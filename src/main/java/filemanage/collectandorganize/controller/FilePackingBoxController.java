package filemanage.collectandorganize.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import filemanage.collectandorganize.service.ArchiveFileStoreService;
import filemanage.collectandorganize.service.FilePackingBoxService;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.CartoningFunctionDataVoForm;
import filemanage.collectandorganize.vo.ExcelFrom;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmCoBoxProperty;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.FileCustomizationFileBoxService;
import filemanage.systemmanage.service.FileCustomizationTermOfCustodyService;
import filemanage.systemmanage.service.UserService;
import filemanage.utils.GenerateRuleFormulateTool;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;

/**
 * 档案整理	 >>	       文件装盒页面
 * @author 陈一达
 * controller层
 */
@Controller
@RequestMapping("/FilePackingBoxController")
public class FilePackingBoxController {

	@Autowired
	private FilePackingBoxService fpbs;
	@Autowired
	private FileCustomizationFileBoxService fcfbs;
	@Autowired
	private UserService service;
	@Autowired
	private ArchiveService as;
	@Autowired
	private FileCustomizationTermOfCustodyService fctoc;
	@Autowired
	private ArchiveFileStoreService archiveFileStoreService;
	
	@RequestMapping(value = "/modelAndView",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView modelAndView(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		//用户表
		User user = new User();
		//全宗表
		Archive archive = new Archive();
		//登陆用户的全宗
		user.setUserId(HavingUserInfor.havingUser().getUserId());
		archive.setQuanzongId(HavingUserInfor.havingArchiveId());
		user.setArchive(archive);
		user.setQuanzongId(user.getArchive().getQuanzongId());
		map.put("quanzongid", user.getQuanzongId());
		AmCoBoxProperty amcoboxpropert = new AmCoBoxProperty();
		List<User> userList=service.queryUserAllManager(user);
		List<AmCoArchivefile> filePackingBoxAnnualQueryList = fpbs.filePackingBoxAnnualQuery(map);
		List<AmCoBoxProperty> AmCoBoxPropertyList =  fcfbs.queryBoxProperties(amcoboxpropert);
		
		//查询该用户所属全宗名称
		mv.addObject("userList",userList);
		//查询该全宗下的年度查询
		mv.addObject("filePackingBoxAnnualQueryList",filePackingBoxAnnualQueryList);
		//查询盒子属性
		mv.addObject("AmCoBoxPropertyList",AmCoBoxPropertyList);
		mv.setViewName("/archiveManage/file_boxes");
		return mv;
	}
	/**
	 * 该全宗下的年度下的保管期限查询
	 * @param request
	 * @param response
	 * @param archivefileanual
	 * @return
	 */
	@RequestMapping("/filePackingBoxsafekeepingTermQuery")
	@ResponseBody
	public List<AmCoArchivefile> filePackingBoxsafekeepingTermQuery(HttpServletRequest request,HttpServletResponse response){
		//全宗ID
		String quanzongId = request.getParameter("quanzongId");
		//年度
		String archivefileanual = request.getParameter("archivefileanual");
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongid", quanzongId);
		map.put("archivefileanual", archivefileanual);
		List<AmCoArchivefile> filePackingBoxsafekeepingTermQueryList = fpbs.filePackingBoxsafekeepingTermQuery(map);
		return filePackingBoxsafekeepingTermQueryList;
		
	}
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类查询
	 * @param request
	 * @param response
	 * @param archivefileanual
	 * @return
	 */
	@RequestMapping("/filePackingBoxArchivesPrimaryQuery")
	@ResponseBody
	public List<AmCoArchivefile> filePackingBoxArchivesPrimaryQuery(HttpServletRequest request,HttpServletResponse response){
		//全宗ID
		String quanzongId = request.getParameter("quanzongId");
		//年度
		String archivefileanual = request.getParameter("archivefileanual");
		//保管期限
		String retentionperiodid = request.getParameter("retentionperiodid");
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongid", quanzongId);
		map.put("archivefileanual", archivefileanual);
		map.put("retentionperiodid", retentionperiodid);
		List<AmCoArchivefile> filePackingBoxArchivesPrimaryQueryList = fpbs.filePackingBoxArchivesPrimaryQuery(map);
		return filePackingBoxArchivesPrimaryQueryList;
		
	}
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询
	 * @param request
	 * @param response
	 * @param archivefileanual
	 * @return
	 */
	@RequestMapping("/filePackingBoxArchiveSsecondaryQuery")
	@ResponseBody
	public List<AmCoArchivefile> filePackingBoxArchiveSsecondaryQuery(HttpServletRequest request,HttpServletResponse response){
		//全宗ID
		String quanzongId = request.getParameter("quanzongId");
		//年度
		String archivefileanual = request.getParameter("archivefileanual");
		//保管期限
		String retentionperiodid = request.getParameter("retentionperiodid");
		//一级分类主键
		String primaryclassificationid = request.getParameter("primaryclassificationid");
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongid", quanzongId);
		map.put("archivefileanual", archivefileanual);
		map.put("retentionperiodid", retentionperiodid);
		map.put("retentionperiodid", retentionperiodid);
		map.put("primaryclassificationid", primaryclassificationid);
		List<AmCoArchivefile> filePackingBoxArchiveSsecondaryQueryList = fpbs.filePackingBoxArchiveSsecondaryQuery(map);
		return filePackingBoxArchiveSsecondaryQueryList;
		
	}
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)
	 * @param request
	 * @param response /FilePackingBoxController/filePackingBoxALLQuery
	 * @param archivefileanual
	 * @return 
	 */ 
	@RequestMapping("/filePackingBoxALLQuery")
	@ResponseBody
	public Layui filePackingBoxALLQuery(HttpServletRequest request,HttpServletResponse response){
		//档号生成规则工具类
		GenerateRuleFormulateTool grft = new GenerateRuleFormulateTool();
		//全宗ID
		String quanzongId = request.getParameter("quanzongId");
		//年度
		String archivefileanual = request.getParameter("archivefileanual");
		//保管期限
		String retentionperiodid = request.getParameter("retentionperiodid");
		//一级分类主键
		String primaryclassificationid = request.getParameter("primaryclassificationid");
		//二级分类主键
		String secondaryclassificationid = request.getParameter("secondaryclassificationid");
		//关键字参数
		String archivefilefilenumber = request.getParameter("keyWord");
		
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongid", quanzongId);
		map.put("archivefileanual", archivefileanual);
		map.put("retentionperiodid", retentionperiodid);
		map.put("secondaryclassificationid", secondaryclassificationid);
		map.put("primaryclassificationid", primaryclassificationid);
		map.put("archivefilefilenumber", archivefilefilenumber);
		Integer countFile = fpbs.countArchivefilePages(map);
		request.getSession().setAttribute("countFile",countFile);
		return grft.filePackingBoxALLQuery(map, fpbs, archivefilefilenumber, secondaryclassificationid, request);
	}
	
