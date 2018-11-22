package filemanage.danganmanage.vo;

public class QueryHistoryByCondition {
	
	private String historydataId;								//(泰坦数据)-文件主键
	private String historydataTitle;							//(泰坦数据)-文件题名
	private String historydataNumber;							//(泰坦数据)-档号
	private String historydataTypecode;							//(泰坦数据)-门类代码
	private String historydataPages;							//(泰坦数据)-页数
	private String historydataFiledate;							//(泰坦数据)-成文日期
	private String historydataType;								//(泰坦数据)-档案类型
	private String historydataSecurityLevel;					//(泰坦数据)-密级
	private String quanzongId;									//(泰坦数据)-全宗主键
	private String historydataArchivalYear;						//(泰坦数据)-归档年度
	private String historydataPartNumber;						//(泰坦数据)-件号
	private String retentionperiodId;							//(泰坦数据)-保管期限主键
	private String organizationId;								//(泰坦数据)-机构（问题）
	private String historydataAFResponsible;					//(泰坦数据)-责任者
	private String historydataReferencenumber;					//(泰坦数据)-文件编号（文号）
	private String historydataName;								//(泰坦数据)-人名
	private String historydataClificationNum;					//(泰坦数据)-分类号
	private String historydataBoxNumber;						//(泰坦数据)-盒号
	private String keywords;									//(泰坦数据)-主题词
	private String historydataTextitem;							//(泰坦数据)-文本项
	private String historydataCarrierType;						//(泰坦数据)-载体类型
	private String historydataCarriermorphology;				//(泰坦数据)-载体形态
	private String historydataAdmissiondate;					//(泰坦数据)-录入日期
	private String historydataNotes;							//(泰坦数据)-附注
	private String conditions;                                  //关键词
	private String retentionperiodname;                         //保管期限名称
	private String quanzongName; //全宗名称
	private String pcName;//档案类型
	
	
	public QueryHistoryByCondition() {
		
	}


	public QueryHistoryByCondition(String historydataId, String historydataTitle, String historydataNumber,
			String historydataTypecode, String historydataPages, String historydataFiledate, String historydataType,
			String historydataSecurityLevel, String quanzongId, String historydataArchivalYear,
			String historydataPartNumber, String retentionperiodId, String organizationId,
			String historydataAFResponsible, String historydataReferencenumber, String historydataName,
			String historydataClificationNum, String historydataBoxNumber, String keywords, String historydataTextitem,
			String historydataCarrierType, String historydataCarriermorphology, String historydataAdmissiondate,
			String historydataNotes, String conditions, String retentionperiodname, String quanzongName,
			String pcName) {
		super();
		this.historydataId = historydataId;
		this.historydataTitle = historydataTitle;
		this.historydataNumber = historydataNumber;
		this.historydataTypecode = historydataTypecode;
		this.historydataPages = historydataPages;
		this.historydataFiledate = historydataFiledate;
		this.historydataType = historydataType;
		this.historydataSecurityLevel = historydataSecurityLevel;
		this.quanzongId = quanzongId;
		this.historydataArchivalYear = historydataArchivalYear;
		this.historydataPartNumber = historydataPartNumber;
		this.retentionperiodId = retentionperiodId;
		this.organizationId = organizationId;
		this.historydataAFResponsible = historydataAFResponsible;
		this.historydataReferencenumber = historydataReferencenumber;
		this.historydataName = historydataName;
		this.historydataClificationNum = historydataClificationNum;
		this.historydataBoxNumber = historydataBoxNumber;
		this.keywords = keywords;
		this.historydataTextitem = historydataTextitem;
		this.historydataCarrierType = historydataCarrierType;
		this.historydataCarriermorphology = historydataCarriermorphology;
		this.historydataAdmissiondate = historydataAdmissiondate;
		this.historydataNotes = historydataNotes;
		this.conditions = conditions;
		this.retentionperiodname = retentionperiodname;
		this.quanzongName = quanzongName;
		this.pcName = pcName;
	}


	public String getHistorydataId() {
		return historydataId;
	}


	public void setHistorydataId(String historydataId) {
		this.historydataId = historydataId;
	}


	public String getHistorydataTitle() {
		return historydataTitle;
	}


	public void setHistorydataTitle(String historydataTitle) {
		this.historydataTitle = historydataTitle;
	}


	public String getHistorydataNumber() {
		return historydataNumber;
	}


	public void setHistorydataNumber(String historydataNumber) {
		this.historydataNumber = historydataNumber;
	}


	public String getHistorydataTypecode() {
		return historydataTypecode;
	}


	public void setHistorydataTypecode(String historydataTypecode) {
		this.historydataTypecode = historydataTypecode;
	}


	public String getHistorydataPages() {
		return historydataPages;
	}


	public void setHistorydataPages(String historydataPages) {
		this.historydataPages = historydataPages;
	}


	public String getHistorydataFiledate() {
		return historydataFiledate;
	}


	public void setHistorydataFiledate(String historydataFiledate) {
		this.historydataFiledate = historydataFiledate;
	}


	public String getHistorydataType() {
		return historydataType;
	}


