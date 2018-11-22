package filemanage.collectandorganize.vo;

public class BoxHavingRetentionperiodHelp {
	private String retentionperiodid;//保管期限主键
	private String retentionperiodname;//保管期限名称

	public BoxHavingRetentionperiodHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxHavingRetentionperiodHelp(String retentionperiodid, String retentionperiodname) {
		super();
		this.retentionperiodid = retentionperiodid;
		this.retentionperiodname = retentionperiodname;
	}

	@Override
	public String toString() {
		return "BoxHavingMiHelp [retentionperiodid=" + retentionperiodid + ", retentionperiodname="
				+ retentionperiodname + "]";
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}

}
