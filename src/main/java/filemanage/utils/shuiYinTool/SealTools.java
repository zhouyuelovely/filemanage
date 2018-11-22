package filemanage.utils.shuiYinTool;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Component;

import filemanage.collectandorganize.vo.BoxSideBoxRidge;
import filemanage.collectandorganize.vo.ExaminaBoxHelp;
import filemanage.collectandorganize.vo.Shuiyin;

public class SealTools {
	private Logger logger=Logger.getLogger(SealTools.class);
	// 水印透明度
    private float alpha = 1f;
    private float alph=0.8f;
    // 水印横向位置
    private int width = 800;
    // 水印纵向位置
    private int height = 10;
    // 水印文字字体
    private Font font = new Font("仿宋体", Font.BOLD, 30);
    // 水印文字颜色
    private Color color = Color.red;
	
    
    /**
     * 装盒相关水印
     * @param boxSideBoxRidge 盒相关信息
     * @param srcImage
     * @return
     */
	public static Map boxInfor(BoxSideBoxRidge boxSideBoxRidge,HttpServletRequest request) {
		String srcImage =request.getSession().getServletContext().getRealPath("shuiYin")+"/box.jpg";
		SealTools sTools=new SealTools();
		Map<String, String> map=new HashMap<String,String>();
		//创建盒子信息保存文件夹
		String path="D:/file"+"/"+boxSideBoxRidge.getQuanzongNumber()+"/"+boxSideBoxRidge.getBoxanual()+"/"+boxSideBoxRidge.getBoxnumber();
		File file=new File(path);
		if(file.exists()) {
			sTools.logger.info(path+"已存在");
		}else {
			Boolean res=file.mkdirs();//创建文件夹
			if(res) {
				sTools.logger.info("路径"+path+"创建成功");
			}else {
				sTools.logger.info("路径"+path+"创建失败");
			}
		}
		String boxInfor=sTools.boxContent(boxSideBoxRidge,srcImage);
		String remarkInfor=sTools.remarkContent(boxSideBoxRidge,request);
		map.put("boxInfor", boxInfor);
		map.put("remarkInfor", remarkInfor);
		return map;
	}
	
	/**
	 * 归档章
	 * @param shuiYin 归档章内容
	 * @param srcImage 目标文件
	 * @param syImgPath 水印图片
	 */
	public void archiveInfor(Shuiyin shuiYin,String srcImage,HttpServletRequest request) {
		String syImgPath=request.getSession().getServletContext().getRealPath("shuiYin")+"/archive.jpg";
		//获取生成水印图片
		logger.info("开始生成归档章水印·······");
		String tempImg=srchiveContent(shuiYin,syImgPath,request);
		logger.info("开始图片打水印······");
		markImageByIcon(tempImg,srcImage,srcImage,null);
		delete(tempImg);
	}
	//生成水印图片
	public String srchiveContent(Shuiyin shuiYin,String syImgPath,HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("temporaryImage");
		//生成水印图片
		String quanZangNum=producePath(path,syImgPath);
		String anual=producePath(path,syImgPath);
		String piceNum=producePath(path,syImgPath);
		String scName=producePath(path,syImgPath);
		String retentionperiodName=producePath(path,syImgPath);
		String pageNum=producePath(path,syImgPath);
		Font font=new Font("仿宋体", Font.BOLD, 30);
		Color color = Color.red;
		//图片打印文字
		markImageByText(shuiYin.getQuanzongId(),syImgPath,quanZangNum,15, 45, null,font,color);
		markImageByText(shuiYin.getAnual(),quanZangNum,anual,145, 45, null,font,color);
		markImageByText(shuiYin.getPiceNum(),anual,piceNum,260, 45, null,font,color);
		markImageByText(shuiYin.getScName(),piceNum,scName,15, 115, null,font,color);
		markImageByText(shuiYin.getRetentionperiodName(),scName,retentionperiodName,165, 115, null,font,color);
		markImageByText(shuiYin.getPageNum(),retentionperiodName,pageNum,280, 115, null,font,color);
		//删除多余信息
		delete(quanZangNum);
		delete(anual);
		delete(piceNum);
		delete(scName);
		delete(retentionperiodName);
		
		//返回水印图片
		logger.info("水印图片为："+pageNum);
		return pageNum;
	}
	
	
	/**
	 * 备考表检查人信息生成
	 * @param examinaBoxHelp 检查人信息
	 * @param secImage 原文件路径
	 * @return
	 */
	public String examinaContent(ExaminaBoxHelp examinaBoxHelp,String secImage) {
		logger.info("备考表信息为:"+examinaBoxHelp);
		String path=secImage.substring(0,secImage.lastIndexOf("/"));
		logger.info("文件路径为"+path);
		String examinaPerson=producePath(path,secImage);//检查人
		String examinaTime=path+"/备考表.jpg";//检查时间
		logger.info("最后文件是："+examinaTime);
		Font font=new Font("仿宋体", Font.PLAIN, 60);
		Color color = Color.BLACK;
		markImageByText(examinaBoxHelp.getExaminaPerson(),secImage,examinaPerson,1470,3200,null,font,color);
		markImageByText(examinaBoxHelp.getTime(), examinaPerson, examinaTime, 1680, 3200, null,font,color);
		delete(secImage);
		delete(examinaPerson);
		return examinaTime;
	}
	
