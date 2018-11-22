package filemanage.systemmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Authority;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.Role;

/**
 * @author FYX
 *
 */
@Repository("roleManagementMapper")
public interface RoleManagementMapper {

	/**
	 * 查询全宗名称集合
	 * 
	 * @return
	 */
	List<Archive> listArchive() throws Exception;

	/**
	 * 查询角色名称集合
	 * 
	 * @return
	 */
	List<Role> listRole() throws Exception;

	/**
	 * 添加自定义角色
	 * 
	 * @param role
	 * @return
	 */
	Integer addRole(Role role) throws Exception;

	/**
	 * 根据角色主键删除一个角色
	 * 
	 * @param roleId
	 * @return
	 */
	Integer deleteRoleByRoleId(@Param("roleId") String roleId) throws Exception;

	/**
	 * 根据所属权限查询一级权限集合
	 * 
	 * @param authorityBelong
	 * @return
	 */
	List<Authority> listAuthority(@Param("permissionBelong") String permissionBelong) throws Exception;

	/**
	 * 根据全宗表的主键查询机构名称
	 * 
	 * @param quanzongId
	 * @return
	 */
	List<Organization> queryOrganizationByquanzongId(@Param("quanzongId") String quanzongId) throws Exception;

	/**
	 * 根据机构表的主键查询用户信息
	 * 
	 * @param organizationId
	 * @return
	 */
	List<User> queryUserInfoByorganizationId(@Param("organizationId") String organizationId) throws Exception;

	/**
	 * 根据用户名查找用户
	 * 
	 * @param user
	 * @return
	 */
	List<User> queryUserByCondition(@Param("userName") String userName) throws Exception;

	/**
	 * 根据角色Id删除权限Id
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer deleteAuthorityByRoleId(@Param("roleId") String roleId) throws Exception;

	/**
	 * 赋予角色权限
	 * 
	 * @param roleId
	 * @param rightId
	 * @return
	 */
	Integer grantAuthority(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
	/**
	 * 根据角色主键查询角色
	 * @param roleId
	 * @return
	 */
	Role queryRoleById(@Param("roleId") String roleId);

	/**
	 * 根据角色名称查询角色是否在角色表中存在
	 * 
	 * @param roleName
	 * @return
	 */
	Role queryRoleByRoleName(@Param("roleName") String roleName) throws Exception;
	/**
	 * 获取角色拥有的权限
	 * @param roleId 角色主键
	 * @return
	 */
	List<Authority> havingAuthority(String roleId);
	
	/**
	 * 获取拥有该角色的用户
	 * @param roleId 角色主键
	 * @return
	 */
	List<Map<String, Object>> queryUsers(String roleId);

}
