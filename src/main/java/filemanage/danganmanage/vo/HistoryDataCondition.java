package filemanage.danganmanage.vo;

public class HistoryDataCondition {
	private String historydataId; //(泰坦数据)-文件主键
	private String quanzongName;//全宗名称
	private String pcName;//一级分类名称
	private String historyAnual;//年度
	private String retentionperiodname;//保管期限名称
	
	public HistoryDataCondition() {
		
	}

	public HistoryDataCondition(String historydataId, String quanzongName, String pcName, String historyAnual,
			String retentionperiodname) {
		super();
		this.historydataId = historydataId;
		this.quanzongName = quanzongName;
		this.pcName = pcName;
		this.historyAnual = historyAnual;
		this.retentionperiodname = retentionperiodname;
	}

	public String getHistorydataId() {
		return historydataId;
	}

	public void setHistorydataId(String historydataId) {
		this.historydataId = historydataId;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getHistoryAnual() {
		return historyAnual;
	}

	public void setHistoryAnual(String historyAnual) {
		this.historyAnual = historyAnual;
	}

	public String getRetentionperiodname() {
		return retentionperiodname;
	}

	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}

	@Override
	public String toString() {
		return "HistoryDataCondition [historydataId=" + historydataId + ", quanzongName=" + quanzongName + ", pcName="
				+ pcName + ", historyAnual=" + historyAnual + ", retentionperiodname=" + retentionperiodname + "]";
	}
	
	
}
