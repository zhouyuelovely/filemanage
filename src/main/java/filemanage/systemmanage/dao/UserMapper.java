package filemanage.systemmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.login.pojo.User;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.vo.UserQueryConditions;

/**
 * @author tchuanwu
 *  用户管理接口
 */
@Repository
public interface UserMapper {
	/**
	 * 查询所有的用户
	 * @return
	 */
	List<User> queryAllUser(@Param("before") int before,@Param("after") int after);
	/**
	 * 根据用户主键查询用户
	 * @param userId
	 * @return
	 */
	User queryUserById(String userId);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 根据用户主键删除用户
	 * @param userId
	 * @return
	 */
	int deleteUserById(String userId);
	/**
	 * 统计用户记录条数
	 * @return
	 */
	int countAllUser();
	/**
	 * 重置用户密码
	 * @param userPassword
	 * @param userId
	 * @return
	 */
	Boolean resetUserPassword(@Param("userPassword")String userPassword,@Param("userId") String userId);
	 /**
	  * 判断用户名是否存在
	  * >=0 存在  <0 不存在
	  * @param user
	  * @return
	  */
	 int isExitUserName(User user);
	 /**
	  * 判断身份证号是否存在
	  * >=0 存在  <0 不存在
	  * @param user
	  * @return
	  */
	 int isExitIdNumber(User user);
	 /**
	  * 判断手机号是否存在
	  * >=0 存在  <0 不存在
	  * @param user
	  * @return
	  */
	 int isExitTelPhone(User user);
	 /**
	  * 判断工号是否存在
	  * >=0 存在  <0 不存在
	  * @param user
	  * @return
	  */
	 int isExitWorkNumber(User user);
	 /**
	  * 关键词查询用户
	  * @param conditions
	  * @return
	  */
	 List<User> queryUserByConditions(String conditions);
	 /**
	  * 统计查询关键词条数
	  * @return
	  */
	 int countUserByConditions(String conditions);
	 /**
	  * 根据用户登录获取该用户的所有信息
	  * @return
	  */
	 List<User> queryUserAllManager(User user);
	 /**
	  * 根据全宗名称查询全宗主键
	  * @param quanzongName
	  * @return
	  */
	 String queryArchiveIdByName(String quanzongName);
	 /**
	  * 根据机构名称查询机构主键
	  * @param organizationName
	  * @return
	  */
	 String queryOrgIdByName(String organizationName,String quanzongName);
	 /**
	  * 根据角色名称查询角色主键
	  * @param roleName
	  * @return
	  */
	 String queryRoleIdByName(String roleName);
	 /**
	  * 根据全宗名称统计全宗主键个数
	  * @param quanzongName
	  * @return
	  */
	 Integer countArchiveIdByName(String quanzongName);
	 /**
	  * 根据机构名称统计机构主键个数
	  * @param organizationName
	  * @return
	  */
	 Integer countOrgIdByName(String organizationName);
	 /**
	  * 根据角色名称统计角色主键个数
	  * @param roleName
	  * @return
	  */
	 Integer countRoleIdByName(String roleName);
	 /**
	  * 查询用户表的所有用户
	  * @return
	  */
	 List<User> listAllUser();
	

}
