package filemanage.digitalarchives.pojo;

import java.util.Date;

import filemanage.login.pojo.User;

/**
 * 咨询建议表
 * @author 陈一达
 *
 */
public class Advice {

	private String adviceId;							//咨询建议主键
	private String adviceType;							//咨询建议类别（1:咨询2：建议）
	private String advicePublicinformation;				//公开情况
	private String adviceTheme;							//主题
	private String adviceContent;						//内容
	private String adviceTime;							//提交时间
	private String adviceStatus;						//回复状态
	private User   userIds;								//咨询建议人主键（用户主键）
	private String ruserId;								//回复用户主键（ID）
	private String replyContent;						//回复内容
	private String replyTime;							//回复时间
	
	
	public Advice() {
		super();
	}
	
	
	public Advice(String adviceId, String adviceType, String advicePublicinformation, String adviceTheme,
			String adviceContent, String adviceTime, String adviceStatus, User userIds, String ruserId,
			String replyContent, String replyTime) {
		super();
		this.adviceId = adviceId;
		this.adviceType = adviceType;
		this.advicePublicinformation = advicePublicinformation;
		this.adviceTheme = adviceTheme;
		this.adviceContent = adviceContent;
		this.adviceTime = adviceTime;
		this.adviceStatus = adviceStatus;
		this.userIds = userIds;
		this.ruserId = ruserId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}


	@Override
	public String toString() {
		return "Advice [adviceId=" + adviceId + ", adviceType=" + adviceType + ", advicePublicinformation="
				+ advicePublicinformation + ", adviceTheme=" + adviceTheme + ", adviceContent=" + adviceContent
				+ ", adviceTime=" + adviceTime + ", adviceStatus=" + adviceStatus + ", userIds=" + userIds
				+ ", ruserId=" + ruserId + ", replyContent=" + replyContent + ", replyTime=" + replyTime + "]";
	}


	public String getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
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
	public String getAdviceTheme() {
		return adviceTheme;
	}
	public void setAdviceTheme(String adviceTheme) {
		this.adviceTheme = adviceTheme;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(String adviceTime) {
		this.adviceTime = adviceTime;
	}
	public String getAdviceStatus() {
		return adviceStatus;
	}
	public void setAdviceStatus(String adviceStatus) {
		this.adviceStatus = adviceStatus;
	}
	public User getUserIds() {
		return userIds;
	}
	public void setUserIds(User userIds) {
		this.userIds = userIds;
	}
	public String getRuserId() {
		return ruserId;
	}
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	
	
}
