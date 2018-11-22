package filemanage.collectandorganize.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.dao.KnowledgeBaseMapper;
import filemanage.collectandorganize.pojo.KnowledgeBase;
import filemanage.collectandorganize.service.KnowledgeBaseService;


/**
 * @author tchuanwu
 * 知识库业务层实现类
 */
@Transactional
@Service("knowledgeBaseService")
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {
	
	@Autowired
	private KnowledgeBaseMapper knowledgeBaseMapper;
	private Logger logger=Logger.getLogger(KnowledgeBaseServiceImpl.class);

	@Override
	public List<KnowledgeBase> queryKnowledgeByType(String KnowledgeType) {
		logger.info("根据知识库类型查询知识库");
		return knowledgeBaseMapper.queryKnowledgeByType(KnowledgeType);
	}

	@Override
	public KnowledgeBase queryKnowledgeById(String knowledgeId) {
		 logger.info("根据知识库主键查询知识库");
		return knowledgeBaseMapper.queryKnowledgeById(knowledgeId);
	}

	@Override
	public int addKnowledgeBase(KnowledgeBase know) {
		 logger.info("添加知识库");
		return knowledgeBaseMapper.addKnowledgeBase(know);
	}

	@Override
	public int isExitKnowledgeDocumentNum(KnowledgeBase know) {
		 logger.info("根据知识库文号查询知识库文号是否存在,>=0 存在 ,<0 不存在");
		return knowledgeBaseMapper.isExitKnowledgeDocumentNum(know);
	}

	@Override
	public List<KnowledgeBase> queryAllKnowledgeBase(int before,int after) {
		logger.info("查询所有的知识库");
		return knowledgeBaseMapper.queryAllKnowledgeBase(before,after);
	}

	@Override
	public int countAllKnowledgeBase() {
		logger.info("查询知识库总条数");
		return knowledgeBaseMapper.countAllKnowledgeBase();
	}

	@Override
	public List<KnowledgeBase> queryKnowledgeByConditions(String conditions) {
		 logger.info("知识库关键词查找");
		return knowledgeBaseMapper.queryKnowledgeByConditions(conditions);
	}

	@Override
	public int countKnowledgeBaseByConditions(String conditions) {
		logger.info("知识库关键词查找条数");
		return knowledgeBaseMapper.countKnowledgeBaseByConditions(conditions);
	}

	@Override
	public int countKnowledgeByType(String KnowledgeType) {
		logger.info("根据不同标准显示不同条数 ");
		return knowledgeBaseMapper.countKnowledgeByType(KnowledgeType);
	}

	

}
