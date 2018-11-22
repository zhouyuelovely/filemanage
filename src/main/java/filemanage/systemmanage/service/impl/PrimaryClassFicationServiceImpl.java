package filemanage.systemmanage.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.systemmanage.dao.PrimaryClassFicationMapper;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.service.PrimaryClassFicationService;
import filemanage.utils.JSON;
import filemanage.utils.page.PageBean;


/**
 * @author tchuanwu
 * 一级分类业务层实现类
 */
@Transactional
@Service("primaryClassFicationService")
public class PrimaryClassFicationServiceImpl implements PrimaryClassFicationService {
	
	 @Autowired
	 private PrimaryClassFicationMapper primaryClassFicationMapper;
	 
	 private Logger logger=Logger.getLogger(PrimaryClassFicationServiceImpl.class);

	@Override
	public List<PrimaryClassFication> queryAllPrimaryClass() {
		 logger.info("查询所有的一级分类");
		return primaryClassFicationMapper.queryAllPrimaryClass();
	}

	@Override
	public int addPrimaryClass(PrimaryClassFication primaryClass) {
		 logger.info("添加一级分类,返回布尔值,true:添加成功, false:添加失败");
		return primaryClassFicationMapper.addPrimaryClass(primaryClass);
	}

	@Override
	public int isExitPrimaryClassName(PrimaryClassFication primaryClass) {
		 logger.info("判断一级分类名称是否存在,如果>=0,存在,<0 不存在");
		return primaryClassFicationMapper.isExitPrimaryClassName(primaryClass);
	}

	@Override
	public int isExitPrimaryClassCode(PrimaryClassFication primaryClass) {
		logger.info("判断一级分类代码是否存在,如果>=0,存在,<0 不存在");
		return primaryClassFicationMapper.isExitPrimaryClassCode(primaryClass);
	}

	@Override
	public String selectAllPc() {
		String result=JSON.queryAllClass(primaryClassFicationMapper.selectAllPc());
		logger.info("结果"+result);
		return result;
	}

	@Override
	public String queryScByIdAndStatus(String pcDescription) {
		String result=JSON.queryAllClass(primaryClassFicationMapper.queryScByIdAndStatus(pcDescription));
		logger.info("结果"+result);
		return result;
	}
	/**
	 * 根据全宗id查询二级机构分类
	 */
	@Override
	public List<PrimaryClassFication> queryScByOrg(@Param("quanzongid")String quanzongid) {
		logger.info("遍历文书档案的机构分类");
		return primaryClassFicationMapper.queryScByOrg(quanzongid);
	}

	@Override
	public List<PrimaryClassFication> queryAllPcById() {
		logger.info("遍历文书档案下的所有分类");
		return primaryClassFicationMapper.queryAllPcById();
	}

	@Override
	public Integer countAllPc() {
		logger.info("统计所有的一级分类条数");
		return primaryClassFicationMapper.countAllPc();
	}

	
	@Override
	public PageBean<PrimaryClassFication> queryAllPc(String scStatus, Integer currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<PrimaryClassFication> pageBean=new PageBean<PrimaryClassFication>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    int totalCount =primaryClassFicationMapper.countPcByStatus(scStatus);
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
		map.put("before", (currentPage - 1) * pageSize);
		map.put("after", pageBean.getPageSize());
	    map.put("scStatus", scStatus);
	    List<PrimaryClassFication> lists=primaryClassFicationMapper.queryAllPc(map);
	    pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public PageBean<PrimaryClassFication> queryAllScByPc(String scStatus, Integer currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<PrimaryClassFication> pageBean=new PageBean<PrimaryClassFication>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    int totalCount =primaryClassFicationMapper.countPcByStatus(scStatus);
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
		map.put("before", (currentPage - 1) * pageSize);
		map.put("after", pageBean.getPageSize());
	    map.put("scStatus", scStatus);
	    List<PrimaryClassFication> lists=primaryClassFicationMapper.queryAllScByPc(map);
	    pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public PageBean<PrimaryClassFication> findByPage(Integer currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<PrimaryClassFication> pageBean=new PageBean<PrimaryClassFication>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    int totalCount =primaryClassFicationMapper.countPcByStatus("1");
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
		map.put("before", (currentPage - 1) * pageSize);
		map.put("after", pageBean.getPageSize());
		 map.put("scStatus", "1");
		 List<PrimaryClassFication> lists=primaryClassFicationMapper.queryAllPc(map);
		  pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public PageBean<PrimaryClassFication> findByPage2(Integer currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<PrimaryClassFication> pageBean=new PageBean<PrimaryClassFication>();
		 //获取当前页数
		pageBean.setCurrPage(currentPage);
		// 每页显示的数据
		int pageSize = 8;
	    pageBean.setPageSize(pageSize);
	    int totalCount =primaryClassFicationMapper.countPcByStatus("0");
	    pageBean.setTotalCount(totalCount);
	    // 封装总页数
	 	double tc = totalCount;
	 	Double num = Math.ceil(tc / pageSize);// 向上取整
	 	pageBean.setTotalPage(num.intValue());
		map.put("before", (currentPage - 1) * pageSize);
		map.put("after", pageBean.getPageSize());
		 map.put("scStatus", "0");
		 List<PrimaryClassFication> lists=primaryClassFicationMapper.queryAllScByPc(map);
		 pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public Boolean deletePcByPcId(String pcId) {
		
		return primaryClassFicationMapper.deletePcByPcId(pcId);
	}

	@Override
	public int countPcIdBySc(String pcId) {
		
		return primaryClassFicationMapper.countPcIdBySc(pcId);
	}

	

	

	


}
