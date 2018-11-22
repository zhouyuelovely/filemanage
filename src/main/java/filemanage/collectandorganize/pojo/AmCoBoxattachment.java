package filemanage.collectandorganize.pojo;

import filemanage.systemmanage.pojo.Archive;

/**
 * 档案盒附件
 * @author 陈一达
 *
 */
public class AmCoBoxattachment {
	private String boxattachmentId;//盒附件的主键
	private String boxattachmentBox;//盒面盒脊地址地址
	private String boxattachmentFile;//归档文件目录地址
	private String boxattachmentForm;//备考表地址
	private String boxId;//盒主键
	private String boxYear;//盒年度
	private Archive archive;//全宗类 
	private String retentionperiodid; // 保管期限主键
	
	public AmCoBoxattachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AmCoBoxattachment(String boxattachmentId, String boxattachmentBox, String boxattachmentFile,
			String boxattachmentForm, String boxId, String boxYear, Archive archive, String retentionperiodid) {
		super();
		this.boxattachmentId = boxattachmentId;
		this.boxattachmentBox = boxattachmentBox;
		this.boxattachmentFile = boxattachmentFile;
		this.boxattachmentForm = boxattachmentForm;
		this.boxId = boxId;
		this.boxYear = boxYear;
		this.archive = archive;
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

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}
	
	public String getRetentionperiodid() {
		return retentionperiodid;
	}

	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}

	@Override
	public String toString() {
		return "AmCoBoxattachment [boxattachmentId=" + boxattachmentId + ", boxattachmentBox=" + boxattachmentBox
				+ ", boxattachmentFile=" + boxattachmentFile + ", boxattachmentForm=" + boxattachmentForm + ", boxId="
				+ boxId + ", boxYear=" + boxYear + ", archive=" + archive + ", retentionperiodid=" + retentionperiodid
				+ "]";
	}

}
