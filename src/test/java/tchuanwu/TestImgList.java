package tchuanwu;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.collectandorganize.dao.IdentificationMapper;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.IdentificationService;
import filemanage.utils.page.PageBean;

/**
 * @author Administrator
 * 文件图片测试类
 */
public class TestImgList {
	
	@Test
	public void testImgList() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		IdentificationService service=(IdentificationService)context.getBean("identificationService",IdentificationService.class);
		
		
	}
	
	@Test
	public void testAnual() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		IdentificationMapper id=(IdentificationMapper)context.getBean("identificationMapper");
		List<ArchiveFile> list=id.queryFileByAnualAndStatus("01FE498598ED4813AD7FFE2CBC31F871");
		for (ArchiveFile archiveFile : list) {
			System.out.println(archiveFile);
		}
		
	}
	

}
