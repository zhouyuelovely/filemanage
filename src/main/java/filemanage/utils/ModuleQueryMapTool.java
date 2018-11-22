package filemanage.utils;

import java.util.HashMap;
import java.util.Map;

public class ModuleQueryMapTool {
	
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
	
	public static void main(String[] args) {
		ModuleConditionalQueryTool sdf = new ModuleConditionalQueryTool();
		ModuleQueryMapTool a = new ModuleQueryMapTool();
		sdf.setQuanzongName("asdfgas");
		sdf.setQuanzongNumber("asdfadg");
		a.queryMap(sdf);
		System.out.println(a.queryMap(sdf));
	}
	/**
	 * 将各个查询条件封装到MAP中
	 * @param mdqm
	 * @return
	 */
	public Map<String, Object> queryMap(ModuleConditionalQueryTool mdqm){
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongNumber", mdqm.getQuanzongNumber());
		map.put("quanzongName", mdqm.getQuanzongName());
		map.put("qrganizationCode", mdqm.getQrganizationCode());
		map.put("qrganizationName", mdqm.getQrganizationName());
		map.put("userName", mdqm.getUserName());
		map.put("userIdnumber", mdqm.getUserIdnumber());
		map.put("userTelephone", mdqm.getUserTelephone());
		map.put("userWorknumber", mdqm.getUserWorknumber());
		map.put("roleName", mdqm.getRoleName());
		map.put("logCreatetimeBegin", mdqm.getLogCreatetimeBegin());
		map.put("logCreatetimeEnd", mdqm.getLogCreatetimeEnd());
		map.put("archivefileAnual", mdqm.getArchivefileAnual());
		map.put("archivefileResponsible", mdqm.getArchivefileResponsible());
		map.put("archivefileCreatetime", mdqm.getArchivefileCreatetime());
		map.put("ferencenumber", mdqm.getFerencenumber());
		map.put("archivefileTitle", mdqm.getArchivefileTitle());
		map.put("knowledgebaseTitle", mdqm.getKnowledgebaseTitle());
		map.put("knowledgebaseContent", mdqm.getKnowledgebaseTitle());
		map.put("archivefileFilenumber", mdqm.getArchivefileFilenumber());
		map.put("archivefileSecurityclassrification", mdqm.getArchivefileSecurityclassrification());
		map.put("scCode", mdqm.getScCode());
		map.put("scName", mdqm.getScName());
		map.put("scStatus", mdqm.getScStatus());
		map.put("retentionperiodCode", mdqm.getRetentionperiodCode());
		map.put("retentionperiodName", mdqm.getRetentionperiodName());
		map.put("boxNumber", mdqm.getBoxNumber());
		map.put("boxThickness", mdqm.getBoxThickness());
		map.put("theme", mdqm.getTheme());
		map.put("time", mdqm.getTime());
		map.put("content", mdqm.getContent());
		map.put("pcCode", mdqm.getPcCode());
		map.put("pcName", mdqm.getPcName());
		map.put("pcTime", mdqm.getPcTime());
		map.put("ipType", mdqm.getIpType());
		map.put("subjectHeadings", mdqm.getSubjectHeadings());
		return map;
		
	}
}
