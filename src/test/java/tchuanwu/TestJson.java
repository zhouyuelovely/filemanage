package tchuanwu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.systemmanage.dao.PrimaryClassFicationMapper;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.service.PrimaryClassFicationService;
import filemanage.utils.JSON;

public class TestJson {
	
	@Test
	public void testJson() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		PrimaryClassFicationService service=(PrimaryClassFicationService) context.getBean("primaryClassFicationService",PrimaryClassFicationService.class);
		String pc=service.selectAllPc();
		System.out.println(pc);
	}
	@Test
	public void testList() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		PrimaryClassFicationMapper primaryClassFicationMapper=(PrimaryClassFicationMapper)context.getBean("primaryClassFicationMapper");
		List<PrimaryClassFication> list=primaryClassFicationMapper.selectAllPc();
		assertNotNull(list);
		for (PrimaryClassFication primaryClassFication : list) {
			System.out.println(primaryClassFication);
		}
	}
	

}
