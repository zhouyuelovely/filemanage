package filemanage.fileBorrowing.dao;

import java.util.List;
import java.util.Map;

import filemanage.fileBorrowing.pojo.BorrowDetails;
import filemanage.fileBorrowing.pojo.BorrowRecords;

/**
 * 借阅DAO层
 * @author 陈一达
 *
 */
public interface FileBorrowingMapper {
	/**
	 * 获取所属部门名称
	 * @return
	 */
	List<BorrowDetails> queryOrganizationName(BorrowDetails borrowdetails);
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
	List<BorrowDetails> borrowQueryFile(BorrowDetails borrowdetails);
	
	/**
	 * 借阅申请数据总数
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowQueryFileCount(Map<String, Object> map);
	
	/**
	 * 填写借阅申请单(填写借阅明细)
	 * @param borrowdetails
	 * @return
	 */
	Integer borrowDetailsInsert(BorrowDetails borrowdetails);
	
	/**
	 * 填写借阅申请单(填写借阅记录)
	 * @param borrowrecords
	 * @return
	 */
	Integer borrowRecordsInsert(BorrowRecords borrowrecords);
	
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询
	 * @param borrowrecords
	 * @return
	 */
	List<BorrowRecords> borrowRecordsQuery(BorrowRecords borrowrecords);
	
	/**
	 * 查询借阅记录表展示数据并进行分页以及条件查询(总数)
	 * @param borrowrecords
	 * @return
	 */
	Integer borrowRecordsCountQuery(Map<String, Object> map);
	
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
	Integer borrowDetailsSelectCount(Map<String, Object> map);
	
	/**
	 * 归还
	 * @param borrowrecords
	 * @return
	 */
	Integer fileReturn(BorrowRecords borrowrecords);
	
	/**
	 * 续借
	 * @param borrowrecords
	 * @return
	 */
	Integer fileRenew(BorrowRecords borrowrecords);
	
	/**
	 * 审核功能
	 * @param borrowrecords
	 * @return
	 */
	Integer fileAudit(BorrowRecords borrowrecords);
}
