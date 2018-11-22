package filemanage.systemmanage.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.OrganizationService;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;

/**
 * @author MLT
 *
 */
@Controller
@RequestMapping("/archive")
public class ArchiveController {
	/**
	 * 系统管理_全宗管理模块
	 */
	

	@Autowired
	private ArchiveService archiveService;

	@Autowired
	private OrganizationService orgService;
	
	@Autowired
	private MessageNotificationService messageNotificationService;

	/**
	 * 添加、修改全宗
	 * 
	 * @param archive
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOneArchive", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer adupOneArchive(Archive archive, HttpServletRequest request) throws Exception {
		String quanzongCreatetime = request.getParameter("quanzongCreatetime");
		archive.setQuanzongCreatetime(quanzongCreatetime);
		Integer result = null;
		int isExitArchiveNumber = archiveService.isExitArchiveNumber(archive);
		int isExitArchiveName = archiveService.isExitArchiveName(archive);
		int isExitArchivePhone = archiveService.isExitArchivePhone(archive);
		if (isExitArchiveNumber > 0) {
			System.out.println("全宗号已存在");
			result = 1;
		} else if (isExitArchiveName > 0) {
			System.out.println("该全宗已存在");
			result = 2;
		} else if (isExitArchivePhone > 0) {
			System.out.println("单位电话已存在");
			result = 3;
		} else if (archive.getQuanzongId() != null && archive.getQuanzongId() != "") {
			archiveService.updateOneArchive(archive);
			result = 4;
		} else {
			archiveService.addOneArchive(archive);
			result = 5;
		}
		return result;
	}

	@RequestMapping(value="/updateOneArchive", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer updateOneArchive(Archive archive) {
		Integer result = null;
		archiveService.updateOneArchive(archive);
		result = 3;
		return result;
	}

	/**
	 * 根据全宗主键查询全宗信息
	 * 
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping(value = "/queryArchiveById", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Archive queryArchiveById(@RequestParam("quanzongId") String quanzongId) {
		Archive archive = archiveService.queryArchiveById(quanzongId);
		return archive;
	}

	/**
	 * 删除全宗(删除前先查询全宗有没有机构或者是用户，有则不能删；没有，则可以删)
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping(value = "/deleteOneArchive", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean deleteOneArchive(@RequestParam("quanzongId") String quanzongId) {
		Boolean result = null;
		int countArchiveLinkInfo = archiveService.countArchiveLinkInfo(quanzongId);
		if (countArchiveLinkInfo == 0) {
			result = archiveService.deleteOneArchive(quanzongId);
		}else{
			return false;
		}
		return result;
	}

	/**
	 * 根据全宗主键查询机构信息
	 * 
	 * @param request
	 * @param response
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping(value = "/selectOrgByArchiveId", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView selectOrgByArchiveId(HttpServletRequest request, HttpServletResponse response,
			String quanzongId) {
		quanzongId = request.getParameter("quanzongId");
		System.out.println(quanzongId);
		List<Organization> listOrg = orgService.queryOrganizationByQuanzongId(quanzongId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOrg", listOrg);
		mv.addObject("quanzongId", quanzongId);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/archiveManage/organizationaManage");// 跳转到机构管理页面
		return mv;
	}

	/**
	 * 全宗列表显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/archiveListShow", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView archiveManageList() throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = HavingUserInfor.havingUser();
		List<Archive> archiveManagementList = archiveService.selectAllArchive();
		mv.addObject("archiveManagementList", archiveManagementList);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/archiveManage/archiveManage");// 跳转到全宗管理展示页面
		for (Archive archive : archiveManagementList) {
			System.out.println(archive);
		}
		return mv;
	}

	/**
	 * 全宗列表数据渲染
	 * 
	 * @return
	 */
	@RequestMapping("/archiveManageList")
	@ResponseBody
	public Layui archiveManagementList() {
		List<Archive> archiveList = archiveService.selectAllArchive();
		int getAllArchive = archiveService.countAllArchive();
		System.out.println(getAllArchive);
		return Layui.data(getAllArchive, archiveList);
	}

	/**
	 * 根据关键词查询全宗信息(全宗号、全宗名)
	 * 
	 * @param request
	 * @param archiveQueryConditions
	 * @return
	 */
	@RequestMapping(value = "/searchArchiveByConditions", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui searchArchiveByConditions(HttpServletRequest request, Archive archive) {
		String conditions = request.getParameter("conditions");
		System.out.println(conditions);
		int countArchiveByConditions = archiveService.countArchiveByConditions(conditions);
		System.out.println(countArchiveByConditions);
		List<Archive> searchArchiveByCondition = archiveService
				.queryArchiveByArchiveQueryCondition(archive);
		return Layui.data(countArchiveByConditions, searchArchiveByCondition);
	}

	// 下载模板
	@RequestMapping(value = "/downloadTemplate")
	public void fileDownlosd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("filename") String filename) throws Exception {
		// 生成模版
		produceArchive(request, filename);
		// 获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
		String fileName = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}

	// 读取excel
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam("excelName") MultipartFile file, HttpServletRequest request,
			HttpSession session) throws Exception, ClassCastException {
		ModelAndView mv = new ModelAndView();
		String path = request.getSession().getServletContext().getRealPath("excelFile");
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);

		List<List<Object>> list = ExportExcel.readExcel(path + "/" + fileName);
		Archive archive = null;
		
		Boolean result = false;
		for (List<Object> listObj : list) {
			archive = new Archive();
			archive.setQuanzongNumber(listObj.get(0).toString());
			archive.setQuanzongName(listObj.get(1).toString());
			archive.setQuanzongPhone(listObj.get(2).toString());
			archive.setQuanzongCreatetime(listObj.get(3).toString());
			//int isExitArchiveNumber = archiveService.isExitArchiveNumber(archive);
			int isExitArchiveName = archiveService.isExitArchiveName(archive);
			if(isExitArchiveName > 0){
				result =  true;
			}else{
				Boolean isExit = archiveService.addOneArchive(archive);
				if(isExit){
					result = true;
				}else{
					result = false;
				}
			}
			//
		}
		
		
		mv.addObject(result);
		mv.addObject("list", list);
		mv.setViewName("/archiveManage/archiveManage");// 跳转至全宗展示展示页面
		return mv;
	}

	// excel模板
	public void produceArchive(HttpServletRequest request, String filename) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		String fileName = "全宗模板";
		String[] archiveOutFilt = { "全宗号", "全宗名", "单位电话", "创建日期" };
		List<List> list = new ArrayList<List>();
		ExportExcel.createExcel(path, fileName, archiveOutFilt, list);
	}

}
