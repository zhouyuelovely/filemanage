package filemanage.collectandorganize.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.converters.BooleanArrayConverter;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.QueryArchiveFileCondition;
import filemanage.collectandorganize.vo.QueryArchiveFileStoreHelp;
import filemanage.collectandorganize.vo.SaveArchiveFileHelp;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

public interface ArchiveFileStoreService {
	/**
	 * 全宗下文件集合
	 * @param archiveId
	 * @return
	 */
	Layui findAllArchiveFile(String archiveId,Integer limit,Integer page);
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
	/**
	 * 查询全宗某年度的全部采集文件
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文集的合集，封装在工具类中
	 */
	Layui findArchiveFile(String archiveId,String annual,Integer limit,Integer page);
	/**
	 * 统计本全宗某年度的全部采集文件数量
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文件数量
	 */
	Integer countFileNumberArchiveFile(String archiveId,String annual);
	/**
	 * 统计本全宗某年度的全部采集文件总页数
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return 文件的总数量
	 */
	Integer countPageNumber(String archiveId,String annual);
	/**
	 * 条件查询文件信息
	 * @param queryArchiveFileCondition 包括全宗主键，年度，和查询条件
	 * @return 条件筛选后的文件的合集，封装在工具类
	 */
	Layui queryArchiveFileByCondition(QueryArchiveFileCondition queryArchiveFileCondition,Integer limit,Integer page);
	/**
	 * 条件查询文件数量
	 * @param queryArchiveFileCondition 全宗主键，年度，查询条件
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
	 * 获取文件的附件的信息（按照先后顺序进行排列）
	 * @param archiveFileId 文件主键
	 * @return 文件附件的集合
	 */
	List<FileAttachment> queryFileAttachmentAddressByArchiveFileId(String archiveFileId);
	/**
	 * 查询单个文件的信息
	 * @param archiveFileId 文件的主键
	 * @return 单个文件的信息
	 */
	ArchiveFile queryArchiveFileByArchiveFileId(String archiveFileId);
	/**
	 * 分页查询文件附件
	 * @param archiveFileId 文件主键
	 * @param currentPage 当前页数
	 * @return 文件附件的相关信息
	 */
	PageBean<FileAttachment> queryFileAttachmentByArchiveFileIdPages(String archiveFileId,int currentPage);
	/**
	 * 获取文件附件的信息
	 * @param archiveFileId 文件主键
	 * @return 文件地址
	 */
	String queryFileAttachmentPathByArchiveFileId(String archiveFileId);
	/**
	 * 统计附件附件数量
	 * @param archiveFileId 文件主键 
	 * @return 文件附件数量
	 */
	Integer countFileAttachmentByArchiveFileIdPages(String archiveFileId);
	/**
	 * 更新文件信息
	 * @param archiveFile 新文件信息
	 * @return 更新文件信息是否成功
	 */
	Boolean updateArchiveFileByArchiveFileId(SaveArchiveFileHelp saveArchiveFileHelp);
	/**
	 * 添加文件附件
	 * @param fileAttachment
	 * @return
	 */
	Boolean addFileAttachment(FileAttachment fileAttachment);
	/**
	 * 删除文件附件
	 * @param archiveFileId
	 * @return
	 */
	Boolean deleteFileAttachment(String archiveFileId);
	/**
	 *删除文件的信息（更新文件的状态，表示是否删除）
	 * @param archiveFileId 文件主键
	 * @return 删除文件（实际为更改数据库文件的状态-假删除）是否成功
	 */
	Boolean deleteArchiveFileByArchiveFileId(String archiveFileId);
	/**
	 * 更新文件的状态
	 * @param archiveId 全宗主键
	 * @param annual 年度
	 * @return
	 */
	Boolean updateArchiveFileStartByArchiveFileId(String archiveId,String annual);
	/**
	 * 根据主键添加更新文件状态
	 * @param str
	 * @return
	 */
	Boolean updateArchiveFileStartById(String str);
	/**
	 * 获取全宗文件的数量信息
	 * @param archiveId 全宗id
	 * @return 数量信息
	 */
	ArchiveFileHelpInfor archiveFileHelpInfor(String archiveId);
	/**
	 * 获取全宗年度文件数量信息
	 * @param archiveId 全宗主键 
	 * @param annual 年度
	 * @return 数量信息
	 */
	ArchiveFileHelpInfor archiveFileHelpInforAnual(String archiveId,String annual);
	/**
	 * 条件查询文件的数量信息
	 * @param queryArchiveFileCondition 查询条件
	 * @return 数量信息
	 */
	ArchiveFileHelpInfor archiveFileHelpInforCondition(QueryArchiveFileCondition queryArchiveFileCondition);
	/**
	 * 删除文件附件
	 * @return 
	 */
	Boolean deleteFileAttachment(String archiveFileId,String fileAttachmentPageNumber);
	/**
	 * 文件信息的校验
	 * @param archiveFileId 文件主键
	 * @param archiveFileReferenceNumber 文号
	 * @param archiveFileTitle 题名
	 * @return
	 */
	Boolean checkFile(String archiveFileId,String archiveFileReferenceNumber,String archiveFileTitle);
	
}
