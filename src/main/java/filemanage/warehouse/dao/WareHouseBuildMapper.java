package filemanage.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.vo.QueryWareHouseBuildConditions;
/**
 * @author mlt 库房管理_库房建设接口
 */
public interface WareHouseBuildMapper {

	/**
	 * 展示所有库房信息
	 * @return
	 */
	List<WareHouseBuild> wareHouseInfoListShow(Map<String,Object>map);

	/**
	 * 统计库房数
	 * @return
	 */
	int countWareHouseInfoListShow();

	// ==================================================页面展示全部库房信息================================================
	/**
	 * 显示所有的密集架数量
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
	List<WareHouseBuild> selectWareHouseInfoByShelvesNumAndGroupsNum(Map<String, Object> map);

	/**
	 * 统计筛选后的全部库房数
	 * @param wareHouseBuildShelvesNum
	 * @param wareHouseBuildGroupsNum
	 * @return
	 */
	int countWareHouseInfoByShelvesNumAndGroupsNum(@Param("wareHouseBuildShelvesNum") String wareHouseBuildShelvesNum,
			@Param("wareHouseBuildGroupsNum") String wareHouseBuildGroupsNum);
	
	/**
	 * 关键词查询库房信息
	 * @param map
	 * @return 关键词(库房号、库房名称、密集架数量、组数、格子数)
	 */
	List<QueryWareHouseBuildConditions> selectWareHouseInfoByConditions(Map<String,Object>map);
	
	/**
	 * 统计关键词查询后的库房数量
	 * @param queryWareHouseBuildConditions
	 * @return
	 */
	int countWareHouseInfoByConditions(String condition);
	// ================================================根据密集架数和组数进行筛选=====================================================
	
	/**
	 * 删除一条库房信息
	 * @param wareHouseBuildId
	 * @return
	 */
	Integer deleteOneWareHouseInfo(String wareHouseBuildId);
	
	/**
	 * 判断要删除的库房下是否有数据(有，则不能删除；没有，则可以删除)
	 * @param wareHouseBuildId
	 * @return
	 */
	int countWareHouseUnderHaveInfo(String wareHouseBuildId);
	//===================================================删除===================================================
	
	/**
	 * 编辑库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	Integer updateOneWareHouseInfo(WareHouseBuild wareHouseBuild);
	
	/**
	 * 根据主键查询
	 * @param wareHouseBuildId
	 * @return
	 */
	WareHouseBuild queryWareHouseInfo(String wareHouseBuildId);
	//===================================================编辑===================================================
	/**
	 * 添加库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	Integer addWareHouseInfo(WareHouseBuild wareHouseBuild);
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
	//==================================================删除===============================================

}
