package filemanage.recorded.vo;

public class RecodedTableSelect {
	private String selectKey;//select的value
	private String selectValue;//select的test
	public RecodedTableSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecodedTableSelect(String selectKey, String selectValue) {
		super();
		this.selectKey = selectKey;
		this.selectValue = selectValue;
	}
	public String getSelectKey() {
		return selectKey;
	}
	public void setSelectKey(String selectKey) {
		this.selectKey = selectKey;
	}
	public String getSelectValue() {
		return selectValue;
	}
	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}
	@Override
	public String toString() {
		return "RecodedTableSelect [selectKey=" + selectKey + ", selectValue=" + selectValue + "]";
	}
	
	
	
}
