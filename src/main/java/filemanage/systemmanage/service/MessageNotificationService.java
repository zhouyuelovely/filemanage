package filemanage.systemmanage.service;

import filemanage.systemmanage.pojo.MessageNotification;
import filemanage.utils.layui.Layui;

/**
 * @author meng 消息
 */
public interface MessageNotificationService {
	/**
	 * 消息展示
	 * 
	 * @param limit
	 *            每页数量
	 * @param page
	 *            当前页数
	 * @return
	 */
	Layui findMessageNotification(Integer limit, Integer page);

	/**
	 * 更新消息状态
	 * 
	 * @param str
	 *            消息主键的集合字符串
	 * @return
	 */
	Boolean updateMessageNotification(String str);

	/**
	 * 统计未读消息
	 * 
	 * @return
	 */
	Integer countMessageNotificationStart();

	/**
	 * 添加消息
	 * 
	 * @param messageNotification
	 * @return
	 */
	Integer addMessageNotification(MessageNotification messageNotification);
}
