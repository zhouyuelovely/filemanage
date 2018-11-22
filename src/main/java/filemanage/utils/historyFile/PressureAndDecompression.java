package filemanage.utils.historyFile;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import filemanage.recorded.dao.HisoryDataMapper;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.recorded.pojo.HistoryData;

@Component
public class PressureAndDecompression{
	private Logger logger = Logger.getLogger(PressureAndDecompression.class);
	

	/**
	 * 解压压缩文件
	 * @param zipFileName 文件的绝对路径
	 * @param outputDirectory 文件的保存信息
	 */
	public List<String> decompressionZipFile(String zipFileName, String outputDirectory) {
		logger.info("开始解压 [" + zipFileName + "] 到 [" + outputDirectory + "]");
		List<String> list=new ArrayList<String>();
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(zipFileName);
			Enumeration<?> e = zipFile.getEntries();
			ZipEntry zipEntry = null;
			createDirectory(outputDirectory, "");
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				logger.info("解压：" + zipEntry.getName());

				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					File f = new File(outputDirectory + File.separator + name);
					f.mkdir();
					logger.info("创建目录：" + outputDirectory + File.separator + name);
				} else {
					String fileName = zipEntry.getName();
					list.add(fileName);
					fileName = fileName.replace('\\', '/');
					if (fileName.indexOf("/") != -1) {
						createDirectory(outputDirectory, fileName.substring(0, fileName.lastIndexOf("/")));
						fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
					}
					File f = new File(outputDirectory + File.separator + zipEntry.getName());
					f.createNewFile();
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					byte[] by = new byte[1024];
					int c;
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					in.close();
					out.close();
				}
			}
			logger.info("解压 [" + zipFileName + "] 完成！");
		} catch (Exception ex) {
			logger.info(ex.getMessage());
		} finally {
			if(zipFile!=null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					
				}
			}
		}
		return list;
	}
	/**
	 * 创建文件的路径
	 * @param directory 
	 * @param subDirectory
	 */
	public void createDirectory(String directory, String subDirectory) {
		String dir[];
		File fl = new File(directory);
		try {
			if (subDirectory == "" && fl.exists() != true) {
				fl.mkdir();
			} else if (subDirectory != "") {
				dir = subDirectory.replace('\\', '/').split("/");
				for (int i = 0; i < dir.length; i++) {
					File subFile = new File(directory + File.separator + dir[i]);
					if (subFile.exists() == false)
						subFile.mkdir();
					directory += File.separator + dir[i];
				}
			}
		} catch (Exception ex) {
			logger.info(ex.getMessage());
		}
	}
	/**
	 * 读取文件信息
	 * @param path 文件的绝对路径
	 * @return
	 */
	public List<List> readFile(String path){
		logger.info("读取文件"+path+"开始");
		File file=new File(path);
		FileInputStream fis =null;
		BufferedReader br =null;
		List<List> listes=new ArrayList<List>();
		List<String> list=null;
		try {
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis, "GBK"));
			list = new ArrayList<String>();
			while(br.ready()) {
				list=new ArrayList<String>();
				Integer i=0;
				String content=br.readLine();
				char[] ch=content.toCharArray();
				for (char c : ch) {
					if(c=='') {
						i++;
					}
				}
				list.add(i.toString());
				String[] strings=content.toString().replaceAll("", "/").split("/");
				List<String> lists=Arrays.asList(strings);
				for (String string : lists) {
					if(string.length()>0) {
						list.add(string);
					}
				}
				listes.add(list);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		logger.info("读取文件结束");
		return listes;
	}
	/**
	 * 删除文件
	 * @param path 文件的绝对路径
	 */
	public void deleteFile(String path) {
		logger.info("删除文件"+path+"开始");
		File file=new File(path);
		if(file.isFile()) {
			file.delete();
			logger.info("文件"+path+"成功");
		}
	}
	/**
	 * 判断文件的附件是否存在
	 * @param list 文件集合
	 * @param name 文件最后元素
	 * @return
	 */
	public String havingFile(List<String> list,String name) {
		String pathname=null;
		name=name+"_1";
		for (String string : list) {
			String fileName=string.substring(string.lastIndexOf("/")+1,string.lastIndexOf("."));
			if(name.equals(fileName)) {
				pathname=string;
				break;
			}
		}
		return pathname;
	}
	/**
	 * 获取解压后文件中压缩包的数量
	 * @param list 文件集合
	 * @return
	 */
	public Integer havingNumber(List<String> list) {
		Integer integer=0;
		for (String string : list) {
			String fileName=string.substring(string.lastIndexOf("."));//获取文件格式
			if("zip".equals(fileName.toLowerCase())) {
				integer++;
			}
		}
		return integer;
	}
	
	
	
	
	
}
