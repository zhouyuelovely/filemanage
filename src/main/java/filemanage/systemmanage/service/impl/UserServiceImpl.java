package filemanage.systemmanage.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.login.pojo.User;
import filemanage.login.util.encryption.PasswordHelper;
import filemanage.systemmanage.dao.UserMapper;
import filemanage.systemmanage.service.UserService;


/**
 * @author tchuanwu
 * 用户业务层实现类
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	private Logger logger=Logger.getLogger(UserServiceImpl.class);

	@Override
	public List<User> queryAllUser(int before,int after) {
		logger.info("分页查询所有的用户");
		return userMapper.queryAllUser(before,after);
	}

	@Override
	public User queryUserById(String userId) {
		logger.info("根据用户主键查询用户");
		return userMapper.queryUserById(userId);
	}

	@Override
	public int addUser(User user) {
		logger.info("添加用户");
		return userMapper.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		logger.info("修改用户");
		return userMapper.updateUser(user);
	}

	@Override
	public Boolean deleteUserById(String userId) {
		 logger.info("根据用户主键删除用户");
		return userMapper.deleteUserById(userId)>0;
	}

	@Override
	public int countAllUser() {
		logger.info("统计用户记录条数");
		return userMapper.countAllUser();
	}

	@Override
	public Boolean resetUserPassword(String str) {
		Boolean bool=false;
		Boolean result=false;
		logger.info("重置用户密码为123456");
		String[] s= str.split(";");
		User user=null;
		for (String string : s) {
			String[] sl=string.split(",");
			user=new User();
			user.setUserId(sl[0]);
			user.setUserName(sl[1]);
			user.setUserPassword("123456");
			PasswordHelper ph=new PasswordHelper();
			ph.encryptPassword(user);
			bool=userMapper.resetUserPassword(user.getUserPassword(), user.getUserId());
			if(bool) {
				result=true;
			}else {
				result=false;
				break;
			}
		}
		return result;
	}

	@Override
	public int isExitUserName(User user) {
		logger.info("判断用户名是否存在");
		return userMapper.isExitUserName(user);
	}

	@Override
	public int isExitIdNumber(User user) {
		logger.info("判断身份证号是否存在");
		return userMapper.isExitIdNumber(user);
	}

	@Override
	public int isExitTelPhone(User user) {
		logger.info("判断手机号是否存在");
		return userMapper.isExitTelPhone(user);
	}

	@Override
	public int isExitWorkNumber(User user) {
		logger.info("判断工号是否存在");
		return userMapper.isExitWorkNumber(user);
	}

	@Override
	public List<User> queryUserByConditions(String conditions) {
		logger.info("按关键词查询用户");
		return userMapper.queryUserByConditions(conditions);
	}

	@Override
	public int countUserByConditions(String conditions) {
		logger.info("统计按关键词查询用户的条数");
		return userMapper.countUserByConditions(conditions);
	}

	@Override
	public List<User> queryUserAllManager(User user) {
		 logger.info("根据用户登录获取该用户的所有信息");
		return userMapper.queryUserAllManager(user);
	}

	@Override
	public String queryArchiveIdByName(String quanzongName) {
		logger.info("根据全宗名称查询全宗主键");
		return userMapper.queryArchiveIdByName(quanzongName);
	}

	@Override
	public String queryOrgIdByName(String organizationName,String quanzongName) {
		logger.info("根据机构名称查询机构主键");
		return userMapper.queryOrgIdByName(organizationName,quanzongName);
	}

	@Override
	public String queryRoleIdByName(String roleName) {
		logger.info("根据角色名称查询角色主键");
		return userMapper.queryRoleIdByName(roleName);
	}

	@Override
	public Integer countArchiveIdByName(String quanzongName) {
		logger.info("根据全宗名称统计全宗主键个数");
		return userMapper.countArchiveIdByName(quanzongName);
	}

	@Override
	public Integer countOrgIdByName(String organizationName) {
		logger.info("根据机构名称统计机构主键个数");
		return userMapper.countOrgIdByName(organizationName);
	}

	@Override
	public Integer countRoleIdByName(String roleName) {
		logger.info("根据角色名称统计角色主键个数");
		return userMapper.countRoleIdByName(roleName);
	}

	@Override
	public List<User> listAllUser() {
		
		return userMapper.listAllUser();
	}

	
	
	

}
