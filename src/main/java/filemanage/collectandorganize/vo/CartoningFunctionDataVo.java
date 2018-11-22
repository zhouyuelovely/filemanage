package filemanage.collectandorganize.vo;

import java.util.List;

/**
 * 装盒参数的对象
 * @author 陈一达
 *
 */
public class CartoningFunctionDataVo {
	
	private String boxid;
	private String boxProperties;						
	private String boxsituation;						//盒子说明
	private String boxcasesnumber;						
	private String quanzongId;							//全宗ID
	private String archivefileanual;					//文件年度
	private String retentionperiodid;					//保管期限ID
	private String retentionperiodidName;				//保管期限名称
	private String secondaryclassificationid;			//二级分类ID
	private String secondaryclassificationidName;		//二级分类名称
	private String boxstartnumber;						//起件号
	private String boxendnumber;						//止件号
	private String archivefileids;						//潜在bug字段
	private String quanzongName;						//全宗名称
	private List<AmCoArchiveVo> excelList;
	
	
	@Override
	public String toString() {
		return "CartoningFunctionDataVo [boxid=" + boxid + ", boxProperties=" + boxProperties + ", boxsituation="
				+ boxsituation + ", boxcasesnumber=" + boxcasesnumber + ", quanzongId=" + quanzongId
				+ ", archivefileanual=" + archivefileanual + ", retentionperiodid=" + retentionperiodid
				+ ", retentionperiodidName=" + retentionperiodidName + ", secondaryclassificationid="
				+ secondaryclassificationid + ", secondaryclassificationidName=" + secondaryclassificationidName
				+ ", boxstartnumber=" + boxstartnumber + ", boxendnumber=" + boxendnumber + ", archivefileids="
				+ archivefileids + ", quanzongName=" + quanzongName + ", excelList=" + excelList + "]";
	}
	public CartoningFunctionDataVo() {
		super();
	}
	public CartoningFunctionDataVo(String boxid, String boxProperties, String boxsituation, String boxcasesnumber,
			String quanzongId, String archivefileanual, String retentionperiodid, String retentionperiodidName,
			String secondaryclassificationid, String secondaryclassificationidName, String boxstartnumber,
			String boxendnumber, String archivefileids, String quanzongName, List<AmCoArchiveVo> excelList) {
		super();
		this.boxid = boxid;
		this.boxProperties = boxProperties;
		this.boxsituation = boxsituation;
		this.boxcasesnumber = boxcasesnumber;
		this.quanzongId = quanzongId;
		this.archivefileanual = archivefileanual;
		this.retentionperiodid = retentionperiodid;
		this.retentionperiodidName = retentionperiodidName;
		this.secondaryclassificationid = secondaryclassificationid;
		this.secondaryclassificationidName = secondaryclassificationidName;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.archivefileids = archivefileids;
		this.quanzongName = quanzongName;
		this.excelList = excelList;
	}
	public String getBoxid() {
		return boxid;
	}
	public void setBoxid(String boxid) {
		this.boxid = boxid;
	}
	public String getBoxProperties() {
		return boxProperties;
	}
	public void setBoxProperties(String boxProperties) {
		this.boxProperties = boxProperties;
	}
	public String getBoxsituation() {
		return boxsituation;
	}
	public void setBoxsituation(String boxsituation) {
		this.boxsituation = boxsituation;
	}
	public String getBoxcasesnumber() {
		return boxcasesnumber;
	}
	public void setBoxcasesnumber(String boxcasesnumber) {
		this.boxcasesnumber = boxcasesnumber;
	}
	public String getQuanzongId() {
		return quanzongId;
	}
	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}
	public String getArchivefileanual() {
		return archivefileanual;
	}
	public void setArchivefileanual(String archivefileanual) {
		this.archivefileanual = archivefileanual;
	}
	public String getRetentionperiodid() {
		return retentionperiodid;
	}
	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}
	public String getRetentionperiodidName() {
		return retentionperiodidName;
	}
	public void setRetentionperiodidName(String retentionperiodidName) {
		this.retentionperiodidName = retentionperiodidName;
	}
	public String getSecondaryclassificationid() {
		return secondaryclassificationid;
	}
	public void setSecondaryclassificationid(String secondaryclassificationid) {
		this.secondaryclassificationid = secondaryclassificationid;
	}
	public String getSecondaryclassificationidName() {
		return secondaryclassificationidName;
	}
	public void setSecondaryclassificationidName(String secondaryclassificationidName) {
		this.secondaryclassificationidName = secondaryclassificationidName;
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
	public String getArchivefileids() {
		return archivefileids;
	}
	public void setArchivefileids(String archivefileids) {
		this.archivefileids = archivefileids;
	}
	public String getQuanzongName() {
		return quanzongName;
	}
	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}
	public List<AmCoArchiveVo> getExcelList() {
		return excelList;
	}
	public void setExcelList(List<AmCoArchiveVo> excelList) {
		this.excelList = excelList;
	}
	
	
	
		
}
