package filemanage.systemmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.systemmanage.dao.OrganizationMapper;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.service.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

	
	@Autowired
	private OrganizationMapper organizationMapper;

	/**
	 * 添加机构
	 */
	@Override
	public Boolean addOneOrganization(Organization organization) {
		return organizationMapper.addOneOrganization(organization) > 0;
	}

	/**
	 * 查询机构代码是否存在
	 */
	@Override
	public int isExitOrgCode(Organization organization) {
		return organizationMapper.isExitOrgCode(organization);
	}

	/**
	 * 查询机构名称是否存在
	 */
	@Override
	public int isExitOrgName(Organization organization) {
		return organizationMapper.isExitOrgName(organization);
	}

	/**
	 * 判断机构电话是否存在
	 */
	@Override
	public int isExitOrgPhone(Organization organization) {
		return organizationMapper.isExitOrgPhone(organization);
	}

	/**
	 * 添加二级分类
	 */
	@Override
	public Boolean addSecondry(Organization organization) {
		return organizationMapper.addSecondry(organization) > 0;
	}

	/**
	 * 判断是否存在相同的二级分类名称
	 */
	@Override
	public int isExitSecondryName(Organization organization) {
		return organizationMapper.isExitSecondryName(organization);
	}

	/**
	 * 判断
	 */
	@Override
	public int isExitSecondryCode(Organization organization) {
		return organizationMapper.isExitSecondryCode(organization);
	}

	/**
	 * 删除机构
	 */
	@Override
	public Boolean deleteOneOrganization(String organizationId) {
		return organizationMapper.deleteOneOrganization(organizationId) > 0;
	}

	/**
	 * 删除前查询机构下是否有数据(比如说用户)
	 */
	@Override
	public int countOrgLinkInfo(String organizationId) {
		return organizationMapper.countOrgLinkInfo(organizationId);
	}

	/**
	 * 编辑机构
	 */
	@Override
	public Boolean updateOneOrganization(Organization organization) {
		return organizationMapper.updateOneOrganization(organization) > 0;
	}

	/**
	 * 根据主键查询机构信息
	 */
	@Override
	public Organization queryOrganizationById(String organizationId) {
		return organizationMapper.queryOrganizationById(organizationId);
	}

	/**
	 * 查询机构所有信息
	 */
	@Override
	public List<Organization> selectAllOrganization() {
		return organizationMapper.selectAllOrganization();
	}

	/**
	 * 批量导入去重
	 */
	@Override
	public Integer countAllByImportOrganization(Organization organization) {
		return organizationMapper.countAllByImportOrganization(organization);
	}

	/**
	 * 关键词查询机构信息
	 */
	@Override
	public List<Organization> queryOrganizationByOrganizationQueryCondition(Organization organization) {
		return organizationMapper.queryOrganizationByOrganizationQueryCondition(organization);
	}

	/**
	 * 根据全宗主键查询该全宗下的机构
	 */
	@Override
	public List<Organization> queryOrganizationByQuanzongId(String quanzongId) {
		return organizationMapper.queryOrganizationByQuanzongId(quanzongId);
	}

	/**
	 * 所有的机构数
	 */
	@Override
	public int countAllOrganization(String quanzongId) {
		return organizationMapper.countAllOrganization(quanzongId);
	}

	/**
	 * 查询的条件数
	 */
	@Override
	public int countOrgByConditions(String conditions) {
		return organizationMapper.countOrgByConditions(conditions);
	}

	/**
	 * 去重导入传参(全宗主键)
	 */
	@Override
	public List<Organization> listAchiveId(String quanzongId) {
		return organizationMapper.listAchiveId(quanzongId);
	}

}
