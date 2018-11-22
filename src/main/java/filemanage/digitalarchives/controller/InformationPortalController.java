package filemanage.digitalarchives.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import filemanage.digitalarchives.pojo.InformationPortal;
import filemanage.digitalarchives.pojo.Picturecarousel;
import filemanage.digitalarchives.service.InformationPortalService;
import filemanage.digitalarchives.vo.QueryInforByConditions;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.layui.Layui;

/**
 * @author tchuanwu 档案信息门户控制层
 */
@Controller
@RequestMapping("information")
@Component
public class InformationPortalController {

	@Autowired
	private  InformationPortalService informationPortalService;

	private  Logger logger = Logger.getLogger(InformationPortalController.class);

	private  User user;


	/**
	 * 跳转到数字档案馆首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/godigitalarchives")
	public ModelAndView godigitalarchives() {
		ModelAndView mv = new ModelAndView();
		List<InformationPortal> listInformation = informationPortalService.queryInfomationByTime();
		mv.addObject("listInformation", listInformation);
		mv.setViewName("/digitalarchives/digitalarchives");
		return mv;
	}

	/**
	 * 跳转到档案信息门户页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goarchivalInformation")
	public ModelAndView goarchivalInformation() {
		ModelAndView mv = new ModelAndView();
		List<InformationPortal> listIPType = informationPortalService.queryAllInformationType();
		for (InformationPortal informationPortal : listIPType) {
			logger.info("档案类型有===============>" + informationPortal.getiPType());
		}
		List<InformationPortal> listInformation = informationPortalService.queryInfomationByTime();
		user = HavingUserInfor.havingUser();
		logger.info("获取到的用户信息为:" + user);
		mv.addObject("user", user);
		mv.addObject("listInformation", listInformation);
		mv.addObject("listIPType", listIPType);
		List<Picturecarousel> listpc=informationPortalService.queryAllPicture();
		Integer listcount=listpc.size();
		mv.addObject("listpc", listpc);
		mv.addObject("listcount", listcount);
		mv.setViewName("/digitalarchives/archivalInformation");
		return mv;
	}

	/**
	 * 跳转到档案信息门户查看页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goarchivaldetail", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView goarchivaldetail(@RequestParam("iPId") String iPId) {
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		logger.info("获取到的用户信息为=====>" + user);
		mv.addObject("user", user);
		InformationPortal information = informationPortalService.queryInformationById(iPId);
		logger.info("根据信息主键获取到的档案信息为:=============" + information);
		mv.addObject("information", information);
		mv.setViewName("/digitalarchives/archivaldetail");
		return mv;
	}

	/**
	 * layui数据渲染
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryAllArchivalInformation", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryAllArchivalInformation(int page, int limit) {
		int before = limit * (page - 1);
		int after = page * limit;
		List<InformationPortal> listIP = informationPortalService.queryAllInformation(before, after);
		
		int countAllInformation = informationPortalService.countAllInformation();
		return Layui.data(countAllInformation, listIP);
	}

	/**
	 * 关键词条件查询
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryInforByConditions", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryInforByConditions(int page,int limit,HttpServletRequest request) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		Date iPFormDate=StrToDate(request.getParameter("iPFormDate"));
		String iPType=request.getParameter("iPType");
		String queryConditions=request.getParameter("queryConditions");
		QueryInforByConditions conditions=new QueryInforByConditions();
		conditions.setiPFormDate(iPFormDate);
		conditions.setiPType(iPType);
		conditions.setQueryConditions(queryConditions);
		conditions.setBefore(before);
		conditions.setAfter(after);
		List<InformationPortal> queryInforByConditions=informationPortalService.queryInforByConditions(conditions);
		Integer countQueryInforByConditions=informationPortalService.countQueryInforByConditions(conditions);
		return Layui.data(countQueryInforByConditions, queryInforByConditions);
	}
	
	/** 
	* 字符串转换成日期 
	* @param str 
	* @return date 
	*/ 
	public static Date StrToDate(String str) { 
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	   Date date = null; 
	   try { 
	    date = format.parse(str); 
	   } catch (ParseException e) { 
	    e.printStackTrace(); 
	   } 
	   return date; 
	} 

