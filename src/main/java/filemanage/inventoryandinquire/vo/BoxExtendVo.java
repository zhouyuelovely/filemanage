package filemanage.inventoryandinquire.vo;

public class BoxExtendVo {
	private String boxId;//盒子主键
	private String boxAnual;//年度
	private String boxStartNumber; // 起件号
	private String boxEndNumber; // 止件号
	private	String boxNumber;//盒号
	private String boxthickness; //盒厚度
	private String quanzongNumber;//全宗号
	private String quanzongName;//全宗名称
	private String scName;//二级分类名称[问题(机构)分类]
	private String retentionPeriodName;//保管期限名称
	private String storageRacknumber;//架位号
	/*private Archive archive;//全宗类 
	private PrimaryClassFication primaryClassFication;
	private SecondryClassFication secondryClassFication;//二级分类
	private AmMaSmRetentionperiod amMaSmRetentionperiod;//保管期限类
	private WareHouseStorage wareHouseStorage;//入库类*/
	
	public BoxExtendVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxExtendVo(String boxId, String boxAnual, String boxStartNumber, String boxEndNumber, String boxNumber,
			String boxthickness, String quanzongNumber, String quanzongName, String scName, String retentionPeriodName,
			String storageRacknumber) {
		super();
		this.boxId = boxId;
		this.boxAnual = boxAnual;
		this.boxStartNumber = boxStartNumber;
		this.boxEndNumber = boxEndNumber;
		this.boxNumber = boxNumber;
		this.boxthickness = boxthickness;
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.scName = scName;
		this.retentionPeriodName = retentionPeriodName;
		this.storageRacknumber = storageRacknumber;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxAnual() {
		return boxAnual;
	}

	public void setBoxAnual(String boxAnual) {
		this.boxAnual = boxAnual;
	}

	public String getBoxStartNumber() {
		return boxStartNumber;
	}

	public void setBoxStartNumber(String boxStartNumber) {
		this.boxStartNumber = boxStartNumber;
	}

	public String getBoxEndNumber() {
		return boxEndNumber;
	}

	public void setBoxEndNumber(String boxEndNumber) {
		this.boxEndNumber = boxEndNumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getBoxthickness() {
		return boxthickness;
	}

	public void setBoxthickness(String boxthickness) {
		this.boxthickness = boxthickness;
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

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getRetentionPeriodName() {
		return retentionPeriodName;
	}

	public void setRetentionPeriodName(String retentionPeriodName) {
		this.retentionPeriodName = retentionPeriodName;
	}

	public String getStorageRacknumber() {
		return storageRacknumber;
	}

	public void setStorageRacknumber(String storageRacknumber) {
		this.storageRacknumber = storageRacknumber;
	}

	@Override
	public String toString() {
		return "BoxExtendVo [boxId=" + boxId + ", boxAnual=" + boxAnual + ", boxStartNumber=" + boxStartNumber
				+ ", boxEndNumber=" + boxEndNumber + ", boxNumber=" + boxNumber + ", boxthickness=" + boxthickness
				+ ", quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName + ", scName=" + scName
				+ ", retentionPeriodName=" + retentionPeriodName + ", storageRacknumber=" + storageRacknumber + "]";
	}

	
}	
