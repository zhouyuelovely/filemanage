package meng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.collectandorganize.dao.BoxSubmitReviewMapper;
import filemanage.collectandorganize.dao.FileAuditMapper;
import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.vo.BoxSubmitReview;
import filemanage.collectandorganize.vo.BoxSubmitReviewAnualHelp;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.Archive;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml", "classpath:spring-mvc-dao.xml" })
@WebAppConfiguration("src/main/resources")
public class TestBoxSubmitReview {
	@Autowired
	private BoxSubmitReviewMapper boxSubmitReviewMapper;
	@Autowired
	private FileAuditMapper fileAuditMapper;

	/*@Test // 全宗下所有盒子
	public void testFindAllAmcBox() {
		List<AmCoBox> list = boxSubmitReviewMapper.findAllAmcBox("B7FBECDD119D4EF28837BD9503B2CF95");
		for (AmCoBox amCoBox : list) {
			System.out.println(amCoBox);
		}
	}*/
	@Test
	public void testCountAllAmcBoxNum() {
		Integer result=boxSubmitReviewMapper.countAllAmcBoxNum("B7FBECDD119D4EF28837BD9503B2CF95");
		System.out.println(result);
	}
	@Test
	public void testCountAmcBoxArchiveFile() {
		Integer result=boxSubmitReviewMapper.countAmcBoxArchiveFile("B7FBECDD119D4EF28837BD9503B2CF95");
		System.out.println(result);
	}
	@Test
	public void testCountArchiveFileSubmitReviewAnual() {
		List<BoxSubmitReviewAnualHelp> list=boxSubmitReviewMapper.countArchiveFileSubmitReviewAnual("B7FBECDD119D4EF28837BD9503B2CF95");
		for (BoxSubmitReviewAnualHelp archiveFileSubmitReviewAnualHelp : list) {
			System.out.println(archiveFileSubmitReviewAnualHelp);
		}
		
	}
	@Test
	public void testUpdateSubmitRrview() {
		BoxSubmitReview b=new BoxSubmitReview();
		b.setAnual("1960");
		b.setRetentionperioId("2");
		b.setArchiveId("B7FBECDD119D4EF28837BD9503B2CF95");
		Integer bInteger=boxSubmitReviewMapper.updateSubmitRrview(b);
		System.out.println(bInteger);
	}

	@Test
	public void testQueryAllAllAmcBoxByAnualAndRetentionperoids() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("anual", "2016");
		map.put("archiveId", "01FE498598ED4813AD7FFE2CBC31F871");
		map.put("retentionperoids", "1");
		map.put("begin", 1);
		map.put("end", 10);
		List<AmCoBox> list=boxSubmitReviewMapper.queryAllAllAmcBoxByAnualAndRetentionperoids(map);
		for (AmCoBox amCoBox : list) {
			System.out.println(amCoBox);
		}
	}

}
