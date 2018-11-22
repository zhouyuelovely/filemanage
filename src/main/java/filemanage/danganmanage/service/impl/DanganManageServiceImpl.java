package filemanage.danganmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.dao.ArchiveFileStoreMapper;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.danganmanage.dao.DanganManageMapper;
import filemanage.danganmanage.service.DanganManageService;
import filemanage.danganmanage.vo.AmCoBoxConditons;
import filemanage.danganmanage.vo.BoxCondition;
import filemanage.danganmanage.vo.QueryBoxByCondition;
import filemanage.danganmanage.vo.QueryFileByCondition;
import filemanage.danganmanage.vo.QueryHistoryByCondition;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;

@Transactional
@Service("danganManageService")
public class DanganManageServiceImpl implements DanganManageService {
	@Autowired
	private DanganManageMapper danganManageMapper;
	@Autowired
	private ArchiveFileStoreMapper archiveFileStoreMapper;
	
	@Override
	public Layui selectAllBox(int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		List<AmCoBox> listbox = danganManageMapper.selectAllBox(map);
		Integer countbox = danganManageMapper.countSelectAllBox();
		return Layui.data(countbox, listbox);
	}
	
	@Override
	public Integer countSelectAllBox() {
		
		return danganManageMapper.countSelectAllBox();
	}

	@Override
	public Integer countFileNumByBox() {
		
		return danganManageMapper.countFileNumByBox();
	}

	@Override
	public Layui queryAllBox(BoxCondition boxCondition, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("boxCondition", boxCondition);
		List<AmCoBox> listbox = danganManageMapper.queryAllBox(map);
		Integer countbox = danganManageMapper.countAllBox(boxCondition);
		return Layui.data(countbox, listbox);

	}

	@Override
	public Integer countFileNum(BoxCondition boxCondition) {

		return danganManageMapper.countFileNum(boxCondition);
	}

	@Override
	public Layui queryBoxByConditions(String conditions, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("conditions", conditions);
		List<AmCoBox> listbox = danganManageMapper.queryBoxByConditions(map);
		Integer countBoxByConditions = danganManageMapper.countBoxByConditions(conditions);
		return Layui.data(countBoxByConditions, listbox);

	}

	@Override
	public Integer countBoxByConditions(String conditions) {

		return danganManageMapper.countBoxByConditions(conditions);
	}

	@Override
	public Layui queryAllFile(BoxCondition boxCondition, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("boxCondition", boxCondition);
		List<AmCoArchivefile> listfile = danganManageMapper.queryAllFile(map);
		Integer countFile = danganManageMapper.countFileNum(boxCondition);
		return Layui.data(countFile, listfile);

	}

	@Override
	public Integer countFilePages(BoxCondition boxCondition) {

		return danganManageMapper.countFilePages(boxCondition);
	}

	@Override
	public Layui queryFileByConditions(String conditions, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("conditions", conditions);
		List<AmCoArchivefile> listfile = danganManageMapper.queryFileByConditions(map);
		Integer countFile = danganManageMapper.countFileByConditions(conditions);
		return Layui.data(countFile, listfile);

	}

	@Override
	public Integer countFileByConditions(String conditions) {

		return danganManageMapper.countFileByConditions(conditions);
	}

	@Override
	public HavingInforBox queryBoxByCondition(QueryBoxByCondition boxCondition) {
		HavingInforBox inforbox = new HavingInforBox();
		inforbox.setBoxNum(danganManageMapper.countBoxByCondition(boxCondition));
		inforbox.setFileNum(danganManageMapper.countFileNumByCondition(boxCondition));
		return inforbox;
	}

	@Override
	public ArchiveFileHelpInfor queryFileByCondition(QueryFileByCondition fileCondition) {
		ArchiveFileHelpInfor infofile = new ArchiveFileHelpInfor();
		infofile.setArchiveFileNumber(danganManageMapper.countFileNumByCondition2(fileCondition));
		infofile.setArchiveFilePage(danganManageMapper.countFilePagesByCondition(fileCondition));
		return infofile;
	}

