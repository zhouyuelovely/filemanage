package filemanage.systemmanage.pojo;

import java.util.Date;

import filemanage.login.pojo.User;

/**
 * @author meng 日志
 */
public class LoggingProduce {
	private String logId;// 日志主键
	private String logContent;// 日志内容
	private Date logCreateTime;// 日志时间
	private User user;// 用户信息

	public LoggingProduce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoggingProduce(String logId, String logContent, Date logCreateTime, User user) {
		super();
		this.logId = logId;
		this.logContent = logContent;
		this.logCreateTime = logCreateTime;
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoggingProduce [logId=" + logId + ", logContent=" + logContent + ", logCreateTime=" + logCreateTime
				+ ", user=" + user + "]";
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Date getLogCreateTime() {
		return logCreateTime;
	}

	public void setLogCreateTime(Date logCreateTime) {
		this.logCreateTime = logCreateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