	public void setHistorydataType(String historydataType) {
		this.historydataType = historydataType;
	}


	public String getHistorydataSecurityLevel() {
		return historydataSecurityLevel;
	}


	public void setHistorydataSecurityLevel(String historydataSecurityLevel) {
		this.historydataSecurityLevel = historydataSecurityLevel;
	}


	public String getQuanzongId() {
		return quanzongId;
	}


	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}


	public String getHistorydataArchivalYear() {
		return historydataArchivalYear;
	}


	public void setHistorydataArchivalYear(String historydataArchivalYear) {
		this.historydataArchivalYear = historydataArchivalYear;
	}


	public String getHistorydataPartNumber() {
		return historydataPartNumber;
	}


	public void setHistorydataPartNumber(String historydataPartNumber) {
		this.historydataPartNumber = historydataPartNumber;
	}


	public String getRetentionperiodId() {
		return retentionperiodId;
	}


	public void setRetentionperiodId(String retentionperiodId) {
		this.retentionperiodId = retentionperiodId;
	}


	public String getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}


	public String getHistorydataAFResponsible() {
		return historydataAFResponsible;
	}


	public void setHistorydataAFResponsible(String historydataAFResponsible) {
		this.historydataAFResponsible = historydataAFResponsible;
	}


	public String getHistorydataReferencenumber() {
		return historydataReferencenumber;
	}


	public void setHistorydataReferencenumber(String historydataReferencenumber) {
		this.historydataReferencenumber = historydataReferencenumber;
	}


	public String getHistorydataName() {
		return historydataName;
	}


	public void setHistorydataName(String historydataName) {
		this.historydataName = historydataName;
	}


	public String getHistorydataClificationNum() {
		return historydataClificationNum;
	}


	public void setHistorydataClificationNum(String historydataClificationNum) {
		this.historydataClificationNum = historydataClificationNum;
	}


	public String getHistorydataBoxNumber() {
		return historydataBoxNumber;
	}


	public void setHistorydataBoxNumber(String historydataBoxNumber) {
		this.historydataBoxNumber = historydataBoxNumber;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public String getHistorydataTextitem() {
		return historydataTextitem;
	}


	public void setHistorydataTextitem(String historydataTextitem) {
		this.historydataTextitem = historydataTextitem;
	}


	public String getHistorydataCarrierType() {
		return historydataCarrierType;
	}


	public void setHistorydataCarrierType(String historydataCarrierType) {
		this.historydataCarrierType = historydataCarrierType;
	}


	public String getHistorydataCarriermorphology() {
		return historydataCarriermorphology;
	}


	public void setHistorydataCarriermorphology(String historydataCarriermorphology) {
		this.historydataCarriermorphology = historydataCarriermorphology;
	}


	public String getHistorydataAdmissiondate() {
		return historydataAdmissiondate;
	}


	public void setHistorydataAdmissiondate(String historydataAdmissiondate) {
		this.historydataAdmissiondate = historydataAdmissiondate;
	}


	public String getHistorydataNotes() {
		return historydataNotes;
	}


	public void setHistorydataNotes(String historydataNotes) {
		this.historydataNotes = historydataNotes;
	}


	public String getConditions() {
		return conditions;
	}


	public void setConditions(String conditions) {
		this.conditions = conditions;
	}


	public String getRetentionperiodname() {
		return retentionperiodname;
	}


	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}


	public String getQuanzongName() {
		return quanzongName;
	}


	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}


	public String getPcName() {
		return pcName;
	}


	public void setPcName(String pcName) {
		this.pcName = pcName;
	}


	@Override
	public String toString() {
		return "QueryHistoryByCondition [historydataId=" + historydataId + ", historydataTitle=" + historydataTitle
				+ ", historydataNumber=" + historydataNumber + ", historydataTypecode=" + historydataTypecode
				+ ", historydataPages=" + historydataPages + ", historydataFiledate=" + historydataFiledate
				+ ", historydataType=" + historydataType + ", historydataSecurityLevel=" + historydataSecurityLevel
				+ ", quanzongId=" + quanzongId + ", historydataArchivalYear=" + historydataArchivalYear
				+ ", historydataPartNumber=" + historydataPartNumber + ", retentionperiodId=" + retentionperiodId
				+ ", organizationId=" + organizationId + ", historydataAFResponsible=" + historydataAFResponsible
				+ ", historydataReferencenumber=" + historydataReferencenumber + ", historydataName=" + historydataName
				+ ", historydataClificationNum=" + historydataClificationNum + ", historydataBoxNumber="
				+ historydataBoxNumber + ", keywords=" + keywords + ", historydataTextitem=" + historydataTextitem
				+ ", historydataCarrierType=" + historydataCarrierType + ", historydataCarriermorphology="
				+ historydataCarriermorphology + ", historydataAdmissiondate=" + historydataAdmissiondate
				+ ", historydataNotes=" + historydataNotes + ", conditions=" + conditions + ", retentionperiodname="
				+ retentionperiodname + ", quanzongName=" + quanzongName + ", pcName=" + pcName + "]";
	}

	
	
	
	
	

}
