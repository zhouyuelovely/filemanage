package filemanage.systemmanage.pojo;

/**
 * @author FYX
 *
 */
public class RoleAndAuthority {
	private String roleId;//角色主键
	private	String permissionId;//权限主键
	
	public RoleAndAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleAndAuthority(String roleId, String permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "RoleAndAuthority [roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}
	
	
}
