package filemanage.collectandorganize.pojo;

import java.util.Date;

import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;
import filemanage.warehouse.pojo.WareHouseStorage;

public class ArchiveFile {
	private String archiveFileId;// 文件主键
	private String archiveFileResponsible;// 责任人
	private String archiveFileCreatetime;// 创建日期（文件形成日期）
	private String archiveFileAnual;// 年度
	private String archiveFileTitle;// 题名
	private String archiveFileScanpople;// 扫描人
	private String archiveFilePages;// 页数
	private Date archiveFileScanDate;// 扫描日期
	private String archiveFileFinishingStatus;// 整理状态(1：待整理 2：整理中 3：已整理)
	private String afSecurityClassrification;// 密级
	private String archiveFileAuthenticateStatus;// 鉴定文件状态(1：全部文件2：待整理文件3：回收文件)
	private String archiveFileFileNumber;// 档号
	private String archiveFileReferenceNumber;// 文号
	private String archiveFileRemark;// 备注
	private String archiveFileIsDelete;// 是否删除0：未删除，1：已删除
	private Archive archive;// 全宗
	private Organization organization;// 机构
	private PrimaryClassFication primaryClassFication;// 一级分类映射类
	private SecondryClassFication secondryClassFication;// 二级分类映射类
	private AmMaSmRetentionperiod amMaSmRetentionperiod;// 保管期限主键
	private AmCoBox amCoBox;// 盒子主键
	private Date finishingTime;// 整理时间
	private Integer signNumber;// 鉴定分类点击保存给予标记 ,默认为0
	private String collator;// 整理人
	private String condition;
	private WareHouseStorage wareHouseStorage;
	private String archiveFileIsUpload;// 文件是否上传(档案著录1:未上传；2:已上传)

