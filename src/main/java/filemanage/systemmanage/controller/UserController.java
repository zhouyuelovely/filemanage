package filemanage.systemmanage.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import filemanage.systemmanage.pojo.Role;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.OrganizationService;
import filemanage.systemmanage.service.RoleManagementService;
import filemanage.systemmanage.service.UserService;
import filemanage.utils.DeleteFile;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;
import filemanage.utils.md5.MD5;
/**
 * @author tchuanwu
 * 用户管理控制层
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ArchiveService archiveService;
	@Autowired
	private OrganizationService orgService;
	@Autowired
	private RoleManagementService roleManagementService;
	@Autowired
	private MessageNotificationService messageNotificationService;
	
	private Logger logger=Logger.getLogger(UserController.class);
	
	
	/**
	 * 跳转到用户管理页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/getUserList",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView userList() throws Exception {
		ModelAndView mv=new ModelAndView();
		User user = HavingUserInfor.havingUser();
		List<Archive> archiveList=archiveService.selectAllArchive();
		Integer countID = archiveList.size();
		mv.addObject("countID",countID);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/userManage/userManage");
		return mv;
	}
	/**
	 * layui渲染数据
	 * @return
	 */
	@RequestMapping(value="/getAllUser",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui getUserList(int page, int limit) {
		 int before = limit * (page-1);  
         int after = page * limit; 
		List<User> userList=userService.queryAllUser(before,after);
		int countAllUser=userService.countAllUser();
		System.out.println(countAllUser);
		return Layui.data(countAllUser, userList);
	}
	/**
	 * 遍历所有的全宗名称
	 * @return
	 */
	@RequestMapping(value="/archiveLists",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Archive> archiveLists() throws Exception{
		List<Archive> archiveList=archiveService.selectAllArchive();
		return archiveList;
	}
	
	/**
	 * 遍历所有角色
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/RoleLists",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Role> RoleLists() throws Exception {
		List<Role> roleList=roleManagementService.listRole();
		return roleList;
	}
	
	/**
	 * 根据全宗主键查询部门信息
	 * @param request
	 * @param quanzongId
	 * @return
	 */
	@RequestMapping(value="/selectOrgByQuanzongId",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Organization> selectOrgByQuanzongId(HttpServletRequest request,@RequestParam("quanzongId")String quanzongId){
		//获取前段的所选中的一级菜单的参数
		List<Organization> listOrg=orgService.queryOrganizationByQuanzongId(quanzongId);
		for (Organization organization : listOrg) {
			System.out.println("---------------------->"+organization);
		}
		return listOrg;
	}
	
	/**
	 * 添加或修改用户
	 * @param userId
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/addOrUpdateUser",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addOrUpdateUser(HttpServletRequest request) throws Exception {
		String userName=request.getParameter("userName");
		String userSex=request.getParameter("userSex");
		String userIdNumber=request.getParameter("userIdNumber");
		String quanzongId=request.getParameter("quanzongId");
		String userTelePhone=request.getParameter("userTelePhone");
		String organizationId=request.getParameter("organizationId");
		String userWorkNumber=request.getParameter("userWorkNumber");
		String roleId=request.getParameter("roleId");
		 User user=new User();
		 user.setArchive(archiveService.queryArchiveById(quanzongId));//设置全宗信息
		 user.setOrg(orgService.queryOrganizationById(organizationId));//设置机构信息
		 user.setRole(roleManagementService.queryRoleById(roleId));//设置角色信息
		 user.setUserCreateTime(new Date());
		 user.setUserName(userName);
		 user.setUserSex(userSex);
		 user.setUserIdNumber(userIdNumber);
		 user.setUserTelePhone(userTelePhone);
		 user.setUserWorkNumber(userWorkNumber);
		 user.setQuanzongId(quanzongId);
		 user.setOrganizationId(organizationId);
		 user.setRoleId(roleId);
		 InetAddress addr = InetAddress.getLocalHost();
		 String userHostName=addr.getHostName();//获取操作用户的主机
		 String userIpAddress=addr.getHostAddress();//获取操作用户的ip地址
		 user.setUserHostName(userHostName);
		 user.setUserIpAddress(userIpAddress);
		 user.setUserType("1");
		 user.setUserPassword("123456");
		 Integer result=null;
		 int isExitUserName=userService.isExitUserName(user);
		 int isExitIdNumber=userService.isExitIdNumber(user);
		 int isExitTelPhone=userService.isExitTelPhone(user);
		 int isExitWorkNumber=userService.isExitWorkNumber(user);
		 if(isExitUserName>0) {
			 System.out.println("对不起,用户名已存在!");
			 result=1;
		 }else if(isExitIdNumber>0) {
			 System.out.println("对不起,身份证号已存在!");
			 result=2;
		 }else if(isExitTelPhone>0) {
			 System.out.println("对不起,手机号已存在!");
			 result=3;
		 }else if(isExitWorkNumber>0) {
			 System.out.println("对不起,工号已存在!");
			 result=4;
		 }else if(user.getUserId()!=null&& user.getUserId()!="") {
			userService.updateUser(user);
			result=5;
		}else {
			userService.addUser(user);
			result=6;
		}
		 return result;	
}
	
	/**
	 * 修改用户
	 * @param userId
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value="/UpdateUser",method= {RequestMethod.GET,RequestMethod.POST})	 
	@ResponseBody
	public Integer UpdateUser(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String userSex=request.getParameter("userSex");
		String userIdNumber=request.getParameter("userIdNumber");
		String quanzongId=request.getParameter("quanzongId");
		String userTelePhone=request.getParameter("userTelePhone");
		String organizationId=request.getParameter("organizationId");
		String userWorkNumber=request.getParameter("userWorkNumber");
		String roleId=request.getParameter("roleId");
		 User user=new User();
		 user.setArchive(archiveService.queryArchiveById(quanzongId));//设置全宗信息
		 user.setOrg(orgService.queryOrganizationById(organizationId));//设置机构信息
		 user.setRole(roleManagementService.queryRoleById(roleId));//设置角色信息
		 user.setUserId(userId);
		 user.setUserName(userName);
		 user.setUserSex(userSex);
		 user.setUserIdNumber(userIdNumber);
		 user.setUserTelePhone(userTelePhone);
		 user.setUserWorkNumber(userWorkNumber);
		 user.setQuanzongId(quanzongId);
		 user.setOrganizationId(organizationId);
		  user.setRoleId(roleId);
		   Integer result=userService.updateUser(user);
		   if(result>0) {
			   System.out.println("用户修改成功");
		   }else {
			   System.out.println("用户修改失败");
		   }
		   return result;

}
	
	/**
	 * 根据用户主键查询用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/queryUserById",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public User queryUserById(@RequestParam("userId") String userId) {
		User user=userService.queryUserById(userId);
		return user;
	}
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/deleteUserById",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Boolean deleteUserById(@RequestParam("userId") String userId) {
		if(userService.deleteUserById(userId)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 下载模板
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadTemplate")
	public void fileDownlosd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("filename") String filename) throws Exception {
		// 生成模版
		produce(request, filename);
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
	
	public void produce(HttpServletRequest request, String filename) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;
		String fileName = "用户模版";
		String[] userOutfit = { "序号","姓名", "性别", "身份证号", "手机号", "工号", "所属全宗", "所属部门","所属角色" };
		List<List> list = new ArrayList<List>();
		ExportExcel.createExcel(path, fileName, userOutfit, list);
	}
	
	/**
	 * 关键词查询用户
	 * @param conditions
	 * @return
	 */
	@RequestMapping(value="/queryUserByConditions",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public  Layui queryUserByConditions(HttpServletRequest request){
		String conditions=request.getParameter("conditions");
		System.out.println(conditions);
		int countUserByConditions=userService.countUserByConditions(conditions);
		System.out.println(countUserByConditions);
		List<User> listUser=userService.queryUserByConditions(conditions);
		return  Layui.data(countUserByConditions,listUser);
	}
	/**
	 * 重置用户密码
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/resetPassword",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Boolean resetPassword(String str) {
		logger.info("重置用户密码");
	   return userService.resetUserPassword(str);
	}
	
	/**
	 * 读取excel内容
	 * 
	 * @param file
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 * @throws ClassCastException
	 */

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public Integer uploadFile(@RequestParam("excelName") MultipartFile file, HttpServletRequest request) throws Exception, ClassCastException {
		String msg=null;
		Integer result=null;
		String path = request.getSession().getServletContext().getRealPath("excelFile");
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);
		List<List<Object>> list = ExportExcel.readExcel(path + "/" + fileName);
		for (List<Object> list2 : list) {
			User user=new User();
			user.setUserName(list2.get(1).toString());
			user.setUserSex(list2.get(2).toString());
			user.setUserIdNumber(list2.get(3).toString());
			user.setUserTelePhone(list2.get(4).toString());
			user.setUserWorkNumber(list2.get(5).toString());
			user.setQuanzongName(list2.get(6).toString());
			user.setOrganizationName(list2.get(7).toString());
			user.setRoleName(list2.get(8).toString());
			user.setUserType("1");
			user.setUserCreateTime(new Date());
			System.out.println(user.getUserName().toString()+"/"+user.getUserSex().toString()+"/"+user.getUserIdNumber().toString()+
					"/"+user.getUserTelePhone().toString()+"/"+user.getUserWorkNumber().toString()+"/"+user.getQuanzongName().toString()+
					"/"+user.getOrganizationName().toString()+"/"+user.getRoleName().toString()+"/"+user.getUserType().toString());
			 int isExitUserName=userService.isExitUserName(user);
			 int isExitIdNumber=userService.isExitIdNumber(user);
			 int isExitTelPhone=userService.isExitTelPhone(user);
			 int isExitWorkNumber=userService.isExitWorkNumber(user);
			Integer countArchiveIdByName=userService.countArchiveIdByName(list2.get(6).toString());
			System.out.println(countArchiveIdByName.toString());
			Integer countOrgIdByName=userService.countOrgIdByName(list2.get(7).toString());
			Integer countRoleIdByName=userService.countRoleIdByName(list2.get(8).toString());
			if(countArchiveIdByName==0) {
				logger.info("所属全宗名称不存在");
				msg="所属全宗名称不存在,导入失败";
				result=1;
			}else if(countOrgIdByName==0) {
				logger.info("所属机构不存在");
				msg="所属机构不存在,导入失败";
				result=2;
			}else if(countRoleIdByName==0) {
				logger.info("所属角色不存在");
				msg="所属角色不存在,导入失败";
				result=3;
			}else if(isExitUserName>0) {
				logger.info("用户名已存在");
				msg="用户名已存在,导入失败";
				result=4;
			}else if(isExitIdNumber>0) {
				logger.info("身份证号已存在");
				msg="身份证号已存在,导入失败";
				result=5;
			}else if(isExitTelPhone>0) {
				logger.info("手机号已存在");
				msg="手机号已存在,导入失败";
				result=6;
			}else if(isExitWorkNumber>0) {
				logger.info("工号已存在");
				msg="工号已存在,导入失败";
				result=7;
			}else if(list2.get(1).toString().length()==0) {
				logger.info("用户名不能为空");
				msg="用户名不能为空,导入失败";
				result=8;
			}else if(list2.get(3).toString().length()==0) {
				logger.info("身份证号不能为空");
				msg="身份证号不能为空,导入失败";
				result=9;
			}else if(list2.get(4).toString().length()==0) {
				logger.info("手机号不能为空");
				msg="手机号不能为空,导入失败";
				result=10;
			}else if(list2.get(5).toString().length()==0) {
				logger.info("工号不能为空");
				msg="工号不能为空,导入失败";
				result=11;
			}else if(list2.get(6).toString().length()==0) {
				logger.info("所属全宗不能为空");
				msg="所属全宗不能为空,导入失败";
				result=12;
			}else if(list2.get(7).toString().length()==0) {
				logger.info("所属机构不能为空");
				msg="所属机构不能为空,导入失败";
				result=13;
			}else if(list2.get(8).toString().length()==0) {
				logger.info("所属角色不能为空");
				msg="所属角色不能为空,导入失败";
				result=14;
			}else {
				user.setUserName(list2.get(1).toString());
				user.setUserSex(list2.get(2).toString());
				user.setUserIdNumber(list2.get(3).toString());
				user.setUserTelePhone(list2.get(4).toString());
				user.setUserWorkNumber(list2.get(5).toString());
				user.setQuanzongName(list2.get(6).toString());
				user.setOrganizationName(list2.get(7).toString());
				user.setRoleName(list2.get(8).toString());
				user.setUserType("1");
				user.setUserCreateTime(new Date());
				user.setQuanzongId(userService.queryArchiveIdByName(list2.get(6).toString()));
				user.setOrganizationId(userService.queryOrgIdByName(list2.get(7).toString(),list2.get(6).toString()));
				user.setRoleId(userService.queryRoleIdByName(list2.get(8).toString()));
				userService.addUser(user);
				msg="恭喜你,用户批量导入成功";
				result=15;
			}
			
		} 
	
		  /*Boolean result = DeleteFile.delete(path + "/" + fileName);*/
		return result;
	}
	
	
	
	
	
	
	

}
