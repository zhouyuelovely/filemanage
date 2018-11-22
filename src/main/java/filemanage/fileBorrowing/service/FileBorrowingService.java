package filemanage.fileBorrowing.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import filemanage.fileBorrowing.pojo.BorrowDetails;
import filemanage.fileBorrowing.pojo.BorrowRecords;
import filemanage.fileBorrowing.vo.BorrowDataListSourceVoForm;
import filemanage.fileBorrowing.vo.DataListSourceVoForm;
import filemanage.utils.layui.Layui;

/**
 * 借阅Service
 * @author 陈一达
 *
 */
public interface FileBorrowingService {
	/**
	 * 获取所属部门名称
	 * @return
	 */
	String queryOrganizationName(BorrowDetails borrowdetails);
	
	/**
	 * 全宗名称下拉框数据展示
	 * @return
	 */
	List<BorrowDetails> queryQuanzongName();
	
	/**
	 * 根据全宗ID查询档案年度并在下拉框中展示
	 * @return
	 */
	List<BorrowDetails> queryQuanzongId(Map<String , Object> map);
	
	/**
	 * 借阅申请数据展示并分页
	 * @param borrowdetails
	 * @return
	 */
	List<BorrowDetails> borrowQueryFile(/*HttpServletRequest request,*/String quanzongName,String borrowdetailsAnnual,String borrowdetailsTitle,int page,int limit);
	
	/**
	 * 借阅申请数据总数
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowQueryFileCount(HttpServletRequest request,String quanzongName,String borrowdetailsAnnual,String borrowdetailsTitle,int page,int limit);
	
	/**
	 * 填写借阅申请单(填写借阅明细)
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowDetailsInsert(BorrowDataListSourceVoForm borrowdatalistsourcevoform,String userId);
	
	/**
	 * 填写借阅申请单(填写借阅记录)
	 * @param borrowrecords
	 * @return
	 */
	Integer borrowRecordsInsert(BorrowDataListSourceVoForm borrowdatalistsourcevoform);
	/**
	 * 明细/记录的添加业务处理
	 * @param borrowdatalistsourcevoform
	 * @return
	 */
	String  borrowRecordDetails(BorrowDataListSourceVoForm borrowdatalistsourcevoform,String userId);
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询
	 * @param borrowrecords
	 * @return
	 */
	List<BorrowRecords> borrowRecordsQuery(HttpServletRequest request,String borrowRecordsId,String borrowRecordsCarrier,String borrowRecordsStatus);
	
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询(总数)
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowRecordsCountQuery(HttpServletRequest request,String borrowRecordsId,String borrowRecordsCarrier,String borrowRecordsStatus);
	/**
	 * 借阅记录业务处理
	 * @param request	请求参数（可有可无）
	 * @param userId	用户ID
	 * @param borrowRecordsCarrier  档案载体
	 * @param borrowRecordsStatus  	审核状态
	 * @return
	 */
	Layui borrowRecordsRendering(HttpServletRequest request, String userId,
			String borrowRecordsCarrier, String borrowRecordsStatus);
	
	/**
	 * 借阅明细(记录查询)
	 * @param borrowrecords
	 * @return
	 */
	List<BorrowRecords> borrowRecordsSelect(BorrowRecords borrowrecords);
	
	/**
	 * 借阅明细（明细表查询）
	 * @param borrowdetails
	 * @return
	 */
	List<BorrowDetails> borrowDetailsSelect(BorrowDetails borrowdetails);
	
	/**
	 * 借阅明细（明细表查询）(总数)
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowDetailsSelectCount(String borrowRecordsId);
	/**
	 * 借阅明细(记录查询)/借阅明细（明细表查询）业务处理
	 * @param borrowRecordsId
	 * @return
	 */
	List<Layui> borrowRecordsBorrowDetailsSelect(HttpServletRequest request,String borrowRecordsId);
	
	/**
	 * 归还
	 * @param borrowrecords
	 * @return
	 */
	Integer fileReturn(BorrowRecords borrowrecords);
	/**
	 * 归还业务
	 * @param borrowRecordsId
	 * @param borrowRecordsEvaluation
	 * @param borrowRecordsInstructions
	 * @return
	 */
	String fileReturnBusiness(String borrowtype,String borrowRecordsId,String borrowRecordsEvaluation,String borrowRecordsInstructions);
	/**
	 * 续借
	 * @param borrowrecords
	 * @return
	 */
	Integer fileRenew(BorrowRecords borrowrecords);
	
	/**
	 * 审核功能拒绝
	 * @param borrowrecords
	 * @return
	 */
	String fileAudit(List<DataListSourceVoForm> dateList);
	/**
	 * 审核功能通过
	 * @param borrowrecords
	 * @return
	 */
	String filePass(List<DataListSourceVoForm> dateList);
}
