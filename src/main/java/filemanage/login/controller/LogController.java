package filemanage.login.controller;

import java.net.InetAddress;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.login.pojo.User;
import filemanage.login.service.LogService;
import filemanage.login.util.getUser.HavingUserInfor;

/**
 * @author meng
 *用户管理后端控制器
 */
@Controller
@RequestMapping("/log")
public class LogController {
	private Logger logger=Logger.getLogger(LogController.class);
	
	@Autowired
	private LogService logService;
	
	
	
	/**
	 * 跳转到登录页面
	 * @return 登录视图
	 */
	@RequestMapping(value="/goLogin",method= {RequestMethod.GET,RequestMethod.POST})
	public String goLogin() {
		return "log/login";
	}
	/**
	 * 转跳用户注册
	 * @return 注册视图 
	 */
	@RequestMapping(value="/goRegister",method=RequestMethod.GET)
	public String goRegistered() {
		return "log/register";
	}
	/**
	 * 转跳密码重置提醒
	 * @return 密码重置视图
	 */
	@RequestMapping(value="/goResetPassword",method=RequestMethod.GET)
	public String geResetPassword() {
		return "log/retrieve-password";
	}
	/**
	 * 登录错误信息
	 * @param request 请求信息
	 * @param model 返回数据容器
	 * @return
	 */
	@RequestMapping(value="/login")
	public String showLoginForm(HttpServletRequest request,Model model) {
		String exceptionClassName=(String)request.getAttribute("shiroLoginFailure");
		
		String error=null;
		if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
			logger.info("用户名/密码错误");
			error="用户名/密码错误";
		}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			logger.info("用户名/密码错误");
			error="用户名/密码错误";
		}else if(exceptionClassName!=null) {
			logger.info("其他错误:"+exceptionClassName);
			error="其他错误:"+exceptionClassName;
		}
		model.addAttribute("error",error);
		return "log/login";
	}
	/**
	 * 注册用户的信息
	 * @param userName用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public @ResponseBody Boolean registerUser(@RequestParam("userName")String userName,@RequestParam("passwrod")String password)throws Exception {
		User user =new User();
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setUserCreateTime(new Date());
		user.setUserType("1");
		InetAddress addr = InetAddress.getLocalHost();
		String userHostName=addr.getHostName();//获取操作用户的主机
		String userIpAddress=addr.getHostAddress();//获取操作用户的ip地址
		user.setUserHostName(userHostName);
		user.setUserIpAddress(userIpAddress);
		return logService.registerUser(user);
	}
	/**
	 * 进入home页面
	 * @return
	 */
	@RequestMapping(value="/goHome",method=RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView mv=new ModelAndView();
		User user = HavingUserInfor.havingUser();
		mv.addObject("user", user);
		mv.addObject("sort", logService.filePremission(1, 1));
		mv.addObject("manage", logService.filePremission(2, 11));
		mv.addObject("arch", logService.filePremission(12, 12));
		mv.setViewName("/log/home");
		return mv;
	}
	 //退出登录
	   @RequestMapping(value = "/logout")
	   public String logout(HttpServletRequest request) throws Exception {
	       request.getSession().invalidate();
	       return "log/login";
	   }
	
}
