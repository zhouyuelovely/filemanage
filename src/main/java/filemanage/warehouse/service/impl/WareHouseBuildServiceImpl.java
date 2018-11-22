package filemanage.warehouse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.utils.layui.Layui;
import filemanage.warehouse.dao.WareHouseBuildMapper;
import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.service.WareHouseBuildService;
import filemanage.warehouse.vo.QueryWareHouseBuildConditions;
import filemanage.warehouse.vo.WareHousePageInfo;
@Service
public class WareHouseBuildServiceImpl implements WareHouseBuildService {

	@Autowired
	private WareHouseBuildMapper wareHouseBuildMapper;

	/**
	 * 展示所有库房信息
	 */
	@Override
	public Layui wareHouseInfoListShow(Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<WareHouseBuild> wareHouseInfoListShow = wareHouseBuildMapper.wareHouseInfoListShow(map);
		int countWareHouseInfoListShow = wareHouseBuildMapper.countWareHouseInfoListShow();
		return Layui.data(countWareHouseInfoListShow, wareHouseInfoListShow);
	}

	/**
	 * 初始化统计库房数
	 */
	@Override
	public WareHousePageInfo havingPageInfoAboutWareHouse() {
		WareHousePageInfo wareHousePageInfo = new WareHousePageInfo();
		wareHousePageInfo.setWareHouseNum(wareHouseBuildMapper.countWareHouseInfoListShow());
		return wareHousePageInfo;
	}

	/**
	 * 遍历侠士所有密集架数量
	 */
	@Override
	public List<WareHouseBuild> listWareHouseBuildShelvesNum() {
		return wareHouseBuildMapper.listWareHouseBuildShelvesNum();
	}

	/**
	 * 根据密集架获取密集架下全部的组数
	 */
	@Override
	public List<WareHouseBuild> listWareHouseBuildGroupsNum(String wareHouseBuildShelvesNum) {
		return wareHouseBuildMapper.listWareHouseBuildGroupsNum(wareHouseBuildShelvesNum);
	}

	/**
	 * 根据密集架和组数进行筛选
	 */
	@Override
	public Layui selectWareHouseInfoByShelvesNumAndGroupsNum(String wareHouseBuildShelvesNum,
			String wareHouseBuildGroupsNum, Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("wareHouseBuildShelvesNum", wareHouseBuildShelvesNum);
		map.put("wareHouseBuildGroupsNum", wareHouseBuildGroupsNum);
		map.put("begin", begin);
		map.put("end", end);
		int countWareHouseInfoByShelvesNumAndGroupsNum = wareHouseBuildMapper
				.countWareHouseInfoByShelvesNumAndGroupsNum(wareHouseBuildShelvesNum, wareHouseBuildGroupsNum);
		List<WareHouseBuild> selectWareHouseInfoByShelvesNumAndGroupsNum = wareHouseBuildMapper
				.selectWareHouseInfoByShelvesNumAndGroupsNum(map);
		return Layui.data(countWareHouseInfoByShelvesNumAndGroupsNum, selectWareHouseInfoByShelvesNumAndGroupsNum);
	}

	/**
	 * 统计筛选后的库房数
	 */
	@Override
	public WareHousePageInfo havingPageInfoByShelvesNumAndGroupsNum(String wareHouseBuildShelvesNum,
			String wareHouseBuildGroupsNum) {
		WareHousePageInfo wareHousePageInfo = new WareHousePageInfo();
		wareHousePageInfo.setWareHouseNum(wareHouseBuildMapper
				.countWareHouseInfoByShelvesNumAndGroupsNum(wareHouseBuildShelvesNum, wareHouseBuildGroupsNum));
		return wareHousePageInfo;
	}

	/**
	 * 关键词查询库房信息
	 */
	@Override
	public Layui selectWareHouseInfoByConditions(String condition,Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("condition", condition);
		int countWareHouseInfoByConditions = wareHouseBuildMapper
				.countWareHouseInfoByConditions(condition);
		List<QueryWareHouseBuildConditions> selectWareHouseInfoByConditions = wareHouseBuildMapper
				.selectWareHouseInfoByConditions(map);
		return Layui.data(countWareHouseInfoByConditions, selectWareHouseInfoByConditions);
	}

	/**
	 * 统计关键词查询后的库房数量
	 */

	@Override
	public WareHousePageInfo havingPageInfoByConditions(String condition) {
		WareHousePageInfo wareHousePageInfo = new WareHousePageInfo();
		wareHousePageInfo.setWareHouseNum(wareHouseBuildMapper.countWareHouseInfoByConditions(condition));
		return wareHousePageInfo;
	}
	
	/**
	 * 删除库房信息
	 */
	@Override
	public Boolean deleteOneWareHouseInfo(String wareHouseBuildId) {
		return wareHouseBuildMapper.deleteOneWareHouseInfo(wareHouseBuildId) > 0;
	}

	/**
	 * 判断要删除的库房下是否有数据(有，则不能删除；没有，则可以删除)
	 */
	@Override
	public int countWareHouseUnderHaveInfo(String wareHouseBuildId) {
		return wareHouseBuildMapper.countWareHouseUnderHaveInfo(wareHouseBuildId);
	}

	/**
	 * 编辑单个库房信息
	 */
	@Override
	public Integer updateOneWareHouseInfo(WareHouseBuild wareHouseBuild) {
		return wareHouseBuildMapper.updateOneWareHouseInfo(wareHouseBuild);
	}

	/**
	 * 根据主键查询(编辑相关)
	 */
	@Override
	public WareHouseBuild queryWareHouseInfo(String wareHouseBuildId) {
		return wareHouseBuildMapper.queryWareHouseInfo(wareHouseBuildId);
	}

	/**
	 * 添加库房信息
	 */
	@Override
	public Boolean addWareHouseInfo(WareHouseBuild wareHouseBuild) {
		return wareHouseBuildMapper.addWareHouseInfo(wareHouseBuild) > 0;
	}

	/**
	 * 判断库房号是否存在
	 */
	@Override
	public int isExitWareHouseBuildNumber(WareHouseBuild wareHouseBuild) {
		return wareHouseBuildMapper.isExitWareHouseBuildNumber(wareHouseBuild);
	}

	/**
	 * 判断库房名称是否存在
	 */
	@Override
	public int isExitWareHouseBuildName(WareHouseBuild wareHouseBuild) {
		return wareHouseBuildMapper.isExitWareHouseBuildName(wareHouseBuild);
	}

}
