package filemanage.utils.aop.annotation;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.dao.MessageNotificationMapper;
import filemanage.systemmanage.pojo.MessageNotification;
import filemanage.utils.aop.MessageTool;
@Aspect
@Component
public class MessageNotificationTool {
	private Logger logger=Logger.getLogger(MessageNotificationTool.class);
	@Autowired
	private MessageNotificationMapper messageNotificationMapper;
	@Around("within(filemanage..*) && @annotation(messageTool)")
	public Object doArundMethod(ProceedingJoinPoint pjd,MessageTool messageTool)throws Throwable {
		logger.info("监听消息提醒执行开始时间······");
		long startTime = System.currentTimeMillis();// 开始时间
		
		User user=HavingUserInfor.havingUser();
		logger.info("监听消息提醒获取用户的信息:"+user);
		
		Object[] params = pjd.getArgs();
		logger.info("监听消息提醒到传入参数为:");
		for (Object param : params) {
			logger.info(param);
		}
		
		Object result = pjd.proceed();
		logger.info("监听消息提醒返回参数为:" + result);
		
		logger.info("监听消息提醒结束时间······");
		long endTime = System.currentTimeMillis();// 结束时间
		float excTime = (float) (endTime - startTime) / 1000;
		logger.info("监听消息提醒方法执行总时间:" + excTime + "s");
		logger.info("监听到消息提醒的中消息类型为:"+messageTool.messType());
		logger.info("监听到消息提醒中消息内容为:"+messageTool.messContent());
		
		//消息组装
		MessageNotification messageNotification=new MessageNotification();
		messageNotification.setMessageContent(messageTool.messContent());
		messageNotification.setMessageCreator(user.getUserName());
		messageNotification.setMessageType(messageTool.messType());
		messageNotificationMapper.addMessageNotification(messageNotification);
		return result;
	}
	
	
}
