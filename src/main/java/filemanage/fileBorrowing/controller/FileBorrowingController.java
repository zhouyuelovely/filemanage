package filemanage.fileBorrowing.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.vo.ExcelFrom;
import filemanage.fileBorrowing.pojo.BorrowDetails;
import filemanage.fileBorrowing.pojo.BorrowRecords;
import filemanage.fileBorrowing.service.FileBorrowingService;
import filemanage.fileBorrowing.vo.BorrowDataListSourceVoForm;
import filemanage.fileBorrowing.vo.BorrowDataSourceVoForm;
import filemanage.fileBorrowing.vo.DataListSourceVoForm;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;
import net.sf.json.JSONObject;
/**
 * 借阅模块controll（控制层）
 * @author 陈一达
 *
 */
@Controller
@RequestMapping("/FileBorrowingController")
public class FileBorrowingController {
	
	
	@Autowired
	private FileBorrowingService fs;
	private User user;
	 @Autowired
	 private MessageNotificationService messageNotificationService;
	
	/**
	 * 跳转到档案借阅页面
	 * @param request
	 * @param response 
	 * @return
	 */
	@RequestMapping(value = "/modeAndView" ,method= {RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public ModelAndView modeAndView(HttpServletRequest request,HttpServletResponse response) {
		user = HavingUserInfor.havingUser();
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		String quanzongNumber = request.getParameter("quanzongNumber");
		if(quanzongNumber == null || quanzongNumber.equals("")) {
			map.put("quanzongNumber", "");
		}else {
			map.put("quanzongNumber",quanzongNumber);
		}
		//获取年度
		List<BorrowDetails> ndList = fs.queryQuanzongId(map);
		//全宗下拉框数据查询
		List<BorrowDetails> qzList = fs.queryQuanzongName();
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("ndList",ndList);
		mv.addObject("qzList",qzList);
		//用户权限类型（1：只能借阅 2：审核）
		String userType = "1";
		if(userType.equals("1")) {
			mv.setViewName("/fileBorrowing/Archives_library");
		}else if(userType.equals("2")) {
			mv.setViewName("/fileBorrowing/approve");
		}
		return mv;
		
	}
	
	
	
	/**
	 * 跳转到档案借阅页面
	 * @param request
	 * @param response 
	 * @return
	 */
	@RequestMapping(value = "/modeAndView2" ,method= {RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public ModelAndView modeAndView2(HttpServletRequest request,HttpServletResponse response) {
		user = HavingUserInfor.havingUser();
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		String quanzongNumber = request.getParameter("quanzongNumber");
		if(quanzongNumber == null || quanzongNumber.equals("")) {
			map.put("quanzongNumber", "");
		}else {
			map.put("quanzongNumber",quanzongNumber);
		}
		//获取年度
		List<BorrowDetails> ndList = fs.queryQuanzongId(map);
		System.out.println(ndList);
		//全宗下拉框数据查询
		List<BorrowDetails> qzList = fs.queryQuanzongName();
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("ndList",ndList);
		mv.addObject("qzList",qzList);
		//用户权限类型（1：只能借阅 2：审核）
		String userType = "2";
		if(userType.equals("1")) {
			mv.setViewName("/fileBorrowing/Archives_library");
		}else if(userType.equals("2")) {
			mv.setViewName("/fileBorrowing/approve");
		}
		return mv;
		
	}
////////////////////////////////////////////(-------------<借阅功能(头)>-----<START>--------)//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 数据渲染
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/borrowQueryFile",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui borrowQueryFile(HttpServletRequest request,HttpServletResponse response) {
		/*int page = Integer.getInteger(request.getParameter("page"));
		int limit = Integer.getInteger(request.getParameter("limit"));*/
		int page = 7;
		int limit = 1;
		//全宗主键
		String quanzongName =  request.getParameter("quanzongName");
		//年度
		String borrowdetailsAnnual = request.getParameter("borrowdetailsAnnual");
		//关键词
		String borrowdetailsTitle = request.getParameter("borrowdetailsTitle");
		List<BorrowDetails> borrowdetailsList = fs.borrowQueryFile(quanzongName, borrowdetailsAnnual,borrowdetailsTitle,page,limit);
		Integer borrowdetailsCount = fs.borrowQueryFileCount(request,quanzongName, borrowdetailsAnnual,borrowdetailsTitle,page,limit);
		System.out.println(borrowdetailsCount);
		return Layui.data(borrowdetailsCount, borrowdetailsList);
		
	}
	
	/**
	 * 获取年度（进行级联）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/annualList")
	@ResponseBody
	public List<BorrowDetails> annualList(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<>();
		String quanzongNumber = request.getParameter("quanzongNumber");
		if(quanzongNumber == null || quanzongNumber.equals("")) {
			map.put("quanzongNumber", "");
		}else {
			map.put("quanzongNumber",quanzongNumber);
		}
		//获取年度
		List<BorrowDetails> ndList = fs.queryQuanzongId(map);
		return ndList;
	}
	
	/**
	 * 获取前台所选的参数进行layUI.data转换在返回给前台展示（借阅明细的数据展示）
	 * @param request
	 * @param response
	 * @param borrowdatasourcevoform
	 * @return
	 */
	@RequestMapping("/borrowQueryList")
	@ResponseBody
	public List<Layui> borrowQueryList(HttpServletRequest request,HttpServletResponse response,
			@RequestBody  List<BorrowDataSourceVoForm> borrowdatasourcevoform ) {
		List<Layui> layuiList = new ArrayList<>();
		layuiList.add(Layui.data(borrowdatasourcevoform.size(), borrowdatasourcevoform));
		BorrowDetails borrowdetails = new BorrowDetails();
		String userId = HavingUserInfor.havingUser().getUserId();
		String userName = HavingUserInfor.havingUser().getUserName();
		
		//根据userId获取所属部门名称
		borrowdetails.setUserId(userId);
		String organiZationName = fs.queryOrganizationName(borrowdetails).toString();
		System.out.println("用户所属部门:"+organiZationName);
		//数据组装
		List<String> strList = new ArrayList<>();
		strList.add(userName);
		strList.add(organiZationName);
		layuiList.add(Layui.data(strList.size(),strList));
		return layuiList;
		
	}
	/**
	 * 借阅记录查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/borrowRecordsQuery")
	@ResponseBody
	public Layui borrowRecordsQuery(HttpServletRequest request, HttpServletResponse response) {
		//当前用户ID
		String userId = HavingUserInfor.havingUser().getUserId();
		//档案载体
		String borrowRecordsCarrier = request.getParameter("borrowRecordsCarrier");
		//审核转态
		String borrowRecordsStatus = request.getParameter("borrowRecordsStatus");
		System.out.println("测试数据："+borrowRecordsCarrier+"::::"+borrowRecordsStatus);
		return fs.borrowRecordsRendering(request, userId, borrowRecordsCarrier, borrowRecordsStatus);
	}
	/**
	 * 批量添加借阅明细  以及添加借阅记录信息
	 * @param request
	 * @param response
	 * @param borrowdatalistsourcevoform
	 * @return
	 */
	@RequestMapping("/borrowDetailsAndRecordsInsert")
	@ResponseBody
	public JSONObject borrowDetailsAndRecordsInsert(HttpServletRequest request,HttpServletResponse response,
			@RequestBody BorrowDataListSourceVoForm borrowdatalistsourcevoform) {
		System.out.println(borrowdatalistsourcevoform);
		String userId = HavingUserInfor.havingUser().getUserId();
		System.out.println("测试对象："+borrowdatalistsourcevoform);
		JSONObject msgArr = JSONObject.fromObject(fs.borrowRecordDetails(borrowdatalistsourcevoform, userId));
		return msgArr;
	}
	/**
	 * 借阅记录明细查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/borrowRecordsBorrowDetailsSelect")
	@ResponseBody
	public List<Layui> borrowRecordsBorrowDetailsSelect(HttpServletRequest request,HttpServletResponse response){
		String borrowRecordsId = request.getParameter("borrowRecordsId");
		System.out.println("layui数据展示:"+fs.borrowRecordsBorrowDetailsSelect(request,borrowRecordsId));
		return fs.borrowRecordsBorrowDetailsSelect(request,borrowRecordsId);
	}
	/**
	 * 归还功能
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ReturnFunction")
	@ResponseBody
	public JSONObject ReturnFunction(HttpServletRequest request, HttpServletResponse response) {
		String borrowtype = request.getParameter("borrowtype");
		String borrowRecordsId = request.getParameter("borrowRecordsId");
		String borrowRecordsEvaluation = request.getParameter("borrowRecordsEvaluation");
		String borrowRecordsInstructions = request.getParameter("borrowRecordsInstructions");
		
		JSONObject msg = JSONObject.fromObject(fs.fileReturnBusiness(borrowtype,borrowRecordsId, borrowRecordsEvaluation, borrowRecordsInstructions));
		return msg;
	}
////////////////////////////////////////////(-------------<借阅功能(尾)>-----<END>--------)//////////////////////////////////////////////////////////////////////////////////	

	/**
	 * 数据渲染
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/fileBorrowingReview")
	@ResponseBody
	public Layui fileBorrowingReview(HttpServletRequest request,HttpServletResponse response,int page,int limit) {
		//全宗主键
		String quanzongName =  request.getParameter("quanzongName");
		//年度
		String borrowdetailsAnnual = request.getParameter("borrowdetailsAnnual");
		//关键词
		String borrowdetailsTitle = request.getParameter("borrowdetailsTitle");
		List<BorrowDetails> borrowdetailsList = fs.borrowQueryFile(quanzongName, borrowdetailsAnnual,borrowdetailsTitle,page,limit);
		Integer borrowdetailsCount = fs.borrowQueryFileCount(request,quanzongName, borrowdetailsAnnual,borrowdetailsTitle,page,limit);
		System.out.println(borrowdetailsCount);
		return Layui.data(borrowdetailsCount, borrowdetailsList);
		
	}
	
	/**
	 * 审核功能拒绝
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/fileAudit")
	@ResponseBody
	public JSONObject fileAudit(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  List<DataListSourceVoForm> dateList) {
		JSONObject msg = JSONObject.fromObject(fs.fileAudit(dateList));
		return msg;
	}
	
	/**
	 * 审核功能通过
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/filePass")
	@ResponseBody
	public JSONObject filePass(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  List<DataListSourceVoForm> dateList) {
		JSONObject msg = JSONObject.fromObject(fs.filePass(dateList));
		return msg;
	}
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileBorrowingService fs=(FileBorrowingService)context.getBean("FileBorrowingService",FileBorrowingService.class);
		 	UUID uuid=UUID.randomUUID();
	        String str = uuid.toString();
	        String uuidStr=str.replace("-", "");
	        System.out.println(uuidStr);
	}
}
