package filemanage.warningandediting.pojo;

/**
 * 到期档案
 * 
 * @author yaofei
 *
 */
public class ExpiredFile {

	private String qzName;// 全宗名称
	private String archivefileId;// 文件ID
	private String fileNumber;// 档号
	private String boxNumber;// 盒号
	private String rackNumber;// 架位号
	private String fileCreateDate;// 档案日期
	private String endDate;// 到期日期
	private String surplusDays;// 预警天数
	private String saveDays;// 保管期限

	public String getArchivefileId() {
		return archivefileId;
	}

	public void setArchivefileId(String archivefileId) {
		this.archivefileId = archivefileId;
	}

	public String getSaveDays() {
		return saveDays;
	}

	public void setSaveDays(String saveDays) {
		this.saveDays = saveDays;
	}

	public String getQzName() {
		return qzName;
	}

	public void setQzName(String qzName) {
		this.qzName = qzName;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}

	public String getFileCreateDate() {
		return fileCreateDate;
	}

	public void setFileCreateDate(String fileCreateDate) {
		this.fileCreateDate = fileCreateDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSurplusDays() {
		return surplusDays;
	}

	public void setSurplusDays(String surplusDays) {
		this.surplusDays = surplusDays;
	}

	public ExpiredFile(String qzName, String surplusDays) {
		super();
		this.qzName = qzName;
		this.surplusDays = surplusDays;
	}

	public ExpiredFile(String qzName) {
		super();
		this.qzName = qzName;
	}

	public ExpiredFile(String qzName,  String archivefileId,String fileNumber, String boxNumber, String rackNumber, String fileCreateDate,
			String endDate, String surplusDays) {
		super();
		this.qzName = qzName;
		this.archivefileId = archivefileId;
		this.fileNumber = fileNumber;
		this.boxNumber = boxNumber;
		this.rackNumber = rackNumber;
		this.fileCreateDate = fileCreateDate;
		this.endDate = endDate;
		this.surplusDays = surplusDays;
	}


	public ExpiredFile() {
		super();
	}


	public ExpiredFile(String qzName, String archivefileId, String fileNumber, String boxNumber, String rackNumber,
			String fileCreateDate, String endDate, String surplusDays, String saveDays) {
		super();
		this.qzName = qzName;
		this.archivefileId = archivefileId;
		this.fileNumber = fileNumber;
		this.boxNumber = boxNumber;
		this.rackNumber = rackNumber;
		this.fileCreateDate = fileCreateDate;
		this.endDate = endDate;
		this.surplusDays = surplusDays;
		this.saveDays = saveDays;
	}

	@Override
	public String toString() {
		return "ExpiredFile [qzName=" + qzName + ", archivefileId=" + archivefileId + ", fileNumber=" + fileNumber
				+ ", boxNumber=" + boxNumber + ", rackNumber=" + rackNumber + ", fileCreateDate=" + fileCreateDate
				+ ", endDate=" + endDate + ", surplusDays=" + surplusDays + ", saveDays=" + saveDays + "]";
	}


}
