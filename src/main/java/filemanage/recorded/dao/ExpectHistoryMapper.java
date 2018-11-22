package filemanage.recorded.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import filemanage.recorded.vo.ExportHistoryHelp;

@Repository
public interface ExpectHistoryMapper {
	/**
	 * 获取新建文件集合
	 * @param ids 文件主键的集合
	 * @return
	 */
	List<ExportHistoryHelp> queryFile(String[] ids);
	/**
	 * 获取历史数据集合
	 * @param ids 文件主键集合
	 * @return
	 */
	List<ExportHistoryHelp> queryHistory(String[] ids);
	/**
	 * 获取新建文件附件地址
	 * @param fileId 文件主键
	 * @return
	 */
	List<String> findFile(String fileId);
	/**
	 * 获取历史数据附件的地址
	 * @param fileId 文件的主键
	 * @return
	 */
	List<String> findHistory(String fileId);
}
