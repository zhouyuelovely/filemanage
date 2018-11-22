package filemanage.systemmanage.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author FYX
 *
 */
public class Role {
	private String roleId;// 角色主键(序列)
	private String roleName;// 角色名称
	private String roleDescription;// 角色描述
	private Date roleCreatetime;// 角色创建时间
	private String roleCreator;// 角色创建人
	private String roleProperty;// 角色属性,0：系统默认 1：自定义
	private List<Authority> authorities;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleId, String roleName, String roleDescription, Date roleCreatetime, String roleCreator,
			String roleProperty, List<Authority> authorities) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleCreatetime = roleCreatetime;
		this.roleCreator = roleCreator;
		this.roleProperty = roleProperty;
		this.authorities = authorities;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Date getRoleCreatetime() {
		return roleCreatetime;
	}

	public void setRoleCreatetime(Date roleCreatetime) {
		this.roleCreatetime = roleCreatetime;
	}

	public String getRoleCreator() {
		return roleCreator;
	}

	public void setRoleCreator(String roleCreator) {
		this.roleCreator = roleCreator;
	}

	public String getRoleProperty() {
		return roleProperty;
	}

	public void setRoleProperty(String roleProperty) {
		this.roleProperty = roleProperty;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ ", roleCreatetime=" + roleCreatetime + ", roleCreator=" + roleCreator + ", roleProperty="
				+ roleProperty + ", authorities=" + authorities + "]";
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
