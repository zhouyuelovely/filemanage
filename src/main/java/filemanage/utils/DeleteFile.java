package filemanage.utils;

import java.io.File;

public class DeleteFile {
	public static Boolean delete(String pathName) {
		File file = new File(pathName);
		return file.delete();
	}

	/**
	 * 递归删除文件下的文件
	 * @param file
	 */
	public static boolean delFile(File file) {
		boolean isDelete = false;
		if (file.isDirectory()) {// 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
			File[] subFiles = file.listFiles();// 获取子文件/目录
			for (File subFile : subFiles) {// 遍历该目录
				// 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
				// 递归清空其内容后再删除
				isDelete = subFile.delete();// 删除空目录或文件
				// delDir(subFile);
			}
		}
		return isDelete;
	}

	public static void main(String[] args) {
		delFile(new File("D:\\fileupload"));
	}
}
