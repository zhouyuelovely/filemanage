package filemanage.systemmanage.pojo;

/**
 * @author mlt
 *
 */
public class Archive {

	/**
	 * 全宗
	 */

	private String quanzongId;// 主键
	private String quanzongNumber;// 全宗号
	private String quanzongName;// 全宗名
	private String quanzongPhone;// 单位电话
	private String quanzongCreatetime;// 创建时间
	private String quanzongCreator;// 创建人
	private String quanzongDescription;// 描述
	private String quanzongRemark;// 备注
	private String conditions;// 条件
	private Organization organization;

	public Archive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Archive(String quanzongId, String quanzongNumber, String quanzongName, String quanzongPhone,
			String quanzongCreatetime, String quanzongCreator, String quanzongDescription, String quanzongRemark,
			String conditions, Organization organization) {
		super();
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.quanzongPhone = quanzongPhone;
		this.quanzongCreatetime = quanzongCreatetime;
		this.quanzongCreator = quanzongCreator;
		this.quanzongDescription = quanzongDescription;
		this.quanzongRemark = quanzongRemark;
		this.conditions = conditions;
		this.organization = organization;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getQuanzongNumber() {
		return quanzongNumber;
	}

	public void setQuanzongNumber(String quanzongNumber) {
		this.quanzongNumber = quanzongNumber;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getQuanzongPhone() {
		return quanzongPhone;
	}

	public void setQuanzongPhone(String quanzongPhone) {
		this.quanzongPhone = quanzongPhone;
	}

	public String getQuanzongCreatetime() {
		return quanzongCreatetime;
	}

	public void setQuanzongCreatetime(String quanzongCreatetime) {
		this.quanzongCreatetime = quanzongCreatetime;
	}

	public String getQuanzongCreator() {
		return quanzongCreator;
	}

	public void setQuanzongCreator(String quanzongCreator) {
		this.quanzongCreator = quanzongCreator;
	}

	public String getQuanzongDescription() {
		return quanzongDescription;
	}

	public void setQuanzongDescription(String quanzongDescription) {
		this.quanzongDescription = quanzongDescription;
	}

	public String getQuanzongRemark() {
		return quanzongRemark;
	}

	public void setQuanzongRemark(String quanzongRemark) {
		this.quanzongRemark = quanzongRemark;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Archive [quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber + ", quanzongName="
				+ quanzongName + ", quanzongPhone=" + quanzongPhone + ", quanzongCreatetime=" + quanzongCreatetime
				+ ", quanzongCreator=" + quanzongCreator + ", quanzongDescription=" + quanzongDescription
				+ ", quanzongRemark=" + quanzongRemark + ", conditions=" + conditions + ", organization=" + organization
				+ "]";
	}

}
