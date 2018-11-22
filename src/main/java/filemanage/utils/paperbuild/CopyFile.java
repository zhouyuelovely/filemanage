package filemanage.utils.paperbuild;

import java.io.File;

import org.apache.log4j.Logger;

public class CopyFile {
	private Logger log = Logger.getLogger(CopyFile.class);

	public Boolean copyFile(String srcPath, String desPath, int index) throws Exception {
		CopyFile copyFile = new CopyFile();
		File srcFile = new File(srcPath);
		File desFile = null;
		if (!srcFile.exists()) {
			copyFile.log.info("文件不存在！");
		} else {
			File[] files = srcFile.listFiles();
			long partLength;
			for (File file : files) {
				desFile = new File(desPath, file.getName());
				partLength = file.length() / index + 1;
				for (int i = 0; i < index; i++) {
					new FileThread(file, desFile, partLength * (i + 1), 0).start();
				}
			}
			log.info("文件移动成功!");
		}
		return true;
	}

	public Boolean deleteFile(String srcPath) {
		Boolean lock = null;
		File file = new File(srcPath);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.delete()) {
				log.info("删除旧文件成功!");
				lock = true;
			} else {
				log.info("删除旧文件失败!");
			}
		}
		file.delete();
		log.info("删除文件夹");
		return lock;
	}
}
