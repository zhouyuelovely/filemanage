package filemanage.collectandorganize.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;

import filemanage.collectandorganize.dao.FileScanningMapper;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.pojo.TemporaryFile;
import filemanage.collectandorganize.service.FileScanningService;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.page.PageBean;
import filemanage.utils.paperbuild.CopyFile;
import filemanage.utils.paperbuild.CreateTemporaryPathUtil;

/**
 * @author FYX
 *
 */
@Service("fileScanningService")
public class FileScanningServiceImpl implements FileScanningService {

	Logger log = Logger.getLogger(FileScanningServiceImpl.class);

	@Autowired
	private FileScanningMapper fileScanningMapper;

	/**
	 * 扫描上传图片
	 */
	@Override
	public String uploadjpg(MultipartFile[] files, User user, String quanzongId) throws Exception {
		if (user.getUserIdNumber() != null && quanzongId != null) {
			if (null != files) {
				if (files.length == 0) {
					log.info("图片未上传");
				} else {
					Integer num = fileScanningMapper.countImgPath(user.getUserIdNumber());
					log.info("图片数量: " + files.length);
					// 循环获取file数组中得文件
					for (int i = 0; i < files.length; i++) {
						MultipartFile file = files[i];
						// 保存文件
						log.info("准备保存第" + String.valueOf(i + 1) + "个图片");
						// 上传图片到服务器上
						log.info("获取到用户信息为:" + user + "文件信息为" + file + "获取请求");
						uploadImage(file, user);
						// 保存图片信息到数据库
						if (num > 0) {
							saveImageInfo(file, user, String.valueOf(num + i + 1));
						} else {
							saveImageInfo(file, user, String.valueOf(i + 1));
						}
					}
					return "{status:true}";
				}
			} else {
				throw new Exception("图片files为null---" + files);
			}
		} else {
			throw new Exception("没有拿到用户信息,用户session作用域失效或者用户数据不存在!");
		}
		return "{status:false}";
	}

