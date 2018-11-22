package filemanage.fileBorrowing.service.img;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.fileBorrowing.dao.FileBorrowingMapper;
import filemanage.fileBorrowing.pojo.BorrowDetails;
import filemanage.fileBorrowing.pojo.BorrowRecords;
import filemanage.fileBorrowing.service.FileBorrowingService;
import filemanage.fileBorrowing.vo.BorrowDataListSourceVoForm;
import filemanage.fileBorrowing.vo.BorrowDataSource;
import filemanage.fileBorrowing.vo.DataListSourceVoForm;
import filemanage.utils.layui.Layui;
@Transactional
@Service("FileBorrowingService")
public class FileBorrowingServiceImpl implements FileBorrowingService{

	/**
	 * 借阅DAO层接口自动装载
	 */
	@Autowired
	private FileBorrowingMapper fm;
	
	
	/**
	 * 获取所属部门名称
	 * @return
	 */
	@Override
	public String queryOrganizationName(BorrowDetails borrowdetails) {
		// TODO Auto-generated method stub
		return fm.queryOrganizationName(borrowdetails).get(0).getQuanzongName().toString();
	}
	
	/**
	 * 全宗名称下拉框数据展示
	 */
	@Override
	public List<BorrowDetails> queryQuanzongName() {
		// TODO Auto-generated method stub
		return fm.queryQuanzongName();
	}

