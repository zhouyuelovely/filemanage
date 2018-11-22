package filemanage.danganmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.danganmanage.vo.AmCoBoxConditons;
import filemanage.danganmanage.vo.BoxCondition;
import filemanage.danganmanage.vo.HistoryDataCondition;
import filemanage.danganmanage.vo.QueryBoxByCondition;
import filemanage.danganmanage.vo.QueryFileByCondition;
import filemanage.danganmanage.vo.QueryHistoryByCondition;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.systemmanage.pojo.AmCoBox;

/**
 * @author tchuanwu 档案管理接口
 */
@Repository
public interface DanganManageMapper {
	
	List<AmCoBox> selectAllBox(Map<String, Object> map);
	 Integer countSelectAllBox();
	 Integer countFileNumByBox();
	// 查询所有的审核合格的盒信息
	List<AmCoBox> queryAllBox(Map<String, Object> map);

	// 统计所有审核合格的盒
	Integer countAllBox(BoxCondition boxCondition);

	Integer countFileBoxNumByCondition(BoxCondition boxCondition);

	// 统计所有已归档合格的文件
	Integer countFileNum(BoxCondition boxCondition);

	// 条件查询下统计盒数
	Integer countBoxByCondition(QueryBoxByCondition boxCondition);

	// 条件查询下统计件数
	Integer countFileNumByCondition(QueryBoxByCondition boxCondition);

	// 条件查询下统计文件页数
	Integer countFilePagesByCondition(QueryFileByCondition fileCondition);

	Integer countFileNumByCondition2(QueryFileByCondition fileCondition);

	/**
	 * 查询所有的全宗名称
	 * 
	 * @return
	 */
	List<BoxCondition> queryAllQuanzongName();

	List<BoxCondition> queryAllQuanzongName2();

	List<BoxCondition> queryAllQuanzongName3();

	/**
	 * 根据全宗名称查询该全宗下的一级分类
	 * 
	 * @param boxCondition
	 * @return
	 */
	List<BoxCondition> queryPcByquanzongName(BoxCondition boxCondition);

	List<BoxCondition> queryPcByquanzongName2(BoxCondition boxCondition);

	List<BoxCondition> queryPcByquanzongName3(BoxCondition boxCondition);

	/**
	 * 根据全宗名称和一级分类名称查询年度
	 * 
	 * @param boxCondition
	 * @return
	 */
	List<BoxCondition> queryBoxAnualByquanzongNameAndPcName(BoxCondition boxCondition);

	List<BoxCondition> queryBoxAnualByquanzongNameAndPcName2(BoxCondition boxCondition);

	List<BoxCondition> queryBoxAnualByquanzongNameAndPcName3(BoxCondition boxCondition);

	/**
	 * 根据全宗名称和一级分类名称还有年度查询保管期限名称
	 * 
	 * @param boxCondition
	 * @return
	 */
	List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual(BoxCondition boxCondition);

	List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual2(BoxCondition boxCondition);

	List<BoxCondition> queryRpNameByquanzongNameAndPcNameAndBoxAnual3(BoxCondition boxCondition);

	/**
	 * 根据关键词查询盒信息
	 * 
	 * @param conditions
	 * @return
	 */
	List<AmCoBox> queryBoxByConditions(Map<String, Object> map);

	/**
	 * 根据关键词统计盒数量
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countBoxByConditions(String conditions);
	
	List<AmCoArchivefile> selectAllFile2(Map<String, Object> map);

	// 查询所有的已合格归档的文件
	List<AmCoArchivefile> queryAllFile(Map<String, Object> map);
	Integer countAllFilePages();

	// 统计合格归档文件页数
	Integer countFilePages(BoxCondition boxCondition);

	/**
	 * 以件管理关键词查询
	 * 
	 * @param conditions
	 * @return
	 */
	List<AmCoArchivefile> queryFileByConditions(Map<String, Object> map);

	/**
	 * 统计以件管理关键词查询个数
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countFileByConditions(String conditions);
	
	
	List<QueryHistoryByCondition> selectAllHistoryData(Map<String, Object> map);
	
	Integer countSelectAllHistoryData();
	
	Integer countSelectAllHistoryDataPages();

	/**
	 * 查询所有的历史数据
	 * 
	 * @return
	 */
	List<QueryHistoryByCondition> queryAllHistoryData(Map<String, Object> map);

	/**
	 * 统计所有的历史数据
	 * 
	 * @return
	 */
	Integer countAllHistoryData(BoxCondition boxCondition);

	/**
	 * 统计历史数据的总页数
	 * 
	 * @return
	 */
	Integer countHistoryDataPages(BoxCondition boxCondition);

	/**
	 * 根据历史数据主键查询单个历史数据文件的附件信息
	 * 
	 * @param historydataId
	 * @return
	 */
	List<HistoryAnnex> queryHistoryAnnexByHistoryId(String historydataId);

	/**
	 * 历史数据管理关键词查询
	 * 
	 * @param conditions
	 * @return
	 */
	List<QueryHistoryByCondition> queryHistoryByConditions(Map<String, Object> map);

	/**
	 * 统计历史数据管理关键词条数
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countHistoryByConditions(String conditions);

	/**
	 * 条件查询下统计历史数据件数
	 * 
	 * @param fileCondition
	 * @return
	 */
	Integer countHistoryDataByCondition(QueryFileByCondition fileCondition);

	/**
	 * 条件查询下统计历史数据页数
	 * 
	 * @param fileCondition
	 * @return
	 */
	Integer countHistoryDataPagesByCondition(QueryFileByCondition fileCondition);

	/**
	 * 边沿界面文件查询
	 * 
	 * @return
	 */
	List<AmCoArchivefile> selectAllFile();

	/**
	 * 边沿界面模糊查询
	 * 
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	List<AmCoArchivefile> fuzzyEditingFileTitle(@Param("searchBody") String searchBody) throws Exception;
}
