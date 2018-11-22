package filemanage.systemmanage.vo;

import java.util.Date;

/**
 * 用户表辅助类
 * @author 陈一达
 *
 */
public class UserVo {

	private String userId;//用户主键
	private String userName;//用户姓名
	private String userPassword;//密码
	private String userIdNumber;//身份证号码
	private String userTelePhone;//手机号码
	private String userWorkNumber;//工号
	private String userSex;//性别
	private String userIpAddress;//ip地址
	private String userHostName;//主机名称
	private String quanzongId;//全宗主键
	private String organizationId;//机构主键
	private String roleId;//角色主键
	private Date userCreateTime;//创建日期
	private String userType;//用户类型
	private String archive;//所属全宗
	private String org;//所属部门
	private String role;//所属角色
	
	
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userIdNumber=" + userIdNumber + ", userTelePhone=" + userTelePhone + ", userWorkNumber="
				+ userWorkNumber + ", userSex=" + userSex + ", userIpAddress=" + userIpAddress + ", userHostName="
				+ userHostName + ", quanzongId=" + quanzongId + ", organizationId=" + organizationId + ", roleId="
				+ roleId + ", userCreateTime=" + userCreateTime + ", userType=" + userType + ", archive=" + archive
				+ ", org=" + org + ", role=" + role + "]";
	}
	public UserVo() {
		super();
	}
	public UserVo(String userId, String userName, String userPassword, String userIdNumber, String userTelePhone,
			String userWorkNumber, String userSex, String userIpAddress, String userHostName, String quanzongId,
			String organizationId, String roleId, Date userCreateTime, String userType, String archive, String org,
			String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIdNumber = userIdNumber;
		this.userTelePhone = userTelePhone;
		this.userWorkNumber = userWorkNumber;
		this.userSex = userSex;
		this.userIpAddress = userIpAddress;
		this.userHostName = userHostName;
		this.quanzongId = quanzongId;
		this.organizationId = organizationId;
		this.roleId = roleId;
		this.userCreateTime = userCreateTime;
		this.userType = userType;
		this.archive = archive;
		this.org = org;
		this.role = role;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserIpAddress() {
		return userIpAddress;
	}
	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}
	public String getUserHostName() {
		return userHostName;
	}
	public void setUserHostName(String userHostName) {
		this.userHostName = userHostName;
	}
	public String getQuanzongId() {
		return quanzongId;
	}
	public void setQuanzongId(String quanzongId) {
		this.quanzongId = quanzongId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Date getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getArchive() {
		return archive;
	}
	public void setArchive(String archive) {
		this.archive = archive;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
