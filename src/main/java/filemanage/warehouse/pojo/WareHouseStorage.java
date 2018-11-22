package filemanage.warehouse.pojo;
/**
 * @author mlt 库房管理_档案入库映射类
 */
public class WareHouseStorage {

	private String storageId; // 入库表主键
	private String storageRackNumber;// 架位号
	private Integer storageIsplan; // 是否加入计划(1:是，2：否)
	private String planId; // 计划表主键
	private String wareHouseBuildId;// 库房表主键

	public WareHouseStorage() {
		super();
	}

	public WareHouseStorage(String storageId, String storageRackNumber, Integer storageIsplan, String planId,
			String wareHouseBuildId) {
		super();
		this.storageId = storageId;
		this.storageRackNumber = storageRackNumber;
		this.storageIsplan = storageIsplan;
		this.planId = planId;
		this.wareHouseBuildId = wareHouseBuildId;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageRackNumber() {
		return storageRackNumber;
	}

	public void setStorageRackNumber(String storageRackNumber) {
		this.storageRackNumber = storageRackNumber;
	}

	public Integer getStorageIsplan() {
		return storageIsplan;
	}

	public void setStorageIsplan(Integer storageIsplan) {
		this.storageIsplan = storageIsplan;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getWareHouseBuildId() {
		return wareHouseBuildId;
	}

	public void setWareHouseBuildId(String wareHouseBuildId) {
		this.wareHouseBuildId = wareHouseBuildId;
	}

	@Override
	public String toString() {
		return "WareHouseStorage [storageId=" + storageId + ", storageRackNumber=" + storageRackNumber
				+ ", storageIsplan=" + storageIsplan + ", planId=" + planId + ", wareHouseBuildId=" + wareHouseBuildId
				+ "]";
	}

}
