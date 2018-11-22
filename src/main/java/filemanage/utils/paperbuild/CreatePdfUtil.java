package filemanage.utils.paperbuild;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.TiffWriter.FieldUndefined;



public class CreatePdfUtil {
	private  org.apache.log4j.Logger logger=Logger.getLogger(CreatePdfUtil.class);
	
	public static void main(String[] args)throws Exception {
		String pathname="D:\\file\\001\\1991-10-10\\区人民政府关于成立张掖市御景东方建设工程项目1号综合楼“92”高处坠落事故调查组的批复";
		File file=new File(pathname);
		File[] f=file.listFiles();
		String[] s=new String[f.length];
		for(int i=0;i<f.length;i++) {
			s[i]=f[i].toString();
		}
		List<String> xList=Arrays.asList(s);
		String pString="D:\\file\\001\\1991-10-10\\m.pdf";
		CreatePdfUtil.createPDF(pString,xList);
	}
	
	public static List<?> createPDF(String pdfPath,List<String> imagePath) throws FileNotFoundException, DocumentException, IOException {
		CreatePdfUtil cUtil=new CreatePdfUtil();
		// 1.创建document对象
		Document document = new Document();
		/*File outDir =new File("D:/file/3");*/
		
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		//pdfPath="E:/PDF/2test.pdf"
		PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
		// 3.打开文档
		document.open();
		// 添加内容
		//document.add(new Paragraph("Some content here"));
		// 设置属性
		// 设置标题
		document.addTitle("this is a title");
		// 作者
		document.addAuthor("H__D");
		// 主题
		document.addSubject("this is subject");
		// 关键字
		document.addKeywords("Keywords");
		// 创建时间
		document.addCreationDate();
		// 应用程序
		document.addCreator("zm");
	
		// 图片1 "E:/photo/timg.jpg"D:\file\3
		//图片的获取
		Image image1;
		//判断的文件
		File file;
		//返回的true/false
		Boolean isFile = true;
		//返回信息
		String msg = null ;
		//组装的消息LIST
		List<String> msgList = new ArrayList<>(); 
		for(int i=0;i<imagePath.size();i++) {
			file = new File(imagePath.get(i));
			if(file.exists()) {
				msg = "-该"+imagePath.get(i)+"开始生成";
				image1 = Image.getInstance(imagePath.get(i));
				// 设置图片位置的x轴和y轴位置,不到打开
				//image1.setAbsolutePosition(100f, 550f);
				// 设置图片的宽度和高度
				image1.scaleAbsolute(500, 600);
				// 将图片添加到pdf文件中
				document.add(image1);
				isFile = true;
				msgList.add(isFile+msg);
			}else {
				msg = "-该"+imagePath.get(i)+"的图片不存在";
				System.out.println(msg);
				isFile = false;
				msgList.add(isFile+msg);
				continue;
			}
			
			
		}
		// 5.关闭文档
		document.close();
		// 刷新文档
		write.flush();
		/*log.info("************生成PDF文件"+pdfPath);*/
		// 6.关闭书写器
		write.close();
		return msgList;
	}
	
}
