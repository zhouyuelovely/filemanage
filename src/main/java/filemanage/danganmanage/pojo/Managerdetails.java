package filemanage.danganmanage.pojo;

import filemanage.collectandorganize.vo.AmCoArchivefile;

/**
 * @author tchuanwu
 * 档案管理明细映射类
 */
public class Managerdetails {
	private String managerDetailsId; //管理明细主键
	private String managerDetailsApplication; //申请项
	private String managerDetailsBeforeChange; //变更前
	private String managerDetailsAfterChange; //变更后
	private String managerDetailsReason; //申请事由
	private String managerDetailsPerson; //申请人
	private String managerDetailsTime; //申请时间
	private String managerDetailsReviewer;//审核人
	private String managerDetailsAudittime;//审核时间
	private String managerDetailsStatus;//审核状态(1:待审核，2:已驳回，3:已通过)
	private String id; //档案盒主键/件主键
	private String idStatus;// 1表示以件为主键状态,2 表示以盒为主键状态
	private String pcName;//档案类型
	private String boxsericalnumber;//盒子编号
	private String archivefilefilenumber;//档号
	private String boxanual; //年度
	private String retentionperiodid; //保管期限主键
	private String managerDetailsBohuiReason;//驳回原因
	private AmCoArchivefile amCoArchivefile; // 文件主键
	private String isDelete; //是否删除  1:不删除  2:删除
	private String flag; //1:历史数据  0:其他
	
	public Managerdetails() {
		
	}

	public Managerdetails(String managerDetailsId, String managerDetailsApplication, String managerDetailsBeforeChange,
			String managerDetailsAfterChange, String managerDetailsReason, String managerDetailsPerson,
			String managerDetailsTime, String managerDetailsReviewer, String managerDetailsAudittime,
			String managerDetailsStatus, String id, String idStatus, String pcName, String boxsericalnumber,
			String archivefilefilenumber, String boxanual, String retentionperiodid, String managerDetailsBohuiReason,
			AmCoArchivefile amCoArchivefile, String isDelete, String flag) {
		super();
		this.managerDetailsId = managerDetailsId;
		this.managerDetailsApplication = managerDetailsApplication;
		this.managerDetailsBeforeChange = managerDetailsBeforeChange;
		this.managerDetailsAfterChange = managerDetailsAfterChange;
		this.managerDetailsReason = managerDetailsReason;
		this.managerDetailsPerson = managerDetailsPerson;
		this.managerDetailsTime = managerDetailsTime;
		this.managerDetailsReviewer = managerDetailsReviewer;
		this.managerDetailsAudittime = managerDetailsAudittime;
		this.managerDetailsStatus = managerDetailsStatus;
		this.id = id;
		this.idStatus = idStatus;
		this.pcName = pcName;
		this.boxsericalnumber = boxsericalnumber;
		this.archivefilefilenumber = archivefilefilenumber;
		this.boxanual = boxanual;
		this.retentionperiodid = retentionperiodid;
		this.managerDetailsBohuiReason = managerDetailsBohuiReason;
		this.amCoArchivefile = amCoArchivefile;
		this.isDelete = isDelete;
		this.flag = flag;
	}

	public String getManagerDetailsId() {
		return managerDetailsId;
	}

	public void setManagerDetailsId(String managerDetailsId) {
		this.managerDetailsId = managerDetailsId;
	}

	public String getManagerDetailsApplication() {
		return managerDetailsApplication;
	}

	public void setManagerDetailsApplication(String managerDetailsApplication) {
		this.managerDetailsApplication = managerDetailsApplication;
	}

	public String getManagerDetailsBeforeChange() {
		return managerDetailsBeforeChange;
	}

	public void setManagerDetailsBeforeChange(String managerDetailsBeforeChange) {
		this.managerDetailsBeforeChange = managerDetailsBeforeChange;
	}

	public String getManagerDetailsAfterChange() {
		return managerDetailsAfterChange;
	}

	public void setManagerDetailsAfterChange(String managerDetailsAfterChange) {
		this.managerDetailsAfterChange = managerDetailsAfterChange;
	}

	public String getManagerDetailsReason() {
		return managerDetailsReason;
	}

	public void setManagerDetailsReason(String managerDetailsReason) {
		this.managerDetailsReason = managerDetailsReason;
	}

	public String getManagerDetailsPerson() {
		return managerDetailsPerson;
	}

	public void setManagerDetailsPerson(String managerDetailsPerson) {
		this.managerDetailsPerson = managerDetailsPerson;
	}

	public String getManagerDetailsTime() {
		return managerDetailsTime;
	}

	public void setManagerDetailsTime(String managerDetailsTime) {
		this.managerDetailsTime = managerDetailsTime;
	}

	public String getManagerDetailsReviewer() {
		return managerDetailsReviewer;
	}

	public void setManagerDetailsReviewer(String managerDetailsReviewer) {
		this.managerDetailsReviewer = managerDetailsReviewer;
	}

	public String getManagerDetailsAudittime() {
		return managerDetailsAudittime;
	}

	public void setManagerDetailsAudittime(String managerDetailsAudittime) {
		this.managerDetailsAudittime = managerDetailsAudittime;
	}

	public String getManagerDetailsStatus() {
		return managerDetailsStatus;
	}

	public void setManagerDetailsStatus(String managerDetailsStatus) {
		this.managerDetailsStatus = managerDetailsStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getBoxsericalnumber() {
		return boxsericalnumber;
	}

	public void setBoxsericalnumber(String boxsericalnumber) {
		this.boxsericalnumber = boxsericalnumber;
	}

	public String getArchivefilefilenumber() {
		return archivefilefilenumber;
	}

	public void setArchivefilefilenumber(String archivefilefilenumber) {
		this.archivefilefilenumber = archivefilefilenumber;
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

	public String getManagerDetailsBohuiReason() {
		return managerDetailsBohuiReason;
	}

	public void setManagerDetailsBohuiReason(String managerDetailsBohuiReason) {
		this.managerDetailsBohuiReason = managerDetailsBohuiReason;
	}

	public AmCoArchivefile getAmCoArchivefile() {
		return amCoArchivefile;
	}

	public void setAmCoArchivefile(AmCoArchivefile amCoArchivefile) {
		this.amCoArchivefile = amCoArchivefile;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Managerdetails [managerDetailsId=" + managerDetailsId + ", managerDetailsApplication="
				+ managerDetailsApplication + ", managerDetailsBeforeChange=" + managerDetailsBeforeChange
				+ ", managerDetailsAfterChange=" + managerDetailsAfterChange + ", managerDetailsReason="
				+ managerDetailsReason + ", managerDetailsPerson=" + managerDetailsPerson + ", managerDetailsTime="
				+ managerDetailsTime + ", managerDetailsReviewer=" + managerDetailsReviewer
				+ ", managerDetailsAudittime=" + managerDetailsAudittime + ", managerDetailsStatus="
				+ managerDetailsStatus + ", id=" + id + ", idStatus=" + idStatus + ", pcName=" + pcName
				+ ", boxsericalnumber=" + boxsericalnumber + ", archivefilefilenumber=" + archivefilefilenumber
				+ ", boxanual=" + boxanual + ", retentionperiodid=" + retentionperiodid + ", managerDetailsBohuiReason="
				+ managerDetailsBohuiReason + ", amCoArchivefile=" + amCoArchivefile + ", isDelete=" + isDelete
				+ ", flag=" + flag + "]";
	}

	
	
	
	
	
	

	
	
	
	

}
