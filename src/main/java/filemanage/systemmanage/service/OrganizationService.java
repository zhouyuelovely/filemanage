package filemanage.systemmanage.service;

import java.util.List;

import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.SecondryClassFication;

/**
 * @author MLT 机构的增删改查
 */
public interface OrganizationService {
	/**
	 * 添加机构
	 * 
	 * @return
	 */
	Boolean addOneOrganization(Organization organization);

	/**
	 * 判断机构代码是否存在
	 * 
	 * @param organization
	 * @return
	 */
	int isExitOrgCode(Organization organization);

	/**
	 * 判断机构名称是否存在
	 * 
	 * @param organization
	 * @return
	 */
	int isExitOrgName(Organization organization);

	/**
	 * 判断机构电话是否存在
	 * 
	 * @param organization
	 * @return
	 */
	int isExitOrgPhone(Organization organization);

	/**
	 * 添加二级分类
	 * 
	 * @param secondry
	 * @return
	 */
	Boolean addSecondry(Organization organization);

	/**
	 * 按二级分类名scName查询二级分类是否存在 >=0 存在 <0 不存在
	 * 
	 * @param secondry
	 * @return
	 */
	int isExitSecondryName(Organization organization);

	/**
	 * 按二级分类代码scCode查询二级分类是否存在 >=0 存在 <0 不存在
	 * 
	 * @param secondry
	 * @return
	 */
	int isExitSecondryCode(Organization organization);
	// =======================================以上是添加机构和二级分类===========================================

	/**
	 * 删除机构
	 * 
	 * @return
	 */
	Boolean deleteOneOrganization(String organizationId);

	/**
	 * 删除前查询机构下是否有数据(比如用户，没有，则能删除；有，则不能删除)
	 * 
	 * @param organizationId
	 * @return
	 */
	int countOrgLinkInfo(String organizationId);

	/**
	 * 编辑机构信息
	 * 
	 * @return
	 */
	Boolean updateOneOrganization(Organization organization);

	/**
	 * 根据机构主键查询机构信息
	 * 
	 * @param organizationId
	 * @return
	 */
	Organization queryOrganizationById(String organizationId);

	/**
	 * 列表展示机构信息
	 * 
	 * @return
	 */
	List<Organization> selectAllOrganization();

	/**
	 * 根据全宗主键查机构(根据全宗主键查询该全宗下所属的机构)
	 * 
	 * @return
	 */
	List<Organization> queryOrganizationByQuanzongId(String quanzongId);

	/**
	 * 统计全宗下的机构数
	 * 
	 * @return
	 */
	int countAllOrganization(String quanzongId);

	/**
	 * 机构管理中批量导入去重判断
	 * 
	 * @param archive
	 * @return
	 */
	Integer countAllByImportOrganization(Organization organization);

	/**
	 * 关键词查询机构信息
	 * 
	 * @param organizationQueryConditions
	 * @return
	 */
	List<Organization> queryOrganizationByOrganizationQueryCondition(Organization organization);

	/**
	 * 关键词数
	 * 
	 * @param conditions
	 * @return
	 */
	int countOrgByConditions(String conditions);

	// ------------------------------------------------------------------
	/**
	 * 机构管理去重导入传参
	 * 
	 * @return
	 */
	List<Organization> listAchiveId(String quanzongId);

}