	//盒面盒脊信息生成
	public String boxContent(BoxSideBoxRidge boxSideBoxRidge,String srcImage) {
		String path="D:/file"+"/"+boxSideBoxRidge.getQuanzongNumber()+"/"+boxSideBoxRidge.getBoxanual()+"/"+boxSideBoxRidge.getBoxnumber();
		//水印图片，方便水印打好后删除
		String quanZongNum=producePath(path,srcImage);
		String anual=producePath(path,srcImage);
		String term=producePath(path,srcImage);
		String second=producePath(path,srcImage);
		String begin=producePath(path,srcImage);;
		String end=producePath(path,srcImage);
		String boxNum=producePath(path,srcImage);
		String quanZongName=path+"/盒面盒脊.jpg";
		Font otherFont=new Font("仿宋体", Font.BOLD, 18);
		Font archiveFont=new Font("宋体", Font.BOLD, 36);
		Color color = Color.red;
		//图片打水印
		markImageByText(boxSideBoxRidge.getQuanzongNumber(),srcImage,quanZongNum,30,160,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getBoxanual(),quanZongNum,anual,30,245,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getAmmasmretentionperiod(),anual,term,30,330,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getSecondryClassFication(),term,second,30,415,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getBoxstartnumber(),second,begin,80,500,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getBoxendnumber(),begin,end,80,585,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getBoxnumber(),end,boxNum,30,660,null,otherFont,color);
		markImageByText(boxSideBoxRidge.getQuanzongName(),boxNum,quanZongName,300,270,null,otherFont,color);
		
		//删除不需要的图片
		delete(quanZongNum);
		delete(second);
		delete(boxNum);
		delete(anual);
		delete(begin);
		delete(term);
		delete(end);
		return quanZongName;
		
	}
	//备考表信息生成
	public String remarkContent(BoxSideBoxRidge boxSideBoxRidge,HttpServletRequest request) {
		String path="D:/file"+"/"+boxSideBoxRidge.getQuanzongNumber()+"/"+boxSideBoxRidge.getBoxanual()+"/"+boxSideBoxRidge.getBoxnumber();
		String srcImage=request.getSession().getServletContext().getRealPath("shuiYin")+"/remark.jpg";
		String remark=producePath(path,srcImage);
		String organPerson=producePath(path,srcImage);
		String organTime=producePath(path,srcImage);
		Font font=new Font("仿宋体", Font.PLAIN, 60);
		Color color = Color.BLACK;
		String string=boxSideBoxRidge.getBoxsituation();
		logger.info("字数是:"+string.length());
		List<String> contentList=new ArrayList<String>();
		List<String> pathList=new ArrayList<String>();
		if(string.length()>0) {//文件的长度大于零存在汉子，对文字进行换行处理
			double p=string.length();
			double q=33;
			//生成相应的路径和换行后的内容
			for(int i=0;i<string.length();i++) {
				int m=(int) Math.ceil(p/q);//算出有几行文字
				logger.info("m"+m);
				if(i<m) {
					String x=producePath(path,srcImage);
					pathList.add(x);
					if((i+1)*33>string.length() && i*33<string.length()) {
						String y=string.substring(i*33, string.length());
						logger.info("最后文字长度："+y.length());
						contentList.add(y);
					}else {
						String y=string.substring(i*33, (i+1)*33);
						logger.info("文字长度："+y.length());
						contentList.add(y);
					}
				}else {
					break;
				}
				
			}
			//图片添加文字
			for(int i=0;i<contentList.size();i++) {
				logger.info("文件的路径："+pathList.get(i));
				logger.info("文件的内容："+contentList.get(i));
				if(i>0) {
					markImageByText(contentList.get(i),pathList.get(i-1),pathList.get(i),300,900+(100*i),null,font,color);
				}else {
					markImageByText(contentList.get(i),srcImage,pathList.get(i),300,900,null,font,color);
				}
				
			}
		}else {//无备考表内容
			String x=producePath(path,srcImage);
			pathList.add(x);//路径添加到集合中
			markImageByText("",srcImage,x,300,900,null,font,color);
		}
		
		markImageByText(boxSideBoxRidge.getCollator(),pathList.get(pathList.size()-1),organPerson,1470,3080,null,font,color);
		markImageByText(boxSideBoxRidge.getFinishingTime(),organPerson,organTime,1680,3080,null,font,color);
		delete(remark);
		delete(organPerson);
		for (String st : pathList) {
			delete(st);
		}
		return organTime;
	}
	
