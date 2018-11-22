package filemanage.collectandorganize.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.vo.BoxAuditHelp;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxVo;

/**
 * @author MLT
 *
 */
public interface FileAuditMapper {
	// =========================================初始化数据渲染===============================//

	/**
	 * 查询所有送审盒子相关文件
	 * @return 盒子的集合
	 */
	List<BoxVo> findAmcBox(Map<String,Object> map);

	/**
	 * 统计所有的盒子页面
	 * @return 盒子的数量
	 */
	Integer countBoxNum();

	/**
	 * 统计盒子文件的数量
	 * @return 文件的数量
	 */
	Integer countArchiveFileNum();

	/**
	 * 获取盒子拥有的全宗信息
	 * @return
	 */
	List<BoxAuditHelp> listArchiveInfo();

	/**
	 * 根据全宗主键获取审核的全部年度
	 * 
	 * @return
	 */
	List<BoxAuditHelp> listAnualByArchiveId(String archiveId);

	// =======================================================全宗年度渲染============================//
	/**
	 * 根据全宗主键和年度进行筛选
	 * @param anual  年度
	 * @param archiveId  全宗主键
	 * @return
	 */
	List<BoxVo> findAmcBoxAnualAndArchiveId(Map<String,Object> map);

	/**
	 * 根据全宗主键和年度统计文件盒子
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return
	 */
	Integer countBoxNumAnualAndArchiveId(@Param("anual") String anual, @Param("archiveId") String archiveId);

	/**
	 * 根据全宗主键和年度统计文件数量
	 * @param anual  年度
	 * @param archiveId  全宗主键
	 * @return
	 */
	Integer countArchiveFileNumAnualAndArchiveId(@Param("anual") String anual, @Param("archiveId") String archiveId);

	// ======================================================条件查询=========================================//
	/**
	 * 条件查询盒子信息
	 * @param boxByCondition  盒子信息：可能存在年度，全宗主键，条件
	 * @return
	 */
	List<BoxVo> findAmcBoxCondition(Map<String, Object> map);

	/**
	 * 统计盒子数量
	 * @param boxByCondition  盒子信息：可能存在年度，全宗主键，条件
	 * @return
	 */
	Integer countBoxNumCondition(BoxByCondition boxByCondition);

	/**
	 * 计算盒子文件数量
	 * @param boxByCondition  盒子信息：可能存在年度，全宗主键，条件
	 * @return
	 */
	Integer countArchiveFileNumCondition(BoxByCondition boxByCondition);

	// ================================================================功能==================================//
	/**
	 * 验收合格
	 * @param anual  年度
	 * @param archiveId  全宗主键
	 * @return
	 */
	Integer updateGood(@Param("anual") String anual, @Param("archiveId") String archiveId);

	/**
	 * 驳回重整
	 * @param anual  年度
	 * @param archiveId  全宗主键
	 * @return
	 */
	Integer updateBad(@Param("anual") String anual, @Param("archiveId") String archiveId);

	/**
	 * 添加驳回情况表
	 * @param returnInfoBox  驳回情况
	 * @return
	 */
	Integer addReturnFor(ReturnInfoBox returnInfoBox);
	
	/**
	 * 根据盒主键查询驳回情况表是否有信息	
	 * @param boxVo
	 * @return
	 */
	Integer queryReturnFor(String boxId);

	/**
	 * 更新驳回情况
	 * @param returnInfoId
	 * @return
	 */
	Integer updateReturnFor(@Param("returnInfoReson") String returnInfoReson,
			@Param("returnInfoId") String returnInfoId);

}
