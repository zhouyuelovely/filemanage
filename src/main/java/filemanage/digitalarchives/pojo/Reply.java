package filemanage.digitalarchives.pojo;

import filemanage.login.pojo.User;

/**
 * 回复表
 * @author 陈一达
 *
 */
public class Reply {

	private String replyId;						//回复主键
	private String replyTime;					//回复时间
	private String replyContent;				//回复内容
	private String ruserId;						//回复人(用户主键)
	private Advice adviceId;					//咨询建议主键
	public Reply() {
		super();
	}
	public Reply(String replyId, String replyTime, String replyContent, String ruserId, Advice adviceId) {
		super();
		this.replyId = replyId;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
		this.ruserId = ruserId;
		this.adviceId = adviceId;
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyTime=" + replyTime + ", replyContent=" + replyContent
				+ ", ruserId=" + ruserId + ", adviceId=" + adviceId + "]";
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
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
	public String getRuserId() {
		return ruserId;
	}
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}
	public Advice getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(Advice adviceId) {
		this.adviceId = adviceId;
	}
	
	
}
