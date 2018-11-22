package filemanage.systemmanage.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.PrintCellComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.PrimaryClassFicationService;
import filemanage.systemmanage.service.SecondryClassFicationService;
import filemanage.utils.page.PageBean;
/**
 * @author tchuanwu
 * 分类管理控制层
 */
@Controller
@RequestMapping("classfication")
public class ClassFicationController {
	
	@Autowired
	private PrimaryClassFicationService primaryClassFicationService;
	@Autowired
	private SecondryClassFicationService secondryClassFicationService;
	@Autowired
	private MessageNotificationService messageNotificationService;
	@Autowired
	private ArchiveService archiveService;
	private User user;
	private Logger logger=Logger.getLogger(ClassFicationController.class);
	
	/**
	 * 跳转到档案自定义页面
	 * @return
	 */
	@RequestMapping(value="/getAllPrimaryClass")
	@ResponseBody
	public ModelAndView getAllPrimaryClass(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
		ModelAndView mv=new ModelAndView();
		user = HavingUserInfor.havingUser();
		Integer countAllPc=primaryClassFicationService.countAllPc();
		logger.info("获取到的用户信息为:"+user);
		List<SecondryClassFication> listsc=secondryClassFicationService.queryAllSc();
		//获取全宗的信息
		List<Archive> archiveList = archiveService.selectAllArchive();
		mv.addObject("archiveList",archiveList);
		mv.addObject("listsc", listsc);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("countAllPc", countAllPc);
		mv.addObject("pagemsg",primaryClassFicationService.findByPage(currentPage));
		mv.addObject("pagemsg2",primaryClassFicationService.findByPage2(currentPage));
		mv.setViewName("/classfication/classficationManage");
		return mv;
	}
	/**
	 * 遍历所有的一级分类
	 * @return
	 */
	@RequestMapping(value="/queryAllPrimaryClass")
	@ResponseBody
	public List<PrimaryClassFication> queryAllPrimaryClass() {
		List<PrimaryClassFication> primaryClassList=primaryClassFicationService.queryAllPrimaryClass();
		return primaryClassList;
	}
	/**
	 * 查询所有的问题分类并分页
	 * @param currentPage
	 * @param scStatus
	 * @return
	 */
	@RequestMapping(value="/selectPcByPage",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public PageBean<PrimaryClassFication> selectPcByPage(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,
			@RequestParam("scStatus") String scStatus){
		return primaryClassFicationService.queryAllPc(scStatus, currentPage);
	}
	/**
	 * 查询所有的机构分类并分页
	 * @param currentPage
	 * @param scStatus
	 * @return
	 */
	@RequestMapping(value="/selectPcBySCPage",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public PageBean<PrimaryClassFication> selectPcBySCPage(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,
			@RequestParam("scStatus") String scStatus){
		return primaryClassFicationService.queryAllScByPc(scStatus, currentPage);
	}
	
	
	
	/**
	 * 添加分类
	 * @param request
	 * @param pcId
	 * @return
	 */
	@RequestMapping(value="/addClassFication",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addPrimaryClass(HttpServletRequest request,@RequestParam(value="pcId", required=true) String pcId) {
		 Integer result=null;
		 String typeCode=request.getParameter("typeCode");
		 String typeName=request.getParameter("typeName");
		 String typeContext=request.getParameter("typeContext");
		 String scStatus=request.getParameter("scStatus");
		 user = HavingUserInfor.havingUser();
		 logger.info("获取到的用户信息为:"+user);
		 if(pcId !=null && pcId != "" ) {
			 SecondryClassFication scf=new SecondryClassFication();
			 scf.setPcId(pcId);
			 scf.setScCode(typeCode);
			 scf.setScName(typeName);
			 scf.setScDescription(typeContext);
			 scf.setScCreateTime(new Date());
			 scf.setScCreator(user.getUserName());
			 scf.setScProperty("1");
			 scf.setScStatus(scStatus);
			 int scCodeName=secondryClassFicationService.isExitSecondryClassCode(scf);
			 int scName=secondryClassFicationService.isExitSecondryClassName(scf);
			 if(scCodeName>0) {
				 System.out.println("对不起,二级分类代码已存在!");
				 result=1;
				 
			 }else if(scName>0) {
				 System.out.println("对不起,二级分类名称已存在!");
				 result= 2;
			 }else {
				 secondryClassFicationService.addSecondryClass(scf);
				 result= 3;
			 }
			 
		 }else {
			 PrimaryClassFication pcf=new PrimaryClassFication();
			 pcf.setPcCode(typeCode);
			 pcf.setPcName(typeName);
			 pcf.setPcCreateTime(new Date());
			 pcf.setPcCreator(user.getUserName());
			 pcf.setPcDescription(typeContext);
			 pcf.setPcProperty("1");
			 int pcCodeName=primaryClassFicationService.isExitPrimaryClassCode(pcf);
			 int pcName=primaryClassFicationService.isExitPrimaryClassName(pcf);
			 if(pcCodeName>0) {
				 System.out.println("对不起,一级分类代码已存在!");
				 result= 4;
			 }else if(pcName>0) {
				 System.out.println("对不起,一级分类名称已存在!");
				 result= 5;
			 }else {
				 primaryClassFicationService.addPrimaryClass(pcf); 
				 result= 6;
			 }
			 
		 }
		 return result;
		
	}
	
	/**
	 * 一二级分类遍历
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryStr",method= RequestMethod.POST)
	@ResponseBody
	public JSONObject queryStr()throws Exception{
		String result=primaryClassFicationService.selectAllPc();
		return JSONObject.parseObject(result);
	}
	
	/**
	 * 显示文书档案下的机构分类
	 * @return
	 */
	@RequestMapping(value="/queryScByPcIdAndStatus",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSONObject queryScByPcIdAndStatus(HttpServletRequest request,HttpServletResponse response){
		String quanzongid = request.getParameter("quanzongid");
		String result=primaryClassFicationService.queryScByIdAndStatus(quanzongid);
		return JSONObject.parseObject(result);
	}
	
	/**
	 * 根据二级分类主键查询文件表里是否有二级分类存在 ,如果有则不能删除
	 * @param scId
	 * @return
	 */
	@RequestMapping(value="/deleteScById",method= RequestMethod.POST)
	@ResponseBody
	public Boolean deleteScById(@RequestParam(value="scId", required=true) String scId) {
		Boolean result=null;
		int countArchiveFileByScId=secondryClassFicationService.countArchiveFileByScId(scId);
		if(countArchiveFileByScId==0) {
			result=secondryClassFicationService.delSecondryClassById(scId);
		}else if(countArchiveFileByScId>0){
			result=false;
		}
		return result;
	}
	/**
	 * 删除一级分类时判断一级分类下是否有二级分类,如果有则不能删除
	 * @param pcId
	 * @return
	 */
	@RequestMapping(value="/deletePcByPcId",method= RequestMethod.POST)
	@ResponseBody
	public Boolean deletePcByPcId(@RequestParam(value="pcId", required=true) String pcId) {
		Boolean result=null;
		int countPcIdBySc=primaryClassFicationService.countPcIdBySc(pcId);
		if(countPcIdBySc==0) {
			result=primaryClassFicationService.deletePcByPcId(pcId);
		}else if(countPcIdBySc>0) {
			result=false;
		}
		return result;
	}
	
	/**
	 * 根据一级分类主键和二级分类状态查询二级分类
	 * @param pcId
	 * @param scStatus
	 * @return
	 */
	@RequestMapping(value="/queryScByIdAndStatus",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<SecondryClassFication> queryScByIdAndStatus(@RequestParam("pcId") String pcId,
			@RequestParam("scStatus") String scStatus,@RequestParam("quanzongid") String quanzongid){
		 List<SecondryClassFication> listsc=secondryClassFicationService.queryAllSecondry(pcId,scStatus,quanzongid);
		  return listsc;
	}
	/**
	 * 根据一级分类主键查询二级分类
	 * @param pcId
	 * @return
	 */
	@RequestMapping(value="/queryScByPcId",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<SecondryClassFication> queryScByPcId(@RequestParam("pcId") String pcId){
		List<SecondryClassFication> listsc=secondryClassFicationService.querySecondryByPcId(pcId);
		return listsc;
	}
	/**
	 * 遍历文书档案下的机构分类,调取的是机构表的数据(根据全宗id查询二级分类的机构分类)
	 * @return
	 */
	@RequestMapping(value="/queryScByOrg",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<PrimaryClassFication> queryScByOrg(@RequestParam("quanzongid")String quanzongid){
		List<PrimaryClassFication> listsc=primaryClassFicationService.queryScByOrg(quanzongid);
		return listsc;
	}
	/**
	 * 遍历文书档案下的所有二级分类
	 * @return
	 */
	@RequestMapping(value="/queryAllPcById",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<PrimaryClassFication> queryAllPcById(){
		List<PrimaryClassFication> listsc=primaryClassFicationService.queryAllPcById();
		return listsc;
	}
	

}
