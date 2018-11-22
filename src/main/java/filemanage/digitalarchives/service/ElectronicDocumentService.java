package filemanage.digitalarchives.service;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.pojo.ElectronicDocument;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * 电子文件表业务层接口
 * 
 * @author FYX
 *
 */
public interface ElectronicDocumentService {

	/**
	 * 查询电子文件表所有信息
	 * 
	 * @return
	 */
	Layui queryElectronicDocumentList() throws Exception;

	/**
	 * 查询电子文件信息
	 * 
	 * @param electronicDocument
	 * @return
	 * @throws Exception
	 */
	Layui queryElectronicDocumentByCondition(ElectronicDocument electronicDocument) throws Exception;

	/**
	 * 查询电子附件路径集合(图片展示)
	 * 
	 * @return
	 */
	PageBean<FileAttachment> queryElectronicAttachment(Integer currentPage) throws Exception;

	/**
	 * 根据文件主键及当前页码查看附件图片
	 * 
	 * @param currentPage
	 * @param archiveFileId
	 * @return
	 */
	PageBean<String> queryElectronicImgList(Integer currentPage, String archiveFileId) throws Exception;

}
