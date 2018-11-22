package filemanage.digitalarchives.service;

import java.util.List;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.vo.ElecReadingRoomVo;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * @author MLT 电子阅览室
 *
 */
public interface ElectronicReadingRoomService {
	
	/**
	 * 展示所有公开档案信息
	 * @return
	 */
	Layui selectAllPublicArchive(Integer limit,Integer page);
	
	/**
	 * 统计全部的公开档案数
	 * @return
	 */
	int countAllPublicArchive();
	
	/**
	 * 查询单个文件 的附件信息
	 * @param archiveFileId
	 * @return
	 */
	List<FileAttachment> selectFileAttachmentByArchiveFileId(String archiveFileId);
	
	/**
	 * 根据文件主键查询文件附件信息/分页后的附件信息
	 * @param map
	 * @return
	 */
	PageBean<FileAttachment> selectFileAttachmentByArchiveFileIdPages(String archiveFileId,int currentPage);
	
	/**
	 * 统计文件附件数量
	 * @param archiveFileId
	 * @return
	 */
	int countFileAttachmentByArchiveFileIdPages(String archiveFileId);
//====================================页面内全部公开档案列表展示=========================================
	/**
	 * 缩略图展示所有密级为公开状态的文件(档号)
	 * @return
	 */
	PageBean<ElecReadingRoomVo> selectAllPublicArchiveDh(Integer currentPage) throws Exception;
	
	/**
	 * 统计所有密级为公开状态的文件的附件数(档号)
	 * @return
	 */
	int countAllPublicArchiveDh();
	// ====================================全部档案以缩略图形式展示=========================================
	
	/**
	 * 多条件查询全部公开档案
	 * @param map
	 * @return
	 */
	Layui queryAllPublicAchiveFileByConditions(ElecReadingRoomVo elecReadingRoomVo,Integer limit,Integer page);
			
	/**
	 * 统计多条件查询的关键词个数
	 * @param archiveFile
	 * @return
	 */
	int countAllPublicAchiveFileByConditions(ElecReadingRoomVo elecReadingRoomVo);
	
	//======================================多条件查询全部公开档案=====================================
	/**
	 * 获取档案文件拥有的全宗信息
	 * @return
	 */
	List<ElecReadingRoomVo> listAllArchiveInfo();

	/**
	 * 获取密级为公开的文件的年度
	 * @return
	 */
	List<ElecReadingRoomVo> listArchiveFileAnual();

	/**
	 * 获取密级为公开的文件的保管期限
	 * @return
	 */
	List<ElecReadingRoomVo> listRetentionperiodName();

	/**
	 * 获取密级为公开的文件的一级分类
	 * @return
	 */
	List<ElecReadingRoomVo> listPCName();

	/**
	 * 获取密级为公开的文件的二级分类
	 * @return
	 */
	List<ElecReadingRoomVo> listSCName();
//==========================================档案检索(条件筛选)=========================================

}
