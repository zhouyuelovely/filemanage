package filemanage.danganmanage.vo;

public class DanganmanageCondition {
	
	private String managerDetailsApplication;//申请项
	private String managerDetailsPerson;//申请人
	private String startTime;//开始时间
	private String endTime;//结束时间
	private Integer before; //分页开始位置
	private Integer after; //分页结束位置
	private String idStatus;//文件主键状态
	
	public DanganmanageCondition() {
		
	}

	public DanganmanageCondition(String managerDetailsApplication, String managerDetailsPerson, String startTime,
			String endTime, Integer before, Integer after, String idStatus) {
		super();
		this.managerDetailsApplication = managerDetailsApplication;
		this.managerDetailsPerson = managerDetailsPerson;
		this.startTime = startTime;
		this.endTime = endTime;
		this.before = before;
		this.after = after;
		this.idStatus = idStatus;
	}

	public String getManagerDetailsApplication() {
		return managerDetailsApplication;
	}

	public void setManagerDetailsApplication(String managerDetailsApplication) {
		this.managerDetailsApplication = managerDetailsApplication;
	}

	public String getManagerDetailsPerson() {
		return managerDetailsPerson;
	}

	public void setManagerDetailsPerson(String managerDetailsPerson) {
		this.managerDetailsPerson = managerDetailsPerson;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	@Override
	public String toString() {
		return "DanganmanageCondition [managerDetailsApplication=" + managerDetailsApplication
				+ ", managerDetailsPerson=" + managerDetailsPerson + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", before=" + before + ", after=" + after + ", idStatus=" + idStatus + "]";
	}

	
	
	
	
	

}
