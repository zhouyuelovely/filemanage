package filemanage.utils.paperbuild;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class OracleImp {
	private static Logger log=Logger.getLogger(OracleImp.class);
	private final static String userName = "scott";
	private final static String passWord= "tiger";  
	private final static String dataBaseName = "SHUZIDANGAN";
	private static String address="D:\\file";
	public static Boolean OracleImpM() {
		//imp scott/SHUZHIDANGAN8@SHUZHIDANGAN file=D:\file\SHUZHIDANGAN.dmp---D:\file\SHUZHIDANGAN.dmp
		StringBuffer exp = new StringBuffer("imp ");
		exp.append(userName);
		exp.append("/");
		exp.append(passWord);
		exp.append("@");
		exp.append(dataBaseName);
		exp.append(" file=");
		String maxIndex = address.substring(address.length() - 1);
		if ("/".equals(maxIndex) || "||".equals(maxIndex)) {
			exp.append(address);
		} else {
			address = address + "\\";
			exp.append(address);
		}
		exp.append(dataBaseName);
		exp.append(".dmp");
		File file = new File(address +"\\"+ dataBaseName + ".dmp");
		log.info(exp+"---"+file);
		// 判断文件是否存在，存在才进行恢复，不存在就不恢复
		if (file.exists()) {
			log.info("开始恢复...");
			try {
				exp.append(" ignore=y tables=(am_co_archivefile,am_co_file_attachment)");
				log.info("------exp:"+exp.toString());
				Process p = Runtime.getRuntime().exec("cmd  /c  start cmd.exe /c " + exp.toString());
				InputStreamReader isr = new InputStreamReader(p.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("错误") != -1) {
						break;
					}
				}
				p.destroy();
				log.info("恢复成功.....");
				p.waitFor();
				return true;

			} catch (IOException e) {
				System.out.println(e.getMessage());
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				
			}finally {
				File file2 = new File("D:\\file\\SHUZHIDANGAN.dmp");
				if (file2.exists()) {
					file2.delete();
					log.info("删除成功数据库包文件:" + file2);
				}
			}
			
		}
		log.info("---需要恢复的文件不存在:"+file);
		return false;
	}

}
