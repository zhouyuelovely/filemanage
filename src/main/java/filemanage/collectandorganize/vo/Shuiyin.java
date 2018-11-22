package filemanage.collectandorganize.vo;

/**
 * @author tchuanwu 归档章需要涉及的字段属性
 */
public class Shuiyin {
	private String quanzongId;// 全宗号
	private String anual;// 年度
	private String piceNum;// 件号
	private String scName;// 机构/问题
	private String retentionperiodName;// 保管期限名称
	private String pageNum;// 页数
	private String collator;//整理人
	private String finishingTime;//整理时间
	
	
	@Override
	public String toString() {
		return "Shuiyin [quanzongId=" + quanzongId + ", anual=" + anual + ", piceNum=" + piceNum + ", scName=" + scName
				+ ", retentionperiodName=" + retentionperiodName + ", pageNum=" + pageNum + ", collator=" + collator
				+ ", finishingTime=" + finishingTime + "]";
	}
	public Shuiyin() {
		super();
	}
	public Shuiyin(String quanzongId, String anual, String piceNum, String scName, String retentionperiodName,
			String pageNum, String collator, String finishingTime) {
		super();
		this.quanzongId = quanzongId;
		this.anual = anual;
		this.piceNum = piceNum;
		this.scName = scName;
		this.retentionperiodName = retentionperiodName;
		this.pageNum = pageNum;
		this.collator = collator;
		this.finishingTime = finishingTime;
	}
	public String getQuanzongId() {
		return quanzongId;
	}
	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}
	public String getAnual() {
		return anual;
	}
	public void setAnual(String anual) {
		this.anual = anual;
	}
	public String getPiceNum() {
		return piceNum;
	}
	public void setPiceNum(String piceNum) {
		this.piceNum = piceNum;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getRetentionperiodName() {
		return retentionperiodName;
	}
	public void setRetentionperiodName(String retentionperiodName) {
		this.retentionperiodName = retentionperiodName;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getCollator() {
		return collator;
	}
	public void setCollator(String collator) {
		this.collator = collator;
	}
	public String getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(String finishingTime) {
		this.finishingTime = finishingTime;
	}
	
	
	
}