	public ArchiveFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchiveFile(String archiveFileId, String archiveFileResponsible, String archiveFileCreatetime,
			String archiveFileAnual, String archiveFileTitle, String archiveFileScanpople, String archiveFilePages,
			Date archiveFileScanDate, String archiveFileFinishingStatus, String afSecurityClassrification,
			String archiveFileAuthenticateStatus, String archiveFileFileNumber, String archiveFileReferenceNumber,
			String archiveFileRemark, String archiveFileIsDelete, Archive archive, Organization organization,
			PrimaryClassFication primaryClassFication, SecondryClassFication secondryClassFication,
			AmMaSmRetentionperiod amMaSmRetentionperiod, AmCoBox amCoBox, Date finishingTime, Integer signNumber,
			String collator, String condition, WareHouseStorage wareHouseStorage, String archiveFileIsUpload) {
		super();
		this.archiveFileId = archiveFileId;
		this.archiveFileResponsible = archiveFileResponsible;
		this.archiveFileCreatetime = archiveFileCreatetime;
		this.archiveFileAnual = archiveFileAnual;
		this.archiveFileTitle = archiveFileTitle;
		this.archiveFileScanpople = archiveFileScanpople;
		this.archiveFilePages = archiveFilePages;
		this.archiveFileScanDate = archiveFileScanDate;
		this.archiveFileFinishingStatus = archiveFileFinishingStatus;
		this.afSecurityClassrification = afSecurityClassrification;
		this.archiveFileAuthenticateStatus = archiveFileAuthenticateStatus;
		this.archiveFileFileNumber = archiveFileFileNumber;
		this.archiveFileReferenceNumber = archiveFileReferenceNumber;
		this.archiveFileRemark = archiveFileRemark;
		this.archiveFileIsDelete = archiveFileIsDelete;
		this.archive = archive;
		this.organization = organization;
		this.primaryClassFication = primaryClassFication;
		this.secondryClassFication = secondryClassFication;
		this.amMaSmRetentionperiod = amMaSmRetentionperiod;
		this.amCoBox = amCoBox;
		this.finishingTime = finishingTime;
		this.signNumber = signNumber;
		this.collator = collator;
		this.condition = condition;
		this.wareHouseStorage = wareHouseStorage;
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

	public String getArchiveFileScanpople() {
		return archiveFileScanpople;
	}

	public void setArchiveFileScanpople(String archiveFileScanpople) {
		this.archiveFileScanpople = archiveFileScanpople;
	}

	public String getArchiveFilePages() {
		return archiveFilePages;
	}

	public void setArchiveFilePages(String archiveFilePages) {
		this.archiveFilePages = archiveFilePages;
	}

	public Date getArchiveFileScanDate() {
		return archiveFileScanDate;
	}

	public void setArchiveFileScanDate(Date archiveFileScanDate) {
		this.archiveFileScanDate = archiveFileScanDate;
	}

	public String getArchiveFileFinishingStatus() {
		return archiveFileFinishingStatus;
	}

	public void setArchiveFileFinishingStatus(String archiveFileFinishingStatus) {
		this.archiveFileFinishingStatus = archiveFileFinishingStatus;
	}

	public String getAfSecurityClassrification() {
		return afSecurityClassrification;
	}

	public void setAfSecurityClassrification(String afSecurityClassrification) {
		this.afSecurityClassrification = afSecurityClassrification;
	}

	public String getArchiveFileAuthenticateStatus() {
		return archiveFileAuthenticateStatus;
	}

	public void setArchiveFileAuthenticateStatus(String archiveFileAuthenticateStatus) {
		this.archiveFileAuthenticateStatus = archiveFileAuthenticateStatus;
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

	public String getArchiveFileRemark() {
		return archiveFileRemark;
	}

	public void setArchiveFileRemark(String archiveFileRemark) {
		this.archiveFileRemark = archiveFileRemark;
	}

	public String getArchiveFileIsDelete() {
		return archiveFileIsDelete;
	}

	public void setArchiveFileIsDelete(String archiveFileIsDelete) {
		this.archiveFileIsDelete = archiveFileIsDelete;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public PrimaryClassFication getPrimaryClassFication() {
		return primaryClassFication;
	}

	public void setPrimaryClassFication(PrimaryClassFication primaryClassFication) {
		this.primaryClassFication = primaryClassFication;
	}

	public SecondryClassFication getSecondryClassFication() {
		return secondryClassFication;
	}

	public void setSecondryClassFication(SecondryClassFication secondryClassFication) {
		this.secondryClassFication = secondryClassFication;
	}

	public AmMaSmRetentionperiod getAmMaSmRetentionperiod() {
		return amMaSmRetentionperiod;
	}

	public void setAmMaSmRetentionperiod(AmMaSmRetentionperiod amMaSmRetentionperiod) {
		this.amMaSmRetentionperiod = amMaSmRetentionperiod;
	}

	public AmCoBox getAmCoBox() {
		return amCoBox;
	}

	public void setAmCoBox(AmCoBox amCoBox) {
		this.amCoBox = amCoBox;
	}

	public Date getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(Date finishingTime) {
		this.finishingTime = finishingTime;
	}

	public Integer getSignNumber() {
		return signNumber;
	}

	public void setSignNumber(Integer signNumber) {
		this.signNumber = signNumber;
	}

	public String getCollator() {
		return collator;
	}

	public void setCollator(String collator) {
		this.collator = collator;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public WareHouseStorage getWareHouseStorage() {
		return wareHouseStorage;
	}


	public void setWareHouseStorage(WareHouseStorage wareHouseStorage) {
		this.wareHouseStorage = wareHouseStorage;
	}

	public String getArchiveFileIsUpload() {
		return archiveFileIsUpload;
	}

	public void setArchiveFileIsUpload(String archiveFileIsUpload) {
		this.archiveFileIsUpload = archiveFileIsUpload;
	}

	@Override
	public String toString() {
		return "ArchiveFile [archiveFileId=" + archiveFileId + ", archiveFileResponsible=" + archiveFileResponsible
				+ ", archiveFileCreatetime=" + archiveFileCreatetime + ", archiveFileAnual=" + archiveFileAnual
				+ ", archiveFileTitle=" + archiveFileTitle + ", archiveFileScanpople=" + archiveFileScanpople
				+ ", archiveFilePages=" + archiveFilePages + ", archiveFileScanDate=" + archiveFileScanDate
				+ ", archiveFileFinishingStatus=" + archiveFileFinishingStatus + ", afSecurityClassrification="
				+ afSecurityClassrification + ", archiveFileAuthenticateStatus=" + archiveFileAuthenticateStatus
				+ ", archiveFileFileNumber=" + archiveFileFileNumber + ", archiveFileReferenceNumber="
				+ archiveFileReferenceNumber + ", archiveFileRemark=" + archiveFileRemark + ", archiveFileIsDelete="
				+ archiveFileIsDelete + ", archive=" + archive + ", organization=" + organization
				+ ", primaryClassFication=" + primaryClassFication + ", secondryClassFication=" + secondryClassFication
				+ ", amMaSmRetentionperiod=" + amMaSmRetentionperiod + ", amCoBox=" + amCoBox + ", finishingTime="
				+ finishingTime + ", signNumber=" + signNumber + ", collator=" + collator + ", condition=" + condition
				+ ", wareHouseStorage=" + wareHouseStorage + ", archiveFileIsUpload=" + archiveFileIsUpload + "]";
	}

	
}
