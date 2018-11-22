package filemanage.collectandorganize.vo;

public class BoxAuditHelp {
	private String quangzongName;// 全宗名称
	private String quanzongId;// 全宗主键
	private String anual;// 年度

	public BoxAuditHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxAuditHelp(String quangzongName, String quanzongId, String anual) {
		super();
		this.quangzongName = quangzongName;
		this.quanzongId = quanzongId;
		this.anual = anual;
	}

	@Override
	public String toString() {
		return "BoxAuditHelp [quangzongName=" + quangzongName + ", quanzongId=" + quanzongId + ", anual=" + anual + "]";
	}

	public String getQuangzongName() {
		return quangzongName;
	}

	public void setQuangzongName(String quangzongName) {
		this.quangzongName = quangzongName;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}
}

