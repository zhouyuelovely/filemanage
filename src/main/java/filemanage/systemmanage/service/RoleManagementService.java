package filemanage.systemmanage.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Authority;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.Role;

/**
 * @author FYX
 *
 */
public interface RoleManagementService {

	/**
	 * 查询全宗名称集合
	 * 
	 * @return
	 */
	List<Archive> listArchive() throws Exception;

	/**
	 * 根据全宗表的主键查询机构名称
	 * 
	 * @param quanzongId
	 * @return
	 */
	List<Organization> queryOrganizationByquanzongId(String quanzongId) throws Exception;

	/**
	 * 查询角色名称集合
	 * 
	 * @return
	 */
	List<Role> listRole() throws Exception;

	/**
	 * 根据所属权限查询一级权限集合
	 * 
	 * @param authorityBelong
	 * @return
	 */
	List<Authority> listAuthority(String permissionBelong) throws Exception;

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	Boolean addRole(Role role) throws Exception;

	/**
	 * 根据主键删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	Boolean deleteRoleByRoleId(String roleId) throws Exception;

	/**
	 * 根据机构表的主键查询用户信息
	 * 
	 * @param organizationId
	 * @return
	 */
	List<User> queryUserInfoByorganizationId(String organizationId) throws Exception;

	/**
	 * 根据用户名查找用户
	 * 
	 * @param condition
	 * @return
	 */
	List<User> queryUserByCondition(String userName) throws Exception;

	/**
	 * 赋予角色权限
	 * 
	 * @param roleId
	 * @param permissionId
	 * @return
	 */
	Boolean grantAuthority(String roleId, String[] permissionId) throws Exception;

	/**
	 * 根据角色名称查询角色是否在角色表中存在
	 * 
	 * @param roleName
	 * @return
	 */
	Role queryRoleByRoleName(String roleName) throws Exception;

	/**
	 * 根据角色主键查询角色
	 * 
	 * @param roleId
	 * @return
	 */
	Role queryRoleById(@Param("roleId") String roleId);

	/**
	 * 根据角色id删除权限
	 * 
	 * @param roleId
	 * @return
	 */
	Integer deleteAuthorityByRoleId(String roleId) throws Exception;
	/**
	 * 获取角色拥有的权限
	 * @param roleId 角色主键
	 * @return
	 */
	List<Authority> havingAuthority(String roleId);
	
	List<Map<String, Object>> queryUsers(String roleId);
}
