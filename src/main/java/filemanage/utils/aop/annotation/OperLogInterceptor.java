package filemanage.utils.aop.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import filemanage.login.pojo.User;
import filemanage.utils.aop.OperLog;

@Aspect
@Component
public class OperLogInterceptor {
	
	private Logger logger=Logger.getLogger(OperLogInterceptor.class);
	
	
	
	@Around("within(filemanage..*) && @annotation(operLog)")
	public Object doAroundMethod(ProceedingJoinPoint pjd, OperLog operLog) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		
		User u = (User) session.getAttribute("user");
		long startTime = System.currentTimeMillis();// 开始时间
		// 获取请求参数
		Object[] params = pjd.getArgs();
		logger.info("监听到传入参数为:");
		for (Object param : params) {
			logger.info(param);
		}
		// ###################上面代码为方法执行前#####################
		Object result = pjd.proceed();// 执行方法，获取返回参数
		// ###################下面代码为方法执行后#####################
		logger.info("返回参数为:" + result);
		String userNaem = u.getUserName();
		String operType = operLog.operType();// 操作类型
		logger.info("操作人: " + userNaem + " 操作类型: " + operType);
		// 执行方法
		long endTime = System.currentTimeMillis();// 结束时间
		float excTime = (float) (endTime - startTime) / 1000;
		logger.info("执行时间:" + excTime + "s");
		return result;

	}

}
