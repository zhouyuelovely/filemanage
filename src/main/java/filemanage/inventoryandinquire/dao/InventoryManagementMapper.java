package filemanage.inventoryandinquire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.inventoryandinquire.pojo.InventoryPlan;
import filemanage.inventoryandinquire.vo.InventoryConditionVo;
import filemanage.inventoryandinquire.vo.InventoryPlanQueryVo;
import filemanage.inventoryandinquire.vo.InventoryPlanningVo;

@Repository("inventoryManagementMapper")
public interface InventoryManagementMapper {
	/******************************* 盘点计划下拉框数据查询*************************************/
	/**
	 * 查询所有全宗名称
	 * 
	 * @return
	 * @throws Exception
	 */
	List<InventoryConditionVo> queryQuanzongName() throws Exception;

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

	/************************************* 盘点计划页面未加入计划的数据渲染及操作***************************************/
	/**
	 * 根据全宗名称、盒年度、档案类型、保管期限渲染盒信息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlanningVo> queryBoxInfoByCondition(Map<String, Object> map) throws Exception;

	/**
	 * 根据全宗名称、盒年度、档案类型、保管期限计算未加入计划的盒子信息数量
	 * 
	 * @param inventoryConditionVo
	 * @return
	 * @throws Exception
	 */
	Integer countBoxInfo(InventoryConditionVo inventoryConditionVo) throws Exception;

	/**
	 * 盘点加入计划操作
	 * 
	 * @param boxIdList
	 * @return
	 * @throws Exception
	 */
	Integer updateJoinPlanByBoxIdList(@Param("boxIdList") List<String> boxIdList) throws Exception;

	/************************************* 盘点计划已加入计划的页面数据渲染及操作**********************************/
	/**
	 * 查询已加入计划的盒信息(1:已加入))
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlanningVo> queryBoxInfo(Map<String, Object> map) throws Exception;

	/**
	 * 删除已加入的盘点计划记录
	 * 
	 * @param boxId
	 * @return
	 * @throws Exception
	 */
	Integer updateJoinPlanByBoxId(@Param("boxId") String boxId) throws Exception;

	/**
	 * 计算加入计划的盒子数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countByJoinPlan() throws Exception;

	/**
	 * 将提交计划的盒信息是否加入计划状态设置成未加入计划('2')
	 * 
	 * @param boxIdList
	 * @return
	 * @throws Exception
	 */
	Integer updateJoinPlanStatusByBoxIdList(@Param("boxIdList") List<String> boxIdList) throws Exception;

	/**
	 * 查询盒信息是否加入计划状态为"1"的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<String> queryJoinPlanStatusByOne() throws Exception;

	/**
	 * 提交计划
	 * 
	 * @param inventoryPlan
	 * @return
	 * @throws Exception
	 */
	Integer submitInventoryPlan(InventoryPlan inventoryPlan) throws Exception;

	/************************************* 盘点计划 计划列表 的页面数据渲染及操作**********************************/

	/**
	 * 查询所有盘点人
	 * 
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryPlanPerson() throws Exception;

	/**
	 * 查询所有盘点状态
	 * 
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryPlanStatus() throws Exception;

	/**
	 * 查询盘点计划表所有信息并分页
	 * 
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryInventoryPlanInfo(Map<String, Object> map) throws Exception;

	/**
	 * 统计盘点计划表所有信息数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countInventoryPlanInfo() throws Exception;

	/**
	 * 按条件查询盘点计划表的信息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<InventoryPlan> queryInventoryPlanInfoByCondition(Map<String, Object> map) throws Exception;

	/**
	 * 按条件统计盘点计划表的信息
	 * 
	 * @param inventoryPlanQueryVo
	 * @return
	 * @throws Exception
	 */
	Integer countInventoryPlanInfoByCondition(InventoryPlanQueryVo inventoryPlanQueryVo) throws Exception;

	/**
	 * 向盒表里插入计划表的主键集合(用于关联已已提交计划的数据)
	 * 
	 * @param planIdList
	 * @return
	 */
	Boolean addPlanIdInToAmCoBox(@Param("planId") String planId)
			throws Exception;
	
	/**
	 * 根据计划表主键查询盒表信息集合
	 * @param planId
	 * @return
	 */
	List<InventoryPlanningVo> queryBoxListByPlanId(@Param("planId")String planId) 
			throws Exception;
	
	/**
	 * 将盘点计划的盘点状态设置为盘点中
	 * @param planId
	 * @return
	 */
	Integer updatePlanStatusByPlanId(@Param("planId")String planId) 
			throws Exception;
	
	/**
	 * 将计划表的信息盘点状态设置为已盘点
	 * @param planId
	 * @return
	 */
	Integer updatePlanStatusByPlanIdThree(@Param("planId")String planId,@Param("planUploadaddress")String planUploadaddress) 
			throws Exception;
	
	/**
	 * 根据计划主键查询盒表信息
	 * @param map
	 * @return
	 */
	List<InventoryPlanningVo> queryBoxInfoByPlanId(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据计划主键统计盒表信息
	 * @param planId
	 * @return
	 */
	Integer countBoxInfoByPlanId(@Param("planId")String planId) throws Exception;
	
	/**
	 * 根据计划主键查询计划表信息
	 * @param planId
	 * @return
	 */
	List<InventoryPlan> queryPlanInfoByPlanId(@Param("planId")String planId) throws Exception;
	
	/**
	 * 根据计划主键查询盘点人
	 * @param planId
	 * @return
	 */
	String queryPDJG(@Param("planId")String planId) throws Exception;
	
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
	