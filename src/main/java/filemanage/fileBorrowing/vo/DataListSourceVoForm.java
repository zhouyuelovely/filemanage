package filemanage.fileBorrowing.vo;

import java.util.List;

public class DataListSourceVoForm extends DataListSource{
	
	private List<DataListSource> borrowDataSource;

	public List<DataListSource> getBorrowDataSource() {
		return borrowDataSource;
	}

	public void setBorrowDataSource(List<DataListSource> borrowDataSource) {
		this.borrowDataSource = borrowDataSource;
	}
	
}