	@Override
	public Layui queryHistoryByConditions(String conditions, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("conditions", conditions);
		List<QueryHistoryByCondition> listhistory = danganManageMapper.queryHistoryByConditions(map);
		Integer countHistoryData = danganManageMapper.countHistoryByConditions(conditions);
		return Layui.data(countHistoryData, listhistory);

	}

	@Override
	public Integer countHistoryByConditions(String conditions) {

		return danganManageMapper.countHistoryByConditions(conditions);
	}

	@Override
	public Layui queryAllHistoryData(BoxCondition boxCondition, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		map.put("boxCondition", boxCondition);
		List<QueryHistoryByCondition> listhistory = danganManageMapper.queryAllHistoryData(map);
		Integer countHistoryData = danganManageMapper.countAllHistoryData(boxCondition);
		return Layui.data(countHistoryData, listhistory);
	}

	@Override
	public Integer countAllHistoryData(BoxCondition boxCondition) {

		return danganManageMapper.countAllHistoryData(boxCondition);
	}

	@Override
	public List<HistoryAnnex> queryHistoryAnnexByHistoryId(String historydataId) {
		List<HistoryAnnex> listhistoryannex = danganManageMapper.queryHistoryAnnexByHistoryId(historydataId);

		for (HistoryAnnex historyAnnex : listhistoryannex) {
			historyAnnex.setHistoryannexPath(historyAnnex.getHistoryannexPath().replace("D:/file", "/resource"));
		}
		return listhistoryannex;
	}

	@Override
	public Integer countHistoryDataPages(BoxCondition boxCondition) {

		return danganManageMapper.countHistoryDataPages(boxCondition);
	}

	@Override
	public ArchiveFileHelpInfor queryHistoryDataByCondition(QueryFileByCondition fileCondition) {
		ArchiveFileHelpInfor infofile = new ArchiveFileHelpInfor();
		infofile.setArchiveFileNumber(danganManageMapper.countHistoryDataByCondition(fileCondition));
		infofile.setArchiveFilePage(danganManageMapper.countHistoryDataPagesByCondition(fileCondition));
		return infofile;
	}

