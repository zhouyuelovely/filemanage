package filemanage.warehouse.vo;

/**
 * @author mlt 档案管理_档案入库辅助类
 */
public class ArchiveInWareHouseAssist {

	private String boxId;// 档案盒主键
	private String boxAnual;// 档案盒年度
	private String boxSericalNumber;// 盒编号
	private String boxNumber;// 档案盒号
	private String boxThickness;// 档案盒属性
	private String boxStatus;// 档案盒状态
	private String boxCasesNumber;// 件数
	private String boxAuditStart;// 档案盒审核状态
	private String wareHouseBuildId;// 库房表主键
	private String wareHouseBuildNumber;// 库房号
	private String wareHouseBuildName;// 库房名称
	private String wareHouseBuildShelfNumber;// 密集架编号
	private String wareHouseBuildGroupNumber;// 组编号
	private String wareHouseBuildLatticeNumber;// 格子编号
	private String storageId;// 入库表主键
	private String storageRackNumber;// 架位号
	private String storageIsplan;// 是否加入计划(1:是，2：否)
	private String planId;// 计划表主键
	private String quanzongId;// 全宗主键
	private String quanzongNumber;// 全宗号
	private String quanzongName;// 全宗名称
	private String retentionperiodId;// 保管期限主键
	private String retentionperiodCode;// 保管期限代码
	private String retentionperiodName;// 保管期限名称
	private String pcId;// 一级分类主键
	private String pcCode;// 一级分类代码
	private String pcName;// 一级分类名称
	private String scId;// 二级分类主键
	private String scCode;// 二级分类代码
	private String scName;// 二级分类名称
	private String str;
	private String uuid;

