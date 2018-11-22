package filemanage.inventoryandinquire.vo;

public class FileExtendVo {
	private String archiveFileId;// 文件主键
	private String archiveFileFileNumber;// 档号
	private String archiveFileReferenceNumber;// 文号
	private String archiveFileResponsible;// 责任者
	private String archiveFileTitle;// 题名
	private String archiveFileCreatetime;// 创建日期（文件形成日期）
	private String afSecurityClassrification;// 密级
	private String archiveFilePages;// 页数
	private String archiveFileRemark;// 备注
	private String boxnumber;// 盒号
	private String storageRacknumber;// 架位号

	public FileExtendVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileExtendVo(String archiveFileId, String archiveFileFileNumber, String archiveFileReferenceNumber,
			String archiveFileResponsible, String archiveFileTitle, String archiveFileCreatetime,
			String afSecurityClassrification, String archiveFilePages, String archiveFileRemark, String boxnumber,
			String storageRacknumber) {
		super();
		this.archiveFileId = archiveFileId;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
		this.archiveFileResponsible = archiveFileResponsible;
		this.archiveFileTitle = archiveFileTitle;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.afSecurityClassrification = afSecurityClassrification;
		this.archiveFilePages = archiveFilePages;
		this.archiveFileRemark = archiveFileRemark;
		this.boxnumber = boxnumber;
		this.storageRacknumber = storageRacknumber;
	}

	public String getArchiveFileId() {
		return archiveFileId;
	}

	public void setArchiveFileId(String archiveFileId) {
		this.archiveFileId = archiveFileId;
	}

	public String getArchiveFileFileNumber() {
		return archiveFileFileNumber;
	}

	public void setArchiveFileFileNumber(String archiveFileFileNumber) {
		this.archiveFileFileNumber = archiveFileFileNumber;
	}

	public String getArchiveFileReferenceNumber() {
		return archiveFileReferenceNumber;
	}

	public void setArchiveFileReferenceNumber(String archiveFileReferenceNumber) {
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
	}

	public String getArchiveFileResponsible() {
		return archiveFileResponsible;
	}

	public void setArchiveFileResponsible(String archiveFileResponsible) {
		this.archiveFileResponsible = archiveFileResponsible;
	}

	public String getArchiveFileTitle() {
		return archiveFileTitle;
	}

	public void setArchiveFileTitle(String archiveFileTitle) {
		this.archiveFileTitle = archiveFileTitle;
	}

	public String getArchiveFileCreatetime() {
		return archiveFileCreatetime;
	}

	public void setArchiveFileCreatetime(String archiveFileCreatetime) {
		this.archiveFileCreatetime = archiveFileCreatetime;
	}

	public String getAfSecurityClassrification() {
		return afSecurityClassrification;
	}

	public void setAfSecurityClassrification(String afSecurityClassrification) {
		this.afSecurityClassrification = afSecurityClassrification;
	}

	public String getArchiveFilePages() {
		return archiveFilePages;
	}

	public void setArchiveFilePages(String archiveFilePages) {
		this.archiveFilePages = archiveFilePages;
	}

	public String getArchiveFileRemark() {
		return archiveFileRemark;
	}

	public void setArchiveFileRemark(String archiveFileRemark) {
		this.archiveFileRemark = archiveFileRemark;
	}

	public String getBoxnumber() {
		return boxnumber;
	}

	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}

	public String getStorageRacknumber() {
		return storageRacknumber;
	}

	public void setStorageRacknumber(String storageRacknumber) {
		this.storageRacknumber = storageRacknumber;
	}

	@Override
	public String toString() {
		return "FileExtendVo [archiveFileId=" + archiveFileId + ", archiveFileFileNumber=" + archiveFileFileNumber
				+ ", archiveFileReferenceNumber=" + archiveFileReferenceNumber + ", archiveFileResponsible="
				+ archiveFileResponsible + ", archiveFileTitle=" + archiveFileTitle + ", archiveFileCreatetime="
				+ archiveFileCreatetime + ", afSecurityClassrification=" + afSecurityClassrification
				+ ", archiveFilePages=" + archiveFilePages + ", archiveFileRemark=" + archiveFileRemark + ", boxnumber="
				+ boxnumber + ", storageRacknumber=" + storageRacknumber + "]";
	}

}
