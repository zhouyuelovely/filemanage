package filemanage.utils.yuancheng;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtil {
	public static void main(String[] args)throws IOException {
		 try{
			 downLoadFromUrl("http://localhost:8080/resource/021.zip",
	                    "021.zip","d:/resource");
	        }catch (Exception e) {
	            // TODO: handle exception
	        }
		
	}
	public static Boolean downLoadFromUrl(String urlStr,String fileName,String savePath)throws IOException {
		 	URL url = new URL(urlStr);  
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	                //设置超时间为3秒
	        conn.setConnectTimeout(3*1000);
	        //防止屏蔽程序抓取而返回403错误
	        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

	        //得到输入流
	        InputStream inputStream = conn.getInputStream();  
	        //获取自己数组
	        byte[] getData = readInputStream(inputStream);    

	        //文件保存位置
	        File saveDir = new File(savePath);
	        if(!saveDir.exists()){
	            saveDir.mkdir();
	        }
	        File file = new File(saveDir+File.separator+fileName);    
	        FileOutputStream fos = new FileOutputStream(file);     
	        fos.write(getData); 
	        if(fos!=null){
	            fos.close();  
	        }
	        if(inputStream!=null){
	            inputStream.close();
	        }


	        System.out.println("info:"+url+" download success");
	        return true;
	}
	  public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
	        byte[] buffer = new byte[1024];  
	        int len = 0;  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	        while((len = inputStream.read(buffer)) != -1) {  
	            bos.write(buffer, 0, len);  
	        }  
	        bos.close();  
	        return bos.toByteArray();  
	    }  
	  
	  public static File saveUrlAs(String url, String filePath, String fileName, String method) {
			// System.out.println("fileName---->"+filePath);
			// 创建不同的文件夹目录
			File file = new File(filePath);
			// 判断文件夹是否存在
			if (!file.exists()) {
				// 如果文件夹不存在，则创建新的的文件夹
				file.mkdirs();
			}
			FileOutputStream fileOut = null;
			HttpURLConnection conn = null;
			InputStream inputStream = null;
			try {
				//建立链接
				URL httpUrl = new URL(url);
				conn = (HttpURLConnection) httpUrl.openConnection();
				// 以Post方式提交表单，默认get方式
				conn.setRequestMethod(method);
				conn.setDoInput(true);
				conn.setDoOutput(true);
				// post方式不能使用缓存
				conn.setUseCaches(false);
				//连接指定的资源
				conn.connect();
				// 获取网络输入流
				inputStream = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				//判断文件的保存路径后面是否以/结尾
				if (!filePath.endsWith("/")) {

					filePath += "/";

				}
				//写入到文件（注意文件保存路径的后面一定要加上文件的名称）
				fileOut = new FileOutputStream(filePath + fileName);
				BufferedOutputStream bos = new BufferedOutputStream(fileOut);

				byte[] buf = new byte[4096];
				int length = bis.read(buf);
				// 保存文件
				while (length != -1) {
					bos.write(buf, 0, length);
					length = bis.read(buf);
				}
				bos.close();
				bis.close();
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("抛出异常！！");
			}
			return file;
		}

}
