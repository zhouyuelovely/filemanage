package yaoFei;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.warningandediting.pojo.BorrowingFile;
import filemanage.warningandediting.service.BorrowingFileService;

public class TestBorrowing {

	@Test
	public void testBorrowingFile() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		BorrowingFileService service = (BorrowingFileService) context.getBean("borrowingFileService");
		List<BorrowingFile> list = service.queryBorrowingFile(0, 200);
		for (BorrowingFile borrowingFile : list) {
			System.out.println("borrowingFile+++" + borrowingFile);
		}
	}

	@Test
	public void testcountBorrowingFile() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		BorrowingFileService service = (BorrowingFileService) context.getBean("borrowingFileService");
		int list = service.countBorrowingFile();
		System.out.println("list+++" + list);
	}

	@Test
	public void testTime() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String beginTime = new String("2017-06-09");
		String endTime = new String("2017-05-08");
		Date sd1 = sdf.parse(beginTime);
		Date sd2 = sdf.parse(endTime);
		System.out.println("before++++++++"+sd1.before(sd2));
		System.out.println("after++++++++"+sd1.after(sd2));
	}
}
