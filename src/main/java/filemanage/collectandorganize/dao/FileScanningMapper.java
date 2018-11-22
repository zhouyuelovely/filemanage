package filemanage.collectandorganize.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.pojo.TemporaryFile;

/**
 * @author FYX
 *
 */
@Repository
public interface FileScanningMapper {
	/**
	 * 保存扫描图片信息到文件临时表中
	 * 
	 * @param temporaryFile
	 * @return
	 */
	Integer saveImageInfo(List<TemporaryFile> list) throws Exception;

	/**
	 * 根据扫描人身份证号统计图片数量
	 * 
	 * @param userIdNumber
	 * @return
	 */
	Integer countImgPath(@Param("temporaryAccessaryUserIdNumber") String userIdNumber) throws Exception;

	/**
	 * 根据扫描人身份证号和当前页数分页查询图片路径集合
	 * 
	 * @param map
	 * @return
	 */
	List<TemporaryFile> listImgPath(HashMap<String, Object> map) throws Exception;

	/**
	 * 根据路径删除图片记录
	 * 
	 * @param path
	 * @return
	 */
	Integer deleteImgByPath(@Param("temporaryAccessaryPath") String temporaryAccessaryPath) throws Exception;

	/**
	 * 添加封面信息
	 * 
	 * @param archiveFile
	 * @return
	 */
	Boolean addCoverInfo(ArchiveFile archiveFile) throws Exception;

	/**
	 * 根据图片路径标记首页
	 * 
	 * @param ftp
	 * @return
	 */
	Integer tagPageByImgPath(@Param("temporaryAccessaryPath") String temporaryAccessaryPath) throws Exception;

	/**
	 * 根据用户身份证号查询临时附件表信息
	 * 
	 * @param userIdNumber
	 * @return
	 */
	List<TemporaryFile> queryTemporaryFileInfoByUserIdNumber(
			@Param("temporaryAccessaryUserIdNumber") String temporaryAccessaryUserIdNumber) throws Exception;

	/**
	 * 添加信息到文件附件表中
	 * 
	 * @param fileAttachment
	 * @return
	 */
	Integer addFileAttachmentInfo(@Param("list")List<FileAttachment> list) throws Exception;

	/**
	 * 根据全宗主键删除临时表信息
	 * 
	 * @param quanzongId
	 * @return
	 */
	Integer deleteTemporaryByquanzongId(@Param("quanzongId") String quanzongId) throws Exception;

	/**
	 * 文号或者题名重名校验
	 * 
	 * @param archiveFile
	 * @return
	 */
	Integer queryByCondition(ArchiveFile archiveFile) throws Exception;

	/**
	 * 根据题名查询文件表主键
	 * 
	 * @param archiveFileTitle
	 * @return
	 */
	ArchiveFile queryArchiveFileIdByArchiveFileTitle(@Param("archiveFileTitle") String archiveFileTitle)
			throws Exception;

	/**
	 * 获取页码大于删除页码文件附件的集合
	 * 
	 * @param archiveId
	 * @param temporaryAccessaryPageNumber
	 * @return
	 */
	List<TemporaryFile> getPageNumberList(@Param("quanzongId") String quanzongId,
			@Param("temporaryAccessaryPageNumber") String temporaryAccessaryPageNumber) throws Exception;

	/**
	 * 根据临时文件表主键和新页码更新旧页码
	 * 
	 * @param temporaryAccessaryId
	 * @param newPageNumber
	 * @return
	 */
	Integer updateTemporaryFilePageNumber(@Param("temporaryAccessaryId") String temporaryAccessaryId,
			@Param("temporaryAccessaryPageNumber") String temporaryAccessaryPageNumber) throws Exception;

	/**
	 * 根据身份证号统计页数
	 * 
	 * @param userIdNumber
	 * @return
	 */
	Integer countPage(@Param("temporaryAccessaryUserIdNumber") String userIdNumber) throws Exception;
	
}
