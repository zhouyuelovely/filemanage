package filemanage.collectandorganize.pojo;

import java.util.Date;

public class TemporaryFile {
	private String temporaryAccessaryId;//主键（序列）
	private String temporaryAccessaryUserIdNumber;//扫描人身份证号
	private String quanzongId;//全宗主键
	private Date temporaryAccessaryCreateTime;//创建时间
	private String temporaryAccessaryPageNumber;//页码
	private String temporaryAccessarySign;//文件标记1：封面
	private String temporaryAccessaryName;//图片名称
	private String temporaryAccessaryPath;//图片路径
	
	public TemporaryFile() {
		super();
	}

	public TemporaryFile(String temporaryAccessaryId, String temporaryAccessaryUserIdNumber, String quanzongId,
			Date temporaryAccessaryCreateTime, String temporaryAccessaryPageNumber, String temporaryAccessarySign,
			String temporaryAccessaryName, String temporaryAccessaryPath) {
		super();
		this.temporaryAccessaryId = temporaryAccessaryId;
		this.temporaryAccessaryUserIdNumber = temporaryAccessaryUserIdNumber;
		this.quanzongId = quanzongId;
		this.temporaryAccessaryCreateTime = temporaryAccessaryCreateTime;
		this.temporaryAccessaryPageNumber = temporaryAccessaryPageNumber;
		this.temporaryAccessarySign = temporaryAccessarySign;
		this.temporaryAccessaryName = temporaryAccessaryName;
		this.temporaryAccessaryPath = temporaryAccessaryPath;
	}

	public String getTemporaryAccessaryId() {
		return temporaryAccessaryId;
	}

	public void setTemporaryAccessaryId(String temporaryAccessaryId) {
		this.temporaryAccessaryId = temporaryAccessaryId;
	}

	public String getTemporaryAccessaryUserIdNumber() {
		return temporaryAccessaryUserIdNumber;
	}

	public void setTemporaryAccessaryUserIdNumber(String temporaryAccessaryUserIdNumber) {
		this.temporaryAccessaryUserIdNumber = temporaryAccessaryUserIdNumber;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public Date getTemporaryAccessaryCreateTime() {
		return temporaryAccessaryCreateTime;
	}

	public void setTemporaryAccessaryCreateTime(Date temporaryAccessaryCreateTime) {
		this.temporaryAccessaryCreateTime = temporaryAccessaryCreateTime;
	}

	public String getTemporaryAccessaryPageNumber() {
		return temporaryAccessaryPageNumber;
	}

	public void setTemporaryAccessaryPageNumber(String temporaryAccessaryPageNumber) {
		this.temporaryAccessaryPageNumber = temporaryAccessaryPageNumber;
	}

	public String getTemporaryAccessarySign() {
		return temporaryAccessarySign;
	}

	public void setTemporaryAccessarySign(String temporaryAccessarySign) {
		this.temporaryAccessarySign = temporaryAccessarySign;
	}

	public String getTemporaryAccessaryName() {
		return temporaryAccessaryName;
	}

	public void setTemporaryAccessaryName(String temporaryAccessaryName) {
		this.temporaryAccessaryName = temporaryAccessaryName;
	}

	public String getTemporaryAccessaryPath() {
		return temporaryAccessaryPath;
	}

	public void setTemporaryAccessaryPath(String temporaryAccessaryPath) {
		this.temporaryAccessaryPath = temporaryAccessaryPath;
	}

	@Override
	public String toString() {
		return "TemporaryFile [temporaryAccessaryId=" + temporaryAccessaryId + ", temporaryAccessaryUserIdNumber="
				+ temporaryAccessaryUserIdNumber + ", quanzongId=" + quanzongId + ", temporaryAccessaryCreateTime="
				+ temporaryAccessaryCreateTime + ", temporaryAccessaryPageNumber=" + temporaryAccessaryPageNumber
				+ ", temporaryAccessarySign=" + temporaryAccessarySign + ", temporaryAccessaryName="
				+ temporaryAccessaryName + ", temporaryAccessaryPath=" + temporaryAccessaryPath + "]";
	}
	
	
}
