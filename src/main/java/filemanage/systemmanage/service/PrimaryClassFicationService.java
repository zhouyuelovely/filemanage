package filemanage.systemmanage.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.utils.page.PageBean;

/**
 * @author tchuanwu
 * 一级分类业务层接口
 *
 */
public interface PrimaryClassFicationService {
	
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
	
	String selectAllPc();
	
	String queryScByIdAndStatus(String pcDescription);
	/**
	 * 根据全宗id查询二级机构分类
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
	
	PageBean<PrimaryClassFication> queryAllPc(String scStatus,Integer currentPage);
	
	PageBean<PrimaryClassFication> queryAllScByPc(String scStatus,Integer currentPage);
	
	PageBean<PrimaryClassFication> findByPage(Integer currentPage);
	
	PageBean<PrimaryClassFication> findByPage2(Integer currentPage);
	
      Boolean deletePcByPcId(String pcId);
	
	int countPcIdBySc(String pcId);
	
	
	
	
	
	
	
	

}
