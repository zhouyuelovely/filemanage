package filemanage.warehouse.pojo;

import filemanage.systemmanage.pojo.AmCoBox;
/**
 * @author mlt 库房表映射实体类
 */
public class WareHouseBuild {

	private String wareHouseBuildId;// 主键
	private String wareHouseBuildNumber;// 库房号
	private String wareHouseBuildName;// 库房名称
	private String wareHouseBuildLong;// 长
	private String wareHouseBuildWidth;// 宽
	private String wareHouseBuildHigh;// 高
	private String wareHouseBuildArea;// 面积
	private String wareHouseBuildVolume;// 体积
	private String wareHouseBuildDoor;// 门朝向
	private String wareHouseBuildWindow;// 窗户朝向
	private String wareHouseBuildTemperature;// 温度
	private String wareHouseBuildHumidity;// 湿度
	private String wareHouseBuildShelvesNum;// 密集架数目
	private String wareHouseBuildDirection;// 密集架方向
	private String wareHouseBuildNamingDirection;// 命名方向
	private String wareHouseBuildShelfNumber;// 密集架编号(以；进行分割)
	private String wareHouseBuildGroupsNum;// 每个密集架的组数
	private String wareHouseBuildGroupNameDirect;// 组的命名方向
	private String wareHouseBuildGroupNumber;// 组编号(规则同密集架)
	private String wareHouseBuildLatticeNum;// 每组格子数
	private String wareHouseBuildLattiNameDirect;// 格子命名方向
	private String wareHouseBuildLatticeNumber;// 格子编号(同上)
	private String condition;
	private AmCoBox amCoBox;// 档案盒
	private WareHouseStorage wareHouseStorage;

	public WareHouseBuild() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WareHouseBuild(String wareHouseBuildId, String wareHouseBuildNumber, String wareHouseBuildName,
			String wareHouseBuildLong, String wareHouseBuildWidth, String wareHouseBuildHigh, String wareHouseBuildArea,
			String wareHouseBuildVolume, String wareHouseBuildDoor, String wareHouseBuildWindow,
			String wareHouseBuildTemperature, String wareHouseBuildHumidity, String wareHouseBuildShelvesNum,
			String wareHouseBuildDirection, String wareHouseBuildNamingDirection, String wareHouseBuildShelfNumber,
			String wareHouseBuildGroupsNum, String wareHouseBuildGroupNameDirect, String wareHouseBuildGroupNumber,
			String wareHouseBuildLatticeNum, String wareHouseBuildLattiNameDirect, String wareHouseBuildLatticeNumber,
			String condition, AmCoBox amCoBox, WareHouseStorage wareHouseStorage) {
		super();
		this.wareHouseBuildId = wareHouseBuildId;
		this.wareHouseBuildNumber = wareHouseBuildNumber;
		this.wareHouseBuildName = wareHouseBuildName;
		this.wareHouseBuildLong = wareHouseBuildLong;
		this.wareHouseBuildWidth = wareHouseBuildWidth;
		this.wareHouseBuildHigh = wareHouseBuildHigh;
		this.wareHouseBuildArea = wareHouseBuildArea;
		this.wareHouseBuildVolume = wareHouseBuildVolume;
		this.wareHouseBuildDoor = wareHouseBuildDoor;
		this.wareHouseBuildWindow = wareHouseBuildWindow;
		this.wareHouseBuildTemperature = wareHouseBuildTemperature;
		this.wareHouseBuildHumidity = wareHouseBuildHumidity;
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
		this.wareHouseBuildDirection = wareHouseBuildDirection;
		this.wareHouseBuildNamingDirection = wareHouseBuildNamingDirection;
		this.wareHouseBuildShelfNumber = wareHouseBuildShelfNumber;
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
		this.wareHouseBuildGroupNameDirect = wareHouseBuildGroupNameDirect;
		this.wareHouseBuildGroupNumber = wareHouseBuildGroupNumber;
		this.wareHouseBuildLatticeNum = wareHouseBuildLatticeNum;
		this.wareHouseBuildLattiNameDirect = wareHouseBuildLattiNameDirect;
		this.wareHouseBuildLatticeNumber = wareHouseBuildLatticeNumber;
		this.condition = condition;
		this.amCoBox = amCoBox;
		this.wareHouseStorage = wareHouseStorage;
	}

