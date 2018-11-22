package filemanage.systemmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import filemanage.login.pojo.User;
import filemanage.systemmanage.dao.RoleManagementMapper;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Authority;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.Role;
import filemanage.systemmanage.pojo.RoleAndAuthority;
import filemanage.systemmanage.service.RoleManagementService;

/**
 * @author FYX
 *
 */
@Service("roleManagementService")
public class RoleManagementServiceImpl implements RoleManagementService {
	private Logger log = Logger.getLogger(RoleManagementServiceImpl.class);
	@Autowired
	private RoleManagementMapper roleManagementMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Archive> listArchive() throws Exception {

		return roleManagementMapper.listArchive();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Role> listRole() throws Exception {

		return roleManagementMapper.listRole();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authority> listAuthority(String permissionBelong) throws Exception {

		return roleManagementMapper.listAuthority(permissionBelong);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean addRole(Role role) throws Exception {
		return roleManagementMapper.addRole(role) > 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean deleteRoleByRoleId(String roleId) throws Exception {
		
		return roleManagementMapper.deleteRoleByRoleId(roleId) > 0;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> queryOrganizationByquanzongId(String quanzongId) throws Exception {
		return roleManagementMapper.queryOrganizationByquanzongId(quanzongId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> queryUserInfoByorganizationId(String organizationId) throws Exception {
		return roleManagementMapper.queryUserInfoByorganizationId(organizationId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> queryUserByCondition(String userName) throws Exception {
		return roleManagementMapper.queryUserByCondition(userName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean grantAuthority(String roleId, String[] permissionId) throws Exception {
		Boolean result = false;
		if (!StringUtils.isEmpty(roleId)) {
			Integer num = roleManagementMapper.deleteAuthorityByRoleId(roleId);
			for (String rightId : permissionId) {
				result = roleManagementMapper.grantAuthority(roleId, rightId) > 0;
			}
			log.info("删除角色权限表数据:" + num);
		}
		return result;
	}

	@Override
	public Role queryRoleByRoleName(String roleName) throws Exception {
		return roleManagementMapper.queryRoleByRoleName(roleName);
	}

	@Override
	public Role queryRoleById(String roleId) {

		return roleManagementMapper.queryRoleById(roleId);
	}

	@Override
	public Integer deleteAuthorityByRoleId(String roleId) throws Exception {
			// RoleAndAuthority roleAndAuthority=roleManagementMapper.queryAuthorityByRoleId(roleId);
		return roleManagementMapper.deleteAuthorityByRoleId(roleId);
	}

	@Override
	public List<Authority> havingAuthority(String roleId) {
		return roleManagementMapper.havingAuthority(roleId);
	}

	@Override
	public List<Map<String, Object>> queryUsers(String roleId) {
		
		return roleManagementMapper.queryUsers(roleId);
	}

}
