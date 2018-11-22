package filemanage.recorded.vo;

public class RecordedTableCountHelp {
	private Integer boxNum;// 盒子数量
	private Integer fileNum;// 文件数量

	public RecordedTableCountHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordedTableCountHelp(Integer boxNum, Integer fileNum) {
		super();
		this.boxNum = boxNum;
		this.fileNum = fileNum;
	}

	public Integer getBoxNum() {
		return boxNum;
	}

	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}

	public Integer getFileNum() {
		return fileNum;
	}

	public void setFileNum(Integer fileNum) {
		this.fileNum = fileNum;
	}

	@Override
	public String toString() {
		return "RecordedTableCountHelp [boxNum=" + boxNum + ", fileNum=" + fileNum + "]";
	}

}
