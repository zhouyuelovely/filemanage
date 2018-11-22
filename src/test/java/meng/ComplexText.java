package meng;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.collectandorganize.service.BoxSubmitReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml","classpath:spring-mvc-dao.xml"})
@WebAppConfiguration("src/main/resources")
public class ComplexText {
	@Autowired
	private BoxSubmitReviewService box;
	
	
	/*@Test
	public void testReorganize() {
		String anual="2015";
		String archiveId="1";
		Boolean res=box.reorganize(archiveId, anual);
		System.out.println(res);
		assertTrue(res);
	}*/
}
