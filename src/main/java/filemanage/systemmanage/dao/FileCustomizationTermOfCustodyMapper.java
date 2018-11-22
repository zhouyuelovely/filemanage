package filemanage.systemmanage.dao;

import java.util.List;

import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;

/**
 * 档案自定义 	>>		保管期限
 * @author 陈一达
 *
 */
public interface FileCustomizationTermOfCustodyMapper {

	//添加保管期限
	Integer saveTermOfCustody(AmMaSmRetentionperiod reten);
	//删除保管期限
	Integer deleteTermOfCustody(AmMaSmRetentionperiod reten);
	//查询保管期限（页面展示）
	List<AmMaSmRetentionperiod> queryTermOfCustody(AmMaSmRetentionperiod reten);
	//查询保管期限总数量（页面展示）
	Integer countQueryTermOfCustody();
	//删除时查询该保管期限的状态是否为自定义
	Integer termOfCustodyType(AmMaSmRetentionperiod reten);
	//查询该保管期限中是否存在信息
	Integer countTermOfCustody(AmMaSmRetentionperiod reten);
	
}
