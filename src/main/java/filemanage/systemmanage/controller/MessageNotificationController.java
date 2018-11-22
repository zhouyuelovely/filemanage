package filemanage.systemmanage.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;

@Controller
@RequestMapping("/messageNotification")
public class MessageNotificationController {
	@Autowired
	private MessageNotificationService messageNotificationService;
	private User user;
	@RequestMapping(value="/goNotification")//进入消息提醒页面
	public String goNotification(HttpServletRequest request) {
		user=HavingUserInfor.havingUser();
		request.setAttribute("messageNum", messageNotificationService.countMessageNotificationStart());
		return "/archiveManage/notification";
	}
	
	@RequestMapping(value="/havingMessageNotification",method=RequestMethod.POST)//获取页面数据
	public @ResponseBody Layui havingMessageNotification(@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return messageNotificationService.findMessageNotification(limit, page);
	}
	@RequestMapping(value="/updateMessageNotificationStart",method=RequestMethod.POST)
	public @ResponseBody Boolean updateMessageNotificationStart(String str) {
		return messageNotificationService.updateMessageNotification(str);
	}
	
	@RequestMapping(value="/havingMessageNum",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Integer havingMessageNum() {
		return messageNotificationService.countMessageNotificationStart();
	}
}
