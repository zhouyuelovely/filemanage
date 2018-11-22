package filemanage.systemmanage.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.systemmanage.dao.SecondryClassFicationMapper;
import filemanage.systemmanage.pojo.SecondryClassFication;
import filemanage.systemmanage.service.SecondryClassFicationService;


/**
 * @author tchuanwu
 * 二级分类业务层实现类
 */
@Transactional
@Service("secondryClassFicationService")
public class SecondryClassFicationServiceImpl implements SecondryClassFicationService {
	
	@Autowired
	private SecondryClassFicationMapper secondryClassFicationMapper;
	private Logger logger=Logger.getLogger(SecondryClassFicationServiceImpl.class);

	@Override
	public List<SecondryClassFication> queryAllSecondry(String pcId,@Param("scStatus") String scStatus,String quanzongid) {
		logger.info("根据一级分类主键和二级分类状态查询所有的二级分类");
		return secondryClassFicationMapper.queryAllSecondry(pcId,scStatus,quanzongid);
	}

	@Override
	public List<SecondryClassFication> querySecondryByPcId(String pcId) {
		 logger.info("根据一级分类主键查询二级分类");
		return secondryClassFicationMapper.querySecondryByPcId(pcId);
	}

	@Override
	public int addSecondryClass(SecondryClassFication secondry) {
		 logger.info("添加二级分类");
		return secondryClassFicationMapper.addSecondryClass(secondry);
	}

	@Override
	public Boolean delSecondryClassById(String scId) {
		 logger.info("根据二级分类主键删除二级分类");
		return secondryClassFicationMapper.delSecondryClassById(scId)>0;
	}

	@Override
	public int isExitSecondryClassName(SecondryClassFication secondry) {
		logger.info("判断二级分类名称是否存在,如果>=0,存在,<0 不存在");
		return secondryClassFicationMapper.isExitSecondryClassName(secondry);
	}

	@Override
	public int isExitSecondryClassCode(SecondryClassFication secondry) {
		logger.info("判断二级分类代码是否存在,如果>=0,存在,<0 不存在");
		return secondryClassFicationMapper.isExitSecondryClassCode(secondry);
	}

	@Override
	public int countArchiveFileByScId(String scId) {
		logger.info("根据二级分类主键查询文件表里是否有二级分类存在");
		return secondryClassFicationMapper.countArchiveFileByScId(scId);
	}

	@Override
	public List<SecondryClassFication> queryAllSc() {
		logger.info("查询所有的二级分类");
		return secondryClassFicationMapper.queryAllSc();
	}

}
