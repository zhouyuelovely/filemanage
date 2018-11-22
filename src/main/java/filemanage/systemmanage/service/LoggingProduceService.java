package filemanage.systemmanage.service;

import filemanage.systemmanage.vo.LogginProduceCondition;
import filemanage.utils.layui.Layui;

public interface LoggingProduceService {
	/**
	 * 获取日志的集合
	 * @param limit 每页数据
	 * @param page 当前页数
	 * @return
	 */
	Layui findLoggingProduce(Integer limit,Integer page);
	/**
	 * 条件查询日志信息
	 * @param logginProduceCondition 查询条件
	 * @param limit 每页数据
	 * @param page 当前页数
	 * @return
	 */
	Layui findLoggingProduceByCondition(LogginProduceCondition logginProduceCondition,Integer limit,Integer page);
	/**
	 * 导出日志的
	 * @param LoggingProduceIds 日志的集合
	 * @return
	 */
	String expectLoggingProduce(String str,String path)throws Exception ;
}
