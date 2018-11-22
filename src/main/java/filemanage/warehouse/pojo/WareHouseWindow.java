package filemanage.warehouse.pojo;

/**
 * @author mlt
 * 库房管理_库房窗户朝向映射类
 */
public class WareHouseWindow {

	private Integer windowId;// 仓库窗子主键
	private String windowDirection;// 仓库窗子朝向
	private String wareHouseBuildId;// 仓库主键

	public WareHouseWindow() {
		super();
	}

	public WareHouseWindow(Integer windowId, String windowDirection, String wareHouseBuildId) {
		super();
		this.windowId = windowId;
		this.windowDirection = windowDirection;
		this.wareHouseBuildId = wareHouseBuildId;
	}

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
	}

	public String getWindowDirection() {
		return windowDirection;
	}

	public void setWindowDirection(String windowDirection) {
		this.windowDirection = windowDirection;
	}

	public String getWareHouseBuildId() {
		return wareHouseBuildId;
	}

	public void setWareHouseBuildId(String wareHouseBuildId) {
		this.wareHouseBuildId = wareHouseBuildId;
	}

	@Override
	public String toString() {
		return "WareHouseWindow [windowId=" + windowId + ", windowDirection=" + windowDirection + ", wareHouseBuildId="
				+ wareHouseBuildId + "]";
	}

}
