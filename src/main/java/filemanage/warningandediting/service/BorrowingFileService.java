package filemanage.warningandediting.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.warningandediting.pojo.BorrowingFile;

public interface BorrowingFileService {
	/**
	 * 查询所有未归还档案
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<BorrowingFile> queryBorrowingFile(int before, int after) throws Exception;

	/**
	 * 统计未归还档案数量
	 * 
	 * @return
	 * @throws Exception
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
	List<BorrowingFile> queryByEndDate(int before, int after, String endDate) throws Exception;//

	/**
	 * 统计根据预警天数查询信息
	 * 
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	Integer countByEndDate(String endDate) throws Exception;
	
	/**
	 * 统计根据预警天数为0的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countByZeroDate() throws Exception;
}
