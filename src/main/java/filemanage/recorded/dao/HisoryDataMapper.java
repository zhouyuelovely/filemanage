package filemanage.recorded.dao;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.recorded.pojo.HistoryData;
@Repository
public interface HisoryDataMapper {
	/**
	 * 添加历史数据
	 * @param list 历史数据集合
	 * @return
	 */
	Integer addHistoryData(List<HistoryData> list);
	/**
	 * 添加历史数据的附件
	 * @param list 历史数据附件
	 * @return
	 */
	Integer addHistoryAnnex(List<HistoryAnnex> list);
	/**
	 * 查询全宗主键
	 * @param quanzongNumber 全宗号
	 * @return
	 */
	String queryQuanzongName(String quanzongNumber);
	/**
	 * 查询保管期限主键
	 * @param retentionperiodName 保管期限名称
	 * @return
	 */
	String queryRetentionperiodId(String retentionperiodName);
	/**
	 * 查询一级分类主键
	 * @param typeName 一级分类名称
	 * @return
	 */
	String queryHistorydataType(String typeName);
	/**
	 * 查询二级分类名称
	 * @param oraginName 二级分类名称
	 * @return
	 */
	String queryOrganizationId(String oraginName);
}
