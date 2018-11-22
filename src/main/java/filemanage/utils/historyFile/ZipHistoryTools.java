package filemanage.utils.historyFile;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;



public class ZipHistoryTools {
	private static Logger logger=Logger.getLogger(ZipHistoryTools.class);
	/**
	 * 压缩文件
	 * @param pathList文件或者文件夹集合
	 * @param srcPath 输出文件的名字
	 * @throws Exception
	 */
	public static void zip(List<String> pathList,String srcPath)throws Exception{
		File file=new File(srcPath);
		if(!file.exists()) {//文件夹是否存在
			file.getParentFile().mkdirs();
		}
		ZipOutputStream zipOS=new ZipOutputStream(new FileOutputStream(srcPath));//创建zip输出流
		BufferedOutputStream bf = new BufferedOutputStream(zipOS);//创建缓存流
		if(pathList==null || pathList.size()==0){
            throw new RuntimeException("没有指定需要压缩的文件");
        }
		 for(String filePath :pathList){
             File srcFile = new File(filePath);
             zip(zipOS, srcFile, srcFile.getName(), bf); 
         }
		 bf.close();  
		 zipOS.close();
		 logger.info("压缩文件成功");
	}
	/**
	 * 压缩
	 * @param zipOS zip文件输出流
	 * @param srcFile 文件保存
	 * @param base 压缩文件名
	 * @param bf 缓存流
	 * @throws Exception
	 */
	public static void zip(ZipOutputStream zipOS,File srcFile,String base,BufferedOutputStream bf)throws Exception{
		if(srcFile.isDirectory()) {//文件为目录
			File[] fileList = srcFile.listFiles();//获取文件夹先所有的文件和文件夹
			if (fileList.length == 0) {  
				zipOS.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base  
				zipOS.closeEntry();
            }
        	for (int i = 0; i < fileList.length; i++) {  
                zip(zipOS, fileList[i], base + "/" + fileList[i].getName(), bf); // 递归遍历子文件夹  
            } 
		}else {
			zipOS.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base  
            FileInputStream in = new FileInputStream(srcFile);  
            byte[]buffer = new byte[1024];
            int len = 0;
            while((len = in.read(buffer))!=-1){
            	zipOS.write(buffer ,0 ,len);
            }  
            in.close(); // 输入流关闭 
		}
	}
	/**
	 * 获取不同模式下符号的内容
	 * @param pathname 符号文件的路径
	 * @return
	 * @throws Exception
	 */
	public static List<String> readModelFile(String pathname) throws Exception {
		List<String> listSymbl=null;
		File file=new File(pathname);
		if(file.exists()) {
			InputStream is=new FileInputStream(pathname);//创建字节流
			InputStreamReader isr=new InputStreamReader(is,"GBK");//创建转换流
			BufferedReader br=new BufferedReader(isr);//创建字符缓存流
			listSymbl=new ArrayList<String>();//接收文件读取的内容
			String content=null;//接收每行的数据
			while((content=br.readLine())!=null) {
				listSymbl.add(content);
			}
			br.close();
			isr.close();
			is.close();
		}else {
			logger.info("文件不存在");
		}
		return listSymbl;
	}
	/**
	 * 组装每一行的字符串
	 * @param listContent 内容集合
	 * @param listSymbl 符号的集合
	 * @return
	 */
	public static String lineComposition(List<String> listContent,List<String> listSymbl) {
		StringBuffer sb=new StringBuffer();//字符串获取
		if(listContent.size()==listSymbl.size()) {
			for(int i=0;i<listContent.size();i++) {
				sb.append(listContent.get(i)+listSymbl.get(i));
			}
		}else {
			logger.info("文件内容和符号不匹配");
		}
		return sb.toString();
	}
	/**
	 * txt文件生成
	 * @param contentTxt Txt每行的内容
	 * @param pathnameTxt Txt文件的绝对路径
	 * @throws Exception
	 */
	public static void writerTxt(String[] contentTxt,String pathnameTxt)throws Exception {
		OutputStream os=new FileOutputStream(new File(pathnameTxt));//获取字符写入流
		OutputStreamWriter osw=new OutputStreamWriter(os, "GBK");//转换流设置编码
		BufferedWriter bw=new BufferedWriter(osw);//字符缓存流
		for (String string : contentTxt) {
			bw.write(string);
			bw.write(System.getProperty("line.separator"));
		}
		bw.flush();
		osw.flush();
		os.flush();
		bw.close();
		osw.close();
		os.close();
		logger.info("Txt文件生成");
	}
	/**
	 * 生成ini文件
	 * @param contentIn ini文件内容
	 * @param pathnameIni ini文件绝对路径
	 * @throws Exception
	 */
	public static void writerIni(String[] contentIni,String pathnameIni)throws Exception {
		OutputStream os=new FileOutputStream(new File(pathnameIni));//获取字符写入流
		OutputStreamWriter osw=new OutputStreamWriter(os, "GBK");//转换流设置编码
		BufferedWriter bw=new BufferedWriter(osw);//字符缓存流
		for (String string : contentIni) {
			bw.write(string);
			bw.write(System.getProperty("line.separator"));
		}
		bw.flush();
		osw.flush();
		os.flush();
		bw.close();
		osw.close();
		os.close();
		logger.info("Ini文件生成");
	}
	/**
	 * 生成六位数数字
	 * @param size
	 * @return
	 */
	public static Integer havingIndex(Integer size) {
		Integer index=(int)((Math.random()*9+1)*100000);
		if((index+size)>=1000000) {
			havingIndex(size);
		}
		return index;
	}
	/**
	 * 获取时间信息
	 * @return
	 */
	public static String havingTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy\\MM\\dd EEEE HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * 删除文件
	 * @param pathname
	 */
	public static void deleteFile(String pathname) {
		File file=new File(pathname);
		if(file.isDirectory()) {
			File[] files=file.listFiles();
			for (File subFile : files) {
				deleteFile(subFile.getPath());
			}
		}
		file.delete();
	}
	public static void main(String[] args) {
		String name="D:/file/expectTT/敦煌泰坦";
		ZipHistoryTools.deleteFile(name);
	}
}
