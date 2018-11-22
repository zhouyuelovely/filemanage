package filemanage.recorded.vo;

/**
 * @author meng 页面选择内容
 */
public class ConditionHelp {
	private String condition;// 接收条件
	private String id;// 条件主键

	public ConditionHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConditionHelp(String condition, String id) {
		super();
		this.condition = condition;
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConditionHelp [condition=" + condition + ", id=" + id + "]";
	}

}
