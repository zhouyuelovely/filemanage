package filemanage.collectandorganize.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.dao.ArchiveFileStoreMapper;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.ArchiveFileStoreService;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.QueryArchiveFileCondition;
import filemanage.collectandorganize.vo.QueryArchiveFileStoreHelp;
import filemanage.collectandorganize.vo.SaveArchiveFileHelp;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.aop.MessageTool;
import filemanage.utils.copefile.CopeFileTool;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * @author meng 文件整理的业务逻辑层实现
 */
@Service
public class ArchiveFileStoreServiceImpl implements ArchiveFileStoreService {
	private Logger logger = Logger.getLogger(ArchiveFileStoreServiceImpl.class);

	@Autowired
	private ArchiveFileStoreMapper archiveFileStoreMapper;

	@Override // 查询全宗所有的采集文件
	@MessageTool(messType="普通消息",messContent="查看全宗下文件")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui findAllArchiveFile(String archiveId,Integer limit,Integer page) {
		Layui layui = new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		List<ArchiveFile> dataAll = archiveFileStoreMapper.findAllArchiveFile(map);
		Integer count = archiveFileStoreMapper.countFileNumberAllArchiveFile(archiveId);
		return layui.data(count, dataAll);
	}

	@Override // 统计全宗所有的采集文件的总数量
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countFileNumberAllArchiveFile(String archiveId) {
		return archiveFileStoreMapper.countFileNumberAllArchiveFile(archiveId);
	};

	@Override // 统计全宗所有采集文件的总页数
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countAllPageNumber(String archiveId) {
		return archiveFileStoreMapper.countAllPageNumber(archiveId);
	};

	@Override // 查询全宗文件所拥有的年度
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<QueryArchiveFileStoreHelp> listAnual(String archiveId) {
		return archiveFileStoreMapper.listAnual(archiveId);
	}

	@Override // 查询全宗年度下的采集文件
	@MessageTool(messType="普通消息",messContent="查看全宗下某年度文件")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui findArchiveFile(String archiveId, String annual,Integer limit,Integer page) {
		Layui layui = new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("annual", annual);
		List<ArchiveFile> data = archiveFileStoreMapper.findArchiveFile(map);// 获取文件的集合
		Integer count = archiveFileStoreMapper.countFileNumberArchiveFile(archiveId, annual);// 获取文件的数量
		return Layui.data(count, data);// 组装数据
	}

	@Override // 统计全宗年度下文件的数量
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countFileNumberArchiveFile(String archiveId, String annual) {
		return archiveFileStoreMapper.countFileNumberArchiveFile(archiveId, annual);
	}

	@Override // 统计全宗年度下文件的页数
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countPageNumber(String archiveId, String annual) {
		return archiveFileStoreMapper.countPageNumber(archiveId, annual);
	}

	@Override // 条件查询全宗年度下的文件
	@MessageTool(messType="普通消息",messContent="条件查询采集文件")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryArchiveFileByCondition(QueryArchiveFileCondition queryArchiveFileCondition,Integer limit,Integer page) {
		Layui layui = new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", queryArchiveFileCondition.getArchiveId());
		map.put("begin", begin);
		map.put("end", end);
		map.put("anual", queryArchiveFileCondition.getAnual());
		map.put("condition", queryArchiveFileCondition.getCondition());
		List<ArchiveFile> data = archiveFileStoreMapper.queryArchiveFileByCondition(map);
		Integer count = archiveFileStoreMapper.countArchiveFileNumberByCondition(queryArchiveFileCondition);
		return Layui.data(count, data);
	}

	@Override // 条件查询全宗年度下的文件的总数量
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countArchiveFileNumberByCondition(QueryArchiveFileCondition queryArchiveFileCondition) {
		return archiveFileStoreMapper.countArchiveFileNumberByCondition(queryArchiveFileCondition);
	}

	@Override // 条件查询全宗年度下的文件的总页数
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countArchiveFilePagerByCondition(QueryArchiveFileCondition queryArchiveFileCondition) {
		return archiveFileStoreMapper.countArchiveFilePagerByCondition(queryArchiveFileCondition);
	}

	@Override // 文件主键查询全宗年度下的文件附件的信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileAttachment> queryFileAttachmentAddressByArchiveFileId(String archiveFileId) {
		List<FileAttachment> fileAttachmentList = archiveFileStoreMapper
				.queryFileAttachmentByArchiveFileId(archiveFileId);
		for (FileAttachment fileAttachment : fileAttachmentList) {
			fileAttachment
					.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		return fileAttachmentList;
	}

