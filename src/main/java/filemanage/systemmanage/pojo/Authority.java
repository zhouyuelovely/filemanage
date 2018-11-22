package filemanage.systemmanage.pojo;

/**
 * @author FYX
 *
 */
public class Authority {
	private String permissionId;//权限主键(序列)
	private String permissionName;//权限名称
	private String permissionUrl;//权限过滤地址
	private String permissionDescription;//权限描述
	private String permissionBelong;//所属权限
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(String permissionId, String permissionName, String permissionUrl, String permissionDescription,
			String permissionBelong) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionUrl = permissionUrl;
		this.permissionDescription = permissionDescription;
		this.permissionBelong = permissionBelong;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getPermissionBelong() {
		return permissionBelong;
	}

	public void setPermissionBelong(String permissionBelong) {
		this.permissionBelong = permissionBelong;
	}

	@Override
	public String toString() {
		return "Authority [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionUrl="
				+ permissionUrl + ", permissionDescription=" + permissionDescription + ", permissionBelong="
				+ permissionBelong + "]";
	}
	
}
