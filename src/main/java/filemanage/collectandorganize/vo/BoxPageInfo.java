
package filemanage.collectandorganize.vo;

public class BoxPageInfo {
	private Integer boxNum;
	private Integer fileNum;

	public BoxPageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxPageInfo(Integer boxNum, Integer fileNum) {
		super();
		this.boxNum = boxNum;
		this.fileNum = fileNum;
	}

	@Override
	public String toString() {
		return "BoxPageInfo [boxNum=" + boxNum + ", fileNum=" + fileNum + "]";
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
}

