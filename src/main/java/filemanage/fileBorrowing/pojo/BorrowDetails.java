package filemanage.fileBorrowing.pojo;

/**
 * 借阅明细表
 * @author 陈一达
 *
 */
public class BorrowDetails {

	private String borrowdetailsId;					//借阅明细主键	
	private String quanzongNumber;					//全宗号	
	private String quanzongName;					//全宗名称	
	private String borrowdetailsAnnual;				//档案年度
	private String borrowdetailsTitle;				//题名		
	private String borrowrecordsId;					//借阅记录表的主键
	private String userId;							//借阅人主键/用户主键
	private String archivefileId;					//文件ID
	public BorrowDetails() {
		super();
	}
	public BorrowDetails(String borrowdetailsId, String quanzongNumber, String quanzongName, String borrowdetailsAnnual,
			String borrowdetailsTitle, String borrowrecordsId, String userId, String archivefileId) {
		super();
		this.borrowdetailsId = borrowdetailsId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.borrowdetailsAnnual = borrowdetailsAnnual;
		this.borrowdetailsTitle = borrowdetailsTitle;
		this.borrowrecordsId = borrowrecordsId;
		this.userId = userId;
		this.archivefileId = archivefileId;
	}
	@Override
	public String toString() {
		return "BorrowDetails [borrowdetailsId=" + borrowdetailsId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", borrowdetailsAnnual=" + borrowdetailsAnnual
				+ ", borrowdetailsTitle=" + borrowdetailsTitle + ", borrowrecordsId=" + borrowrecordsId + ", userId="
				+ userId + ", archivefileId=" + archivefileId + "]";
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
	
	
	
}