	/**
	 * 文件附件添加页码
	 * @param page 页码
	 * @param path 路径
	 */
	public void addPageArchiveFile(String page,String path) {
		int imgWidth = 0;
		int imgHeight = 0;
		// 获取文件的信息
		File file = new File(path);
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			ImageReader reader = readers.next();
			reader.setInput(iis, true);
			imgWidth = reader.getWidth(0);// 获取文件的宽度
			imgHeight = reader.getHeight(0);// 获取文件的高度
			logger.info("The imgWidth of this watermark picture:" + imgWidth);
			logger.info("The imgWidth of this watermark picture:" + imgHeight);
			iis.flush();
			iis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imgWidth=imgWidth-50;
		imgHeight=50;
		
		Font font=new Font("仿宋体", Font.BOLD, 36);
		Color color = Color.BLACK;
		markImageByText(page,path,path,imgWidth,imgHeight,null,font,color);
	}
	
	
	//删除文件
	public void delete(String name) {
		//删除原来的水印图片
	    File file=new File(name);
        file.delete();
	}
	
	
	/**
	 * 文字内容生成
	 * @param content 水印内容
	 * @param sourceImage 源文件
	 * @param contentImage 内容文件
	 * @param width 宽度
	 * @param heigh 高度
	 * @param degree 倾斜角度
	 */
	public String markImageByText(String content,String srcImage,
			String contentPath,Integer width,Integer heigh,Integer degree,Font font,Color color) {
		
		InputStream is = null;
        OutputStream os = null;
        try {
			//目标源文件
			Image srcImg=ImageIO.read(new File(srcImage));//
			BufferedImage buffImg=new BufferedImage(srcImg.getWidth(null), 
					srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
			
			
			// 2、得到画笔对象
			Graphics2D g = buffImg.createGraphics();
			// 3、设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(
			        srcImg.getScaledInstance(srcImg.getWidth(null),
			                srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
			        null);
			
			
			// 4、设置水印旋转
			if (null != degree) {
			    g.rotate(Math.toRadians(degree),
			            (double) buffImg.getWidth() / 2,
			            (double) buffImg.getHeight() / 2);
			}
			// 5、设置水印文字颜色
			g.setColor(color);
			// 6、设置水印文字Font
			g.setFont(font);
			// 7、设置水印文字透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
			        alpha));
			
			// 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
			g.drawString(content, width, heigh);
			// 9、释放资源
			g.dispose();
			// 10、生成图片
			// 10、生成图片
			os = new FileOutputStream(contentPath);
			ImageIO.write(buffImg, "jpg", os);
			
			logger.info("图片完成添加水印文字");
		}  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contentPath;
        
	}
	
	/**
	 * 图片打水印
	 * @param watermarkPath 水印图片路径
	 * @param srcImgPath 源文件路径
	 * @param aimImgPath 目标文件路径
	 * @param degree 倾斜角
	 */
	public void markImageByIcon(String watermarkPath,String srcImgPath,
			String aimImgPath,Integer degree) {
		OutputStream os = null;
		int imgWidth = 0;
		int imgHeight = 0;
		// 获取文件的信息
		File file = new File(srcImgPath);
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			ImageReader reader = readers.next();
			reader.setInput(iis, true);
			imgWidth = reader.getWidth(0);// 获取文件的宽度
			imgHeight = reader.getHeight(0);// 获取文件的高度
			logger.info("The imgWidth of this watermark picture:" + imgWidth);
			logger.info("The imgWidth of this watermark picture:" + imgHeight);
			iis.flush();
			iis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		imgWidth=imgWidth-380;
		imgHeight=200;
		 try {
			Image srcImg = ImageIO.read(new File(srcImgPath));
			 BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
			         srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
			 
			 // 1、得到画笔对象
			 Graphics2D g = buffImg.createGraphics();

			 // 2、设置对线段的锯齿状边缘处理
			 g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			         RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			 

			 g.drawImage(
			         srcImg.getScaledInstance(srcImg.getWidth(null),
			                 srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
			         null);
			 // 3、设置水印旋转
			 if (null != degree) {
			     g.rotate(Math.toRadians(degree),
			             (double) buffImg.getWidth() / 2,
			             (double) buffImg.getHeight() / 2);
			 }
			 
			 // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
			 ImageIcon imgIcon = new ImageIcon(watermarkPath);
			 // 5、得到Image对象。
			 Image img = imgIcon.getImage();

			 g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
			         alph));
			 
			 // 6、水印图片的位置
			 g.drawImage(img, imgWidth, imgHeight, null);
			 g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			 // 7、释放资源
			 g.dispose();
			 // 8、生成图片
			 os = new FileOutputStream(aimImgPath);
			 ImageIO.write(buffImg, "jpg", os);
			 logger.info("首页添加归档章完成");
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	
	
	
	/**
	 * 传入文件路径生成文件名称
	 * @param path 文件路径
	 * @return 
	 */
	public String producePath(String path,String srcImage){
	 	// 打开输出流
		String newImage=new String();
		try {
			// 打开输入流
			FileInputStream fis = new FileInputStream(srcImage);
			newImage = path+"/"+UUID.randomUUID()+".jpg";
			FileOutputStream fos = new FileOutputStream(newImage);
			
			// 读取和写入信息
			int len = 0;
			while ((len = fis.read()) != -1) {
			    fos.write(len);
			}
			
			// 关闭流  先开后关  后开先关
			fos.close(); // 后开先关
			fis.close(); // 先开后关
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return newImage;
	}
	
	
	public static void main(String[] args) {
		/*SealTools sealTools=new SealTools();
		String srcImage="D:/testImage/a.jpg";
		BoxSideBoxRidge boxSideBoxRidge=new BoxSideBoxRidge();
		boxSideBoxRidge.setAmmasmretentionperiod("YJ");
		boxSideBoxRidge.setBoxanual("2018");
		boxSideBoxRidge.setBoxendnumber("56");
		boxSideBoxRidge.setBoxnumber("003");
		boxSideBoxRidge.setBoxsituation("这是阿士大夫不撒敷is啊好的GV暖水袋放大四班发生过华发商都不放假撒谎");
		boxSideBoxRidge.setQuanzongName("张掖市安监局");
		boxSideBoxRidge.setQuanzongNumber("001");
		boxSideBoxRidge.setSecondryClassFication("JDZ");
		boxSideBoxRidge.setBoxstartnumber("40");
		sealTools.boxInfor(boxSideBoxRidge,srcImage);*/
		
		
		/*
		Shuiyin shuiyin=new Shuiyin();
		shuiyin.setQuanzongId("002");
		shuiyin.setAnual("2018");
		shuiyin.setPiceNum("003");
		shuiyin.setScName("987");
		shuiyin.setRetentionperiodName("YJ");
		shuiyin.setPageNum("100");
		String srcImag="D:\\test\\t.jpg";
		String syImgPath="D:\\test\\archive.jpg";
		sealTools.archiveInfor(shuiyin,srcImag, syImgPath);*/
	}
	
	
	
}
