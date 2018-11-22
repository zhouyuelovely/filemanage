package filemanage.inventoryandinquire.service;

import java.util.List;

import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;

public interface CascadingService {
	/**
	 * 查询一级分类(档案类型)
	 * 
	 * @return
	 * @throws Exception
	 */
	List<PrimaryClassFication> getPrimaryClassList() throws Exception;
	
	/**
	 * 根据一级分类主键查询二级分类
	 * @param pcId
	 * @return
	 * @throws Exception
	 */
	List<SecondryClassFication> getSecondryClassListByPcId(String pcId)throws Exception;
	
}
