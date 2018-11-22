package filemanage.utils.aop.annotation;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.dao.LoggingProduceMapper;
import filemanage.utils.aop.LoggingTool;

@Aspect
@Component
public class ProduceLoggingTool {
	private Logger logger=Logger.getLogger(ProduceLoggingTool.class);//控制台日志记录
	@Autowired
	private LoggingProduceMapper loggingProduceMapper;
	@Around("within(filemanage..*) && @annotation(loggingTool)")
	public Object doArundMethod(ProceedingJoinPoint pjd,LoggingTool loggingTool) throws Throwable {
		logger.info("监听日志记录执行开始时间······");
		long startTime = System.currentTimeMillis();// 开始时间
		
		User user=HavingUserInfor.havingUser();
		logger.info("监听日志记录获取用户的信息:"+user);
		
		Object[] params = pjd.getArgs();
		logger.info("监听日志记录到传入参数为:");
		for (Object param : params) {
			logger.info(param);
		}
		
		Object result = pjd.proceed();
		logger.info("监听日志记录返回参数为:" + result);
		
		logger.info("监听日志记录结束时间······");
		long endTime = System.currentTimeMillis();// 结束时间
		float excTime = (float) (endTime - startTime) / 1000;
		logger.info("监听日志记录方法执行总时间:" + excTime + "s");
		logger.info("监听日志记录监听到用户行为为:"+loggingTool.operCon());
		Boolean produceLogging=loggingProduceMapper.addLoogingProduce(loggingTool.operCon(), user.getUserId())>0;
		if(produceLogging) {
			logger.info("日志添加成功");
		}else {
			logger.info("日志添加失败");
		}
		return result;
	}
	
}
