package filemanage.collectandorganize.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.QueryArchiveFileCondition;
import filemanage.collectandorganize.vo.QueryArchiveFileStoreHelp;

/**
 * @author meng
 *档案整理-档案储存
 */
@Repository
public interface ArchiveFileStoreMapper {
	
	/**
	 * 全宗下文件集合
	 * @param archiveId
	 * @return
	 */
	List<ArchiveFile> findAllArchiveFile(Map<String, Object> map);
	/**
	 *统计全宗下文件的总数量
	 * @param archiveId
	 * @return
	 */
	Integer countFileNumberAllArchiveFile(String archiveId);
	/**
	 * 查询本全宗下所有的文件的总页数
	 * @param archiveId 全宗主键
	 * @return 总的页数
	 */
	Integer countAllPageNumber(String archiveId);
	/**
	 * 全宗下文件存在的年度
	 * @param archiveId
	 * @return
	 */
	List<QueryArchiveFileStoreHelp> listAnual(String archiveId);
	/**
	 * 查询本全宗某年度的全部采集文件
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文件集合
	 */
	List<ArchiveFile> findArchiveFile(Map<String, Object> map);
	/**
	 * 统计本全宗某年度的全部采集文件数量
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文件数量
	 */
	Integer countFileNumberArchiveFile(@Param("archiveId")String archiveId,@Param("annual")String annual);
	/**
	 * 统计本全宗某年度的全部采集文件总页数
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文件的总数量
	 */
	Integer countPageNumber(@Param("archiveId")String archiveId,@Param("annual")String annual);
	/**
	 * 条件查询文件信息
	 * @param queryArchiveFileCondition 包括全宗主键，年度，和查询条件
	 * @return 文件集合
	 */
	List<ArchiveFile> queryArchiveFileByCondition(Map<String, Object> map);
	/**
	 * 条件查询文件数量
	 * @param queryArchiveFileCondition 包括：全宗主键，年度，查询条件
	 * @return 条件查询后数量
	 */
	Integer countArchiveFileNumberByCondition(QueryArchiveFileCondition queryArchiveFileCondition);
	/**
	 * 条件统计文件的总页数
	 * @param queryArchiveFileCondition 包括：全宗主键，年度，查询条件
	 * @return 条件查询后总页数
	 */
	Integer countArchiveFilePagerByCondition(QueryArchiveFileCondition queryArchiveFileCondition);
	
	/**
	 * 根据文件的主键查询单个文件的附件信息
	 * @param archiveFileId 文件的主键
	 * @return 单个文件的详情信息（附件信息）
	 */
	List<FileAttachment> queryFileAttachmentByArchiveFileId(String archiveFileId);
	/**
	 * 查询单个文件的信息
	 * @param archiveFileId 文件的主键
	 * @return 单个文件的信息
	 */
	ArchiveFile queryArchiveFileByArchiveFileId(String archiveFileId);
	/**
	 * 根据文件主键查询文件文件信息
	 * @param archiveFileId 文件的主键
	 * @return 分页后的文件的信息
	 */
	List<FileAttachment> queryFileAttachmentByArchiveFileIdPages(Map<String, Object> map);
	/**
	 * 统计附件附件数量
	 * @param archiveFileId 文件主键 
	 * @return 文件附件数量
	 */
	Integer countFileAttachmentByArchiveFileIdPages(String archiveFileId);
	/**
	 * 更新文件信息
	 * @param archiveFile 新文件信息
	 * @return 是否更新成功
	 */
	Integer updateArchiveFileByArchiveFileId(ArchiveFile archiveFile);
	/**
	 * 添加文件的附件信息
	 * @param temporaryFile 文件附件
	 * @return 是否添加成功
	 */
	Integer addFileAttachment(FileAttachment fileAttachment);
	/**
	 * 删除文件附件
	 * @param temporaryFileId 文件附近主键
	 * @return 是否删除成功
	 */
	Integer deleteFileAttachment(String archiveFileId);
	/**
	 * 删除单个文件附件
	 * @param archiveFileId 文件主键
	 * @param fileAttachmentPageNumber 页码
	 * @return 是否删除
	 */
	Integer deleteOneFileAttachment(@Param("archiveFileId")String archiveFileId,@Param("fileAttachmentPageNumber")String fileAttachmentPageNumber);
	/**
	 * 获取附件的信息
	 * @param archiveFileId 文件主键
	 * @param fileAttachmentPageNumber 附件页码
	 * @return
	 */
	FileAttachment havingFileAttachment(@Param("archiveFileId")String archiveFileId,@Param("fileAttachmentPageNumber")String fileAttachmentPageNumber);
	/**
	 * 获取文件下页码以后的文件的集合
	 * @param archiveFileId 文件主键
	 * @param fileAttachmentPageNumber 页码
	 * @return
	 */
	List<FileAttachment> havingFileAttachmentList(@Param("archiveFileId")String archiveFileId,@Param("fileAttachmentPageNumber")String fileAttachmentPageNumber);
	/**
	 * 更新文件的序号
	 * @param fileAttachmentId 文件附件主键
	 * @param fileAttachmentPageNumber  文件附件序号
	 * @return
	 */
	Integer updateFileAttachmentPageNumber(@Param("fileAttachmentId")String fileAttachmentId,@Param("fileAttachmentPageNumber")String fileAttachmentPageNumber);
	
