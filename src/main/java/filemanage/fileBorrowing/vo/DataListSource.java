package filemanage.fileBorrowing.vo;

public class DataListSource {

	private String borrowrecordsReasonrejection;
	private String borrowRecordsStatus;
	private String borrowRecordsId;
	
	
	@Override
	public String toString() {
		return "DataListSource [borrowrecordsReasonrejection=" + borrowrecordsReasonrejection + ", borrowRecordsStatus="
				+ borrowRecordsStatus + ", borrowRecordsId=" + borrowRecordsId + "]";
	}
	public DataListSource() {
		super();
	}
	public DataListSource(String borrowrecordsReasonrejection, String borrowRecordsStatus, String borrowRecordsId) {
		super();
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
		this.borrowRecordsStatus = borrowRecordsStatus;
		this.borrowRecordsId = borrowRecordsId;
	}
	public String getBorrowrecordsReasonrejection() {
		return borrowrecordsReasonrejection;
	}
	public void setBorrowrecordsReasonrejection(String borrowrecordsReasonrejection) {
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
	}
	public String getBorrowRecordsStatus() {
		return borrowRecordsStatus;
	}
	public void setBorrowRecordsStatus(String borrowRecordsStatus) {
		this.borrowRecordsStatus = borrowRecordsStatus;
	}
	public String getBorrowRecordsId() {
		return borrowRecordsId;
	}
	public void setBorrowRecordsId(String borrowRecordsId) {
		this.borrowRecordsId = borrowRecordsId;
	}
	
}
