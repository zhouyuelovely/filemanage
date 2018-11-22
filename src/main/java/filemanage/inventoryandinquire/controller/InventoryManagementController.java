package filemanage.inventoryandinquire.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import filemanage.inventoryandinquire.pojo.InventoryPlan;
import filemanage.inventoryandinquire.service.InventoryManagementService;
import filemanage.inventoryandinquire.vo.InventoryConditionVo;
import filemanage.inventoryandinquire.vo.InventoryPlanQueryVo;
import filemanage.inventoryandinquire.vo.InventoryPlanningVo;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;
import filemanage.utils.papersave.CustomFileUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/inventoryManagement")
public class InventoryManagementController {
	private Logger log = LoggerFactory.getLogger(InventoryManagementController.class);
	@Autowired
	private InventoryManagementService inventoryManagementService;

	@Autowired
	private MessageNotificationService messageNotificationService;

	/**
	 * 跳转盘点计划页面(基础数据渲染)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goToInventoryManagement", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goToInventoryManagement(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = HavingUserInfor.havingUser();
		ModelAndView mView = new ModelAndView();
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());// 消息提示
		mView.addObject("quanzongNameList", inventoryManagementService.queryQuanzongName());// 全宗名称集合
		mView.addObject("boxNumber", inventoryManagementService.countByJoinPlan());// 统计已加入计划的盒数
		mView.addObject("user", user);
		mView.setViewName("/inventoryAndinquire/inventory");
		return mView;
	}

	/**
	 * 渲染已加入计划的数据
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryBoxInfo(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page)
			throws Exception {
		return inventoryManagementService.queryBoxInfo(limit, page);
	}

	/**
	 * 根据全宗名称查询该全宗下的所有年度
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxAnualByQuanzongName", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<InventoryConditionVo> queryBoxAnualByQuanzongName(
			@RequestBody InventoryConditionVo inventoryConditionVo) throws Exception {
		return inventoryManagementService.queryBoxAnualByQuanzongName(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称和年度查询该全宗该年度下的所有档案类型
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryPcNameByQuanzongNameAndBoxAnual", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<InventoryConditionVo> queryPcNameByQuanzongNameAndBoxAnual(
			@RequestBody InventoryConditionVo inventoryConditionVo) throws Exception {
		return inventoryManagementService.queryPcNameByQuanzongNameAndBoxAnual(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称、年度、档案类型查询该全宗该年度该档案类型下的所有保管期限
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryRetentionperiodName", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<InventoryConditionVo> queryRetentionperiodName(
			@RequestBody InventoryConditionVo inventoryConditionVo) throws Exception {
		System.out.println("inventoryConditionVo=" + inventoryConditionVo);
		return inventoryManagementService.queryRetentionperiodName(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称、盒年度、档案类型、保管期限渲染盒信息
	 * 
	 * @param inventoryConditionVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxInfoByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryBoxInfoByCondition(InventoryConditionVo inventoryConditionVo,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws Exception {
		System.out.println("inventoryConditionVo===" + inventoryConditionVo);
		return inventoryManagementService.queryBoxInfoByCondition(inventoryConditionVo, limit, page);
	}

	/**
	 * 盘点加入计划操作
	 * 
	 * @param boxIdList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateJoinPlanByBoxIdList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Boolean updateJoinPlanByBoxIdList(@RequestParam("boxIdList") List<String> boxIdList)
			throws Exception {
		return inventoryManagementService.updateJoinPlanByBoxIdList(boxIdList);
	}

	/**
	 * 提交计划
	 * 
	 * @param inventoryPlan
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "submitInventoryPlan", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Boolean submitInventoryPlan(@RequestBody InventoryPlan inventoryPlan) throws Exception {
		return inventoryManagementService.submitInventoryPlan(inventoryPlan);
	}

	/**
	 * 删除已加入的盘点计划记录
	 * 
	 * @param boxId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateJoinPlanByBoxId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Boolean updateJoinPlanByBoxId(@RequestParam("boxId") String boxId) throws Exception {
		return inventoryManagementService.updateJoinPlanByBoxId(boxId);
	}

	/**
	 * 跳转盘点计划列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goToInventoryPlansList", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goToInventoryPlansList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mView = new ModelAndView();
		User user = HavingUserInfor.havingUser();
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());// 消息提示
		mView.addObject("planPerson", inventoryManagementService.queryPlanPerson());// 盘点人名称集合
		// mView.addObject("planStatus",inventoryManagementService.queryPlanStatus());//盘点状态集合
		mView.addObject("user", user);
		mView.setViewName("/inventoryAndinquire/plan");
		return mView;
	}

	/**
	 * 查询盘点计划表所有信息并分页
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryInventoryPlanInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryInventoryPlanInfo(@RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) throws Exception {
		return inventoryManagementService.queryInventoryPlanInfo(limit, page);
	}

	/**
	 * 按条件查询盘点计划表所有信息并分页
	 * 
	 * @param inventoryPlanQueryVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryInventoryPlanInfoByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryInventoryPlanInfoByCondition(InventoryPlanQueryVo inventoryPlanQueryVo,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws Exception {
		return inventoryManagementService.queryInventoryPlanInfoByCondition(inventoryPlanQueryVo, limit, page);
	}

	/**
	 * 根据计划主键查询计划表信息
	 * 
	 * @param planId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryPlanInfoByPlanId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryPlanInfoByPlanId(@RequestParam("planId") String planId) throws Exception {
		return inventoryManagementService.queryPlanInfoByPlanId(planId);
	}

	/**
	 * 根据计划主键查询盒表信息
	 * 
	 * @param planId
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxInfoByPlanId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryBoxInfoByPlanId(@RequestParam("planId") String planId,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page,@RequestParam("zhuangtai") String zhuangtai) throws Exception {
		return inventoryManagementService.queryBoxInfoByPlanId(planId, limit, page, zhuangtai);
	}

	/**
	 * 根据计划表主键更新盘点状态
	 * 
	 * @param planId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePlanStatusByPlanId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean updatePlanStatusByPlanId(@RequestParam("planId") String planId) throws Exception {
		return inventoryManagementService.updatePlanStatusByPlanId(planId);
	}

	/**
	 * 下载盘点计划
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/downPlan", method = { RequestMethod.GET, RequestMethod.POST })
	public void downlosdPlan(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("planId") String planId) throws Exception {
		List<InventoryPlanningVo> list = inventoryManagementService.queryBoxListByPlanId(planId);
		List<InventoryPlan> datas = inventoryManagementService.queryPlanInfoByPlanIds(planId);
		List<Object> listObj = new ArrayList<>();
		List<Object> listObj2 = new ArrayList<>();
		List<List> listList = new ArrayList<List>();
		for (InventoryPlan InventoryPlan : datas) {
			if (InventoryPlan.getPlanMakingPerson() == null) {
				InventoryPlan.setPlanMakingPerson(" ");
				listObj2.add(InventoryPlan.getPlanMakingPerson());
			} else {
				listObj2.add(InventoryPlan.getPlanMakingPerson());
			}
			if (InventoryPlan.getPlanPerson() == null) {
				InventoryPlan.setPlanPerson(" ");
				listObj2.add(InventoryPlan.getPlanPerson());
			} else {
				listObj2.add(InventoryPlan.getPlanPerson());
			}
			if (InventoryPlan.getPlanMakingDate() == null) {
				InventoryPlan.setPlanMakingDate(" ");
				listObj2.add(InventoryPlan.getPlanMakingDate());
			} else {
				listObj2.add(InventoryPlan.getPlanMakingDate());
			}
			if (InventoryPlan.getPlanStartdate() == null) {
				InventoryPlan.setPlanStartdate(" ");
				listObj2.add(InventoryPlan.getPlanStartdate());
			} else {
				listObj2.add(InventoryPlan.getPlanStartdate());
			}
			if (InventoryPlan.getPlanEnddate() == null) {
				InventoryPlan.setPlanEnddate(" ");
				listObj2.add(InventoryPlan.getPlanEnddate());
			} else {
				listObj2.add(InventoryPlan.getPlanEnddate());
			}
			if (InventoryPlan.getPlanBoxNumber() == null) {
				InventoryPlan.setPlanBoxNumber(0);
				listObj2.add(InventoryPlan.getPlanBoxNumber());
			} else {
				listObj2.add(InventoryPlan.getPlanBoxNumber());
			}

		}
		for (InventoryPlanningVo inventoryPlanningVo : list) {
			if (inventoryPlanningVo.getJoinPlan() == null) {
				inventoryPlanningVo.setJoinPlan(" ");
				listObj.add(inventoryPlanningVo.getJoinPlan());
			} else {
				listObj.add(inventoryPlanningVo.getJoinPlan());
			}
			if (inventoryPlanningVo.getBoxSericalNumber() == null) {
				inventoryPlanningVo.setBoxSericalNumber(" ");
				listObj.add(inventoryPlanningVo.getBoxSericalNumber());
			} else {
				listObj.add(inventoryPlanningVo.getBoxSericalNumber());
			}
			if (inventoryPlanningVo.getPcName() == null) {
				inventoryPlanningVo.setPcName(" ");
				listObj.add(inventoryPlanningVo.getPcName());
			} else {
				listObj.add(inventoryPlanningVo.getPcName());
			}
			if (inventoryPlanningVo.getBoxStartNumber() == null) {
				listObj.add(" ");
			} else {
				listObj.add(inventoryPlanningVo.getBoxStartNumber());
			}
			if (inventoryPlanningVo.getBoxEndNumber() == null) {
				listObj.add(" ");
			} else {
				listObj.add(inventoryPlanningVo.getBoxEndNumber());
			}
			if (inventoryPlanningVo.getStorageRacknumber() == null) {
				listObj.add(" ");
			} else {
				listObj.add(inventoryPlanningVo.getStorageRacknumber());
			}
		}
		listList.add(listObj);
		listList.add(listObj2);
		String filename = UUID.randomUUID().toString().replaceAll("\\-", "") + ".xlsx";
		// 生成模版
		produce(request, filename, listList);
		// 获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
		String fileName = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		System.out.println("!!!!:" + fileName);
		CustomFileUtil.downloadFile(new File(fileName), response, true);
	}

	public void produce(HttpServletRequest request, String filename, List<List> list) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		String fileName = "盘点计划";
		String[] userOutfit = { "制作人", "盘点人", "计划制作日期", "计划实施日期", "计划完成日期", "盘点盒数", "实际实施时间", "实际完成日期", "盒编号", "档案类型",
				"起件号", "止件号", "位置", "盘点结果" };

		ExportExcel.createExcel(path, fileName, userOutfit, list);
	}

	/*
	 * public static void main(String[] args) { List<String> obj = new
	 * ArrayList<>(); List<String> obj2 = new ArrayList<>(); List<List> lists = new
	 * ArrayList<>(); obj.add("1"); obj.add("2"); obj2.add("5"); obj2.add("6");
	 * lists.add(obj); lists.add(obj2); List<List> strlist = new ArrayList<>();
	 * List<List> strlist2 = new ArrayList<>(); strlist.add(lists.get(0));
	 * strlist2.add(lists.get(1)); for (int i = 0; i < strlist2.size(); i++) {
	 * System.out.println(strlist2.get(i)); } String[] useroutfits =
	 * {"制作人","盘点人","计划制作日期","计划实施日期","计划完成日期","盘点盒数","实际实施时间","实际完成日期","盒编号",
	 * "档案类型", "起件号", "止件号", "位置","盘点结果"}; String[] userOutfit = { "盒编号", "档案类型",
	 * "起件号", "止件号", "位置","盘点结果" }; String[] strNew = new String[14]; String[]
	 * outfitNew1 = new String[14]; String[] outfitNew2 = new String[14]; for (int i
	 * = 0; i < useroutfits.length; i++) { if(useroutfits.length == 14) { if(i <8) {
	 * strNew[i] = useroutfits[i]; outfitNew1 = strNew;
	 * System.out.println("+++++++"+outfitNew1[i]); }else { strNew[i] =
	 * useroutfits[i]; outfitNew2 = strNew;
	 * System.out.println("+++++++"+outfitNew2[i]); } }else {
	 * System.out.println("其他功能打印"); } } }
	 */
	/**
	 * 上传盘点结果
	 * 
	 * @param file
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody JSONObject fileUpload(@RequestParam("file") MultipartFile file, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, @RequestParam("planId") String planId)
			throws Exception {
		JSONObject resObj = new JSONObject();
		String planExcelPath = request.getSession().getServletContext().getRealPath("/planExcel");
		String fileName = file.getOriginalFilename(); // 获取文件名
		String filePath = "";

		if (file != null) {
			File dir = new File(planExcelPath, fileName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			try {
				file.transferTo(dir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			filePath = planExcelPath + "\\" + fileName;
			// 更新盘点状态为已盘点
			Boolean boolean1 = inventoryManagementService.updatePlanStatusByPlanIdThree(planId, filePath);
			if (boolean1) {
				resObj.put("msg", "ok");
				log.info("更新盘点状态为已盘点成功!");
				downloadPanDian(planId, filePath);
				if (inventoryManagementService.queryPDJG(planId) == null
						|| inventoryManagementService.queryPDJG(planId).equals("")) {
					resObj.put("msg", "输入的盘点结果必须是数字类型");
				}
			} else {
				log.error("更新盘点状态为已盘点失败!");
			}
		} else {
			resObj.put("msg", "failure");
		}
		return resObj;
	}

	public void downloadPanDian(String planId, String filePath) throws Exception {
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String, String>> list = null;
		String cellData = null;
		String columns[] = { "制作人", "盘点人", "计划制作日期", "计划实施日期", "计划完成日期", "盘点盒数", "实际实施时间", "实际完成日期" };

		wb = readExcel(filePath);
		if (wb != null) {
			// 用来存放表中数据
			list = new ArrayList<Map<String, String>>();
			// 获取第一个sheet
			sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			// 获取第一行
			row = sheet.getRow(2);
			// 获取最大列数
			int colnum = row.getPhysicalNumberOfCells();
			for (int i = 1; i < rownum; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i + 2);
				if (row != null) {
					for (int j = 0; j < colnum; j++) {
						cellData = (String) getCellFormatValue(row.getCell(j));
						map.put(columns[j], cellData);
					}
				} else {
					break;
				}
				list.add(map);
			}
		}

		// for(int i=2;i<list.size();i++) {
		//
		// mapo.put("juider", list.get(i).get(columns[1]));//获取盒子编号
		// mapo.put("boxbianhao", list.get(i).get(columns[6]));//获取盘点状态
		// inventoryManagementService.UpdataMapper(mapo);//这是修改盒子状态
		// }

		String[] exval = null;
		String val = null;
		// 遍历解析出来的list
		for (Map<String, String> map : list) {
			for (Entry<String, String> entry : map.entrySet()) {
				val += entry.getValue() + ",";
			}

		}

		/*
		 * Map<String, String> mapo=new HashMap<String, String>();
		 * mapo.put("juider",val);
		 */
		// inventoryManagementService.UpdataMapper(mapo);//这是修改盒子状态

