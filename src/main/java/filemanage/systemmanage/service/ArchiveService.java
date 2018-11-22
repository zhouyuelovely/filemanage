package filemanage.systemmanage.service;

import java.util.List;

import filemanage.systemmanage.pojo.Archive;


/**
 * @author MLT
 *
 */
public interface ArchiveService {

	/**
	 * 全宗的增删改查
	 */

	/**
	 * 添加全宗
	 * @param archive
	 * @return
	 */
	Boolean addOneArchive(Archive archive);
	/**
	 * 判断全宗号是否存在(存在则>=0,不存在则<0)
	 * @param archive
	 * @return
	 */
	int isExitArchiveNumber(Archive archive);
	/**
	 * 判断全宗名是否存在(存在则>=0,不存在则<0)
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
	Boolean deleteOneArchive(String quanzongId);
	/**
	 * 删除前查询全宗下是否有数据(比如机构、没有，则能删除；哟，则不能删除)
	 * @param quanzongId
	 * @return
	 */
	int countArchiveLinkInfo(String quanzongId);

	/**
	 * 编辑全宗信息
	 * @param archive
	 * @return
	 */
	Boolean updateOneArchive(Archive archive);

	/**
	 * 根据主键查询全宗信息
	 * @param quanzongId
	 * @return
	 */
	Archive queryArchiveById(String quanzongId);

	/**
	 * 页面展示所有全宗信息
	 * @return
	 */
	List<Archive> selectAllArchive();
	/**
	 * 统计全部全宗的个数
	 * @return
	 */
	int countAllArchive();

	/**
	 * 全宗管理中批量导入去重判断()
	 * @param archive
	 * @return
	 */
	Integer countAllByImportArchive(Archive archive);

	/**
	 * 全宗管理_根据关键词查询(全宗号、全宗名称)
	 * @param archiveQueryConditions
	 * @return
	 */
	List<Archive> queryArchiveByArchiveQueryCondition(Archive archive);
	
	/**
	 * 关键词数
	 * @param conditions
	 * @return
	 */
	int countArchiveByConditions(String conditions);

}
