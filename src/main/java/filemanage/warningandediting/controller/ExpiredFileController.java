package filemanage.warningandediting.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.danganmanage.controller.DanganmanageController;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;
import filemanage.warningandediting.pojo.ExpiredFile;
import filemanage.warningandediting.service.ExpiredFileService;

@Controller
@RequestMapping("expiredFile")
public class ExpiredFileController {
	private User user;
	private Logger logger = Logger.getLogger(DanganmanageController.class);

	@Autowired
	private ExpiredFileService efs;
	@Autowired
	private MessageNotificationService messageNotificationService;

	// 去重
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList(); // 创建新集合
		Iterator it = list.iterator(); // 根据传入的集合(旧集合)获取迭代器
		while (it.hasNext()) { // 遍历老集合
			Object obj = it.next(); // 记录每一个元素
			if (!newList.contains(obj)) { // 如果新集合中不包含旧集合中的元素
				newList.add(obj); // 将元素添加
			}
		}
		return newList;
	}

	@RequestMapping("/goDaoQi")
	public ModelAndView goDaoQi() throws Exception {
		logger.info("跳转到到期档案页面");
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<ExpiredFile> list = efs.queryExpiredFile();
		ArrayList dayList = new ArrayList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				String baoGuan = list.get(i).getSaveDays();
				if (baoGuan.equals("永久")) {
					System.out.println("无需预警");
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// 当天的时间
					Date date1 = new Date();
					// 计算到期日期
					String fileCreateDate = list.get(i).getFileCreateDate();
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(fileCreateDate));
					String regEx = "[^0-9]";
					Pattern p = Pattern.compile(regEx);
					Matcher m = p.matcher(baoGuan);
					System.out.println(m.replaceAll("").trim());
					c.add(Calendar.DATE, Integer.parseInt(m.replaceAll("").trim()) * 365);
					// 获得到期日期
					String endDate = sdf.format(c.getTime());
					System.out.println("endDate++++" + endDate);
					Date date2 = sdf.parse(endDate);
					// 计算剩余天数
					long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
					System.out.println("days3++++" + days3);
					// 30天内开始预警
					if (days3 <= 30) {
						if (days3 <= 0) {
							// 获得预警天数
							String warningDays = 0 + "天";
							dayList.add(warningDays);
						} else {
							// 获得预警天数
							String warningDays = days3 + "天";
							dayList.add(warningDays);
						}
					}
				}
				ArrayList newList = getSingle(dayList);
				mv.addObject("qzNameList", efs.queryAllQzName());
				mv.addObject("warningDayList", newList);
			}
		}
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("total", efs.countExpiredFile());
		mv.setViewName("/warningandediting/warning");
		return mv;
	}

	/**
	 * 查询所有到期档案
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectAllExpiredFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryAllFile(int page, int limit) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<ExpiredFile> list = efs.queryAllExpiredFile(before, after);
		List<ExpiredFile> newList = new ArrayList<ExpiredFile>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				String baoGuan = list.get(i).getSaveDays();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 当天的时间
				Date date1 = new Date();
				// 计算到期日期
				String fileCreateDate = list.get(i).getFileCreateDate();
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(fileCreateDate));
				String regEx = "[^0-9]";
				Pattern p = Pattern.compile(regEx);
				Matcher m = p.matcher(baoGuan);
				System.out.println(m.replaceAll("").trim());
				c.add(Calendar.DATE, Integer.parseInt(m.replaceAll("").trim()) * 365);
				// 获得到期日期
				String endDate = sdf.format(c.getTime());
				System.out.println("endDate++++" + endDate);
				Date date2 = sdf.parse(endDate);
				// 计算剩余天数
				long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
				System.out.println("days3++++" + days3);

				// 30天内开始预警
				if (days3 <= 30) {
					if (days3 <= 0) {
						// 获得预警天数
						String warningDays = 0 + "天";
						newList.add(new ExpiredFile(list.get(i).getQzName(), list.get(i).getArchivefileId(),
								list.get(i).getFileNumber(), list.get(i).getBoxNumber(), list.get(i).getRackNumber(),
								list.get(i).getFileCreateDate(), endDate, warningDays,list.get(i).getSaveDays()));
					} else {
						// 获得预警天数
						String warningDays = days3 + "天";
						newList.add(new ExpiredFile(list.get(i).getQzName(), list.get(i).getArchivefileId(),
								list.get(i).getFileNumber(), list.get(i).getBoxNumber(), list.get(i).getRackNumber(),
								list.get(i).getFileCreateDate(), endDate, warningDays,list.get(i).getSaveDays()));
					}
				}
			}
		}
		int count = efs.countExpiredFile();
		return Layui.data(count, newList);
	}

	/**
	 * 根据全宗名查看文件
	 * 
	 * @param page
	 * @param limit
	 * @param qzName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectFileByQzName", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryFileByName(int page, int limit, String qzName) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<ExpiredFile> list = efs.queryFileByQzName(before, after, qzName);
		List<ExpiredFile> newList = new ArrayList<ExpiredFile>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				String baoGuan = list.get(i).getSaveDays();
				if (baoGuan.equals("永久")) {
					System.out.println("无需预警");
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// 当天的时间
					Date date1 = new Date();
					// 计算到期日期
					String fileCreateDate = list.get(i).getFileCreateDate();
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(fileCreateDate));
					String regEx = "[^0-9]";
					Pattern p = Pattern.compile(regEx);
					Matcher m = p.matcher(baoGuan);
					System.out.println(m.replaceAll("").trim());
					c.add(Calendar.DATE, Integer.parseInt(m.replaceAll("").trim()) * 365);
					// 获得到期日期
					String endDate = sdf.format(c.getTime());
					System.out.println("endDate++++" + endDate);
					Date date2 = sdf.parse(endDate);
					// 计算剩余天数
					long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
					System.out.println("days3++++" + days3);

					// 30天内开始预警
					if (days3 <= 30) {
						if (days3 <= 0) {
							// 获得预警天数
							String warningDays = 0 + "天";
							newList.add(new ExpiredFile(list.get(i).getQzName(), list.get(i).getArchivefileId(),
									list.get(i).getFileNumber(), list.get(i).getBoxNumber(),
									list.get(i).getRackNumber(), list.get(i).getFileCreateDate(), endDate,
									warningDays,list.get(i).getSaveDays()));
						} else {
							// 获得预警天数
							String warningDays = days3 + "天";
							newList.add(new ExpiredFile(list.get(i).getQzName(), list.get(i).getArchivefileId(),
									list.get(i).getFileNumber(), list.get(i).getBoxNumber(),
									list.get(i).getRackNumber(), list.get(i).getFileCreateDate(), endDate,
									warningDays,list.get(i).getSaveDays()));
						}
					}
				}
			}
		}
		int count = efs.countFileByQzName(qzName);
		return Layui.data(count, newList);
	}

	/**
	 * 根据预警天数查询
	 * 
	 * @param page
	 * @param limit
	 * @param surplusDays
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectFileBySurplusDays", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryFileBySurplusDays(int page, int limit, String surplusDays) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<ExpiredFile> list = efs.queryAllExpiredFile(before, after);
		List<ExpiredFile> newList = new ArrayList<ExpiredFile>();
		if (list != null && surplusDays != null) {
			for (int i = 0; i < list.size(); i++) {
				String baoGuan = list.get(i).getSaveDays();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 当天的时间
				Date date1 = new Date();
				// 计算到期日期
				String fileCreateDate = list.get(i).getFileCreateDate();
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(fileCreateDate));
				String regEx = "[^0-9]";
				Pattern p = Pattern.compile(regEx);
				Matcher m = p.matcher(baoGuan);
				System.out.println(m.replaceAll("").trim());
				c.add(Calendar.DATE, Integer.parseInt(m.replaceAll("").trim()) * 365);
				// 获得到期日期
				String endDate = sdf.format(c.getTime());
				System.out.println("endDate++++" + endDate);
				Date date2 = sdf.parse(endDate);
				// 计算剩余天数
				long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
				System.out.println("days3++++" + days3);
				// 获得预警天数
				String warningDays = days3 + "天";
				if (warningDays.equals(surplusDays)) {
					newList.add(new ExpiredFile(list.get(i).getQzName(), list.get(i).getArchivefileId(),
							list.get(i).getFileNumber(), list.get(i).getBoxNumber(), list.get(i).getRackNumber(),
							list.get(i).getFileCreateDate(), endDate, warningDays,list.get(i).getSaveDays()));
				}
			}
		}
		int count = efs.countExpiredFile();
		return Layui.data(count, newList);
	}
}
