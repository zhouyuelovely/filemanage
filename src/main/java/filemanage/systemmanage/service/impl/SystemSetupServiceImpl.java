package filemanage.systemmanage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.login.pojo.User;
import filemanage.login.util.encryption.PasswordHelper;
import filemanage.systemmanage.dao.SystemSetupMapper;
import filemanage.systemmanage.service.SystemSetupService;

@Service("SystemSetupService")
public class SystemSetupServiceImpl implements SystemSetupService{
	private Logger log = LoggerFactory.getLogger(SystemSetupService.class);
	
	@Autowired
	private SystemSetupMapper systemSetupMapper;
	
	@Autowired
	private PasswordHelper passwordHelp;//用户用户密码的加密
	
	@Override
	public 	Boolean comparingThePassword(User user) throws Exception {
		passwordHelp.encryptPassword(user);//加密密码
		log.info("userInfo:"+user);
		return systemSetupMapper.comparingThePassword(user)>0;
	}

	@Override
	public Integer updateUserPasswordByUserName(User user) {
		passwordHelp.encryptPassword(user);//加密密码
		log.info("userInfo:"+user);
		return systemSetupMapper.updateUserPasswordByUserName(user);
	}

}
