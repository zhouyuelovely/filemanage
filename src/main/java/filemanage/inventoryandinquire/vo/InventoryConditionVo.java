package filemanage.inventoryandinquire.vo;

public class InventoryConditionVo {
	private String boxId;
	private String quanzongName;//全宗名称
	private String boxAnual;//盒年度
	private String pcName;//一级分类(档案类型)
	private String retentionperiodname;//保管期限名称
	
	public InventoryConditionVo() {
		super();
	}
	
	public InventoryConditionVo(String boxId, String quanzongName, String boxAnual, String pcName,
			String retentionperiodname) {
		super();
		this.boxId = boxId;
		this.quanzongName = quanzongName;
		this.boxAnual = boxAnual;
		this.pcName = pcName;
		this.retentionperiodname = retentionperiodname;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getBoxAnual() {
		return boxAnual;
	}

	public void setBoxAnual(String boxAnual) {
		this.boxAnual = boxAnual;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}
	
	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	@Override
	public String toString() {
		return "InventoryConditionVo [boxId=" + boxId + ", quanzongName=" + quanzongName + ", boxAnual=" + boxAnual
				+ ", pcName=" + pcName + ", retentionperiodname=" + retentionperiodname + "]";
	}

}
