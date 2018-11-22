package filemanage.collectandorganize.vo;

/**
 * @author meng 帮助查询文件的数量
 */
public class QueryArchiveFileStoreHelp {
	private String anual;// 统计全宗的各个年度

	public QueryArchiveFileStoreHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryArchiveFileStoreHelp(String anual) {
		super();
		this.anual = anual;
	}

	@Override
	public String toString() {
		return "QueryArchiveFileStoreHelp [anual=" + anual + "]";
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

}
