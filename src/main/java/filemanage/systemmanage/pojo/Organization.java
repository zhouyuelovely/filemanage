package filemanage.systemmanage.pojo;

/**
 * @author mlt 机构映射类
 */
public class Organization {

	private String organizationId;// 主键
	private String organizationCode;// 机构代码
	private String organizationName;// 机构名
	private String organizationPhone;// 机构电话
	private String organizationCreatetime;// 创建日期
	private String organizationCreator;// 创建人
	private String quanzongId;// 所属全宗
	private String organizationDescription;// 描述
	private String organizationRemark;// 备注
	private String pcId;// 一级分类主键
	private String conditions;// 条件
	private String organizationProperty;// 机构(问题)属性
	private String organizationStatus;// 机构(问题)状态

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(String organizationId, String organizationCode, String organizationName,
			String organizationPhone, String organizationCreatetime, String organizationCreator, String quanzongId,
			String organizationDescription, String organizationRemark, String pcId, String conditions,
			String organizationProperty, String organizationStatus) {
		super();
		this.organizationId = organizationId;
		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.organizationPhone = organizationPhone;
		this.organizationCreatetime = organizationCreatetime;
		this.organizationCreator = organizationCreator;
		this.quanzongId = quanzongId;
		this.organizationDescription = organizationDescription;
		this.organizationRemark = organizationRemark;
		this.pcId = pcId;
		this.conditions = conditions;
		this.organizationProperty = organizationProperty;
		this.organizationStatus = organizationStatus;
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

	public String getOrganizationPhone() {
		return organizationPhone;
	}

	public void setOrganizationPhone(String organizationPhone) {
		this.organizationPhone = organizationPhone;
	}

	public String getOrganizationCreatetime() {
		return organizationCreatetime;
	}

	public void setOrganizationCreatetime(String organizationCreatetime) {
		this.organizationCreatetime = organizationCreatetime;
	}

	public String getOrganizationCreator() {
		return organizationCreator;
	}

	public void setOrganizationCreator(String organizationCreator) {
		this.organizationCreator = organizationCreator;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getOrganizationDescription() {
		return organizationDescription;
	}

	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}

	public String getOrganizationRemark() {
		return organizationRemark;
	}

	public void setOrganizationRemark(String organizationRemark) {
		this.organizationRemark = organizationRemark;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getOrganizationProperty() {
		return organizationProperty;
	}

	public void setOrganizationProperty(String organizationProperty) {
		this.organizationProperty = organizationProperty;
	}

	public String getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organizationCode=" + organizationCode
				+ ", organizationName=" + organizationName + ", organizationPhone=" + organizationPhone
				+ ", organizationCreatetime=" + organizationCreatetime + ", organizationCreator=" + organizationCreator
				+ ", quanzongId=" + quanzongId + ", organizationDescription=" + organizationDescription
				+ ", organizationRemark=" + organizationRemark + ", pcId=" + pcId + ", conditions=" + conditions
				+ ", organizationProperty=" + organizationProperty + ", organizationStatus=" + organizationStatus + "]";
	}

}
