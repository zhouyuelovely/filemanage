package filemanage.collectandorganize.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.pojo.KnowledgeBase;
import filemanage.collectandorganize.service.IdentificationService;
import filemanage.collectandorganize.service.KnowledgeBaseService;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.Shuiyin;

import filemanage.collectandorganize.vo.AmCoArchivefile;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.service.FileCustomizationTermOfCustodyService;
import filemanage.systemmanage.service.PrimaryClassFicationService;
import filemanage.systemmanage.service.UserService;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;
import filemanage.utils.shuiYinTool.SealTools;

/**
 * @author tchuanwu
 * 知识库控制层
 */
@Controller
@RequestMapping("knowledgeBase")
public class KnowledgeBaseController {
	private Logger logger=Logger.getLogger(KnowledgeBaseController.class);
	private User user;
	private String quanzongId;
	
	@Autowired
	private KnowledgeBaseService knowledgeBaseService;
	@Autowired
	private PrimaryClassFicationService primaryClassFicationService;
	@Autowired
	private UserService userService;
	@Autowired
	private FileCustomizationTermOfCustodyService ftocService;
	@Autowired
	private IdentificationService identificationService;
	
	
	
	/**
	 * 跳转到档案整理知识库页面
	 * @return
	 */
	@RequestMapping(value="/goKnowledgeBase")
	public ModelAndView goKnowledgeBase() {
		ModelAndView mv=new ModelAndView();
		 user = HavingUserInfor.havingUser();
		logger.info("获取的用户信息为：" + user);
		mv.setViewName("/archivescollect/knowledgeBase");
		return mv;
	}
	/**
	 * 跳转到鉴定分类页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/goIdentification")
	public ModelAndView goIdentification(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) throws Exception {
		logger.info("进入档案整理页面");
		user = HavingUserInfor.havingUser();
		quanzongId=HavingUserInfor.havingArchiveId();
		ModelAndView mv=new ModelAndView();
		List<PrimaryClassFication> primaryClassList=primaryClassFicationService.queryAllPrimaryClass();
		AmMaSmRetentionperiod ammasmretentionperiod  = new AmMaSmRetentionperiod();
		List<AmMaSmRetentionperiod> retentionPeriodList=ftocService.queryTermOfCustody(ammasmretentionperiod);
		user.setUserId(user.getUserId());
		user.setQuanzongId(quanzongId);
		List<User> userList=userService.queryUserAllManager(user);
		logger.info("用户集合为:"+userList);
        List<ArchiveFile> listFileByAnnual=identificationService.queryFileByAnualAndStatus(quanzongId); 
         for (int i=0;i<listFileByAnnual.size();i++) {
			mv.addObject("pagemsg",identificationService.findFileByPage("1",listFileByAnnual.get(i).getArchiveFileAnual() ,quanzongId, "2", currentPage) );
			mv.addObject("pagemsg2",identificationService.findFileByPage("2",listFileByAnnual.get(i).getArchiveFileAnual() ,quanzongId, "2",currentPage) );
			mv.addObject("pagemsg3",identificationService.findFileByPage("3",listFileByAnnual.get(i).getArchiveFileAnual() ,quanzongId, "3",currentPage) );	
		}
         //用户表
         logger.info("获取的用户信息为：" + user);
         logger.info("获取的全宗主键为:"+quanzongId);
		//查询该用户所属全宗名称
		mv.addObject("userList",userList);
		//查询该全宗下的年度查询
		mv.addObject("listFileByAnnual", listFileByAnnual);
		mv.addObject("retentionPeriodList", retentionPeriodList);
		mv.addObject("primaryClassList", primaryClassList);
		mv.addObject("user", user);
		mv.setViewName("/archivescollect/Identification");
		return mv;
	}
	
	/**
	 * layui渲染数据
	 * @return
	 */
	@RequestMapping(value="/getKnowledgeBase",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryKnowledgeBase(int page, int limit) {
		 int before = limit * (page-1);  
         int after = page * limit; 
		List<KnowledgeBase> listKnow=knowledgeBaseService.queryAllKnowledgeBase(before,after);
		int countAllKnowledgeBase=knowledgeBaseService.countAllKnowledgeBase();
		return Layui.data(countAllKnowledgeBase, listKnow);
	}
	/**
	 * 关键词查询知识库
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryKnowByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryKnowByConditions(HttpServletRequest request) {
		String conditions=request.getParameter("conditions");
		int countKnowledgeBaseConditions=knowledgeBaseService.countKnowledgeBaseByConditions(conditions);
		List<KnowledgeBase> listKnowledge=knowledgeBaseService.queryKnowledgeByConditions(conditions);
		return Layui.data(countKnowledgeBaseConditions, listKnowledge);
	}
	
	/**
	 * 按知识库类型显示不同的知识库信息
	 * @param KnowledgeType
	 * @return
	 */
	@RequestMapping(value="/queryKnowByType",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryKnowByType(@RequestParam("KnowledgeType") String KnowledgeType){
		List<KnowledgeBase> listKnow=knowledgeBaseService.queryKnowledgeByType(KnowledgeType);
		int countKnowledgeType=knowledgeBaseService.countKnowledgeByType(KnowledgeType);
		return Layui.data(countKnowledgeType, listKnow);
	}
	/**
	 * 添加知识库
	 * @param know
	 * @return
	 */
	@RequestMapping(value="/addKnowledgeBase",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addKnowledgeBase(KnowledgeBase know) {
	    user = HavingUserInfor.havingUser();
	    logger.info("获取的用户信息为：" + user);
		know.setKnowledgePublaster(user.getUserName());
		Integer result=null;
		int isExitKnowledgeDocumentNum=knowledgeBaseService.isExitKnowledgeDocumentNum(know);
		if(isExitKnowledgeDocumentNum>0) {
			System.out.println("知识库文号已存在");
			result=1;
		}else if(knowledgeBaseService.addKnowledgeBase(know)>0) {
			result=2;
		}else {
			result=3;
		}
		return result;
	}
	/**
	 * 根据知识库主键查询知识库
	 * @param knowledgeId
	 * @return
	 */
	@RequestMapping(value="/queryKnowledgeById",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public KnowledgeBase queryKnowledgeById(@RequestParam("knowledgeId") String knowledgeId) {
		KnowledgeBase know=knowledgeBaseService.queryKnowledgeById(knowledgeId);
		return know;
	}
	/**
	 * 根据立卷老师对应全宗年度筛选分页查询图片路径集合
	 * @param currentPage
	 * @param fileAttachmentAnual
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryImgList",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public PageBean<FileAttachment> queryImgList(
			@RequestParam("archiveFileAuthenticateStatus") String archiveFileAuthenticateStatus,
			@RequestParam("fileAttachmentAnual") String fileAttachmentAnual,@RequestParam("quanzongId") String quanzongId,
			@RequestParam("archiveFileFinishingStatus") String archiveFileFinishingStatus,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage
			) throws Exception{
		 PageBean<FileAttachment> PageBean = identificationService.queryImgList(archiveFileAuthenticateStatus,fileAttachmentAnual,quanzongId,archiveFileFinishingStatus,currentPage);
		 List<FileAttachment> flist = PageBean.getLists();
		 for (int i = 0; i < flist.size(); i++) {
			System.out.println(flist.get(i).getArchiveFileId());
		}
		return PageBean;
	}
	
	@RequestMapping(value="/countImg",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int countImg(@RequestParam("archiveFileAuthenticateStatus") String archiveFileAuthenticateStatus,
			@RequestParam("fileAttachmentAnual") String fileAttachmentAnual,
			@RequestParam("quanzongId") String quanzongId,@RequestParam("archiveFileFinishingStatus") String archiveFileFinishingStatus) throws Exception {
		return identificationService.countImgPath(archiveFileAuthenticateStatus, fileAttachmentAnual,quanzongId,archiveFileFinishingStatus);
	}
	/**
	 * 根据文件主键和鉴定分类还有年度和全宗主键分页查询
	 * @param currentPage
	 * @param fileAttachmentAnual
	 * @param quanzongId
	 * @param archiveFileId
	 * @param archiveFileAuthenticateStatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryAttachmentImgList",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<FileAttachment> queryAttachmentImgList(
			@RequestParam("archiveFileId") String archiveFileId
			 )throws Exception{
		 
		return identificationService.queryAttachmentImgList( archiveFileId);
	}
	
	/**
	 * 根据文件主键查询附件表中文件图片数量
	 * @param archiveFileId
	 * @param fileAttachmentAnual
	 * @param archiveFileAuthenticateStatus
	 * @return
	 */
	@RequestMapping(value="/countAttachmentImgPath",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int countAttachmentImgPath(@RequestParam("archiveFileId") String archiveFileId
			) throws Exception{
		int countAttachmentImgPath=identificationService.countAttachmentImgPath( archiveFileId);
		return countAttachmentImgPath;
	}
	/**
	 * 将文件拖动到回收站中改变文件的状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateFileStatus3",method= {RequestMethod.POST, RequestMethod.GET})
	public Boolean updateFileStatus3(HttpServletRequest request) {
		String archiveFileId=request.getParameter("archiveFileId").trim();
		logger.info("获取到的文件主键为:"+archiveFileId);
		ArchiveFile archiveFile=new ArchiveFile();
		archiveFile.setArchiveFileId(archiveFileId);
		archiveFile.setArchiveFileAuthenticateStatus("3");
		archiveFile.setArchiveFileFinishingStatus("3");
		archiveFile.setFinishingTime(new Date());
		archiveFile.setCollator(HavingUserInfor.havingUser().getUserName());
		if(identificationService.updateArchiveFileById(archiveFile)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 将文件拖动到待整理中改变文件的状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateFileStatus2",method= {RequestMethod.POST, RequestMethod.GET})
	public Boolean updateFileStatus2(HttpServletRequest request) {
		String archiveFileId=request.getParameter("archiveFileId").trim();
		logger.info("获取到的文件主键为:"+archiveFileId);
		ArchiveFile archiveFile=new ArchiveFile();
		archiveFile.setArchiveFileId(archiveFileId);
		archiveFile.setArchiveFileAuthenticateStatus("2");
		archiveFile.setArchiveFileFinishingStatus("2");
		archiveFile.setFinishingTime(new Date());
		archiveFile.setCollator(HavingUserInfor.havingUser().getUserName());
		if(identificationService.updateArchiveFileById(archiveFile)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 点保存按钮给文件赋予属性
	 * @param archiveFile
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/updateArchiveFile",method= {RequestMethod.POST, RequestMethod.GET})
	public Integer updateArchiveFile(AmCoArchivefile amcoArchivefile) throws Exception {
		Integer result=null;
		amcoArchivefile.setFinishingTime(new Date());
		String userName = HavingUserInfor.havingUser().getUserName();
		logger.info("获取到的用户名为:"+userName);
		amcoArchivefile.setCollator(userName);
		Integer countFile = identificationService.countFileByStatus(amcoArchivefile);
		if(countFile == 0) {
			amcoArchivefile.setSignNumber(1);
			result = identificationService.updateArchiveFile(amcoArchivefile);
		}else if(countFile > 0){
			amcoArchivefile.setSignNumber(1+identificationService.queryMax(amcoArchivefile));
			result = identificationService.updateArchiveFile(amcoArchivefile);
		}
		List<FileAttachment> queryAttachmentImgList=identificationService.queryAttachmentImgList(amcoArchivefile.getArchivefileid());
		SealTools sealtools = new SealTools();
		for (int i = 0; i < queryAttachmentImgList.size(); i++) {
			System.out.println(queryAttachmentImgList.get(i).getFileAttachmentPath().replace("/resource", "D:/file"));
			
			sealtools.addPageArchiveFile(queryAttachmentImgList.get(i).getFileAttachmentPageNumber(), queryAttachmentImgList.get(i).getFileAttachmentPath().replace("/resource", "D:/file"));
		}
		
		
		return result;
		
	}
	
	
	/**
	 * 根据文件主键查询文件信息
	 * @param archiveFileId
	 * @return
	 */
	@RequestMapping(value="/queryArchiveFileById",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFile queryArchiveFileById(@RequestParam("archiveFileId") String archiveFileId) {
		ArchiveFile archiveFile=identificationService.queryArchiveFileById(archiveFileId);
		return archiveFile;
	}
	/**
	 *  根据文件年度和全宗查找返回上一件文件的附件图片信息
	 * @param archiveFileAnual
	 * @param quanzongId
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/previousOneQuery",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<FileAttachment> previousOneQuery(@RequestParam("archiveFileAnual") String archiveFileAnual,
			@RequestParam("quanzongId") String quanzongId) throws Exception{
		AmCoArchivefile amcoArchivefile=new AmCoArchivefile();
		amcoArchivefile.setArchivefileanual(archiveFileAnual);
		amcoArchivefile.setQuanzongid(quanzongId);
		return identificationService.previousOneQuery(amcoArchivefile);
	}
	
	/**
	 * 返回上一件修改整理状态和鉴定文件状态
	 */
	@ResponseBody
	@RequestMapping(value="/updateFileByStatus",method= {RequestMethod.POST, RequestMethod.GET})
	public Integer updateFileByStatus(AmCoArchivefile amcoArchivefile) throws Exception {
		Integer result=null;
		amcoArchivefile.setFinishingTime(new Date());
		result=identificationService.updateFileByStatus(amcoArchivefile);
		if(result>0) {
			logger.info("文件状态修改成功!");
		}else {
			logger.info("文件状态修改失败!");
		}
		return result;
	}
	/**
	 * 统计文件为整理中还是已全部整理完成的个数
	 * @param archiveFileAnual
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryFileByAnual",method= {RequestMethod.POST, RequestMethod.GET})
	public Integer queryFileByAnual(@RequestParam("archiveFileAnual") String archiveFileAnual){
		 Integer result=null;
		 Integer result1=identificationService.countFileByAnual(archiveFileAnual);
		 Integer countFileByStatus=identificationService.countFile(archiveFileAnual);
		if(countFileByStatus==0) {
			logger.info("文件还在整理中");
			result=0;
		}else if(countFileByStatus<result1) {
			logger.info("文件还未全部整理完成");
			result=1;
		}else if(countFileByStatus==result1) {
			logger.info("文件已全部整理完成");
			result=2;
		}
		return result;
	}
	/**
	 * 文件附件查询
	 */
	@ResponseBody
	@RequestMapping(value="/queryFileAttachmentById",method= {RequestMethod.POST, RequestMethod.GET})
	public List<FileAttachment> queryFileAttachmentById(@RequestParam("archiveFileId") String archiveFileId
			) throws Exception{
		return identificationService.queryFileAttachmentById(archiveFileId);
	}
	
	 
	 
	 
	 
	
	
	
	

}
