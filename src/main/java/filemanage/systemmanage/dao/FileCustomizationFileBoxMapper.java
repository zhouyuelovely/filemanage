package filemanage.systemmanage.dao;

import java.util.List;

import filemanage.systemmanage.pojo.AmCoBoxProperty;


/**
 * 档案自定义		>	档案盒
 * DAO层
 * @author chenyida
 *
 */
public interface FileCustomizationFileBoxMapper {

	/*添加盒属性*/
	Integer saveBoxProperties(AmCoBoxProperty boxProperty);
	/*编辑盒属性*/
	Integer updateBoxProperties(AmCoBoxProperty boxProperty);
	/*删除盒属性*/
	Integer deleteBoxProperties(AmCoBoxProperty boxProperty);
	
	/*查询盒信息（页面展示）*/
	List<AmCoBoxProperty> queryBoxProperties(AmCoBoxProperty amcoboxproperty);
	/*查询档案盒总数*/
	Integer queryCountBoxProperties();
	/*查询该盒中是否存在信息*/
	Integer countBoxPropertiesFileExist(AmCoBoxProperty boxProperty);
}
