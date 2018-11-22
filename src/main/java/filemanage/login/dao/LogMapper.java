package filemanage.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Authority;

/**
 * @author meng
 *登录
 */
@Repository
public interface LogMapper {
	/**
	 *根据用户名查询用户信息 
	 * @param userName 用户名
	 * @return 用户的信息
	 */
	User queryUserByUserName(@Param("username")String username);
	/**
	 * 注册用户
	 * @param user 用户信息
	 * @return 是否注册成功
	 */
	Integer registerUser(User user);
	/**
	 * 回去各级权限
	 * @param begin 权限开始
	 * @param end 权限结束
	 * @return
	 */
	List<Authority> filePremission(@Param("begin")Integer begin,@Param("end")Integer end);
}
