package filemanage.collectandorganize.service;

import java.util.List;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxHavingRetentionperiodHelp;
import filemanage.collectandorganize.vo.BoxSubmitReviewAnualHelp;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

public interface BoxSubmitReviewService {
	//========================================初始页面渲染=======================================//
	/**
	 * 获取全宗下所有的盒子
	 * @param archiveId
	 * @return
	 */
	Layui findAllAmcBox(String archiveId,Integer limit,Integer page);
	/**
	 * 统计全宗下盒子的数量
	 * @param archiveId 全宗主键
	 * @return 盒子数量
	 */
	Integer countAllAmcBoxNum(String archiveId);
	/**
	 * 统计全宗盒子中文件数量 
	 * @param archiveId 全宗主键 
	 * @return 文件数量
	 */
	Integer countAmcBoxArchiveFile(String archiveId);
	/**
	 * 获取全宗下盒子所有的年度
	 * @param archiveId 全宗主键
	 * @return 年度集合
	 */
	List<BoxSubmitReviewAnualHelp> countArchiveFileSubmitReviewAnual(String archiveId);
	/**
	 * 获取盒子页面信息
	 * @param archiveId 全宗主键
	 * @return 盒子的数量和文件数量
	 */
	HavingInforBox havingAllAllAmcBoxByAnual(String archiveId);
	
	
	//========================================年度数据=======================================//
	/**
	 * 查询全宗年度下盒子信息
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @return 盒子信息
	 */
	Layui queryAllAllAmcBoxByAnual(String archiveId,String anual,Integer limit,Integer page);
	/**
	 * 获取盒子页面信息
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @return 盒子的数量和文件数量
	 */
	HavingInforBox reloadAmcBoxByAnual(String archiveId,String anual);
	//==============================================年度和保管期限==================================//
	/**
	 * 获取盒子信息
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @param limit 分页数据
	 * @param page 当前页数
	 * @param Retentionperoids 保管期限的主键
	 * @return
	 */
	Layui queryAllAllAmcBoxByAnualAndRetentionperoid(String archiveId,String anual,Integer limit,Integer page,String retentionperoids);
	/**
	 * 获取盒子页面的信息
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @param Retentionperoids 保管期限主键
	 * @return
	 */
	HavingInforBox reloadAmcBoxByAnualAndRetentionperoid(String archiveId,String anual,String retentionperoids);
	//==============================================条件查询=======================================//
	/**
	 * 条件查询盒子信息
	 * @param boxByCondition 包括：全宗 可能包括：年度，条件
	 * @return 组装盒子信息
	 */
	Layui queryAllAllAmcBoxByCondition(BoxByCondition boxByCondition,Integer limit,Integer page);
	/**
	 * 获取盒页面信息
	 * @param boxByCondition 包括：全宗 可能包括：年度，条件
	 * @return 盒子的数量和文件数量
	 */
	HavingInforBox reloadAmcBoxByCondition(BoxByCondition boxByCondition);
	
	//============================================功能===============================================//
	/**
	 * 盒子送审
	 * @param str 保管期限主键
	 * @return 更新是否成功
	 */
	Boolean updateSubmitRrview(String[] str,String anual,User user);
	/**
	 * 驳回重整
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @param custody 保管期限
	 * @return
	 */
	Boolean reorganize(String archiveId,String anual,String custody);
	
	/**
	 * 根据年度和全宗号导出档案(压缩包)
	 * @param amCoBoxattachment
	 * @return
	 */
	List<String> findBoxPathList(String boxYear,String retentionperiodid)throws Exception;
	
	/**
	 *根据盒子主键查询盒子附件信息
	 * @param boxId
	 * @return
	 */
	AmCoBoxattachment queryAmCoBoxattachment(String boxId);
	/**
	 * 根据盒主键查询文件信息
	 * @param boxId 盒子主键 
	 * @return 文件信息
	 */
	Layui queryArchiveFileByBoxId(String boxId,Integer limit,Integer page);
	/**
	 * 根据盒子主键查询文件的相关信息
	 * @param boxId 盒子主键
	 * @return
	 */
	PageBean<FileAttachment> queryFileAttachmentByBoxId(String boxId,int currPage);
	/**
	 * 根据文件的主键查询单个文件的附件信息
	 * @param archiveFileId 文件的主键
	 * @return 单个文件的详情信息（附件信息）
	 */
	List<FileAttachment> queryFileAttachmentByArchiveFileId(String archiveFileId);
	/**
	 * 根据盒子主键查询盒子信息
	 * @param boxId 盒子主键
	 * @return 盒子信息
	 */
	AmCoBox queryAmCoBoxByBoxId(String boxId);
	//==============================================================驳回情况表======================================//
	/**
	 * 根据全宗主键和年度查询驳回情况表
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @return 数据组装
	 */
	Layui returnInfor(String archiveId,String anual,Integer limit,Integer page);
	/**
	 * 获取盒子年度下有的保管期限
	 * @param archiveId 全宗主键
	 * @param anual 年度
	 * @return
	 */
	List<BoxHavingRetentionperiodHelp> havingRetentionperiod(String archiveId,String anual);
}
