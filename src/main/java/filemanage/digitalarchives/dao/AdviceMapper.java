package filemanage.digitalarchives.dao;

import java.util.List;

import filemanage.digitalarchives.pojo.Advice;
import filemanage.digitalarchives.pojo.Reply;

/**
 * 交流中心
 * @author 陈一达
 * DAO
 */
public interface AdviceMapper {
	
	/**
	 * 关键词查询咨询建议
	 * @param advice
	 * @return
	 */
	List<Advice> adviceQuery(Advice advice);
	
	/**
	 * 查询总咨询数
	 * @param advice
	 * @return
	 */
	int adviceCount(Advice advice);
	
	/**
	 * 查询单个咨询建议信息(查看)
	 * @param advice
	 * @return
	 */
	Advice adviceSelect(Advice advice);
	
	/**
	 * 新增咨询建议
	 * @param advice
	 * @return
	 */
	int insertAdvice(Advice advice);
	
	/**
	 * 新增管理员回复
	 * @param reply
	 * @return
	 */
	int insertReply(Reply reply);
	
	/**
	 * 更新咨询建议表的回复主键
	 * @param advice
	 * @return
	 */
	int updateAdvice(Advice advice);
}
