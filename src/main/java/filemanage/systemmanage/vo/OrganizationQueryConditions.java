package filemanage.systemmanage.vo;

/**
 * @author MLT
 *  关键词查询机构信息（机构代码、机构名称）
 */
public class OrganizationQueryConditions {
	
	private String organizationId;// 主键
	private String organizationCode;// 机构代码
	private String organizationName;// 机构名称
	private String condition;

	public OrganizationQueryConditions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationQueryConditions(String organizationId, String organizationCode, String organizationName,
			String condition) {
		super();
		this.organizationId = organizationId;
		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.condition = condition;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getConditions() {
		return condition;
	}

	public void setConditions(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "OrganizationQueryConditions [organizationId=" + organizationId + ", organizationCode="
				+ organizationCode + ", organizationName=" + organizationName + ", condition=" + condition + "]";
	}

}