	public String getWareHouseBuildId() {
		return wareHouseBuildId;
	}

	public void setWareHouseBuildId(String wareHouseBuildId) {
		this.wareHouseBuildId = wareHouseBuildId;
	}

	public String getWareHouseBuildNumber() {
		return wareHouseBuildNumber;
	}

	public void setWareHouseBuildNumber(String wareHouseBuildNumber) {
		this.wareHouseBuildNumber = wareHouseBuildNumber;
	}

	public String getWareHouseBuildName() {
		return wareHouseBuildName;
	}

	public void setWareHouseBuildName(String wareHouseBuildName) {
		this.wareHouseBuildName = wareHouseBuildName;
	}

	public String getWareHouseBuildLong() {
		return wareHouseBuildLong;
	}

	public void setWareHouseBuildLong(String wareHouseBuildLong) {
		this.wareHouseBuildLong = wareHouseBuildLong;
	}

	public String getWareHouseBuildWidth() {
		return wareHouseBuildWidth;
	}

	public void setWareHouseBuildWidth(String wareHouseBuildWidth) {
		this.wareHouseBuildWidth = wareHouseBuildWidth;
	}

	public String getWareHouseBuildHigh() {
		return wareHouseBuildHigh;
	}

	public void setWareHouseBuildHigh(String wareHouseBuildHigh) {
		this.wareHouseBuildHigh = wareHouseBuildHigh;
	}

	public String getWareHouseBuildArea() {
		return wareHouseBuildArea;
	}

	public void setWareHouseBuildArea(String wareHouseBuildArea) {
		this.wareHouseBuildArea = wareHouseBuildArea;
	}

	public String getWareHouseBuildVolume() {
		return wareHouseBuildVolume;
	}

	public void setWareHouseBuildVolume(String wareHouseBuildVolume) {
		this.wareHouseBuildVolume = wareHouseBuildVolume;
	}

	public String getWareHouseBuildDoor() {
		return wareHouseBuildDoor;
	}

	public void setWareHouseBuildDoor(String wareHouseBuildDoor) {
		this.wareHouseBuildDoor = wareHouseBuildDoor;
	}

	public String getWareHouseBuildWindow() {
		return wareHouseBuildWindow;
	}

	public void setWareHouseBuildWindow(String wareHouseBuildWindow) {
		this.wareHouseBuildWindow = wareHouseBuildWindow;
	}

	public String getWareHouseBuildTemperature() {
		return wareHouseBuildTemperature;
	}

	public void setWareHouseBuildTemperature(String wareHouseBuildTemperature) {
		this.wareHouseBuildTemperature = wareHouseBuildTemperature;
	}

	public String getWareHouseBuildHumidity() {
		return wareHouseBuildHumidity;
	}

	public void setWareHouseBuildHumidity(String wareHouseBuildHumidity) {
		this.wareHouseBuildHumidity = wareHouseBuildHumidity;
	}

	public String getWareHouseBuildShelvesNum() {
		return wareHouseBuildShelvesNum;
	}

	public void setWareHouseBuildShelvesNum(String wareHouseBuildShelvesNum) {
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
	}

	public String getWareHouseBuildDirection() {
		return wareHouseBuildDirection;
	}

	public void setWareHouseBuildDirection(String wareHouseBuildDirection) {
		this.wareHouseBuildDirection = wareHouseBuildDirection;
	}

	public String getWareHouseBuildNamingDirection() {
		return wareHouseBuildNamingDirection;
	}

	public void setWareHouseBuildNamingDirection(String wareHouseBuildNamingDirection) {
		this.wareHouseBuildNamingDirection = wareHouseBuildNamingDirection;
	}

	public String getWareHouseBuildShelfNumber() {
		return wareHouseBuildShelfNumber;
	}

	public void setWareHouseBuildShelfNumber(String wareHouseBuildShelfNumber) {
		this.wareHouseBuildShelfNumber = wareHouseBuildShelfNumber;
	}

