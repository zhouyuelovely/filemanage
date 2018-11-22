package filemanage.collectandorganize.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;

/**
 * @author tchuanwu
 * 鉴定分类接口
 */
@Repository
public interface IdentificationMapper {
	/**
	 * 根据文件主键修改文件状态,拖动到待整理或回收站更改状态
	 * @param archiveFile
	 * @return
	 */
	Boolean updateArchiveFileById(ArchiveFile archiveFile);
	/**
	 * 根据立卷老师对应全宗年度筛选分页查询图片路径集合
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<FileAttachment> queryImgList(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据附件年度统计图片数量
	 * @param fileAttachmentAnual
	 * @return
	 * @throws Exception
	 */
    Integer countImgPath(@Param("archiveFileAuthenticateStatus") String archiveFileAuthenticateStatus,
    		@Param("archiveFileAnual") String archiveFileAnual,@Param("quanzongId") String quanzongId,
    		@Param("archiveFileFinishingStatus") String archiveFileFinishingStatus
    		) throws Exception;
    
    
    /**
     * 根据文件主键和鉴定分类还有年度和全宗主键分页查询
     * @param map
     * @return
     * @throws Exception
     */
    List<FileAttachment> queryAttachmentImgList(@Param("archiveFileId") String archiveFileId) throws Exception;
    /**
     * 根据文件主键查询附件表中文件图片数量
     * @param archiveFileId
     * @return
     * @throws Exception
     */
    Integer countAttachmentImgPath(
    		@Param("archiveFileId") String archiveFileId
    		) throws Exception;
    /**
     * 点保存按钮给文件赋予属性
     * @param archiveFile
     * @return
     */
    Integer updateArchiveFile(AmCoArchivefile amcoArchivefile);
    
    
    /**
     * 根据文件主键查询文件信息
     * @param archiveFileId
     * @return
     */
    ArchiveFile queryArchiveFileById(String archiveFileId);
    /**
     * 根据年度和全宗查询已整理过并且已归档的文件个数
     * @param archiveFileAnual
     * @param quanzongId
     * @return
     */
    Integer countFileByStatus(AmCoArchivefile amcoArchivefile);
    
    /**
     * 查询最大标记
     * @param archiveFile
     * @return
     */
    Integer queryMax(AmCoArchivefile amcoArchivefile);
    /**
     * 返回上一件
     * @param archiveFile
     * @return
     */
    List<FileAttachment> previousOneQuery(AmCoArchivefile amcoArchivefile) throws Exception;
    /**
     * 根据全宗主键查询该全宗年度下所有年度状态为整理中的文件
     * @return
     */
    List<ArchiveFile> queryFileByAnualAndStatus(@Param("quanzongId") String quanzongId);
    
    /**
     * 返回上一件修改上一件文件状态为整理中,鉴定文件状态为全部文件
     * @param amcoArchivefile
     * @return
     */
    Integer updateFileByStatus(AmCoArchivefile amcoArchivefile);
    /**
     * 根据年度统计全部文件
     * @param archivefileanual
     * @return
     */
     Integer countFileByAnual(String archiveFileAnual);
    
    Integer countFile(String archiveFileAnual);
    
    /**
     * 文件附件分页查询
     * @param map
     * @return
     * @throws Exception
     */
    List<FileAttachment> queryFileAttachmentById(@Param("archiveFileId") String archiveFileId) throws Exception;
    
    
   
    
   
    
  
    
    
	

}
