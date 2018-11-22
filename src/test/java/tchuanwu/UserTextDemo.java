package tchuanwu;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.service.UserService;

public class UserTextDemo {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		UserService service=(UserService)context .getBean("userService",UserService.class);
		User user = new User();
		Archive archive = new Archive();
		user.setUserId("14");
		archive.setQuanzongId("B7FBECDD119D4EF28837BD9503B2CF95");
		user.setArchive(archive);
		user.setQuanzongId(user.getArchive().getQuanzongId());
		List<User> userList=service.queryUserAllManager(user);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getUserName());
			System.out.println(userList.get(i).getQuanzongId());
			System.out.println(userList.get(i).getQuanzongName());
		}
		
	}
}
