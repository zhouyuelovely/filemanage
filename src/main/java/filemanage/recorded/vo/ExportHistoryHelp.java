package filemanage.recorded.vo;

public class ExportHistoryHelp {
	private String fileId;// 文件的主键
	private String expectTitle;// 文件题名
	private String expectNumbering;// 文件编号
	private String expectRPerson;// 责任者
	private String expectWrittenDate;// 成文日期
	private String expectSecretLevel;// 密级
	private String expectPages;// 页数
	private String expectTypeName;// 档案类型名称
	private String expectArchiveNumber;// 全宗号
	private String expectSTimeName;// 保管期限名称
	private String expectAnual;// 归档年度
	private String expectSCName;// 二级分类名称
	private String expectPartNumber;// 件号
	private String expectSTimeCode;// 保管期限代码
	private String expectSCCode;// 二级分类代码
	private String expectTextItem;// 文本项
	private String expectPageNumber;// 底层包编号

	public ExportHistoryHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExportHistoryHelp(String fileId, String expectTitle, String expectNumbering, String expectRPerson,
			String expectWrittenDate, String expectSecretLevel, String expectPages, String expectTypeName,
			String expectArchiveNumber, String expectSTimeName, String expectAnual, String expectSCName,
			String expectPartNumber, String expectSTimeCode, String expectSCCode, String expectTextItem,
			String expectPageNumber) {
		super();
		this.fileId = fileId;
		this.expectTitle = expectTitle;
		this.expectNumbering = expectNumbering;
		this.expectRPerson = expectRPerson;
		this.expectWrittenDate = expectWrittenDate;
		this.expectSecretLevel = expectSecretLevel;
		this.expectPages = expectPages;
		this.expectTypeName = expectTypeName;
		this.expectArchiveNumber = expectArchiveNumber;
		this.expectSTimeName = expectSTimeName;
		this.expectAnual = expectAnual;
		this.expectSCName = expectSCName;
		this.expectPartNumber = expectPartNumber;
		this.expectSTimeCode = expectSTimeCode;
		this.expectSCCode = expectSCCode;
		this.expectTextItem = expectTextItem;
		this.expectPageNumber = expectPageNumber;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getExpectTitle() {
		return expectTitle;
	}

	public void setExpectTitle(String expectTitle) {
		this.expectTitle = expectTitle;
	}

	public String getExpectNumbering() {
		return expectNumbering;
	}

	public void setExpectNumbering(String expectNumbering) {
		this.expectNumbering = expectNumbering;
	}

	public String getExpectRPerson() {
		return expectRPerson;
	}

	public void setExpectRPerson(String expectRPerson) {
		this.expectRPerson = expectRPerson;
	}

	public String getExpectWrittenDate() {
		return expectWrittenDate;
	}

	public void setExpectWrittenDate(String expectWrittenDate) {
		this.expectWrittenDate = expectWrittenDate;
	}

	public String getExpectSecretLevel() {
		return expectSecretLevel;
	}

	public void setExpectSecretLevel(String expectSecretLevel) {
		this.expectSecretLevel = expectSecretLevel;
	}

	public String getExpectPages() {
		return expectPages;
	}

	public void setExpectPages(String expectPages) {
		this.expectPages = expectPages;
	}

	public String getExpectTypeName() {
		return expectTypeName;
	}

	public void setExpectTypeName(String expectTypeName) {
		this.expectTypeName = expectTypeName;
	}

	public String getExpectArchiveNumber() {
		return expectArchiveNumber;
	}

	public void setExpectArchiveNumber(String expectArchiveNumber) {
		this.expectArchiveNumber = expectArchiveNumber;
	}

	public String getExpectSTimeName() {
		return expectSTimeName;
	}

	public void setExpectSTimeName(String expectSTimeName) {
		this.expectSTimeName = expectSTimeName;
	}

	public String getExpectAnual() {
		return expectAnual;
	}

	public void setExpectAnual(String expectAnual) {
		this.expectAnual = expectAnual;
	}

	public String getExpectSCName() {
		return expectSCName;
	}

	public void setExpectSCName(String expectSCName) {
		this.expectSCName = expectSCName;
	}

	public String getExpectPartNumber() {
		return expectPartNumber;
	}

	public void setExpectPartNumber(String expectPartNumber) {
		this.expectPartNumber = expectPartNumber;
	}

	public String getExpectSTimeCode() {
		return expectSTimeCode;
	}

	public void setExpectSTimeCode(String expectSTimeCode) {
		this.expectSTimeCode = expectSTimeCode;
	}

	public String getExpectSCCode() {
		return expectSCCode;
	}

	public void setExpectSCCode(String expectSCCode) {
		this.expectSCCode = expectSCCode;
	}

	public String getExpectTextItem() {
		return expectTextItem;
	}

	public void setExpectTextItem(String expectTextItem) {
		this.expectTextItem = expectTextItem;
	}

	public String getExpectPageNumber() {
		return expectPageNumber;
	}

	public void setExpectPageNumber(String expectPageNumber) {
		this.expectPageNumber = expectPageNumber;
	}

	@Override
	public String toString() {
		return "ExportHistoryHelp [fileId=" + fileId + ", expectTitle=" + expectTitle + ", expectNumbering="
				+ expectNumbering + ", expectRPerson=" + expectRPerson + ", expectWrittenDate=" + expectWrittenDate
				+ ", expectSecretLevel=" + expectSecretLevel + ", expectPages=" + expectPages + ", expectTypeName="
				+ expectTypeName + ", expectArchiveNumber=" + expectArchiveNumber + ", expectSTimeName="
				+ expectSTimeName + ", expectAnual=" + expectAnual + ", expectSCName=" + expectSCName
				+ ", expectPartNumber=" + expectPartNumber + ", expectSTimeCode=" + expectSTimeCode + ", expectSCCode="
				+ expectSCCode + ", expectTextItem=" + expectTextItem + ", expectPageNumber=" + expectPageNumber + "]";
	}

}
