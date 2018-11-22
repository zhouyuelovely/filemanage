package filemanage.digitalarchives.vo;

public class exchangeCenterVo {

	private String adviceTheme;							//主题	
	private String adviceType;							//咨询/建议类型
	private String advicePublicinformation;				//公开情况
	private String adviceTime;							//咨询建议提交时间
	private String adviceContent;						//咨询建议内容
	private String replyTime;							//回复时间
	private String replyContent;						//回复内容
	private String userId;								//咨询人/回复人 ID
	private String commitType;							//提交状态（咨询？回复？）
	private String adviceId;							//咨询人ID
	public exchangeCenterVo() {
		super();
	}
	public exchangeCenterVo(String adviceTheme, String adviceType, String advicePublicinformation, String adviceTime,
			String adviceContent, String replyTime, String replyContent, String userId, String commitType,
			String adviceId) {
		super();
		this.adviceTheme = adviceTheme;
		this.adviceType = adviceType;
		this.advicePublicinformation = advicePublicinformation;
		this.adviceTime = adviceTime;
		this.adviceContent = adviceContent;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
		this.userId = userId;
		this.commitType = commitType;
		this.adviceId = adviceId;
	}
	@Override
	public String toString() {
		return "exchangeCenterVo [adviceTheme=" + adviceTheme + ", adviceType=" + adviceType
				+ ", advicePublicinformation=" + advicePublicinformation + ", adviceTime=" + adviceTime
				+ ", adviceContent=" + adviceContent + ", replyTime=" + replyTime + ", replyContent=" + replyContent
				+ ", userId=" + userId + ", commitType=" + commitType + ", adviceId=" + adviceId + "]";
	}
	public String getAdviceTheme() {
		return adviceTheme;
	}
	public void setAdviceTheme(String adviceTheme) {
		this.adviceTheme = adviceTheme;
	}
	public String getAdviceType() {
		return adviceType;
	}
	public void setAdviceType(String adviceType) {
		this.adviceType = adviceType;
	}
	public String getAdvicePublicinformation() {
		return advicePublicinformation;
	}
	public void setAdvicePublicinformation(String advicePublicinformation) {
		this.advicePublicinformation = advicePublicinformation;
	}
	public String getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(String adviceTime) {
		this.adviceTime = adviceTime;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommitType() {
		return commitType;
	}
	public void setCommitType(String commitType) {
		this.commitType = commitType;
	}
	public String getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
	}
		
}
