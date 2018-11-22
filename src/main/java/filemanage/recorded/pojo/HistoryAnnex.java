package filemanage.recorded.pojo;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 历史数据附件表
 * 
 * @author 陈一达
 *
 */
public class HistoryAnnex {

	private String historyannexId; // 历史数据附件主键
	private String historyannexPath; // 地址
	private String historyannexName; // 名字
	private String historydataId; // 历史数据主键

	public HistoryAnnex() {
		super();
	}

	public HistoryAnnex(String historyannexId, String historyannexPath, String historyannexName, String historydataId) {
		super();
		this.historyannexId = historyannexId;
		this.historyannexPath = historyannexPath;
		this.historyannexName = historyannexName;
		this.historydataId = historydataId;
	}

	public String getHistoryannexId() {
		return historyannexId;
	}

	public void setHistoryannexId(String historyannexId) {
		this.historyannexId = historyannexId;
	}

	public String getHistoryannexPath() {
		return historyannexPath;
	}

	public void setHistoryannexPath(String historyannexPath) {
		this.historyannexPath = historyannexPath;
	}

	public String getHistoryannexName() {
		return historyannexName;
	}

	public void setHistoryannexName(String historyannexName) {
		this.historyannexName = historyannexName;
	}

	public String getHistorydataId() {
		return historydataId;
	}

	public void setHistorydataId(String historydataId) {
		this.historydataId = historydataId;
	}

	@Override
	public String toString() {
		return "HistoryAnnex [historyannexId=" + historyannexId + ", historyannexPath=" + historyannexPath
				+ ", historyannexName=" + historyannexName + ", historydataId=" + historydataId + "]";
	}

}
