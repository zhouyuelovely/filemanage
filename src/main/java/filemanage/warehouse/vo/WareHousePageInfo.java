package filemanage.warehouse.vo;

public class WareHousePageInfo {

	private Integer boxsNum;// 档案入库页面显示的全部档案盒数
	private Integer archiveFilesNum;// 档案入库页面显示的全部档案盒内的文件数
	private Integer wareHouseNum;// 库房数

	public WareHousePageInfo() {
		super();
	}

	public WareHousePageInfo(Integer boxsNum, Integer archiveFilesNum, Integer wareHouseNum) {
		super();
		this.boxsNum = boxsNum;
		this.archiveFilesNum = archiveFilesNum;
		this.wareHouseNum = wareHouseNum;
	}

	public Integer getBoxsNum() {
		return boxsNum;
	}

	public void setBoxsNum(Integer boxsNum) {
		this.boxsNum = boxsNum;
	}

	public Integer getArchiveFilesNum() {
		return archiveFilesNum;
	}

	public void setArchiveFilesNum(Integer archiveFilesNum) {
		this.archiveFilesNum = archiveFilesNum;
	}

	public Integer getWareHouseNum() {
		return wareHouseNum;
	}

	public void setWareHouseNum(Integer wareHouseNum) {
		this.wareHouseNum = wareHouseNum;
	}

	@Override
	public String toString() {
		return "WareHousePageInfo [boxsNum=" + boxsNum + ", archiveFilesNum=" + archiveFilesNum + ", wareHouseNum="
				+ wareHouseNum + "]";
	}

}
