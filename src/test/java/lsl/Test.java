package lsl;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.statistics.pojo.AmCoBoxReport;
import filemanage.statistics.service.AmCoBoxReportService;

public class Test {
	@org.junit.Test
	public void testQueryBox() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		AmCoBoxReportService service = (AmCoBoxReportService) context.getBean("amCoBoxReportService");
		List<AmCoBoxReport> list = service.queryQuanzongname(null);
		for (AmCoBoxReport amCoBoxReport : list) {
			System.out.println("amCoBoxReport+++" + amCoBoxReport);
		}
		
		Map<String, List<AmCoBoxReport>> map = service.queryByBox(null);
		System.out.println(map);
	}
}