	@Override // 文件主键查询文件信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArchiveFile queryArchiveFileByArchiveFileId(String archiveFileId) {
		return archiveFileStoreMapper.queryArchiveFileByArchiveFileId(archiveFileId);
	}

	@Override // 文件主键查询文件附件信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PageBean<FileAttachment> queryFileAttachmentByArchiveFileIdPages(String archiveFileId, int currentPage) {
		logger.info("监听到传入的参数：archiveFileId=" + archiveFileId + "currentPage=" + currentPage);
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<FileAttachment> pageBean = new PageBean<FileAttachment>();
		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = archiveFileStoreMapper.countFileAttachmentByArchiveFileIdPages(archiveFileId);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("begin", (currentPage - 1) * pageSize + 1);
		map.put("end", currentPage * pageSize);
		map.put("archiveFileId", archiveFileId);

		List<FileAttachment> lists = archiveFileStoreMapper.queryFileAttachmentByArchiveFileIdPages(map);
		for (FileAttachment fileAttachment : lists) {
			logger.info("监听到文件附件返回的参数：fileAttachment=" + fileAttachment);
			fileAttachment
					.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override // 更新文件的信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public String queryFileAttachmentPathByArchiveFileId(String archiveFileId) {
		logger.info("获取文件保存路径的文件主键为:"+archiveFileId);
		String path = new String();
		List<FileAttachment> list = archiveFileStoreMapper.queryFileAttachmentByArchiveFileId(archiveFileId);
		path = list.get(0).getFileAttachmentPath();
		path=path.substring(0, path.lastIndexOf("/"));
		logger.info("文件存储的路径为:"+path);
		return path;
	}

	@Override // 统计文件附件数量的
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer countFileAttachmentByArchiveFileIdPages(String archiveFileId) {
		return archiveFileStoreMapper.countFileAttachmentByArchiveFileIdPages(archiveFileId);
	}

	@Override // 删除文件附件信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean deleteFileAttachment(String archiveFileId) {
		return archiveFileStoreMapper.deleteFileAttachment(archiveFileId) > 0;
	}

	@Override // 更新文件的信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateArchiveFileByArchiveFileId(SaveArchiveFileHelp saveArchiveFileHelp) {
		User user=HavingUserInfor.havingUser();
		logger.info("获取用户信息："+user);
		logger.info("文件保存之获取原文件信息");
		ArchiveFile oldArchiveFile=archiveFileStoreMapper.queryArchiveFileByArchiveFileId(saveArchiveFileHelp.getArchiveFileId());
		logger.info("旧文件信息为:"+oldArchiveFile);
		logger.info("保存文件的信息为："+saveArchiveFileHelp);
		logger.info("组装文件信息");
		ArchiveFile archiveFile=new ArchiveFile();
		archiveFile.setArchiveFileId(saveArchiveFileHelp.getArchiveFileId());//文件主键
		archiveFile.setArchiveFileAnual(saveArchiveFileHelp.getArchiveFileAnual());//年度
		archiveFile.setArchiveFileCreatetime(saveArchiveFileHelp.getArchiveFileCreatetime());//创建日期
		archiveFile.setArchiveFileResponsible(saveArchiveFileHelp.getArchiveFileResponsible());//责任人
		archiveFile.setArchiveFileReferenceNumber(saveArchiveFileHelp.getArchiveFileReferenceNumber());//文号
		archiveFile.setArchiveFileTitle(saveArchiveFileHelp.getArchiveFileTitle());//题名
		Integer count = archiveFileStoreMapper.countFileAttachmentByArchiveFileIdPages(saveArchiveFileHelp.getArchiveFileId());// 获取附件的总页数
		Integer meng = archiveFileStoreMapper.updateArchiveFilePages(saveArchiveFileHelp.getArchiveFileId(), count.toString());//更新文件表中数据
		Boolean result= archiveFileStoreMapper.updateArchiveFileByArchiveFileId(archiveFile) > 0;
		if(result) {
			logger.info("文件信息更新成功");
		}else {
			logger.info("文件信息更新失败");
			return false;
		}
		logger.info("重新标记首页");
		Boolean index=archiveFileStoreMapper.updateFileAttachmentStart(saveArchiveFileHelp.getArchiveFileId())>0;
		if(index) {
			logger.info("文件附件的状态更新成功");
		}else {
			logger.info("文件附件的状态更新失败");
			return false;
		}
		Boolean anu=archiveFileStoreMapper.updateFileAttachmentAnual(saveArchiveFileHelp.getArchiveFileId(), saveArchiveFileHelp.getArchiveFileAnual())>0;
		if(anu) {
			logger.info("文件附件的年度更新成功");
		}else {
			logger.info("文件附件的年度更新失败");
			return false;
		}
		Boolean m=archiveFileStoreMapper.updateFileAttachmentRemark(saveArchiveFileHelp.getRemark())>0;
		if(m) {
			logger.info("附件标记成功");
			
		}else {
			logger.info("附件标记失败");
			return false;
		}
		logger.info("文件保存之改变服务器文件夹");
		String pathname="D:/file/"+user.getArchive().getQuanzongNumber()+"/"+oldArchiveFile.getArchiveFileCreatetime()+"/"+oldArchiveFile.getArchiveFileTitle();
		logger.info("文件保存之获取文件的原路径"+pathname);
		String newPath="D:/file/"+user.getArchive().getQuanzongNumber()+"/"+saveArchiveFileHelp.getArchiveFileCreatetime()+"/"+saveArchiveFileHelp.getArchiveFileTitle();
		logger.info("文件保存之获取文件的新路径"+newPath);
		CopeFileTool copeFile=new CopeFileTool();
		logger.info("旧文件的日期:"+oldArchiveFile.getArchiveFileCreatetime()+"新文件的日期:"+saveArchiveFileHelp.getArchiveFileCreatetime());
		logger.info("旧文件的题名:"+oldArchiveFile.getArchiveFileTitle()+"新文件的题名:"+saveArchiveFileHelp.getArchiveFileTitle());
		if(saveArchiveFileHelp.getArchiveFileCreatetime().equals(oldArchiveFile.getArchiveFileCreatetime()) && saveArchiveFileHelp.getArchiveFileTitle()==oldArchiveFile.getArchiveFileTitle()) {
			logger.info("文件日期和题名未发生改变");
		}else if(saveArchiveFileHelp.getArchiveFileCreatetime().equals(oldArchiveFile.getArchiveFileCreatetime()) && !saveArchiveFileHelp.getArchiveFileTitle().equals(oldArchiveFile.getArchiveFileTitle())) {
			logger.info("文件的日期不变，题名发生改变");
			File file=new File(pathname);
			File newFile=new File(newPath);
			file.renameTo(newFile);
			if(newFile.exists()) {
				logger.info("文件保存之时间不变题名发生改变文件夹修改成功");
			}else {
				logger.info("文件保存之时间不变题名发生改变文件夹修改失败");
				return false;
			}
		}else{
			logger.info("文件保存之时间改变");
			logger.info("开始复制文件");
			File newFile=new File(newPath);
			if(!newFile.exists()) {
				newFile.mkdirs();
				logger.info("文件夹不存在创建文件夹"+newFile);
			}
			Boolean xBoolean=copeFile.copeFile(pathname, newPath, 30);
			if(xBoolean) {
				logger.info("文件保存之时间和题都发生改变文件保存成功");
			}else {
				logger.info("文件保存之时间和题都发生改变文件保存失败");
				return false;
			}
		}
		
		logger.info("更新文件附件表中的信息");
		if(saveArchiveFileHelp.getArchiveFileCreatetime().equals(oldArchiveFile.getArchiveFileCreatetime()) && saveArchiveFileHelp.getArchiveFileTitle().equals(oldArchiveFile.getArchiveFileTitle())) {
			logger.info("文件附件信息中文件所在位置未发生改变");
		}else {
			logger.info("文件附件信息中文件所在位置发生改变");
			List<FileAttachment> list = archiveFileStoreMapper.queryFileAttachmentByArchiveFileId(saveArchiveFileHelp.getArchiveFileId());
			logger.info("获取原文件信息：原文件附件的长度为"+list.size());
			for (FileAttachment fileAttachment : list) {
				fileAttachment.setFileAttachmentPath(newPath+"/"+fileAttachment.getFileAttachmentName());
			}
			Integer rem=archiveFileStoreMapper.updateFileAttachmentPath(list);
			if(rem==-1) {
				logger.info("文件附件信息中文件所在位置发生改变新文件信息更新成功");
			}else {
				logger.info("文件附件信息中文件所在位置发生改变新文件信息更新失败");
				return false;
			}
			
		}
		logger.info("文件保存之时间和题名都发生改变删除文件信息");
		if(!saveArchiveFileHelp.getArchiveFileCreatetime().equals(oldArchiveFile.getArchiveFileCreatetime())) {
			logger.info("文件时间改变");
			Boolean lock=false;
			Boolean x=copeFile.deleteFile(pathname);
			logger.info("删除题名文件夹");
			if(x) {
				logger.info("文件保存之时间和题都发生改变删除修文件信息旧文件夹信息删除成功");
				lock=true;
			}else {
				logger.info("文件保存之时间和题都发生改变删除修文件信息旧文件夹信息删除失败");
				lock= false;
			}
			logger.info("此日期下是否存在文件夹或者文件");
			String pathJudgemnt="D:/file/"+user.getArchive().getQuanzongNumber()+"/"+oldArchiveFile.getArchiveFileCreatetime();
			File fileJudgment=new File(pathJudgemnt);
			File[] files=fileJudgment.listFiles();
			if(files.length>0) {
				logger.info("此文件夹下存在文件不允许删除");
			}else {
				Boolean y=fileJudgment.delete();
				if(y) {
					logger.info("此文件夹下不存在文件删除文件夹");
					lock=true;
				}else {
					logger.info("文件删除成功");
					lock= false;
				}
			}
			return lock;
		}else {
			logger.info("文件夹不存在");
			return true;
		}
		
		
	}

	@Override // 添加文件附件信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean addFileAttachment(FileAttachment fileAttachment) {
		return archiveFileStoreMapper.addFileAttachment(fileAttachment) > 0;
	}

	@Override // 删除文件（假删除）
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean deleteArchiveFileByArchiveFileId(String archiveFileId) {
		User user=HavingUserInfor.havingUser();
		logger.info("监听到文件编辑中用户的信息为:"+user);
		ArchiveFile archiveFile=archiveFileStoreMapper.queryArchiveFileByArchiveFileId(archiveFileId);
		logger.info("文件的信息为:"+archiveFile);
		String path="D:/file/"+user.getArchive().getQuanzongNumber()+"/"+archiveFile.getArchiveFileCreatetime()+"/"+archiveFile.getArchiveFileTitle();
		CopeFileTool copeFileTool=new CopeFileTool();
		logger.info("删除文件的附件");
		List<FileAttachment> list=archiveFileStoreMapper.queryFileAttachmentByArchiveFileId(archiveFileId);
		logger.info("文件的路径为:"+path);
		Boolean nBoolean=copeFileTool.deleteFile(path);
		if(nBoolean) {
			logger.info("服务器文件删除成功");
		}else {
			logger.info("服务器文件删除失败");
			return false;
		}
		String pathX="D:/file/"+user.getArchive().getQuanzongNumber()+"/"+archiveFile.getArchiveFileCreatetime();
		File file=new File(pathX);
		File[] files=file.listFiles();
		if(files.length>0) {
			logger.info("此时间存在其他文件");
		}else {
			logger.info("此时间无文件存在删除文件夹");
			file.delete();
		}
		Boolean y=archiveFileStoreMapper.deleteArchiveFileByArchiveFileId(archiveFileId) > 0;
		if(y) {
			logger.info("文件删除成功");
		}else {
			logger.info("文件删除失败");
			return false;
		}
		Integer x=archiveFileStoreMapper.deleteFileAttachment(archiveFileId);
		if(x>0) {
			logger.info("文件附件删除成功");
			return true;
		}else {
			logger.info("文件附件删除失败");
			return false;
		}
	}

	@Override // 更新文件状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateArchiveFileStartByArchiveFileId(String archiveId,String annual) {
		return archiveFileStoreMapper.updateArchiveFileStartByArchiveFileId(archiveId,annual) > 0;
	}

	/**
	 * 获取全宗下全部文件的数量和页数
	 * 
	 * @return
	 */
	public ArchiveFileHelpInfor archiveFileHelpInfor(String archiveId) {
		ArchiveFileHelpInfor archiveFileHelpInfor = new ArchiveFileHelpInfor();
		archiveFileHelpInfor.setArchiveFileNumber(archiveFileStoreMapper.countFileNumberAllArchiveFile(archiveId));// 获取文件的总数
		archiveFileHelpInfor.setArchiveFilePage(archiveFileStoreMapper.countAllPageNumber(archiveId));// 获取文件的总页数
		return archiveFileHelpInfor;// 返回文件的数量信息
	}

	/**
	 * 获取全宗年度下全部文件的数量和页数
	 */
	public ArchiveFileHelpInfor archiveFileHelpInforAnual(String archiveId, String annual) {
		ArchiveFileHelpInfor archiveFileHelpInfor = new ArchiveFileHelpInfor();
		archiveFileHelpInfor.setArchiveFileNumber(archiveFileStoreMapper.countFileNumberArchiveFile(archiveId, annual));// 获取全宗文件下文件的
		archiveFileHelpInfor.setArchiveFilePage(archiveFileStoreMapper.countPageNumber(archiveId, annual));// 获取全宗年度下文件的页数
		return archiveFileHelpInfor;
	}

	/**
	 * 条件查询文件的数量和页数
	 */
	public ArchiveFileHelpInfor archiveFileHelpInforCondition(QueryArchiveFileCondition queryArchiveFileCondition) {
		ArchiveFileHelpInfor archiveFileHelpInfor = new ArchiveFileHelpInfor();
		archiveFileHelpInfor.setArchiveFileNumber(
				archiveFileStoreMapper.countArchiveFileNumberByCondition(queryArchiveFileCondition));
		archiveFileHelpInfor
				.setArchiveFilePage(archiveFileStoreMapper.countArchiveFilePagerByCondition(queryArchiveFileCondition));
		return archiveFileHelpInfor;
	}

	@Override // 更新文件状态
	public Boolean deleteFileAttachment(String archiveFileId, String fileAttachmentPageNumber) {
		Boolean result = false;
		FileAttachment fileAttachment = archiveFileStoreMapper.havingFileAttachment(archiveFileId,
				fileAttachmentPageNumber);// 获取文件附件信息
		logger.info("监听到当前文件附件的信息为:"+fileAttachment);
		List<FileAttachment> havingFileAttachmentList = archiveFileStoreMapper.havingFileAttachmentList(archiveFileId,
				fileAttachmentPageNumber);// 获取页码大于删除页码文件 附件的集合
		String pathAndName = fileAttachment.getFileAttachmentPath();//获取删除文件的路径
		File file = new File(pathAndName);
		file.delete();// 删除文件
		Boolean del = archiveFileStoreMapper.deleteOneFileAttachment(archiveFileId, fileAttachmentPageNumber) > 0;// 删除数据库中数据
		if (del) {
			for (FileAttachment at : havingFileAttachmentList) {// 遍历文件的集合更新文件的页码
				Integer index = Integer.parseInt(at.getFileAttachmentPageNumber());
				logger.info("监听到当前问文件附件的页码是:"+index);
				Integer end = (index - 1);
				String ftpn = end.toString();// 获取新的页码
				Boolean chang = archiveFileStoreMapper.updateFileAttachmentPageNumber(at.getFileAttachmentId(),
						ftpn) > 0;
				if (chang) {
					result = true;
				} else {
					result = false;
				}
			}
			Integer count = archiveFileStoreMapper.countFileAttachmentByArchiveFileIdPages(archiveFileId);// 获取附件的总页数
			Integer meng = archiveFileStoreMapper.updateArchiveFilePages(archiveFileId, count.toString());//更新文件表中数据
			if (meng > 0) {
				result = true;
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	@Override//根据文件主键更新文件状态
	public Boolean updateArchiveFileStartById(String str) {
		Boolean lock=false;
		String[] fileArchiveIds=str.split(",");
		for (String fileArchiveId : fileArchiveIds) {
			Integer re=archiveFileStoreMapper.updateArchiveFileStartById(fileArchiveId);
			if(re>0) {
				logger.info("根据文件主键文件状态更新成功");
				lock=true;
			}else {
				logger.info("根据文件主键文件状态更新失败");
				lock=false;
				break;
			}
		}
		return lock;
	}

	@Override//文件的重名校验
	public Boolean checkFile(String archiveFileId, String archiveFileReferenceNumber, String archiveFileTitle) {
		logger.info("文件保存之重名校验");
		logger.info("文件的主键："+archiveFileId+"文号:"+archiveFileReferenceNumber+"题名:"+archiveFileTitle);
		List<ArchiveFile> list=archiveFileStoreMapper.queryArchiveFile(archiveFileTitle, archiveFileReferenceNumber);
		logger.info("监听到文件的集合为："+list+"文件的长度为:"+list.size());
		if(list.size()==0) {
			logger.info("不存在同名文件");
			return true;
		}else {
			Boolean lock=false;
			for (ArchiveFile archiveFile : list) {
				logger.info("文件的信息为："+archiveFile);
				if(archiveFileId.equals(archiveFile.getArchiveFileId())) {
					logger.info("为同一个文件，允许修改");
					lock=true;
				}else{
					logger.info("存在相同题名或者文号的文件");
					lock=false;
					break;//停止循环
				}
			}
			return lock;
		}
	}

}
