package filemanage.collectandorganize.vo;

/**
 * 获取前台的参数集
 * @author 陈一达
 *
 */
public class AmCoArchiveVo {

	private String afsecurityclassrification;
	private String archivefilecreatetime;
	private String archivefilefilenumber;
	private String archivefilepages;
	private String archivefilereferencenumber;
	private String archivefileremark;
	private String archivefileresponsible;
	private String archivefiletitle;
	private String archivefileid;
	private String collator;											//整理人
	
	
	@Override
	public String toString() {
		return "AmCoArchiveVo [afsecurityclassrification=" + afsecurityclassrification + ", archivefilecreatetime="
				+ archivefilecreatetime + ", archivefilefilenumber=" + archivefilefilenumber + ", archivefilepages="
				+ archivefilepages + ", archivefilereferencenumber=" + archivefilereferencenumber
				+ ", archivefileremark=" + archivefileremark + ", archivefileresponsible=" + archivefileresponsible
				+ ", archivefiletitle=" + archivefiletitle + ", archivefileid=" + archivefileid + ", collator="
				+ collator + "]";
	}
	public AmCoArchiveVo(String afsecurityclassrification, String archivefilecreatetime, String archivefilefilenumber,
			String archivefilepages, String archivefilereferencenumber, String archivefileremark,
			String archivefileresponsible, String archivefiletitle, String archivefileid, String collator) {
		super();
		this.afsecurityclassrification = afsecurityclassrification;
		this.archivefilecreatetime = archivefilecreatetime;
		this.archivefilefilenumber = archivefilefilenumber;
		this.archivefilepages = archivefilepages;
		this.archivefilereferencenumber = archivefilereferencenumber;
		this.archivefileremark = archivefileremark;
		this.archivefileresponsible = archivefileresponsible;
		this.archivefiletitle = archivefiletitle;
		this.archivefileid = archivefileid;
		this.collator = collator;
	}
	public AmCoArchiveVo() {
		super();
	}
	public String getAfsecurityclassrification() {
		return afsecurityclassrification;
	}
	public void setAfsecurityclassrification(String afsecurityclassrification) {
		this.afsecurityclassrification = afsecurityclassrification;
	}
	public String getArchivefilecreatetime() {
		return archivefilecreatetime;
	}
	public void setArchivefilecreatetime(String archivefilecreatetime) {
		this.archivefilecreatetime = archivefilecreatetime;
	}
	public String getArchivefilefilenumber() {
		return archivefilefilenumber;
	}
	public void setArchivefilefilenumber(String archivefilefilenumber) {
		this.archivefilefilenumber = archivefilefilenumber;
	}
	public String getArchivefilepages() {
		return archivefilepages;
	}
	public void setArchivefilepages(String archivefilepages) {
		this.archivefilepages = archivefilepages;
	}
	public String getArchivefilereferencenumber() {
		return archivefilereferencenumber;
	}
	public void setArchivefilereferencenumber(String archivefilereferencenumber) {
		this.archivefilereferencenumber = archivefilereferencenumber;
	}
	public String getArchivefileremark() {
		return archivefileremark;
	}
	public void setArchivefileremark(String archivefileremark) {
		this.archivefileremark = archivefileremark;
	}
	public String getArchivefileresponsible() {
		return archivefileresponsible;
	}
	public void setArchivefileresponsible(String archivefileresponsible) {
		this.archivefileresponsible = archivefileresponsible;
	}
	public String getArchivefiletitle() {
		return archivefiletitle;
	}
	public void setArchivefiletitle(String archivefiletitle) {
		this.archivefiletitle = archivefiletitle;
	}
	public String getArchivefileid() {
		return archivefileid;
	}
	public void setArchivefileid(String archivefileid) {
		this.archivefileid = archivefileid;
	}
	public String getCollator() {
		return collator;
	}
	public void setCollator(String collator) {
		this.collator = collator;
	}
	
	
}
