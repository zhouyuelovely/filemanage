package filemanage.inventoryandinquire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;

@Repository("cascadingMapper")
public interface CascadingMapper {

	/**
	 * 查询一级分类(档案类型)
	 * 
	 * @return
	 */
	List<PrimaryClassFication> getPrimaryClassList() throws Exception;

	/**
	 * 根据一级分类(档案类型)主键查询二级分类(问题、机构)名称集合
	 * 
	 * @param pcId
	 * @return
	 */
	List<SecondryClassFication> getSecondryClassListByPcId(@Param("pcId") String pcId) throws Exception;;

}
