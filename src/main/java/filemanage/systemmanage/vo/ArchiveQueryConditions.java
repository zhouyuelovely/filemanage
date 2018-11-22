package filemanage.systemmanage.vo;

public class ArchiveQueryConditions {
	/**
	 * 关键词查询全宗信息（全宗号、全宗名称）
	 */

	private String quanzongId;// 主键
	private String quanzongNumber;// 全宗号
	private String quanzongName;// 全宗名
	private String condition;// 条件

	public ArchiveQueryConditions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchiveQueryConditions(String quanzongId, String quanzongNumber, String quanzongName, String condition) {
		super();
		this.quanzongId = quanzongId;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.condition = condition;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getQuanzongNumber() {
		return quanzongNumber;
	}

	public void setQuanzongNumber(String quanzongNumber) {
		this.quanzongNumber = quanzongNumber;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getConditions() {
		return condition;
	}

	public void setConditions(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "ArchiveQueryConditions [quanzongId=" + quanzongId + ", quanzongNumber=" + quanzongNumber
				+ ", quanzongName=" + quanzongName + ", condition=" + condition + "]";
	}

}
