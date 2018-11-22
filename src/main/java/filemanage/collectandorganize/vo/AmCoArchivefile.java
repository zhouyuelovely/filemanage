package filemanage.collectandorganize.vo;

import java.util.Date;

/**
 * 文件工具类
 * @author 陈一达
 * 工具类
 */
public class AmCoArchivefile {

	private String archivefileid;									//文件主键
	private String archivefileresponsible;							//责任人
	private String archivefilecreatetime;							//创建日期（文件形成日期）
	private String archivefileanual;								//年度
	private String archivefiletitle;								//题名
	private String archivefilescanpople;							//扫描人
	private String quanzongid;										//全宗主键
	private String archivefilepages;								//页数
	private String archivefilescandate;								//扫描日期
	private String archivefilefinishingstatus;						//整理状态(1：待整理 2：整理中 3：已整理)
	private String organizationid;									//机构主键
	private String primaryclassificationid;							//一级分类主键
	private String pcname;											//一级分类姓名
	private String secondaryclassificationid;						//二级分类主键
	private String scname;											//二级分类姓名
	private String retentionperiodid;								//保管期限主键
	private String retentionperiodname;								//保管期限名称
	private String afsecurityclassrification;						//密级
	private String archivefileauthenticatestatus;					//鉴定文件状态(1：全部文件：待整理文件3：回收文件)
	private String archivefilefilenumber;							//档号
	private String archivefilereferencenumber;						//文号
	private String archivefileremark;								//备注
	private String boxid;											//盒子主键
	private Date finishingTime;                                     //整理时间
	private Integer signNumber;                                   //鉴定分类点击保存给予标记 ,默认为0
	private String collator;                                          //整理人
	private String boxnumber;                                        //盒号
	private String conditions;                                       //关键词
	
	public AmCoArchivefile() {
		super();
	}

	public AmCoArchivefile(String archivefileid, String archivefileresponsible, String archivefilecreatetime,
			String archivefileanual, String archivefiletitle, String archivefilescanpople, String quanzongid,
			String archivefilepages, String archivefilescandate, String archivefilefinishingstatus,
			String organizationid, String primaryclassificationid, String pcname, String secondaryclassificationid,
			String scname, String retentionperiodid, String retentionperiodname, String afsecurityclassrification,
			String archivefileauthenticatestatus, String archivefilefilenumber, String archivefilereferencenumber,
			String archivefileremark, String boxid, Date finishingTime, Integer signNumber, String collator,
			String boxnumber, String conditions) {
		super();
		this.archivefileid = archivefileid;
		this.archivefileresponsible = archivefileresponsible;
		this.archivefilecreatetime = archivefilecreatetime;
		this.archivefileanual = archivefileanual;
		this.archivefiletitle = archivefiletitle;
		this.archivefilescanpople = archivefilescanpople;
		this.quanzongid = quanzongid;
		this.archivefilepages = archivefilepages;
		this.archivefilescandate = archivefilescandate;
		this.archivefilefinishingstatus = archivefilefinishingstatus;
		this.organizationid = organizationid;
		this.primaryclassificationid = primaryclassificationid;
		this.pcname = pcname;
		this.secondaryclassificationid = secondaryclassificationid;
		this.scname = scname;
		this.retentionperiodid = retentionperiodid;
		this.retentionperiodname = retentionperiodname;
		this.afsecurityclassrification = afsecurityclassrification;
		this.archivefileauthenticatestatus = archivefileauthenticatestatus;
		this.archivefilefilenumber = archivefilefilenumber;
		this.archivefilereferencenumber = archivefilereferencenumber;
		this.archivefileremark = archivefileremark;
		this.boxid = boxid;
		this.finishingTime = finishingTime;
		this.signNumber = signNumber;
		this.collator = collator;
		this.boxnumber = boxnumber;
		this.conditions = conditions;
	}

	public String getArchivefileid() {
		return archivefileid;
	}

	public void setArchivefileid(String archivefileid) {
		this.archivefileid = archivefileid;
	}

	public String getArchivefileresponsible() {
		return archivefileresponsible;
	}

	public void setArchivefileresponsible(String archivefileresponsible) {
		this.archivefileresponsible = archivefileresponsible;
	}

	public String getArchivefilecreatetime() {
		return archivefilecreatetime;
	}

	public void setArchivefilecreatetime(String archivefilecreatetime) {
		this.archivefilecreatetime = archivefilecreatetime;
	}

	public String getArchivefileanual() {
		return archivefileanual;
	}