	/**
	 * 根据盒主键查询盒的信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/boxPrimaryKeyQuery")
	@ResponseBody
	public List<AmCoBoxProperty> boxPrimaryKeyQuery(HttpServletRequest request,HttpServletResponse response) {
		String boxpropertyid = request.getParameter("boxpropertyid");
		//档号生成规则工具类
		GenerateRuleFormulateTool grft = new GenerateRuleFormulateTool();
		return grft.boxPrimaryKeyQuery(boxpropertyid, fcfbs, request);
		
	}
	
	/**
	 * 给文件添加盒子主键操作
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateFilePackingBox")
	@ResponseBody
	public String updateFilePackingBox(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<ExcelFrom> listDatas ) {
		//档号生成规则工具类
		GenerateRuleFormulateTool grft = new GenerateRuleFormulateTool();
		return grft.updateFilePackingBox(listDatas, fpbs, request);
	}
	
	/**
	 * 装盒功能
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/cartoningFunction")
	@ResponseBody
	public Boolean cartoningFunction(HttpServletRequest request,HttpServletResponse response,
			@RequestBody CartoningFunctionDataVoForm cartoningFunctionData
			) {
		GenerateRuleFormulateTool generateruleformulatetool = new GenerateRuleFormulateTool();
		return generateruleformulatetool.cartoningFunction(cartoningFunctionData, fcfbs, fpbs, fctoc, request, as);
				 
	}

	/**
	 * 根据文件编号跟新备注
	 * @return
	 */
	@RequestMapping("/updateArchivefileremark")
	@ResponseBody
	public Integer updateArchivefileremark(HttpServletRequest request,HttpServletResponse response) {
		String archivefileid = request.getParameter("archivefileid");
		String archivefileremark = request.getParameter("archivefileremark");
		AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
		amcoarchivefile.setArchivefileid(archivefileid);
		amcoarchivefile.setArchivefileremark(archivefileremark);
		return fpbs.updateArchivefileremark(amcoarchivefile);
		
	}
	
}