	/**
	 * 删除文件的信息（更新文件的状态，表示是否删除）
	 * @param archiveFileId 文件主键
	 * @return 删除返回值
	 */
	Integer deleteArchiveFileByArchiveFileId(String archiveFileId);
	
	
	/**
	 * 更新文件的整理状态
	 * @param archiveId 全宗主键 
	 * @param annual 
	 * @return
	 */
	Integer updateArchiveFileStartByArchiveFileId(@Param("archiveId")String archiveId,@Param("annual")String annual);
	/**
	 * 根据主键更新文件的状态
	 * @param archiveFileId 文件主键
	 * @return
	 */
	Integer updateArchiveFileStartById(String archiveFileId);
	/**
	 * 更新文件的附件数量
	 * @param archiveFileId 文件主键
	 * @param archiveFilePages 附件数量
	 * @return
	 */
	Integer updateArchiveFilePages(@Param("archiveFileId")String archiveFileId,@Param("archiveFilePages")String archiveFilePages);
	
	/**
	 * 根据盒主键查询文件信息
	 * @param boxId 盒子主键 
	 * @return 文件信息
	 */
	List<ArchiveFile> queryArchiveFileByBoxId(Map<String, Object> map);
	/**
	 * 统计盒子下文件附件的数量
	 * @param map
	 * @return
	 */
	Integer countArchiveFileByBoxId(String boxId);
	/**
	 * 根据盒子主键查询文件的相关信息
	 * @param boxId 盒子主键
	 * @return
	 */
	List<FileAttachment> queryFileAttachmentByBoxId(Map<String, Object> map);
	/**
	 * 根据盒子主键查询文件附件数量
	 * @param boxId 盒子主键
	 * @return 附件数量
	 */
	Integer countFileAttachmentByBoxId(String boxId);
	/**
	 * 更新文件附件的状态
	 * @param archiveFileId 文件主键
	 * @return
	 */
	Integer updateFileAttachmentStart(String archiveFileId);
	/**
	 * 更新文件附件的年度
	 * @param archiveFileId 文件主键
	 * @param annual 年度
	 * @return
	 */
	Integer updateFileAttachmentAnual(@Param("archiveFileId")String archiveFileId,@Param("annual")String annual);
	/**
	 * 标记首页
	 * @param fileAttachmentId 附件的主键
	 * @return
	 */
	Integer updateFileAttachmentRemark(String fileAttachmentId);
	/**
	 * 重名校验
	 * @param archiveFileTitle 文件 的题名
	 * @param archiveFileReferenceNumber 文件的文号
	 * @return
	 */
	List<ArchiveFile> queryArchiveFile(@Param("archiveFileTitle")String archiveFileTitle,@Param("archiveFileReferenceNumber")String archiveFileReferenceNumber);
	/**
	 * 批量更新文件附件的信息
	 * @param list 文件附件的集合
	 * @return
	 */
	Integer updateFileAttachmentPath(List<FileAttachment> list);
	
}
