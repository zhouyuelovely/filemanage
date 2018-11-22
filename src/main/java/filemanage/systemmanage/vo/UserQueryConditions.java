package filemanage.systemmanage.vo;

import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.pojo.Role;

/**
 * @author tchuanwu
 * 用户关键词查询映射类
 */
public class UserQueryConditions {
	private String userId;//用户主键
	private String userName;//用户姓名
	private String userSex;//性别
	private String userIdNumber;//身份证号码
	private String userTelePhone;//手机号码
	private String userWorkNumber;//工号
	private Archive archive;//所属全宗
	private Organization org;//所属部门
	private Role role;//所属角色
	private String quanzongName;
	private String organizationName;
	private String roleName;
	private String conditions;
	
	public UserQueryConditions() {
		
	}

	public UserQueryConditions(String userId, String userName, String userSex, String userIdNumber,
			String userTelePhone, String userWorkNumber, Archive archive, Organization org, Role role,
			String quanzongName, String organizationName, String roleName, String conditions) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userIdNumber = userIdNumber;
		this.userTelePhone = userTelePhone;
		this.userWorkNumber = userWorkNumber;
		this.archive = archive;
		this.org = org;
		this.role = role;
		this.quanzongName = quanzongName;
		this.organizationName = organizationName;
		this.roleName = roleName;
		this.conditions = conditions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserIdNumber() {
		return userIdNumber;
	}

	public void setUserIdNumber(String userIdNumber) {
		this.userIdNumber = userIdNumber;
	}

	public String getUserTelePhone() {
		return userTelePhone;
	}

	public void setUserTelePhone(String userTelePhone) {
		this.userTelePhone = userTelePhone;
	}

	public String getUserWorkNumber() {
		return userWorkNumber;
	}

	public void setUserWorkNumber(String userWorkNumber) {
		this.userWorkNumber = userWorkNumber;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getQuanzongName() {
		return quanzongName;
	}

	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "UserQueryConditions [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userIdNumber=" + userIdNumber + ", userTelePhone=" + userTelePhone + ", userWorkNumber="
				+ userWorkNumber + ", archive=" + archive + ", org=" + org + ", role=" + role + ", quanzongName="
				+ quanzongName + ", organizationName=" + organizationName + ", roleName=" + roleName + ", conditions="
				+ conditions + "]";
	}

	
	
	
	
	

}
