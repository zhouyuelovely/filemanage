package filemanage.collectandorganize.vo;

/**
 * @author meng 条件下文件的页数和件数
 */
public class ArchiveFileHelpInfor {
	private Integer archiveFileNumber;// 文件数量
	private Integer archiveFilePage;// 文件页数

	public ArchiveFileHelpInfor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchiveFileHelpInfor(Integer archiveFileNumber, Integer archiveFilePage) {
		super();
		this.archiveFileNumber = archiveFileNumber;
		this.archiveFilePage = archiveFilePage;
	}

	@Override
	public String toString() {
		return "ArchiveFileHelpInfor [archiveFileNumber=" + archiveFileNumber + ", archiveFilePage=" + archiveFilePage
				+ "]";
	}

	public Integer getArchiveFileNumber() {
		return archiveFileNumber;
	}

	public void setArchiveFileNumber(Integer archiveFileNumber) {
		this.archiveFileNumber = archiveFileNumber;
	}

	public Integer getArchiveFilePage() {
		return archiveFilePage;
	}

	public void setArchiveFilePage(Integer archiveFilePage) {
		this.archiveFilePage = archiveFilePage;
	}

}