	public void setArchivefileanual(String archivefileanual) {
		this.archivefileanual = archivefileanual;
	}

	public String getArchivefiletitle() {
		return archivefiletitle;
	}

	public void setArchivefiletitle(String archivefiletitle) {
		this.archivefiletitle = archivefiletitle;
	}

	public String getArchivefilescanpople() {
		return archivefilescanpople;
	}

	public void setArchivefilescanpople(String archivefilescanpople) {
		this.archivefilescanpople = archivefilescanpople;
	}

	public String getQuanzongid() {
		return quanzongid;
	}

	public void setQuanzongid(String quanzongid) {
		this.quanzongid = quanzongid;
	}

	public String getArchivefilepages() {
		return archivefilepages;
	}

	public void setArchivefilepages(String archivefilepages) {
		this.archivefilepages = archivefilepages;
	}

	public String getArchivefilescandate() {
		return archivefilescandate;
	}

	public void setArchivefilescandate(String archivefilescandate) {
		this.archivefilescandate = archivefilescandate;
	}

	public String getArchivefilefinishingstatus() {
		return archivefilefinishingstatus;
	}

	public void setArchivefilefinishingstatus(String archivefilefinishingstatus) {
		this.archivefilefinishingstatus = archivefilefinishingstatus;
	}

	public String getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}

	public String getPrimaryclassificationid() {
		return primaryclassificationid;
	}

	public void setPrimaryclassificationid(String primaryclassificationid) {
		this.primaryclassificationid = primaryclassificationid;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public String getSecondaryclassificationid() {
		return secondaryclassificationid;
	}

	public void setSecondaryclassificationid(String secondaryclassificationid) {
		this.secondaryclassificationid = secondaryclassificationid;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
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

	public String getAfsecurityclassrification() {
		return afsecurityclassrification;
	}

	public void setAfsecurityclassrification(String afsecurityclassrification) {
		this.afsecurityclassrification = afsecurityclassrification;
	}

	public String getArchivefileauthenticatestatus() {
		return archivefileauthenticatestatus;
	}

	public void setArchivefileauthenticatestatus(String archivefileauthenticatestatus) {
		this.archivefileauthenticatestatus = archivefileauthenticatestatus;
	}

	public String getArchivefilefilenumber() {
		return archivefilefilenumber;
	}

	public void setArchivefilefilenumber(String archivefilefilenumber) {
		this.archivefilefilenumber = archivefilefilenumber;
	}

	public String getArchivefilereferencenumber() {
		return archivefilereferencenumber;
	}

	public void setArchivefilereferencenumber(String archivefilereferencenumber) {
		this.archivefilereferencenumber = archivefilereferencenumber;
	}

	public String getArchivefileremark() {
		return archivefileremark;
	}

	public void setArchivefileremark(String archivefileremark) {
		this.archivefileremark = archivefileremark;
	}

	public String getBoxid() {
		return boxid;
	}

	public void setBoxid(String boxid) {
		this.boxid = boxid;
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

	public String getBoxnumber() {
		return boxnumber;
	}

	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "AmCoArchivefile [archivefileid=" + archivefileid + ", archivefileresponsible=" + archivefileresponsible
				+ ", archivefilecreatetime=" + archivefilecreatetime + ", archivefileanual=" + archivefileanual
				+ ", archivefiletitle=" + archivefiletitle + ", archivefilescanpople=" + archivefilescanpople
				+ ", quanzongid=" + quanzongid + ", archivefilepages=" + archivefilepages + ", archivefilescandate="
				+ archivefilescandate + ", archivefilefinishingstatus=" + archivefilefinishingstatus
				+ ", organizationid=" + organizationid + ", primaryclassificationid=" + primaryclassificationid
				+ ", pcname=" + pcname + ", secondaryclassificationid=" + secondaryclassificationid + ", scname="
				+ scname + ", retentionperiodid=" + retentionperiodid + ", retentionperiodname=" + retentionperiodname
				+ ", afsecurityclassrification=" + afsecurityclassrification + ", archivefileauthenticatestatus="
				+ archivefileauthenticatestatus + ", archivefilefilenumber=" + archivefilefilenumber
				+ ", archivefilereferencenumber=" + archivefilereferencenumber + ", archivefileremark="
				+ archivefileremark + ", boxid=" + boxid + ", finishingTime=" + finishingTime + ", signNumber="
				+ signNumber + ", collator=" + collator + ", boxnumber=" + boxnumber + ", conditions=" + conditions
				+ "]";
	}

	
	
	

	
	
	
	
	
}
