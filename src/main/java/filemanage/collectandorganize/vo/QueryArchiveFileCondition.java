package filemanage.collectandorganize.vo;

/**
 * @author meng
 *条件查询辅助
 */
public class QueryArchiveFileCondition {
	private String archiveId; //全宗主键
	private String anual; //年度
	private String condition; //条件

	public QueryArchiveFileCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryArchiveFileCondition(String archiveId, String anual, String condition) {
		super();
		this.archiveId = archiveId;
		this.anual = anual;
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "QueryArchiveFileCondition [archiveId=" + archiveId + ", anual=" + anual + ", condition=" + condition
				+ "]";
	}

	public String getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
