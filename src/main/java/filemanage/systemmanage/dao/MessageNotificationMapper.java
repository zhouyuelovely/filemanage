package filemanage.systemmanage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import filemanage.systemmanage.pojo.MessageNotification;

@Repository
public interface MessageNotificationMapper {
	/**
	 * 添加消息
	 * @param messageNotification
	 * @return
	 */
	Integer addMessageNotification(MessageNotification messageNotification);
	/**
	 * 获取消息的集合
	 * @return 
	 */
	List<MessageNotification> findMessageNotification(Map<String, Object> map);
	/**
	 * 统计消息的数量
	 * @return
	 */
	Integer countMessageNotification();
	/**
	 * 根据主键查询消息
	 * @param messageId 消息主键
	 * @return 
	 */
	MessageNotification queryMessageNotification(String messageId);
	/**
	 * 批量更新消息状态
	 * @param list 消息主键的集合
	 * @return
	 */
	Integer updateMessageNotificationStart(List<String> list);
	/**
	 * 统计未读消息
	 * @return
	 */
	Integer countMessageNotificationStart();
}
