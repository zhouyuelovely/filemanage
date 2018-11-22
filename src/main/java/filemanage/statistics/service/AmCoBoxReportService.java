package filemanage.statistics.service;

import java.util.List;
import java.util.Map;


import filemanage.statistics.pojo.AmCoBoxReport;


public interface AmCoBoxReportService {
	/**
	 * 根据档案类型和全宗id查询出一个档案盒数量
	 * @param pcname
	 * @param quanzongid
	 * @return
	 */
	String queryfileSumnum(String anual, String pcname, String quanzongid);
	
	/**
	 * 根据档案类型和全宗id查询出一个档案盒数量
	 * @param pcname
	 * @param quanzongid
	 * @return
	 */
	String queryboxCountnum(String anual, String pcname, String quanzongid);
	/**
	 * 以盒查询统计
	 */
	Map<String, List<AmCoBoxReport>> queryByBox(String anual);
	
	/**
	 * 以盒查询统计(表格)
	 */
	List<AmCoBoxReport> queryByBoxTable(String anual,int before,int after);
	
	/**
	 * 以盒查询统计总数量(表格)queryByBoxTableTotal
	 */
	int queryByBoxTableTotal(String anual);
	
	/**
	 * 查询盒横坐标全宗名称(有全宗id)
	 */
	List<AmCoBoxReport> queryQuanzongname(String anual);
	/**
	 * 查询件横坐标全宗名称(有全宗id)
	 */
	List<AmCoBoxReport> queryFileQuanzongname(String anual);
	
	/**
	 * 查询盒所有的档案类型
	 * @return
	 */
	List<AmCoBoxReport> queryPcname(String anual);
	/**
	 * 查询所有的件档案类型
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryFilePcname(String anual);
	
	/**
	 * 查询盒所有年份
	 * @return
	 */
	List<AmCoBoxReport> queryAnual();
	
	/**
	 * 查询件所有年份
	 * @return
	 */
	List<AmCoBoxReport> queryFileAnual();
	
	/**
	 * 以件查询
	 */
	Map<String, List<AmCoBoxReport>> queryByFile(String anual);
	
	/**
	 * 以件查询(表格)
	 */
	List<AmCoBoxReport> queryByFileTable(String anual,int before,int after);
	
	/**
	 * 以件查询总条数(表格)
	 */
	int queryByFileTableTotal(String anual);
	
	/**
	 * 查询借阅统计
	 * @return
	 */
	List<AmCoBoxReport> queryBorrowing(String anual);
	
	/**
	 * 查询借阅统计(表格)
	 * @return
	 */
	List<AmCoBoxReport> queryBorrowingTable(String anual, int before, int after);
	/**
	 * 查询借阅统计(表格)总条数
	 * @return
	 */
	int queryBorrowingTableTotal(String anual);
	
	/**
	 * 查询借阅总数
	 * @return
	 */
	int queryBorrowingCount(String anual);
	
	/**
	 * 根据年度查询借阅档案类型
	 */
	List<AmCoBoxReport> queryBorrowingType(String anual);
	
	/**
	 * 查询借阅年份
	 * @return
	 */
	List<AmCoBoxReport> queryBorrowingAnual();
	
	/**
	 * 查询某全宗下驳回的次数
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryReject(String anual);
	
	/**
	 * 查询质量比图横坐标所包含的全宗
	 */
	List<AmCoBoxReport> queryRejectQuanzong(String anual);
	
	/**
	 * 查询某全宗下驳回的次数(表格分页)
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryRejectTable(String anual, int before, int after);
	/**
	 * 查询某全宗下驳回的次数(表格分页)总条数
	 * @return
	 */
	Integer queryRejectTableTotal(String anual);
	
	/**
	 * 查询驳回的总次数
	 */
	Integer queryRejectTotal(String anual);
	
	/**
	 * 驳回图年份下拉框
	 * @return
	 */
	List<AmCoBoxReport> queryRejectAnual();
	
	
}
