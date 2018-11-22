package filemanage.collectandorganize.pojo;

import java.util.Date;

import filemanage.collectandorganize.vo.BoxVo;
import filemanage.systemmanage.pojo.AmCoBox;

/**
 * @author meng 驳回情况信息
 */
public class ReturnInfoBox {
	private String returnInfoId;// 驳回主键
	private String returnInfoReason;// 驳回情况
	private Date returnInfoTime;// 驳回时间
	private String returnInfoPreson;// 驳回人
	private String boxId;
	private BoxVo boxVo;// 盒子主键
	private AmCoBox amCoBox;
	private String boxsericalnumber; // 盒子编号

	public ReturnInfoBox() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnInfoBox(String returnInfoId, String returnInfoReason, Date returnInfoTime, String returnInfoPreson,
			String boxId, BoxVo boxVo, AmCoBox amCoBox, String boxsericalnumber) {
		super();
		this.returnInfoId = returnInfoId;
		this.returnInfoReason = returnInfoReason;
		this.returnInfoTime = returnInfoTime;
		this.returnInfoPreson = returnInfoPreson;
		this.boxId = boxId;
		this.boxVo = boxVo;
		this.amCoBox = amCoBox;
		this.boxsericalnumber = boxsericalnumber;
	}

	public String getReturnInfoId() {
		return returnInfoId;
	}

	public void setReturnInfoId(String returnInfoId) {
		this.returnInfoId = returnInfoId;
	}

	public String getReturnInfoReason() {
		return returnInfoReason;
	}

	public void setReturnInfoReason(String returnInfoReason) {
		this.returnInfoReason = returnInfoReason;
	}

	public Date getReturnInfoTime() {
		return returnInfoTime;
	}

	public void setReturnInfoTime(Date returnInfoTime) {
		this.returnInfoTime = returnInfoTime;
	}

	public String getReturnInfoPreson() {
		return returnInfoPreson;
	}

	public void setReturnInfoPreson(String returnInfoPreson) {
		this.returnInfoPreson = returnInfoPreson;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public BoxVo getBoxVo() {
		return boxVo;
	}

	public void setBoxVo(BoxVo boxVo) {
		this.boxVo = boxVo;
	}

	public AmCoBox getAmCoBox() {
		return amCoBox;
	}

	public void setAmCoBox(AmCoBox amCoBox) {
		this.amCoBox = amCoBox;
	}

	public String getBoxsericalnumber() {
		return boxsericalnumber;
	}

	public void setBoxsericalnumber(String boxsericalnumber) {
		this.boxsericalnumber = boxsericalnumber;
	}

	@Override
	public String toString() {
		return "ReturnInfoBox [returnInfoId=" + returnInfoId + ", returnInfoReason=" + returnInfoReason
				+ ", returnInfoTime=" + returnInfoTime + ", returnInfoPreson=" + returnInfoPreson + ", boxId=" + boxId
				+ ", boxVo=" + boxVo + ", amCoBox=" + amCoBox + ", boxsericalnumber=" + boxsericalnumber + "]";
	}

}
