package filemanage.danganmanage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.danganmanage.pojo.Managerdetails;
import filemanage.danganmanage.vo.DanganmanageCondition;
import filemanage.utils.layui.Layui;

/**
 * @author tchuanwu
 * 档案管理明细业务层接口
 */
public interface ManagerdetailsService {
	/**
	 * 管理明细表添加数据
	 * @param managerdetails
	 * @return
	 */
	public int addManagerDetails(Managerdetails managerdetails);
	
	/**
	 * 查看所有的管理明细
	 * @return
	 */
	List<Managerdetails> queryAllManagerdetails(String id,int before,int after);
	/**
	 * 统计所有的管理明细
	 * @return
	 */
	Integer countAllManagerdetails();
	
	/**
	 * 档案管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	Layui queryManagerdetailsByConditions(DanganmanageCondition danganmanageCondition,Integer limit,Integer page);
	
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
	List<Managerdetails> queryManagerdetailsByFile(int before,int after);
	/**
	 * 以件管理统计所有的管理明细
	 * @return
	 */
	Integer countManagerdetailsByFile();
	
	/**
	 * 档案管理以件管理明细多条件查询 
	 * @param managerdetails
	 * @return
	 */
	Layui queryManagerdetailsByFileConditions(DanganmanageCondition danganmanageCondition,Integer limit,Integer page);
	
	
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
	Layui queryManagerdetailsByFileShenheConditions(DanganmanageCondition danganmanageCondition,Integer limit,Integer page);
	
	
	/**
	 * 历史数据管理明细多条件查询
	 * @param managerdetails
	 * @return
	 */
	Layui queryManagerdetailsByHistoryDataConditions(DanganmanageCondition danganmanageCondition,Integer limit,Integer page);
	
	/**
	 * 鉴定销毁假删除
	 * @param managerdetails
	 * @return
	 */
	Integer updateManagerdetailsByIsDelete(String managerDetailsId);
	
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
	
	
}
