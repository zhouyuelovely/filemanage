package filemanage.collectandorganize.pojo;

import java.util.Date;

public class FileAttachment {
	private String fileAttachmentId;// 附件主键
	private String fileAttachmentPath;// 附件地址
	private String fileAttachmentName;// 附件名称
	private String archiveFileId;// 文件主键
	private String fileAttachmentPageNumber;// 页码
	private String fileAttachmentMark;// 标记1：封面
	private String quanzongId;// 全宗主键
	private String fileAttachmentAnual;// 文件年度
	private Date fileCreatetime;//创建时间
	private String fileCreator;//创建人
	
	public FileAttachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileAttachment(String fileAttachmentId, String fileAttachmentPath, String fileAttachmentName,
			String archiveFileId, String fileAttachmentPageNumber, String fileAttachmentMark, String quanzongId,
			String fileAttachmentAnual, Date fileCreatetime, String fileCreator) {
		super();
		this.fileAttachmentId = fileAttachmentId;
		this.fileAttachmentPath = fileAttachmentPath;
		this.fileAttachmentName = fileAttachmentName;
		this.archiveFileId = archiveFileId;
		this.fileAttachmentPageNumber = fileAttachmentPageNumber;
		this.fileAttachmentMark = fileAttachmentMark;
		this.quanzongId = quanzongId;
		this.fileAttachmentAnual = fileAttachmentAnual;
		this.fileCreatetime = fileCreatetime;
		this.fileCreator = fileCreator;
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

	public String getArchiveFileId() {
		return archiveFileId;
	}

	public void setArchiveFileId(String archiveFileId) {
		this.archiveFileId = archiveFileId;
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
		return "FileAttachment [fileAttachmentId=" + fileAttachmentId + ", fileAttachmentPath=" + fileAttachmentPath
				+ ", fileAttachmentName=" + fileAttachmentName + ", archiveFileId=" + archiveFileId
				+ ", fileAttachmentPageNumber=" + fileAttachmentPageNumber + ", fileAttachmentMark="
				+ fileAttachmentMark + ", quanzongId=" + quanzongId + ", fileAttachmentAnual=" + fileAttachmentAnual
				+ ", fileCreatetime=" + fileCreatetime + ", fileCreator=" + fileCreator + "]";
	}

	
	
}
