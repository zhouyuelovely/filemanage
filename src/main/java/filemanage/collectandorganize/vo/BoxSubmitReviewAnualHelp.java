package filemanage.collectandorganize.vo;

/**
 * @author meng 文件送审页面年度的集合
 */
public class BoxSubmitReviewAnualHelp {
	private String anual;// 盒子存在的年度

	public BoxSubmitReviewAnualHelp(String anual) {
		super();
		this.anual = anual;
	}

	public BoxSubmitReviewAnualHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BoxSubmitReviewAnualHelp [anual=" + anual + "]";
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

}
