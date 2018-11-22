package tchuanwu;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.login.pojo.User;
import filemanage.systemmanage.service.UserService;

/**
 * @author tchuanwu
 *  测试用户
 */
public class TestUser {
	/**
	 * 查询所有用户
	 */
	@Test
	public void testQueryAllUser() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		UserService service=(UserService)context .getBean("userService",UserService.class);
		List<User> userList=service.queryAllUser(0,3);
		for (User user : userList) {
			System.out.println(user);
		}
		Assert.assertNotNull(userList);
	}
	
	@Test
	public void testAddOneUser() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		UserService service=(UserService)context .getBean("userService",UserService.class);
		User user=new User();
		user.setUserCreateTime(new Date());
		user.setUserName("admin");
		user.setUserPassword("123456");
		user.setUserHostName("admin123");
		user.setUserIpAddress("192.168.0.28");
		user.setUserTelePhone("13802973654");
		user.setUserSex("男");
		int isExitUserName=service.isExitUserName(user);
		 int isExitIdNumber=service.isExitIdNumber(user);
		 int isExitTelPhone=service.isExitTelPhone(user);
		 int isExitWorkNumber=service.isExitWorkNumber(user);
		 if(isExitUserName>0) {
			 System.out.println("对不起,用户名已存在!");
		 }else if(isExitIdNumber>0) {
			 System.out.println("对不起,身份证号已存在!");
		 }else if(isExitTelPhone>0) {
			 System.out.println("对不起,手机号已存在!");
		 }else if(isExitWorkNumber>0) {
			 System.out.println("对不起,工号已存在!"); 
		 }else {
			 service.addUser(user);
			 System.out.println("用户添加成功!");
		 }
	}

}
