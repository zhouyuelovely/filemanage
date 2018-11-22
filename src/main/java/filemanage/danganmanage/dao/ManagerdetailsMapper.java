package filemanage.danganmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.danganmanage.pojo.Managerdetails;
import filemanage.danganmanage.vo.DanganmanageCondition;

/**
 * @author tchuanwu
 * 档案管理明细接口
 */
@Repository
public interface ManagerdetailsMapper {
	/**
	 * 管理明细表添加数据
	 * @param managerdetails
	 * @return
	 */
	public int addManagerDetails(Managerdetails managerdetails);
	/**
	 * 以盒管理查看所有的管理明细
	 * @return
	 */
	List<Managerdetails> queryAllManagerdetails(@Param("id") String id,@Param("before") int before,@Param("after") int after);
	/**
	 * 以盒管理统计所有的管理明细
	 * @return
	 */
	Integer countAllManagerdetails();
	/**
	 * 档案管理以盒管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 统计档案管理以盒管理明细多条件查询条数
	 * @param managerdetails
	 * @return
	 */
	Integer countManagerdetailsByConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 档案审核-审核盒查看所有的管理明细
	 * @param before
	 * @param after
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByBoxShenhe(@Param("before") int before,@Param("after") int after);
	/**
	 * 档案审核-审核盒统计所有的管理明细
	 * @return
	 */
	Integer countManagerdetailsByBoxShenhe();
	
	
	/**
	 * 档案审核修改
	 * @param managerdetails
	 * @return
	 */
	Integer updateManagerdetailsById(Managerdetails managerdetails);
	/**
	 * 以件管理查看所有的管理明细
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByFile(@Param("before") int before,@Param("after") int after);
	/**
	 * 以件管理统计所有的管理明细
	 * @return
	 */
	Integer countManagerdetailsByFile();
	
	/**
	 *档案管理以件管理明细多条件查询 
	 * @param managerdetails
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByFileConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 档案管理以件管理明细多条件查询 条数 
	 * @param managerdetails
	 * @return
	 */
	Integer countManagerdetailsByFileConditions(DanganmanageCondition danganmanageCondition);
	
	/**
	 * 历史数据管理明细
	 * @param before
	 * @param after
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByHistoryData(@Param("before") int before,@Param("after") int after);
	/**
	 * 统计历史数据管理明细条数
	 * @return
	 */
	Integer countManagerdetailsByHistoryData();
	/**
	 * 审核件时查看所有的管理明细
	 * @param before
	 * @param after
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByFileShenghe(@Param("before") int before,@Param("after") int after);
	/**
	 * 审核件时统计所有的管理明细
	 * @return
	 */
	Integer countManagerdetailsByFileShenghe();
	/**
	 * 档案审核-审核件多条件查询
	 * @param managerdetails
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByFileShenheConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 档案审核-统计审核件多条件查询条数
	 * @param managerdetails
	 * @return
	 */
	Integer countManagerdetailsByFileShenheConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 历史数据管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	List<Managerdetails> queryManagerdetailsByHistoryDataConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 统计历史数据管理明细多条件查询条数
	 * @param managerdetails
	 * @return
	 */
	Integer countManagerdetailsByHistoryDataConditions(DanganmanageCondition danganmanageCondition);
	/**
	 * 鉴定销毁假删除
	 * @param managerdetails
	 * @return
	 */
	Integer updateManagerdetailsByIsDelete(@Param("managerDetailsId") String managerDetailsId);
	
	
	
	
	
	

	
	

}
