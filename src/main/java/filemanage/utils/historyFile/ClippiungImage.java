package filemanage.utils.historyFile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;



public class ClippiungImage {
	private Logger logger=Logger.getLogger(ClippiungImage.class);
	/**
	 * 获取文件的信息
	 * @param pathname 文件的绝对路径
	 * @return 文件长和宽
	 * @throws Exception
	 */
	private Map<String, Object> havingImageInfor(String pathname)throws Exception {
		Map<String, Object> map=new HashMap<String,Object>();
		int[] rgb = new int[3];
		int meng=0;
		int xm=200;
		int ym=250;
		File file=new File(pathname);//获取图片文件
		BufferedImage bufferedImage=ImageIO.read(file);//读取图片的文件
		Integer width=bufferedImage.getWidth();//获取文件的宽度
		Integer height=bufferedImage.getHeight();//获取文件的高度
		map.put("width", width);//文件宽度
		map.put("height", height);//文件高度
		if(width>3000&&height>2000) {
			xm=400;
			ym=500;
		}
		Integer minX=bufferedImage.getMinX();//获取文件的最小X坐标
		Integer minY=bufferedImage.getMinY();//获取文件的最小Y坐标
		for(int x=minX;x<xm;x++) {//获取表格左上起点坐标
			for(int y=minY;y<ym;y++) {
				Integer pixel=bufferedImage.getRGB(x, y);
				rgb[0] = (pixel & 0xff0000) >> 16;//获取文件的r值  
            	rgb[1] = (pixel & 0xff00) >> 8;//获取文件的g值
            	rgb[2] = (pixel & 0xff);//获取文件的b值
            	if(rgb[0]<10&&rgb[1]<10&&rgb[2]<10) {//获取表格线的起点
            		map.put("leftTopX", x);//表格起点横坐标
            		map.put("leftTopY", y);//表格起点纵坐标
            		logger.info("表格左上起点:x="+x+","+"y="+y+";("+rgb[0]+","+rgb[1]+","+rgb[2]+")");
            		meng=1;
            		break;
            	}
			}
			if(meng==1) {
				break;
			}
		}
		for(int x=width-10;x>(width-xm);x--) {//获取表格右上起点坐标
			for(int y=1;y<ym;y++) {
				Integer pixel=bufferedImage.getRGB(x, y);
				rgb[0] = (pixel & 0xff0000) >> 16;//获取文件的r值  
            	rgb[1] = (pixel & 0xff00) >> 8;//获取文件的g值
            	rgb[2] = (pixel & 0xff);//获取文件的b值
            	if(rgb[0]<10&&rgb[1]<10&&rgb[2]<10) {//获取表格线的起点
            		map.put("rightTopX", x);//表格起点横坐标
            		map.put("rightTopY", y);//表格起点纵坐标
            		logger.info("表格右上起点;x="+x+","+"y="+y+";("+rgb[0]+","+rgb[1]+","+rgb[2]+")");
            		meng=2;
            		break;
            	}
			}
			if(meng==2) {
				break;
			}
		}
		for(int x=minX+10;x<xm;x++) {//获取表格左下起点坐标
			for(int y=height-10;y>(height-ym);y--) {
				Integer pixel=bufferedImage.getRGB(x, y);
				rgb[0] = (pixel & 0xff0000) >> 16;//获取文件的r值  
            	rgb[1] = (pixel & 0xff00) >> 8;//获取文件的g值
            	rgb[2] = (pixel & 0xff);//获取文件的b值
            	if(rgb[0]<10&&rgb[1]<10&&rgb[2]<10) {//获取表格线的起点
            		map.put("leftLowerX", x);//表格起点横坐标
            		map.put("leftLowerY", y);//表格起点纵坐标
            		logger.info("表格左下起点;x="+x+","+"y="+y+";("+rgb[0]+","+rgb[1]+","+rgb[2]+")");
            		meng=3;
            		break;
            	}
			}
			if(meng==3) {
				break;
			}
		}
		for(int x=width-10;x>(width-xm);x--) {//获取表格右下起点坐标
			for(int y=height-10;y>(height-ym);y--) {
				Integer pixel=bufferedImage.getRGB(x, y);
				rgb[0] = (pixel & 0xff0000) >> 16;//获取文件的r值  
            	rgb[1] = (pixel & 0xff00) >> 8;//获取文件的g值
            	rgb[2] = (pixel & 0xff);//获取文件的b值
            	if(rgb[0]<10&&rgb[1]<10&&rgb[2]<10) {//获取表格线的起点
            		map.put("rightLowerX", x);//表格起点横坐标
            		map.put("rightLowerY", y);//表格起点纵坐标
            		logger.info("表格右下起点;x="+x+","+"y="+y+";("+rgb[0]+","+rgb[1]+","+rgb[2]+")");
            		meng=4;
            		break;
            	}
			}
			if(meng==4) {
				break;
			}
		}
		return map;
	}
	/**
	 * 清除图片上影响剪切的文字
	 * @param pathname 文件的绝对路径
	 * @throws Exception 
	 */
	public List<List> havingImageCoorDinate(String pathname) throws Exception {
		Map<String, Object> map=havingImageInfor(pathname);
		List<List> listes=new ArrayList<List>();
		List<String> listPath=null;
		String pathName=null;
		String outFile ="D:/file/archivingFileList/results";
		Integer x=0;//剪切x值
		Integer y=0;//剪切y值
		Integer z=0;//剪切z值
		Integer width=(Integer) map.get("width");//获取图片的宽
		Integer height=(Integer)map.get("height");//获取图片的高
		Integer leftTopX=(Integer) map.get("leftTopX");//获取表格左上角起点横坐标
		Integer leftTopY=(Integer)map.get("leftTopY");//获取表格左上角起点的纵坐标
		Integer rightTopX=(Integer)map.get("rightTopX");//获取表格右上角起点的横坐标
		Integer rightTopY=(Integer)map.get("rightTopY");//获取表格右上角起点的纵坐标
		Integer leftLowerX=(Integer)map.get("leftLowerX");//获取表格左下角起点的横坐标
		Integer leftLowerY=(Integer)map.get("leftLowerY");//获取表格左下角起点的纵坐标
		Integer rightLowerX=(Integer)map.get("rightLowerX");//获取表格右下角起点的横坐标
		Integer rightLowerY=(Integer)map.get("rightLowerY");//获取表格右下角起点的纵坐标
		File file=new File(pathname);//获取图片文件
		BufferedImage bufferedImage=ImageIO.read(file);//读取图片的文件
		Graphics graphics=bufferedImage.getGraphics();//获取画笔工具
		graphics.clearRect((leftTopX+4), (leftTopY+5), 40, 60);//清空文字
		graphics.clearRect((rightTopX-55), (rightTopY+5), 50, 60);//清空文字
		graphics.drawImage(bufferedImage, (leftTopX+4), (leftTopY+5), 40, 60, Color.white, null);//设置背景
		graphics.drawImage(bufferedImage, (rightTopX-55), (rightTopY+5), 50, 60, Color.white, null);//设置背景
		graphics.fillRect((leftTopX+2), (leftTopY+2), 44, 65);//背景填充
		graphics.fillRect((rightTopX-57), (rightTopY+4), 55, 65);//背景填充
		graphics.dispose();//关闭画笔
		ImageIO.write(bufferedImage, "jpeg", file);//保存图片
		if(rightTopY-leftTopY>0) {
			y=rightTopY+2;
		}else if(rightTopY-leftTopY<=0) {
			y=leftTopY+2;
		}
		String xname=cutImage(pathname, outFile+"/x"+UUID.randomUUID()+".jpg", 0, y, width, 5);//剪切表头
		List<Integer> xList=havingInforCutImage(xname,1);
		
		if(leftLowerX-leftTopX>0) {
			x=leftLowerX+2;
		}else if(leftLowerX-leftTopX<=0) {
			x=leftTopX+2;
		}
		String yname=cutImage(pathname, outFile+"/y"+UUID.randomUUID()+".jpg", x, 0, 5, height);//剪切序号
		List<Integer> yList=havingInforCutImage(yname, 2);
		if(rightLowerX-rightTopX>=0) {
			z=rightTopX-10;
		}else if(rightLowerX-rightTopX<0) {
			z=rightLowerX-10;
		}
		String zname=cutImage(pathname, outFile+"/z"+UUID.randomUUID()+".jpg", z, 0, 5, height);//剪切备注
		List<Integer> zList=havingInforCutImage(yname, 3);
		for(int m=1;m<yList.size()-1;m++) {
			listPath=new ArrayList<String>();
			for(int n=0;n<xList.size()-1;n++) {
				pathName=cutImage(pathname, outFile+"/"+m+"-"+n+UUID.randomUUID()+".jpg", xList.get(n), yList.get(m), (xList.get(n+1)-xList.get(n)), (yList.get(m+1)-yList.get(m)));
				listPath.add(pathName);
			}
			listes.add(listPath);
		}
		deleteFile(xname);
		deleteFile(yname);
		deleteFile(zname);
		return listes;
	}
	/**
	 * 获取表格线位置
	 * @param pathname 文件绝对路径
	 * @param index 区分截取图片类型
	 * @throws Exception
	 */
	private List<Integer> havingInforCutImage(String pathname,Integer index)throws Exception {//获取表格的大致结构
		List<Integer> list=new ArrayList<Integer>();
		int[] rgb = new int[3];  
        File file = new File(pathname);  
        BufferedImage bi = ImageIO.read(file);
        Integer width = bi.getWidth();  
        Integer height = bi.getHeight();  
        Integer minx = bi.getMinX();  
        Integer miny = bi.getMinY();
        if(index==1) {
        	for(int x=minx;x<width;x++) {
        		for(int y=height-1;y>(height-2);y--) {
        			int pixel = bi.getRGB(x, y); // 下面三行代码将一个数字转换为RGB数字  
                    rgb[0] = (pixel & 0xff0000) >> 16; 
                    rgb[1] = (pixel & 0xff00) >> 8; 
                    rgb[2] = (pixel & 0xff);
                    if(rgb[0]<100) {
                    	list.add(x);
                    }
        		}
        	}
        	list=cutSameElemnt(list);
        }else if(index==2) {
        	for(int x=width-1;x>(width-2);x--) {
        		for(int y=miny;y<height-10;y++) {
        			int pixel = bi.getRGB(x, y); // 下面三行代码将一个数字转换为RGB数字  
                    rgb[0] = (pixel & 0xff0000) >> 16; 
                    rgb[1] = (pixel & 0xff00) >> 8; 
                    rgb[2] = (pixel & 0xff);
                    if(rgb[0]<100) {
                    	list.add(y);
                    }
        		}
        	}
        	list=cutSameElemnt(list);
        }else if(index==3) {
        	for(int x=width-1;x>width-2;x--) {
        		for(int y=minx;y<height-10;y++) {
        			int pixel = bi.getRGB(x, y); // 下面三行代码将一个数字转换为RGB数字  
                    rgb[0] = (pixel & 0xff0000) >> 16; 
                    rgb[1] = (pixel & 0xff00) >> 8; 
                    rgb[2] = (pixel & 0xff);
                    if(rgb[0]<100) {
                    	list.add(y);
                    }
        		}
        	}
        	list=cutSameElemnt(list);
        }
		return list;
	}
	/**
	 * 剪切图片
	 * @param pathname 文件的绝对路径
	 * @param outFile 文件的输出路径
	 * @param x 分割的x坐标
	 * @param y 分割的y坐标
	 * @param width 分割的宽度
	 * @param height 分割的高度
	 */
	public String cutImage(String pathname, String outFile, int x, int y,  
            int width, int height) throws Exception{
		InputStream is = null;  
        ImageInputStream iis = null;
        File file=new File(pathname);
        if(!file.exists()) {
        	logger.info("文件不存在");
        }
        is=new FileInputStream(pathname);
        String ext = pathname.substring(pathname.lastIndexOf(".") + 1);  // 获取文件格式  
        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(ext); // ImageReader声称能够解码指定格式    
        ImageReader reader = it.next();
        iis = ImageIO.createImageInputStream(is); // 获取图片流  
        reader.setInput(iis, true); // 输入源中的图像将只按顺序读取 
        ImageReadParam param = reader.getDefaultReadParam();//设置解码
        Rectangle rect = new Rectangle(x, y, width, height);//裁剪图片
        param.setSourceRegion(rect);//解码数据
        BufferedImage bi = reader.read(0, param);
        File tempOutFile = new File(outFile);  
        if (!tempOutFile.exists()) {  
            tempOutFile.mkdirs();  
        }  
        ImageIO.write(bi, ext, new File(outFile));//保存文件
        is.close();
        iis.close();
        return outFile;
	}
	/**
	 * 移除集合中差值较近的元素
	 * @param list
	 * @return
	 */
	private List<Integer> cutSameElemnt(List<Integer> list){
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(list.get(j)-list.get(i)>0&&list.get(j)-list.get(i)<=2) {
					list.remove(i);
					cutSameElemnt(list);
				}
			}
		}
		return list;
	}
	/**
	 * 删除临时
	 * @param pathname
	 */
	public void deleteFile(String pathname) {
		System.err.println("删除文件路径:"+pathname);
		File file=new File(pathname);
		if(file.exists()) {
			file.delete();
		}
	}
	public String copyFile(String pathname)throws Exception {
		String path=pathname.substring(0, pathname.lastIndexOf("/")+1);
		String name=path+UUID.randomUUID().toString()+".jpg";
		FileInputStream fis = new FileInputStream(pathname);
		FileOutputStream fos = new FileOutputStream(name);
		// 读取和写入信息
		int len = 0;
		while ((len = fis.read()) != -1) {
		    fos.write(len);
		}
		// 关闭流  先开后关  后开先关
		fos.close(); // 后开先关
		fis.close(); // 先开后关
		return name;
	}
	public static void main(String[] args)throws Exception {
		ClippiungImage clippiungImage=new ClippiungImage();
		String pathname="D:/split/source/0001.jpg";
		//String pathnam="D:/split/source/001.jpg";
		clippiungImage.havingImageCoorDinate(pathname);
		//clippiungImage.havingImageInfor(pathnam);
		//clippiungImage.copyFile(pathname);
	}
	
}
