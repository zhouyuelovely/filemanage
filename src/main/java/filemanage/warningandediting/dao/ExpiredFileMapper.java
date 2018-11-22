package filemanage.warningandediting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.warningandediting.pojo.ExpiredFile;

@Repository
public interface ExpiredFileMapper {

	/**
	 * 查询所有到期档案
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryAllExpiredFile(@Param("before") int before, @Param("after") int after) throws Exception;

	/**
	 * 统计到期档案数量
	 * 
	 * @return
	 */
	Integer countExpiredFile() throws Exception;

	/**
	 * 查询所有全宗名
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryAllQzName() throws Exception;

	/**
	 * 用于预警天数的跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryExpiredFile() throws Exception;

	/**
	 * 根据全宗名查看文件
	 * 
	 * @param before
	 * @param after
	 * @param qzName
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryFileByQzName(@Param("before") int before, @Param("after") int after,
			@Param("qzName") String qzName) throws Exception;

	/**
	 * 统计根据全宗名查看文件
	 * 
	 * @return
	 * @throws Exception
	 */
	int countFileByQzName(@Param("qzName") String qzName) throws Exception;
	
	/**
	 * 根据预警天数查看文件
	 * 
	 * @param before
	 * @param after
	 * @param saveDays
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryFileBySurplusDays(@Param("before") int before, @Param("after") int after,
			@Param("saveDays") String saveDays) throws Exception;
	
	/**
	 * 统计根据预警天数查看文件
	 * 
	 * @return
	 * @throws Exception
	 */
	int countFileBySurplusDays(@Param("saveDays") String fileCreateDate) throws Exception;
}
