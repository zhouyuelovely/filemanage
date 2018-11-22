package filemanage.inventoryandinquire.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import filemanage.inventoryandinquire.pojo.InventoryPlan;
import filemanage.inventoryandinquire.vo.InventoryConditionVo;
import filemanage.inventoryandinquire.vo.InventoryPlanQueryVo;
import filemanage.inventoryandinquire.vo.InventoryPlanningVo;
import filemanage.utils.layui.Layui;

public interface InventoryManagementService {
	/**
	 * 查询全宗名称集合
	 * 
	 * @return
	 * @throws Exception
	 */
	List<InventoryConditionVo> queryQuanzongName() throws Exception;

	/**
	 * 统计已加入计划的盒数
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countByJoinPlan() throws Exception;

	/**
	 * 渲染已加入计划的盒信息数据
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Layui queryBoxInfo(Integer limit, Integer page) throws Exception;

	/**
	 * 根据全宗名称查询该全宗下的所有年度
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	List<InventoryConditionVo> queryBoxAnualByQuanzongName(InventoryConditionVo inventoryConditionVo) throws Exception;

	/**
	 * 根据全宗名称和年度查询该全宗该年度下的所有档案类型
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	List<InventoryConditionVo> queryPcNameByQuanzongNameAndBoxAnual(InventoryConditionVo inventoryConditionVo)
			throws Exception;

	/**
	 * 根据全宗名称、年度、档案类型查询该全宗该年度该档案类型下的所有保管期限
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	List<InventoryConditionVo> queryRetentionperiodName(InventoryConditionVo inventoryConditionVo) throws Exception;

	/**
	 * 根据全宗名称、盒年度、档案类型、保管期限渲染盒信息
	 * 
	 * @param inventoryConditionVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Layui queryBoxInfoByCondition(InventoryConditionVo inventoryConditionVo, Integer limit, Integer page)
			throws Exception;

	/**
	 * 盘点加入计划操作
	 * 
	 * @param boxIdList
	 * @return
	 * @throws Exception
	 */
	Boolean updateJoinPlanByBoxIdList(List<String> boxIdList) throws Exception;

	/**
	 * 提交计划
	 * 
	 * @param inventoryPlan
	 * @return
	 * @throws Exception
	 */
	Boolean submitInventoryPlan(InventoryPlan inventoryPlan) throws Exception;

	/**
	 * 删除已加入的盘点计划记录
	 * 
	 * @param boxId
	 * @return
	 * @throws Exception
	 */
	Boolean updateJoinPlanByBoxId(String boxId) throws Exception;
	
	/**
	 * 查询所有盘点人
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryPlanPerson() throws Exception; 
	
	/**
	 * 查询所有盘点状态
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryPlanStatus() throws Exception;

	/**
	 * 查询盘点计划表所有信息并分页
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Layui queryInventoryPlanInfo(Integer limit, Integer page) throws Exception;

	/**
	 * 按条件查询盘点计划表所有信息并分页
	 * 
	 * @param inventoryPlanQueryVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Layui queryInventoryPlanInfoByCondition(InventoryPlanQueryVo inventoryPlanQueryVo, Integer limit, Integer page)
			throws Exception;
	
	/**
	 * 根据计划表主键查询计划表信息
	 * @param planId
	 * @return
	 */
	List<InventoryPlanningVo> queryBoxListByPlanId(String planId) throws Exception;
	
	/**
	 * 将盘点计划的盘点状态设置为盘点中
	 * @param planStatus
	 * @return
	 */
	Boolean updatePlanStatusByPlanId(String planId) throws Exception;
	
	/**
	 * 将计划表的信息盘点状态设置为已盘点
	 * @param planId
	 * @return
	 */
	Boolean updatePlanStatusByPlanIdThree(String planId,String planUploadaddress) throws Exception;
	
	/**
	 * 根据计划主键查询盒表信息
	 * @param planId
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui queryBoxInfoByPlanId(String planId, Integer limit, Integer page ,String zhuangtai) throws Exception;
	
	/**
	 * 根据计划主键查询计划表信息
	 * @param planId
	 * @return
	 */
	Layui queryPlanInfoByPlanId(String planId) throws Exception;
	
	/**
	 * 根据计划主键查询盘点人
	 * @param planId
	 * @return
	 */
	String queryPDJG(String planId) throws Exception;
	
	/**
	 * 计划详情
	 * @param planId
	 * @return
	 */
	List<InventoryPlan> queryPlanInfoByPlanIds(String planId) throws Exception;
	
	/**
	 * 下载盘点结果
	 * @param planId
	 * @return
	 * @throws Exception
	 */
	String downloadPanDian(@Param("planId")String planId) throws Exception;
	/**
	 * 解析并修改上传计划
	 */
	Integer updateDownload(InventoryPlan inventoryplan);
	
	
	Integer UpdataMapper(Map<String, String> map);
}
