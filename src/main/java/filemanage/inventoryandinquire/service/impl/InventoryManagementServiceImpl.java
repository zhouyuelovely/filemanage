package filemanage.inventoryandinquire.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import filemanage.inventoryandinquire.dao.InventoryManagementMapper;
import filemanage.inventoryandinquire.pojo.InventoryPlan;
import filemanage.inventoryandinquire.service.InventoryManagementService;
import filemanage.inventoryandinquire.vo.InventoryConditionVo;
import filemanage.inventoryandinquire.vo.InventoryPlanQueryVo;
import filemanage.inventoryandinquire.vo.InventoryPlanningVo;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.GetUUIDName;
import filemanage.utils.layui.Layui;

@Service("inventoryManagementServiceImpl")
public class InventoryManagementServiceImpl implements InventoryManagementService {

	private Logger log = LoggerFactory.getLogger(InventoryManagementServiceImpl.class);

	@Autowired
	private InventoryManagementMapper inventoryManagementMapper;

	/**
	 * 查询全宗名称集合
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryConditionVo> queryQuanzongName() throws Exception {
		return inventoryManagementMapper.queryQuanzongName();
	}

	/**
	 * 统计已加入计划的盒数
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countByJoinPlan() throws Exception {
		return inventoryManagementMapper.countByJoinPlan();
	}

	/**
	 * 渲染已加入计划的盒信息数据
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryBoxInfo(Integer limit, Integer page) throws Exception {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<InventoryPlanningVo> data = inventoryManagementMapper.queryBoxInfo(map);
		Integer count = inventoryManagementMapper.countByJoinPlan();
		return layui.data(count, data);
	}

	/**
	 * 根据全宗名称查询该全宗下的所有年度
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryConditionVo> queryBoxAnualByQuanzongName(InventoryConditionVo inventoryConditionVo)
			throws Exception {
		return inventoryManagementMapper.queryBoxAnualByQuanzongName(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称和年度查询该全宗该年度下的所有档案类型
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryConditionVo> queryPcNameByQuanzongNameAndBoxAnual(InventoryConditionVo inventoryConditionVo)
			throws Exception {
		return inventoryManagementMapper.queryPcNameByQuanzongNameAndBoxAnual(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称、年度、档案类型查询该全宗该年度该档案类型下的所有保管期限
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryConditionVo> queryRetentionperiodName(InventoryConditionVo inventoryConditionVo)
			throws Exception {
		return inventoryManagementMapper.queryRetentionperiodName(inventoryConditionVo);
	}

	/**
	 * 根据全宗名称、盒年度、档案类型、保管期限渲染盒信息
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryBoxInfoByCondition(InventoryConditionVo inventoryConditionVo, Integer limit, Integer page)
			throws Exception {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("inventoryConditionVo", inventoryConditionVo);
		List<InventoryPlanningVo> data = inventoryManagementMapper.queryBoxInfoByCondition(map);
		Integer count = inventoryManagementMapper.countBoxInfo(inventoryConditionVo);
		return layui.data(count, data);
	}

	/**
	 * 盘点加入计划操作
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateJoinPlanByBoxIdList(List<String> boxIdList) throws Exception {
		return inventoryManagementMapper.updateJoinPlanByBoxIdList(boxIdList) > 0;
	}

	/**
	 * 提交计划
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean submitInventoryPlan(InventoryPlan inventoryPlan) throws Exception {
		User user = HavingUserInfor.havingUser();
		Boolean boolean1 = false;
		String planId = GetUUIDName.getUUID();
		if (user != null) {
			Date day = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			inventoryPlan.setPlanMakingPerson(user.getUserName());
			inventoryPlan.setPlanMakingDate(df.format(day));
			inventoryPlan.setPlanId(planId);
			boolean1 = inventoryManagementMapper.submitInventoryPlan(inventoryPlan) > 0;
			if (boolean1) {
				List<String> boxIdList = inventoryManagementMapper.queryJoinPlanStatusByOne();
				if (boxIdList.size() > 0) {
					Boolean boolean2 = inventoryManagementMapper.addPlanIdInToAmCoBox(planId);
					if (boolean2) {
						Integer num = inventoryManagementMapper.updateJoinPlanStatusByBoxIdList(boxIdList);
						if (num > 0) {
							log.info("将提交计划后盒子信息状态由加入计划变为未加入计划,影响到的盒子数量=" + num);
						} else {
							log.error("提交计划失败,请检查参数是否正确!boxIdList=" + boxIdList);
						}
					} else {
						throw new Exception("向盒表里插入计划主键失败!参数planId=" + planId);
					}
				} else {
					log.error("已加入计划的盒子信息数量为0,boxIdList=" + boxIdList);
				}
			} else {
				throw new Exception("提交计划失败,请检查参数是否正确!inventoryPlan=" + inventoryPlan);
			}
		} else {
			throw new Exception("获取用户信息失败!");
		}
		return boolean1;
	}

	/**
	 * 删除已加入的盘点计划记录
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateJoinPlanByBoxId(String boxId) throws Exception {
		return inventoryManagementMapper.updateJoinPlanByBoxId(boxId) > 0;
	}

	/**
	 * 查询盘点计划表所有信息并分页
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryInventoryPlanInfo(Integer limit, Integer page) throws Exception {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<InventoryPlan> data = inventoryManagementMapper.queryInventoryPlanInfo(map);
		Integer count = inventoryManagementMapper.countInventoryPlanInfo();
		return layui.data(count, data);
	}

	/**
	 * 按条件查询盘点计划表的信息
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryInventoryPlanInfoByCondition(InventoryPlanQueryVo inventoryPlanQueryVo, Integer limit,
			Integer page) throws Exception {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("inventoryPlanQueryVo", inventoryPlanQueryVo);
		List<InventoryPlan> data = inventoryManagementMapper.queryInventoryPlanInfoByCondition(map);
		Integer count = inventoryManagementMapper.countInventoryPlanInfoByCondition(inventoryPlanQueryVo);
		return layui.data(count, data);
	}

	/**
	 * 查询所有盘点人名称
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryPlan> queryPlanPerson() throws Exception {
		return inventoryManagementMapper.queryPlanPerson();
	}

	/**
	 * 查询所有盘点状态
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryPlan> queryPlanStatus() throws Exception {
		return inventoryManagementMapper.queryPlanStatus();
	}

	/**
	 * 根据计划表主键查询计划表信息
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventoryPlanningVo> queryBoxListByPlanId(String planId) throws Exception {
		return inventoryManagementMapper.queryBoxListByPlanId(planId);
	}

	/**
	 * 将盘点计划的盘点状态设置为盘点中
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updatePlanStatusByPlanId(String planId) throws Exception {
		return inventoryManagementMapper.updatePlanStatusByPlanId(planId) > 0;
	}

	/**
	 * 将计划表的信息盘点状态设置为已盘点
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updatePlanStatusByPlanIdThree(String planId, String planUploadaddress) throws Exception {
		return inventoryManagementMapper.updatePlanStatusByPlanIdThree(planId, planUploadaddress) > 0;
	}

	/**
	 * 根据计划主键查询盒表信息
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryBoxInfoByPlanId(String planId, Integer limit, Integer page,String zhuangtai) throws Exception {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("planId", planId);
		List<InventoryPlanningVo> data = inventoryManagementMapper.queryBoxInfoByPlanId(map);
		if (zhuangtai.equals("已盘点")) {
			
		}else {
			for (InventoryPlanningVo inventoryPlanningVo : data) {
				inventoryPlanningVo.setJuider("未盘点");
			}
		}
		Integer count = inventoryManagementMapper.countBoxInfoByPlanId(planId);
		return layui.data(count, data);
	}

	/**
	 * 根据计划主键查询计划表信息
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryPlanInfoByPlanId(String planId) throws Exception {
		Layui layui = new Layui();
		List<InventoryPlan> data = inventoryManagementMapper.queryPlanInfoByPlanId(planId);
		return layui.data(0, data);
	}

	@Override
	public List<InventoryPlan> queryPlanInfoByPlanIds(String planId) throws Exception {
		// TODO Auto-generated method stub
		return inventoryManagementMapper.queryPlanInfoByPlanId(planId);
	}

	/**
	 * 下载盘点结果
	 * 
	 * @param planId
	 * @return
	 * @throws Exception
	 */
	@Override
	public String downloadPanDian(String planId) throws Exception {
		// TODO Auto-generated method stub
		return inventoryManagementMapper.downloadPanDian(planId);
	}

	/**
	 * 解析并修改上传计划
	 */
	@Override
	public Integer updateDownload(InventoryPlan inventoryplan) {
		// TODO Auto-generated method stub
		return inventoryManagementMapper.updateDownload(inventoryplan);
	}

	/**
	 * 根据计划主键查询盘点人
	 * 
	 * @param planId
	 * @return
	 */
	@Override
	public String queryPDJG(String planId) throws Exception {
		// TODO Auto-generated method stub
		return inventoryManagementMapper.queryPDJG(planId);
	}

	@Override
	public Integer UpdataMapper(Map<String, String> map) {
		return inventoryManagementMapper.UpdataMapper(map);
	}

}
