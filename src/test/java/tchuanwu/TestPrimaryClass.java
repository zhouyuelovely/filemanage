package tchuanwu;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.danganmanage.service.DanganManageService;
import filemanage.danganmanage.vo.AmCoBoxConditons;
import filemanage.danganmanage.vo.BoxCondition;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.service.PrimaryClassFicationService;

/**
 * @author tchuanwu
 * 测试一级分类
 *
 */
public class TestPrimaryClass {
	/**
	 * 查询所有的一级分类
	 */
	@Test
	public void testPrimaryClass() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		PrimaryClassFicationService service=(PrimaryClassFicationService) context.getBean("primaryClassFicationService",PrimaryClassFicationService.class);
		List<PrimaryClassFication> listPc=service.queryAllPrimaryClass();
		for (PrimaryClassFication primaryClassFication : listPc) {
			System.out.println(primaryClassFication);
		}
	}
	
	/**
	 * 添加一级分类
	 */
	@Test
	public void testAddPrimaryClass() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		PrimaryClassFicationService service=(PrimaryClassFicationService) context.getBean("primaryClassFicationService",PrimaryClassFicationService.class);
		PrimaryClassFication primaryClass=new PrimaryClassFication();
		primaryClass.setPcCode("XS");
		primaryClass.setPcName("刑事档案");
		primaryClass.setPcCreateTime(new Date());
		primaryClass.setPcCreator("tchuanwu");
		primaryClass.setPcDescription("负责刑事案件所有档案");
		primaryClass.setPcProperty("1");
		int addResult=service.addPrimaryClass(primaryClass);
		if(addResult>0) {
			System.out.println("一级分类添加成功!");
		}else {
			System.out.println("一级分类添加失败!");
		}
	}
	
	/**
	 * 添加默认的一级分类，判断存不存在
	 */
	@Test
	public void testAddPrimaryClass2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		PrimaryClassFicationService service=(PrimaryClassFicationService) context.getBean("primaryClassFicationService",PrimaryClassFicationService.class);
		PrimaryClassFication primaryClass=new PrimaryClassFication();
		primaryClass.setPcCode("WS");
		primaryClass.setPcName("文书档案");
		primaryClass.setPcCreateTime(new Date());
		primaryClass.setPcCreator("tchuanwu");
		primaryClass.setPcDescription("负责文书档案所有分类");
		primaryClass.setPcProperty("1");
		int c=service.isExitPrimaryClassCode(primaryClass);
		int n=service.isExitPrimaryClassName(primaryClass);
		if(c>0) {
			System.out.println("对不起,该一级分类代码已存在！");
		
		}
		if(n>0) {
			System.out.println("对不起,该一级分类名称已存在！");
		}else {
			int addResult=service.addPrimaryClass(primaryClass);
			if(addResult>0) {
				System.out.println("一级分类添加成功!");
			}else {
				System.out.println("一级分类添加失败!");
			}
		}
		
	}
	
	@Test
	public void testpc() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		DanganManageService service=(DanganManageService)context.getBean("danganManageService",DanganManageService.class);
		BoxCondition boxCondition=new BoxCondition();
		boxCondition.setQuanzongName("张掖市安监局");
		List<BoxCondition>  listbox=service.queryPcByquanzongName(boxCondition);
		 for (BoxCondition boxCondition2 : listbox) {
			 System.out.println(boxCondition2.getPcName());
		}
	}
	

}
