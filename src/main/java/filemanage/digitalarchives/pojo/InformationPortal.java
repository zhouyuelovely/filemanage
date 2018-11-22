package filemanage.digitalarchives.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author tchuanwu
 * 档案信息门户映射类
 */
public class InformationPortal {
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
	
	public InformationPortal() {
		
	}

	public InformationPortal(String iPId, String iPIndexNum, String iPDocumentNum, String iPType, String iPTimealness,
			String iPForm, String iPContent, String iPStatus, String iPPerson, String iPName, String subjectHeadings,
			Date iPFormDate) {
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

	@Override
	public String toString() {
		return "InformationPortal [iPId=" + iPId + ", iPIndexNum=" + iPIndexNum + ", iPDocumentNum=" + iPDocumentNum
				+ ", iPType=" + iPType + ", iPTimealness=" + iPTimealness + ", iPForm=" + iPForm + ", iPContent="
				+ iPContent + ", iPStatus=" + iPStatus + ", iPPerson=" + iPPerson + ", iPName=" + iPName
				+ ", subjectHeadings=" + subjectHeadings + ", iPFormDate=" + iPFormDate + "]";
	}
	
	
	
	

	

	

	
	

}
