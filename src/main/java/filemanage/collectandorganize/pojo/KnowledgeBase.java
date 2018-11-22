package filemanage.collectandorganize.pojo;

import java.util.Date;

/**
 * @author tchuanwu
 * 知识库映射类
 */
public class KnowledgeBase {
	private String knowledgeId;//知识库主键
	private String knowledgeDocumentNum;//知识库文号
	private String KnowledgeType;//知识库类型
	private String knowledgeReleaDate;//发布日期
	private String knowledgeTitle;//知识库标题
	private String knowledgeContent;//知识库内容
	private String knowledgePublaster;//发布人
	private String conditions;//关键词查询
	
	public KnowledgeBase() {
		
	}

	public KnowledgeBase(String knowledgeId, String knowledgeDocumentNum, String knowledgeType, String knowledgeReleaDate,
			String knowledgeTitle, String knowledgeContent, String knowledgePublaster, String conditions) {
		super();
		this.knowledgeId = knowledgeId;
		this.knowledgeDocumentNum = knowledgeDocumentNum;
		KnowledgeType = knowledgeType;
		this.knowledgeReleaDate = knowledgeReleaDate;
		this.knowledgeTitle = knowledgeTitle;
		this.knowledgeContent = knowledgeContent;
		this.knowledgePublaster = knowledgePublaster;
		this.conditions = conditions;
	}

	public String getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getKnowledgeDocumentNum() {
		return knowledgeDocumentNum;
	}

	public void setKnowledgeDocumentNum(String knowledgeDocumentNum) {
		this.knowledgeDocumentNum = knowledgeDocumentNum;
	}

	public String getKnowledgeType() {
		return KnowledgeType;
	}

	public void setKnowledgeType(String knowledgeType) {
		KnowledgeType = knowledgeType;
	}

	public String getKnowledgeReleaDate() {
		return knowledgeReleaDate;
	}

	public void setKnowledgeReleaDate(String knowledgeReleaDate) {
		this.knowledgeReleaDate = knowledgeReleaDate;
	}

	public String getKnowledgeTitle() {
		return knowledgeTitle;
	}

	public void setKnowledgeTitle(String knowledgeTitle) {
		this.knowledgeTitle = knowledgeTitle;
	}

	public String getKnowledgeContent() {
		return knowledgeContent;
	}

	public void setKnowledgeContent(String knowledgeContent) {
		this.knowledgeContent = knowledgeContent;
	}

	public String getKnowledgePublaster() {
		return knowledgePublaster;
	}

	public void setKnowledgePublaster(String knowledgePublaster) {
		this.knowledgePublaster = knowledgePublaster;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "KnowledgeBase [knowledgeId=" + knowledgeId + ", knowledgeDocumentNum=" + knowledgeDocumentNum
				+ ", KnowledgeType=" + KnowledgeType + ", knowledgeReleaDate=" + knowledgeReleaDate
				+ ", knowledgeTitle=" + knowledgeTitle + ", knowledgeContent=" + knowledgeContent
				+ ", knowledgePublaster=" + knowledgePublaster + ", conditions=" + conditions + "]";
	}

	
	
	

}
