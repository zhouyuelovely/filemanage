package filemanage.warehouse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.utils.layui.Layui;
import filemanage.warehouse.dao.WareHouseStorageMapper;
import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.service.WareHouseStorageService;
import filemanage.warehouse.vo.ArchiveInWareHouseAssist;
@Service
public class WareHouseStorageServiceImpl implements WareHouseStorageService {

	@Autowired
	private WareHouseStorageMapper wareHouseStorageMapper;

	/**
	 * 档案入库页面档案盒数据展示
	 */
	@Override
	public Layui boxInfoListShow(Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<ArchiveInWareHouseAssist> boxInfoListShow = wareHouseStorageMapper.boxInfoListShow(map);
		int countBoxInfoListShow = wareHouseStorageMapper.countBoxInfoListShow();
		return Layui.data(countBoxInfoListShow, boxInfoListShow);
	}

	/**
	 * 统计档案入库页面展示的全部的档案盒信息的数目
	 */
	@Override
	public int countBoxInfoListShow() {
		return wareHouseStorageMapper.countBoxInfoListShow();
	}

	/**
	 * 档案入库页面展示的档案盒内的文件数
	 */
	@Override
	public int countArchiveFileInBox() {
		return wareHouseStorageMapper.countArchiveFileInBox();
	}

	/**
	 * 多条件查询档案入库页面档案盒信息
	 */
	@Override
	public Layui queryBoxInfoByConditions(ArchiveInWareHouseAssist archiveInWareHouseAssist, Integer limit,
			Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("quanzongNumber", archiveInWareHouseAssist.getQuanzongNumber());
		map.put("quanzongName", archiveInWareHouseAssist.getQuanzongName());
		map.put("pcName", archiveInWareHouseAssist.getPcName());
		map.put("scName", archiveInWareHouseAssist.getScName());
		map.put("boxAnual", archiveInWareHouseAssist.getBoxAnual());
		map.put("retentionperiodName", archiveInWareHouseAssist.getRetentionperiodName());
		map.put("boxNumber", archiveInWareHouseAssist.getBoxNumber());
		map.put("begin", begin);
		map.put("end", end);
		int countBoxInfoByConditions = wareHouseStorageMapper.countBoxInfoByConditions(archiveInWareHouseAssist);
		List<ArchiveInWareHouseAssist> queryboxInfoByConditions = wareHouseStorageMapper.queryBoxInfoByConditions(map);
		return Layui.data(countBoxInfoByConditions, queryboxInfoByConditions);
	}

	/**
	 * 统计多条件查询档案入库
	 */
	@Override
	public int countBoxInfoByConditions(ArchiveInWareHouseAssist archiveInWareHouseAssist) {
		return wareHouseStorageMapper.countBoxInfoByConditions(archiveInWareHouseAssist);
	}

	/**
	 * 编辑入库信息
	 */
	@Override
	public Boolean updateOneInStorageInfo(ArchiveInWareHouseAssist archiveInWareHouseAssist) {
		return wareHouseStorageMapper.updateOneInStorageInfo(archiveInWareHouseAssist) > 0;
	}

	/**
	 * 根据主键查询入库信息
	 */
	@Override
	public ArchiveInWareHouseAssist queryOneInStorageInfoById(String boxId) {
		return wareHouseStorageMapper.queryOneInStorageInfoById(boxId);
	}

	/**
	 * 入库操作
	 */
	@Override
	public Boolean updateInWareHouse(String str, String uuid) {
		return wareHouseStorageMapper.updateInWareHouse(str, uuid) > 0;
	}

	/**
	 * 编辑操作
	 */
	@Override
	public Boolean editInWareHouse(String boxId, String ids) {
		return wareHouseStorageMapper.editInWareHouse(boxId, ids) > 0;
	}

