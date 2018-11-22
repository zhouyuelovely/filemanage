package tchuanwu;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.digitalarchives.pojo.InformationPortal;
import filemanage.digitalarchives.pojo.Picturecarousel;
import filemanage.digitalarchives.service.InformationPortalService;

/**
 * @author tchuanwu
 * 档案信息门户测试类
 */
public class TestInformationPortal {
	/**
	 * 测试所有已发布的信息
	 */
	@Test
	public void testQueryAllInformation() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		List<InformationPortal> listInformation=service.queryAllInformation(0,3);
		for (InformationPortal informationPortal : listInformation) {
			System.out.println(informationPortal);
		}
	}
	
	/**
	 * 添加信息
	 */
	@Test
	public void testAddInformation() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		InformationPortal info=new InformationPortal();
		info.setiPContent("档案为下岗职工找到养老依据");
		info.setiPDocumentNum("档发[2018]1号");
		info.setiPForm("直接发布");
		info.setiPFormDate(new Date());
		info.setiPIndexNum("2018-1");
		info.setiPName("档案为下岗职工找到养老依据");
		info.setiPPerson("admin");
		info.setiPStatus("2");
		info.setiPTimealness("长期有效");
		info.setiPType("工作动态");
		info.setSubjectHeadings("档案服务");
		int addResult=service.addInformationPortal(info);
		if(addResult>0) {
			System.out.println("信息发布成功!");
		}else {
			System.out.println("信息发布失败!");
		}
	}
	
	/**
	 * 添加信息时判断索引号和文号是否已存在
	 */
	@Test
	public void testAddInformation2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		InformationPortal info=new InformationPortal();
		info.setiPContent("该死的温柔发给防火防盗");
		info.setiPDocumentNum("档发[2018]1号");
		info.setiPForm("直接发布");
		info.setiPFormDate(new Date());
		info.setiPIndexNum("2018-1");
		info.setiPName("让档案更好的服务社会");
		info.setiPPerson("admin");
		info.setiPStatus("2");
		info.setiPTimealness("长期有效");
		info.setiPType("通知公告");
		info.setSubjectHeadings("档案史料");
		int c=service.isExitInformationIndexNum(info);
		int n=service.isExitInformationDocumentNum(info);
		if(c>0) {
			System.out.println("对不起,该索引号已存在!");
		
		}
		if(n>0) {
			System.out.println("对不起,该文号已存在!");
		}else {
			int addResult=service.addInformationPortal(info);
			if(addResult>0) {
				System.out.println("信息发布成功!");
			}else {
				System.out.println("信息发布失败!");
			}
		}
	}
	
	@Test
	public void testType() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		List<InformationPortal> listType=service.queryAllInformationType();
		for (InformationPortal informationPortal : listType) {
			System.out.println(informationPortal.getiPType());
		}
	}
	
	@Test
	public void testQueryAllPicture() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		List<Picturecarousel> listType=service.queryAllPicture();
		for (Picturecarousel picturecarousel : listType) {
			System.out.println(picturecarousel.getPcPhotoAddress());
		}
	}
	
	@Test
	public void testDeletePictureCarousel() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		InformationPortalService service=(InformationPortalService)context.getBean("informationPortalService",InformationPortalService.class);
		service.deletePictureCarousel();
	}
}
