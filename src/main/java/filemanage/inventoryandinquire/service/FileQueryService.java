package filemanage.inventoryandinquire.service;

import java.util.List;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.inventoryandinquire.vo.BoxConditionVo;
import filemanage.inventoryandinquire.vo.FileConditionVo;
import filemanage.inventoryandinquire.vo.HistoryDataConditionVo;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.utils.layui.Layui;

public interface FileQueryService {

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
	 * 查询所有盒子信息(页面初始化数据)
	 * 
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui queryBoxList(Integer limit, Integer page) throws Exception;

	/**
	 * 按照条件查询盒子信息
	 * 
	 * @param boxConditionVo
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui queryBoxListByCondition(BoxConditionVo boxConditionVo, Integer limit, Integer page) throws Exception;

	/**
	 * 查询所有件信息
	 * 
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui queryFileList(Integer limit, Integer page) throws Exception;

	/**
	 * 按条件查询件信息
	 * 
	 * @param fileConditionVo
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui queryFileListByCondition(FileConditionVo fileConditionVo, Integer limit, Integer page) throws Exception;

	/**
	 * 统计文件数量
	 * 
	 * @return
	 */
	Integer countFile() throws Exception;

	/**
	 * 统计文件页数之和
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
	 * 根据盒子主键获取归档目录路径集合
	 * 
	 * @param boxIdList
	 * @return
	 */
	List<String> findFilePathList(List<String> boxIdList) throws Exception;

	/**
	 * 查询盒附件表归档文件目录地址(在线打印归档文件目录)
	 * 
	 * @param boxId
	 * @return
	 */
	AmCoBoxattachment queryBoxattachmentFilePath(String boxId) throws Exception;

	/**
	 * 统计历史数据件数之和
	 * 
	 * @return
	 */
	Integer countHistoryData() throws Exception;

	/**
	 * 统计历史数据页数之和
	 * 
	 * @return
	 */
	Integer countHistoryDataPageSum() throws Exception;

	/**
	 * 历史数据查询
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	Layui queryHistoryData(Integer page, Integer limit) throws Exception;

	/**
	 * 按条件查询历史数据查询
	 * 
	 * @param historyDataConditionVo
	 * @param page
	 * @param limit
	 * @return
	 */
	
	Layui queryHistoryDataByCondition(HistoryDataConditionVo historyDataConditionVo, Integer page, Integer limit) throws Exception;
	//条件查询统计盒数和件数
	public HavingInforBox queryBoxByCondition(BoxConditionVo boxConditionVo)throws Exception;
	 //条件查询统计件数和页数
	 public ArchiveFileHelpInfor queryFileByboxCondition(FileConditionVo fileConditionVo) throws Exception;
	
}
