package filemanage.statistics.pojo;

/**
 * 报表统计
 * 
 * @author Administrator
 *
 */
public class AmCoBoxReport {
	private String pcname; // 档案类型
	private Integer countnum; // 盒数量
	private String quanzongid; // 全宗id
	private String quanzongname; // 全宗名称
	private String anual; // 年份
	private Integer sumnum; // 件总数

	private Integer borrowingnum; // 每种档案类型的借阅数
	private Integer borrowingcount; // 总借阅数
	private String borrowProportion;// 借阅占比

	private Integer rejectnum; // 驳回次数
	private Integer rejectCount; // 驳回总次数
	private String rejectProprotion;// 质量比

	public String getRejectProprotion() {
		return rejectProprotion;
	}

	public void setRejectProprotion(String rejectProprotion) {
		this.rejectProprotion = rejectProprotion;
	}

	public String getBorrowProportion() {
		return borrowProportion;
	}

	public void setBorrowProportion(String borrowProportion) {
		this.borrowProportion = borrowProportion;
	}

	public Integer getRejectnum() {
		return rejectnum;
	}

	public void setRejectnum(Integer rejectnum) {
		this.rejectnum = rejectnum;
	}

	public Integer getRejectCount() {
		return rejectCount;
	}

	public void setRejectCount(Integer rejectCount) {
		this.rejectCount = rejectCount;
	}

	public Integer getBorrowingnum() {
		return borrowingnum;
	}

	public void setBorrowingnum(Integer borrowingnum) {
		this.borrowingnum = borrowingnum;
	}

	public Integer getBorrowingcount() {
		return borrowingcount;
	}

	public void setBorrowingcount(Integer borrowingcount) {
		this.borrowingcount = borrowingcount;
	}

	public Integer getSumnum() {
		return sumnum;
	}

	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public Integer getCountnum() {
		return countnum;
	}

	public void setCountnum(Integer countnum) {
		this.countnum = countnum;
	}

	public String getQuanzongid() {
		return quanzongid;
	}

	public void setQuanzongid(String quanzongid) {
		this.quanzongid = quanzongid;
	}

	public String getQuanzongname() {
		return quanzongname;
	}

	public void setQuanzongname(String quanzongname) {
		this.quanzongname = quanzongname;
	}

	public AmCoBoxReport(String pcname, Integer countnum, String quanzongid, String quanzongname) {
		super();
		this.pcname = pcname;
		this.countnum = countnum;
		this.quanzongid = quanzongid;
		this.quanzongname = quanzongname;
	}

	public AmCoBoxReport() {
		super();
	}

	@Override
	public String toString() {
		return "AmCoBoxReport [档案类型=" + pcname + ", 盒数量=" + countnum + ", 全宗id=" + quanzongid + ", 全宗名称=" + quanzongname
				+ "], 年份=" + anual + "], 件总数=" + sumnum + ", 借阅数=" + borrowingnum + ", 借阅总数=" + borrowingcount
				+ ", 借阅占比=" + borrowProportion + ", 驳回次数=" + rejectnum + ", 驳回总次数=" + rejectCount + ", 驳回质量比="
				+ rejectProprotion + "]";
	}
}
