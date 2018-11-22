package filemanage.recorded.vo;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @author meng 归档文件目录的相关信息
 */
public class TableContentInfor {
	private String quanzongId;// 全宗主键
	private String pcId;// 一级分类主键
	private String scId;// 二级分类主键
	private String retentionperiodid;// 保管期限主键
	private String anual;//年度
	private String boxstartnumber; // 起件号
	private String boxendnumber; // 止件号
	private String boxId;// 盒子主键

	public TableContentInfor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TableContentInfor(String quanzongId, String pcId, String scId, String retentionperiodid, String anual,
			String boxstartnumber, String boxendnumber, String boxId) {
		super();
		this.quanzongId = quanzongId;
		this.pcId = pcId;
		this.scId = scId;
		this.retentionperiodid = retentionperiodid;
		this.anual = anual;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.boxId = boxId;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
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

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getBoxstartnumber() {
		return boxstartnumber;
	}

	public void setBoxstartnumber(String boxstartnumber) {
		this.boxstartnumber = boxstartnumber;
	}

	public String getBoxendnumber() {
		return boxendnumber;
	}

	public void setBoxendnumber(String boxendnumber) {
		this.boxendnumber = boxendnumber;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	@Override
	public String toString() {
		return "TableContentInfor [quanzongId=" + quanzongId + ", pcId=" + pcId + ", scId=" + scId
				+ ", retentionperiodid=" + retentionperiodid + ", anual=" + anual + ", boxstartnumber=" + boxstartnumber
				+ ", boxendnumber=" + boxendnumber + ", boxId=" + boxId + "]";
	}

}
