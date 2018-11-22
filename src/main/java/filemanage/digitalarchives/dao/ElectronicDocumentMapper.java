package filemanage.digitalarchives.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.pojo.ElectronicDocument;

@Repository
public interface ElectronicDocumentMapper {

	/**
	 * 查询电子文件表所有信息
	 * 
	 * @return
	 */
	List<ElectronicDocument> queryElectronicDocumentList();

	/**
	 * 统计电子文件表文件数量
	 * 
	 * @return
	 */
	Integer countElectronicDocumentList();

	/**
	 * 根据条件查询电子文件信息
	 * 
	 * @param electronicDocument
	 * @return
	 * @throws Exception
	 */
	List<ElectronicDocument> queryElectronicDocumentByCondition(ElectronicDocument electronicDocument) throws Exception;

	/**
	 * 根据条件统计电子文件信息数量
	 * 
	 * @param electronicDocument
	 * @return
	 * @throws Exception
	 */
	Integer countElectronicDocumentByCondition(ElectronicDocument electronicDocument) throws Exception;

	/**
	 * 统计电子附件数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countElectronicAttachment() throws Exception;

	/**
	 * 查询电子附件路径集合(图片展示)
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<FileAttachment> queryElectronicAttachmentList(HashMap<String, Object> map) throws Exception;

	/**
	 * 根据文件主键统计图片数量
	 * 
	 * @param archiveFileId
	 * @return
	 */
	Integer countAllElectronicImg(@Param("archiveFileId") String archiveFileId) throws Exception;

	/**
	 * 根据文件主键及当前页码查看图片
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<String> listAllElectronicImg(HashMap<String, Object> map) throws Exception;

}