	/**
	 * 根据全宗ID查询档案年度并在下拉框中展示
	 */
	@Override
	public List<BorrowDetails> queryQuanzongId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fm.queryQuanzongId(map);
	}

	/**
	 * 借阅申请数据展示并分页
	 */
	@Override
	public List<BorrowDetails> borrowQueryFile(/*HttpServletRequest request,*/String quanzongName,String borrowdetailsAnnual,String borrowdetailsTitle,int page,int limit) {
		BorrowDetails borrowdetails = new BorrowDetails();
		// TODO Auto-generated method stub
		//分页计算
		int before = limit * (page-1);  
		int after = page * limit; 
		borrowdetails.setQuanzongName(quanzongName);
		borrowdetails.setBorrowdetailsAnnual(borrowdetailsAnnual);
		borrowdetails.setBorrowdetailsTitle(borrowdetailsTitle);
		return fm.borrowQueryFile(borrowdetails);
	}
	
	/**
	 * 借阅申请数据总数
	 */
	@Override
	public Integer borrowQueryFileCount(HttpServletRequest request,String quanzongName, String borrowdetailsAnnual,String borrowdetailsTitle,int page,int limit) {
		// TODO Auto-generated method stub
		//分页计算
		int before = limit * (page-1);  
		int after = page * limit; 
		Map<String, Object> map = new HashMap<>();
		map.put("quanzongName",quanzongName);
		map.put("borrowdetailsAnnual",borrowdetailsAnnual);
		map.put( "borrowdetailsTitle",borrowdetailsTitle);
		return fm.borrowQueryFileCount(map);
	}
	
	/**
	 * 填写借阅申请单(填写借阅明细)
	 */
	@Override
	public Integer borrowDetailsInsert(BorrowDataListSourceVoForm borrowdatalistsourcevoform,String userId) {
		// TODO Auto-generated method stub
		List<BorrowDataSource> bDSList = borrowdatalistsourcevoform.getBorrowdatasource();
		int insertInt = 0;
		for (int i = 0; i < bDSList.size(); i++) {
			BorrowDetails borrowdetails = new BorrowDetails();
			borrowdetails.setQuanzongNumber(bDSList.get(i).getQuanzongNumber());
			borrowdetails.setQuanzongName(bDSList.get(i).getQuanzongName());
			borrowdetails.setBorrowdetailsAnnual(bDSList.get(i).getBorrowdetailsAnnual());
			borrowdetails.setBorrowdetailsTitle(bDSList.get(i).getBorrowdetailsTitle());
			borrowdetails.setBorrowrecordsId(borrowdatalistsourcevoform.getBorrowRecordsId());
			borrowdetails.setUserId(userId);
			borrowdetails.setArchivefileId(bDSList.get(i).getArchivefileId());
			insertInt = fm.borrowDetailsInsert(borrowdetails);
		}
		return insertInt;
	}

	/**
	 * 填写借阅申请单(填写借阅记录)
	 */
	@Override
	public Integer borrowRecordsInsert(BorrowDataListSourceVoForm borrowdatalistsourcevoform) {
		// TODO Auto-generated method stub
		BorrowRecords borrowrecords = new BorrowRecords();
		borrowrecords.setBorrowRecordsId(borrowdatalistsourcevoform.getBorrowRecordsId());
		borrowrecords.setBorrowRecordsName(borrowdatalistsourcevoform.getBorrowRecordsName());
		borrowrecords.setBorrowRecordsDepartment(borrowdatalistsourcevoform.getBorrowRecordsDepartment());
		borrowrecords.setBorrowRecordsReturnDate(borrowdatalistsourcevoform.getBorrowRecordsReturnDate());
		borrowrecords.setBorrowRecordsCarrier(borrowdatalistsourcevoform.getBorrowRecordsCarrier());
		borrowrecords.setBorrowRecordsReason(borrowdatalistsourcevoform.getBorrowRecordsReason());
		borrowrecords.setBorrowRecordsNumber(borrowdatalistsourcevoform.getBorrowRecordsNumber());
		return fm.borrowRecordsInsert(borrowrecords);
	}
	/**
	 * 明细/记录的添加业务
	 * @param borrowdatalistsourcevoform
	 * @return
	 */
	@Override
	public String  borrowRecordDetails(BorrowDataListSourceVoForm borrowdatalistsourcevoform,String userId) {
		//生成UUID
		UUID uuid=UUID.randomUUID();
		String str = uuid.toString(); 
		String uuidStr=str.replace("-", "");
		borrowdatalistsourcevoform.setBorrowRecordsId(uuidStr);
		//返回提示语句
		String msg = "";
		if(borrowRecordsInsert(borrowdatalistsourcevoform) >0) {
			if(borrowDetailsInsert(borrowdatalistsourcevoform,userId) >0) {
					msg = "{msg:'借阅明细添加成功！'}";
		    	}else {
		    		msg = "{msg:'借阅明细添加失败！'}";
		    	}
		}else {
		      msg = "{msg:'借阅记录添加失败！'}";
		}
		return msg;
	}
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询
	 */
	@Override
	public List<BorrowRecords> borrowRecordsQuery(HttpServletRequest request,String userId,String borrowRecordsCarrier,String borrowRecordsStatus) {
		// TODO Auto-generated method stub
		BorrowRecords borrowrecords = new BorrowRecords();
		borrowrecords.setBorrowRecordsId(userId);
		borrowrecords.setBorrowRecordsCarrier(borrowRecordsCarrier);
		borrowrecords.setBorrowRecordsStatus(borrowRecordsStatus);
		System.out.println("借阅记录参数展示："+borrowrecords);
		List<BorrowRecords> borrowRecordsList = fm.borrowRecordsQuery(borrowrecords);
		return borrowRecordsList;
	}
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询(总数)
	 */
	@Override
	public Integer borrowRecordsCountQuery(HttpServletRequest request, String borrowRecordsId,
			String borrowRecordsCarrier, String borrowRecordsStatus) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put(borrowRecordsId, "borrowRecordsId");
		map.put(borrowRecordsId, "borrowRecordsId");
		map.put(borrowRecordsStatus, "borrowRecordsStatus");
		return fm.borrowRecordsCountQuery(map);
	}
	
	/**
	 * 借阅记录数据渲染业务处理
	 */
	@Override
	public Layui borrowRecordsRendering(HttpServletRequest request, String userId,
			String borrowRecordsCarrier, String borrowRecordsStatus) {
		if(borrowRecordsCarrier.equals("0") || borrowRecordsCarrier.equals("请选择")) {
			borrowRecordsCarrier = null;
		}
		if(borrowRecordsStatus.equals("0") || borrowRecordsStatus.equals("请选择")) {
			borrowRecordsStatus = null;
		}
		List<BorrowRecords> borrowRecordsList = borrowRecordsQuery(request,userId,borrowRecordsCarrier,borrowRecordsStatus);
		return Layui.data(borrowRecordsCountQuery(request, userId, borrowRecordsCarrier, borrowRecordsStatus),borrowRecordsList );
	}
	
	/**
	 * 借阅明细(记录查询)
	 */
	@Override
	public List<BorrowRecords> borrowRecordsSelect(BorrowRecords borrowrecords) {
		// TODO Auto-generated method stub
		return fm.borrowRecordsSelect(borrowrecords);
	}

	/**
	 * 借阅明细（明细表查询）
	 */
	@Override
	public List<BorrowDetails> borrowDetailsSelect(BorrowDetails borrowdetails) {
		// TODO Auto-generated method stub
		return fm.borrowDetailsSelect(borrowdetails);
	}
	
	/**
	 * 借阅明细（明细表查询）(总数)
	 * @param borrowdetails
	 * @return
	 */
	@Override
	public Integer borrowDetailsSelectCount(String borrowRecordsId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("borrowRecordsId", borrowRecordsId);
		System.out.println(map);
		System.out.println("总数:"+fm.borrowDetailsSelectCount(map));
		return fm.borrowDetailsSelectCount(map);
	}
	
	/**
	 * 借阅明细(记录查询)/借阅明细（明细表查询）业务处理
	 * @param borrowRecordsId
	 * @return
	 */
	@Override
	public List<Layui> borrowRecordsBorrowDetailsSelect(HttpServletRequest request, String borrowRecordsId) {
		// TODO Auto-generated method stub
		//记录查询
		BorrowRecords borrowrecords = new BorrowRecords();
		borrowrecords.setBorrowRecordsId(borrowRecordsId);
		
		//明细查询
		BorrowDetails borrowdetails = new BorrowDetails();
		borrowdetails.setBorrowrecordsId(borrowRecordsId);
		String quanzongName = null;
		String borrowdetailsAnnual = null;
		String borrowdetailsTitle = null;
		List<Layui> laylist = new ArrayList<>();
		Integer count =  borrowDetailsSelectCount(borrowRecordsId);
		//组装list
		laylist.add(Layui.data(0, borrowRecordsSelect(borrowrecords)));
		laylist.add(Layui.data(count, borrowDetailsSelect(borrowdetails)));
		return laylist;
	}
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileBorrowingService fs=(FileBorrowingService)context.getBean("FileBorrowingService",FileBorrowingService.class);
	}

	/**
	 * 归还
	 */
	@Override
	public Integer fileReturn(BorrowRecords borrowrecords) {
		// TODO Auto-generated method stub
		return fm.fileReturn(borrowrecords);
	}
	/**
	 * 续借
	 */
	@Override
	public Integer fileRenew(BorrowRecords borrowrecords) {
		// TODO Auto-generated method stub
		return fm.fileRenew(borrowrecords);
	}
	/**
	 * 归还/续借业务
	 */
	@Override
	public String fileReturnBusiness(String borrowtype,String borrowRecordsId, String borrowRecordsEvaluation,
			String borrowRecordsInstructions) {
		// TODO Auto-generated method stub
		String msg = null;
		//1：归还  2：续借
		if(borrowtype.equals("1")) {
			BorrowRecords borrowrecords = new BorrowRecords();
			//记录表ID
			borrowrecords.setBorrowRecordsId(borrowRecordsId);
			//效果评价
			borrowrecords.setBorrowRecordsEvaluation(borrowRecordsEvaluation);
			//效果说明
			borrowrecords.setBorrowRecordsInstructions(borrowRecordsInstructions);
			if(fm.fileReturn(borrowrecords) == 0) {
				msg = "{msg:'归还失败！'}";
			}else {
				msg = "{msg:'归还成功！'}";
			}
		}else if(borrowtype.equals("2")) {
			BorrowRecords borrowrecords = new BorrowRecords();
			//记录表ID
			borrowrecords.setBorrowRecordsId(borrowRecordsId);
			//归还日期
			borrowrecords.setBorrowRecordsReturnDate(borrowRecordsEvaluation);
			//借阅事由
			borrowrecords.setBorrowRecordsReason(borrowRecordsInstructions);
			if(fm.fileRenew(borrowrecords) == 0) {
				msg = "{msg:'续借失败！'}";
			}else {
				msg = "{msg:'续借成功！'}";
			}
		}
		return msg;
		
	}
	/**
	 * 审核功能拒绝
	 * @param borrowrecords
	 * @return
	 */
	@Override
	public String fileAudit(List<DataListSourceVoForm> dateList) {
		// TODO Auto-generated method stub
		String msg;
		for (int i = 0; i < dateList.size(); i++) {
			if(dateList.get(i).getBorrowRecordsStatus().equals("1")) {
				BorrowRecords borrowrecords = new BorrowRecords();
				borrowrecords.setBorrowrecordsReasonrejection(dateList.get(i).getBorrowrecordsReasonrejection());
				borrowrecords.setBorrowRecordsId(dateList.get(i).getBorrowRecordsId());
				borrowrecords.setBorrowRecordsStatus("2");
				fm.fileAudit(borrowrecords);
			}
			
			
		}
		msg = "{msg:'驳回成功！'}";
		return msg;
	}
	/**
	 * 审核功能通过
	 * @param borrowrecords
	 * @return
	 */
	@Override
	public String filePass(List<DataListSourceVoForm> dateList) {
		// TODO Auto-generated method stub
		String msg;
		for (int i = 0; i < dateList.size(); i++) {
			if(dateList.get(i).getBorrowRecordsStatus().equals("1")) {
				BorrowRecords borrowrecords = new BorrowRecords();
				borrowrecords.setBorrowRecordsId(dateList.get(i).getBorrowRecordsId());
				borrowrecords.setBorrowRecordsStatus("3");
				fm.fileAudit(borrowrecords);
			}
		}
		msg = "{msg:'通过审核成功！'}";
		return null;
	}

	
}
