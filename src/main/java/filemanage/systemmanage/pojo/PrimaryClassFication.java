package filemanage.systemmanage.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author tchuanwu 一级分类映射类
 */
public class PrimaryClassFication {

	private String pcId;// 一级分类主键
	private String pcCode;// 一级分类代码
	private String pcName;// 一级分类名称
	private String pcDescription;// 一级分类描述
	private String pcProperty;// 一级分类属性 0：表示系统默认 1：自定义属性
	private Date pcCreateTime; // 一级分类创建日期
	private String pcCreator;// 一级分类创建人
	private List<SecondryClassFication> twos;// 获取所属二级分类的集合
	private Organization org;

	public PrimaryClassFication() {
		super();
	}

	public PrimaryClassFication(String pcId, String pcCode, String pcName, String pcDescription, String pcProperty,
			Date pcCreateTime, String pcCreator, List<SecondryClassFication> twos, Organization org) {
		super();
		this.pcId = pcId;
		this.pcCode = pcCode;
		this.pcName = pcName;
		this.pcDescription = pcDescription;
		this.pcProperty = pcProperty;
		this.pcCreateTime = pcCreateTime;
		this.pcCreator = pcCreator;
		this.twos = twos;
		this.org = org;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getPcCode() {
		return pcCode;
	}

	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getPcDescription() {
		return pcDescription;
	}

	public void setPcDescription(String pcDescription) {
		this.pcDescription = pcDescription;
	}

	public String getPcProperty() {
		return pcProperty;
	}

	public void setPcProperty(String pcProperty) {
		this.pcProperty = pcProperty;
	}

	public Date getPcCreateTime() {
		return pcCreateTime;
	}

	public void setPcCreateTime(Date pcCreateTime) {
		this.pcCreateTime = pcCreateTime;
	}

	public String getPcCreator() {
		return pcCreator;
	}

	public void setPcCreator(String pcCreator) {
		this.pcCreator = pcCreator;
	}

	public List<SecondryClassFication> getTwos() {
		return twos;
	}

	public void setTwos(List<SecondryClassFication> twos) {
		this.twos = twos;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "PrimaryClassFication [pcId=" + pcId + ", pcCode=" + pcCode + ", pcName=" + pcName + ", pcDescription="
				+ pcDescription + ", pcProperty=" + pcProperty + ", pcCreateTime=" + pcCreateTime + ", pcCreator="
				+ pcCreator + ", twos=" + twos + ", org=" + org + "]";
	}

	

}
