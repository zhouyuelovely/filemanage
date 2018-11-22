package filemanage.danganmanage.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.itextpdf.text.DocumentException;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.danganmanage.pojo.Managerdetails;
import filemanage.danganmanage.service.DanganManageService;
import filemanage.danganmanage.service.ManagerdetailsService;
import filemanage.danganmanage.vo.BoxCondition;
import filemanage.danganmanage.vo.DanganmanageCondition;
import filemanage.danganmanage.vo.QueryBoxByCondition;
import filemanage.danganmanage.vo.QueryFileByCondition;
import filemanage.danganmanage.vo.QueryHistoryByCondition;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.UserService;
import filemanage.utils.layui.Layui;
import filemanage.utils.paperbuild.CreatePdfUtil;


/**
 * @author tchuanwu
 * 档案管理控制层
 *
 */
@Controller
@RequestMapping("danganmanage")
public class DanganmanageController {
	 private User user;
	 private Logger logger=Logger.getLogger(DanganmanageController.class);
	 @Autowired
	 private MessageNotificationService messageNotificationService;
	 @Autowired
	 private DanganManageService danganManageService;
	 @Autowired
	 private ManagerdetailsService managerdetailsService;
	 @Autowired
	 private UserService userService;
	 
	 
	/**
	 * 跳转到档案管理——以盒管理页面
	 * @return
	 */
	@RequestMapping("/goboxmanagement")
	public ModelAndView goboxmanagement() {
		logger.info("跳转到档案管理——以盒管理页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<BoxCondition> listquanzongName=danganManageService.queryAllQuanzongName();
		mv.addObject("listquanzongName", listquanzongName);
		Integer countAllManagerdetails=managerdetailsService.countAllManagerdetails();
		mv.addObject("user", user);
		mv.addObject("boxNum", danganManageService.countSelectAllBox());//统计所有审核合格的盒数
		mv.addObject("fileNum", danganManageService.countFileNumByBox());//统计所有审核合格的件数
		mv.addObject("countAllManagerdetails", countAllManagerdetails);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/boxmanagement");
		return mv;
	}
	/**
	 * 以盒管理页面layui数据渲染
	 * @return
	 */
	@RequestMapping(value="/selectAllBox",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui selectAllBox(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.selectAllBox(page, limit);
	}
	/**
	 * 以盒管理页面筛选过后layui数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryAllBox",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryAllBox(BoxCondition boxCondition,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.queryAllBox(boxCondition, page, limit);
	}
	
	/**
	 * 以盒管理页面根据全宗名、一级分类、年度、保管期限获取盒数和件数
	 * @param quanzongName
	 * @param pcName
	 * @param boxAnual
	 * @param retentionperiodname
	 * @return
	 */
	@RequestMapping(value="/countBox",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public HavingInforBox countBox(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName,@RequestParam("boxAnual") String boxAnual,
			@RequestParam("retentionperiodname") String retentionperiodname) {
		BoxCondition boxCondition =new BoxCondition();
		boxCondition.setBoxAnual(boxAnual);
		boxCondition.setPcName(pcName);
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setRetentionperiodname(retentionperiodname);
		return danganManageService.countBoxByCondition(boxCondition);
	}
	
	/**
	 * 以件管理页面根据全宗名、一级分类、年度、保管期限获取件数和页数
	 * @param quanzongName
	 * @param pcName
	 * @param archivefileanual
	 * @param retentionperiodname
	 * @return
	 */
	@RequestMapping(value="/queryFileByboxCondition",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFileHelpInfor queryFileByboxCondition(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName,@RequestParam("archivefileanual") String archivefileanual,
			@RequestParam("retentionperiodname") String retentionperiodname) {
		BoxCondition boxCondition =new BoxCondition();
		boxCondition.setArchivefileanual(archivefileanual);;
		boxCondition.setPcName(pcName);
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setRetentionperiodname(retentionperiodname);
		return danganManageService.queryFileByboxCondition(boxCondition);
	}
	
	/**
	 * 历史数据管理页面根据全宗名、一级分类、年度、保管期限获取件数和页数
	 * @param quanzongName
	 * @param pcName
	 * @param historydataArchivalYear
	 * @param retentionperiodname
	 * @return
	 */
	@RequestMapping(value="/queryHistoryDataByCondition",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFileHelpInfor queryHistoryDataByCondition(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("historydataType") String historydataType,@RequestParam("historydataArchivalYear") String historydataArchivalYear,
			@RequestParam("retentionperiodname") String retentionperiodname) {
		BoxCondition boxCondition =new BoxCondition();
		boxCondition.setHistorydataArchivalYear(historydataArchivalYear);
		boxCondition.setHistorydataType(historydataType);
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setRetentionperiodname(retentionperiodname);
		return danganManageService.queryHistoryDataByCondition(boxCondition);
	}
	
	/**
	 * 关键词查询盒信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryBoxByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryBoxByConditions(String conditions,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.queryBoxByConditions(conditions, page, limit);
	}
	/**
	 * 以盒管理条件查询下统计盒数和件数
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/queryConditionNum",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public HavingInforBox queryConditionNum(@RequestParam("conditions")String conditions) {
		QueryBoxByCondition boxCondition=new QueryBoxByCondition();
		boxCondition.setConditions(conditions);
		return danganManageService.queryBoxByCondition(boxCondition);
	}
	
	/**
	 * 新增管理明细
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addManagerDetails",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addManagerDetails(HttpServletRequest request) {
		Integer result=null;
		String managerDetailsApplication=request.getParameter("managerDetailsApplication");
		String managerDetailsBeforeChange=request.getParameter("managerDetailsBeforeChange");
		String managerDetailsAfterChange=request.getParameter("managerDetailsAfterChange");
		String managerDetailsReason=request.getParameter("managerDetailsReason");
		String managerDetailsPerson=HavingUserInfor.havingUser().getUserName();
		String id=request.getParameter("id");
		String managerDetailsTime = request.getParameter("managerDetailsTime");
		Managerdetails managerdetails=new Managerdetails();
		managerdetails.setId(id);
		managerdetails.setIdStatus("2");
		managerdetails.setManagerDetailsAfterChange(managerDetailsAfterChange);
		managerdetails.setManagerDetailsApplication(managerDetailsApplication);
		managerdetails.setManagerDetailsBeforeChange(managerDetailsBeforeChange);
		managerdetails.setManagerDetailsPerson(managerDetailsPerson);
		managerdetails.setManagerDetailsReason(managerDetailsReason);
		managerdetails.setManagerDetailsTime(managerDetailsTime);
		managerdetails.setManagerDetailsStatus("1");
		managerdetails.setIsDelete("1");
		managerdetails.setFlag("0");
		Integer addresult=managerdetailsService.addManagerDetails(managerdetails);
			if(addresult>0) {
				logger.info("档案管理明细表数据添加成功!");
				result=1;
			}else {
				logger.info("档案管理明细表数据添加失败!");
				result=2;
			}

		return result;
	}
	
	
	
	/**跳转到档案管理——以件管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/gofilemanagement")
	public ModelAndView gofilemanagement() {
		logger.info("跳转到档案管理——以件管理页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<BoxCondition> listquanzongName=danganManageService.queryAllQuanzongName2();
		mv.addObject("listquanzongName", listquanzongName);
		mv.addObject("fileNum", danganManageService.countFileNumByBox());//统计合格文件件数
		mv.addObject("filePagesNum", danganManageService.countAllFilePages());//统计合格文件页数
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/filemanagement");
		return mv;
	}
	
	/**
	 * 以件管理页面数据渲染
	 * @return
	 */
	@RequestMapping(value="/selectAllFile",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui selectAllFile(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		
		return danganManageService.selectAllFile2(page, limit);
	}
	/**
	 * 以件管理页面筛选之后数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryAllFile",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryAllFile(BoxCondition boxCondition,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		
		return danganManageService.queryAllFile(boxCondition, page, limit);
	}
	/**
	 * 关键词查询件信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryFileByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryFileByConditions(String conditions,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.queryFileByConditions(conditions, page, limit);
	}
	/**
	 * 以件管理条件查询下统计文件数量和页数
	 * @param conditions
	 * @return
	 */
	@RequestMapping(value="/queryFileConditionNum",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFileHelpInfor queryFileConditionNum(@RequestParam("conditions")String conditions) {
		QueryFileByCondition  fileCondition=new QueryFileByCondition();
		fileCondition.setConditions(conditions);
		return danganManageService.queryFileByCondition(fileCondition);
	} 
	/**
	 * 历史数据管理条件查询下统计件数和页数
	 * @param conditions
	 * @return
	 */
	@RequestMapping(value="/queryHistoryDataConditionNum",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFileHelpInfor queryHistoryDataConditionNum(@RequestParam("conditions")String conditions) {
		QueryFileByCondition  fileCondition=new QueryFileByCondition();
		fileCondition.setConditions(conditions);
		return danganManageService.queryHistoryDataByCondition(fileCondition);
	}
	
	/**
	 * 新增管理明细
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addManagerDetails2",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addManagerDetails2(HttpServletRequest request) {
		Integer result=null;
		String managerDetailsApplication=request.getParameter("managerDetailsApplication");
		String managerDetailsBeforeChange=request.getParameter("managerDetailsBeforeChange");
		String managerDetailsAfterChange=request.getParameter("managerDetailsAfterChange");
		String managerDetailsReason=request.getParameter("managerDetailsReason");
		String managerDetailsPerson=HavingUserInfor.havingUser().getUserName();
		String id=request.getParameter("id");
		String managerDetailsTime = request.getParameter("managerDetailsTime");
		Managerdetails managerdetails=new Managerdetails();
		managerdetails.setId(id);
		managerdetails.setIdStatus("1");
		managerdetails.setManagerDetailsAfterChange(managerDetailsAfterChange);
		managerdetails.setManagerDetailsApplication(managerDetailsApplication);
		managerdetails.setManagerDetailsBeforeChange(managerDetailsBeforeChange);
		managerdetails.setManagerDetailsPerson(managerDetailsPerson);
		managerdetails.setManagerDetailsReason(managerDetailsReason);
		managerdetails.setManagerDetailsTime(managerDetailsTime);
		managerdetails.setManagerDetailsStatus("1");
		managerdetails.setIsDelete("1");
		managerdetails.setFlag("0");
		Integer addresult=managerdetailsService.addManagerDetails(managerdetails);
			if(addresult>0) {
				logger.info("档案管理明细表数据添加成功!");
				result=1;
			}else {
				logger.info("档案管理明细表数据添加失败!");
				result=2;
			}

		return result;
	}
	

	/**跳转到档案管理——历史数据管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/gohistorymanagement")
	public ModelAndView gohistorymanagement() {
		logger.info("跳转到档案管理——历史数据管理页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<BoxCondition> listquanzongName=danganManageService.queryAllQuanzongName3();
		mv.addObject("listquanzongName", listquanzongName);
		mv.addObject("historydataNum", danganManageService.countSelectAllHistoryData());
		mv.addObject("historydataPagesNum", danganManageService.countSelectAllHistoryDataPages());
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/historymanagement");
		return mv;
	}
	/**
	 * 跳转到档案管理——审核盒页面
	 * @return
	 */
	@RequestMapping("/goboxdatareview")
	public ModelAndView goboxdatareview() {
		logger.info("跳转到档案管理——审核盒页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<User> userList=userService.listAllUser();
		mv.addObject("userList", userList);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/boxdatareview");
		return mv;
	}
	/**
	 * 跳转到档案管理——审核件页面
	 * @return
	 */
	@RequestMapping("/gofiledatareview")
	public ModelAndView gofiledatareview() {
		logger.info("跳转到档案管理——审核件页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<User> userList=userService.listAllUser();
		mv.addObject("userList", userList);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/filedatareview");
		return mv;
	}
	/**
	 * 跳转到档案管理——以盒管理明细页面
	 * @return
	 */
	@RequestMapping("/goboxsubsidiary")
	public ModelAndView goboxsubsidiary(HttpServletRequest request,HttpServletResponse response) {
		logger.info("跳转到档案管理——以盒管理明细页面");
		String id = request.getParameter("id");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		mv.addObject("user", user);
		List<User> userList=userService.listAllUser();
		mv.addObject("userList", userList);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("id",id);
		mv.setViewName("/danganmanage/boxsubsidiary");
		return mv;
	}
	/**
	 * 档案管理以盒管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryManagedetailsByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	public Layui queryManagedetailsByConditions(DanganmanageCondition danganmanageCondition,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return managerdetailsService.queryManagerdetailsByConditions(danganmanageCondition, limit, page);
	}
	/**
	 * 档案管理以件管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryManagerdetailsFileByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	public Layui queryManagerdetailsFileByConditions(DanganmanageCondition danganmanageCondition,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return managerdetailsService.queryManagerdetailsByFileConditions(danganmanageCondition, limit, page);
	}
	/**
	 * 档案审核-审核件多条件查询 
	 * @param managerdetails
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryManagerdetailsByFileShenheConditions",method= {RequestMethod.GET,RequestMethod.POST})
	public Layui queryManagerdetailsByFileShenheConditions(DanganmanageCondition danganmanageCondition,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return managerdetailsService.queryManagerdetailsByFileShenheConditions(danganmanageCondition, limit, page);
	}
	
	/**
	 * 跳转到档案管理——以件管理明细页面
	 * @return
	 */
	@RequestMapping("/gofilesubsidiary")
	public ModelAndView gofilesubsidiary() {
		logger.info("跳转到档案管理——以件管理明细页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<User> userList=userService.listAllUser();
		mv.addObject("userList", userList);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/filesubsidiary");
		return mv;
	}
	
	/**
	 * 以盒管理-管理明细数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryAllManagerdetails",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryAllManagerdetails(String id,int page, int limit) {
		int before = limit * (page-1);  
        int after = page * limit; 
		Integer countAllManagerdetails=managerdetailsService.countAllManagerdetails();
		List<Managerdetails> listmanagerdetails=managerdetailsService.queryAllManagerdetails(id,before, after);
		return Layui.data(countAllManagerdetails, listmanagerdetails);
	}
	/**
	 * 以件管理-管理明细数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryManagerdetailsByFile",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryManagerdetailsByFile(int page, int limit) {
		int before = limit * (page-1);  
        int after = page * limit; 
		Integer countManagerdetailsByFile=managerdetailsService.countManagerdetailsByFile();
		List<Managerdetails> listmanagerdetails=managerdetailsService.queryManagerdetailsByFile(before, after);
		return Layui.data(countManagerdetailsByFile, listmanagerdetails);
	}
	
	/**
	 * 档案审核-审核盒管理明细数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryManagerdetailsByBoxShenhe",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryManagerdetailsByBoxShenhe(int page, int limit) {
		int before = limit * (page-1);  
        int after = page * limit; 
        Integer countManagerdetailsByBoxShenhe=managerdetailsService.countManagerdetailsByBoxShenhe();
        List<Managerdetails> queryManagerdetailsByBoxShenhe=managerdetailsService.queryManagerdetailsByBoxShenhe(before, after);
        return Layui.data(countManagerdetailsByBoxShenhe, queryManagerdetailsByBoxShenhe);
	}
	
	/**
	 * 档案审核-审核件管理明细数据渲染
	 * @return
	 */
	@RequestMapping(value="/queryManagerdetailsByFileShenghe",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryManagerdetailsByFileShenghe(int page, int limit) {
		int before = limit * (page-1);  
        int after = page * limit; 
        Integer countManagerdetailsByFileShenghe=managerdetailsService.countManagerdetailsByFileShenghe();
        List<Managerdetails> listmanagerdetailsShenhe=managerdetailsService.queryManagerdetailsByFileShenghe(before, after);
        return Layui.data(countManagerdetailsByFileShenghe, listmanagerdetailsShenhe);
	}
	/**
	 * 历史数据管理明细页面
	 * @return
	 */
	@RequestMapping("/gohistorysubsidiary")
	public ModelAndView gohistorysubsidiary() {
		logger.info("跳转到档案管理——以件管理明细页面");
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<User> userList=userService.listAllUser();
		mv.addObject("userList", userList);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/danganmanage/historysubsidiary");
		return mv;
	}
	/**
	 * 历史数据管理页面数据渲染
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/queryAllHistoryData",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryAllHistoryData(BoxCondition boxCondition,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.queryAllHistoryData(boxCondition, page, limit);
	}
	/**
	 * 历史数据管理关键词查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryHistoryDataByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryHistoryDataByConditions(String conditions,@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.queryHistoryByConditions(conditions, page, limit);
	}
	/**
	 * 查询历史数据文件附件
	 * @param historydataId
	 * @return
	 */
	@RequestMapping(value="/queryHistoryAnnexByHistoryId",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<HistoryAnnex> queryHistoryAnnexByHistoryId( String historydataId){
		return danganManageService.queryHistoryAnnexByHistoryId(historydataId);
	}
	
	@RequestMapping(value="/selectAllHistoryData",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui selectAllHistoryData(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return danganManageService.selectAllHistoryData(page, limit);
	}
	/**
	 * 历史数据管理明细页面数据渲染
	 */
	@RequestMapping(value="/queryAllManagerdetailsByHistoryData",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryAllManagerdetailsByHistoryData(int page, int limit) {
		int before = limit * (page-1);  
        int after = page * limit; 
        Integer countManagerdetailsByHistoryData=managerdetailsService.countManagerdetailsByHistoryData();
        List<Managerdetails> listhistory=managerdetailsService.queryManagerdetailsByHistoryData(before, after);
        return Layui.data(countManagerdetailsByHistoryData, listhistory);
	}
	/**
	 * 历史数据管理明细页面多条件查询
	 * @param managerdetails
	 * @return
	 */
	@RequestMapping(value="/queryManagerdetailsByHistoryDataConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryManagerdetailsByHistoryDataConditions(DanganmanageCondition danganmanageCondition,@RequestParam("limit")Integer limit,
			@RequestParam("page")Integer page) {
		return managerdetailsService.queryManagerdetailsByHistoryDataConditions(danganmanageCondition, limit, page);
	}
	/**
	 * 档案审核修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateManagerdetails",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer updateManagerdetails(HttpServletRequest request) {
		Integer result=null;
		String managerDetailsReviewer=request.getParameter("managerDetailsReviewer");
		String managerDetailsAudittime=request.getParameter("managerDetailsAudittime");
		String managerDetailsBohuiReason=request.getParameter("managerDetailsBohuiReason");
		String managerDetailsStatus=request.getParameter("managerDetailsStatus");
		String managerDetailsId=request.getParameter("managerDetailsId");
		Managerdetails managerdetails=new Managerdetails();
		managerdetails.setManagerDetailsReviewer(managerDetailsReviewer);
		managerdetails.setManagerDetailsAudittime(managerDetailsAudittime);
		managerdetails.setManagerDetailsId(managerDetailsId);
		managerdetails.setManagerDetailsStatus(managerDetailsStatus);
		managerdetails.setManagerDetailsBohuiReason(managerDetailsBohuiReason);
		if(managerdetailsService.updateManagerdetailsById(managerdetails)>0) {
			result=1;
		}else {
			result=2;
		}
		return result;	
	}
	
	/**
	 * 以件管理管理明细下载pdf(文件附件图片)
	 * @param archiveFileId
	 * @return
	 */
	@RequestMapping(value = "/uploadPDF", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Integer uploadPdf(@RequestParam("archiveFileId") String archiveFileId) {
		Integer result=null;
		String filePath ="D:/file";
		List<String> imgList = new ArrayList<String>();
		List<FileAttachment> list=danganManageService.queryFileAttachmentByArchiveFileId(archiveFileId);
		for(int i=0;i<list.size();i++) {
			imgList.add(list.get(i).getFileAttachmentPath());
			logger.info("获取图片全路径集合======" + imgList);
			logger.info("获取图片路径-----" + filePath);
		}
		try {
			CreatePdfUtil.createPDF(filePath + "/" + archiveFileId + ".PDF", imgList);
			result=1;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 历史数据管理明细下载pdf(文件附件图片)
	 * @param archiveFileId
	 * @return
	 */
	@RequestMapping(value = "/uploadHistoryDataPdf", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Integer uploadHistoryDataPdf(@RequestParam("historydataId") String historydataId) {
		Integer result=null;
		String filePath ="D:/file";
		List<String> imgList = new ArrayList<String>();
		List<HistoryAnnex> list=danganManageService.queryHistoryAnnexByHistoryId2(historydataId);
		for(int i=0;i<list.size();i++) {
			imgList.add(list.get(i).getHistoryannexPath());
			logger.info("获取图片全路径集合======" + imgList);
			logger.info("获取图片路径-----" + filePath);
		}
		try {
			CreatePdfUtil.createPDF(filePath + "/" + historydataId + ".PDF", imgList);
			result=1;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 鉴定销毁假删除
	 * @param managerdetails
	 * @return
	 */
	@RequestMapping(value = "/updateManagerdetailsByIsDelete", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Integer updateManagerdetailsByIsDelete(@RequestParam("managerDetailsId") String managerDetailsId) {
		Integer result=null;
		if(managerdetailsService.updateManagerdetailsByIsDelete(managerDetailsId)>0) {
			result=1;
		}else {
			result=2;
		}
		return result;
	}
	/**
	 * 以盒管理根据全宗名称查询该全宗下的一级分类
	 * @param quanzongName
	 * @return
	 */
	@RequestMapping(value = "/queryPcByquanzongName", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryPcByquanzongName(@RequestParam("quanzongName") String quanzongName){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		List<BoxCondition> listbox=danganManageService.queryPcByquanzongName(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			 System.out.println(boxCondition2.getPcName());
		}
		 return listbox;
	}
	/**
	 * 以件管理根据全宗名称查询该全宗下的一级分类
	 * @param quanzongName
	 * @return
	 */
	@RequestMapping(value = "/queryPcByquanzongName2", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryPcByquanzongName2(@RequestParam("quanzongName") String quanzongName){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		List<BoxCondition> listbox=danganManageService.queryPcByquanzongName2(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			 System.out.println(boxCondition2.getPcName());
		}
		 return listbox;
	}
	/**
	 * 历史数据管理根据全宗名称查询该全宗下的一级分类
	 * @param quanzongName
	 * @return
	 */
	@RequestMapping(value = "/queryPcByquanzongName3", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryPcByquanzongName3(@RequestParam("quanzongName") String quanzongName){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		List<BoxCondition> listbox=danganManageService.queryPcByquanzongName3(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			 System.out.println(boxCondition2.getPcName());
		}
		 return listbox;
	}
	
	
	/**
	 * 以盒管理根据全宗名称和一级分类名称查询年度
	 * @param quanzongName
	 * @param pcName
	 * @return
	 */
	@RequestMapping(value = "/queryBoxAnualByquanzongNameAndPcName", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setPcName(pcName);
		List<BoxCondition> listbox=danganManageService.queryBoxAnualByquanzongNameAndPcName(boxCondition);
		return listbox;
	}
	
	/**
	 * 以件管理根据全宗名称和一级分类名称查询年度
	 * @param quanzongName
	 * @param pcName
	 * @return
	 */
	@RequestMapping(value = "/queryBoxAnualByquanzongNameAndPcName2", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName2(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setPcName(pcName);
		List<BoxCondition> listbox=danganManageService.queryBoxAnualByquanzongNameAndPcName2(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			System.out.println("文件年度:"+boxCondition2.getArchivefileanual());
		}
		return listbox;
	}
	
	/**
	 * 历史数据管理根据全宗名称和一级分类名称查询年度
	 * @param quanzongName
	 * @param pcName
	 * @return
	 */
	@RequestMapping(value = "/queryBoxAnualByquanzongNameAndPcName3", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName3(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("historydataType") String historydataType){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setHistorydataType(historydataType);
		List<BoxCondition> listbox=danganManageService.queryBoxAnualByquanzongNameAndPcName3(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			System.out.println("历史数据年度:"+boxCondition2.getArchivefileanual());
		}
		return listbox;
	}
	
	
	/**
	 * 以盒管理根据全宗名称和一级分类名称还有年度查询保管期限名称
	 * @param quanzongName
	 * @param pcName
	 * @param boxAnual
	 * @return
	 */
	@RequestMapping(value = "/queryRpNameByquanzongNameAndPcNameAndBoxAnual", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName,@RequestParam("boxAnual") String boxAnual){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setPcName(pcName);
		boxCondition.setBoxAnual(boxAnual);
		List<BoxCondition> listbox=danganManageService.queryRpNameByquanzongNameAndPcNameAndBoxAnual(boxCondition);
		return listbox;
	}
	/**
	 * 以件管理根据全宗名称和一级分类名称还有年度查询保管期限名称
	 * @param quanzongName
	 * @param pcName
	 * @param archivefileanual
	 * @return
	 */
	@RequestMapping(value = "/queryRpNameByquanzongNameAndPcNameAndBoxAnual2", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual2(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("pcName") String pcName,@RequestParam("archivefileanual") String archivefileanual){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setPcName(pcName);
		boxCondition.setArchivefileanual(archivefileanual);;
		List<BoxCondition> listbox=danganManageService.queryRpNameByquanzongNameAndPcNameAndBoxAnual2(boxCondition);
		return listbox;
	}
	
	/**
	 * 历史数据管理根据全宗名称和一级分类名称还有年度查询保管期限名称
	 * @param quanzongName
	 * @param pcName
	 * @param historydataArchivalYear
	 * @return
	 */
	@RequestMapping(value = "/queryRpNameByquanzongNameAndPcNameAndBoxAnual3", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual3(@RequestParam("quanzongName") String quanzongName,
			@RequestParam("historydataType") String historydataType,@RequestParam("historydataArchivalYear") String historydataArchivalYear){
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName(quanzongName);
		boxCondition.setHistorydataType(historydataType);
		boxCondition.setHistorydataArchivalYear(historydataArchivalYear);
		List<BoxCondition> listbox=danganManageService.queryRpNameByquanzongNameAndPcNameAndBoxAnual3(boxCondition);
		return listbox;
	}
	
	
	

}
