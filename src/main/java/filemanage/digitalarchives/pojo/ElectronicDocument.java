package filemanage.digitalarchives.pojo;

import java.util.Date;

import filemanage.systemmanage.pojo.Archive;

/**
 * @author FYX
 *
 */
public class ElectronicDocument {
	private String archivefileId;//主键
	private String archivefileAnual;//文件年度
	private String archivefileCreatetime;//文件日期
	private String archivefileResponsible;//责任人
	private String archivefileReferencenumber;//文号
	private String archivefileTitle;//题名
	private Date receiptTime;//接收/导入时间
	private Archive archive;// 全宗信息
	private String startDate;//开始时间
	private String endDate;//开始时间
	
	public ElectronicDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicDocument(String archivefileId, String archivefileAnual, String archivefileCreatetime,
			String archivefileResponsible, String archivefileReferencenumber, String archivefileTitle, Date receiptTime,
			Archive archive, String startDate, String endDate) {
		super();
		this.archivefileId = archivefileId;
		this.archivefileAnual = archivefileAnual;
		this.archivefileCreatetime = archivefileCreatetime;
		this.archivefileResponsible = archivefileResponsible;
		this.archivefileReferencenumber = archivefileReferencenumber;
		this.archivefileTitle = archivefileTitle;
		this.receiptTime = receiptTime;
		this.archive = archive;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getArchivefileId() {
		return archivefileId;
	}

	public void setArchivefileId(String archivefileId) {
		this.archivefileId = archivefileId;
	}

	public String getArchivefileAnual() {
		return archivefileAnual;
	}

	public void setArchivefileAnual(String archivefileAnual) {
		this.archivefileAnual = archivefileAnual;
	}

	public String getArchivefileCreatetime() {
		return archivefileCreatetime;
	}

	public void setArchivefileCreatetime(String archivefileCreatetime) {
		this.archivefileCreatetime = archivefileCreatetime;
	}

	public String getArchivefileResponsible() {
		return archivefileResponsible;
	}

	public void setArchivefileResponsible(String archivefileResponsible) {
		this.archivefileResponsible = archivefileResponsible;
	}

	public String getArchivefileReferencenumber() {
		return archivefileReferencenumber;
	}

	public void setArchivefileReferencenumber(String archivefileReferencenumber) {
		this.archivefileReferencenumber = archivefileReferencenumber;
	}

	public String getArchivefileTitle() {
		return archivefileTitle;
	}

	public void setArchivefileTitle(String archivefileTitle) {
		this.archivefileTitle = archivefileTitle;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ElectronicDocument [archivefileId=" + archivefileId + ", archivefileAnual=" + archivefileAnual
				+ ", archivefileCreatetime=" + archivefileCreatetime + ", archivefileResponsible="
				+ archivefileResponsible + ", archivefileReferencenumber=" + archivefileReferencenumber
				+ ", archivefileTitle=" + archivefileTitle + ", receiptTime=" + receiptTime + ", archive=" + archive
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
