package filemanage.recorded.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.recorded.vo.ArchiveFileAddHelp;
import filemanage.recorded.vo.BoxAddHelp;
import filemanage.recorded.vo.BoxAttachmentHelp;
import filemanage.recorded.vo.ConditionHelp;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.recorded.vo.SaveBoxInfor;
import filemanage.systemmanage.pojo.AmCoBox;

/**
 * @author meng
 *档案著录信息
 */
@Repository
public interface ArchivingFileRecordedMapper {
	/**
	 * 查询全宗主键
	 * @param quanZongNumber 全宗号
	 * @return
	 */
	String queryQuanZongId(String quanZongNumber);
	/**
	 * 查询保管期限主键
	 * @param retentionPeriodCode 保管期限代码
	 * @return
	 */
	String queryRetentionPeriodId(String retentionPeriodCode);
	/**
	 * 查询一级分类主键
	 * @param pcCode 一级分类代码
	 * @return
	 */
	String queryPcId(String pcCode);
	/**
	 * 查询二级分类主键
	 * @param scCode 二级分类代码
	 * @return
	 */
	String queryScId(String scCode);
	/**
	 * 添加盒信息
	 * @param boxAddHelp 盒子信息
	 * @return
	 */
	Integer addBoxInfor(BoxAddHelp boxAddHelp);
	/**
	 * 添加文件的信息
	 * @param list 文件的集合
	 * @return
	 */
	Integer addArchiveFile(List<ArchiveFileAddHelp> list);
	/**
	 * 获取全宗号
	 * @return
	 */
	List<ConditionHelp> findQuanzongNumber();
	/**
	 * 获取全宗名
	 * @return
	 */
	List<ConditionHelp> findQuanzongName();
	/**
	 * 获取一级分类
	 * @return
	 */
	List<ConditionHelp> findPcId();
	/**
	 * 获取二级分类
	 * @return
	 */
	List<ConditionHelp> findScId();
	/**
	 * 获取保管期限
	 * @return
	 */
	List<ConditionHelp> findRetentionperiodName();
	/**
	 * 获取盒属性
	 * @return
	 */
	List<ConditionHelp> findBoxpropertyPag();
	/**
	 * 根据盒子信息查询盒子是否存在
	 * @param preparationFormHelp
	 * @return
	 */
	AmCoBox findAmCoBoxByCondition(PreparationFormHelp preparationFormHelp);
	/**
	 * 查询保管期限代码
	 * @param rtId 保管期限主键
	 * @return
	 */
	String findRetentionCode(String rtId);
	/**
	 * 更新盒子信息
	 * @param saveBoxInfor 盒子信息
	 * @return
	 */
	Integer updataBoxInfor(SaveBoxInfor saveBoxInfor);
	/**
	 * 添加盒子附件信息
	 * @param boxAttachmentHelp
	 * @return
	 */
	Integer addBoxAttechment(BoxAttachmentHelp boxAttachmentHelp);
	/**
	 * 查询盒子中的文件
	 * @param boxId 盒子的主键
	 * @return
	 */
	List<ArchiveFile> findArchiveFileByBoxId(Map<String,Object> map);
	/**
	 * 统计盒子中文件数量
	 * @param boxId 盒子主键
	 * @return
	 */
	Integer countArchiveFileByBoxId(String boxId);
	/**
	 * 查询盒子下所有的文件
	 * @param boxId 盒子主键
	 * @return
	 */
	List<ArchiveFile> findAllArchiveFileByBoxId(String boxId);
	/**
	 * 更新文件信息
	 * @param map 信息集合
	 * @return
	 */
	Integer updataFileInfor(Map<String, String> map);
	/**
	 * 查询全宗号
	 * @param fileId 文件主键
	 * @return
	 */
	String findQzongNumber(String fileId);
	/**
	 * 获取全宗主键
	 * @param fileId
	 * @return
	 */
	String findQuanzongId(String fileId);
	/**
	 * 添加文件附件信息
	 * @param list 文件附件集合
	 * @return
	 */
	Integer addFileAttachment(List<FileAttachment> list);
	/**
	 * 获取文件文件的集合
	 * @param archiveFileId 文件主键
	 * @return
	 */
	List<String> havingFileAtta(String archiveFileId);
	/**
	 * 文件状态筛选
	 * @param map 信息集合
	 * @return
	 */
	List<ArchiveFile> findArchiveFileByBoxIdAndStart(Map<String,Object> map);
	/**
	 * 统计指定状态下的文件
	 * @param boxId 盒子主键
	 * @param start 状态
	 * @return
	 */
	Integer countArchiveFileByBoxIdAndStart(@Param("boxId")String boxId,@Param("start")String start);
	/**
	 * 更新盒子状态（未保存-未进馆）
	 * @param boxId 盒子主键
	 * @return
	 */
	Boolean updataBoxStart(String boxId);
	/**
	 * 更新文件的上传状态
	 * @param fileId
	 * @return
	 */
	Boolean updateFileStart(String fileId);
	/**
	 * 文件已上传到数量
	 * @param boxId 盒子的主键
	 * @return
	 */
	Integer havingFileNum(String boxId);
	/**
	 * 更新盒子装盒状态
	 * @param boxId 盒子主键
	 * @return
	 */
	Boolean updateBoxingStart(String boxId);
	/**
	 * 获取盒子中文件的数量
	 * @param boxId 盒子主键
	 * @return
	 */
	String havingBoxFileNum(String boxId);
	
	Integer selectCount(BoxAddHelp boxAddHelp);
}
