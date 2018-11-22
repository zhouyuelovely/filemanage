package filemanage.warningandediting.pojo;

import java.util.Date;

/**
 * 未归还档案
 * 
 * @author Administrator
 *
 */
public class BorrowingFile {

	private String archivefileId;// 文件ID
	private String qzName;// 全宗名称
	private String fileNumber;// 档号
	private String boxNumber;// 盒号
	private String rackNumber;// 架位号
	private String startDate;// 租借日期
	private String endDate;// 到期日期
	private String surplusDays;// 预警天数

	public String getArchivefileId() {
		return archivefileId;
	}

	public void setArchivefileId(String archivefileId) {
		this.archivefileId = archivefileId;
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

	public String getSurplusDays() {
		return surplusDays;
	}

	public void setSurplusDays(String surplusDays) {
		this.surplusDays = surplusDays;
	}

	public BorrowingFile(String archivefileId, String qzName, String fileNumber, String boxNumber, String rackNumber,
			String startDate, String endDate, String surplusDays) {
		super();
		this.archivefileId = archivefileId;
		this.qzName = qzName;
		this.fileNumber = fileNumber;
		this.boxNumber = boxNumber;
		this.rackNumber = rackNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.surplusDays = surplusDays;
	}

	public BorrowingFile() {
		super();
	}

	public BorrowingFile(String surplusDays) {
		super();
		this.surplusDays = surplusDays;
	}

	@Override
	public String toString() {
		return "BorrowingFile [qzName=" + qzName + ", fileNumber=" + fileNumber + ", boxNumber=" + boxNumber
				+ ", rackNumber=" + rackNumber + ", startDate=" + startDate + ", endDate=" + endDate + ", surplusDays="
				+ surplusDays + "]";
	}

}
