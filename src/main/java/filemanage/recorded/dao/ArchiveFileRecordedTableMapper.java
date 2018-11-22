package filemanage.recorded.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.recorded.vo.RecodedTableSelect;
import filemanage.systemmanage.pojo.AmCoBox;

@Repository
public interface ArchiveFileRecordedTableMapper {
	/**
	 * 根据全宗查询一级分类
	 * @param quanzongId 全宗主键
	 * @return
	 */
	List<RecodedTableSelect> findSelectPc(String quanzongId);
	/**
	 * 获取年度
	 * @param map 全宗和一级分类
	 * @return
	 */
	List<String> findSelectAnual(String quanzongId);
	/**
	 * 著录列表
	 * @param map 分页信息 全宗
	 * @return
	 */
	List<AmCoBox> findAmCoBoxByQuanzongId(Map<String, Object> map);
	/**
	 * 统计数量
	 * @param quanzongId 全宗主键
	 * @return
	 */
	Integer countAmCoBoxByQuanzongId(String quanzongId);
	/**
	 * 统计盒内文件
	 * @param quanzongId
	 * @return
	 */
	Integer countFileAmCoBoxByQuanzongId(String quanzongId);
	/**
	 * select 著录列表
	 * @param map 分页， select信息 全宗
	 * @return
	 */
	List<AmCoBox> findAmCoBoxBySelect(Map<String, Object> map);
	/**
	 * select 统计数量
	 * @param map 条件 全宗
	 * @return
	 */
	Integer countAmCoBoxBySelect(Map<String, Object> map);
	/**
	 * 统计盒内文件
	 * @param quanzongId
	 * @return
	 */
	Integer countFileAmCoBoxBySelect(Map<String, Object> map);
	/**
	 * 条件查询
	 * @param map 分页信息，条件 全宗
	 * @return 
	 */
	List<AmCoBox> findAmCoBoxByCondition(Map<String, Object> map);
	/**
	 * 条件统计数量
	 * @param map 全宗 条件
	 * @return
	 */
	Integer countAmCoBoxByCondition(Map<String, Object> map);
	/**
	 * 条件统计文件数量
	 * @param map
	 * @return
	 */
	Integer countFileAmCoBoxByCondition(Map<String, Object> map);
	/**
	 * 盒子下文件附件的路径
	 * @param boxId 盒子主键
	 * @return
	 */
	List<String> havingFileAttachByBoxId(String boxId);
	/**
	 * 删除文件附件
	 * @param boxId 盒号
	 * @return
	 */
	Boolean deleteFileAttachByBoxId(String boxId);
	/**
	 * 删除文件
	 * @param boxId
	 * @return
	 */
	Boolean deleteFileByBoxId(String boxId);
	/**
	 * 盒子下所有盒子附件的地址
	 * @param boxId
	 * @return
	 */
	AmCoBoxattachment havingBoxAttachByBoxId(String boxId);
	/**
	 * 删除盒子附件
	 * @param boxId
	 * @return
	 */
	Boolean deleteBoxAttachByBoxId(String boxId);
	/**
	 * 删除盒子
	 * @param boxId
	 * @return
	 */
	Boolean deleteBoxByBoxId(String boxId);
	/**
	 * 提交进馆状态变为验收合格
	 * @param str
	 * @return
	 */
	Boolean updateBoxStart(Map<String, Object> map);
}
