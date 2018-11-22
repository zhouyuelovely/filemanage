package filemanage.danganmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.danganmanage.dao.ManagerdetailsMapper;
import filemanage.danganmanage.pojo.Managerdetails;
import filemanage.danganmanage.service.ManagerdetailsService;
import filemanage.danganmanage.vo.DanganmanageCondition;
import filemanage.utils.layui.Layui;


/**
 * @author tchuanwu
 *  档案管理明细业务层实现类
 *
 */
@Transactional
@Service("managerdetailsService")
public class ManagerdetailsServiceImpl implements ManagerdetailsService {
	@Autowired
	private ManagerdetailsMapper managerdetailsMapper;

	@Override
	public int addManagerDetails(Managerdetails managerdetails) {
		return managerdetailsMapper.addManagerDetails(managerdetails);
	}

	@Override
	public List<Managerdetails> queryAllManagerdetails(String id,int before,int after) {
		
		return managerdetailsMapper.queryAllManagerdetails(id,before,after);
	}

	@Override
	public Integer countAllManagerdetails() {
		
		return managerdetailsMapper.countAllManagerdetails();
	}
	
	
	@Override
	public Layui queryManagerdetailsByConditions(DanganmanageCondition danganmanageCondition, Integer limit,
			Integer page) {
		Integer before = limit * (page-1);
		Integer after=page * limit; 
		danganmanageCondition.setBefore(before);
		danganmanageCondition.setAfter(after);
		List<Managerdetails> queryManagerdetailsByConditions=managerdetailsMapper.queryManagerdetailsByConditions(danganmanageCondition);
		Integer countManagerdetailsByConditions=managerdetailsMapper.countManagerdetailsByConditions(danganmanageCondition);		
		return Layui.data(countManagerdetailsByConditions, queryManagerdetailsByConditions);
	}
	

	@Override
	public Integer updateManagerdetailsById(Managerdetails managerdetails) {
		
		return managerdetailsMapper.updateManagerdetailsById(managerdetails);
	}

	@Override
	public List<Managerdetails> queryManagerdetailsByFile(int before,int after) {
		
		return managerdetailsMapper.queryManagerdetailsByFile(before,after);
	}

	@Override
	public Integer countManagerdetailsByFile() {
		
		return managerdetailsMapper.countManagerdetailsByFile();
	}

	@Override
	public  Layui queryManagerdetailsByFileConditions(DanganmanageCondition danganmanageCondition, Integer limit,Integer page) {
		Integer before = limit * (page-1);
		Integer after=page * limit; 
		danganmanageCondition.setBefore(before);
		danganmanageCondition.setAfter(after);
		List<Managerdetails> queryManagerdetailsByFileConditions=managerdetailsMapper.queryManagerdetailsByFileConditions(danganmanageCondition);
		Integer countManagerdetailsByFileConditions=managerdetailsMapper.countManagerdetailsByFileConditions(danganmanageCondition);
		return Layui.data(countManagerdetailsByFileConditions, queryManagerdetailsByFileConditions);
		
	}

	@Override
	public List<Managerdetails> queryManagerdetailsByHistoryData(int before, int after) {
		
		return managerdetailsMapper.queryManagerdetailsByHistoryData(before, after);
	}

	@Override
	public Integer countManagerdetailsByHistoryData() {
		
		return managerdetailsMapper.countManagerdetailsByHistoryData();
	}

	@Override
	public List<Managerdetails> queryManagerdetailsByFileShenghe(int before, int after) {
		
		return managerdetailsMapper.queryManagerdetailsByFileShenghe(before, after);
	}

	@Override
	public Integer countManagerdetailsByFileShenghe() {
		
		return managerdetailsMapper.countManagerdetailsByFileShenghe();
	}

	@Override
	public  Layui queryManagerdetailsByFileShenheConditions(DanganmanageCondition danganmanageCondition, Integer limit,Integer page) {
		Integer before = limit * (page-1);
		Integer after=page * limit; 
		danganmanageCondition.setBefore(before);
		danganmanageCondition.setAfter(after);
		List<Managerdetails> queryManagerdetailsByFileShenheConditions=managerdetailsMapper.queryManagerdetailsByFileShenheConditions(danganmanageCondition);
		Integer countManagerdetailsByFileShenheConditions=managerdetailsMapper.countManagerdetailsByFileShenheConditions(danganmanageCondition);
		return Layui.data(countManagerdetailsByFileShenheConditions, queryManagerdetailsByFileShenheConditions);
		
	}

	@Override
	public Layui queryManagerdetailsByHistoryDataConditions(DanganmanageCondition danganmanageCondition, Integer limit,
			Integer page) {
		Integer before = limit * (page-1);
		Integer after=page * limit; 
		danganmanageCondition.setBefore(before);
		danganmanageCondition.setAfter(after);
		List<Managerdetails> queryManagerdetailsByHistoryDataConditions=managerdetailsMapper.queryManagerdetailsByHistoryDataConditions(danganmanageCondition);
		Integer countManagerdetailsByHistoryDataConditions=managerdetailsMapper.countManagerdetailsByHistoryDataConditions(danganmanageCondition);
		return Layui.data(countManagerdetailsByHistoryDataConditions, queryManagerdetailsByHistoryDataConditions);
	}

	@Override
	public Integer updateManagerdetailsByIsDelete(String managerDetailsId) {
		
		return managerdetailsMapper.updateManagerdetailsByIsDelete(managerDetailsId);
	}

	@Override
	public List<Managerdetails> queryManagerdetailsByBoxShenhe(int before, int after) {
		
		return managerdetailsMapper.queryManagerdetailsByBoxShenhe(before, after);
	}

	@Override
	public Integer countManagerdetailsByBoxShenhe() {
		
		return managerdetailsMapper.countManagerdetailsByBoxShenhe();
	}

	

	

	

}
