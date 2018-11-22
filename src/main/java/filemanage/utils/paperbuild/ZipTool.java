package filemanage.utils.paperbuild;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

public class ZipTool {

	private static Logger log = Logger.getLogger(ZipTool.class);

	public static void unZipFiles(File zipFile) {
		String descDir = "D:\\";
		try {
			ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));// 解决中文文件夹乱码
			String name = zip.getName().substring(zip.getName().lastIndexOf('\\') + 1, zip.getName().lastIndexOf('.'));

			File pathFile = new File(descDir + name);
			if (!pathFile.exists()) {
				pathFile.mkdirs();
			}
			for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				InputStream in = zip.getInputStream(entry);
				String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
				log.info("------outPath:" + outPath);
				// 判断路径是否存在,不存在则创建文件路径
				File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
				if (!file.exists()) {
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
				if (new File(outPath).isDirectory()) {
					continue;
				}
				// 输出文件路径信息
				// System.out.println(outPath);

				FileOutputStream out = new FileOutputStream(outPath);
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				out.close();
				in.close();
				log.info("******************解压完毕********************");
			}
			zip.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			File file2 = zipFile;
			if (file2.exists()) {
				file2.delete();
				log.info("删除成功:" + file2);
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		String zipFilePath = "D:\\Config\\apache-tomcat-9.0.1\\wtpwebapps\\filemanage\\zipFile\\file.zip";
		ZipTool.unZipFiles(new File(zipFilePath));
	}

}