	/**
	 * 跳转到档案信息门户信息发布页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goarchivalInfofabu")
	public ModelAndView goarchivalInfofabu() {
		ModelAndView mv = new ModelAndView();
		Integer countAllPic=informationPortalService.countAllPic();
		mv.addObject("countAllPic", countAllPic);
		mv.setViewName("/digitalarchives/archivalfabu");
		return mv;
	}

	/**
	 * 添加信息
	 * 
	 * @param information
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/addInformation", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public  Integer addInformation(InformationPortal information, HttpServletRequest request) throws Exception {
		user = HavingUserInfor.havingUser();
		String iPForm=request.getParameter("iPForm");
		if(iPForm=="直接发布") {
			long l = System.currentTimeMillis();
			Date date=new Date(l);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   information.setiPFormDate(sdf.parse(sdf.format(date)));
		}else if(iPForm=="定期发布") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date iPFormDate= sdf.parse(request.getParameter("iPFormDate"));
			information.setiPFormDate(iPFormDate);
		}
		
		information.setiPStatus("2");
		information.setiPPerson(user.getUserName());
		Integer result = null;
		int isExitInformationIndexNum = informationPortalService.isExitInformationIndexNum(information);
		int isExitInformationDocumentNum = informationPortalService.isExitInformationDocumentNum(information);
		if (isExitInformationIndexNum > 0) {
			logger.info("该索引号已存在");
			result = 1;
		} else if (isExitInformationDocumentNum > 0) {
			logger.info("该文号已存在");
			result = 2;
		} else if (informationPortalService.addInformationPortal(information) > 0) {
			logger.info("恭喜你,信息发布成功");
			result = 3;
		} else {
			logger.info("对不起,信息发布失败");
			result = 4;
		}
		return result;
	}
	
	/**
	 * 定时发布文章
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/insertInformation", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer insertInformation(InformationPortal information,HttpServletRequest request) throws Exception {
		user = HavingUserInfor.havingUser();
		Integer result=null;
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date iPFormDate= sdf.parse(request.getParameter("iPFormDate"));
			information.setiPFormDate(iPFormDate);
			information.setiPStatus("2");
			information.setiPPerson(user.getUserName());
			int isExitInformationIndexNum = informationPortalService.isExitInformationIndexNum(information);
			int isExitInformationDocumentNum = informationPortalService.isExitInformationDocumentNum(information);
			// 首次运行时间
			Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
			long l = System.currentTimeMillis();
			System.out.println(l);
			System.out.println(startTime.getTime());
			if(l>startTime.getTime()) {
				startTime = iPFormDate;
				Timer t = new Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						if(informationPortalService.addInformationPortal(information)>0) {
							logger.info("恭喜你,信息发布成功!");	
						}else if(isExitInformationIndexNum>0) {
							logger.info("该索引号已存在");
						}else if(isExitInformationDocumentNum>0) {
							logger.info("该文号已存在");
						}
					}	
				};
				t.scheduleAtFixedRate(task, startTime, l);
				result=1;
			}

		return result;
	}
	
	

	/**
	 * 一次上传多张图片
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean threeFileUpload(@RequestParam("file") CommonsMultipartFile files[], HttpServletRequest request)
			throws Exception {
		informationPortalService.deleteAllFile();
		Boolean result=false;
		// 上传位置
		String path = "D:/file/fileupload/";// 设定文件保存的目录
		String pathFileName = null;
		List<String> list = new ArrayList<String>();
		list.add(request.getParameter("PcUrlOne"));
		list.add(request.getParameter("PcUrlTwo"));
		list.add(request.getParameter("PcUrlThree"));
		list.add(request.getParameter("PcUrlFour"));
		list.add(request.getParameter("PcUrlFive"));
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		for (int i = 0; i < files.length; i++) {
			// 获得原始文件名
			String fileName = files[i].getOriginalFilename();
			// 新文件名
			String newFileName = UUID.randomUUID() + fileName;
			pathFileName = path + newFileName;
			logger.info("新文件名称:" + newFileName);
			if (!files[i].isEmpty()) {
				try {
					FileOutputStream fos = new FileOutputStream(path + newFileName);
					InputStream in = files[i].getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}
					fos.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result=addPicturecarousel(request, pathFileName, list.get(i));
		}
		return result;
	}

	private Boolean addPicturecarousel(HttpServletRequest request, String pathFileName, String pcUrl) throws Exception {
		Boolean bool = false;
		String pcPerson = HavingUserInfor.havingUser().getUserName();
		Picturecarousel picturecarousel = new Picturecarousel();
		picturecarousel.setPcPhotoAddress(pathFileName);
		picturecarousel.setPcUrl(pcUrl);
		picturecarousel.setPcTime(new Date());
		picturecarousel.setPcPerson(pcPerson);
		System.out.println("---picturecarousel:" + picturecarousel);
		bool = informationPortalService.addPicturecarousel(picturecarousel) > 0;
		if (bool) {
			logger.info("添加轮播图片信息成功!");
		} else {
			logger.error("添加轮播图片信息失败!");
		}
		return bool;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
