package filemanage.collectandorganize.vo;

public class SaveArchiveFileHelp {
	private String archiveFileId;// 文件主键
	private String archiveFileResponsible;// 责任人
	private String archiveFileCreatetime;// 创建日期（文件形成日期）
	private String archiveFileAnual;// 年度
	private String archiveFileTitle;// 题名
	private String archiveFileReferenceNumber;// 文号
	private String remark;// 标记文件附件主键

	public SaveArchiveFileHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaveArchiveFileHelp(String archiveFileId, String archiveFileResponsible, String archiveFileCreatetime,
			String archiveFileAnual, String archiveFileTitle, String archiveFileReferenceNumber, String remark) {
		super();
		this.archiveFileId = archiveFileId;
		this.archiveFileResponsible = archiveFileResponsible;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.archiveFileAnual = archiveFileAnual;
		this.archiveFileTitle = archiveFileTitle;
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SaveArchiveFileHelp [archiveFileId=" + archiveFileId + ", archiveFileResponsible="
				+ archiveFileResponsible + ", archiveFileCreatetime=" + archiveFileCreatetime + ", archiveFileAnual="
				+ archiveFileAnual + ", archiveFileTitle=" + archiveFileTitle + ", archiveFileReferenceNumber="
				+ archiveFileReferenceNumber + ", remark=" + remark + "]";
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

	public String getArchiveFileAnual() {
		return archiveFileAnual;
	}

	public void setArchiveFileAnual(String archiveFileAnual) {
		this.archiveFileAnual = archiveFileAnual;
	}

	public String getArchiveFileTitle() {
		return archiveFileTitle;
	}

	public void setArchiveFileTitle(String archiveFileTitle) {
		this.archiveFileTitle = archiveFileTitle;
	}

	public String getArchiveFileReferenceNumber() {
		return archiveFileReferenceNumber;
	}

	public void setArchiveFileReferenceNumber(String archiveFileReferenceNumber) {
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
