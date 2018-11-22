package filemanage.inventoryandinquire.vo;

public class InventoryPlanningVo {
	private String boxId; // 盒子主键
	private String boxSericalNumber; // 盒子编号
	private String boxStartNumber; // 起件号
	private String boxEndNumber; // 止件号
	private String pcName;// 一级分类名称(档案类型)
	private String storageRacknumber;// 架位号
	private String joinPlan;// 是否加入计划
	private String juider;//
	/*
	 * private Archive archive;//全宗类 private PrimaryClassFication
	 * primaryClassFication;//一级分类类 private SecondryClassFication
	 * secondryClassFication;//二级分类类 private WareHouseStorage
	 * wareHouseStorage;//入库表类 private AmMaSmRetentionperiod
	 * amMaSmRetentionperiod;//保管期限类
	 */

	public InventoryPlanningVo() {
		super();
	}

	public String getJuider() {
		return juider;
	}

	public void setJuider(String juider) {
		if (juider.equals("未盘点")) {
			this.juider = "未盘点";
		} else if (juider.equals("1")) {
			this.juider = "未盘点";
		} else if (juider.equals("1.0")) {
			this.juider = "未盘点";
		} else {
			this.juider = "已盘点";
		}
	}

	public InventoryPlanningVo(String boxId, String boxSericalNumber, String boxStartNumber, String boxEndNumber,
			String pcName, String storageRacknumber, String joinPlan, String juider) {
		super();
		this.boxId = boxId;
		this.boxSericalNumber = boxSericalNumber;
		this.boxStartNumber = boxStartNumber;
		this.boxEndNumber = boxEndNumber;
		this.pcName = pcName;
		this.storageRacknumber = storageRacknumber;
		this.joinPlan = joinPlan;
		setJuider(juider);
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxSericalNumber() {
		return boxSericalNumber;
	}

	public void setBoxSericalNumber(String boxSericalNumber) {
		this.boxSericalNumber = boxSericalNumber;
	}

	public String getBoxStartNumber() {
		return boxStartNumber;
	}

	public void setBoxStartNumber(String boxStartNumber) {
		this.boxStartNumber = boxStartNumber;
	}

	public String getBoxEndNumber() {
		return boxEndNumber;
	}

	public void setBoxEndNumber(String boxEndNumber) {
		this.boxEndNumber = boxEndNumber;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getStorageRacknumber() {
		return storageRacknumber;
	}

	public void setStorageRacknumber(String storageRacknumber) {
		this.storageRacknumber = storageRacknumber;
	}

	public String getJoinPlan() {
		return joinPlan;
	}

	public void setJoinPlan(String joinPlan) {
		this.joinPlan = joinPlan;
	}

	@Override
	public String toString() {
		return "InventoryPlanningVo [boxId=" + boxId + ", boxSericalNumber=" + boxSericalNumber + ", boxStartNumber="
				+ boxStartNumber + ", boxEndNumber=" + boxEndNumber + ", pcName=" + pcName + ", storageRacknumber="
				+ storageRacknumber + ", joinPlan=" + joinPlan + ", juider=" + juider + "]";
	}

}
