package filemanage.inventoryandinquire.pojo;

import filemanage.systemmanage.pojo.AmCoBox;

public class InventoryPlan {
	private String planId;//计划表主键
	private String planPerson;//盘点人
	private String planStartdate;//计划实施日期
	private String planEnddate;//计划完成日期
	private String planMakingDate;//计划制作日期
	private String planMakingPerson;//制作人
	private String planStatus;//状态（1:待盘点，2:盘点中，3:已盘点）
	private Integer planBoxNumber;//盒数
	private AmCoBox amCoBox;
	private String planUploadaddress;//上传文件目录
	private String sjsstime;	//实际实施时间
	private String sjwctime;	//实际完成时间
	private String pdjg;	//盘点结果
	
	
	@Override
	public String toString() {
		return "InventoryPlan [planId=" + planId + ", planPerson=" + planPerson + ", planStartdate=" + planStartdate
				+ ", planEnddate=" + planEnddate + ", planMakingDate=" + planMakingDate + ", planMakingPerson="
				+ planMakingPerson + ", planStatus=" + planStatus + ", planBoxNumber=" + planBoxNumber + ", amCoBox="
				+ amCoBox + ", planUploadaddress=" + planUploadaddress + ", sjsstime=" + sjsstime + ", sjwctime="
				+ sjwctime + ", pdjg=" + pdjg + "]";
	}
	public InventoryPlan(String planId, String planPerson, String planStartdate, String planEnddate,
			String planMakingDate, String planMakingPerson, String planStatus, Integer planBoxNumber, AmCoBox amCoBox,
			String planUploadaddress, String sjsstime, String sjwctime, String pdjg) {
		super();
		this.planId = planId;
		this.planPerson = planPerson;
		this.planStartdate = planStartdate;
		this.planEnddate = planEnddate;
		this.planMakingDate = planMakingDate;
		this.planMakingPerson = planMakingPerson;
		this.planStatus = planStatus;
		this.planBoxNumber = planBoxNumber;
		this.amCoBox = amCoBox;
		this.planUploadaddress = planUploadaddress;
		this.sjsstime = sjsstime;
		this.sjwctime = sjwctime;
		this.pdjg = pdjg;
	}
	public InventoryPlan() {
		super();
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanPerson() {
		return planPerson;
	}
	public void setPlanPerson(String planPerson) {
		this.planPerson = planPerson;
	}
	public String getPlanStartdate() {
		return planStartdate;
	}
	public void setPlanStartdate(String planStartdate) {
		this.planStartdate = planStartdate;
	}
	public String getPlanEnddate() {
		return planEnddate;
	}
	public void setPlanEnddate(String planEnddate) {
		this.planEnddate = planEnddate;
	}
	public String getPlanMakingDate() {
		return planMakingDate;
	}
	public void setPlanMakingDate(String planMakingDate) {
		this.planMakingDate = planMakingDate;
	}
	public String getPlanMakingPerson() {
		return planMakingPerson;
	}
	public void setPlanMakingPerson(String planMakingPerson) {
		this.planMakingPerson = planMakingPerson;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public Integer getPlanBoxNumber() {
		return planBoxNumber;
	}
	public void setPlanBoxNumber(Integer planBoxNumber) {
		this.planBoxNumber = planBoxNumber;
	}
	public AmCoBox getAmCoBox() {
		return amCoBox;
	}
	public void setAmCoBox(AmCoBox amCoBox) {
		this.amCoBox = amCoBox;
	}
	public String getPlanUploadaddress() {
		return planUploadaddress;
	}
	public void setPlanUploadaddress(String planUploadaddress) {
		this.planUploadaddress = planUploadaddress;
	}
	public String getSjsstime() {
		return sjsstime;
	}
	public void setSjsstime(String sjsstime) {
		this.sjsstime = sjsstime;
	}
	public String getSjwctime() {
		return sjwctime;
	}
	public void setSjwctime(String sjwctime) {
		this.sjwctime = sjwctime;
	}
	public String getPdjg() {
		return pdjg;
	}
	public void setPdjg(String pdjg) {
		this.pdjg = pdjg;
	}
	
	

}
