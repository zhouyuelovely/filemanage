package filemanage.inventoryandinquire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.inventoryandinquire.vo.BoxConditionVo;
import filemanage.inventoryandinquire.vo.BoxExtendVo;
import filemanage.inventoryandinquire.vo.FileConditionVo;
import filemanage.inventoryandinquire.vo.FileExtendVo;
import filemanage.inventoryandinquire.vo.HistoryDataConditionVo;
import filemanage.inventoryandinquire.vo.HistoryDataExtendVo;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;

@Repository("fileQueryMapper")
public interface FileQueryMapper {

	/**
	 * 查询所有盒子信息
	 * 
	 * @param map
	 * @return
	 */
	List<BoxExtendVo> queryBoxList(Map<String, Object> map) throws Exception;

	/**
	 * 按条件查询盒子信息
	 * 
	 * @param map
	 * @return
	 */
	List<BoxExtendVo> queryBoxListByCondition(Map<String, Object> map) throws Exception;

	/**
	 * 统计盒子数量
	 * 
	 * @return
	 */
	Integer countBoxNum() throws Exception;

	/**
	 * 统计件数之和
	 * 
	 * @return
	 */
	Integer countBoxFileCasesNumber() throws Exception;

	/**
	 * 根据条件统计盒子数量
	 * 
	 * @param boxConditionVo
	 * @return
	 */
	Integer countBoxListByCondition(BoxConditionVo boxConditionVo) throws Exception;
	/**
	 * 按条件统计所有件
	 * @param boxConditionVo
	 * @return
	 * @throws Exception
	 */
	Integer countFileNumByCondition(BoxConditionVo boxConditionVo) throws Exception;
    
	/***************************** 以下是按件查询 ***********************************/

	/**
	 * 查询所有件并分页
	 * 
	 * @param map
	 * @return
	 */
	List<FileExtendVo> queryFileList(Map<String, Object> map) throws Exception;

	/**
	 * 按条件查询所有件并分页
	 * 
	 * @param map
	 * @return
	 */
	List<FileExtendVo> queryFileListByCondition(Map<String, Object> map) throws Exception;

	/**
	 * 按条件统计所有件
	 * 
	 * @param fileConditionVo
	 * @return
	 */
	Integer countFileByCondition(FileConditionVo fileConditionVo) throws Exception;
    /**
     * 按条件统计所有页数
     * @param fileConditionVo
     * @return
     * @throws Exception
     */
	Integer countFilePagesByCondition(FileConditionVo fileConditionVo) throws Exception;
	/**
	 * 统计件数
	 * 
	 * @return
	 */
	Integer countFile() throws Exception;

	/**
	 * 统计页数之和
	 * 
	 * @return
	 */
	Integer countArchivefilePages() throws Exception;

	/**
	 * 统计历史数据数量
	 * 
	 * @return
	 */
	Integer countHistoryDataNumber() throws Exception;

	/**
	 * 统计历史数据页数之和
	 * 
	 * @return
	 */
	Integer countHistoryDataPages() throws Exception;

	/**
	 * 查询所有保管期限名称
	 * 
	 * @return
	 */
	List<AmMaSmRetentionperiod> queryRetentionperiodName() throws Exception;

	/**
	 * 根据盒子主键集合获取归档文件目录集合
	 * 
	 * @param boxIdList
	 * @return
	 */
	List<String> findBoxattachmentFilePathList(@Param("boxIdList") List<String> boxIdList) throws Exception;
	
	/**
	 * 查询盒附件表归档文件目录地址(在线打印归档文件目录)
	 * @param boxId
	 * @return
	 */
	AmCoBoxattachment queryBoxattachmentFilePath(@Param("boxId")String boxId)throws Exception;
	
	/**
	 * 统计历史数据件数之和
	 * @return
	 */
	Integer countHistoryData()throws Exception;
	
	/**
	 * 统计历史数据页数之和
	 * @return
	 */
	Integer countHistoryDataPageSum()throws Exception;
	
	/**
	 * 历史数据查询
	 * @param map
	 * @return
	 */
	List<HistoryDataExtendVo> queryHistoryData(Map<String, Object> map)throws Exception;
	
	/**
	 * 按条件查询历史数据查询
	 * @param map
	 * @return
	 */
	List<HistoryDataExtendVo> queryHistoryDataByCondition(Map<String, Object> map)throws Exception;
	
	/**
	 * 按条件统计历史数据
	 * @param historyDataConditionVo
	 * @return
	 */
	Integer countHistoryDataByCondition(HistoryDataConditionVo historyDataConditionVo);
	
}
