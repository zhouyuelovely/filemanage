package filemanage.recorded.vo;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

public class PreparationFormHelp {
	private String qzId;// 全宗主键
	private String pcId;// 一级分类主键
	private String scId;// 二级分类主键
	private String rtId;// 保管期限主键
	private String bpId;// 盒子属性主键
	private String boxId;// 盒子主键
	private String anual;// 年度
	private String bsn;// 起件号
	private String ben;// 止件号
	private String boxNumber;// 盒号
	private String boxPages;// 可装页数
	private String qzNumbar;// 全宗号
	private String imageAddress;// 图片地址
	private String qzName;// 全宗名
	private String bgName;// 保管期限名
	private String scName;// 机构问题分类
	private String bkImage;// 备考表地址

	public PreparationFormHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreparationFormHelp(String qzId, String pcId, String scId, String rtId, String bpId, String boxId,
			String anual, String bsn, String ben, String boxNumber, String boxPages, String qzNumbar,
			String imageAddress, String qzName, String bgName, String scName, String bkImage) {
		super();
		this.qzId = qzId;
		this.pcId = pcId;
		this.scId = scId;
		this.rtId = rtId;
		this.bpId = bpId;
		this.boxId = boxId;
		this.anual = anual;
		this.bsn = bsn;
		this.ben = ben;
		this.boxNumber = boxNumber;
		this.boxPages = boxPages;
		this.qzNumbar = qzNumbar;
		this.imageAddress = imageAddress;
		this.qzName = qzName;
		this.bgName = bgName;
		this.scName = scName;
		this.bkImage = bkImage;
	}

	public String getQzId() {
		return qzId;
	}

	public void setQzId(String qzId) {
		this.qzId = qzId;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getRtId() {
		return rtId;
	}

	public void setRtId(String rtId) {
		this.rtId = rtId;
	}

	public String getBpId() {
		return bpId;
	}

	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public String getBen() {
		return ben;
	}

	public void setBen(String ben) {
		this.ben = ben;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getBoxPages() {
		return boxPages;
	}

	public void setBoxPages(String boxPages) {
		this.boxPages = boxPages;
	}

	public String getQzNumbar() {
		return qzNumbar;
	}

	public void setQzNumbar(String qzNumbar) {
		this.qzNumbar = qzNumbar;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

	public String getQzName() {
		return qzName;
	}

	public void setQzName(String qzName) {
		this.qzName = qzName;
	}

	public String getBgName() {
		return bgName;
	}

	public void setBgName(String bgName) {
		this.bgName = bgName;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getBkImage() {
		return bkImage;
	}

	public void setBkImage(String bkImage) {
		this.bkImage = bkImage;
	}

	@Override
	public String toString() {
		return "PreparationFormHelp [qzId=" + qzId + ", pcId=" + pcId + ", scId=" + scId + ", rtId=" + rtId + ", bpId="
				+ bpId + ", boxId=" + boxId + ", anual=" + anual + ", bsn=" + bsn + ", ben=" + ben + ", boxNumber="
				+ boxNumber + ", boxPages=" + boxPages + ", qzNumbar=" + qzNumbar + ", imageAddress=" + imageAddress
				+ ", qzName=" + qzName + ", bgName=" + bgName + ", scName=" + scName + ", bkImage=" + bkImage + "]";
	}

}
