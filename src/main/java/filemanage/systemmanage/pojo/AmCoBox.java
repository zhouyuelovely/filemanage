package filemanage.systemmanage.pojo;

import java.util.Date;

import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.BoxVo;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;

public class AmCoBox {

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
	private PrimaryClassFication primaryClassFication;// 一级分类主键
	private SecondryClassFication secondryClassFication;// 二级分类
	private BoxVo boxVo;
	private String quanzongId;
	private String quanzongNumber;// 全宗号
	private String quanzongName;// 全宗名
	private String organizationName;// 机构名
	private String retentionperiodname;// 保管期限名称
	private AmCoArchivefile archivefileid; // 文件主键
	private String rummager; // 检查人
	private Date checkTime;// 检查时间
	private String boxReviewstart;// 档案审核状态（档案管理中：待审核/已通过/已驳回）
	private String scName;
	private String conditions;// 关键词查询
	private String boxRejectNum;// 驳回次数
	private String boxBoxingStart;// 装盒状态（档案著录中2已装盒，1未装盒）
	private String joinPlan;// 是否加入计划(1：是，2：否)
	private String storageId;// 入库表主键

	public AmCoBox() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AmCoBox(String storageId) {
		super();
		this.storageId = storageId;
	}

	public AmCoBox(String boxid, String boxsituation, String boxsericalnumber, String boxthickness, String boxpage,
			String boxstatus, String boxcasesnumber, String boxanual, String retentionperiodid, String boxstartnumber,
			String boxendnumber, String boxnumber, Date boxcreatetime, String boxAuditstart, Archive archive,
			Organization organization, AmMaSmRetentionperiod retentionperiod, PrimaryClassFication primaryClassFication,
			SecondryClassFication secondryClassFication, BoxVo boxVo, String quanzongId, String quanzongNumber,
			String quanzongName, String organizationName, String retentionperiodname, AmCoArchivefile archivefileid,
			String rummager, Date checkTime, String boxReviewstart, String scName, String conditions,
			String boxRejectNum, String boxBoxingStart, String joinPlan, String storageId) {
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
		this.boxVo = boxVo;
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.organizationName = organizationName;
		this.retentionperiodname = retentionperiodname;
		this.archivefileid = archivefileid;
		this.rummager = rummager;
		this.checkTime = checkTime;
		this.boxReviewstart = boxReviewstart;
		this.scName = scName;
		this.conditions = conditions;
		this.boxRejectNum = boxRejectNum;
		this.boxBoxingStart = boxBoxingStart;
		this.joinPlan = joinPlan;
		this.storageId = storageId;
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

	public BoxVo getBoxVo() {
		return boxVo;
	}

	public void setBoxVo(BoxVo boxVo) {
		this.boxVo = boxVo;
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

	public AmCoArchivefile getArchivefileid() {
		return archivefileid;
	}

	public void setArchivefileid(AmCoArchivefile archivefileid) {
		this.archivefileid = archivefileid;
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

	public String getBoxRejectNum() {
		return boxRejectNum;
	}

	public void setBoxRejectNum(String boxRejectNum) {
		this.boxRejectNum = boxRejectNum;
	}

	public String getBoxBoxingStart() {
		return boxBoxingStart;
	}

	public void setBoxBoxingStart(String boxBoxingStart) {
		this.boxBoxingStart = boxBoxingStart;
	}

	public String getJoinPlan() {
		return joinPlan;
	}

	public void setJoinPlan(String joinPlan) {
		this.joinPlan = joinPlan;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	@Override
	public String toString() {
		return "AmCoBox [boxid=" + boxid + ", boxsituation=" + boxsituation + ", boxsericalnumber=" + boxsericalnumber
				+ ", boxthickness=" + boxthickness + ", boxpage=" + boxpage + ", boxstatus=" + boxstatus
				+ ", boxcasesnumber=" + boxcasesnumber + ", boxanual=" + boxanual + ", retentionperiodid="
				+ retentionperiodid + ", boxstartnumber=" + boxstartnumber + ", boxendnumber=" + boxendnumber
				+ ", boxnumber=" + boxnumber + ", boxcreatetime=" + boxcreatetime + ", boxAuditstart=" + boxAuditstart
				+ ", archive=" + archive + ", organization=" + organization + ", retentionperiod=" + retentionperiod
				+ ", primaryClassFication=" + primaryClassFication + ", secondryClassFication=" + secondryClassFication
				+ ", boxVo=" + boxVo + ", quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", organizationName=" + organizationName + ", retentionperiodname="
				+ retentionperiodname + ", archivefileid=" + archivefileid + ", rummager=" + rummager + ", checkTime="
				+ checkTime + ", boxReviewstart=" + boxReviewstart + ", scName=" + scName + ", conditions=" + conditions
				+ ", boxRejectNum=" + boxRejectNum + ", boxBoxingStart=" + boxBoxingStart + ", joinPlan=" + joinPlan
				+ ", storageId=" + storageId + "]";
	}

}
