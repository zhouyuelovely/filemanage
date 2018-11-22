package filemanage.collectandorganize.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.TemporaryFile;
import filemanage.login.pojo.User;
import filemanage.utils.page.PageBean;

public interface FileScanningService {

	/**
	 * 档案扫描上传图片
	 * 
	 * @param files
	 * @param user
	 * @param quanzongId
	 * @return
	 */
	String uploadjpg(MultipartFile[] files, User user, String quanzongId) throws Exception;

	/**
	 * 图片分页并展示到页面
	 * 
	 * @param string
	 * @param currentPage
	 * @return
	 */
	PageBean<TemporaryFile> getImgList(String userIdNumber, Integer currentPage) throws Exception;

	/**
	 * 根据路径删除图片记录
	 * 
	 * @param temporaryAccessaryPath
	 * @return
	 */
	Integer deleteImgByPath(String temporaryAccessaryPath, String temporaryAccessaryPageNumber) throws Exception;

	/**
	 * 添加封面信息
	 * 
	 * @param archiveFile
	 * @return
	 */
	Integer addCoverInfo(ArchiveFile archiveFile, String temporaryAccessaryPath, User user) throws Exception;

	/**
	 * 统计图片数量
	 * 
	 * @param userIdNumber
	 * @return
	 * @throws Exception
	 */
	Integer countImgPath(String userIdNumber) throws Exception;

	/**
	 * 根据身份证号生成
	 * 
	 * @param userIdNumber
	 * @return
	 */
	Integer countPage(String userIdNumber) throws Exception;
	
}
