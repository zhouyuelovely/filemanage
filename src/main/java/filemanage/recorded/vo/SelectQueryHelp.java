package filemanage.recorded.vo;

/**
 * @author meng 帮助select查询
 */
public class SelectQueryHelp {
	private String pcId;// 一级分类主键
	private String anual;// 年度
	private String start;// 状态

	public SelectQueryHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectQueryHelp(String pcId, String anual, String start) {
		super();
		this.pcId = pcId;
		this.anual = anual;
		this.start = start;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "SelectQueryHelp [pcId=" + pcId + ", anual=" + anual + ", start=" + start + "]";
	}

}
