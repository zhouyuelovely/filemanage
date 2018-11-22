package meng;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.login.dao.LogMapper;
import filemanage.login.pojo.User;
import filemanage.login.service.LogService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml","classpath:spring-mvc-dao.xml"})
@WebAppConfiguration("src/main/resources")
public class TestLog {
	@Autowired
	private LogService logService;
	
	@Autowired
	private LogMapper logMapper;
	
	@Test
	public void testrRegisterUser() {
		User user=new User();
		user.setUserName("tom");
		user.setUserPassword("123456");
		Boolean result=logService.registerUser(user);
		Assert.assertTrue(result);
	}
	@Test
	public void testQueryUserByUserName() {
		User user=logService.queryUserByUserName("admin");
		System.out.println("test:"+user);
	}
	
	@Test
	public void TestMapperQueryUserByUserName() {
		User user=logMapper.queryUserByUserName("caohuahua");
		System.out.println("mapper:"+user);
	}
	
}
