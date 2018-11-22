package filemanage.collectandorganize.vo;

/**
 * 各个模块条件及关键词查询属性（辅助类）
 * @author 陈一达
 *
 */
public class ModuleConditionalQueryVo {
	/**
	 * 系统设置	>>	全宗管理
	 */
	private String quanzongNumber;							//全宗号		（可用于	档案送审）
	private String quanzongName;							//全宗名称	（可用于	用户管理	 /	档案送审	 /	电子阅览室）
	/**
	 * 系统设置	>>	全宗管理		>>		机构管理
	 */
	private String qrganizationCode;						//机构代码	(可用于	用户管理)
	private String qrganizationName;						//机构名称	(可用于	用户管理)
	/**
	 * 用户管理
	 */	
	private String userName;								//姓名		(可用于	安全管理)
	private String userIdnumber;							//身份证号
	private String userTelephone;							//手机号
	private String userWorknumber;							//工号
	private String roleName;								//角色
	/**
	 * 安全管理(消息log表)
	 */
	private String logCreatetimeBegin;						//操作时间(起始时间)
	private String logCreatetimeEnd;						//操作时间(结束时间)
	/**
	 * 档案收集整理系统	>>	档案存储（扫描人员/档案管理人员）
	 */
	private String archivefileAnual;						//档案年度	(可用于	档案送审 	 /	电子阅览室 )
	private String archivefileResponsible;					//责任人		(可用于	档案整理  )
	private String archivefileCreatetime;					//日期		(可用于	档案整理  )
	private String ferencenumber;							//文号		(可用于	档案整理  )
	private String archivefileTitle;						//提名		(可用于	档案整理	 /	电子阅览室  	/	档案信息门户)
	/**
	 * 档案整理	>>	知识库
	 */
	private String knowledgebaseTitle;						//标题
	private String knowledgebaseContent;					//内容
	/**
	 * 档案整理	>>	文件装盒
	 */
	private String archivefileFilenumber;					//档号
	private String archivefileSecurityclassrification;		//密级
	/**
	 * (适用于	：	档案送审		/	验收合格页面	/	驳回重整页面	/	档案审核
	 */
	private String scCode;									//机构/问题代码（二级分类代码）			(可用于	电子阅览室)
	private String scName;									//机构/问题名称（二级分类名称）			(可用于	电子阅览室)
	private String scStatus;								//机构状态(0:机构	/ 1:问题)			(可用于	电子阅览室)
	private String retentionperiodCode;						//保管期限代码						(可用于	电子阅览室)
	private String retentionperiodName;						//保管期限名（期限）					(可用于	电子阅览室)
	private String boxNumber;								//盒号
	private String boxThickness;							//盒厚度（盒属性）
	private String condition;                               // 条件
	/**
	 * 数字档案馆		>>	电子文件中心	(不确定)
	 */
	
	
	/**
	 * 交流中心	（用户页面	/	管理员页面）
	 */
	private String theme;									//主题
	private String time;									//时间
	private String content;									//内容
	
	/**
	 * 电子阅览室
	 */
	private String pcCode;									//一级分类代码(档案类别代码)
	private String pcName;									//一级分类名称（档案类别名称）	
	
