package filemanage.systemmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.systemmanage.dao.FileCustomizationTermOfCustodyMapper;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.service.FileCustomizationTermOfCustodyService;

/**
 * 档案自定义		>>		保管期限
 * service实现层
 * @author 陈一达
 *
 */
@Service("FileCustomizationTermOfCustodyService")
public class FileCustomizationTermOfCustodyServiceImpl implements FileCustomizationTermOfCustodyService{
	
	//档案自定义
	@Autowired
	private  FileCustomizationTermOfCustodyMapper fctcs;
	/**
	 * 添加保管期限
	 */
	@Override
	public Integer saveTermOfCustody(AmMaSmRetentionperiod reten) {
		// TODO Auto-generated method stub
		return fctcs.saveTermOfCustody(reten);
	}
	/**
	 * 删除保管期限
	 */
	@Override
	public Integer deleteTermOfCustody(AmMaSmRetentionperiod reten) {
		// TODO Auto-generated method stub
		return fctcs.deleteTermOfCustody(reten);
	}
	/**
	 * 查询保管期限（页面展示）
	 */
	@Override
	public List<AmMaSmRetentionperiod> queryTermOfCustody(AmMaSmRetentionperiod reten) {
		// TODO Auto-generated method stub
		return fctcs.queryTermOfCustody(reten);
	}
	
	/**
	 * 删除时查询该保管期限的状态是否为自定义
	 */
	@Override
	public Integer termOfCustodyType(AmMaSmRetentionperiod reten) {
		// TODO Auto-generated method stub
		return fctcs.termOfCustodyType(reten);
	}

	/**
	 * 查询该保管期限中是否存在信息
	 */
	@Override
	public Integer countTermOfCustody(AmMaSmRetentionperiod reten) {
		// TODO Auto-generated method stub
		return fctcs.countTermOfCustody(reten);
	}
	
	/**
	 * 查询保管期限总数量(总数量)
	 */
	@Override
	public Integer countQueryTermOfCustody() {
		// TODO Auto-generated method stub
		return fctcs.countQueryTermOfCustody();
	}

}