	public ArchiveInWareHouseAssist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchiveInWareHouseAssist(String boxId, String boxAnual, String boxSericalNumber, String boxNumber,
			String boxThickness, String boxStatus, String boxCasesNumber, String boxAuditStart, String wareHouseBuildId,
			String wareHouseBuildNumber, String wareHouseBuildName, String wareHouseBuildShelfNumber,
			String wareHouseBuildGroupNumber, String wareHouseBuildLatticeNumber, String storageId,
			String storageRackNumber, String storageIsplan, String planId, String quanzongId, String quanzongNumber,
			String quanzongName, String retentionperiodId, String retentionperiodCode, String retentionperiodName,
			String pcId, String pcCode, String pcName, String scId, String scCode, String scName, String str,
			String uuid) {
		super();
		this.boxId = boxId;
		this.boxAnual = boxAnual;
		this.boxSericalNumber = boxSericalNumber;
		this.boxNumber = boxNumber;
		this.boxThickness = boxThickness;
		this.boxStatus = boxStatus;
		this.boxCasesNumber = boxCasesNumber;
		this.boxAuditStart = boxAuditStart;
		this.wareHouseBuildId = wareHouseBuildId;
		this.wareHouseBuildNumber = wareHouseBuildNumber;
		this.wareHouseBuildName = wareHouseBuildName;
		this.wareHouseBuildShelfNumber = wareHouseBuildShelfNumber;
		this.wareHouseBuildGroupNumber = wareHouseBuildGroupNumber;
		this.wareHouseBuildLatticeNumber = wareHouseBuildLatticeNumber;
		this.storageId = storageId;
		this.storageRackNumber = storageRackNumber;
		this.storageIsplan = storageIsplan;
		this.planId = planId;
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.retentionperiodId = retentionperiodId;
		this.retentionperiodCode = retentionperiodCode;
		this.retentionperiodName = retentionperiodName;
		this.pcId = pcId;
		this.pcCode = pcCode;
		this.pcName = pcName;
		this.scId = scId;
		this.scCode = scCode;
		this.scName = scName;
		this.str = str;
		this.uuid = uuid;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxAnual() {
		return boxAnual;
	}

	public void setBoxAnual(String boxAnual) {
		this.boxAnual = boxAnual;
	}

	public String getBoxSericalNumber() {
		return boxSericalNumber;
	}

	public void setBoxSericalNumber(String boxSericalNumber) {
		this.boxSericalNumber = boxSericalNumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getBoxThickness() {
		return boxThickness;
	}

	public void setBoxThickness(String boxThickness) {
		this.boxThickness = boxThickness;
	}

	public String getBoxStatus() {
		return boxStatus;
	}

	public void setBoxStatus(String boxStatus) {
		this.boxStatus = boxStatus;
	}

	public String getBoxCasesNumber() {
		return boxCasesNumber;
	}

	public void setBoxCasesNumber(String boxCasesNumber) {
		this.boxCasesNumber = boxCasesNumber;
	}

	public String getBoxAuditStart() {
		return boxAuditStart;
	}

	public void setBoxAuditStart(String boxAuditStart) {
		this.boxAuditStart = boxAuditStart;
	}

	public String getWareHouseBuildId() {
		return wareHouseBuildId;
	}

	public void setWareHouseBuildId(String wareHouseBuildId) {
		this.wareHouseBuildId = wareHouseBuildId;
	}

	public String getWareHouseBuildNumber() {
		return wareHouseBuildNumber;
	}

	public void setWareHouseBuildNumber(String wareHouseBuildNumber) {
		this.wareHouseBuildNumber = wareHouseBuildNumber;
	}

	public String getWareHouseBuildName() {
		return wareHouseBuildName;
	}

	public void setWareHouseBuildName(String wareHouseBuildName) {
		this.wareHouseBuildName = wareHouseBuildName;
	}

	public String getWareHouseBuildShelfNumber() {
		return wareHouseBuildShelfNumber;
	}

	public void setWareHouseBuildShelfNumber(String wareHouseBuildShelfNumber) {
		this.wareHouseBuildShelfNumber = wareHouseBuildShelfNumber;
	}

	public String getWareHouseBuildGroupNumber() {
		return wareHouseBuildGroupNumber;
	}

	public void setWareHouseBuildGroupNumber(String wareHouseBuildGroupNumber) {
		this.wareHouseBuildGroupNumber = wareHouseBuildGroupNumber;
	}

	public String getWareHouseBuildLatticeNumber() {
		return wareHouseBuildLatticeNumber;
	}

	public void setWareHouseBuildLatticeNumber(String wareHouseBuildLatticeNumber) {
		this.wareHouseBuildLatticeNumber = wareHouseBuildLatticeNumber;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageRackNumber() {
		return storageRackNumber;
	}

	public void setStorageRackNumber(String storageRackNumber) {
		this.storageRackNumber = storageRackNumber;
	}

	public String getStorageIsplan() {
		return storageIsplan;
	}

	public void setStorageIsplan(String storageIsplan) {
		this.storageIsplan = storageIsplan;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
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

	public String getRetentionperiodId() {
		return retentionperiodId;
	}

	public void setRetentionperiodId(String retentionperiodId) {
		this.retentionperiodId = retentionperiodId;
	}

	public String getRetentionperiodCode() {
		return retentionperiodCode;
	}

	public void setRetentionperiodCode(String retentionperiodCode) {
		this.retentionperiodCode = retentionperiodCode;
	}

	public String getRetentionperiodName() {
		return retentionperiodName;
	}

	public void setRetentionperiodName(String retentionperiodName) {
		this.retentionperiodName = retentionperiodName;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getPcCode() {
		return pcCode;
	}

	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
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

	public String getScCode() {
		return scCode;
	}

	public void setScCode(String scCode) {
		this.scCode = scCode;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "ArchiveInWareHouseAssist [boxId=" + boxId + ", boxAnual=" + boxAnual + ", boxSericalNumber="
				+ boxSericalNumber + ", boxNumber=" + boxNumber + ", boxThickness=" + boxThickness + ", boxStatus="
				+ boxStatus + ", boxCasesNumber=" + boxCasesNumber + ", boxAuditStart=" + boxAuditStart
				+ ", wareHouseBuildId=" + wareHouseBuildId + ", wareHouseBuildNumber=" + wareHouseBuildNumber
				+ ", wareHouseBuildName=" + wareHouseBuildName + ", wareHouseBuildShelfNumber="
				+ wareHouseBuildShelfNumber + ", wareHouseBuildGroupNumber=" + wareHouseBuildGroupNumber
				+ ", wareHouseBuildLatticeNumber=" + wareHouseBuildLatticeNumber + ", storageId=" + storageId
				+ ", storageRackNumber=" + storageRackNumber + ", storageIsplan=" + storageIsplan + ", planId=" + planId
				+ ", quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName
				+ ", retentionperiodId=" + retentionperiodId + ", retentionperiodCode=" + retentionperiodCode
				+ ", retentionperiodName=" + retentionperiodName + ", pcId=" + pcId + ", pcCode=" + pcCode + ", pcName="
				+ pcName + ", scId=" + scId + ", scCode=" + scCode + ", scName=" + scName + ", str=" + str + ", uuid="
				+ uuid + "]";
	}

}
