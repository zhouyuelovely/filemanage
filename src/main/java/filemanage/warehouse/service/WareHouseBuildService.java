package filemanage.warehouse.service;

import java.util.List;

import filemanage.utils.layui.Layui;
import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.vo.WareHousePageInfo;
/**
 * @author mlt 库房管理_库房建设对应接口
 */
public interface WareHouseBuildService {
	/**
	 * 返回所有库房信息
	 * @return
	 */
	Layui wareHouseInfoListShow(Integer limit, Integer page);

	/**
	 * 统计库房数
	 * @return
	 */
	WareHousePageInfo havingPageInfoAboutWareHouse();

	// ==================================================页面展示全部库房信息================================================

	/**
	 * 遍历显示所有的密集架数量
	 * @return
	 */
	List<WareHouseBuild> listWareHouseBuildShelvesNum();

	/**
	 * 根据密集架数量获取密集架下全部的组数
	 * @param wareHouseBuildShelvesNum
	 * @return
	 */
	List<WareHouseBuild> listWareHouseBuildGroupsNum(String wareHouseBuildShelvesNum);

	/**
	 * 根据密集架数和组数进行筛选
	 * @param map
	 * @return
	 */
	Layui selectWareHouseInfoByShelvesNumAndGroupsNum(String wareHouseBuildShelvesNum, String wareHouseBuildGroupsNum,
			Integer limit, Integer page);

	/**
	 * 统计筛选后的全部库房数
	 * @param wareHouseBuildShelvesNum
	 * @param wareHouseBuildGroupsNum
	 * @return
	 */
	WareHousePageInfo havingPageInfoByShelvesNumAndGroupsNum(String wareHouseBuildShelvesNum,String wareHouseBuildGroupsNum);

	/**
	 * 关键词查询库房信息
	 * @param queryWareHouseBuildConditions
	 * @param limit
	 * @param page
	 * @return
	 */
	Layui selectWareHouseInfoByConditions(String condition, Integer limit,Integer page);

	/**
	 * 统计关键词查询后的库房数量
	 * @param queryWareHouseBuildConditions
	 * @return
	 */
	WareHousePageInfo havingPageInfoByConditions(String condition);

	/**
	 * 删除库房信息
	 * @param wareHouseBuildId
	 * @return
	 */
	Boolean deleteOneWareHouseInfo(String wareHouseBuildId);

	/**
	 * 判断要删除的库房下是否有数据(有，则不能删除；没有，则可以删除)
	 * @param wareHouseBuildId
	 * @return
	 */
	int countWareHouseUnderHaveInfo(String wareHouseBuildId);

	/**
	 * 编辑库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	Integer updateOneWareHouseInfo(WareHouseBuild wareHouseBuild);

	/**
	 * 根据主键查询(编辑相关)
	 * @param wareHouseBuildId
	 * @return
	 */
	WareHouseBuild queryWareHouseInfo(String wareHouseBuildId);

	/**
	 * 添加库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	Boolean addWareHouseInfo(WareHouseBuild wareHouseBuild);

	/**
	 * 判断库房号是否存在
	 * @param wareHouseBuild
	 * @return
	 */
	int isExitWareHouseBuildNumber(WareHouseBuild wareHouseBuild);

	/**
	 * 判断库房名称是否存在
	 * @param wareHouseBuild
	 * @return
	 */
	int isExitWareHouseBuildName(WareHouseBuild wareHouseBuild);
	// ================================================根据密集架数和组数进行筛选=====================================================

}
