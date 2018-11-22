package filemanage.collectandorganize.service.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.dao.IdentificationMapper;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.IdentificationService;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.utils.page.PageBean;
import filemanage.utils.shuiYinTool.SealTools;

@Transactional
@Service("identificationService")
public class IdentificationServiceImpl implements IdentificationService {
	@Autowired
	private IdentificationMapper identificationMapper;
	private Logger logger=Logger.getLogger(IdentificationServiceImpl.class);

	@Override
	public Boolean updateArchiveFileById(ArchiveFile archiveFile) {
		logger.info("修改文件鉴定状态");
		return identificationMapper.updateArchiveFileById(archiveFile);
	}

	@Override
	public PageBean<FileAttachment> queryImgList(String archiveFileAuthenticateStatus,
			String archiveFileAnual,String quanzongId,String archiveFileFinishingStatus,
			Integer currentPage) throws Exception {
		logger.info("根据立卷老师对应全宗年度筛选分页查询图片路径集合");
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<FileAttachment> pageBean=new PageBean<FileAttachment>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    //根据立卷老师对应全宗年度筛选统计图片数量
	    int totalCount = identificationMapper.countImgPath(archiveFileAuthenticateStatus,archiveFileAnual,quanzongId,archiveFileFinishingStatus);
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
	 	map.put("archiveFileAuthenticateStatus", archiveFileAuthenticateStatus);
	 	map.put("archiveFileAnual", archiveFileAnual);
	 	map.put("quanzongId", quanzongId);
	 	map.put("archiveFileFinishingStatus", archiveFileFinishingStatus);
	 	map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<FileAttachment> lists=identificationMapper.queryImgList(map);
		if(lists.size()>0) {
			for (FileAttachment fileAttachment : lists) {
				fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
				
			}
		}
		
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public Integer countImgPath(String archiveFileAuthenticateStatus,String archiveFileAnual,String quanzongId,String archiveFileFinishingStatus) throws Exception {
		logger.info("根据附件年度统计图片数量");
		return identificationMapper.countImgPath(archiveFileAuthenticateStatus,archiveFileAnual,quanzongId,archiveFileFinishingStatus);
	}
	
	@Override
	public PageBean<FileAttachment> findFileByPage(String archiveFileAuthenticateStatus,String archiveFileAnual,String quanzongId,String archiveFileFinishingStatus,
			Integer currentPage) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<FileAttachment> pageBean=new PageBean<FileAttachment>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    //根据立卷老师对应全宗年度筛选统计图片数量
	    int totalCount = identificationMapper.countImgPath(archiveFileAuthenticateStatus, archiveFileAnual, quanzongId,archiveFileFinishingStatus);
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
		map.put("archiveFileAuthenticateStatus", archiveFileAuthenticateStatus);
	 	map.put("archiveFileAnual", archiveFileAnual);
	 	map.put("quanzongId", quanzongId);
	 	map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		
		// 封装每页显示的数据
	    List<FileAttachment> lists=identificationMapper.queryImgList(map);
	    for (FileAttachment fileAttachment : lists) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		pageBean.setLists(lists);
		return pageBean;
	}
	

	@Override
	public List<FileAttachment> queryAttachmentImgList(
			String archiveFileId) throws Exception {
		   logger.info("根据文件主键和鉴定分类还有年度和全宗主键分页查询");
			// 封装每页显示的数据
			List<FileAttachment> lists=identificationMapper.queryAttachmentImgList(archiveFileId);
			for (FileAttachment fileAttachment : lists) {
				fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
				
				
			}
		
			return lists;
	}

	@Override
	public Integer countAttachmentImgPath(String archiveFileId) throws Exception {
		logger.info("根据文件主键查询附件表中文件图片数量 ");
		return identificationMapper.countAttachmentImgPath(archiveFileId);
	}

	@Override
	public Integer updateArchiveFile(AmCoArchivefile amcoArchivefile) {
		logger.info("点保存按钮给文件赋予属性");
		return identificationMapper.updateArchiveFile(amcoArchivefile);
	}


	@Override
	public ArchiveFile queryArchiveFileById(String archiveFileId) {
		
		return identificationMapper.queryArchiveFileById(archiveFileId);
	}

	/**
     * 根据年度和全宗查询已整理过并且已归档的文件个数
     * @param archiveFileAnual
     * @param quanzongId
     * @return
     */
	@Override
	public Integer countFileByStatus(AmCoArchivefile amcoArchivefile) {
		// TODO Auto-generated method stub
		return identificationMapper.countFileByStatus(amcoArchivefile);
	}

	/**
     * 查询最大标记
     * @param archiveFile
     * @return
     */
	@Override
	public Integer queryMax(AmCoArchivefile amcoArchivefile) {
		// TODO Auto-generated method stub
		return identificationMapper.queryMax(amcoArchivefile);
	}

	@Override
	public List<FileAttachment> previousOneQuery(AmCoArchivefile amcoArchivefile) throws Exception {
		
		List<FileAttachment> lists=identificationMapper.previousOneQuery(amcoArchivefile);
		for (FileAttachment fileAttachment : lists) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
			
			return lists;
	}

	@Override
	public List<ArchiveFile> queryFileByAnualAndStatus(String quanzongId) {
		logger.info("根据全宗主键查询该全宗年度下所有年度状态为整理中的文件");
		return identificationMapper.queryFileByAnualAndStatus(quanzongId);
	}

	@Override
	public Integer updateFileByStatus(AmCoArchivefile amcoArchivefile) {
		
		return identificationMapper.updateFileByStatus(amcoArchivefile);
	}

	@Override
	public Integer countFileByAnual(String archiveFileAnual) {
		
		return identificationMapper.countFileByAnual(archiveFileAnual);
	}

	@Override
	public Integer countFile(String archiveFileAnual) {
		
		return identificationMapper.countFile(archiveFileAnual);
	}


	@Override
	public List<FileAttachment> queryFileAttachmentById(String archiveFileId)
			throws Exception {
		
	    List<FileAttachment> lists=identificationMapper.queryFileAttachmentById(archiveFileId);
	    for (FileAttachment fileAttachment : lists) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		return lists;
	 	
	    
		
	}

	

	

	

	

	

	

	

	


	
	

	

}
