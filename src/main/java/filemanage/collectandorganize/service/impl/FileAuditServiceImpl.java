package filemanage.collectandorganize.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.collectandorganize.dao.FileAuditMapper;
import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.service.FileAuditService;
import filemanage.collectandorganize.vo.BoxAuditHelp;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxPageInfo;
import filemanage.collectandorganize.vo.BoxVo;
import filemanage.utils.layui.Layui;

@Service
public class FileAuditServiceImpl implements FileAuditService {
	@Autowired
	private FileAuditMapper fileAuditMapper;

	/**
	 * 展示所以档案盒
	 */
	@Override
	public Layui findAmcBox(Integer limit,Integer page) {
		
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("begin", begin);
		map.put("end", end);
		List<BoxVo> findAmcBox = fileAuditMapper.findAmcBox(map);
		Integer count = fileAuditMapper.countBoxNum();
		return Layui.data(count, findAmcBox);
	}

	@Override
	public BoxPageInfo havingPageInfo() {
		BoxPageInfo boxPageInfo = new BoxPageInfo();
		boxPageInfo.setBoxNum(fileAuditMapper.countBoxNum());
		boxPageInfo.setFileNum(fileAuditMapper.countArchiveFileNum());
		return boxPageInfo;
	}

	@Override
	public List<BoxAuditHelp> listArchiveInfo() {
		return fileAuditMapper.listArchiveInfo();
	}

	@Override
	public List<BoxAuditHelp> listAnualByArchiveId(String archiveId) {
		return fileAuditMapper.listAnualByArchiveId(archiveId);
	}

	/**
	 * 根据全宗主键和年度进行筛选
	 */
	@Override
	public Layui findAmcBoxAnualAndArchiveId(String anual, String archiveId, Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("anual", anual);
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		List<BoxVo> findAmcBox = fileAuditMapper.findAmcBoxAnualAndArchiveId(map);
		Integer count = fileAuditMapper.countBoxNumAnualAndArchiveId(anual, archiveId);
		return Layui.data(count, findAmcBox);
	}

	/**
	 * 根据全宗主键和年度查询
	 */
	@Override
	public BoxPageInfo havingPageInfoAnualAndArchiveId(String anual, String archiveId) {
		BoxPageInfo boxPageInfo = new BoxPageInfo();
		boxPageInfo.setBoxNum(fileAuditMapper.countBoxNumAnualAndArchiveId(anual, archiveId));
		boxPageInfo.setFileNum(fileAuditMapper.countArchiveFileNumAnualAndArchiveId(anual, archiveId));
		return boxPageInfo;
	}

	/**
	 * 条件查询档案盒信息
	 */
	@Override
	public Layui findAmcBoxCondition(BoxByCondition boxByCondition, Integer limit, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("archiveId", boxByCondition.getArchiveId());
		map.put("begin", begin);
		map.put("end", end);
		map.put("annual", boxByCondition.getAnual());
		map.put("codition", boxByCondition.getCodition());
		List<BoxVo> findAmcBox = fileAuditMapper.findAmcBoxCondition(map);
		Integer count = fileAuditMapper.countArchiveFileNumCondition(boxByCondition);
		return Layui.data(count, findAmcBox);
	}

	/**
	 * 条件查询档案盒信息
	 */
	@Override
	public BoxPageInfo havingPageInfofindAmcBoxCondition(BoxByCondition boxByCondition) {
		BoxPageInfo boxPageInfo = new BoxPageInfo();
		boxPageInfo.setBoxNum(fileAuditMapper.countBoxNumCondition(boxByCondition));
		boxPageInfo.setFileNum(fileAuditMapper.countArchiveFileNumCondition(boxByCondition));
		return boxPageInfo;
	}

	@Override
	public Boolean updateGood(String anual, String archiveId) {
		return fileAuditMapper.updateGood(anual, archiveId) > 0;
	}

	@Override
	public Boolean updateBad(String anual, String archiveId) {
		return fileAuditMapper.updateBad(anual, archiveId) > 0;
	}

	@Override
	public Boolean addReturnFor(ReturnInfoBox returnInfoBox) {
		return fileAuditMapper.addReturnFor(returnInfoBox) > 0;
	}
	
	@Override
	public Integer queryReturnFor(String boxId) {
		return fileAuditMapper.queryReturnFor(boxId);
	}

	@Override
	public Boolean updateReturnFor(String returnInfoReson, String returnInfoId) {
		return fileAuditMapper.updateReturnFor(returnInfoReson, returnInfoId) > 0;
	}

}