	/**
	 * 档案信息门户
	 */	
	private String pcTime;									//发布时间
	private String ipType;									//信息类型
	private String subjectHeadings;							//主题词
	public ModuleConditionalQueryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModuleConditionalQueryVo(String quanzongNumber, String quanzongName, String qrganizationCode,
			String qrganizationName, String userName, String userIdnumber, String userTelephone, String userWorknumber,
			String roleName, String logCreatetimeBegin, String logCreatetimeEnd, String archivefileAnual,
			String archivefileResponsible, String archivefileCreatetime, String ferencenumber, String archivefileTitle,
			String knowledgebaseTitle, String knowledgebaseContent, String archivefileFilenumber,
			String archivefileSecurityclassrification, String scCode, String scName, String scStatus,
			String retentionperiodCode, String retentionperiodName, String boxNumber, String boxThickness,
			String condition, String theme, String time, String content, String pcCode, String pcName, String pcTime,
			String ipType, String subjectHeadings) {
		super();
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.qrganizationCode = qrganizationCode;
		this.qrganizationName = qrganizationName;
		this.userName = userName;
		this.userIdnumber = userIdnumber;
		this.userTelephone = userTelephone;
		this.userWorknumber = userWorknumber;
		this.roleName = roleName;
		this.logCreatetimeBegin = logCreatetimeBegin;
		this.logCreatetimeEnd = logCreatetimeEnd;
		this.archivefileAnual = archivefileAnual;
		this.archivefileResponsible = archivefileResponsible;
		this.archivefileCreatetime = archivefileCreatetime;
		this.ferencenumber = ferencenumber;
		this.archivefileTitle = archivefileTitle;
		this.knowledgebaseTitle = knowledgebaseTitle;
		this.knowledgebaseContent = knowledgebaseContent;
		this.archivefileFilenumber = archivefileFilenumber;
		this.archivefileSecurityclassrification = archivefileSecurityclassrification;
		this.scCode = scCode;
		this.scName = scName;
		this.scStatus = scStatus;
		this.retentionperiodCode = retentionperiodCode;
		this.retentionperiodName = retentionperiodName;
		this.boxNumber = boxNumber;
		this.boxThickness = boxThickness;
		this.condition = condition;
		this.theme = theme;
		this.time = time;
		this.content = content;
		this.pcCode = pcCode;
		this.pcName = pcName;
		this.pcTime = pcTime;
		this.ipType = ipType;
		this.subjectHeadings = subjectHeadings;
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
	public String getQrganizationCode() {
		return qrganizationCode;
	}
	public void setQrganizationCode(String qrganizationCode) {
		this.qrganizationCode = qrganizationCode;
	}
	public String getQrganizationName() {
		return qrganizationName;
	}
	public void setQrganizationName(String qrganizationName) {
		this.qrganizationName = qrganizationName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIdnumber() {
		return userIdnumber;
	}
	public void setUserIdnumber(String userIdnumber) {
		this.userIdnumber = userIdnumber;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserWorknumber() {
		return userWorknumber;
	}
	public void setUserWorknumber(String userWorknumber) {
		this.userWorknumber = userWorknumber;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getLogCreatetimeBegin() {
		return logCreatetimeBegin;
	}
	public void setLogCreatetimeBegin(String logCreatetimeBegin) {
		this.logCreatetimeBegin = logCreatetimeBegin;
	}
	public String getLogCreatetimeEnd() {
		return logCreatetimeEnd;
	}
	public void setLogCreatetimeEnd(String logCreatetimeEnd) {
		this.logCreatetimeEnd = logCreatetimeEnd;
	}
	public String getArchivefileAnual() {
		return archivefileAnual;
	}
	public void setArchivefileAnual(String archivefileAnual) {
		this.archivefileAnual = archivefileAnual;
	}
	public String getArchivefileResponsible() {
		return archivefileResponsible;
	}
	public void setArchivefileResponsible(String archivefileResponsible) {
		this.archivefileResponsible = archivefileResponsible;
	}
	public String getArchivefileCreatetime() {
		return archivefileCreatetime;
	}
	public void setArchivefileCreatetime(String archivefileCreatetime) {
		this.archivefileCreatetime = archivefileCreatetime;
	}
	public String getFerencenumber() {
		return ferencenumber;
	}
	public void setFerencenumber(String ferencenumber) {
		this.ferencenumber = ferencenumber;
	}
	public String getArchivefileTitle() {
		return archivefileTitle;
	}
	public void setArchivefileTitle(String archivefileTitle) {
		this.archivefileTitle = archivefileTitle;
	}
	public String getKnowledgebaseTitle() {
		return knowledgebaseTitle;
	}
	public void setKnowledgebaseTitle(String knowledgebaseTitle) {
		this.knowledgebaseTitle = knowledgebaseTitle;
	}
	public String getKnowledgebaseContent() {
		return knowledgebaseContent;
	}
	public void setKnowledgebaseContent(String knowledgebaseContent) {
		this.knowledgebaseContent = knowledgebaseContent;
	}
	public String getArchivefileFilenumber() {
		return archivefileFilenumber;
	}
	public void setArchivefileFilenumber(String archivefileFilenumber) {
		this.archivefileFilenumber = archivefileFilenumber;
	}
	public String getArchivefileSecurityclassrification() {
		return archivefileSecurityclassrification;
	}
	public void setArchivefileSecurityclassrification(String archivefileSecurityclassrification) {
		this.archivefileSecurityclassrification = archivefileSecurityclassrification;
	}
	public String getScCode() {
		return scCode;
	}
	public void setScCode(String scCode) {
		this.scCode = scCode;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getScStatus() {
		return scStatus;
	}
	public void setScStatus(String scStatus) {
		this.scStatus = scStatus;
	}
	public String getRetentionperiodCode() {
		return retentionperiodCode;
	}
	public void setRetentionperiodCode(String retentionperiodCode) {
		this.retentionperiodCode = retentionperiodCode;
	}
	public String getRetentionperiodName() {
		return retentionperiodName;
	}
	public void setRetentionperiodName(String retentionperiodName) {
		this.retentionperiodName = retentionperiodName;
	}
	public String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public String getBoxThickness() {
		return boxThickness;
	}
	public void setBoxThickness(String boxThickness) {
		this.boxThickness = boxThickness;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public String getPcTime() {
		return pcTime;
	}
	public void setPcTime(String pcTime) {
		this.pcTime = pcTime;
	}
	public String getIpType() {
		return ipType;
	}
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	public String getSubjectHeadings() {
		return subjectHeadings;
	}
	public void setSubjectHeadings(String subjectHeadings) {
		this.subjectHeadings = subjectHeadings;
	}
	@Override
	public String toString() {
		return "ModuleConditionalQueryVo [quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName
				+ ", qrganizationCode=" + qrganizationCode + ", qrganizationName=" + qrganizationName + ", userName="
				+ userName + ", userIdnumber=" + userIdnumber + ", userTelephone=" + userTelephone + ", userWorknumber="
				+ userWorknumber + ", roleName=" + roleName + ", logCreatetimeBegin=" + logCreatetimeBegin
				+ ", logCreatetimeEnd=" + logCreatetimeEnd + ", archivefileAnual=" + archivefileAnual
				+ ", archivefileResponsible=" + archivefileResponsible + ", archivefileCreatetime="
				+ archivefileCreatetime + ", ferencenumber=" + ferencenumber + ", archivefileTitle=" + archivefileTitle
				+ ", knowledgebaseTitle=" + knowledgebaseTitle + ", knowledgebaseContent=" + knowledgebaseContent
				+ ", archivefileFilenumber=" + archivefileFilenumber + ", archivefileSecurityclassrification="
				+ archivefileSecurityclassrification + ", scCode=" + scCode + ", scName=" + scName + ", scStatus="
				+ scStatus + ", retentionperiodCode=" + retentionperiodCode + ", retentionperiodName="
				+ retentionperiodName + ", boxNumber=" + boxNumber + ", boxThickness=" + boxThickness + ", condition="
				+ condition + ", theme=" + theme + ", time=" + time + ", content=" + content + ", pcCode=" + pcCode
				+ ", pcName=" + pcName + ", pcTime=" + pcTime + ", ipType=" + ipType + ", subjectHeadings="
				+ subjectHeadings + "]";
	}
	
	
	
	
	
}


