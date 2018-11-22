package filemanage.danganmanage.vo;

import java.util.Date;

import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.BoxVo;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;

public class AmCoBoxConditons {
	private String boxid; // 盒子主键
	private String boxsituation; // 盒内情况说明
	private String boxsericalnumber; // 盒子编号
	private String boxthickness; // 盒厚度
	private String boxpage; // 可装页数
	private String boxstatus; // 盒状态
	private String boxcasesnumber; // 件数
	private String boxanual; // 年度
	private String retentionperiodid; // 保管期限主键
	private String boxstartnumber; // 起件号
	private String boxendnumber; // 止件号
	private String boxnumber; // 盒号
	private Date boxcreatetime; // 创建日期
	private String boxAuditstart; // 盒审核状态
	private Archive archive; // 全宗
	private Organization organization; // 机构
	private AmMaSmRetentionperiod retentionperiod; // 保管期限
	private PrimaryClassFication primaryClassFication;//
	private SecondryClassFication secondryClassFication;// 二级分类
	private String pcId;
	private String quanzongId;
	private String quanzongNumber;// 全宗号
	private String quanzongName;// 全宗名
	private String organizationName;// 机构名
	private String retentionperiodname;// 保管期限名称
	private AmCoArchivefile amCoArchivefile; // 文件主键
	private String rummager; // 检查人
	private Date checkTime;// 检查时间
	private String boxReviewstart;// 档案审核状态（档案管理中：待审核/已通过/已驳回）
	private String scName;
	private String conditions;// 关键词查询
	private String archivefileresponsible;							//责任人
	private String archivefilecreatetime;							//创建日期（文件形成日期）
	private String archivefiletitle;								//题名
	private String archivefilepages;								//页数
	private String afsecurityclassrification;						//密级
	private String archivefilefilenumber;							//档号
	private String archivefilereferencenumber;						//文号
	private String archivefileremark;
	
	public AmCoBoxConditons() {
		
	}

	public AmCoBoxConditons(String boxid, String boxsituation, String boxsericalnumber, String boxthickness,
			String boxpage, String boxstatus, String boxcasesnumber, String boxanual, String retentionperiodid,
			String boxstartnumber, String boxendnumber, String boxnumber, Date boxcreatetime, String boxAuditstart,
			Archive archive, Organization organization, AmMaSmRetentionperiod retentionperiod,
			PrimaryClassFication primaryClassFication, SecondryClassFication secondryClassFication, String pcId,
			String quanzongId, String quanzongNumber, String quanzongName, String organizationName,
			String retentionperiodname, AmCoArchivefile amCoArchivefile, String rummager, Date checkTime,
			String boxReviewstart, String scName, String conditions, String archivefileresponsible,
			String archivefilecreatetime, String archivefiletitle, String archivefilepages,
			String afsecurityclassrification, String archivefilefilenumber, String archivefilereferencenumber,
			String archivefileremark) {
		super();
		this.boxid = boxid;
		this.boxsituation = boxsituation;
		this.boxsericalnumber = boxsericalnumber;
		this.boxthickness = boxthickness;
		this.boxpage = boxpage;
		this.boxstatus = boxstatus;
		this.boxcasesnumber = boxcasesnumber;
		this.boxanual = boxanual;
		this.retentionperiodid = retentionperiodid;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.boxnumber = boxnumber;
		this.boxcreatetime = boxcreatetime;
		this.boxAuditstart = boxAuditstart;
		this.archive = archive;
		this.organization = organization;
		this.retentionperiod = retentionperiod;
		this.primaryClassFication = primaryClassFication;
		this.secondryClassFication = secondryClassFication;
		this.pcId = pcId;
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.organizationName = organizationName;
		this.retentionperiodname = retentionperiodname;
		this.amCoArchivefile = amCoArchivefile;
		this.rummager = rummager;
		this.checkTime = checkTime;
		this.boxReviewstart = boxReviewstart;
		this.scName = scName;
		this.conditions = conditions;
		this.archivefileresponsible = archivefileresponsible;
		this.archivefilecreatetime = archivefilecreatetime;
		this.archivefiletitle = archivefiletitle;
		this.archivefilepages = archivefilepages;
		this.afsecurityclassrification = afsecurityclassrification;
		this.archivefilefilenumber = archivefilefilenumber;
		this.archivefilereferencenumber = archivefilereferencenumber;
		this.archivefileremark = archivefileremark;
	}

