package filemanage.systemmanage.service;

import java.util.List;

import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;

/**
 * 档案自定义	   	>>		保管期限
 * Service层
 * @author 陈一达
 *
 */
public interface FileCustomizationTermOfCustodyService {
		/**
		 * 添加保管期限
		 * @param reten
		 * @return
		 */
		Integer saveTermOfCustody(AmMaSmRetentionperiod reten);
		/**
		 * 删除保管期限
		 * @param reten
		 * @return
		 */
		Integer deleteTermOfCustody(AmMaSmRetentionperiod reten);
		/**
		 * 查询保管期限（页面展示）
		 * @param reten
		 * @return
		 */
		List<AmMaSmRetentionperiod> queryTermOfCustody(AmMaSmRetentionperiod reten);
		
		/**
		 * 查询保管期限总数量（页面展示）
		 * @return
		 */
		Integer countQueryTermOfCustody();
		/**
		 * 删除时查询该保管期限的状态是否为自定义
		 * @param reten
		 * @return
		 */
		Integer termOfCustodyType(AmMaSmRetentionperiod reten);
		/**
		 * 查询该保管期限中是否存在信息
		 * @param reten
		 * @return
		 */
		Integer countTermOfCustody(AmMaSmRetentionperiod reten);
}