	@Override
	public List<FileAttachment> queryFileAttachmentByArchiveFileId(String archiveFileId) {
		List<FileAttachment> fileAttachmentList = archiveFileStoreMapper
				.queryFileAttachmentByArchiveFileId(archiveFileId);
		for (FileAttachment fileAttachment : fileAttachmentList) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath());
		}
		return fileAttachmentList;
	}

	@Override
	public List<HistoryAnnex> queryHistoryAnnexByHistoryId2(String historydataId) {
		List<HistoryAnnex> listhistoryannex = danganManageMapper.queryHistoryAnnexByHistoryId(historydataId);
		for (HistoryAnnex historyAnnex : listhistoryannex) {
			historyAnnex.setHistoryannexPath(historyAnnex.getHistoryannexPath());
		}
		return listhistoryannex;
	}

	@Override
	public List<BoxCondition> queryPcByquanzongName(BoxCondition boxCondition) {

		return danganManageMapper.queryPcByquanzongName(boxCondition);
	}

	@Override
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName(BoxCondition boxCondition) {

		return danganManageMapper.queryBoxAnualByquanzongNameAndPcName(boxCondition);
	}

	@Override
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual(BoxCondition boxCondition) {

		return danganManageMapper.queryRpNameByquanzongNameAndPcNameAndBoxAnual(boxCondition);
	}

	@Override
	public HavingInforBox countBoxByCondition(BoxCondition boxCondition) {
		HavingInforBox inforbox = new HavingInforBox();
		inforbox.setBoxNum(danganManageMapper.countAllBox(boxCondition));
		inforbox.setFileNum(danganManageMapper.countFileBoxNumByCondition(boxCondition));
		return inforbox;
	}

	@Override
	public ArchiveFileHelpInfor queryFileByboxCondition(BoxCondition boxCondition) {
		ArchiveFileHelpInfor infofile = new ArchiveFileHelpInfor();
		infofile.setArchiveFileNumber(danganManageMapper.countFileNum(boxCondition));
		infofile.setArchiveFilePage(danganManageMapper.countFilePages(boxCondition));
		return infofile;
	}

	@Override
	public ArchiveFileHelpInfor queryHistoryDataByCondition(BoxCondition boxCondition) {
		ArchiveFileHelpInfor infofile = new ArchiveFileHelpInfor();
		infofile.setArchiveFileNumber(danganManageMapper.countAllHistoryData(boxCondition));
		infofile.setArchiveFilePage(danganManageMapper.countHistoryDataPages(boxCondition));
		return infofile;
	}

	@Override
	public List<BoxCondition> queryPcByquanzongName2(BoxCondition boxCondition) {

		return danganManageMapper.queryPcByquanzongName2(boxCondition);
	}

	@Override
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName2(BoxCondition boxCondition) {

		return danganManageMapper.queryBoxAnualByquanzongNameAndPcName2(boxCondition);
	}

	@Override
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual2(BoxCondition boxCondition) {

		return danganManageMapper.queryRpNameByquanzongNameAndPcNameAndBoxAnual2(boxCondition);
	}
	
	@Override
	public Layui selectAllFile2(int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		List<AmCoArchivefile> listfile=danganManageMapper.selectAllFile2(map);
		Integer countFileNum=danganManageMapper.countFileNumByBox();
		return Layui.data(countFileNum, listfile);
	}

	@Override
	public Integer countAllFilePages() {
		
		return danganManageMapper.countAllFilePages();
	}

	@Override
	public List<AmCoArchivefile> selectAllFile() {

		return danganManageMapper.selectAllFile();
	}

	@Override
	public List<BoxCondition> queryPcByquanzongName3(BoxCondition boxCondition) {

		return danganManageMapper.queryPcByquanzongName3(boxCondition);
	}

	@Override
	public List<BoxCondition> queryBoxAnualByquanzongNameAndPcName3(BoxCondition boxCondition) {

		return danganManageMapper.queryBoxAnualByquanzongNameAndPcName3(boxCondition);
	}

	@Override
	public List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual3(BoxCondition boxCondition) {

		return danganManageMapper.queryRpNameByquanzongNameAndPcNameAndBoxAnual3(boxCondition);
	}

	@Override
	public List<BoxCondition> queryAllQuanzongName3() {

		return danganManageMapper.queryAllQuanzongName3();
	}

	@Override
	public List<BoxCondition> queryAllQuanzongName() {

		return danganManageMapper.queryAllQuanzongName();
	}

	/**
	 * 边沿界面查询
	 */
	@Override
	public List<BoxCondition> queryAllQuanzongName2() {
		return danganManageMapper.queryAllQuanzongName2();
	}

	/**
	 * 边沿界面模糊查询
	 */
	@Override
	public List<AmCoArchivefile> fuzzyEditingFileTitle(String searchBody) throws Exception {
		return danganManageMapper.fuzzyEditingFileTitle(searchBody);
	}

	@Override
	public Layui selectAllHistoryData(int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int before = limit * (page - 1);
		int after = page * limit;
		map.put("before", before);
		map.put("after", after);
		List<QueryHistoryByCondition> listhistory = danganManageMapper.selectAllHistoryData(map);
		Integer countSelectAllHistoryData=danganManageMapper.countSelectAllHistoryData();
		return Layui.data(countSelectAllHistoryData, listhistory);
	}

	@Override
	public Integer countSelectAllHistoryData() {
		
		return danganManageMapper.countSelectAllHistoryData();
	}

	@Override
	public Integer countSelectAllHistoryDataPages() {
		
		return danganManageMapper.countSelectAllHistoryDataPages();
	}

	

	

	

}
