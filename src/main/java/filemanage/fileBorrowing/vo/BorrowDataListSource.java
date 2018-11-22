package filemanage.fileBorrowing.vo;

import java.util.List;
/**
 * 明细/记录参数工具类
 * @author 陈一达
 *
 */
public class BorrowDataListSource {

	private String borrowRecordsId;										//借阅记录主键
	private String borrowRecordsName;									//借阅人姓名
	private String borrowRecordsDepartment;								//借阅人所属部门
	private String borrowRecordsBorrowDate;								//借阅日期
	private String borrowRecordsReturnDate;								//归还日期
	private String borrowRecordsCarrier;								//档案载体(1:纸质原件，2:复印件，3:电子文件)
	private String borrowRecordsReason;									//借阅事由
	private String borrowRecordsNumber;									//借阅件数量
	private List<BorrowDataSource> borrowdatasource;					//借阅明细工具类
	public BorrowDataListSource() {
		super();
	}
	public BorrowDataListSource(String borrowRecordsId, String borrowRecordsName, String borrowRecordsDepartment,
			String borrowRecordsBorrowDate, String borrowRecordsReturnDate, String borrowRecordsCarrier,
			String borrowRecordsReason, String borrowRecordsNumber, List<BorrowDataSource> borrowdatasource) {
		super();
		this.borrowRecordsId = borrowRecordsId;
		this.borrowRecordsName = borrowRecordsName;
		this.borrowRecordsDepartment = borrowRecordsDepartment;
		this.borrowRecordsBorrowDate = borrowRecordsBorrowDate;
		this.borrowRecordsReturnDate = borrowRecordsReturnDate;
		this.borrowRecordsCarrier = borrowRecordsCarrier;
		this.borrowRecordsReason = borrowRecordsReason;
		this.borrowRecordsNumber = borrowRecordsNumber;
		this.borrowdatasource = borrowdatasource;
	}
	@Override
	public String toString() {
		return "BorrowDataListSource [borrowRecordsId=" + borrowRecordsId + ", borrowRecordsName=" + borrowRecordsName
				+ ", borrowRecordsDepartment=" + borrowRecordsDepartment + ", borrowRecordsBorrowDate="
				+ borrowRecordsBorrowDate + ", borrowRecordsReturnDate=" + borrowRecordsReturnDate
				+ ", borrowRecordsCarrier=" + borrowRecordsCarrier + ", borrowRecordsReason=" + borrowRecordsReason
				+ ", borrowRecordsNumber=" + borrowRecordsNumber + ", borrowdatasource=" + borrowdatasource + "]";
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
	public String getBorrowRecordsNumber() {
		return borrowRecordsNumber;
	}
	public void setBorrowRecordsNumber(String borrowRecordsNumber) {
		this.borrowRecordsNumber = borrowRecordsNumber;
	}
	public List<BorrowDataSource> getBorrowdatasource() {
		return borrowdatasource;
	}
	public void setBorrowdatasource(List<BorrowDataSource> borrowdatasource) {
		this.borrowdatasource = borrowdatasource;
	}
	
	
	
}
