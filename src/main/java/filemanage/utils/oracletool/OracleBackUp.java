package filemanage.utils.oracletool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OracleBackUp {
	private final static String userName = "SCOTT";
	private final static String password= "SHUZHIDANGAN8";  
	private final static String SID = "SHUZHIDANGAN";
	private final static String fileName = "SHUZIDANGAN";
	private static String savePath="";
	public static Boolean OracleExpM(String path)throws Exception {
		savePath=path;
		Boolean lock=null;
		File saveFile = new File(savePath);  
		    if (!saveFile.exists()) {// 如果目录不存在  
		    	saveFile.mkdirs();// 创建文件夹  
			}  
			try {  
				String str="exp " + userName + "/" + password + "@" + SID + " file='"  
				    + savePath + "/" + fileName + ".dmp'";  
				Process process = null;  
				process = java.lang.Runtime.getRuntime().exec("cmd  /c  start cmd.exe /c " + str);  
				System.out.println("备份开始");
				InputStreamReader isr = new InputStreamReader(process.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while((line = br.readLine())!=null) {
				    if(line.indexOf("错误")!=-1) {
				    	break;
				    }

				}
				process.destroy();
				process.waitFor();
				System.out.println(str);  
				if (process.waitFor() == 0) {// 0 表示线程正常终止。  
					System.out.println("表示线程正常终止");  
					System.out.println("备份结束");  
					lock=true;              
				 }else {
					lock=false;
				 }
				
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		    return lock;  
		}  
}
