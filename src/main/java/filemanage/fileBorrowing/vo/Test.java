package filemanage.fileBorrowing.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.fileBorrowing.pojo.BorrowDetails;
import filemanage.fileBorrowing.pojo.BorrowRecords;
import filemanage.fileBorrowing.service.FileBorrowingService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileBorrowingService service=(FileBorrowingService)context.getBean("FileBorrowingService",FileBorrowingService.class);
		BorrowDetails borrowdetails = new BorrowDetails();
		BorrowRecords borrowrecords = new BorrowRecords();
		//全宗名称下拉框数据展示
		/*List<BorrowDetails> list = service.queryQuanzongName();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuanzongName());
			System.out.println(list.get(i).getQuanzongNumber());
		}*/
		//根据全宗ID查询档案年度并在下拉框中展示
		/*Map<String, Object> map = new HashMap<>();
		BorrowDetails borrowdetails = new BorrowDetails();
		borrowdetails.setQuanzongNumber("01FE498598ED4813AD7FFE2CBC31F871");
		map.put("quanzongNumber", borrowdetails.getQuanzongNumber());
		List<BorrowDetails> list = service.queryQuanzongId(map);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBorrowdetailsAnnual());
		}*/
		
		//借阅申请数据展示并分页
		/*BorrowDetails borrowdetails = new BorrowDetails();
		borrowdetails.setQuanzongName("安监局");
		borrowdetails.setQuanzongNumber("2017");
		List<BorrowDetails> list = service.borrowQueryFile(borrowdetails);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuanzongName()+":"+list.get(i).getBorrowdetailsAnnual()+":"+list.get(i).getBorrowdetailsTitle()+":"+list.get(i).getQuanzongNumber());
		}*/
		
		// 填写借阅申请单(填写借阅明细)
		/*borrowdetails.setQuanzongNumber("021");
		borrowdetails.setQuanzongName("测试全宗4");
		borrowdetails.setBorrowdetailsAnnual("2017");
		borrowdetails.setBorrowdetailsTitle("提名4");
		borrowdetails.setBorrowrecordsId("11111");
		borrowdetails.setUserId("1");
		Integer num = service.borrowDetailsInsert(borrowdetails);*/
		
		//填写借阅申请单(填写借阅记录)
		/*borrowrecords.setBorrowRecordsId("88888");
		borrowrecords.setBorrowRecordsName("陈一达");
		borrowrecords.setBorrowRecordsDepartment("行政搜查科");
		borrowrecords.setBorrowRecordsReturnDate("2018/8/30");
		borrowrecords.setBorrowRecordsCarrier(1);
		borrowrecords.setBorrowRecordsReason("借阅事由8");
		borrowrecords.setBorrowRecordsNumber(50);
		Integer num = service.borrowRecordsInsert(borrowrecords);*/
		
		//查询借阅记录表展示数据并进行分页以及条件查询
		/*List<BorrowRecords> list = service.borrowRecordsQuery(borrowrecords);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBorrowRecordsCarrier());
		}*/
		
		//借阅明细(记录查询)
		/*List<BorrowRecords> list = service.borrowRecordsSelect(borrowrecords);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBorrowRecordsName());
		}*/
		
		//借阅明细（明细表查询）
		/*List<BorrowDetails> list = service.borrowDetailsSelect(borrowdetails);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuanzongName());
		}*/
	
		//归还
		/*borrowrecords.setBorrowRecordsEvaluation("良好");
		borrowrecords.setBorrowRecordsInstructions("测试效果说明5");
		borrowrecords.setBorrowRecordsId("11111");
		Integer a = service.fileReturn(borrowrecords);*/
		//续借
		borrowrecords.setBorrowRecordsReturnDate("2018-8-30");
		borrowrecords.setBorrowRecordsReason("续借事由5");
		borrowrecords.setBorrowRecordsId("11111");
		Integer a = service.fileRenew(borrowrecords);
	}

}
