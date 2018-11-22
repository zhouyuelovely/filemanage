package filemanage.systemmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.SecondryClassFication;

/**
 * @author tchuanwu
 * 二级分类接口
 */
@Repository
public interface SecondryClassFicationMapper {
	
	/**
	 * 根据一级分类主键和二级分类状态查询所有的二级分类
	 * @param pcId
	 * @param scStatus
	 * @return
	 */
	List<SecondryClassFication> queryAllSecondry(@Param("pcId") String pcId,@Param("scStatus") String scStatus,@Param("quanzongid") String quanzongid);
	/**
	 * 根据一级分类主键查询二级分类
	 * @param pcId
	 * @return
	 */
	List<SecondryClassFication> querySecondryByPcId(String pcId);
	/**
	 * 添加二级分类
	 * @param secondry
	 * @return
	 */
	int addSecondryClass(SecondryClassFication secondry);
	/**
	 * 按二级分类名scName查询二级分类是否存在
	 * >=0 存在  <0 不存在
	 * @param secondry
	 * @return
	 */
	int isExitSecondryClassName(SecondryClassFication secondry);
	
	/**
	 * 按二级分类代码scCode查询二级分类是否存在
	 * >=0 存在  <0 不存在
	 * @param secondry
	 * @return
	 */
	int isExitSecondryClassCode(SecondryClassFication secondry);
	/**
	 * 根据二级分类主键删除二级分类
	 * @param scId
	 * @return
	 */
	int delSecondryClassById(String scId);
	/**
	 * 根据二级分类主键查询文件表里是否有二级分类存在
	 * @param scId
	 * @return
	 */
	int countArchiveFileByScId(String scId);
	/**
	 * 查询所有的二级分类
	 * @return
	 */
	List<SecondryClassFication> queryAllSc();
	
	
	
	
	

}
