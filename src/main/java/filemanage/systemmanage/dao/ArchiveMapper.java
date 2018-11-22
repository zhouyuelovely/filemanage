package filemanage.systemmanage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.Archive;

/**
 * @author MLT
 *
 */
@Repository
public interface ArchiveMapper {
	/**
	 * 全宗的增删改查
	 */

	/**
	 * 添加全宗
	 * 
	 * @param archive
	 * @return
	 */
	Integer addOneArchive(Archive archive);

	/**
	 * 判断全宗号是否存在(存在则>=0,不存在则<0)
	 * 
	 * @param archive
	 * @return
	 */
	int isExitArchiveNumber(Archive archive);

	/**
	 * 判断全宗名是否存在(存在则>=0,不存在则<0)
	 * 
	 * @param archive
	 * @return
	 */
	int isExitArchiveName(Archive archive);
	
	/**
	 * 判断单位电话是否存在
	 * @param archive
	 * @return
	 */
	int isExitArchivePhone(Archive archive);

	/**
	 * 删除全宗信息
	 * @param quanzongId
	 * @return
	 */
	Integer deleteOneArchive(String quanzongId);
	/**
	 * 删除前查询全宗下是否有数据(比如机构、没有，则能删除；有，则不能删除)
	 * @param quanzongId
	 * @return
	 */
	int countArchiveLinkInfo(String quanzongId);

	/**
	 * 编辑全宗信息
	 * @param archive
	 * @return
	 */
	Integer updateOneArchive(Archive archive);

	/**
	 * 根据主键查询全宗信息(编辑相关)
	 * @param quanzongId
	 * @return
	 */
	Archive queryArchiveById(String quanzongId);

	/**
	 * 列表展示全宗信息
	 * @return
	 */
	List<Archive> selectAllArchive();

	// ++++++++++++++++++++++++++++++++++++++++++全宗的增删改查+++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 全宗管理中批量导入去重判断()
	 * @param archive                                                                                                                                                                                                                                                                                                                                                                                                   
	 * @return
	 */
	Integer countAllByImportArchive(Archive archive);
	/**
	 * 统计全部全宗的个数
	 * @return
	 */
	int countAllArchive();

	/**
	 * 全宗管理_根据关键词查询(全宗号、全宗名称)
	 * @param archiveQueryConditions
	 * @return
	 */
	List<Archive> queryArchiveByArchiveQueryCondition(Archive archive);
	/**
	 * 统计关键词查询后全宗的数目
	 * @param conditions
	 * @return
	 */
	int countArchiveByConditions(String conditions);
}
