package filemanage.inventoryandinquire.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.inventoryandinquire.controller.FileQueryController;
import filemanage.inventoryandinquire.dao.FileQueryMapper;
import filemanage.inventoryandinquire.service.FileQueryService;
import filemanage.inventoryandinquire.vo.BoxConditionVo;
import filemanage.inventoryandinquire.vo.BoxExtendVo;
import filemanage.inventoryandinquire.vo.FileConditionVo;
import filemanage.inventoryandinquire.vo.FileExtendVo;
import filemanage.inventoryandinquire.vo.HistoryDataConditionVo;
import filemanage.inventoryandinquire.vo.HistoryDataExtendVo;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.utils.layui.Layui;

@Service("fileQueryServiceImpl")
public class FileQueryServiceImpl implements FileQueryService {

	private Logger log = LoggerFactory.getLogger(FileQueryServiceImpl.class);

	@Autowired
	private FileQueryMapper fileQueryMapper;

	/**
	 * 统计盒子数量
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countBoxNum() throws Exception {
		return fileQueryMapper.countBoxNum();
	}

	/**
	 * 统计件数之和
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countBoxFileCasesNumber() throws Exception {
		return fileQueryMapper.countBoxFileCasesNumber();
	}

	/**
	 * 查询所有盒子信息(页面初始化数据)
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryBoxList(Integer limit, Integer page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<BoxExtendVo> data = fileQueryMapper.queryBoxList(map);
		Integer count = fileQueryMapper.countBoxNum();
		return Layui.data(count, data);
	}

	/**
	 * 按条件查询盒子信息
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryBoxListByCondition(BoxConditionVo boxConditionVo, Integer limit, Integer page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("boxConditionVo", boxConditionVo);
		List<BoxExtendVo> data = fileQueryMapper.queryBoxListByCondition(map);
		Integer count = fileQueryMapper.countBoxListByCondition(boxConditionVo);
		return Layui.data(count, data);
	}
	
	/**
	 * 查询所有件信息
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryFileList(Integer limit, Integer page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<FileExtendVo> data = fileQueryMapper.queryFileList(map);
		Integer count = fileQueryMapper.countFile();
		return Layui.data(count, data);
	}

	/**
	 * 按条件查询所有件信息
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryFileListByCondition(FileConditionVo fileConditionVo, Integer limit, Integer page)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("fileConditionVo", fileConditionVo);
		List<FileExtendVo> data = fileQueryMapper.queryFileListByCondition(map);
		Integer count = fileQueryMapper.countFileByCondition(fileConditionVo);
		return Layui.data(count, data);
	}

	/**
	 * 统计件数
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countFile() throws Exception {
		return fileQueryMapper.countFile();
	}

	/**
	 * 统计页数之和
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countArchivefilePages() throws Exception {
		return fileQueryMapper.countArchivefilePages();
	}

	/**
	 * 统计历史数据数量
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countHistoryDataNumber() throws Exception {
		return fileQueryMapper.countHistoryDataNumber();
	}

	/**
	 * 统计历史数据页数之和
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countHistoryDataPages() throws Exception {
		return fileQueryMapper.countHistoryDataPages();
	}

	/**
	 * 查询所有保管期限名称
	 * 
	 * @throws Exception
	 */
	@Override
	public List<AmMaSmRetentionperiod> queryRetentionperiodName() throws Exception {
		return fileQueryMapper.queryRetentionperiodName();
	}

	/**
	 * 根据盒子主键获取归档目录路径集合
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> findFilePathList(List<String> boxIdList) throws Exception {
		List<String> list = new ArrayList<String>();
		List<String> listTemp = new ArrayList<String>();
		List<String> boxAttachmentFile = new ArrayList<>();
		if (!boxIdList.isEmpty()) {
			list = fileQueryMapper.findBoxattachmentFilePathList(boxIdList);
			for (String string : list) {
				boxAttachmentFile.add(string.substring(0, string.lastIndexOf("/")));
			}
			for (int i = 0; i < boxAttachmentFile.size(); i++) {
				if (!listTemp.contains(boxAttachmentFile.get(i))) {
					listTemp.add(boxAttachmentFile.get(i));
				}
			}
		} else {
			throw new Exception("盒子主键集合为空,boxIdList=" + boxIdList);
		}
		return listTemp;
	}

	/**
	 * 查询盒附件表归档文件目录地址(在线打印归档文件目录)
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AmCoBoxattachment queryBoxattachmentFilePath(String boxId) throws Exception {
		AmCoBoxattachment amCoBoxattachment = null;
		if (!StringUtils.isEmpty(boxId)) {
			amCoBoxattachment = fileQueryMapper.queryBoxattachmentFilePath(boxId);
		} else {
			log.error("盒子主键为空,boxId=" + boxId);
		}
		return amCoBoxattachment;
	}
	
	/**
	 * 统计历史数据件数之和
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countHistoryData() throws Exception {
		return fileQueryMapper.countHistoryData();
	}
	
	/**
	 * 统计历史数据页数之和
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countHistoryDataPageSum() throws Exception {
		return fileQueryMapper.countHistoryDataPageSum();
	}
	
	/**
	 * 历史数据查询
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryHistoryData(Integer page, Integer limit) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<HistoryDataExtendVo> data = fileQueryMapper.queryHistoryData(map);
		Integer count = fileQueryMapper.countHistoryData();
		return Layui.data(count, data);
	}
	
	/**
	 * 按条件查询历史数据查询
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui queryHistoryDataByCondition(HistoryDataConditionVo historyDataConditionVo, Integer page, Integer limit)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		map.put("historyDataConditionVo", historyDataConditionVo);
		List<HistoryDataExtendVo> data = fileQueryMapper.queryHistoryDataByCondition(map);
		Integer count = fileQueryMapper.countHistoryDataByCondition(historyDataConditionVo);
		return Layui.data(count, data);
	}

	@Override
	public HavingInforBox queryBoxByCondition(BoxConditionVo boxConditionVo) throws Exception {
		HavingInforBox inforbox=new HavingInforBox();
		inforbox.setBoxNum(fileQueryMapper.countBoxListByCondition(boxConditionVo));
		inforbox.setFileNum(fileQueryMapper.countFileNumByCondition(boxConditionVo));
		return inforbox;
	}

	@Override
	public ArchiveFileHelpInfor queryFileByboxCondition(FileConditionVo fileConditionVo) throws Exception {
		ArchiveFileHelpInfor infofile=new ArchiveFileHelpInfor();
		infofile.setArchiveFileNumber(fileQueryMapper.countFileByCondition(fileConditionVo));
		infofile.setArchiveFilePage(fileQueryMapper.countFilePagesByCondition(fileConditionVo));
		return infofile;
	}

}
