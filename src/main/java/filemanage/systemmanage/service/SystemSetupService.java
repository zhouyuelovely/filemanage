package filemanage.systemmanage.service;

import filemanage.login.pojo.User;

public interface SystemSetupService {

	/**
	 * 校验原密码
	 * 
	 * @param user
	 * @return
	 */
	Boolean comparingThePassword(User user) throws Exception;

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUserPasswordByUserName(User user);

}
