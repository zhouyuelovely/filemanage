package tchuanwu;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.systemmanage.pojo.SecondryClassFication;
import filemanage.systemmanage.service.SecondryClassFicationService;

/**
 * @author tchuanwu
 * 二级分类测试
 */
public class TestSecondryClass {
	/**
	 * 根据一级分类主键查询二级分类
	 */
	@Test
	public void testQuerySecondryClassById() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		SecondryClassFicationService service=(SecondryClassFicationService) context.getBean("secondryClassFicationService",SecondryClassFicationService.class);
		List<SecondryClassFication> listSec=service.querySecondryByPcId("1");
		for (SecondryClassFication secondryClassFication : listSec) {
			System.out.println(secondryClassFication);
		}
	}
	/**
	 * 根据一级分类主键和二级分类状态查询二级分类
	 */
	@Test
	public void testQuerySecondryClass() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		SecondryClassFicationService service=(SecondryClassFicationService) context.getBean("secondryClassFicationService",SecondryClassFicationService.class);
		/*List<SecondryClassFication> listSc=service.queryAllSecondry();*/
		/*for (SecondryClassFication secondryClassFication : listSc) {
			System.out.println(secondryClassFication);
		}*/
	}
	/**
	 * 添加默认二级分类,判断存不存在
	 */
	@Test
	public void testAddSecondryClass() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		SecondryClassFicationService service=(SecondryClassFicationService) context.getBean("secondryClassFicationService",SecondryClassFicationService.class);
		SecondryClassFication sc=new SecondryClassFication();
		sc.setPcId("1");
		sc.setScCode("POL");
		sc.setScCreateTime(new Date());
		sc.setScCreator("admin");
		sc.setScDescription("");
		sc.setScName("纸质类");
		sc.setScProperty("0");
		sc.setScStatus("0");
		int c=service.isExitSecondryClassCode(sc);
		int n=service.isExitSecondryClassName(sc);
		if(c>0) {
			System.out.println("对不起,该二级分类代码已存在！");
		
		}
		if(n>0) {
			System.out.println("对不起,该二级分类名称已存在！");
		}else {
			int addResult=service.addSecondryClass(sc);
			if(addResult>0) {
				System.out.println("二级分类添加成功!");
			}else {
				System.out.println("二级分类添加失败!");
			}
		}
	}
	
	/**
	 * 根据二级分类主键删除二级分类
	 */
	@Test
	public void testDelSecondryClass() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		SecondryClassFicationService service=(SecondryClassFicationService) context.getBean("secondryClassFicationService",SecondryClassFicationService.class);
		Boolean delResult=service.delSecondryClassById("32");
		if(delResult==true) {
			System.out.println("删除成功!");
		}else {
			System.out.println("该分类为系统默认分类,不可以被删除,删除失败!");
		}
	}

}
