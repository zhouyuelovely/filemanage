package filemanage.digitalarchives.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.impl.ArchiveFileStoreServiceImpl;
import filemanage.digitalarchives.dao.ElectronicReadingRoomMapper;
import filemanage.digitalarchives.service.ElectronicReadingRoomService;
import filemanage.digitalarchives.vo.ElecReadingRoomVo;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * @author MLT 数字档案馆_电子阅览室
 *
 */
@Service("electronicReadingRoomService")
public class ElectronicReadingRoomServiceImpl implements ElectronicReadingRoomService {

	private Logger logger = Logger.getLogger(ArchiveFileStoreServiceImpl.class);
	
	
	@Autowired
	private ElectronicReadingRoomMapper electronicReadingRoomMapper;
	
	
	/**
	 * 页面展示全部公开的档案
	 */
	@Override
	public Layui selectAllPublicArchive(Integer limit,Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("begin", begin);
		map.put("end", end);
		List<ElecReadingRoomVo> selectAllPublicArchive = electronicReadingRoomMapper.selectAllPublicArchive(map);
		Integer countAllPublicArchive = electronicReadingRoomMapper.countAllPublicArchive();
		return Layui.data(countAllPublicArchive, selectAllPublicArchive);
	}

	/**
	 * 统计全部公开的档案数
	 */
	@Override
	public int countAllPublicArchive() {
		return electronicReadingRoomMapper.countAllPublicArchive();
	}
	
	/**
	 * 根据主键查询文件附件信息 
	 */
	@Override
	public List<FileAttachment> selectFileAttachmentByArchiveFileId(String archiveFileId) {
		List<FileAttachment> fileAttachmentList = electronicReadingRoomMapper.selectFileAttachmentByArchiveFileId(archiveFileId);
		for (FileAttachment fileAttachment : fileAttachmentList) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		return fileAttachmentList;
	}
	
	/**
	 * 根据主键查询文件附件信息/分页后
	 */
	@Override
	public PageBean<FileAttachment> selectFileAttachmentByArchiveFileIdPages(String archiveFileId, int currentPage) {
		logger.info("监听到传入的参数：archiveFileId=" + archiveFileId + "currentPage=" + currentPage);
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<FileAttachment> pageBean = new PageBean<FileAttachment>();
		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = electronicReadingRoomMapper.countFileAttachmentByArchiveFileIdPages(archiveFileId);
		pageBean.setTotalCount(totalCount);
		
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("begin", (currentPage - 1) * pageSize + 1);
		map.put("end", currentPage * pageSize);
		map.put("archiveFileId", archiveFileId);
		
		List<FileAttachment> lists = electronicReadingRoomMapper.selectFileAttachmentByArchiveFileIdPages(map);
		for (FileAttachment fileAttachment : lists) {
			logger.info("监听到的文件附件的返回参数:fileAttachment="+fileAttachment);
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		pageBean.setLists(lists);
		return pageBean;
	}
	
	/**
	 * 统计文件附件的数量
	 */
	@Override
	public int countFileAttachmentByArchiveFileIdPages(String archiveFileId) {
		return electronicReadingRoomMapper.countFileAttachmentByArchiveFileIdPages(archiveFileId);
	}

	/**
	 * 缩略图展示所有密级为公开状态的文件(档号)
	 */
	@Override
	public PageBean<ElecReadingRoomVo> selectAllPublicArchiveDh(Integer currentPage) throws Exception{
		logger.info("缩略图展示每份密级为公开的文件的首页图片");
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<ElecReadingRoomVo> pageBean=new PageBean<ElecReadingRoomVo>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    //统计缩略图展示的图片数量
	    int totalCount = electronicReadingRoomMapper.countAllPublicArchiveDh();
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
	 	map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<ElecReadingRoomVo> lists = electronicReadingRoomMapper.selectAllPublicArchiveDh(map);
		if(lists.size()>0){
			for (ElecReadingRoomVo elecReadingRoomVo : lists) {
				elecReadingRoomVo.setFileAttachmentPath(elecReadingRoomVo.getFileAttachmentPath().replace("D:/file", "/resource"));
			}
		}
		pageBean.setLists(lists);		
		return pageBean;
	}

	/**
	 * 统计所有密级为公开状态的文件的附件数(档号)
	 */
	@Override
	public int countAllPublicArchiveDh() {
		return electronicReadingRoomMapper.countAllPublicArchiveDh();
	}

	/**
	 * 多条件关键词查询
	 */
	@Override
	public Layui queryAllPublicAchiveFileByConditions(ElecReadingRoomVo elecReadingRoomVo,Integer limit,Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("quanzongName", elecReadingRoomVo.getQuanzongName());
		map.put("archiveFileAnual", elecReadingRoomVo.getArchiveFileAnual());
		map.put("retentionperiodname", elecReadingRoomVo.getRetentionperiodname());
		map.put("pcName", elecReadingRoomVo.getPcName());
		map.put("scName", elecReadingRoomVo.getScName());
		map.put("begin", begin);
		map.put("end", end);
		map.put("conditions", elecReadingRoomVo.getConditions());
		int countAllPublicAchiveFileByConditions = electronicReadingRoomMapper.countAllPublicAchiveFileByConditions(elecReadingRoomVo);
		List<ElecReadingRoomVo> queryAllPublicAchiveFileByConditionsi = electronicReadingRoomMapper.queryAllPublicAchiveFileByConditions(map);
		return Layui.data(countAllPublicAchiveFileByConditions, queryAllPublicAchiveFileByConditionsi);
	}

	/**
	 * 统计关键词的个数
	 */
	@Override
	public int countAllPublicAchiveFileByConditions(ElecReadingRoomVo elecReadingRoomVo) {
		return electronicReadingRoomMapper.countAllPublicAchiveFileByConditions(elecReadingRoomVo);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 获取档案文件拥有的全宗信息
	 */
	@Override
	public List<ElecReadingRoomVo> listAllArchiveInfo() {
		return electronicReadingRoomMapper.listAllArchiveInfo();
	}

	/**
	 * 根据全宗主键获取文件年度
	 */
	@Override
	public List<ElecReadingRoomVo> listArchiveFileAnual() {
		return electronicReadingRoomMapper.listArchiveFileAnual();
	}

	/**
	 * 根据全宗花间和文件主键获取保管期限名称
	 */
	@Override
	public List<ElecReadingRoomVo> listRetentionperiodName() {
		return electronicReadingRoomMapper.listRetentionperiodName();
	}

	/**
	 * 根据全宗主键、文件主键和保管期限主键获取一级分类名称
	 */
	@Override
	public List<ElecReadingRoomVo> listPCName() {
		return electronicReadingRoomMapper.listPCName();
	}

	/**
	 * 根据全宗主键、文件主键、保管期限主键和一级分类主键获取二级分类名称
	 */
	@Override
	public List<ElecReadingRoomVo> listSCName() {
		return electronicReadingRoomMapper.listSCName();
	}
}
