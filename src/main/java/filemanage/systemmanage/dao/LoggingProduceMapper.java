package filemanage.systemmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.LoggingProduce;
import filemanage.systemmanage.vo.LogginProduceCondition;
@Repository
public interface LoggingProduceMapper {
	/**
	 * 
	 * @param logContent
	 * @param userId
	 * @return
	 */
	Integer addLoogingProduce(@Param("logContent")String logContent,@Param("userId")String userId);
	/**
	 * 获取日志集合
	 * @param map 分页相关数据
	 * @return
	 */
	List<LoggingProduce> findLoggingProduce(Map<String, Object> map);
	/**
	 * 统计日志的总数
	 * @return
	 */
	Integer countLoggingProduce();
	/**
	 * 条件查询日志的集合 
	 * @param logginProduceCondition 条件 包括查询条件 分页相关数据
	 * @return
	 */
	List<LoggingProduce> findLoggingProduceByCondition(LogginProduceCondition logginProduceCondition);
	/**
	 * 统计日志的数量
	 * @param logginProduceCondition 日志查询条件
	 * @return
	 */
	Integer countLoggingProduceByCondition(LogginProduceCondition logginProduceCondition);
	/**
	 * 批量查询日志的集合
	 * @param list 日志主键的用于导出功能
	 * @return
	 */
	LoggingProduce expuctLoggingProduce(String logId);
}
