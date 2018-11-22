package filemanage.utils.copefile;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;

import org.apache.log4j.Logger;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;



/**
 * @author meng
 *文件复制工具
 */
public class CopeFileTool {
	private Logger logger=Logger.getLogger(CopeFileTool.class);
	
	
	
	/**
	 * 复制文件
	 * @param srcPath 原文件夹
	 * @param desPath 新文件夹
	 * @param index 开启线程个数
	 * @return
	 */
	public Boolean copeFile(String srcPath,String desPath,int index) {
		CopeFileTool copFile=new CopeFileTool();
		File srcFile = new File(srcPath);
		File desFile = null;
		if(!srcFile.exists()) {
			copFile.logger.info("文件不存在");
			return false;
		}else {
			File[] files = srcFile.listFiles();
			logger.info("文件夹下存在文件的个数是:"+files.length);
			long partLenghth;
			for (File file : files) {
				desFile = new File(desPath, file.getName());
				partLenghth= file.length() / index + 1;
				for (int i = 0; i < index; i++) {
					new FileThread(file, desFile, partLenghth*(i+1) ,0).start();
				}
			}
			
			logger.info("文件转移成功");
			
		}
		return true;
	}
	/**
	 * 复制单个文件
	 * @param srcPath 文件的绝对路径
	 * @param desPath 目标文件的存放路径
	 * @param index 开启的线程数
	 * @return
	 */
	public Boolean copeOneFile(String srcPath,String desPath,int index) {
		CopeFileTool copFile=new CopeFileTool();
		File file=new File(srcPath);//创建新文件
		File desFile = new File(desPath, file.getName());
		long partLenghth=file.length() / index + 1;
		for (int i = 0; i < index; i++) {
			new FileThread(file, desFile, partLenghth*(i+1) ,0).start();
		}
		return true;
	}
	/**
	 * 复制单个文件
	 * @param srcPath 旧文件的绝对路径
	 * @param desPath 新文件的绝对路径
	 * @return
	 */
	public Boolean copeOneFile(String srcPath,String desPath) {
		File file=new File(srcPath);
		if(file.isFile()) {//文件是文件
			File outFile=new File(desPath);
			try {
				Files.copy(file.toPath(), outFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				return true;//复制成功
			}
		}else {
			return false;//复制失败
		}
	};
	/**
	 * 多线程实现文件的复制
	 * @author meng
	 *
	 */
	class FileThread extends Thread{
		private File srcFile;
		private File desFile;
		private long partLength;
		private long pointer = 0;

		FileThread() {
			super();
		}
			
		FileThread(File srcFile, File desFile, long partLength, long pointer) {
			super();
			this.srcFile = srcFile;
			this.desFile = desFile;
			this.partLength = partLength;
			this.pointer = pointer;
		}
		@Override
	    public void run() {
	         RandomAccessFile rafSrc = null;
	         RandomAccessFile rafDes = null;
	         try {
	             rafSrc = new RandomAccessFile(srcFile, "r");
	             rafDes = new RandomAccessFile(desFile, "rw");
		 
		             rafSrc.seek(pointer);
		             rafDes.seek(pointer);
	 
		             byte[] buffer = new byte[(int) partLength];
		             int len = rafSrc.read(buffer);
		             rafDes.write(buffer, 0, len);
		             pointer = rafSrc.getFilePointer();
		             rafDes.close();
		             rafSrc.close();
		       	} catch (IOException e) {
		             System.out.println(e);
		       	}
		}

		public long getPointer() {
			return pointer;
		}
	}
	
	
	public Boolean deleteFile(String srcPath) {
		Boolean lock=null;
		File file=new File(srcPath);
		String[] nameStr=file.list();
		if(nameStr.length>0) {
			logger.info("文件夹下存在文件");
			File fi=null;
			for (String name : nameStr) {
				fi=new File(srcPath,name);
				Boolean x=fi.delete();
				if(x) {
					logger.info("文件删除成功");
					lock=true;
				}else {
					deleteFile(srcPath);
				}
			}
		}else {
			logger.info("文件夹不存在文件");
		}
		File[] files=file.listFiles();
		if(files.length>0) {
			deleteFile(srcPath);
		}else {
			file.delete();
			logger.info("删除文件夹");
		}
		return lock;
	}
	public static void main(String[] args) {
		String srcPath="D:\\file\\archivingFileList\\0001.jpg";
		String desPath="D:\\file\\001\\2017\\39\\0001.jpg";
		CopeFileTool copeFileTool=new CopeFileTool();
		copeFileTool.copeOneFile(srcPath, desPath);
	}
	
}
