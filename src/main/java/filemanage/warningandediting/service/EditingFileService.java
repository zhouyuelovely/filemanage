package filemanage.warningandediting.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.warningandediting.pojo.EditingFile;

public interface EditingFileService {
	/**
	 * 查询所有编研文件
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFile(int before, int after) throws Exception;

	/**
	 * 统计编研文件数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countEditingFile() throws Exception;

	/**
	 * 查看边沿内容
	 * 
	 * @param editingId
	 * @return
	 * @throws Exception
	 */
	EditingFile queryEditingFileBody(String editingId) throws Exception;

	/**
	 * 查询所有编研类型
	 * 
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileType() throws Exception;

	/**
	 * 查询所有编研日期
	 * 
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileDate() throws Exception;

	/**
	 * 搜索框模糊查询
	 * 
	 * @param before
	 * @param after
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> fuzzyEditingFile(int before, int after, String searchBody) throws Exception;

	/**
	 * 统计模糊查询条数
	 * 
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	Integer countFuzzyEditingFile(String searchBody) throws Exception;

	/**
	 * 下拉查看文件
	 * 
	 * @param before
	 * @param after
	 * @param editingTypeName
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileByType(int before, int after, String editingTypeName) throws Exception;

	/**
	 * 统计下拉查看文件
	 * 
	 * @param editingTypeName
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	Integer countQueryEditingFileByType(String editingTypeName) throws Exception;

	/**
	 * 根据编研时间查看文件
	 * 
	 * @param before
	 * @param after
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileByDate(int before, int after, Date editingDate) throws Exception;

	/**
	 * 统计根据编研时间查看文件
	 * 
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	Integer countQueryEditingFileByDate(Date editingDate) throws Exception;

	/**
	 * 删除编研文件
	 * 
	 * @param editingId
	 * @return
	 * @throws Exception
	 */
	Integer deleteEditingFile(String editingId) throws Exception;

	/**
	 * 查询所有编研文件
	 * 
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryAllEditingFile() throws Exception;

	/**
	 * 添加编研文件
	 * 
	 * @param editingFile
	 * @return
	 */
	Integer addEditingFile(EditingFile editingFile);

	/**
	 * 查询类型主键
	 * 
	 * @param editingTypeName
	 * @return
	 */
	EditingFile queryByTypeName(String editingTypeName);

	/**
	 * 修改编研文件
	 * 
	 * @param editingId
	 * @param editingType
	 * @param editingTitle
	 * @param editingAuthor
	 * @param editingController
	 * @return
	 */
	Integer updateEditingFile(EditingFile editingFile);
}
