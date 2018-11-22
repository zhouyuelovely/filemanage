package filemanage.systemmanage.vo;

import java.util.Date;

/**
 * @author meng
 *
 */
public class LogginProduceCondition {
	private String userName;// 用户名
	private String beginTime;// 开始时间
	private String endTime;// 结束时间
	private Integer begin;// 分页起始页面
	private Integer end;// 分页结束页面

	public LogginProduceCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogginProduceCondition(String userName, String beginTime, String endTime, Integer begin, Integer end) {
		super();
		this.userName = userName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public String toString() {
		return "LogginProduceCondition [userName=" + userName + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", begin=" + begin + ", end=" + end + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

}
