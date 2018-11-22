package filemanage.systemmanage.service;

import java.util.List;

import filemanage.systemmanage.pojo.AmCoBoxProperty;

/**
 * 档案自定义		>>	档案盒 
 * service层
 * @author 陈一达
 *
 */
public interface FileCustomizationFileBoxService {

		/**
		 * 添加盒属性
		 * @param box
		 * @return
		 */
		Integer saveBoxProperties(AmCoBoxProperty box);
		
		/**
		 * 编辑盒属性
		 * @param box
		 * @return
		 */
		Integer updateBoxProperties(AmCoBoxProperty box);
		/**
		 * 删除盒属性
		 * @param box
		 * @return
		 */
		Integer deleteBoxProperties(AmCoBoxProperty box);
		
		/**
		 * 查询盒信息（页面展示）
		 * @param box
		 * @return
		 */
		List<AmCoBoxProperty> queryBoxProperties(AmCoBoxProperty amcoboxproperty);
		
		/**
		 * 查询档案盒总数
		 * @return
		 */
		int queryCountBoxProperties();
		/**
		 * 查询该盒中是否存在信息
		 * @param box
		 * @return
		 */
		Integer countBoxPropertiesFileExist(AmCoBoxProperty box);
		
}
