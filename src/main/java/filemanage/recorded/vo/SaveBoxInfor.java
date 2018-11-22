package filemanage.recorded.vo;

public class SaveBoxInfor {
	private String boxId;// 盒子的id
	private String boxsituation; // 盒内情况说明
	private String boxsericalnumber; // 盒子编号
	private String boxthickness; // 盒厚度
	private String boxpage; // 可装页数
	private String boxanual; // 年度
	private String retentionperiodid; // 保管期限主键
	private String boxstartnumber; // 起件号
	private String boxendnumber; // 止件号
	private String boxnumber; // 盒号
	private String quanzongId;// 全宗主键
	private String pcId;// 一级分类主键
	private String scId;// 二级分类主键

	public SaveBoxInfor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaveBoxInfor(String boxId, String boxsituation, String boxsericalnumber, String boxthickness, String boxpage,
			String boxanual, String retentionperiodid, String boxstartnumber, String boxendnumber, String boxnumber,
			String quanzongId, String pcId, String scId) {
		super();
		this.boxId = boxId;
		this.boxsituation = boxsituation;
		this.boxsericalnumber = boxsericalnumber;
		this.boxthickness = boxthickness;
		this.boxpage = boxpage;
		this.boxanual = boxanual;
		this.retentionperiodid = retentionperiodid;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.boxnumber = boxnumber;
		this.quanzongId = quanzongId;
		this.pcId = pcId;
		this.scId = scId;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxsituation() {
		return boxsituation;
	}

	public void setBoxsituation(String boxsituation) {
		this.boxsituation = boxsituation;
	}

	public String getBoxsericalnumber() {
		return boxsericalnumber;
	}

	public void setBoxsericalnumber(String boxsericalnumber) {
		this.boxsericalnumber = boxsericalnumber;
	}

	public String getBoxthickness() {
		return boxthickness;
	}

	public void setBoxthickness(String boxthickness) {
		this.boxthickness = boxthickness;
	}

	public String getBoxpage() {
		return boxpage;
	}

	public void setBoxpage(String boxpage) {
		this.boxpage = boxpage;
	}

	public String getBoxanual() {
		return boxanual;
	}

	public void setBoxanual(String boxanual) {
		this.boxanual = boxanual;
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	public String getBoxstartnumber() {
		return boxstartnumber;
	}

	public void setBoxstartnumber(String boxstartnumber) {
		this.boxstartnumber = boxstartnumber;
	}

	public String getBoxendnumber() {
		return boxendnumber;
	}

	public void setBoxendnumber(String boxendnumber) {
		this.boxendnumber = boxendnumber;
	}

	public String getBoxnumber() {
		return boxnumber;
	}

	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
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

	@Override
	public String toString() {
		return "SaveBoxInfor [boxId=" + boxId + ", boxsituation=" + boxsituation + ", boxsericalnumber="
				+ boxsericalnumber + ", boxthickness=" + boxthickness + ", boxpage=" + boxpage + ", boxanual="
				+ boxanual + ", retentionperiodid=" + retentionperiodid + ", boxstartnumber=" + boxstartnumber
				+ ", boxendnumber=" + boxendnumber + ", boxnumber=" + boxnumber + ", quanzongId=" + quanzongId
				+ ", pcId=" + pcId + ", scId=" + scId + "]";
	}

}
