package tchuanwu;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.collectandorganize.pojo.KnowledgeBase;
import filemanage.collectandorganize.service.KnowledgeBaseService;

/**
 * @author tchuanwu
 * 知识库测试类
 */
public class TestKnowledgeBase {
	/**
	 * 添加知识库
	 */
	@Test
	public void testAddKnowledge() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		KnowledgeBaseService service=(KnowledgeBaseService) context.getBean("knowledgeBaseService",KnowledgeBaseService.class);
		KnowledgeBase know=new KnowledgeBase();
		 know.setKnowledgeDocumentNum("档按[2018] 3号");
		 know.setKnowledgeType("单位标准");
		 know.setKnowledgeReleaDate("2018-5-8");
		 know.setKnowledgeTitle("单位档案局关于印发档案审核归档的通知");
		 know.setKnowledgeContent("档案审核通过或拒绝重新整理");
		 know.setKnowledgePublaster("admin");
		 int addResult=service.addKnowledgeBase(know);
		 if(addResult>0) {
			 System.out.println("知识库添加成功!");
		 }else {
			 System.out.println("知识库添加失败!");
		 }
	}
	
	/**
	 * 根据知识类型查询知识库
	 */
	@Test
	public void  testQueryKnowledgeByType() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		KnowledgeBaseService service=(KnowledgeBaseService) context.getBean("knowledgeBaseService",KnowledgeBaseService.class);
		List<KnowledgeBase> listKnow=service.queryKnowledgeByType("省级标准");
		for (KnowledgeBase knowledgeBase : listKnow) {
			System.out.println(knowledgeBase);
		}
	}
	
	/**
	 * 根据知识库主键查询知识库
	 */
	@Test
	public void testQueryKnowledgeById() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		KnowledgeBaseService service=(KnowledgeBaseService) context.getBean("knowledgeBaseService",KnowledgeBaseService.class);
		KnowledgeBase know=service.queryKnowledgeById("4674C70850BF401492DD5DDC1063CE08");
		System.out.println(know);
	}
	
	/**
	 * 判断知识库文号是否已存在
	 */
	
	@Test
	public void testAddKnowledge2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		KnowledgeBaseService service=(KnowledgeBaseService) context.getBean("knowledgeBaseService",KnowledgeBaseService.class);
		KnowledgeBase know=new KnowledgeBase();
		 know.setKnowledgeDocumentNum("档发[2018] 2号");
		 know.setKnowledgeType("省级标准");
		 know.setKnowledgeReleaDate("2018-5-8");
		 know.setKnowledgeTitle("国家档案局关于印发档案审核归档的通知");
		 know.setKnowledgeContent("档案审核的归档和分类");
		 know.setKnowledgePublaster("admin");
		 int c=service.isExitKnowledgeDocumentNum(know);
		 if(c>0) {
			 System.out.println("该知识库文号已存在!");
		 }else {
			 int addResult=service.addKnowledgeBase(know);
			 if(addResult>0) {
				 System.out.println("知识库添加成功!");
			 }else {
				 System.out.println("知识库添加失败!");
			 }
		 }
	}

}
