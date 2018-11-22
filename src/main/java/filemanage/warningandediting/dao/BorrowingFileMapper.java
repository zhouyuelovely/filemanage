package filemanage.warningandediting.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.warningandediting.pojo.BorrowingFile;

@Repository
public interface BorrowingFileMapper {
	/**
	 * 查询所有未归还档案
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<BorrowingFile> queryBorrowingFile(@Param("before") int before, @Param("after") int after) throws Exception;

	/**
	 * 统计未归还档案数量
	 * 
	 * @return
	 */
	Integer countBorrowingFile() throws Exception;

	/**
	 * 预警天数集合用到
	 * 
	 * @return
	 * @throws Exception
	 */
	List<BorrowingFile> queryAllBorrowingFile() throws Exception;

	/**
	 * 根据预警天数查询信息
	 * 
	 * @param before
	 * @param after
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	List<BorrowingFile> queryByEndDate(@Param("before") int before, @Param("after") int after,
			@Param("endDate") String endDate) throws Exception;

	/**
	 * 统计根据预警天数查询信息
	 * 
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	Integer countByEndDate(@Param("endDate") String endDate) throws Exception;
	
	/**
	 * 统计根据预警天数为0的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countByZeroDate() throws Exception;
}
