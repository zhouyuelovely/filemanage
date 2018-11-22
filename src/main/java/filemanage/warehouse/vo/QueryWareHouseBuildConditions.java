package filemanage.warehouse.vo;

public class QueryWareHouseBuildConditions {

	private String wareHouseBuildId;// 主键
	private String wareHouseBuildNumber;// 库房号
	private String wareHouseBuildName;// 库房名称
	private String wareHouseBuildShelvesNum;// 密集架数目
	private String wareHouseBuildGroupsNum;// 每个密集架的组数
	private String wareHouseBuildLatticeNum;// 每组格子数
	private String wareHouseBuildTemperature;// 温度
	private String wareHouseBuildHumidity;// 湿度
	private String condition;// 条件

	public QueryWareHouseBuildConditions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryWareHouseBuildConditions(String wareHouseBuildId, String wareHouseBuildNumber,
			String wareHouseBuildName, String wareHouseBuildShelvesNum, String wareHouseBuildGroupsNum,
			String wareHouseBuildLatticeNum, String wareHouseBuildTemperature, String wareHouseBuildHumidity,
			String condition) {
		super();
		this.wareHouseBuildId = wareHouseBuildId;
		this.wareHouseBuildNumber = wareHouseBuildNumber;
		this.wareHouseBuildName = wareHouseBuildName;
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
		this.wareHouseBuildLatticeNum = wareHouseBuildLatticeNum;
		this.wareHouseBuildTemperature = wareHouseBuildTemperature;
		this.wareHouseBuildHumidity = wareHouseBuildHumidity;
		this.condition = condition;
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

	public String getWareHouseBuildShelvesNum() {
		return wareHouseBuildShelvesNum;
	}

	public void setWareHouseBuildShelvesNum(String wareHouseBuildShelvesNum) {
		this.wareHouseBuildShelvesNum = wareHouseBuildShelvesNum;
	}

	public String getWareHouseBuildGroupsNum() {
		return wareHouseBuildGroupsNum;
	}

	public void setWareHouseBuildGroupsNum(String wareHouseBuildGroupsNum) {
		this.wareHouseBuildGroupsNum = wareHouseBuildGroupsNum;
	}

	public String getWareHouseBuildLatticeNum() {
		return wareHouseBuildLatticeNum;
	}

	public void setWareHouseBuildLatticeNum(String wareHouseBuildLatticeNum) {
		this.wareHouseBuildLatticeNum = wareHouseBuildLatticeNum;
	}

	public String getWareHouseBuildTemperature() {
		return wareHouseBuildTemperature;
	}

	public void setWareHouseBuildTtemperature(String wareHouseBuildTtemperature) {
		this.wareHouseBuildTemperature = wareHouseBuildTtemperature;
	}

	public String getWareHouseBuildHumidity() {
		return wareHouseBuildHumidity;
	}

	public void setWareHouseBuildHumidity(String wareHouseBuildHumidity) {
		this.wareHouseBuildHumidity = wareHouseBuildHumidity;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "QueryWareHouseBuildConditions [wareHouseBuildId=" + wareHouseBuildId + ", wareHouseBuildNumber="
				+ wareHouseBuildNumber + ", wareHouseBuildName=" + wareHouseBuildName + ", wareHouseBuildShelvesNum="
				+ wareHouseBuildShelvesNum + ", wareHouseBuildGroupsNum=" + wareHouseBuildGroupsNum
				+ ", wareHouseBuildLatticeNum=" + wareHouseBuildLatticeNum + ", wareHouseBuildTemperature="
				+ wareHouseBuildTemperature + ", wareHouseBuildHumidity=" + wareHouseBuildHumidity + ", condition="
				+ condition + "]";
	}

}
