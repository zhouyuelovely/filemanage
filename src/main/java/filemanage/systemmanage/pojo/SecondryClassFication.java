package filemanage.systemmanage.pojo;

import java.util.Date;

import filemanage.collectandorganize.pojo.ArchiveFile;

/**
 * @author tchuanwu
 * 二级分类映射类
 */
public class SecondryClassFication {
	
	private String scId;//二级分类主键
	private String scCode;//二级分类代码
	private String scName;//二级分类名称
	private String scDescription;//二级分类描述
	private String pcId;//所属一级分类id
	private String scProperty;//二级分类属性0：系统默认1：自定义
	private Date scCreateTime;//二级分类创建日期
	private String scStatus;//二级分类状态0：机构1：问题
	private String scCreator;//二级分类创建人
	private ArchiveFile archiveFile;
	
	public SecondryClassFication() {
		
	}

	public SecondryClassFication(String scId, String scCode, String scName, String scDescription, String pcId,
			String scProperty, Date scCreateTime, String scStatus, String scCreator, ArchiveFile archiveFile) {
		super();
		this.scId = scId;
		this.scCode = scCode;
		this.scName = scName;
		this.scDescription = scDescription;
		this.pcId = pcId;
		this.scProperty = scProperty;
		this.scCreateTime = scCreateTime;
		this.scStatus = scStatus;
		this.scCreator = scCreator;
		this.archiveFile = archiveFile;
	}

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getScCode() {
		return scCode;
	}

	public void setScCode(String scCode) {
		this.scCode = scCode;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScDescription() {
		return scDescription;
	}

	public void setScDescription(String scDescription) {
		this.scDescription = scDescription;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getScProperty() {
		return scProperty;
	}

	public void setScProperty(String scProperty) {
		this.scProperty = scProperty;
	}

	public Date getScCreateTime() {
		return scCreateTime;
	}

	public void setScCreateTime(Date scCreateTime) {
		this.scCreateTime = scCreateTime;
	}

	public String getScStatus() {
		return scStatus;
	}

	public void setScStatus(String scStatus) {
		this.scStatus = scStatus;
	}

	public String getScCreator() {
		return scCreator;
	}

	public void setScCreator(String scCreator) {
		this.scCreator = scCreator;
	}

	public ArchiveFile getArchiveFile() {
		return archiveFile;
	}

	public void setArchiveFile(ArchiveFile archiveFile) {
		this.archiveFile = archiveFile;
	}

	@Override
	public String toString() {
		return "SecondryClassFication [scId=" + scId + ", scCode=" + scCode + ", scName=" + scName + ", scDescription="
				+ scDescription + ", pcId=" + pcId + ", scProperty=" + scProperty + ", scCreateTime=" + scCreateTime
				+ ", scStatus=" + scStatus + ", scCreator=" + scCreator + ", archiveFile=" + archiveFile + "]";
	}

	
	

}
