package filemanage.danganmanage.vo;

/**
 * @author tchuanwu 档案管理以盒管理条件查询
 */
public class QueryBoxByCondition {
	private String conditions;// 条件

	public QueryBoxByCondition() {
		
	}

	public QueryBoxByCondition(String conditions) {
		super();
		this.conditions = conditions;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "QueryBoxByCondition [conditions=" + conditions + "]";
	}

	

}
