package filemanage.warningandediting.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.warningandediting.pojo.EditingFile;

@Repository
public interface EditingFileMapper {
	/**
	 * 查询所有编研文件
	 * 
	 * @param before
	 * @param after
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFile(@Param("before") int before, @Param("after") int after) throws Exception;

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
	EditingFile queryEditingFileBody(@Param("editingId") String editingId) throws Exception;

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
	List<EditingFile> fuzzyEditingFile(@Param("before") int before, @Param("after") int after,
			@Param("searchBody") String searchBody) throws Exception;

	/**
	 * 统计模糊查询条数
	 * 
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	Integer countFuzzyEditingFile(@Param("searchBody") String searchBody) throws Exception;

	/**
	 * 下拉查看文件
	 * 
	 * @param before
	 * @param after
	 * @param editingTypeName
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileByType(@Param("before") int before, @Param("after") int after,
			@Param("editingTypeName") String editingTypeName) throws Exception;

	/**
	 * 统计下拉查看文件
	 * 
	 * @param editingTypeName
	 * @return
	 * @throws Exception
	 */
	Integer countQueryEditingFileByType(@Param("editingTypeName") String editingTypeName) throws Exception;

	/**
	 * 根据编研时间查看文件
	 * 
	 * @param before
	 * @param after
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	List<EditingFile> queryEditingFileByDate(@Param("before") int before, @Param("after") int after,
			@Param("editingDate") Date editingDate) throws Exception;

	/**
	 * 统计根据编研时间查看文件
	 * 
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	Integer countQueryEditingFileByDate(@Param("editingDate") Date editingDate) throws Exception;

	/**
	 * 删除编研文件
	 * 
	 * @param editingId
	 * @return
	 * @throws Exception
	 */
	Integer deleteEditingFile(@Param("editingId") String editingId) throws Exception;

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
	EditingFile queryByTypeName(@Param("editingTypeName") String editingTypeName);

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
