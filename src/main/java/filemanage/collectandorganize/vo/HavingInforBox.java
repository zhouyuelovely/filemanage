package filemanage.collectandorganize.vo;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

public class HavingInforBox {
	private Integer boxNum;// 盒子数量
	private Integer fileNum;// 文件数量

	public HavingInforBox() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HavingInforBox(Integer boxNum, Integer fileNum) {
		super();
		this.boxNum = boxNum;
		this.fileNum = fileNum;
	}

	@Override
	public String toString() {
		return "HavingInforBox [boxNum=" + boxNum + ", fileNum=" + fileNum + "]";
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
