package filemanage.fileBorrowing.vo;

import java.util.List;

/**
 * 借阅明细获取前台的对象参数
 * @author 陈一达
 *
 */
public class BorrowDataSourceVoForm extends BorrowDataSource{
	//借阅明细集合	
	private List<BorrowDataSource> BorrowDataSourceList;

	public List<BorrowDataSource> getBorrowDataSourceList() {
		return BorrowDataSourceList;
	}

	public void setBorrowDataSourceList(List<BorrowDataSource> borrowDataSourceList) {
		BorrowDataSourceList = borrowDataSourceList;
	}
	
	
}
