package filemanage.login.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.login.dao.LogMapper;
import filemanage.login.pojo.User;
import filemanage.login.service.LogService;
import filemanage.login.util.encryption.PasswordHelper;
import filemanage.systemmanage.pojo.Authority;

/**
 * @author meng
 *登录业务员逻辑层实现类
 */

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogMapper logMapper;//登录数据访问层
	
	
	private Logger logger=Logger.getLogger(LogServiceImpl.class);
	
	
	
	@Autowired
	private PasswordHelper passwordHelp;//用户用户密码的加密
	/**
	 * 用户信息查询
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User queryUserByUserName(String username) {
		logger.info("传入的参数是："+username);
		User user=logMapper.queryUserByUserName(username);
		logger.info("用户信息为:"+user);
		return user;
	}
	/**
	 * 注册用户
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,isolation=Isolation.DEFAULT)
	public Boolean registerUser(User user) {
		logger.info("用户的密码为："+user.getUserPassword());
		passwordHelp.encryptPassword(user);//加密密码
		logger.info("加密后用户的密码为："+user.getUserPassword());
		return logMapper.registerUser(user)>0;
	}
	@Override
	public List<Authority> filePremission(Integer begin, Integer end) {
		return logMapper.filePremission(begin, end);
	}
	
}
