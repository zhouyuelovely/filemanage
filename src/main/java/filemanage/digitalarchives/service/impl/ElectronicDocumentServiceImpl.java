package filemanage.digitalarchives.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.dao.ElectronicDocumentMapper;
import filemanage.digitalarchives.pojo.ElectronicDocument;
import filemanage.digitalarchives.service.ElectronicDocumentService;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

@Service
public class ElectronicDocumentServiceImpl implements ElectronicDocumentService {

	@Autowired
	private ElectronicDocumentMapper electronicDocumentMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryElectronicDocumentList() throws Exception {
		List<ElectronicDocument> data = electronicDocumentMapper.queryElectronicDocumentList();
		Integer count = electronicDocumentMapper.countElectronicDocumentList();
		return Layui.data(count, data);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryElectronicDocumentByCondition(ElectronicDocument electronicDocument) throws Exception {
		List<ElectronicDocument> data = electronicDocumentMapper.queryElectronicDocumentByCondition(electronicDocument);
		Integer count = electronicDocumentMapper.countElectronicDocumentByCondition(electronicDocument);
		return Layui.data(count, data);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PageBean<FileAttachment> queryElectronicAttachment(Integer currentPage) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<FileAttachment> pageBean = new PageBean<FileAttachment>();
		// 每一页显示数据
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 统计电子文件附件总数量
		int totalCount = electronicDocumentMapper.countElectronicAttachment();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		double pages = totalCount;
		Double num = Math.ceil(pages / pageSize);
		pageBean.setTotalPage(num.intValue());
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		List<FileAttachment> listAttachment = electronicDocumentMapper.queryElectronicAttachmentList(map);
		for (FileAttachment fileAttachment : listAttachment) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replaceAll("D:/file", "/resource"));
		}
		pageBean.setLists(listAttachment);
		return pageBean;
	}

	@Override
	public PageBean<String> queryElectronicImgList(Integer currentPage, String archiveFileId) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<String> pageBean = new PageBean<String>();
		// 每页显示的数据
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 根据全总号+文号查询出的图片路径总记录数
		int totalCount = electronicDocumentMapper.countAllElectronicImg(archiveFileId);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("archiveFileId", archiveFileId);
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<String> lists = electronicDocumentMapper.listAllElectronicImg(map);
		List<String> fileList = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			fileList.add(lists.get(i).replaceAll("D:/file", "/resource"));
		}
		pageBean.setLists(fileList);
		return pageBean;
	}

}
