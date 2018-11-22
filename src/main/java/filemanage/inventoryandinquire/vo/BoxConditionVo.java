package filemanage.inventoryandinquire.vo;

public class BoxConditionVo {
	private String quanzongNumber;//全宗号
	private String quanzongName;//全宗名称
	private String pcId;//一级分类主键
	private String scId;//二级分类主键
	private String boxanual;//年度
	private String retentionperiodId;//保管期限主键
	private	String boxNumber;//盒号
	private String storageRacknumber;//架位号
	private String condition;//关键词
	
	public BoxConditionVo() {
		super();
	}

	public BoxConditionVo(String quanzongNumber, String quanzongName, String pcId, String scId, String boxanual,
			String retentionperiodId, String boxNumber, String storageRacknumber, String condition) {
		super();
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.pcId = pcId;
		this.scId = scId;
		this.boxanual = boxanual;
		this.retentionperiodId = retentionperiodId;
		this.boxNumber = boxNumber;
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

	public String getBoxanual() {
		return boxanual;
	}

	public void setBoxanual(String boxanual) {
		this.boxanual = boxanual;
	}

	public String getRetentionperiodId() {
		return retentionperiodId;
	}

	public void setRetentionperiodId(String retentionperiodId) {
		this.retentionperiodId = retentionperiodId;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
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
		return "BoxConditionVo [quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName + ", pcId=" + pcId
				+ ", scId=" + scId + ", boxanual=" + boxanual + ", retentionperiodId=" + retentionperiodId
				+ ", boxNumber=" + boxNumber + ", storageRacknumber=" + storageRacknumber + ", condition=" + condition
				+ "]";
	}

}
