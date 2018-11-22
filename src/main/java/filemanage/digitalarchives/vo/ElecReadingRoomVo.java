package filemanage.digitalarchives.vo;

import java.util.Date;


/**
 * @author MLT 电子阅览室辅助类
 *
 */
public class ElecReadingRoomVo {

	private String archiveFileId;// 文件主键
	private String archiveFileAnual;// 年度
	private String archiveFileFileNumber;// 档号
	private String archiveFileReferenceNumber;// 文号
	private String archiveFileResponsible;// 责任人
	private String archiveFileTitle;// 题名
	private String archiveFileCreatetime;// 创建日期（文件形成日期）
	private String quanzongName;// 全宗名
	private String retentionperiodid;// 保管期限主键
	private String retentionperiodname;// 保管期限名（期限）
	private String pcId;// 一级分类主键
	private String pcName;// 一级分类名称
	private String scId;// 二级分类主键
	private String scName;// 二级分类名称
	private String conditions;// 条件
	private String fileAttachmentId;// 附件主键
	private String fileAttachmentPath;// 附件地址
	private String fileAttachmentName;// 附件名称
	private String fileAttachmentPageNumber;// 页码
	private String fileAttachmentMark;// 标记1：封面
	private String quanzongId;// 全宗主键
	private String fileAttachmentAnual;// 文件年度
	private Date fileCreatetime;// 创建时间
	private String fileCreator;// 创建人

	public ElecReadingRoomVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElecReadingRoomVo(String archiveFileId, String archiveFileAnual, String archiveFileFileNumber,
			String archiveFileReferenceNumber, String archiveFileResponsible, String archiveFileTitle,
			String archiveFileCreatetime, String quanzongName, String retentionperiodid, String retentionperiodname,
			String pcId, String pcName, String scId, String scName, String conditions, String fileAttachmentId,
			String fileAttachmentPath, String fileAttachmentName, String fileAttachmentPageNumber,
			String fileAttachmentMark, String quanzongId, String fileAttachmentAnual, Date fileCreatetime,
			String fileCreator) {
		super();
		this.archiveFileId = archiveFileId;
		this.archiveFileAnual = archiveFileAnual;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
		this.archiveFileResponsible = archiveFileResponsible;
		this.archiveFileTitle = archiveFileTitle;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.quanzongName = quanzongName;
		this.retentionperiodid = retentionperiodid;
		this.retentionperiodname = retentionperiodname;
		this.pcId = pcId;
		this.pcName = pcName;
		this.scId = scId;
		this.scName = scName;
		this.conditions = conditions;
		this.fileAttachmentId = fileAttachmentId;
		this.fileAttachmentPath = fileAttachmentPath;
		this.fileAttachmentName = fileAttachmentName;
		this.fileAttachmentPageNumber = fileAttachmentPageNumber;
		this.fileAttachmentMark = fileAttachmentMark;
		this.quanzongId = quanzongId;
		this.fileAttachmentAnual = fileAttachmentAnual;
		this.fileCreatetime = fileCreatetime;
		this.fileCreator = fileCreator;
	}

	public String getArchiveFileId() {
		return archiveFileId;
	}

	public void setArchiveFileId(String archiveFileId) {
		this.archiveFileId = archiveFileId;
	}

	public String getArchiveFileAnual() {
		return archiveFileAnual;
	}

	public void setArchiveFileAnual(String archiveFileAnual) {
		this.archiveFileAnual = archiveFileAnual;
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

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getFileAttachmentId() {
		return fileAttachmentId;
	}

	public void setFileAttachmentId(String fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
	}

	public String getFileAttachmentPath() {
		return fileAttachmentPath;
	}

	public void setFileAttachmentPath(String fileAttachmentPath) {
		this.fileAttachmentPath = fileAttachmentPath;
	}

	public String getFileAttachmentName() {
		return fileAttachmentName;
	}

	public void setFileAttachmentName(String fileAttachmentName) {
		this.fileAttachmentName = fileAttachmentName;
	}

	public String getFileAttachmentPageNumber() {
		return fileAttachmentPageNumber;
	}

	public void setFileAttachmentPageNumber(String fileAttachmentPageNumber) {
		this.fileAttachmentPageNumber = fileAttachmentPageNumber;
	}

	public String getFileAttachmentMark() {
		return fileAttachmentMark;
	}

	public void setFileAttachmentMark(String fileAttachmentMark) {
		this.fileAttachmentMark = fileAttachmentMark;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getFileAttachmentAnual() {
		return fileAttachmentAnual;
	}

	public void setFileAttachmentAnual(String fileAttachmentAnual) {
		this.fileAttachmentAnual = fileAttachmentAnual;
	}

	public Date getFileCreatetime() {
		return fileCreatetime;
	}

	public void setFileCreatetime(Date fileCreatetime) {
		this.fileCreatetime = fileCreatetime;
	}

	public String getFileCreator() {
		return fileCreator;
	}

	public void setFileCreator(String fileCreator) {
		this.fileCreator = fileCreator;
	}

	@Override
	public String toString() {
		return "ElecReadingRoomVo [archiveFileId=" + archiveFileId + ", archiveFileAnual=" + archiveFileAnual
				+ ", archiveFileFileNumber=" + archiveFileFileNumber + ", archiveFileReferenceNumber="
				+ archiveFileReferenceNumber + ", archiveFileResponsible=" + archiveFileResponsible
				+ ", archiveFileTitle=" + archiveFileTitle + ", archiveFileCreatetime=" + archiveFileCreatetime
				+ ", quanzongName=" + quanzongName + ", retentionperiodid=" + retentionperiodid
				+ ", retentionperiodname=" + retentionperiodname + ", pcId=" + pcId + ", pcName=" + pcName + ", scId="
				+ scId + ", scName=" + scName + ", conditions=" + conditions + ", fileAttachmentId=" + fileAttachmentId
				+ ", fileAttachmentPath=" + fileAttachmentPath + ", fileAttachmentName=" + fileAttachmentName
				+ ", fileAttachmentPageNumber=" + fileAttachmentPageNumber + ", fileAttachmentMark="
				+ fileAttachmentMark + ", quanzongId=" + quanzongId + ", fileAttachmentAnual=" + fileAttachmentAnual
				+ ", fileCreatetime=" + fileCreatetime + ", fileCreator=" + fileCreator + "]";
	}

}
