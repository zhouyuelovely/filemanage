package filemanage.inventoryandinquire.vo;

public class HistoryDataExtendVo {
	private String historydataId;//(泰坦数据)-主键
	private String historydataNumber;//(泰坦数据)-档号
	private String historydataReferencenumber;//(泰坦数据)-文件编号（文号）
	private String historydataAFResponsible;//(泰坦数据)-责任者
	private String historydataTitle;//(泰坦数据)-文件题名
	private String historydataFiledate;//(泰坦数据)-成文日期
	private String historydataSecurityLevel;//(泰坦数据)-密级
	private String historydataPages;//(泰坦数据)-页数
	private String historydataNotes;//(泰坦数据)-附注
	private String historydataBoxNumber;//(泰坦数据)-盒号
	
	public HistoryDataExtendVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryDataExtendVo(String historydataId, String historydataNumber, String historydataReferencenumber,
			String historydataAFResponsible, String historydataTitle, String historydataFiledate,
			String historydataSecurityLevel, String historydataPages, String historydataNotes,
			String historydataBoxNumber) {
		super();
		this.historydataId = historydataId;
		this.historydataNumber = historydataNumber;
		this.historydataReferencenumber = historydataReferencenumber;
		this.historydataAFResponsible = historydataAFResponsible;
		this.historydataTitle = historydataTitle;
		this.historydataFiledate = historydataFiledate;
		this.historydataSecurityLevel = historydataSecurityLevel;
		this.historydataPages = historydataPages;
		this.historydataNotes = historydataNotes;
		this.historydataBoxNumber = historydataBoxNumber;
	}

	public String getHistorydataNumber() {
		return historydataNumber;
	}

	public void setHistorydataNumber(String historydataNumber) {
		this.historydataNumber = historydataNumber;
	}

	public String getHistorydataReferencenumber() {
		return historydataReferencenumber;
	}

	public void setHistorydataReferencenumber(String historydataReferencenumber) {
		this.historydataReferencenumber = historydataReferencenumber;
	}

	public String getHistorydataAFResponsible() {
		return historydataAFResponsible;
	}

	public void setHistorydataAFResponsible(String historydataAFResponsible) {
		this.historydataAFResponsible = historydataAFResponsible;
	}

	public String getHistorydataTitle() {
		return historydataTitle;
	}

	public void setHistorydataTitle(String historydataTitle) {
		this.historydataTitle = historydataTitle;
	}

	public String getHistorydataFiledate() {
		return historydataFiledate;
	}

	public void setHistorydataFiledate(String historydataFiledate) {
		this.historydataFiledate = historydataFiledate;
	}

	public String getHistorydataSecurityLevel() {
		return historydataSecurityLevel;
	}

	public void setHistorydataSecurityLevel(String historydataSecurityLevel) {
		this.historydataSecurityLevel = historydataSecurityLevel;
	}

	public String getHistorydataPages() {
		return historydataPages;
	}

	public void setHistorydataPages(String historydataPages) {
		this.historydataPages = historydataPages;
	}

	public String getHistorydataNotes() {
		return historydataNotes;
	}

	public void setHistorydataNotes(String historydataNotes) {
		this.historydataNotes = historydataNotes;
	}

	public String getHistorydataBoxNumber() {
		return historydataBoxNumber;
	}

	public void setHistorydataBoxNumber(String historydataBoxNumber) {
		this.historydataBoxNumber = historydataBoxNumber;
	}
	
	public String getHistorydataId() {
		return historydataId;
	}

	public void setHistorydataId(String historydataId) {
		this.historydataId = historydataId;
	}

	@Override
	public String toString() {
		return "HistoryDataExtendVo [historydataId=" + historydataId + ", historydataNumber=" + historydataNumber
				+ ", historydataReferencenumber=" + historydataReferencenumber + ", historydataAFResponsible="
				+ historydataAFResponsible + ", historydataTitle=" + historydataTitle + ", historydataFiledate="
				+ historydataFiledate + ", historydataSecurityLevel=" + historydataSecurityLevel + ", historydataPages="
				+ historydataPages + ", historydataNotes=" + historydataNotes + ", historydataBoxNumber="
				+ historydataBoxNumber + "]";
	}
}
