package filemanage.danganmanage.vo;
/**
 * @author tchuanwu 档案管理以件管理条件查询
 */
public class QueryFileByCondition {
	private String conditions;// 条件
	
	public QueryFileByCondition() {
		
	}

	public QueryFileByCondition(String conditions) {
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
		return "QueryFileByCondition [conditions=" + conditions + "]";
	}
	
	
	
	

}