		InventoryPlan iplan = new InventoryPlan();

		exval = val.split(",");
		Integer sum = 14;
		Double xsun = 0.0;
		String msg;
		for (int i = 0; i < exval.length; i++) {
			//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!这是分割后的数据" + exval[i]);
			// 将转化的excel时间存储到对象里
			iplan.setSjsstime(excelDateZH(exval[6])); // 获取第七个和第八个
			iplan.setSjwctime(excelDateZH(exval[7]));
			sum = 1 + sum;// 比较总数据量的
			sum = 7 + sum;//

			if (sum > exval.length) {
				iplan.setPdjg(xsun.toString());
				iplan.setPlanId(planId);
				if (inventoryManagementService.updateDownload(iplan) > 0) {
					msg = "{msg:解析成功}";
				} else {
					msg = "{msg:解析失败}";
				}
				return;
			} else {
				if (typeIf(exval[sum]) == true) {// 判断是不是数字类型
					//xsun += Double.parseDouble(exval[sum]);
					
					if (typeIf(exval[sum]) == true) {// 是就拿来计算
						Map<String, String> mapo= new HashMap<String, String>();
						xsun += Double.parseDouble(exval[sum]);
						//xsun = Double.parseDouble(exval[sum]);//路修改
//						String xs ="";
//						if(xsun<=1.0){
//							 xs ="未盘点";
//						}else {
//							 xs ="已盘点";
//						}
						
						mapo.put("je", exval[sum - 5]);
						mapo.put("juider", exval[sum]);
						inventoryManagementService.UpdataMapper(mapo);
					} else {
						msg = "{msg:输入的盘点结果必须是数字类型}";
						inventoryManagementService.updatePlanStatusByPlanId(planId);
						return;
					}
				}
			}
		}
	}

	// excel时间格式转换
	public String excelDateZH(String exceldate) {
		Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(Double.valueOf(exceldate));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date));
		return format.format(date);
	}

	// 判断是否为double类型的方法
	public boolean typeIf(String value) {
		boolean bCheckResult = true;
		try {
			Double dCheckValue = Double.parseDouble(value);
			if (dCheckValue instanceof Double == false) {
				bCheckResult = false;
				System.out.println(bCheckResult);
			} else {
				bCheckResult = true;
				System.out.println(bCheckResult);
			}
		} catch (NumberFormatException e) {
			bCheckResult = false;
		}
		return bCheckResult;
	}

	// 读取excel
	public static Workbook readExcel(String filePath) {
		Workbook wb = null;
		if (filePath == null) {
			return null;
		}
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if (".xls".equals(extString)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				return wb = new XSSFWorkbook(is);
			} else {
				return wb = null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 判断cell类型
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				// 判断cell是否为日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					// 转换为日期格式YYYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 数字
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}

}
