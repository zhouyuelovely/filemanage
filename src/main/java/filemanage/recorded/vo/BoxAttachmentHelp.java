package filemanage.recorded.vo;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

public class BoxAttachmentHelp {
	private String boxattachmentId;// 盒附件的主键
	private String boxattachmentBox;// 盒面盒脊地址地址
	private String boxattachmentFile;// 归档文件目录地址
	private String boxattachmentForm;// 备考表地址
	private String boxId;// 盒主键
	private String boxYear;// 盒年度
	private String quanzongId;// 全宗主键
	private String retentionperiodid; // 保管期限主键

	public BoxAttachmentHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxAttachmentHelp(String boxattachmentId, String boxattachmentBox, String boxattachmentFile,
			String boxattachmentForm, String boxId, String boxYear, String quanzongId, String retentionperiodid) {
		super();
		this.boxattachmentId = boxattachmentId;
		this.boxattachmentBox = boxattachmentBox;
		this.boxattachmentFile = boxattachmentFile;
		this.boxattachmentForm = boxattachmentForm;
		this.boxId = boxId;
		this.boxYear = boxYear;
		this.quanzongId = quanzongId;
		this.retentionperiodid = retentionperiodid;
	}

	public String getBoxattachmentId() {
		return boxattachmentId;
	}

	public void setBoxattachmentId(String boxattachmentId) {
		this.boxattachmentId = boxattachmentId;
	}

	public String getBoxattachmentBox() {
		return boxattachmentBox;
	}

	public void setBoxattachmentBox(String boxattachmentBox) {
		this.boxattachmentBox = boxattachmentBox;
	}

	public String getBoxattachmentFile() {
		return boxattachmentFile;
	}

	public void setBoxattachmentFile(String boxattachmentFile) {
		this.boxattachmentFile = boxattachmentFile;
	}

	public String getBoxattachmentForm() {
		return boxattachmentForm;
	}

	public void setBoxattachmentForm(String boxattachmentForm) {
		this.boxattachmentForm = boxattachmentForm;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxYear() {
		return boxYear;
	}

	public void setBoxYear(String boxYear) {
		this.boxYear = boxYear;
	}

	public String getQuanzongId() {
		return quanzongId;
	}

	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}

	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	@Override
	public String toString() {
		return "BoxAttachmentHelp [boxattachmentId=" + boxattachmentId + ", boxattachmentBox=" + boxattachmentBox
				+ ", boxattachmentFile=" + boxattachmentFile + ", boxattachmentForm=" + boxattachmentForm + ", boxId="
				+ boxId + ", boxYear=" + boxYear + ", quanzongId=" + quanzongId + ", retentionperiodid="
				+ retentionperiodid + "]";
	}

}
