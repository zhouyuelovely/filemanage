package filemanage.systemmanage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.Role;
import filemanage.systemmanage.pojo.RoleAndAuthority;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.RoleManagementService;

/**
 * @author FYX
 *
 */
@Controller
@RequestMapping("/roleManagement")
public class RoleManagementController {

	@Autowired
	private RoleManagementService roleManagementService;
	
	@Autowired
	private MessageNotificationService messageNotificationService;
	
	/**
	 * 跳转角色管理页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
	public ModelAndView goToRoleManagement() throws Exception {
		User user = HavingUserInfor.havingUser();
		ModelAndView mv = new ModelAndView();
		mv.addObject("listArchive", roleManagementService.listArchive());
		mv.addObject("listRole", roleManagementService.listRole());
		// mv.addObject("listRight", roleManagementService.listAuthority("0"));//
		// '0':表示一级权限
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/archiveManage/right_management");
		return mv;
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
	public @ResponseBody List<User> getUserInfo(@RequestParam("userName") String userName) throws Exception {
		return roleManagementService.queryUserByCondition(userName);
	}

	/**
	 * 根据全宗表的主键查询机构名称
	 * 
	 * @param quanzongId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showOrganization", method = RequestMethod.GET)
	public @ResponseBody List<Organization> showOrganization(@RequestParam("quanzongId") String quanzongId)
			throws Exception {
		return roleManagementService.queryOrganizationByquanzongId(quanzongId);
	}

	/**
	 * 根据机构表的主键查询用户信息
	 * 
	 * @param organizationId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showUserInfo", method = RequestMethod.GET)
	public @ResponseBody List<User> showUserInfo(@RequestParam("organizationId") String organizationId)
			throws Exception {
		return roleManagementService.queryUserInfoByorganizationId(organizationId);
	}

	/**
	 * 添加角色
	 * 
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public @ResponseBody Integer addRole(HttpServletRequest request, @RequestParam("roleName") String roleName) throws Exception {
		User user = HavingUserInfor.havingUser();
		Integer num = null;
		if (!StringUtils.isEmpty(roleName)/* && user!=null */) {
			Role role = roleManagementService.queryRoleByRoleName(roleName);
			if (role != null) {
				num = 1;
			} else {
				Role role2 = new Role();
				role2.setRoleName(roleName);
				role2.setRoleCreator(user.getUserName());
				roleManagementService.addRole(role2);
				num = 2;
			}
		} else {
			throw new Exception("请检查参数roleName或use是否为null!");
		}
		return num;
	}

	/**
	 * 根据主键删除角色
	 * 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public @ResponseBody Boolean deleteRoleByRoleId(@RequestParam("roleId") String roleId) throws Exception {
		
		List<Map<String, Object>> in=roleManagementService.queryUsers(roleId);
		//System.out.println(roleId);
		if(in.size()>0) {
			//System.out.println(in.size());
			//System.out.println(roleId);
			return false;
		}else {
			//System.exit(-1);
			return roleManagementService.deleteRoleByRoleId(roleId);
		}
	
	}

	/**
	 * 赋予角色权限
	 * 
	 * @param roleAndAuthority
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grantAuthority", method = RequestMethod.POST)
	public @ResponseBody Boolean grantAuthority(@RequestBody RoleAndAuthority roleAndAuthority) throws Exception {
		String roleId = roleAndAuthority.getRoleId();
		String[] permissionId = roleAndAuthority.getPermissionId().split(",");
		return roleManagementService.grantAuthority(roleId, permissionId);
	}
	
	/**
	 * 根据角色Id删除权限
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAuthority", method = RequestMethod.POST)
	public @ResponseBody Integer deleteAuthorityByRoleId(@RequestParam("roleId") String roleId) throws Exception {
		
		return roleManagementService.deleteAuthorityByRoleId(roleId);
	}
	
	/**
	 * 点击角色跳转权限页面
	 * @return
	 */
	@RequestMapping(value = "goPrivilegeJsp")
	public ModelAndView goPrivilegeJsp(@RequestParam("roleId") String roleId) {
		User user = HavingUserInfor.havingUser();
		ModelAndView mv = new ModelAndView();
		mv.addObject("roleId", roleId);
		mv.addObject("user", user);
		mv.addObject("authoritys", roleManagementService.havingAuthority(roleId));
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/archiveManage/privilege");
		return mv;
	}

}
