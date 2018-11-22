package filemanage.login.util.getUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Archive;

/**
 * @author meng
 *用户相关信息
 */
public class HavingUserInfor {
	
	private Logger logger=Logger.getLogger(HavingUserInfor.class);
	/**
	 * 获取用户的详情信息
	 * @return 用户信息
	 */
	public static User havingUser() {
		HavingUserInfor hInfor=new HavingUserInfor();
		Subject subject = SecurityUtils.getSubject();
		User user=(User)subject.getSession().getAttribute("user");
		hInfor.logger.info("获取用户工具中监听到用户的信息为:"+user);
		HavingUserInfor.havingUserInfor();
		return user;
	}
	/**
	 * 获取用户所属全宗id
	 * @return
	 */
	public static String havingArchiveId() {
		HavingUserInfor hInfor=new HavingUserInfor();
		User user=HavingUserInfor.havingUser();//获取用户信息
		Archive archive=user.getArchive();
		String archiveId=archive.getQuanzongId();
		hInfor.logger.info("获取用户工具中监听到获取全宗主键");
		return archiveId;
	}
	
	public static User havingUserInfor() {
		HavingUserInfor hInfor=new HavingUserInfor();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		hInfor.logger.info("获取用户工具中监听到session中用户的信息为:"+user);
		return user;
	}
}
