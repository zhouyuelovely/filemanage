package filemanage.fileBorrowing.vo;

/**
 * 借阅明细以及借阅记录参数对象 （针对前台集合来进行获取）
 * @author 陈一达
 *
 */
public class BorrowDataListSourceVoForm extends BorrowDataListSource{

	//明细/记录参数工具类
	private BorrowDataListSource borrowdatalistsource;

	public BorrowDataListSource getBorrowdatalistsource() {
		return borrowdatalistsource;
	}

	public void setBorrowdatalistsource(BorrowDataListSource borrowdatalistsource) {
		this.borrowdatalistsource = borrowdatalistsource;
	}
	
}