	public String getWareHouseBuildGroupsNum() {
		return wareHouseBuildGroupsNum;
	}

	public void setWareHouseBuildGroupsNum(String wareHouseBuildGroupsNum) {
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
	}

	public String getWareHouseBuildGroupNameDirect() {
		return wareHouseBuildGroupNameDirect;
	}

	public void setWareHouseBuildGroupNameDirect(String wareHouseBuildGroupNameDirect) {
		this.wareHouseBuildGroupNameDirect = wareHouseBuildGroupNameDirect;
	}

	public String getWareHouseBuildGroupNumber() {
		return wareHouseBuildGroupNumber;
	}

	public void setWareHouseBuildGroupNumber(String wareHouseBuildGroupNumber) {
		this.wareHouseBuildGroupNumber = wareHouseBuildGroupNumber;
	}

	public String getWareHouseBuildLatticeNum() {
		return wareHouseBuildLatticeNum;
	}

	public void setWareHouseBuildLatticeNum(String wareHouseBuildLatticeNum) {
		this.wareHouseBuildLatticeNum = wareHouseBuildLatticeNum;
	}

	public String getWareHouseBuildLattiNameDirect() {
		return wareHouseBuildLattiNameDirect;
	}

	public void setWareHouseBuildLattiNameDirect(String wareHouseBuildLattiNameDirect) {
		this.wareHouseBuildLattiNameDirect = wareHouseBuildLattiNameDirect;
	}

	public String getWareHouseBuildLatticeNumber() {
		return wareHouseBuildLatticeNumber;
	}

	public void setWareHouseBuildLatticeNumber(String wareHouseBuildLatticeNumber) {
		this.wareHouseBuildLatticeNumber = wareHouseBuildLatticeNumber;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public AmCoBox getAmCoBox() {
		return amCoBox;
	}

	public void setAmCoBox(AmCoBox amCoBox) {
		this.amCoBox = amCoBox;
	}

	public WareHouseStorage getWareHouseStorage() {
		return wareHouseStorage;
	}

	public void setWareHouseStorage(WareHouseStorage wareHouseStorage) {
		this.wareHouseStorage = wareHouseStorage;
	}

	@Override
	public String toString() {
		return "WareHouseBuild [wareHouseBuildId=" + wareHouseBuildId + ", wareHouseBuildNumber=" + wareHouseBuildNumber
				+ ", wareHouseBuildName=" + wareHouseBuildName + ", wareHouseBuildLong=" + wareHouseBuildLong
				+ ", wareHouseBuildWidth=" + wareHouseBuildWidth + ", wareHouseBuildHigh=" + wareHouseBuildHigh
				+ ", wareHouseBuildArea=" + wareHouseBuildArea + ", wareHouseBuildVolume=" + wareHouseBuildVolume
				+ ", wareHouseBuildDoor=" + wareHouseBuildDoor + ", wareHouseBuildWindow=" + wareHouseBuildWindow
				+ ", wareHouseBuildTemperature=" + wareHouseBuildTemperature + ", wareHouseBuildHumidity="
				+ wareHouseBuildHumidity + ", wareHouseBuildShelvesNum=" + wareHouseBuildShelvesNum
				+ ", wareHouseBuildDirection=" + wareHouseBuildDirection + ", wareHouseBuildNamingDirection="
				+ wareHouseBuildNamingDirection + ", wareHouseBuildShelfNumber=" + wareHouseBuildShelfNumber
				+ ", wareHouseBuildGroupsNum=" + wareHouseBuildGroupsNum + ", wareHouseBuildGroupNameDirect="
				+ wareHouseBuildGroupNameDirect + ", wareHouseBuildGroupNumber=" + wareHouseBuildGroupNumber
				+ ", wareHouseBuildLatticeNum=" + wareHouseBuildLatticeNum + ", wareHouseBuildLattiNameDirect="
				+ wareHouseBuildLattiNameDirect + ", wareHouseBuildLatticeNumber=" + wareHouseBuildLatticeNumber
				+ ", condition=" + condition + ", amCoBox=" + amCoBox + ", wareHouseStorage=" + wareHouseStorage + "]";
	}

}
