package filemanage.warningandediting.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.warningandediting.pojo.ExpiredFile;

public interface ExpiredFileService {

	/**
	 * 查询所有到期档案
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryAllExpiredFile(int before, int after) throws Exception;

	/**
	 * 统计到期档案数量
	 * 
	 * @return
	 * @throws Exception
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
	List<ExpiredFile> queryFileByQzName(int before, int after, String qzName) throws Exception;

	/**
	 * 统计根据全宗名查看文件
	 * 
	 * @return
	 * @throws Exception
	 */
	int countFileByQzName(String qzName) throws Exception;

	/**
	 * 根据预警天数查看文件
	 * 
	 * @param before
	 * @param after
	 * @param fileCreateDate
	 * @return
	 * @throws Exception
	 */
	List<ExpiredFile> queryFileBySurplusDays(int before, int after, String saveDays) throws Exception;

	/**
	 * 统计根据预警天数查看文件
	 * 
	 * @return
	 * @throws Exception
	 */
	int countFileBySurplusDays(String saveDays) throws Exception;
}
