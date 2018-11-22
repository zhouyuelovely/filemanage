package filemanage.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.vo.ArchiveInWareHouseAssist;

/**
 * @author mlt 档案管理_档案入库对应接口
 */
public interface WareHouseStorageMapper {

	/**
	 * 档案入库页面档案盒数据展示
	 * @return
	 */
	List<ArchiveInWareHouseAssist> boxInfoListShow(Map<String, Object> map);

	/**
	 * 统计档案入库页面展示的全部的档案盒信息的数目
	 * @return
	 */
	int countBoxInfoListShow();

	/**
	 * 档案入库页面全部档案盒中的全部文件数
	 * @return
	 */
	int countArchiveFileInBox();

	// =========================================档案入库页面展示=========================================
	/**
	 * 多条件查询库房信息
	 * 
	 * @param map
	 * @return
	 */
	List<ArchiveInWareHouseAssist> queryBoxInfoByConditions(Map<String, Object> map);

	/**
	 * 统计多条件查询后的库房数
	 * 
	 * @return
	 */
	int countBoxInfoByConditions(ArchiveInWareHouseAssist archiveInWareHouseAssist);

	// =========================================档案入库_多条件查询==========================================
	/**
	 * 编辑入库信息
	 * 
	 * @param archiveInWareHouseAssist
	 * @return
	 */
	Integer updateOneInStorageInfo(ArchiveInWareHouseAssist archiveInWareHouseAssist);

	/**
	 * 根据主键查询入库档案信息
	 * 
	 * @param boxId
	 * @return
	 */
	ArchiveInWareHouseAssist queryOneInStorageInfoById(String boxId);

	// ===========================================编辑入库档案=======================================
	/**
	 * 入库操作
	 * 
	 * @param str
	 * @return
	 */
	Integer updateInWareHouse(@Param("str") String str,@Param("uuid") String uuid);
	
	/**
	 * 编辑操作
	 * @param boxId
	 * @param uuid
	 * @return
	 */
	Integer editInWareHouse(@Param("boxId") String boxId,@Param("ids") String ids);

	/**
	 * 入库表添加数据
	 * 
	 * @param archiveInWareHouseAssist
	 * @return
	 */
	Boolean addInWareHouse(ArchiveInWareHouseAssist archiveInWareHouseAssist);

	/**
	 * 判断架位号是否存在
	 * 
	 * @return
	 */
	int isExitSstorageRacknumber(String storageRackNumber);

	/**
	 * 要入科的档案盒是否在对应的
	 * 
	 * @param archiveInWareHouseAssist
	 * @return
	 */
	int isExitBoxInfoUnderWareHouse(String boxId);

	// ++++++++++++++++++++++++++++++++++++++++++++入库+++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 获取已审核通过的档案盒有关的全宗号列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> archiveNumberList();

	/**
	 * 获取已审核通过的档案盒有关的全宗名列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> archiveNameList();

	/**
	 * 获取已审核通过的档案盒有关的一级分类列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> pcNameList();

	/**
	 * 获取已审核通过的档案盒有关的二级分类列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> scNameList();

	/**
	 * 获取已审核通过的档案盒信息列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> boxAnualList();

	/**
	 * 获取已审核通过的档案盒有关的保管期限名称列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> retentionperiodNameList();

	/**
	 * 获取已审核通过的档案盒信息列表
	 * 
	 * @return
	 */
	List<ArchiveInWareHouseAssist> boxNumberList();

	// =++++++++++++++++++++++++++++++++++++++++++查询条件下拉框列表+++++++++++++++++++++++++++++++++++++++++
	/**
	 * 入库弹框_库房编号下拉列表
	 * 
	 * @return
	 */
	List<WareHouseBuild> listWareHouseNumber();

	/**
	 * 入库弹框_根据库房编号获取密集架号
	 * 
	 * @param wareHouseBuildNumber
	 * @return
	 */
	List<WareHouseBuild> listWareHouseShelfNumber(String wareHouseBuildId);

	/**
	 * 入库弹框_库房编号和密集架编号获取组编号
	 * 
	 * @param wareHouseBuildNumber
	 * @param wareHouseBuildShelfNumber
	 * @return
	 */
	List<WareHouseBuild> listWareHouseGroupNumber(String wareHouseBuildId);

	/**
	 * 入库弹框_根据库房编号、密集架号和租号获取格子号
	 * 
	 * @param wareHouseBuildNumber
	 * @param wareHouseBuildShelfNumber
	 * @param wareHouseBuildGroupNumber
	 * @return
	 */
	List<WareHouseBuild> listWareHouseLatticeNumber(String wareHouseBuildId);
	// +++++++++++++++++++++++++++++++++++++++++++++++入库弹框中列表显示+++++++++++++++++++++++++++++++++++++

	/**
	 * 档案入库编辑_获取密集架号列表
	 * 
	 * @return
	 */
	List<WareHouseBuild> listWareHouseShelfNumbers();

	/**
	 * 档案入库编辑_获取组编号列表
	 * 
	 * @return
	 */
	List<WareHouseBuild> listWareHouseGroupNumbers();

	/**
	 * 档案入库编辑_获取格子号列表
	 * 
	 * @return
	 */
	List<WareHouseBuild> listWareHouseLatticeNumbers();
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++编辑相关查询++++++++++++++++++++++++++++++++++
	
	/**
	 * 编辑_查询新生成的架位号对应的入库表主键
	 * @param storageRackNumber
	 * @return
	 */
	String storageIdShow(@Param("storageRackNumber") String storageRackNumber);

}
