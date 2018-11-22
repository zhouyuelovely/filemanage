package filemanage.recorded.vo;

public class BoxAddHelp {
	private String quanZongId;// 全宗主键
	private String retentionperiodid;// 保管期限
	private String pcId;// 一级分类主键
	private String scId;// 二级分类主键
	private String anual;// 年度
	private String boxid;// 盒子主键
	private String boxstartnumber;// 起件号
	private String boxendnumber;// 止件号
	private String boxcasesnumber;// 件数
	private String boxstatus;// 盒状态
	private String boxAuditstart;// 文件审核状态
	private String boxBoxingStart;// 文件装盒状态

	public BoxAddHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxAddHelp(String quanZongId, String retentionperiodid, String pcId, String scId, String anual, String boxid,
			String boxstartnumber, String boxendnumber, String boxcasesnumber, String boxstatus, String boxAuditstart,
			String boxBoxingStart) {
		super();
		this.quanZongId = quanZongId;
		this.retentionperiodid = retentionperiodid;
		this.pcId = pcId;
		this.scId = scId;
		this.anual = anual;
		this.boxid = boxid;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.boxcasesnumber = boxcasesnumber;
		this.boxstatus = boxstatus;
		this.boxAuditstart = boxAuditstart;
		this.boxBoxingStart = boxBoxingStart;
	}

	public String getQuanZongId() {
		return quanZongId;
	}

	public void setQuanZongId(String quanZongId) {
		this.quanZongId = quanZongId;
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
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

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getBoxid() {
		return boxid;
	}

	public void setBoxid(String boxid) {
		this.boxid = boxid;
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

	public String getBoxcasesnumber() {
		return boxcasesnumber;
	}

	public void setBoxcasesnumber(String boxcasesnumber) {
		this.boxcasesnumber = boxcasesnumber;
	}

	public String getBoxstatus() {
		return boxstatus;
	}

	public void setBoxstatus(String boxstatus) {
		this.boxstatus = boxstatus;
	}

	public String getBoxAuditstart() {
		return boxAuditstart;
	}

	public void setBoxAuditstart(String boxAuditstart) {
		this.boxAuditstart = boxAuditstart;
	}

	public String getBoxBoxingStart() {
		return boxBoxingStart;
	}

	public void setBoxBoxingStart(String boxBoxingStart) {
		this.boxBoxingStart = boxBoxingStart;
	}

	@Override
	public String toString() {
		return "BoxAddHelp [quanZongId=" + quanZongId + ", retentionperiodid=" + retentionperiodid + ", pcId=" + pcId
				+ ", scId=" + scId + ", anual=" + anual + ", boxid=" + boxid + ", boxstartnumber=" + boxstartnumber
				+ ", boxendnumber=" + boxendnumber + ", boxcasesnumber=" + boxcasesnumber + ", boxstatus=" + boxstatus
				+ ", boxAuditstart=" + boxAuditstart + ", boxBoxingStart=" + boxBoxingStart + "]";
	}

}
