package filemanage.utils.paperbuild;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFileAttachmentPathUtil {
	private static Logger log = LoggerFactory.getLogger(CreateFileAttachmentPathUtil.class);

	/**
	 * 根据全宗号和用户身份证号创建图片存储临时途径
	 * 
	 * @param quanzongNumber
	 * @param userIdNumber
	 * @return
	 */
	public static String createAttachmentDirectory(String quanzongNumber, String archiveFileCreatetime,
			String archiveFileTitle) {

		String filePath = "D:/file/" + quanzongNumber.trim() + "/" + archiveFileCreatetime.trim() + "/"
				+ archiveFileTitle.trim();
		/*File fp = new File(filePath);
		try {
			// 创建目录
			if (!fp.exists()) {
				fp.mkdirs();// 目录不存在的情况下，创建目录
				log.info("创建文件附件存储路径为：" + fp);
			}
		} catch (Exception e) {
			log.error("创建文件附件存储路径异常，请检查参数是否正确!" + filePath, e);
			throw e;
		}*/
		return filePath;
	}
}
