package filemanage.inventoryandinquire.vo;

public class HistoryDataConditionVo {
	private String quanzongNumber;//全宗号
	private String quanzongName;//全宗名称
	private String pcId;//一级分类主键
	private String scId;//二级分类主键
	private String archiveFileAnual;// 年度
	private String retentionperiodId;//保管期限主键
	private String archiveFileFileNumber;// 档号
	private	String boxNumber;//盒号
	private String archiveFileCreatetime;// 成文日期（文件形成日期）
	private String condition;//关键词 
	
	public HistoryDataConditionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryDataConditionVo(String quanzongNumber, String quanzongName, String pcId, String scId,
			String archiveFileAnual, String retentionperiodId, String archiveFileFileNumber, String boxNumber,
			String archiveFileCreatetime, String condition) {
		super();
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.pcId = pcId;
		this.scId = scId;
		this.archiveFileAnual = archiveFileAnual;
		this.retentionperiodId = retentionperiodId;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.boxNumber = boxNumber;
		this.archiveFileCreatetime = archiveFileCreatetime;
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

	public String getRetentionperiodId() {
		return retentionperiodId;
	}

	public void setRetentionperiodId(String retentionperiodId) {
		this.retentionperiodId = retentionperiodId;
	}

	public String getArchiveFileFileNumber() {
		return archiveFileFileNumber;
	}

	public void setArchiveFileFileNumber(String archiveFileFileNumber) {
		this.archiveFileFileNumber = archiveFileFileNumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getArchiveFileCreatetime() {
		return archiveFileCreatetime;
	}

	public void setArchiveFileCreatetime(String archiveFileCreatetime) {
		this.archiveFileCreatetime = archiveFileCreatetime;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "HistoryDataConditionVo [quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName + ", pcId="
				+ pcId + ", scId=" + scId + ", archiveFileAnual=" + archiveFileAnual + ", retentionperiodId="
				+ retentionperiodId + ", archiveFileFileNumber=" + archiveFileFileNumber + ", boxNumber=" + boxNumber
				+ ", archiveFileCreatetime=" + archiveFileCreatetime + ", condition=" + condition + "]";
	}
	
}
