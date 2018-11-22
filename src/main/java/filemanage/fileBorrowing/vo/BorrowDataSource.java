package filemanage.fileBorrowing.vo;
/**
 * 借阅明细参数工具类
 * @author 陈一达
 *
 */
public class BorrowDataSource {

	private String borrowdetailsId;						//借阅明细主键
	private String quanzongNumber;						//全宗号
	private String quanzongName;						//全宗名称
	private String borrowdetailsAnnual;					//档案年度
	private String borrowdetailsTitle;					//题名
	private String borrowrecordsId;						//借阅记录表的主键
	private String userId;								//借阅人主键/用户主键
	private String archivefileId;						//文件ID
	private String borrowrecordsReasonrejection; 		//拒绝理由
	public BorrowDataSource() {
		super();
	}
	public BorrowDataSource(String borrowdetailsId, String quanzongNumber, String quanzongName,
			String borrowdetailsAnnual, String borrowdetailsTitle, String borrowrecordsId, String userId,
			String archivefileId, String borrowrecordsReasonrejection) {
		super();
		this.borrowdetailsId = borrowdetailsId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.borrowdetailsAnnual = borrowdetailsAnnual;
		this.borrowdetailsTitle = borrowdetailsTitle;
		this.borrowrecordsId = borrowrecordsId;
		this.userId = userId;
		this.archivefileId = archivefileId;
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
	}
	@Override
	public String toString() {
		return "BorrowDataSource [borrowdetailsId=" + borrowdetailsId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", borrowdetailsAnnual=" + borrowdetailsAnnual
				+ ", borrowdetailsTitle=" + borrowdetailsTitle + ", borrowrecordsId=" + borrowrecordsId + ", userId="
				+ userId + ", archivefileId=" + archivefileId + ", borrowrecordsReasonrejection="
				+ borrowrecordsReasonrejection + "]";
	}
	public String getBorrowdetailsId() {
		return borrowdetailsId;
	}
	public void setBorrowdetailsId(String borrowdetailsId) {
		this.borrowdetailsId = borrowdetailsId;
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
	public String getBorrowdetailsAnnual() {
		return borrowdetailsAnnual;
	}
	public void setBorrowdetailsAnnual(String borrowdetailsAnnual) {
		this.borrowdetailsAnnual = borrowdetailsAnnual;
	}
	public String getBorrowdetailsTitle() {
		return borrowdetailsTitle;
	}
	public void setBorrowdetailsTitle(String borrowdetailsTitle) {
		this.borrowdetailsTitle = borrowdetailsTitle;
	}
	public String getBorrowrecordsId() {
		return borrowrecordsId;
	}
	public void setBorrowrecordsId(String borrowrecordsId) {
		this.borrowrecordsId = borrowrecordsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArchivefileId() {
		return archivefileId;
	}
	public void setArchivefileId(String archivefileId) {
		this.archivefileId = archivefileId;
	}
	public String getBorrowrecordsReasonrejection() {
		return borrowrecordsReasonrejection;
	}
	public void setBorrowrecordsReasonrejection(String borrowrecordsReasonrejection) {
		this.borrowrecordsReasonrejection = borrowrecordsReasonrejection;
	}
	
	
	
}
