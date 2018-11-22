package filemanage.utils.paperbuild;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import filemanage.login.pojo.User;

public class CreateTemporaryPathUtil {
	private static Logger log = LoggerFactory.getLogger(CreateTemporaryPathUtil.class);

	/**
	 * 根据全宗号和用户身份证号创建图片存储临时途径
	 * 
	 * @param quanzongNumber
	 * @param userIdNumber
	 * @return
	 */
	public static String createTemporaryDirectory(User user) {
		log.info("获取用户信心"+user);
		String filePath = "D:/file/" + user.getArchive().getQuanzongNumber().trim() + "/" + user.getUserName().trim()
				+ "/" + user.getUserIdNumber().trim();
		log.info("获取路径"+filePath);
		File fp = new File(filePath);
		try {
			// 创建目录
			if (!fp.exists()) {
				fp.mkdirs();// 目录不存在的情况下，创建目录
				log.info("创建图片存储临时路径为：" + fp);
			}
		} catch (Exception e) {
			log.error("创建图片存储临时路径异常，请检查参数是否正确!" + filePath, e);
			throw e;
		}
		return filePath;
	}
}
