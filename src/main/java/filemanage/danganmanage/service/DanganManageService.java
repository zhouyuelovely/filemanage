package filemanage.danganmanage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.danganmanage.vo.AmCoBoxConditons;
import filemanage.danganmanage.vo.BoxCondition;
import filemanage.danganmanage.vo.QueryBoxByCondition;
import filemanage.danganmanage.vo.QueryFileByCondition;
import filemanage.danganmanage.vo.QueryHistoryByCondition;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;

/**
 * @author tchuanwu
 *
 */
public interface DanganManageService {
	
	Layui selectAllBox(int page, int limit);
	 Integer countSelectAllBox();
	 Integer countFileNumByBox();
	// 查询所有的审核合格的盒信息
	Layui queryAllBox(BoxCondition boxCondition, int page, int limit);

	// 统计所有已归档合格的文件
	Integer countFileNum(BoxCondition boxCondition);

	public HavingInforBox countBoxByCondition(BoxCondition boxCondition);

	public ArchiveFileHelpInfor queryFileByboxCondition(BoxCondition boxCondition);

	public ArchiveFileHelpInfor queryHistoryDataByCondition(BoxCondition boxCondition);

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
	Layui queryBoxByConditions(String conditions, int page, int limit);

	/**
	 * 根据关键词统计盒数量
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countBoxByConditions(String conditions);

	// 查询所有的已合格归档的文件
	Layui queryAllFile(BoxCondition boxCondition, int page, int limit);
	
	Layui selectAllFile2(int page, int limit);
	
	Integer countAllFilePages();
	// 统计合格归档文件页数
	Integer countFilePages(BoxCondition boxCondition);

	/**
	 * 以件管理关键词查询
	 * 
	 * @param conditions
	 * @return
	 */
	Layui queryFileByConditions(String conditions, int page, int limit);

	/**
	 * 统计以件管理关键词查询个数
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countFileByConditions(String conditions);

	// 条件查询统计盒数和件数
	public HavingInforBox queryBoxByCondition(QueryBoxByCondition boxCondition);

	// 条件查询统计文件数量和页数
	public ArchiveFileHelpInfor queryFileByCondition(QueryFileByCondition fileCondition);
	
	Layui selectAllHistoryData(int page, int limit);
	
    Integer countSelectAllHistoryData();
	
	Integer countSelectAllHistoryDataPages();
 

	/**
	 * 查询所有的历史数据
	 * 
	 * @return
	 */
	Layui queryAllHistoryData(BoxCondition boxCondition, int page, int limit);

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
	Layui queryHistoryByConditions(String conditions, int page, int limit);

	/**
	 * 统计历史数据管理关键词条数
	 * 
	 * @param conditions
	 * @return
	 */
	Integer countHistoryByConditions(String conditions);

	/**
	 * 条件查询下统计历史数据的件数和页数
	 * 
	 * @param fileCondition
	 * @return
	 */
	public ArchiveFileHelpInfor queryHistoryDataByCondition(QueryFileByCondition fileCondition);

	/**
	 * 根据文件主键查询文件附件
	 * 
	 * @param archiveFileId
	 * @return
	 */
	List<FileAttachment> queryFileAttachmentByArchiveFileId(String archiveFileId);

	List<HistoryAnnex> queryHistoryAnnexByHistoryId2(String historydataId);

	/**
	 * 编研界面文件查询
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
	List<AmCoArchivefile> fuzzyEditingFileTitle(String searchBody) throws Exception;

}
