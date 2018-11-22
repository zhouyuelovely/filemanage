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
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.OrganizationService;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;

/**
 * @author MLT
 * 系统管理_机构管理模块
 */
@Controller
@RequestMapping("/org")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private MessageNotificationService messageNotificationService;
	/**
	 * 编辑机构
	 * @param request
	 * @param organization
	 * @return
	 */
	@RequestMapping(value = "/updateOneOrg", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer updateOneOrg(Organization organization) {
		Integer result = null;
		organizationService.updateOneOrganization(organization);
		result = 6;
		return result;
	}

	/**
	 * 添加、修改机构
	 * @param organization
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOneOrganization", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer addOneOrganization(Organization organization,HttpServletRequest request) throws Exception {
		String organizationCreatetime = request.getParameter("organizationCreatetime");
		organization.setOrganizationCreatetime(organizationCreatetime);
		Integer result = null;
		int isExitOrgCode = organizationService.isExitOrgCode(organization);//判断是同一全宗下是否存在相同机构代码
		int isExitOrgName = organizationService.isExitOrgName(organization);//判断是同一全宗下是否存在相同机构名称
		int isExitOrgPhone = organizationService.isExitOrgPhone(organization);//判断是否存在相同机构电话
		int scCodeName=organizationService.isExitSecondryCode(organization);//
		 int scName=organizationService.isExitSecondryName(organization);//
		if (isExitOrgCode > 0) {
			System.out.println("机构代码已存在");
			result = 1;
		} else if (isExitOrgName > 0) {
			System.out.println("该机构已存在");
			result = 2;
		}else if(isExitOrgPhone > 0){
			System.out.println("机构电话已存在");
			result = 3;
		}else if(scCodeName > 0 && scName > 0){
			organizationService.addOneOrganization(organization);//添加机构
			result = 4;
		}else if(scCodeName == 0 && scName == 0){
			organizationService.addOneOrganization(organization);//添加机构
			organizationService.addSecondry(organization);//添加二级分类
			result = 5;
		}else if(organization.getOrganizationId() != null && organization.getOrganizationId() != ""){
			organizationService.updateOneOrganization(organization);
			result = 6;
		}else {
			result = 7;
		}
		return result;
	}

	/**
	 * 根据机构主键查询机构信息
	 * @param organizationId
	 * @return
	 */
	@RequestMapping(value = "/queryOrganizationById", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Organization queryOrganizationById(@RequestParam("organizationId") String organizationId) {
		Organization organization = organizationService.queryOrganizationById(organizationId);
		return organization;
	}

	/**
	 * 删除机构
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping(value = "/deleteOneOrganization", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean deleteOneOrganization(@RequestParam("organizationId") String organizationId) {
		Boolean result =null;
		int countOrgLinkInfo = organizationService.countOrgLinkInfo(organizationId);
		if (countOrgLinkInfo ==0) {
			result =  organizationService.deleteOneOrganization(organizationId);
		} else {
			return false;
		}
		return result;
	}

	/**
	 * 机构列表显示
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgListShow", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView orgListShow(String quanzongId) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = HavingUserInfor.havingUser();
		List<Organization> orgListShow = organizationService.selectAllOrganization();
		mv.addObject("user", user);
		mv.addObject("archiveId", organizationService.listAchiveId(quanzongId));
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("orgListShow", orgListShow);
		mv.setViewName("/archiveManage/organizationaManage");// 跳转到机构管理展示页面
		for (Organization organization : orgListShow) {
			System.out.println(organization);
		}
		return mv;
	}

	/**
	 * 机构列表数据渲染
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping("/orgManageList")
	@ResponseBody
	public Layui orgManagementList(String quanzongId) {
		List<Organization> orgList = organizationService.queryOrganizationByQuanzongId(quanzongId);
		for (Organization organization : orgList) {
			System.out.println(organization);
		}
		int getAllOrganization = organizationService.countAllOrganization(quanzongId);
		System.out.println(getAllOrganization);
		return Layui.data(getAllOrganization, orgList);
	}

	/**
	 * 根据关键词查询机构信息(机构号、机构名)
	 * @param currentPage
	 * @param archiveQueryConditions
	 * @return
	 */
	@RequestMapping(value = "/searchOrgByConditions", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui searchOrgByConditions(HttpServletRequest request,Organization organization) {
		String conditions = request.getParameter("conditions");
		System.out.println(conditions);
		int countOrgByConditions = organizationService.countOrgByConditions(conditions);
		System.out.println(countOrgByConditions);
		List<Organization> searchOrgByConditions = organizationService
				.queryOrganizationByOrganizationQueryCondition(organization);
		return Layui.data(countOrgByConditions, searchOrgByConditions);
	}

	// 下载模板
	@RequestMapping(value = "/downloadTemplate")
	public void fileDownlosd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("filename") String filename) throws Exception {
		// 生成模版
		produceOrganization(request, filename);
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
		String quanzongId = request.getParameter("quanzongId");
		String path = request.getSession().getServletContext().getRealPath("excelFile");
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);

		List<List<Object>> list = ExportExcel.readExcel(path + "/" + fileName);
		Organization organization = null;

		Boolean result = false;
		for (List<Object> listObj : list) {
			
			organization = new Organization();
			organization.setQuanzongId(quanzongId);
			organization.setOrganizationCode(listObj.get(0).toString());
			organization.setOrganizationName(listObj.get(1).toString());
			organization.setOrganizationPhone(listObj.get(2).toString());
			organization.setOrganizationCreatetime(listObj.get(3).toString());
			int isExitOrgName = organizationService.isExitOrgName(organization);
			if(isExitOrgName > 0){
				result = true;
			}else{
				Boolean isExit = organizationService.addOneOrganization(organization);
				if(isExit){
					result = true;
				}else{
					result = false;
				}
			}
		}
		System.out.println("====================="+quanzongId);
		
		mv.addObject(result);
		mv.addObject("list", list);
		mv.addObject("archiveId", organizationService.listAchiveId(quanzongId));
		mv.setViewName("archiveManage/organizationaManage");// 跳转至机构展示展示页面
		return mv;
	}

	// excel模板
	public void produceOrganization(HttpServletRequest request, String filename) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		String fileName = "机构模板";
		String[] archiveOutFilt = { "机构代码", "机构名称", "机构电话", "创建日期" };
		List<List> list = new ArrayList<List>();
		ExportExcel.createExcel(path, fileName, archiveOutFilt, list);
	}
}
