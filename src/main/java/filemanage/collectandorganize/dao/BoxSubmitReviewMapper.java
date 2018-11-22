package filemanage.collectandorganize.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxHavingRetentionperiodHelp;
import filemanage.collectandorganize.vo.BoxSubmitReview;
import filemanage.collectandorganize.vo.BoxSubmitReviewAnualHelp;
import filemanage.systemmanage.pojo.AmCoBox;
@Repository("boxSubmitReviewMapper")
public interface BoxSubmitReviewMapper {
	//=========================================送审初始化页面----------------------------------------//
		/**
		 *查询全宗下所有的盒子信息
		 * @param archiveId 全宗主键
		 * @return 盒子合集
		 */
		List<AmCoBox> findAllAmcBox(Map<String, Object> map);
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
		
		
		//-------------------------------------------年度筛选---------------------------------------//
		/**
		 * 查询全宗年度下盒子信息
		 * @param archiveId 全宗主键
		 * @param anual 年度
		 * @return 盒子信息
		 */
		List<AmCoBox> queryAllAllAmcBoxByAnual(Map<String, Object> map);
		/**
		 * 获取年度下所有的盒子信息，驳回所有的文件
		 * @return
		 */
		List<AmCoBox> queryAllAllAmcBoxByAnualTurnDown(@Param("archiveId")String archiveId,@Param("anual")String anual,@Param("custody")String custody);
		/**
		 * 统计全宗年度盒子数量
		 * @param archiveId 全宗主键
		 * @param anual 年度
		 * @return 盒子数量
		 */
		Integer countAllAllAmcBoxByAnual(@Param("archiveId")String archiveId,@Param("anual")String anual);
		/**
		 * 统计全宗年度盒子文件数量
		 * @param archiveId 全宗主键
		 * @param anual 年度
		 * @return 文件数量
		 */
		Integer countAmcBoxArchiveFileByAnual(@Param("archiveId")String archiveId,@Param("anual")String anual);
		//-----------------------------------------------年度和保管期限------------------------------//
		/**
		 * 查询盒子的信息
		 * @param map 全宗主键 盒子年度 保管期限主键
		 * @return
		 */
		List<AmCoBox> queryAllAllAmcBoxByAnualAndRetentionperoids(Map<String, Object> map);
		/**
		 * 查询盒子信息
		 * @param map 全宗主键  盒子年度 保管期限主键
		 * @return
		 */
		Integer countcountAllAllAmcBoxByAnualAndRetentionperoids(Map<String, Object> map);
		/**
		 * 查询盒子信息
		 * @param map 全宗主键  盒子年度 保管期限主键
		 * @return
		 */
		Integer countAmcBoxArchiveFileByAnualAndRetentionperoids(Map<String, Object> map);
		
		//---------------------------------------------条件查询------------------------------------//
		/**
		 * 条件查询盒子信息
		 * @param boxByCondition 包括：全宗 可能包括：年度，条件
		 * @return 盒子信息
		 */
		List<AmCoBox> queryAllAllAmcBoxByCondition(Map<String, Object> map);
		/**
		 * 条件统计盒子数量
		 * @param boxByCondition 包括：全宗 可能包括：年度，条件
		 * @return 盒子数量
		 */
		Integer countAllAllAmcBoxByCondition(BoxByCondition boxByCondition);
		/**
		 * 条件统计盒子文件数量
		 * @param boxByCondition 包括：全宗 可能包括：年度，条件
		 * @return 文件数量
		 */
		Integer countAmcBoxArchiveFileByCondition(BoxByCondition boxByCondition);
		
		//-------------------------------------------------功能模块--------------------------------------//
		/**
		 *提交验收更新 文件状态
		 * @param boxSubmitReview 更新的类别 可能存在，永久 三十年 永久和三十年
	 	 * @return 更新是否成功
		 */
		Integer updateSubmitRrview(BoxSubmitReview boxSubmitReview);
		/**
		 * 查询盒子的集合
		 * @param boxSubmitReview 更新的类别 可能存在，永久 三十年 永久和三十年
		 * @return
		 */
		List<AmCoBox> queryAmCoBox(BoxSubmitReview boxSubmitReview);
		/**
		 * 更新文件附件的备考表信息
		 * @param boxattachmentForm 备考表信息
		 * @param boxattachmentId 附件主键
		 * @return
		 */
		Integer updateBoxattachmentForm(@Param("boxattachmentForm")String boxattachmentForm,@Param("boxattachmentId")String boxattachmentId);
		/**
		 * 驳回重整 删除盒子信息
		 * @param archiveId  
		 * @param anual
		 * @return 删除是否成功
		 */
		Integer deleteAmcBox(@Param("archiveId")String archiveId,@Param("anual")String anual,@Param("custody")String custody);
		/**
		 * 更新文件状态 重新整理
		 * @param boxid 盒子的主键
		 * @return 更新是否成功
		 */
		Integer updateArchiveFileBoxStart(String boxId);
		/**
		 * 根据盒子主键删除盒子附件信息
		 * @param boxId
		 * @return
		 */
		Integer deleteBoxAttachment(String boxId);
		
		
		//------------------------------------------------------------盒子信息查看------------------------------------------//
		/**
		 * 根据盒子主键查询盒子信息
		 * @param boxId 盒子主键
		 * @return 盒子信息
		 */
		AmCoBox queryAmCoBoxByBoxId(String boxId);
		
		/**
		 * 根据年度和全宗号查询盒附件路径集合
		 * @param amCoBoxattachment
		 * @return
		 * @throws Exception
		 */
		List<AmCoBoxattachment> findBoxPathList(AmCoBoxattachment amCoBoxattachment) throws Exception;
		/**
		 *获取年度下盒子拥有的保管期限
		 * @param archiveId 全宗主键
		 * @param anual 年度
		 * @return
		 */
		List<BoxHavingRetentionperiodHelp> havingRetentionperiod(@Param("archiveId")String archiveId,@Param("anual")String anual);
}
