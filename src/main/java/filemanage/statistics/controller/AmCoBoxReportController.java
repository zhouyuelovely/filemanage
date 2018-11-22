package filemanage.statistics.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.danganmanage.controller.DanganmanageController;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.statistics.pojo.AmCoBoxReport;
import filemanage.statistics.service.AmCoBoxReportService;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.ExcelExport;
import filemanage.utils.layui.Layui;

@Controller
@RequestMapping("report")
public class AmCoBoxReportController {
	private User user;
	private Logger logger = Logger.getLogger(DanganmanageController.class);
	@Resource
	private AmCoBoxReportService acbrService;
	@Resource
	private MessageNotificationService messageNotificationService;

	/**
	 * 以盒查询 查询一个全宗下对应的数据
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/queryByBox")
	@ResponseBody
	public ModelAndView queryBoxs(HttpServletRequest request, HttpServletResponse response, String anual) {
		ModelAndView mv = new ModelAndView();
		logger.info("跳转到档案数量盒统计页面");
		user = HavingUserInfor.havingUser();
		Map<String, List<AmCoBoxReport>> maps = acbrService.queryByBox(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> qzlist2 = acbrService.queryQuanzongname(anual); // 查询所有的全宗名
		List<AmCoBoxReport> pcNamelist = acbrService.queryPcname(anual); // 查询所有的档案类型
		List<AmCoBoxReport> anuallist = acbrService.queryAnual(); // 查询所有年份
		mv.addObject("user", user);
		mv.addObject("boxs", maps);
		mv.addObject("quanzongname", qzlist2);
		mv.addObject("pcname", pcNamelist);
		mv.addObject("anualList", anuallist);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/statistics/Statistics_report_bar");
		return mv;
	}

	@RequestMapping(value = "/queryByBox1")
	@ResponseBody
	public Map<String, Object> queryBoxs1(HttpServletRequest request, HttpServletResponse response, String anual) {
		logger.info("跳转到档案数量盒统计页面");
		user = HavingUserInfor.havingUser();
		Map<String, List<AmCoBoxReport>> maps = acbrService.queryByBox(anual);// 查询一个全宗下对应的数据信息
		Map<String, Object> map = new HashMap<>();
		List<AmCoBoxReport> keyList = new ArrayList<>();
		List<AmCoBoxReport> valueList = new ArrayList<>();
		AmCoBoxReport amcoboxreport = new AmCoBoxReport();
		for (String key : maps.keySet()) {
			valueList = maps.get(key);
			amcoboxreport.setQuanzongname(key);
			keyList.add(amcoboxreport);
		}
		// 全宗名称
		String[] keyArray = new String[(keyList.size())];
		for (int i = 0; i < keyList.size(); i++) {
			keyArray[i] = keyList.get(i).getQuanzongname();
		}
		// 档案名称
		String[] valueArray = new String[(valueList.size())];
		for (int i = 0; i < valueList.size(); i++) {
			valueArray[i] = valueList.get(i).getPcname();
		}
		// 数量
		Integer[] valueNum = new Integer[(valueList.size())];
		for (int i = 0; i < valueList.size(); i++) {
			valueNum[i] = valueList.get(i).getCountnum();
		}
		map.put("keyArray", keyArray);
		map.put("valueArray", valueArray);
		map.put("valueNum", valueNum);
		return map;
	}

	@RequestMapping(value = "/queryByBox22")
	@ResponseBody
	public Map<String, Object> queryBoxs22(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		user = HavingUserInfor.havingUser();
		String anual = request.getParameter("anual");
		// Map<String, List<AmCoBoxReport>> maps =
		// acbrService.queryByBox(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> qzlist2 = acbrService.queryQuanzongname(anual); // 查询所有的全宗名
		List<AmCoBoxReport> pcNamelist = acbrService.queryPcname(anual); // 查询所有的档案类型
		System.out.println("QQQQ"+qzlist2);
		System.out.println("QQQQ"+pcNamelist);
		// 全宗名称
		String[] keyArray = new String[(qzlist2.size())];
		for (int i = 0; i < qzlist2.size(); i++) {
			keyArray[i] = qzlist2.get(i).getQuanzongname();
		}
		// 档案名称
		String[] valueArray = new String[(pcNamelist.size())];
		for (int i = 0; i < pcNamelist.size(); i++) {
			valueArray[i] = pcNamelist.get(i).getPcname();
		}
		// 数量
		List<Object> valueNum = new ArrayList<>();
		String[] countNum = null;

		for (int i = 0; i < pcNamelist.size(); i++) {
			String pcname = pcNamelist.get(i).getPcname();
			countNum = new String[(qzlist2.size())];
			for (int j = 0; j < qzlist2.size(); j++) {
				String quanzongid = qzlist2.get(j).getQuanzongid();
				String countBoxNum = acbrService.queryboxCountnum(anual, pcname, quanzongid);
				countNum[j] = countBoxNum;
			}
			valueNum.add(countNum);
		}
		map.put("keyArray", keyArray);
		map.put("valueArray", valueArray);
		map.put("valueNum", valueNum);
		return map;
	}

	/**
	 * 以盒查询(表格)
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/queryByBoxTable")
	@ResponseBody
	public Layui queryByBoxTables(HttpServletRequest request, HttpServletResponse response, String anual, int page,
			int limit) {
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<AmCoBoxReport> boxTableList = acbrService.queryByBoxTable(anual, before, after);// 查询一个全宗下对应的数据信息
		int countbox = acbrService.queryByBoxTableTotal(anual);
		return Layui.data(countbox, boxTableList);
	}

	/**
	 * 以件查询
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/queryByFile")
	public ModelAndView queryFile(HttpServletRequest request, HttpServletResponse response, String anual) {
		ModelAndView mv = new ModelAndView();
		logger.info("跳转到档案数量件统计页面");
		user = HavingUserInfor.havingUser();
		Map<String, List<AmCoBoxReport>> maps = acbrService.queryByFile(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> qzlist = acbrService.queryFileQuanzongname(anual); // 查询所有的全宗名
		List<AmCoBoxReport> pcNamelist = acbrService.queryPcname(anual); // 查询所有的档案类型
		List<AmCoBoxReport> anuallist = acbrService.queryFileAnual(); // 查询所有年份
		mv.addObject("user", user);
		mv.addObject("files", maps);
		mv.addObject("quanzongname", qzlist);
		mv.addObject("pcname", pcNamelist);
		mv.addObject("anualList", anuallist);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/statistics/Statistics_report_bart");
		return mv;
	}

	@RequestMapping(value = "/queryByFile1")
	@ResponseBody
	public Map<String, Object> queryByFile1(HttpServletRequest request, HttpServletResponse response, String anual) {
		logger.info("跳转到档案数量件统计页面");
		user = HavingUserInfor.havingUser();
		Map<String, List<AmCoBoxReport>> maps = acbrService.queryByFile(anual);// 查询一个全宗下对应的数据信息
		Map<String, Object> map = new HashMap<>();
		List<AmCoBoxReport> keyList = new ArrayList<>();
		List<AmCoBoxReport> valueList = new ArrayList<>();
		AmCoBoxReport amcoboxreport = new AmCoBoxReport();
		for (String key : maps.keySet()) {
			valueList = maps.get(key);
			amcoboxreport.setQuanzongname(key);
			keyList.add(amcoboxreport);
		}
		// 全宗名称
		String[] keyArray = new String[(keyList.size())];
		for (int i = 0; i < keyList.size(); i++) {
			keyArray[i] = keyList.get(i).getQuanzongname();
		}
		// 档案名称
		String[] valueArray = new String[(valueList.size())];
		for (int i = 0; i < valueList.size(); i++) {
			valueArray[i] = valueList.get(i).getPcname();
		}
		// 数量
		Integer[] valueNum = new Integer[(valueList.size())];
		for (int i = 0; i < valueList.size(); i++) {
			valueNum[i] = valueList.get(i).getSumnum();
		}
		map.put("keyArray", keyArray);
		map.put("valueArray", valueArray);
		map.put("valueNum", valueNum);

		return map;
	}

	@RequestMapping(value = "/queryByFile22")
	@ResponseBody
	public Map<String, Object> queryByFile22(HttpServletRequest request, HttpServletResponse response, String anual) {
		Map<String, Object> map = new HashMap<>();
		user = HavingUserInfor.havingUser();
		List<AmCoBoxReport> qzlist2 = acbrService.queryFileQuanzongname(anual); // 查询所有的全宗名
		List<AmCoBoxReport> pcNamelist = acbrService.queryFilePcname(anual); // 查询所有的档案类型

		// 全宗名称
		String[] keyArray = new String[(qzlist2.size())];
		for (int i = 0; i < qzlist2.size(); i++) {
			keyArray[i] = qzlist2.get(i).getQuanzongname();
		}
		// 档案名称
		String[] valueArray = new String[(pcNamelist.size())];
		for (int i = 0; i < pcNamelist.size(); i++) {
			valueArray[i] = pcNamelist.get(i).getPcname();
		}

		// 数量
		List<Object> valueNum = new ArrayList<>();
		String[] countNum = null;

		for (int i = 0; i < pcNamelist.size(); i++) {
			String pcname = pcNamelist.get(i).getPcname();
			countNum = new String[(qzlist2.size())];
			for (int j = 0; j < qzlist2.size(); j++) {
				String quanzongid = qzlist2.get(j).getQuanzongid();
				String countFileNum = acbrService.queryfileSumnum(anual, pcname, quanzongid);
				if (countFileNum == null) {
					countFileNum = "0";
				}
				countNum[j] = countFileNum;
			}
			valueNum.add(countNum);
		}
		map.put("keyArray", keyArray);
		map.put("valueArray", valueArray);
		map.put("valueNum", valueNum);
		return map;
	}

	/**
	 * 以件查询(表格)
	 * 
	 * @param request
	 * @param response
	 * @param anual
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/queryByFileTable")
	@ResponseBody
	public Layui queryByFileTables(HttpServletRequest request, HttpServletResponse response, String anual, int page,
			int limit) {
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<AmCoBoxReport> fileTable = acbrService.queryByFileTable(anual, before, after);// 查询一个全宗下对应的数据信息
		int countbox = acbrService.queryByFileTableTotal(anual);
		return Layui.data(countbox, fileTable);
	}

	/**
	 * 查询借阅占比
	 */
	@RequestMapping(value = "/queryBorrow")
	public ModelAndView queryBorrow(HttpServletRequest request, HttpServletResponse response, String anual) {
		ModelAndView mv = new ModelAndView();
		logger.info("跳转到档案借阅统计页面");
		user = HavingUserInfor.havingUser();
		List<AmCoBoxReport> list = acbrService.queryBorrowing(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> pcNamelist = acbrService.queryBorrowingType(anual); // 查询所有的档案类型
		List<AmCoBoxReport> anuallist = acbrService.queryBorrowingAnual(); // 查询所有年份
		int borrowCount = acbrService.queryBorrowingCount(anual); // 查询借阅总数量
		mv.addObject("user", user);
		mv.addObject("borrowList", list);
		mv.addObject("pcname", pcNamelist);
		mv.addObject("anualList", anuallist);
		mv.addObject("borrowCount", borrowCount);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/statistics/Statistics_report_pie");
		return mv;
	}

	/**
	 * 查询借阅占比1
	 */
	@RequestMapping(value = "/queryBorrow1")
	@ResponseBody
	public Map<String, Object> queryBorrow1(HttpServletRequest request, HttpServletResponse response, String anual) {
		logger.info("跳转到档案借阅统计页面");
		user = HavingUserInfor.havingUser();
		List<AmCoBoxReport> list = acbrService.queryBorrowing(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> pcNamelist = acbrService.queryBorrowingType(anual); // 查询所有的档案类型
		List<AmCoBoxReport> anuallist = acbrService.queryBorrowingAnual(); // 查询所有年份
		int borrowCount = acbrService.queryBorrowingCount(anual); // 查询借阅总数量

		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("borrowList", list);
		map.put("pcname", pcNamelist);
		map.put("anualList", anuallist);
		map.put("borrowCount", borrowCount);
		return map;
	}

	/**
	 * 查询借阅占比(表格)
	 */
	@RequestMapping(value = "/queryBorrowTable")
	@ResponseBody
	public Layui queryBorrowTable(HttpServletRequest request, HttpServletResponse response, String anual, int page,
			int limit) {
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<AmCoBoxReport> list = acbrService.queryBorrowingTable(anual, before, after);// 查询一个全宗下对应的数据信息
		int countbox = acbrService.queryBorrowingTableTotal(anual);//
		return Layui.data(countbox, list);
	}

	/**
	 * 查询驳回情况质量比
	 */
	@RequestMapping(value = "/queryRejects")
	public ModelAndView queryRejects(HttpServletRequest request, HttpServletResponse response, String anual) {
		ModelAndView mv = new ModelAndView();
		logger.info("跳转到档案整理质量统计页面");
		user = HavingUserInfor.havingUser();
		List<AmCoBoxReport> list = acbrService.queryReject(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> anuallist = acbrService.queryRejectAnual(); // 查询所有年份
		int rejectCount = acbrService.queryRejectTotal(anual); // 查询驳回总数量
		List<AmCoBoxReport> qzlist = acbrService.queryRejectQuanzong(anual); // 查询所有全宗
		mv.addObject("user", user);
		mv.addObject("quanzongname", qzlist);
		mv.addObject("borrowList", list);
		mv.addObject("anualList", anuallist);
		mv.addObject("rejectCount", rejectCount);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/statistics/Statistics_report_line");
		return mv;
	}

	/**
	 * 查询驳回情况质量比1
	 */
	@RequestMapping(value = "/queryRejects1")
	@ResponseBody
	public Map<String, Object> queryRejects1(HttpServletRequest request, HttpServletResponse response, String anual) {
		logger.info("跳转到档案整理质量统计页面");
		user = HavingUserInfor.havingUser();
		List<AmCoBoxReport> list = acbrService.queryReject(anual);// 查询一个全宗下对应的数据信息
		List<AmCoBoxReport> anuallist = acbrService.queryRejectAnual(); // 查询所有年份
		Integer rejectCount = acbrService.queryRejectTotal(anual); // 查询驳回总数量
		List<AmCoBoxReport> qzlist = acbrService.queryRejectQuanzong(anual); // 查询所有全宗

		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("quanzongname", qzlist);
		map.put("borrowList", list);
		map.put("anualList", anuallist);
		map.put("rejectCount", rejectCount);
		return map;
	}

	/**
	 * 查询驳回情况质量比(表格)
	 */
	@RequestMapping(value = "/queryRejectsTable")
	@ResponseBody
	public Layui queryRejectsTable(HttpServletRequest request, HttpServletResponse response, String anual, int page,
			int limit) {
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<AmCoBoxReport> list = acbrService.queryRejectTable(anual, before, after);// 查询一个全宗下对应的数据信息
		Integer countbox = acbrService.queryRejectTableTotal(anual); // 查询驳回总数量
		return Layui.data(countbox, list);
	}

	/**
	 * 下载excel 以盒查询(表格)
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/boxExportExcel", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void boxExportExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("anual") String anual) throws Exception {
		// 定义表的标题
		String title = anual + "档案数量统计";
		// 定义表的列名
		String[] rowsName = new String[] { "序号", "全宗名称", "档案类型", "档案数量-盒" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		int before = -1;
		int after = -1;
		List<AmCoBoxReport> boxTableList = acbrService.queryByBoxTable(anual, before, after);// 查询一个全宗下对应的数据信息
		for (int i = 0; i < boxTableList.size(); i++) {
			AmCoBoxReport box = boxTableList.get(i);
			objs = new Object[rowsName.length];
			objs[1] = box.getQuanzongname();
			objs[2] = box.getPcname();
			objs[3] = box.getCountnum().toString();
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		String path = "D:/" + anual + "档案数量统计.xls";
		String fileName = anual + "档案数量统计.xls";
		ExcelExport ex = new ExcelExport(title, rowsName, dataList);
		// 输出Excel文件
		try {
			FileOutputStream output = new FileOutputStream(path);
			ex.export(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream inputStream = new FileInputStream(path);
		File file = new File(path);
		String userAgent = request.getHeader("USER-AGENT"); // 获取浏览器信息
		System.err.println(userAgent);
		String finalFileName = null;
		if (StringUtils.contains(userAgent, "Edge")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "Chrome")) {// google/firefox
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		} else {
			finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
		}

		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(finalFileName.getBytes("utf-8"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inputStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();
	}

	/**
	 * 下载excel 以件查询(表格)
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/fileExportExcel", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void fileExportExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("anual") String anual) throws Exception {
		// 定义表的标题
		String title = anual + "档案数量统计";
		// 定义表的列名
		String[] rowsName = new String[] { "序号", "全宗名称", "档案类型", "档案数量-件" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		int before = -1;
		int after = -1;
		List<AmCoBoxReport> boxTableList = acbrService.queryByFileTable(anual, before, after);// 查询一个全宗下对应的数据信息
		for (int i = 0; i < boxTableList.size(); i++) {
			AmCoBoxReport box = boxTableList.get(i);
			objs = new Object[rowsName.length];
			objs[1] = box.getQuanzongname();
			objs[2] = box.getPcname();
			objs[3] = box.getSumnum().toString();
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		String path = "D:/" + anual + "档案数量统计.xls";
		String fileName = anual + "档案数量统计.xls";
		ExcelExport ex = new ExcelExport(title, rowsName, dataList);
		// 输出Excel文件
		try {
			FileOutputStream output = new FileOutputStream(path);
			ex.export(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream inputStream = new FileInputStream(path);
		File file = new File(path);
		String userAgent = request.getHeader("USER-AGENT"); // 获取浏览器信息
		System.err.println(userAgent);
		String finalFileName = null;
		if (StringUtils.contains(userAgent, "Edge")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "Chrome")) {// google/firefox
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		} else {
			finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
		}

		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(finalFileName.getBytes("utf-8"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inputStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();
	}

	/**
	 * 下载excel 档案借阅数量占比(表格)
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/borrowExportExcel", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void borrowExportExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("anual") String anual) throws Exception {
		// 定义表的标题
		String title = anual + "档案借阅数量统计";
		// 定义表的列名
		String[] rowsName = new String[] { "序号", "档案类型", "借阅数量-件", "档案数量占比-%" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		int before = -1;
		int after = -1;
		List<AmCoBoxReport> boxTableList = acbrService.queryBorrowingTable(anual, before, after);// 查询一个全宗下对应的数据信息
		for (int i = 0; i < boxTableList.size(); i++) {
			AmCoBoxReport box = boxTableList.get(i);
			objs = new Object[rowsName.length];
			objs[1] = box.getPcname();
			objs[2] = box.getBorrowingnum().toString();
			objs[3] = box.getBorrowProportion();
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		String path = "D:/" + anual + "档案借阅数量统计.xls";
		String fileName = anual + "档案借阅数量统计.xls";
		ExcelExport ex = new ExcelExport(title, rowsName, dataList);
		// 输出Excel文件
		try {
			FileOutputStream output = new FileOutputStream(path);
			ex.export(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream inputStream = new FileInputStream(path);
		File file = new File(path);
		String userAgent = request.getHeader("USER-AGENT"); // 获取浏览器信息
		System.err.println(userAgent);
		String finalFileName = null;
		if (StringUtils.contains(userAgent, "Edge")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "Chrome")) {// google/firefox
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		} else {
			finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
		}

		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(finalFileName.getBytes("utf-8"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inputStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();
	}

	/**
	 * 下载excel 档案整理质量统计(表格)
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/rejectsExportExcel", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void rejectsExportExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("anual") String anual) throws Exception {
		// 定义表的标题
		String title = anual + "档案质量比统计";
		// 定义表的列名
		String[] rowsName = new String[] { "序号", "档案类型", "驳回数量-件", "档案数量占比-%" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		int before = -1;
		int after = -1;
		List<AmCoBoxReport> boxTableList = acbrService.queryRejectTable(anual, before, after);// 查询一个全宗下对应的数据信息
		for (int i = 0; i < boxTableList.size(); i++) {
			AmCoBoxReport box = boxTableList.get(i);
			objs = new Object[rowsName.length];
			objs[1] = box.getPcname();
			objs[2] = box.getRejectnum().toString();
			objs[3] = box.getRejectProprotion();
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		String path = "D:/" + anual + "档案质量比统计.xls";
		String fileName = anual + "档案质量比统计.xls";
		ExcelExport ex = new ExcelExport(title, rowsName, dataList);
		// 输出Excel文件
		try {
			FileOutputStream output = new FileOutputStream(path);
			ex.export(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream inputStream = new FileInputStream(path);
		File file = new File(path);
		String userAgent = request.getHeader("USER-AGENT"); // 获取浏览器信息
		System.err.println(userAgent);
		String finalFileName = null;
		if (StringUtils.contains(userAgent, "Edge")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		} else if (StringUtils.contains(userAgent, "Chrome")) {// google/firefox
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		} else {
			finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
		}

		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(finalFileName.getBytes("utf-8"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inputStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();
	}
}
