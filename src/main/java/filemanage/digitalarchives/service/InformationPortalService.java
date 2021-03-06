package filemanage.digitalarchives.service;

import java.util.List;

import filemanage.digitalarchives.pojo.InformationPortal;
import filemanage.digitalarchives.pojo.Picturecarousel;
import filemanage.digitalarchives.vo.QueryInforByConditions;
import filemanage.utils.layui.Layui;

/**
 * @author tchuanwu
 * 档案信息门户业务层接口
 */
public interface InformationPortalService {
	/**
	 * 查询所有的已发布信息
	 * @return
	 */
	List<InformationPortal> queryAllInformation(int before,int after);
	
	/**
	 * 统计所有已发布信息的数量
	 * @return
	 */
	Integer countAllInformation();
	
	/**
	 * 根据发布日期降序排序查询最新的7条数据
	 * @return
	 */
	List<InformationPortal> queryInfomationByTime();
	/**
	 * 根据主键查询信息
	 * @param IPId
	 * @return
	 */
	InformationPortal queryInformationById(String IPId);
	/**
	 * 添加信息
	 * @param information
	 * @return
	 */
	Integer addInformationPortal(InformationPortal information);
	
	/**
	 * 定时任务30天过后自动删除信息
	 * @param IPId
	 * @return
	 */
	Boolean deleteInfomationPortal();
	
	/**
	 * 根据索引号查询该信息索引号是否已存在
	 * >=0 已存在  <0 不存在
	 * @param information
	 * @return
	 */
	int isExitInformationIndexNum(InformationPortal information);
	/**
	 * 根据文号查询该信息文号是否已存在
	 * >=0 已存在  <0 不存在
	 * @param information
	 * @return
	 */
	int isExitInformationDocumentNum(InformationPortal information);
	
	/**
	 * 查询所有的信息类型
	 * @return
	 */
	List<InformationPortal> queryAllInformationType();
	
	/**
	 * 关键词条件查询信息
	 * @param conditions
	 * @return
	 */
	List<InformationPortal> queryInforByConditions(QueryInforByConditions conditions);
	
	/**
	 * 关键词查询条数
	 * @param conditions
	 * @return
	 */
	int countQueryInforByConditions(QueryInforByConditions conditions);
	
	
	/**
	 * 图片发布轮播
	 * @param picturecarousel
	 * @return
	 */
	int addPicturecarousel(Picturecarousel picturecarousel);
	
	/**
	 * 轮播图片路径集合
	 * @return
	 */
	List<Picturecarousel> queryAllPicture();
	
	/**
	 * 统计轮播图片条数
	 * @return
	 */
	Integer countAllPic();
	/**
	 * 删除文件
	 * @return
	 */
	Boolean deleteAllFile();

	void deletePictureCarousel();
	

}
