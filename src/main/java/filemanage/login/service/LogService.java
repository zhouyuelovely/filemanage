package filemanage.login.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Authority;

/**
 * @author meng
 *
 */
public interface LogService {
	/**
	 * 根据用户名查询用户信息
	 * @param userName 用户名
	 * @return 用户的信息
	 */
	User queryUserByUserName(String username);
	/**
	 * 注册用户
	 * @param user 用户信息
	 * @return 是否注册成功
	 */
	Boolean registerUser(User user);
	/**
	 * 回去各级权限
	 * @param begin 权限开始
	 * @param end 权限结束
	 * @return
	 */
	List<Authority> filePremission(Integer begin,Integer end);
}
