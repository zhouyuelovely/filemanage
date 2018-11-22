package yaoFei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.warningandediting.pojo.EditingFile;
import filemanage.warningandediting.service.EditingFileService;

public class TestEditing {

	@Test
	public void testEditingFile() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		EditingFileService service = (EditingFileService) context.getBean("editingFileService");
		List<EditingFile> list = service.queryEditingFile(0, 100);
		for (EditingFile editingFile : list) {
			System.out.println("editingFile+++" + editingFile);
		}
	}

	@Test
	public void testCountEditingFile() throws Exception {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		EditingFileService service = (EditingFileService) context.getBean("editingFileService");
		int count = service.countEditingFile();
		System.out.println("count+++" + count);*/
		String baoGuan = "10年";
		/*String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(a);  
		System.out.println( m.replaceAll("").trim());*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 当天的时间
		Date date1 = new Date();
		// 计算到期日期
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(baoGuan);  
		System.out.println(m.replaceAll("").trim());
		c.add(Calendar.DATE, Integer.parseInt(m.replaceAll("").trim()) * 365);
		// 获得到期日期
		String endDate = sdf.format(c.getTime());
		System.out.println("endDate++++" + endDate);
		Date date2 = sdf.parse(endDate);
		// 计算剩余天数
		long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
		System.out.println("days3++++" + days3);
		// 获得预警天数
		String warningDays = days3 + "天";
		System.out.println("warningDays++++" + warningDays);
	}
}
