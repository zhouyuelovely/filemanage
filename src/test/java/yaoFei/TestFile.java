package yaoFei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.warningandediting.pojo.ExpiredFile;
import filemanage.warningandediting.service.ExpiredFileService;

public class TestFile {
	@Test
	public void testQueryFile() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		ExpiredFileService service = (ExpiredFileService) context.getBean("expiredFileService");
		//List<ExpiredFile> list = service.queryFileByQzName(0, 122, "");
		List<ExpiredFile> list = service.queryAllExpiredFile(0, 122);
		for (ExpiredFile expiredFile : list) {
			System.out.println("expiredFile+++" + expiredFile);
		}
	}

	@Test
	public void testCount() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		ExpiredFileService service = (ExpiredFileService) context.getBean("expiredFileService");
		Integer count = service.countExpiredFile();
		System.out.println("count+++" + count);
	}
	
	@Test
	public void testTime() throws Exception {
		// 计算剩余天数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 当天的时间
		Date date1 = new Date();
		Calendar c = Calendar.getInstance();  
		c.setTime(date1);  
		c.add(Calendar.DATE, 3);  
		System.out.println("endDate++++"+sdf.format(c.getTime())); 
		String endDate = sdf.format(c.getTime());
		Date date2 = sdf.parse(endDate);
		// 计算剩余天数
		long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
		System.out.println("days3++++"+days3); 
	}
	
}
