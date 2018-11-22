package filemanage.digitalarchives.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.pojo.ElectronicDocument;
import filemanage.digitalarchives.service.ElectronicDocumentService;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * 电子文件表控制层
 * 
 * @author FYX
 *
 */
@Controller
public class ElectronicDocumentController {

	@Autowired
	private ElectronicDocumentService electronicDocumentService;

	/**
	 * 查询电子文件表所有信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getElectronicDocumentList", method = { RequestMethod.GET, RequestMethod.POST })
	public Layui getElectronicDocumentList() throws Exception {
		return electronicDocumentService.queryElectronicDocumentList();
	}

	/**
	 * 根据条件查询电子文件信息
	 * 
	 * @param electronicDocument
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryDocumentCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryElectronicDocumentByCondition(ElectronicDocument electronicDocument)
			throws Exception {
		return electronicDocumentService.queryElectronicDocumentByCondition(electronicDocument);
	}

	/**
	 * 查询电子附件路径集合(图片展示)
	 * 
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getElectronicAttachmentList", method = { RequestMethod.POST, RequestMethod.GET })
	public PageBean<FileAttachment> getElectronicAttachmentList(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage)
			throws Exception {
		return electronicDocumentService.queryElectronicAttachment(currentPage);
	}

	/**
	 * 根据文件主键及当前页码查看附件图片
	 * 
	 * @param currentPage
	 * @param archiveWenhao
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getElectronicImgList", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody PageBean<String> getElectronicImgList(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam("archiveFileId") String archiveFileId) throws Exception {
		PageBean<String> pageBean = electronicDocumentService.queryElectronicImgList(currentPage, archiveFileId);
		return pageBean;
	}

}
