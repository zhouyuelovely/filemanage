package filemanage.danganmanage.vo;

public class BoxCondition {
	
	private String boxId;
	private String quanzongId;//全宗主键
	private String quanzongNumber;//全宗号
	private String quanzongName;//全宗名称
	private String boxAnual;//盒年度
	private String archivefileid;
	private String archivefileanual;//文件年度
	private String historydataId;
	private String historydataArchivalYear;//历史数据年度
	private String pcName;//一级分类(档案类型)
	private String retentionperiodname;//保管期限名称
	private String historydataType; // (泰坦数据)-档案类型名称
	
	public BoxCondition() {
		
	}

	public BoxCondition(String boxId, String quanzongId, String quanzongNumber, String quanzongName, String boxAnual,
			String archivefileid, String archivefileanual, String historydataId, String historydataArchivalYear,
			String pcName, String retentionperiodname, String historydataType) {
		super();
		this.boxId = boxId;
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.boxAnual = boxAnual;
		this.archivefileid = archivefileid;
		this.archivefileanual = archivefileanual;
		this.historydataId = historydataId;
		this.historydataArchivalYear = historydataArchivalYear;
		this.pcName = pcName;
		this.retentionperiodname = retentionperiodname;
		this.historydataType = historydataType;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
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

	public String getBoxAnual() {
		return boxAnual;
	}

	public void setBoxAnual(String boxAnual) {
		this.boxAnual = boxAnual;
	}

	public String getArchivefileid() {
		return archivefileid;
	}

	public void setArchivefileid(String archivefileid) {
		this.archivefileid = archivefileid;
	}

	public String getArchivefileanual() {
		return archivefileanual;
	}

	public void setArchivefileanual(String archivefileanual) {
		this.archivefileanual = archivefileanual;
	}

	public String getHistorydataId() {
		return historydataId;
	}

	public void setHistorydataId(String historydataId) {
		this.historydataId = historydataId;
	}

	public String getHistorydataArchivalYear() {
		return historydataArchivalYear;
	}

	public void setHistorydataArchivalYear(String historydataArchivalYear) {
		this.historydataArchivalYear = historydataArchivalYear;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}

	public String getHistorydataType() {
		return historydataType;
	}

	public void setHistorydataType(String historydataType) {
		this.historydataType = historydataType;
	}

	@Override
	public String toString() {
		return "BoxCondition [boxId=" + boxId + ", quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", boxAnual=" + boxAnual + ", archivefileid=" + archivefileid
				+ ", archivefileanual=" + archivefileanual + ", historydataId=" + historydataId
				+ ", historydataArchivalYear=" + historydataArchivalYear + ", pcName=" + pcName
				+ ", retentionperiodname=" + retentionperiodname + ", historydataType=" + historydataType + "]";
	}

	
	
	
	
	

}
