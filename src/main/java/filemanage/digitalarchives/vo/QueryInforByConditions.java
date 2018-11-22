package filemanage.digitalarchives.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author tchuanwu
 *  档案信息门户条件查询辅助类
 */
public class QueryInforByConditions {
	private String iPId;//主键
	private String iPIndexNum;//索引号
	private String iPDocumentNum;//文号
	private String iPType;//信息类型
	private String iPTimealness;//信息有效性
	private String iPForm;//发布形式
	private String iPContent;//信息内容
	private String iPStatus;//信息状态（1：已读，2：未读）
	private String iPPerson;//信息发布人
	private String iPName;//信息名称
	private String subjectHeadings;//主题词  
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date iPFormDate;//发布日期
	private String queryConditions;//关键词
	private Integer before;//分页开始位置
	private Integer after; //分页结束位置
	
	public QueryInforByConditions() {
		
	}

	public QueryInforByConditions(String iPId, String iPIndexNum, String iPDocumentNum, String iPType,
			String iPTimealness, String iPForm, String iPContent, String iPStatus, String iPPerson, String iPName,
			String subjectHeadings, Date iPFormDate, String queryConditions, Integer before, Integer after) {
		super();
		this.iPId = iPId;
		this.iPIndexNum = iPIndexNum;
		this.iPDocumentNum = iPDocumentNum;
		this.iPType = iPType;
		this.iPTimealness = iPTimealness;
		this.iPForm = iPForm;
		this.iPContent = iPContent;
		this.iPStatus = iPStatus;
		this.iPPerson = iPPerson;
		this.iPName = iPName;
		this.subjectHeadings = subjectHeadings;
		this.iPFormDate = iPFormDate;
		this.queryConditions = queryConditions;
		this.before = before;
		this.after = after;
	}

	public String getiPId() {
		return iPId;
	}

	public void setiPId(String iPId) {
		this.iPId = iPId;
	}

	public String getiPIndexNum() {
		return iPIndexNum;
	}

	public void setiPIndexNum(String iPIndexNum) {
		this.iPIndexNum = iPIndexNum;
	}

	public String getiPDocumentNum() {
		return iPDocumentNum;
	}

	public void setiPDocumentNum(String iPDocumentNum) {
		this.iPDocumentNum = iPDocumentNum;
	}

	public String getiPType() {
		return iPType;
	}

	public void setiPType(String iPType) {
		this.iPType = iPType;
	}

	public String getiPTimealness() {
		return iPTimealness;
	}

	public void setiPTimealness(String iPTimealness) {
		this.iPTimealness = iPTimealness;
	}

	public String getiPForm() {
		return iPForm;
	}

	public void setiPForm(String iPForm) {
		this.iPForm = iPForm;
	}

	public String getiPContent() {
		return iPContent;
	}

	public void setiPContent(String iPContent) {
		this.iPContent = iPContent;
	}

	public String getiPStatus() {
		return iPStatus;
	}

	public void setiPStatus(String iPStatus) {
		this.iPStatus = iPStatus;
	}

	public String getiPPerson() {
		return iPPerson;
	}

	public void setiPPerson(String iPPerson) {
		this.iPPerson = iPPerson;
	}

	public String getiPName() {
		return iPName;
	}

	public void setiPName(String iPName) {
		this.iPName = iPName;
	}

	public String getSubjectHeadings() {
		return subjectHeadings;
	}

	public void setSubjectHeadings(String subjectHeadings) {
		this.subjectHeadings = subjectHeadings;
	}

	public Date getiPFormDate() {
		return iPFormDate;
	}

	public void setiPFormDate(Date iPFormDate) {
		this.iPFormDate = iPFormDate;
	}

	public String getQueryConditions() {
		return queryConditions;
	}

	public void setQueryConditions(String queryConditions) {
		this.queryConditions = queryConditions;
	}

	public Integer getBefore() {
		return before;
	}

	public void setBefore(Integer before) {
		this.before = before;
	}

	public Integer getAfter() {
		return after;
	}

	public void setAfter(Integer after) {
		this.after = after;
	}

	@Override
	public String toString() {
		return "QueryInforByConditions [iPId=" + iPId + ", iPIndexNum=" + iPIndexNum + ", iPDocumentNum="
				+ iPDocumentNum + ", iPType=" + iPType + ", iPTimealness=" + iPTimealness + ", iPForm=" + iPForm
				+ ", iPContent=" + iPContent + ", iPStatus=" + iPStatus + ", iPPerson=" + iPPerson + ", iPName="
				+ iPName + ", subjectHeadings=" + subjectHeadings + ", iPFormDate=" + iPFormDate + ", queryConditions="
				+ queryConditions + ", before=" + before + ", after=" + after + "]";
	}

	
	
	
	
	
	

}
