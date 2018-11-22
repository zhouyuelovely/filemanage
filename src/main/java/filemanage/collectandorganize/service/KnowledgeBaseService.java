package filemanage.collectandorganize.service;

import java.util.List;
import java.util.Map;

import filemanage.collectandorganize.pojo.KnowledgeBase;

/**
 * @author tchuanwu
 * 知识库业务层接口
 */
public interface KnowledgeBaseService {
	
	/**
	 * 查询所有的知识库
	 * @return
	 */
	List<KnowledgeBase> queryAllKnowledgeBase(int before,int after);
	
	/**
	 * 根据知识库类型查询知识库
	 * @param KnowledgeType
	 * @return
	 */
	List<KnowledgeBase> queryKnowledgeByType(String KnowledgeType);
	/**
	 * 根据知识库主键查询知识库
	 * @param knowledgeId
	 * @return
	 */
	KnowledgeBase queryKnowledgeById(String knowledgeId);
	/**
	 * 添加知识库
	 * @param know
	 * @return
	 */
	int addKnowledgeBase(KnowledgeBase know);
	
	/** 根据文号查询知识库文号是否存在
	 * >=0 存在  <0 不存在
	 * @param know
	 * @return
	 */
	int isExitKnowledgeDocumentNum(KnowledgeBase know);
	
	/**
	 * 查询总条数
	 * @return
	 */
	int countAllKnowledgeBase();
	
	/**
	 * 知识库关键词查询
	 * @param conditions
	 * @return
	 */
	List<KnowledgeBase> queryKnowledgeByConditions(String conditions);
	
	/**
	 * 知识库关键词查询条数
	 * @param conditions
	 * @return
	 */
	int countKnowledgeBaseByConditions(String conditions);
	
	/**
	 * 根据不同标准显示不同条数
	 * @param KnowledgeType
	 * @return
	 */
	int countKnowledgeByType(String KnowledgeType);

}
