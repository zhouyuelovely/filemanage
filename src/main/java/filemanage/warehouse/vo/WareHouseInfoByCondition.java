package filemanage.warehouse.vo;

public class WareHouseInfoByCondition {

	private String wareHouseBuildGroupsNum;// 密集架数
	private String wareHouseBuildShelvesNum;// 组数
	private String condition;// 条件

	public WareHouseInfoByCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WareHouseInfoByCondition(String wareHouseBuildGroupsNum, String wareHouseBuildShelvesNum, String condition) {
		super();
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
		this.condition = condition;
	}

	public String getWareHouseBuildGroupsNum() {
		return wareHouseBuildGroupsNum;
	}

	public void setWareHouseBuildGroupsNum(String wareHouseBuildGroupsNum) {
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
	}

	public String getWareHouseBuildShelvesNum() {
		return wareHouseBuildShelvesNum;
	}

	public void setWareHouseBuildShelvesNum(String wareHouseBuildShelvesNum) {
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "WareHouseInfoByCondition [wareHouseBuildGroupsNum=" + wareHouseBuildGroupsNum
				+ ", wareHouseBuildShelvesNum=" + wareHouseBuildShelvesNum + ", condition=" + condition + "]";
	}

}
