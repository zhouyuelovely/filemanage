package filemanage.systemmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.service.SystemSetupService;

/**
 * @author FYX
 *
 */
@Controller
@RequestMapping("/systemSetup")
public class SystemSetupController {

	private Logger log = LoggerFactory.getLogger(SystemSetupController.class);

	@Autowired
	private MessageNotificationService messageNotificationService;

	@Autowired
	private SystemSetupService systemSetupService;
	
	private User user;

	/**
	 * Goto SystemSetup WebPage
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goToSystemSetup")
	public @ResponseBody ModelAndView goToSystemSetup() throws Exception {
		user = HavingUserInfor.havingUser();
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mView.setViewName("/archiveManage/system_setup");
		return mView;
	}

	/**
	 * Goto ChangePassword WebPage
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goToChangePassword")
	public @ResponseBody ModelAndView goToChangePassword() throws Exception {
		user = HavingUserInfor.havingUser();
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mView.setViewName("/archiveManage/change_password");
		return mView;
	}
	
	/**
	 * Change	Password
	 * @param userPassword
	 * @param userNewPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody Integer changePassword(@RequestParam("userPassword") String userPassword,
			@RequestParam("userNewPassword") String userNewPassword) throws Exception {
		Integer num = 0;
		user = HavingUserInfor.havingUser();
		User user1 = new User();
		if (!StringUtils.isEmpty(userPassword) && !StringUtils.isEmpty(userNewPassword)
				&& !StringUtils.isEmpty(user.getUserName())) {
			user1.setUserName(user.getUserName());
			user1.setUserPassword(userPassword);
			Boolean bool = systemSetupService.comparingThePassword(user1);
			log.info("校验密码返回值:"+bool);
			if (bool) {
				user1.setUserPassword(userNewPassword);
				log.info("user1="+user1);
				num = systemSetupService.updateUserPasswordByUserName(user1);
			} else {
				return num = 0;
			}
		}else {
			log.error("系统设置用户名:"+user.getUserName());
			log.error("系统设置用户原密码:"+userPassword);
			log.error("系统设置用户新密码:"+userNewPassword);
		}
		return num;
	}

}
