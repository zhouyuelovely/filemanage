package filemanage.collectandorganize.vo;

/**
 * @author meng 提交审核条件
 */
public class BoxSubmitReview {
	private String retentionperioId;// 保管期限主键
	private String anual;// 年度
	private String archiveId;// 全宗主键

	public BoxSubmitReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxSubmitReview(String retentionperioId, String anual, String archiveId) {
		super();
		this.retentionperioId = retentionperioId;
		this.anual = anual;
		this.archiveId = archiveId;
	}

	@Override
	public String toString() {
		return "BoxSubmitReview [retentionperioId=" + retentionperioId + ", anual=" + anual + ", archiveId=" + archiveId
				+ "]";
	}

	public String getRetentionperioId() {
		return retentionperioId;
	}

	public void setRetentionperioId(String retentionperioId) {
		this.retentionperioId = retentionperioId;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}

}