	/**
	 * 上传图片到服务器上
	 * 
	 * @param file
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean uploadImage(MultipartFile file, User user) throws Exception {
		// 判断文件是否为空
		if (user != null) {
			if (!file.isEmpty()) {
				try {
					// 转存文件
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
							CreateTemporaryPathUtil.createTemporaryDirectory(user), file.getOriginalFilename()));
					log.info("--------图片存储到:" + CreateTemporaryPathUtil.createTemporaryDirectory(user));
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();
				}
			} else {
				log.error("文件信息为空" + file);
			}
		} else {
			log.error("获取user信息失败" + user);
		}
		return false;
	}

	/**
	 * 保存图片信息到文件临时表中
	 * 
	 * @param file
	 * @param user
	 * @param temporaryAccessaryPageNumber
	 * @return
	 * @throws Exception
	 */
	public Integer saveImageInfo(MultipartFile file, User user, String temporaryAccessaryPageNumber) throws Exception {
		Integer num = null;
		List<TemporaryFile> list = new ArrayList<TemporaryFile>();
		String temporaryAccessaryPath = CreateTemporaryPathUtil.createTemporaryDirectory(user) + "/"
				+ file.getOriginalFilename();
		TemporaryFile temporaryFile = new TemporaryFile();
		temporaryFile.setTemporaryAccessaryUserIdNumber(user.getUserIdNumber());
		temporaryFile.setQuanzongId(user.getArchive().getQuanzongId());
		temporaryFile.setTemporaryAccessaryPageNumber(temporaryAccessaryPageNumber);
		temporaryFile.setTemporaryAccessaryName(file.getOriginalFilename());
		temporaryFile.setTemporaryAccessaryPath(temporaryAccessaryPath);
		list.add(temporaryFile);
		if (list.size() > 0) {
			num = fileScanningMapper.saveImageInfo(list);
			if (num > 0) {
				log.info("成功保存图片信息到文件临时表中!");
			} else {
				log.info("保存图片信息失败,请检查传参!");
			}
		}
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PageBean<TemporaryFile> getImgList(String userIdNumber, Integer currentPage) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<TemporaryFile> pageBean = new PageBean<TemporaryFile>();
		// 每页显示的数据
		int pageSize = 14;
		pageBean.setPageSize(pageSize);

		pageBean.setCurrPage(currentPage);
		log.info("临时文件当前页数是:" + currentPage);
		// 根据扫描人身份证号统计图片路径数量
		int totalCount = fileScanningMapper.countImgPath(userIdNumber);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("temporaryAccessaryUserIdNumber", userIdNumber);
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<TemporaryFile> lists = fileScanningMapper.listImgPath(map);
		for (TemporaryFile temporaryFile : lists) {
			temporaryFile.setTemporaryAccessaryPath(
					temporaryFile.getTemporaryAccessaryPath().replaceAll("D:/file", "/resource"));
		}
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer deleteImgByPath(String temporaryAccessaryPath, String temporaryAccessaryPageNumber)
			throws Exception {
		Integer num = null;
		String quanzongId = HavingUserInfor.havingArchiveId();
		if (!StringUtils.isEmpty(temporaryAccessaryPath)) {
			String ftp = temporaryAccessaryPath.substring(temporaryAccessaryPath.indexOf("/resource"),
					temporaryAccessaryPath.length());
			String path = ftp.replace("/resource", "D:/file");
			log.info("业务层临时图片path:" + path);
			num = fileScanningMapper.deleteImgByPath(path);
			if (num > 0) {
				File file = new File(path);
				if (file.exists()) {
					file.delete();
					log.info("删除图片文件路径:" + path);
				} else {
					log.error("删除文件失败，请检查图片是否存在以及传参是否正确！");
				}
				List<TemporaryFile> pageNumberList = fileScanningMapper.getPageNumberList(quanzongId,
						temporaryAccessaryPageNumber);// 获取页码大于删除页码文件 附件的集合
				for (TemporaryFile temporaryFile : pageNumberList) {
					Integer index = Integer.parseInt(temporaryFile.getTemporaryAccessaryPageNumber());
					Integer end = (index - 1);
					String newPageNumber = end.toString();// 获取新的页码
					Boolean result = fileScanningMapper
							.updateTemporaryFilePageNumber(temporaryFile.getTemporaryAccessaryId(), newPageNumber) > 0;
					if (result) {
						log.info("更新页码成功!");
					} else {
						log.info("更新页码失败!");
					}
				}
			}
		} else {
			throw new Exception("图片参数为空!");
		}
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer addCoverInfo(ArchiveFile archiveFile, String temporaryAccessaryPath, User user) throws Exception {
		Integer num = null;
		// 图片路径
		String temPath = temporaryAccessaryPath
				.substring(temporaryAccessaryPath.indexOf("/resource"), temporaryAccessaryPath.length())
				.replace("/resource", "D:/file");
		log.info("");
		Integer in = fileScanningMapper.queryByCondition(archiveFile);
		if (in > 0) {
			num = 1;// 文号已存在，表单信息添加失败！
			log.info("文号或者题名已存在，表单信息添加失败!" + in);
		} else {
			if (StringUtils.isEmpty(archiveFile.getArchiveFileReferenceNumber())) {
				archiveFile.setArchiveFileReferenceNumber("-");
			}
			Boolean result = fileScanningMapper.addCoverInfo(archiveFile);
			if (result) {
				num = 2;// 表单信息添加成功！
				Boolean bool = fileScanningMapper.tagPageByImgPath(temPath) > 0;
				if (bool) {
					log.info("标记首页成功!");
				} else {
					throw new Exception("标记首页失败--bool=" + bool + "temPath=" + temPath);
				}
				log.info("开始图片数据迁移......");
				Integer inte = transferData(temPath, archiveFile, user);
				if (inte > 0) {
					log.info("迁移数据到文件附件表中成功!");
				} else {
					/* log.error("迁移数据到文件附件表中失败,请检查是否成功获取临时文件参数集合!"); */
					throw new Exception(
							"迁移数据到文件附件表中失败,temPath=" + temPath + "--archiveFile=" + archiveFile + "--user=" + user);
				}
			} else {
				num = 3;// 表单信息添加失败！
				/*
				 * Integer delTemporaryNo = fileScanningMapper.deleteTemporaryByquanzongId(user.getArchive().getQuanzongId());
				   if (delTemporaryNo > 0) { log.info("保存文件信息失败后,删除临时文件信息成功!"); }
				   else {
				 * log.error("保存文件信息失败后,删除临时文件信息失败!"); } String filePath = "D:/file/" +
				 * user.getArchive().getQuanzongNumber().trim() + "/" +
				 * user.getUserName().trim() + "/" + user.getUserIdNumber().trim(); Boolean
				 * boolean1 = DeleteDirectory.DeleteFolder(filePath); if (boolean1) {
				 * log.info("保存文件信息失败后,删除文件及目录删除成功!" + boolean1); } else {
				 * log.error("保存文件信息失败后,删除文件及目录删除失败!"); }
				 */
			}
		}
		return num;
	}

	private Integer transferData(String temporaryAccessaryPath, ArchiveFile archiveFile, User user) throws Exception {
		// user.getArchive().getQuanzongNumber();>>>>>>"021"
		String ftp = "D:/file/" + user.getArchive().getQuanzongNumber().trim() + "/"
				+ archiveFile.getArchiveFileCreatetime().trim() + "/" + archiveFile.getArchiveFileTitle().trim();
		String oldPath = "D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\" + user.getUserName() + "\\"
				+ user.getUserIdNumber();
		Integer num = null;
		// user.getUserIdNumber()//320111199812215811
		// 根据用户身份证号查询临时文件信息
		List<TemporaryFile> temporaryFileList = fileScanningMapper
				.queryTemporaryFileInfoByUserIdNumber(user.getUserIdNumber());
		log.info("临时文件信息集合:" + temporaryFileList);
		List<FileAttachment> list = new ArrayList<FileAttachment>();
		if (temporaryFileList.size() > 0) {
			// 根据题名查询文件表主键
			ArchiveFile archiveFile2 = fileScanningMapper
					.queryArchiveFileIdByArchiveFileTitle(archiveFile.getArchiveFileTitle());
			log.info("文件表参数:" + archiveFile2);
			if (archiveFile2 != null) {
				FileAttachment fileAttachment = null;
				for (TemporaryFile temporaryFile : temporaryFileList) {
					fileAttachment = new FileAttachment();
					String fileAttachmentPath = ftp + "/" + temporaryFile.getTemporaryAccessaryName();
					fileAttachment.setArchiveFileId(archiveFile2.getArchiveFileId());// 文件主键
					fileAttachment.setFileAttachmentAnual(archiveFile2.getArchiveFileAnual());// 文件年度
					fileAttachment.setFileAttachmentMark(temporaryFile.getTemporaryAccessarySign());// 标记1：封面
					fileAttachment.setFileAttachmentName(temporaryFile.getTemporaryAccessaryName());// 附件名称
					fileAttachment.setFileAttachmentPageNumber(temporaryFile.getTemporaryAccessaryPageNumber());// 页码
					fileAttachment.setFileAttachmentPath(fileAttachmentPath);// 附件地址
					fileAttachment.setQuanzongId(temporaryFile.getQuanzongId());// 全宗主键
					fileAttachment.setFileCreator(user.getUserName());// 创建人 user.getUserName();//张菜菜
					// 往文件附件表插入信息
					list.add(fileAttachment);
				}
				num = fileScanningMapper.addFileAttachmentInfo(list);
				if (num > 0) {// user.getQuanzongId()//5623388e4a804a498c26f7ea5375c469
					log.info("保存封面信息成功：" + num);
					// 根据全宗主键删除数据
					Integer no = fileScanningMapper.deleteTemporaryByquanzongId(user.getArchive().getQuanzongId());
					String secondaryFile = "D:/file/" + user.getArchive().getQuanzongNumber().trim() + "/"
							+ archiveFile.getArchiveFileCreatetime().trim();
					File secondFileName = new File(secondaryFile);
					if (no > 0) {
						log.info("删除数据成功：" + no);
						// TransferPictures.transferImagesFromOneFolderToAnother(sourcePath,targetPath);
						// 想命名的原文件夹的路径
						if (!secondFileName.exists()) {
							File file1 = new File(
									"D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\" + user.getUserName());
							// 将原文件夹名为用户名更改为文件日期，其中路径是必要的,注意
							file1.renameTo(new File("D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\"
									+ archiveFile.getArchiveFileCreatetime()));
							File fileSecondary = new File("D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\"
									+ archiveFile.getArchiveFileCreatetime());
							Boolean secondaryTrue = fileSecondary.exists();
							if (secondaryTrue) {
								log.info("二级文件夹重命名成功!");
							} else {
								log.error("二级文件夹重命名失败!");
							}

							// 想命名的原文件夹的路径
							File file2 = new File("D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\"
									+ archiveFile.getArchiveFileCreatetime() + "\\" + user.getUserIdNumber());
							log.info("修改文件路径" + file2);
							// 将原文件夹名为用户身份证号更改为文件题名，其中路径是必要的,注意
							file2.renameTo(new File("D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\"
									+ archiveFile.getArchiveFileCreatetime() + "\\"
									+ archiveFile.getArchiveFileTitle()));
							File fileThird = new File("D:\\file\\" + user.getArchive().getQuanzongNumber() + "\\"
									+ archiveFile.getArchiveFileCreatetime() + "\\"
									+ archiveFile.getArchiveFileTitle());
							Boolean thirdTrue = fileThird.exists();
							if (thirdTrue) {
								log.info("三级目录重命名成功!");
							} else {
								log.error("三级目录重命名失败!");
							}
						} else {
							log.info("开启20个线程，复制文件......");
							File thirdFile = new File(ftp);
							if (!thirdFile.exists()) {// 三级文件夹不存在
								thirdFile.mkdirs();// 创建三级文件夹
								log.info("创建三级文件夹成功！");
								Boolean rBoolean = new CopyFile().copyFile(oldPath, ftp, 20);
								if (rBoolean) {
									log.info("文件附件复制成功!");
								}
							}
						}
						
					} else {
						log.error("删除临时表数据失败,系统异常!" + no);
					}
					if(secondFileName.exists()&&new File(oldPath).exists()) {
						new CopyFile().deleteFile(oldPath);
					}
				} else {
					log.error("文件表数据插入失败,请检查传参是否正确!");
				}
			} else {
				log.error("获取题名查询文件信息失败!" + archiveFile2);
			}
		} else {
			log.error("根据用户身份证号获取临时文件表信息失败!" + temporaryFileList);
		}
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countImgPath(String userIdNumber) throws Exception {
		return fileScanningMapper.countImgPath(userIdNumber);
	}

	@Override
	public Integer countPage(String userIdNumber) throws Exception {

		return fileScanningMapper.countPage(userIdNumber);
	}
}
