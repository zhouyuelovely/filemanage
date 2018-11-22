package filemanage.systemmanage.dao;

import org.springframework.stereotype.Repository;

import filemanage.login.pojo.User;

@Repository("SystemSetupMapper")
public interface SystemSetupMapper {
	
	/**
	 * 校验原密码
	 * @param user
	 * @return
	 */
	Integer comparingThePassword(User user) throws Exception;
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	Integer updateUserPasswordByUserName(User user);

}
