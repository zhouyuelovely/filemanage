package filemanage.systemmanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.systemmanage.dao.MessageNotificationMapper;
import filemanage.systemmanage.pojo.MessageNotification;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;

@Service
public class MessageNotificationServiceImpl implements MessageNotificationService {
	private Logger log = Logger.getLogger(MessageNotificationServiceImpl.class);
	@Autowired
	private MessageNotificationMapper messageNotificationMapper;

	@Override // 页面展示
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui findMessageNotification(Integer limit, Integer page) {
		Layui layui = new Layui();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer begin = (page - 1) * limit + 1;
		Integer end = page * limit;
		map.put("begin", begin);
		map.put("end", end);
		List<MessageNotification> data = messageNotificationMapper.findMessageNotification(map);
		Integer count = messageNotificationMapper.countMessageNotification();
		return layui.data(count, data);
	}

	@Override // 更新文件状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateMessageNotification(String str) {
		List<String> list = new ArrayList<String>();
		String[] messageId = str.split(",");
		for (String string : messageId) {
			log.info("更新消息的主键为:" + string);
			list.add(string);
		}
		return messageNotificationMapper.updateMessageNotificationStart(list) == -1 ? true : false;
	}

	@Override // 统计未读消息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer countMessageNotificationStart() {
		return messageNotificationMapper.countMessageNotificationStart();
	}

	/**
	 * 添加消息
	 */
	@Override
	public Integer addMessageNotification(MessageNotification messageNotification) {
		return messageNotificationMapper.addMessageNotification(messageNotification);
	}

}
