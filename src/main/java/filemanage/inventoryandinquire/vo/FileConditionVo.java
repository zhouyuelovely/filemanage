package filemanage.inventoryandinquire.vo;

public class FileConditionVo {
	private String quanzongNumber;//全宗号
	private String quanzongName;//全宗名称
	private String pcId;//一级分类主键
	private String scId;//二级分类主键
	private String archiveFileAnual;// 年度
	private String retentionperiodid;//保管期限主键
	private String archiveFileFileNumber;// 档号
	private	String boxnumber;//盒号
	private String archiveFileCreatetime;// 创建日期（文件形成日期）
	private String storageRacknumber;//架位号
	private String condition;//关键词
	
	public FileConditionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileConditionVo(String quanzongNumber, String quanzongName, String pcId, String scId,
			String archiveFileAnual, String retentionperiodid, String archiveFileFileNumber, String boxnumber,
			String archiveFileCreatetime, String storageRacknumber, String condition) {
		super();
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.pcId = pcId;
		this.scId = scId;
		this.archiveFileAnual = archiveFileAnual;
		this.retentionperiodid = retentionperiodid;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.boxnumber = boxnumber;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.storageRacknumber = storageRacknumber;
		this.condition = condition;
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

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getArchiveFileAnual() {
		return archiveFileAnual;
	}

	public void setArchiveFileAnual(String archiveFileAnual) {
		this.archiveFileAnual = archiveFileAnual;
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	public String getArchiveFileFileNumber() {
		return archiveFileFileNumber;
	}

	public void setArchiveFileFileNumber(String archiveFileFileNumber) {
		this.archiveFileFileNumber = archiveFileFileNumber;
	}

	public String getBoxnumber() {
		return boxnumber;
	}

	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}

	public String getArchiveFileCreatetime() {
		return archiveFileCreatetime;
	}

	public void setArchiveFileCreatetime(String archiveFileCreatetime) {
		this.archiveFileCreatetime = archiveFileCreatetime;
	}

	public String getStorageRacknumber() {
		return storageRacknumber;
	}

	public void setStorageRacknumber(String storageRacknumber) {
		this.storageRacknumber = storageRacknumber;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "FileConditionVo [quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName + ", pcId=" + pcId
				+ ", scId=" + scId + ", archiveFileAnual=" + archiveFileAnual + ", retentionperiodid="
				+ retentionperiodid + ", archiveFileFileNumber=" + archiveFileFileNumber + ", boxnumber=" + boxnumber
				+ ", archiveFileCreatetime=" + archiveFileCreatetime + ", storageRacknumber=" + storageRacknumber
				+ ", condition=" + condition + "]";
	}

}
