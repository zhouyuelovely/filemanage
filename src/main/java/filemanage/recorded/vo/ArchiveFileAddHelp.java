package filemanage.recorded.vo;

public class ArchiveFileAddHelp {
	private String quanZongId;// 全宗主键
	private String retentionperiodid;// 保管期限主键
	private String pcId;// 一级分类主键
	private String scId;// 二级分类主键
	private String anual;// 年度
	private String boxid;// 盒子主键
	private String archiveFileIsUpload;// 是否上传
	private String archiveFileId;// 文件主键
	private String archiveFileResponsible;// 责任者
	private String archiveFileCreatetime;// 成文日期
	private String archiveFileTitle;// 题名
	private String archiveFilePages;// 页数
	private String afSecurityClassrification;// 密级
	private String archiveFileFileNumber;// 档号
	private String archiveFileReferenceNumbe;// 文号
	private String archiveFileRemark;// 备注

	public ArchiveFileAddHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchiveFileAddHelp(String quanZongId, String retentionperiodid, String pcId, String scId, String anual,
			String boxid, String archiveFileIsUpload, String archiveFileId, String archiveFileResponsible,
			String archiveFileCreatetime, String archiveFileTitle, String archiveFilePages,
			String afSecurityClassrification, String archiveFileFileNumber, String archiveFileReferenceNumbe,
			String archiveFileRemark) {
		super();
		this.quanZongId = quanZongId;
		this.retentionperiodid = retentionperiodid;
		this.pcId = pcId;
		this.scId = scId;
		this.anual = anual;
		this.boxid = boxid;
		this.archiveFileIsUpload = archiveFileIsUpload;
		this.archiveFileId = archiveFileId;
		this.archiveFileResponsible = archiveFileResponsible;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.archiveFileTitle = archiveFileTitle;
		this.archiveFilePages = archiveFilePages;
		this.afSecurityClassrification = afSecurityClassrification;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.archiveFileReferenceNumbe = archiveFileReferenceNumbe;
		this.archiveFileRemark = archiveFileRemark;
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

	public String getArchiveFileIsUpload() {
		return archiveFileIsUpload;
	}

	public void setArchiveFileIsUpload(String archiveFileIsUpload) {
		this.archiveFileIsUpload = archiveFileIsUpload;
	}

	public String getArchiveFileId() {
		return archiveFileId;
	}

	public void setArchiveFileId(String archiveFileId) {
		this.archiveFileId = archiveFileId;
	}

	public String getArchiveFileResponsible() {
		return archiveFileResponsible;
	}

	public void setArchiveFileResponsible(String archiveFileResponsible) {
		this.archiveFileResponsible = archiveFileResponsible;
	}

	public String getArchiveFileCreatetime() {
		return archiveFileCreatetime;
	}

	public void setArchiveFileCreatetime(String archiveFileCreatetime) {
		this.archiveFileCreatetime = archiveFileCreatetime;
	}

	public String getArchiveFileTitle() {
		return archiveFileTitle;
	}

	public void setArchiveFileTitle(String archiveFileTitle) {
		this.archiveFileTitle = archiveFileTitle;
	}

	public String getArchiveFilePages() {
		return archiveFilePages;
	}

	public void setArchiveFilePages(String archiveFilePages) {
		this.archiveFilePages = archiveFilePages;
	}

	public String getAfSecurityClassrification() {
		return afSecurityClassrification;
	}

	public void setAfSecurityClassrification(String afSecurityClassrification) {
		this.afSecurityClassrification = afSecurityClassrification;
	}

	public String getArchiveFileFileNumber() {
		return archiveFileFileNumber;
	}

	public void setArchiveFileFileNumber(String archiveFileFileNumber) {
		this.archiveFileFileNumber = archiveFileFileNumber;
	}

	public String getArchiveFileReferenceNumbe() {
		return archiveFileReferenceNumbe;
	}

	public void setArchiveFileReferenceNumbe(String archiveFileReferenceNumbe) {
		this.archiveFileReferenceNumbe = archiveFileReferenceNumbe;
	}

	public String getArchiveFileRemark() {
		return archiveFileRemark;
	}

	public void setArchiveFileRemark(String archiveFileRemark) {
		this.archiveFileRemark = archiveFileRemark;
	}

	@Override
	public String toString() {
		return "ArchiveFileAddHelp [quanZongId=" + quanZongId + ", retentionperiodid=" + retentionperiodid + ", pcId="
				+ pcId + ", scId=" + scId + ", anual=" + anual + ", boxid=" + boxid + ", archiveFileIsUpload="
				+ archiveFileIsUpload + ", archiveFileId=" + archiveFileId + ", archiveFileResponsible="
				+ archiveFileResponsible + ", archiveFileCreatetime=" + archiveFileCreatetime + ", archiveFileTitle="
				+ archiveFileTitle + ", archiveFilePages=" + archiveFilePages + ", afSecurityClassrification="
				+ afSecurityClassrification + ", archiveFileFileNumber=" + archiveFileFileNumber
				+ ", archiveFileReferenceNumbe=" + archiveFileReferenceNumbe + ", archiveFileRemark="
				+ archiveFileRemark + "]";
	}

}