	/**
	 * 入库表添加信息
	 */
	@Override
	public Boolean addInWareHouse(ArchiveInWareHouseAssist archiveInWareHouseAssist) {
		return wareHouseStorageMapper.addInWareHouse(archiveInWareHouseAssist);
	}

	/**
	 * 判断入库表是否存在该架位号
	 */
	@Override
	public int isExitSstorageRacknumber(String storageRackNumber) {
		return wareHouseStorageMapper.isExitSstorageRacknumber(storageRackNumber);
	}

	/**
	 * 档案盒是否有对应的库房
	 */
	@Override
	public int isExitBoxInfoUnderWareHouse(String boxId) {
		return wareHouseStorageMapper.isExitBoxInfoUnderWareHouse(boxId);
	}

	/**
	 * 获取已审核通过的档案盒有关的全宗号列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> archiveNumberList() {
		return wareHouseStorageMapper.archiveNumberList();
	}

	/**
	 * 获取已审核通过的档案盒有关的全宗名列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> archiveNameList() {
		return wareHouseStorageMapper.archiveNameList();
	}

	/**
	 * 获取已审核通过的档案盒有关的一级分类列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> pcNameList() {
		return wareHouseStorageMapper.pcNameList();
	}

	/**
	 * 获取已审核通过的档案盒有关的二级分类列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> scNameList() {
		return wareHouseStorageMapper.scNameList();
	}

	/**
	 * 获取已审核通过的档案盒年度列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> boxAnualList() {
		return wareHouseStorageMapper.boxAnualList();
	}

	/**
	 * 获取已审核通过的档案盒有关的保管期限名称列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> retentionperiodNameList() {
		return wareHouseStorageMapper.retentionperiodNameList();
	}

	/**
	 * 获取已审核通过的档案盒信息列表
	 */
	@Override
	public List<ArchiveInWareHouseAssist> boxNumberList() {
		return wareHouseStorageMapper.boxNumberList();
	}

	/**
	 * 入库弹框_库房编号下拉列表
	 */
	@Override
	public List<WareHouseBuild> listWareHouseNumber() {
		return wareHouseStorageMapper.listWareHouseNumber();
	}

	/**
	 * 入库弹框_根据库房编号获取密集架号
	 */
	@Override
	public List<WareHouseBuild> listWareHouseShelfNumber(String wareHouseBuildId) {
		return wareHouseStorageMapper.listWareHouseShelfNumber(wareHouseBuildId);
	}

	/**
	 * 入库弹框_库房编号和密集架编号获取组编号
	 */
	@Override
	public List<WareHouseBuild> listWareHouseGroupNumber(String wareHouseBuildId) {
		return wareHouseStorageMapper.listWareHouseGroupNumber(wareHouseBuildId);
	}

	/**
	 * 入库弹框_根据库房编号、密集架号和租号获取格子号
	 */
	@Override
	public List<WareHouseBuild> listWareHouseLatticeNumber(String wareHouseBuildId) {
		return wareHouseStorageMapper.listWareHouseLatticeNumber(wareHouseBuildId);
	}

	/**
	 * 档案入库编辑_获取密集架编号列表
	 */
	@Override
	public List<WareHouseBuild> listWareHouseShelfNumbers() {
		return wareHouseStorageMapper.listWareHouseShelfNumbers();
	}

	/**
	 * 档案入库编辑_获取组编号列表
	 */
	@Override
	public List<WareHouseBuild> listWareHouseGroupNumbers() {
		return wareHouseStorageMapper.listWareHouseGroupNumbers();
	}

	/**
	 * 档案入库编辑_获取格子编号列表
	 */
	@Override
	public List<WareHouseBuild> listWareHouseLatticeNumbers() {
		return wareHouseStorageMapper.listWareHouseLatticeNumbers();
	}

	/**
	 * 编辑_查询新生成的架位号对应的入库表主键
	 */
	@Override
	public String storageIdShow(String storageRackNumber) {
		return wareHouseStorageMapper.storageIdShow(storageRackNumber);
	}

}
