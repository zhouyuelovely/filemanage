package filemanage.collectandorganize.vo;

public class BoxVo {
	private String boxId;
	private String boxsericalnumber; // 盒子编号
	private String quanzongNumber;
	private String quanzongName;
	private String boxAnual;
	private String scName;
	private String retentionperiodName;
	private String boxStartnumber;
	private String boxEndnumber;
	private String boxNumber;
	private String boxThickness;
	private String boxAuditstart;

	public BoxVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxVo(String boxId, String boxsericalnumber, String quanzongNumber, String quanzongName, String boxAnual,
			String scName, String retentionperiodName, String boxStartnumber, String boxEndnumber, String boxNumber,
			String boxThickness, String boxAuditstart) {
		super();
		this.boxId = boxId;
		this.boxsericalnumber = boxsericalnumber;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.boxAnual = boxAnual;
		this.scName = scName;
		this.retentionperiodName = retentionperiodName;
		this.boxStartnumber = boxStartnumber;
		this.boxEndnumber = boxEndnumber;
		this.boxNumber = boxNumber;
		this.boxThickness = boxThickness;
		this.boxAuditstart = boxAuditstart;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxsericalnumber() {
		return boxsericalnumber;
	}

	public void setBoxsericalnumber(String boxsericalnumber) {
		this.boxsericalnumber = boxsericalnumber;
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

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getRetentionperiodName() {
		return retentionperiodName;
	}

	public void setRetentionperiodName(String retentionperiodName) {
		this.retentionperiodName = retentionperiodName;
	}

	public String getBoxStartnumber() {
		return boxStartnumber;
	}

	public void setBoxStartnumber(String boxStartnumber) {
		this.boxStartnumber = boxStartnumber;
	}

	public String getBoxEndnumber() {
		return boxEndnumber;
	}

	public void setBoxEndnumber(String boxEndnumber) {
		this.boxEndnumber = boxEndnumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getBoxThickness() {
		return boxThickness;
	}

	public void setBoxThickness(String boxThickness) {
		this.boxThickness = boxThickness;
	}

	public String getBoxAuditstart() {
		return boxAuditstart;
	}

	public void setBoxAuditstart(String boxAuditstart) {
		this.boxAuditstart = boxAuditstart;
	}

	@Override
	public String toString() {
		return "BoxVo [boxId=" + boxId + ", boxsericalnumber=" + boxsericalnumber + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", boxAnual=" + boxAnual + ", scName=" + scName
				+ ", retentionperiodName=" + retentionperiodName + ", boxStartnumber=" + boxStartnumber
				+ ", boxEndnumber=" + boxEndnumber + ", boxNumber=" + boxNumber + ", boxThickness=" + boxThickness
				+ ", boxAuditstart=" + boxAuditstart + "]";
	}

}
