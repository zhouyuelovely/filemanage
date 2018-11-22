package filemanage.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.statistics.pojo.AmCoBoxReport;

@Repository
public interface AmCoBoxReportMapper {
	/**
	 * 根据档案类型和全宗id查询出一个档案盒数量
	 * @param pcname
	 * @param quanzongid
	 * @return
	 */
	String queryfileSumnum(@Param(value = "anual") String anual, @Param(value = "pcname") String pcname,@Param(value = "quanzongid") String quanzongid);
	
	/**
	 * 根据档案类型和全宗id查询出一个档案盒数量
	 * @param pcname
	 * @param quanzongid
	 * @return
	 */
	String queryboxCountnum(@Param(value = "anual") String anual, @Param(value = "pcname") String pcname,@Param(value = "quanzongid") String quanzongid);
	
	/**
	 * 以盒查询统计
	 */
	List<AmCoBoxReport> queryByBox(@Param(value = "anual") String anual, @Param(value = "quanzongid") String quanzongid);
	
	/**
	 * 以盒查询统计(表格)
	 */
	List<AmCoBoxReport> queryByBoxTable(@Param(value = "anual") String anual,@Param(value = "before") int before,@Param(value = "after") int after);
	
	/**
	 * 以盒查询统计总数量(表格)queryByBoxTableTotal
	 */
	int queryByBoxTableTotal(@Param(value = "anual") String anual);
	
	/**
	 * 查询盒横坐标全宗名称(有全宗id)
	 */
	List<AmCoBoxReport> queryQuanzongname(@Param(value = "anual") String anual);
	
	/**
	 * 查询件横坐标全宗名称(有全宗id)
	 */
	List<AmCoBoxReport> queryFileQuanzongname(@Param(value = "anual") String anual);
	
	/**
	 * 查询所有的盒档案类型
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryPcname(@Param(value = "anual") String anual);
	
	/**
	 * 查询所有的件档案类型
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryFilePcname(@Param(value = "anual") String anual);
	
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
	List<AmCoBoxReport> queryByFile(@Param(value = "anual") String anual, @Param(value = "quanzongid") String quanzongid);
	
	/**
	 * 以件查询(表格)
	 */
	List<AmCoBoxReport> queryByFileTable(@Param(value = "anual") String anual,@Param(value = "before") int before,@Param(value = "after") int after);
	
	/**
	 * 以件查询总条数(表格)
	 */
	int queryByFileTableTotal(@Param(value = "anual") String anual);
	
	/**
	 * 查询借阅统计
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryBorrowing(@Param(value = "anual") String anual);
	
	/**
	 * 查询借阅统计(表格)
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryBorrowingTable(@Param(value = "anual") String anual,@Param(value = "before") int before,@Param(value = "after") int after);
	/**
	 * 查询借阅统计(表格)总条数
	 * @param anual
	 * @return
	 */
	int queryBorrowingTableTotal(@Param(value = "anual") String anual);
	
	/**
	 * 查询借阅总数
	 * @param anual
	 * @return
	 */
	Integer queryBorrowingCount(@Param(value = "anual") String anual);
	
	/**
	 * 根据年度查询借阅档案类型
	 */
	List<AmCoBoxReport> queryBorrowingType(@Param(value = "anual") String anual);
	
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
	List<AmCoBoxReport> queryReject(@Param(value = "anual") String anual);
	
	/**
	 * 查询某全宗下驳回的次数(表格分页)
	 * @param anual
	 * @return
	 */
	List<AmCoBoxReport> queryRejectTable(@Param(value = "anual") String anual,@Param(value = "before") int before,@Param(value = "after") int after);
	/**
	 * 查询某全宗下驳回的次数(表格分页)总条数
	 * @param anual
	 * @return
	 */
	Integer queryRejectTableTotal(@Param(value = "anual") String anual);
	
	/**
	 * 查询驳回的总次数
	 */
	Integer queryRejectTotal(@Param(value = "anual") String anual);
	
	/**
	 * 查询质量比图横坐标所包含的全宗
	 */
	List<AmCoBoxReport> queryRejectQuanzong(@Param(value = "anual") String anual);
	
	/**
	 * 驳回图年份下拉框
	 * @return
	 */
	List<AmCoBoxReport> queryRejectAnual();
}