	public String getBoxid() {
		return boxid;
	}

	public void setBoxid(String boxid) {
		this.boxid = boxid;
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

	public String getBoxstatus() {
		return boxstatus;
	}

	public void setBoxstatus(String boxstatus) {
		this.boxstatus = boxstatus;
	}

	public String getBoxcasesnumber() {
		return boxcasesnumber;
	}

	public void setBoxcasesnumber(String boxcasesnumber) {
		this.boxcasesnumber = boxcasesnumber;
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

	public Date getBoxcreatetime() {
		return boxcreatetime;
	}

	public void setBoxcreatetime(Date boxcreatetime) {
		this.boxcreatetime = boxcreatetime;
	}

	public String getBoxAuditstart() {
		return boxAuditstart;
	}

	public void setBoxAuditstart(String boxAuditstart) {
		this.boxAuditstart = boxAuditstart;
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

	public AmMaSmRetentionperiod getRetentionperiod() {
		return retentionperiod;
	}

	public void setRetentionperiod(AmMaSmRetentionperiod retentionperiod) {
		this.retentionperiod = retentionperiod;
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

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getQuanzongNumber() {
		return quanzongNumber;
	}

	public void setQuanzongNumber(String quanzongNumber) {
		this.quanzongNumber = quanzongNumber;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}

	public AmCoArchivefile getAmCoArchivefile() {
		return amCoArchivefile;
	}

	public void setAmCoArchivefile(AmCoArchivefile amCoArchivefile) {
		this.amCoArchivefile = amCoArchivefile;
	}

	public String getRummager() {
		return rummager;
	}

	public void setRummager(String rummager) {
		this.rummager = rummager;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getBoxReviewstart() {
		return boxReviewstart;
	}

	public void setBoxReviewstart(String boxReviewstart) {
		this.boxReviewstart = boxReviewstart;
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

	public String getArchivefiletitle() {
		return archivefiletitle;
	}

	public void setArchivefiletitle(String archivefiletitle) {
		this.archivefiletitle = archivefiletitle;
	}

	public String getArchivefilepages() {
		return archivefilepages;
	}

	public void setArchivefilepages(String archivefilepages) {
		this.archivefilepages = archivefilepages;
	}

	public String getAfsecurityclassrification() {
		return afsecurityclassrification;
	}

	public void setAfsecurityclassrification(String afsecurityclassrification) {
		this.afsecurityclassrification = afsecurityclassrification;
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

	@Override
	public String toString() {
		return "AmCoBoxConditons [boxid=" + boxid + ", boxsituation=" + boxsituation + ", boxsericalnumber="
				+ boxsericalnumber + ", boxthickness=" + boxthickness + ", boxpage=" + boxpage + ", boxstatus="
				+ boxstatus + ", boxcasesnumber=" + boxcasesnumber + ", boxanual=" + boxanual + ", retentionperiodid="
				+ retentionperiodid + ", boxstartnumber=" + boxstartnumber + ", boxendnumber=" + boxendnumber
				+ ", boxnumber=" + boxnumber + ", boxcreatetime=" + boxcreatetime + ", boxAuditstart=" + boxAuditstart
				+ ", archive=" + archive + ", organization=" + organization + ", retentionperiod=" + retentionperiod
				+ ", primaryClassFication=" + primaryClassFication + ", secondryClassFication=" + secondryClassFication
				+ ", pcId=" + pcId + ", quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", organizationName=" + organizationName + ", retentionperiodname="
				+ retentionperiodname + ", amCoArchivefile=" + amCoArchivefile + ", rummager=" + rummager
				+ ", checkTime=" + checkTime + ", boxReviewstart=" + boxReviewstart + ", scName=" + scName
				+ ", conditions=" + conditions + ", archivefileresponsible=" + archivefileresponsible
				+ ", archivefilecreatetime=" + archivefilecreatetime + ", archivefiletitle=" + archivefiletitle
				+ ", archivefilepages=" + archivefilepages + ", afsecurityclassrification=" + afsecurityclassrification
				+ ", archivefilefilenumber=" + archivefilefilenumber + ", archivefilereferencenumber="
				+ archivefilereferencenumber + ", archivefileremark=" + archivefileremark + "]";
	}

	

	
	
	
	

}
