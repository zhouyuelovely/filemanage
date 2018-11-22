package filemanage.systemmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.PrimaryClassFication;

/**
 * @author tchuanwu
 *  一级分类接口
 */
@Repository
public interface PrimaryClassFicationMapper {
	/**
	 * 查询所有的一级分类
	 * @return
	 */
	List<PrimaryClassFication> queryAllPrimaryClass();
	/**
	 * 添加一级分类
	 * @param primaryClass
	 * @return
	 */
	int addPrimaryClass(PrimaryClassFication primaryClass);
	/**
	 * 按一级分类名pcName查询一级分类是否存在
	 * >=0 存在  <0 不存在
	 * @param primaryClass
	 * @return
	 */
	int isExitPrimaryClassName(PrimaryClassFication primaryClass);
	/**
	 * 按一级分类代码pcCode查询一级分类代码是否存在
	 * >=0 存在  <0 不存在
	 * @param primaryClass
	 * @return
	 */
	int isExitPrimaryClassCode(PrimaryClassFication primaryClass);
	/**
	 * 查询所有的问题分类 
	 * @return
	 */
	List<PrimaryClassFication> selectAllPc();
	/**
	 * 遍历文书档案下的机构数据，调取的是机构表里的数据
	 * @return
	 */
	List<PrimaryClassFication> queryScByIdAndStatus(String pcDescription);
	/**
	 * 根据全宗id查询机构的二级分类
	 * @param quanzongid
	 * @return
	 */
	List<PrimaryClassFication> queryScByOrg(@Param("quanzongid")String quanzongid);
	/**
	 * 遍历所有的文书档案
	 * @return
	 */
	List<PrimaryClassFication> queryAllPcById();
	/**
	 * 统计所有的一级分类
	 * @return
	 */
	Integer countAllPc();
	
	List<PrimaryClassFication> queryAllScByPc(Map<String, Object> map);
	
	List<PrimaryClassFication> queryAllPc(Map<String, Object> map);
	
	Integer countPcByStatus(String scStatus);
	
	Boolean deletePcByPcId(String pcId);
	
	int countPcIdBySc(String pcId);
	
	
	
	
	
	

}
