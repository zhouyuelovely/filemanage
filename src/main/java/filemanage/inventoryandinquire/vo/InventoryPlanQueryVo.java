package filemanage.inventoryandinquire.vo;

public class InventoryPlanQueryVo {
	private String planPerson;//盘点人
	private Integer planStatus;//状态（1:待盘点，2:盘点中，3:已盘点）
	private String condition;
	
	public InventoryPlanQueryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryPlanQueryVo(String planPerson, Integer planStatus, String condition) {
		super();
		this.planPerson = planPerson;
		this.planStatus = planStatus;
		this.condition = condition;
	}

	public String getPlanPerson() {
		return planPerson;
	}

	public void setPlanPerson(String planPerson) {
		this.planPerson = planPerson;
	}

	public Integer getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(Integer planStatus) {
		this.planStatus = planStatus;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "InventoryPlanQueryVo [planPerson=" + planPerson + ", planStatus=" + planStatus + ", condition="
				+ condition + "]";
	}
	
}
