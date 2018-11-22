package filemanage.collectandorganize.vo;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

/**
 * @author meng 送审条件查询
 */
public class BoxByCondition {
	private String archiveId;// 全宗主键
	private String anual;// 年度
	private String codition;// 条件

	public BoxByCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxByCondition(String archiveId, String anual, String codition) {
		super();
		this.archiveId = archiveId;
		this.anual = anual;
		this.codition = codition;
	}

	@Override
	public String toString() {
		return "BoxByCondition [archiveId=" + archiveId + ", anual=" + anual + ", codition=" + codition + "]";
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

	public String getCodition() {
		return codition;
	}

	public void setCodition(String codition) {
		this.codition = codition;
	}

}
