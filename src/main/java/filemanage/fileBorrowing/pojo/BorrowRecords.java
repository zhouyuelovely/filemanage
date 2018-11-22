package filemanage.fileBorrowing.pojo;

import java.util.Date;

/**
 * @author tchuanwu
 *  借阅记录映射类
 */
public class BorrowRecords {
	private String borrowRecordsId;						//借阅记录主键
	private String borrowRecordsName;					//借阅人姓名
	private String borrowRecordsDepartment;				//借阅人所属部门
	private String borrowRecordsBorrowDate;				//借阅日期
	private String borrowRecordsReturnDate;				//归还日期
	private String borrowRecordsCarrier;				//档案载体(1:纸质原件，2:复印件，3:电子文件)
	private String borrowRecordsReason;					//借阅事由
	private String borrowRecordsEvaluation;				//效果评价
	private String borrowRecordsInstructions;			//效果说明
	private String borrowRecordsStatus;					//审核状态(1.待审核，2.以驳回，3.已通过，4.以归还)
	private String borrowRecordsNumber;					//借阅件数量
	private String borrowrecordsReasonrejection; 		//拒绝理由
	public BorrowRecords() {
		super();
	}
	public BorrowRecords(String borrowRecordsId, String borrowRecordsName, String borrowRecordsDepartment,
			String borrowRecordsBorrowDate, String borrowRecordsReturnDate, String borrowRecordsCarrier,
			String borrowRecordsReason, String borrowRecordsEvaluation, String borrowRecordsInstructions,
			String borrowRecordsStatus, String borrowRecordsNumber, String borrowrecordsReasonrejection) {
		super();
		this.borrowRecordsId = borrowRecordsId;
		this.borrowRecordsName = borrowRecordsName;
		this.borrowRecordsDepartment = borrowRecordsDepartment;
		this.borrowRecordsBorrowDate = borrowRecordsBorrowDate;
		this.borrowRecordsReturnDate = borrowRecordsReturnDate;
		this.borrowRecordsCarrier = borrowRecordsCarrier;
		this.borrowRecordsReason = borrowRecordsReason;
		this.borrowRecordsEvaluation = borrowRecordsEvaluation;
		this.borrowRecordsInstructions = borrowRecordsInstructions;
		this.borrowRecordsStatus = borrowRecordsStatus;
		this.borrowRecordsNumber = borrowRecordsNumber;
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
	}
	@Override
	public String toString() {
		return "BorrowRecords [borrowRecordsId=" + borrowRecordsId + ", borrowRecordsName=" + borrowRecordsName
				+ ", borrowRecordsDepartment=" + borrowRecordsDepartment + ", borrowRecordsBorrowDate="
				+ borrowRecordsBorrowDate + ", borrowRecordsReturnDate=" + borrowRecordsReturnDate
				+ ", borrowRecordsCarrier=" + borrowRecordsCarrier + ", borrowRecordsReason=" + borrowRecordsReason
				+ ", borrowRecordsEvaluation=" + borrowRecordsEvaluation + ", borrowRecordsInstructions="
				+ borrowRecordsInstructions + ", borrowRecordsStatus=" + borrowRecordsStatus + ", borrowRecordsNumber="
				+ borrowRecordsNumber + ", borrowrecordsReasonrejection=" + borrowrecordsReasonrejection + "]";
	}
	public String getBorrowRecordsId() {
		return borrowRecordsId;
	}
	public void setBorrowRecordsId(String borrowRecordsId) {
		this.borrowRecordsId = borrowRecordsId;
	}
	public String getBorrowRecordsName() {
		return borrowRecordsName;
	}
	public void setBorrowRecordsName(String borrowRecordsName) {
		this.borrowRecordsName = borrowRecordsName;
	}
	public String getBorrowRecordsDepartment() {
		return borrowRecordsDepartment;
	}
	public void setBorrowRecordsDepartment(String borrowRecordsDepartment) {
		this.borrowRecordsDepartment = borrowRecordsDepartment;
	}
	public String getBorrowRecordsBorrowDate() {
		return borrowRecordsBorrowDate;
	}
	public void setBorrowRecordsBorrowDate(String borrowRecordsBorrowDate) {
		this.borrowRecordsBorrowDate = borrowRecordsBorrowDate;
	}
	public String getBorrowRecordsReturnDate() {
		return borrowRecordsReturnDate;
	}
	public void setBorrowRecordsReturnDate(String borrowRecordsReturnDate) {
		this.borrowRecordsReturnDate = borrowRecordsReturnDate;
	}
	public String getBorrowRecordsCarrier() {
		return borrowRecordsCarrier;
	}
	public void setBorrowRecordsCarrier(String borrowRecordsCarrier) {
		this.borrowRecordsCarrier = borrowRecordsCarrier;
	}
	public String getBorrowRecordsReason() {
		return borrowRecordsReason;
	}
	public void setBorrowRecordsReason(String borrowRecordsReason) {
		this.borrowRecordsReason = borrowRecordsReason;
	}
	public String getBorrowRecordsEvaluation() {
		return borrowRecordsEvaluation;
	}
	public void setBorrowRecordsEvaluation(String borrowRecordsEvaluation) {
		this.borrowRecordsEvaluation = borrowRecordsEvaluation;
	}
	public String getBorrowRecordsInstructions() {
		return borrowRecordsInstructions;
	}
	public void setBorrowRecordsInstructions(String borrowRecordsInstructions) {
		this.borrowRecordsInstructions = borrowRecordsInstructions;
	}
	public String getBorrowRecordsStatus() {
		return borrowRecordsStatus;
	}
	public void setBorrowRecordsStatus(String borrowRecordsStatus) {
		this.borrowRecordsStatus = borrowRecordsStatus;
	}
	public String getBorrowRecordsNumber() {
		return borrowRecordsNumber;
	}
	public void setBorrowRecordsNumber(String borrowRecordsNumber) {
		this.borrowRecordsNumber = borrowRecordsNumber;
	}
	public String getBorrowrecordsReasonrejection() {
		return borrowrecordsReasonrejection;
	}
	public void setBorrowrecordsReasonrejection(String borrowrecordsReasonrejection) {
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
	}
	
}
