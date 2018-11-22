package filemanage.systemmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.systemmanage.dao.FileCustomizationFileBoxMapper;
import filemanage.systemmanage.pojo.AmCoBoxProperty;
import filemanage.systemmanage.service.FileCustomizationFileBoxService;

/**
 * 档案自定义		>>	档案盒
 * serviceImpl层
 * @author 陈一达
 *
 */
@Service("FileCustomizationFileBoxService")
public class FileCustomizationFileBoxServiceImpl implements FileCustomizationFileBoxService {

	//档案自定义		>>		档案盒（FileCustomizationFileBoxMapper）
	@Autowired
	private FileCustomizationFileBoxMapper fcfb;
	
	/**
	 * 添加盒属性
	 */
	@Override
	public Integer saveBoxProperties(AmCoBoxProperty boxProperty) {
		// TODO Auto-generated method stub
		return fcfb.saveBoxProperties(boxProperty);
	}

	/**
	 * 编辑盒属性
	 */
	@Override
	public Integer updateBoxProperties(AmCoBoxProperty boxProperty) {
		// TODO Auto-generated method stub
		return fcfb.updateBoxProperties(boxProperty);
	}

	/**
	 * 删除盒属性
	 */
	@Override
	public Integer deleteBoxProperties(AmCoBoxProperty boxProperty) {
		// TODO Auto-generated method stub
		return fcfb.deleteBoxProperties(boxProperty);
	}

	/**
	 * 页面展示
	 */
	@Override
	public List<AmCoBoxProperty> queryBoxProperties(AmCoBoxProperty amcoboxproperty) {
		// TODO Auto-generated method stub
		return fcfb.queryBoxProperties(amcoboxproperty);
	}

	/**
	 * （删除时）查询该盒下是否有文件
	 */
	@Override
	public Integer countBoxPropertiesFileExist(AmCoBoxProperty boxProperty) {
		// TODO Auto-generated method stub
		return fcfb.countBoxPropertiesFileExist(boxProperty);
	}

	/**
	 * 查询档案盒总数
	 * @return
	 */
	@Override
	public int queryCountBoxProperties() {
		// TODO Auto-generated method stub
		return fcfb.queryCountBoxProperties();
	} 
	

	
}
