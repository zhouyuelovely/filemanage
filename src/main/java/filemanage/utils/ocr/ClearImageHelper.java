package filemanage.utils.ocr;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ClearImageHelper {
	public static void main(String[] args) throws IOException {
		String path="D:\\test\\t.jpg";
		String a="D:\\test\\a.jpg";
		String b="D:\\test\\b.jpg";
		String c="D:\\test\\c.jpg";
		File testDataDir = new File("D:\\test\\t.jpg");
		//final String destDir = testDataDir.getAbsolutePath() + "\\tmp";
		final String destDir = "D:\\testImage\\tmp";
		cleanImage(testDataDir, destDir);
		cutPic(path,a,0,500,1500,300);
		cutPic(path,b,0,800,1500,100);
		cutPic(path,c,0,1000,1500,400);

	}
	
	
	

	/**
	 * 
	 * @param sfile
	 *            需要去噪的图像
	 * @param destDir
	 *            去噪后的图像保存地址
	 * @throws IOException
	 */
	public static void cleanImage(File sfile, String destDir) throws IOException {
		ClearImageHelper cih=new ClearImageHelper();
		File destF = new File(destDir);
		if (!destF.exists()) {
			destF.mkdirs();
		}

		BufferedImage bufferedImage = ImageIO.read(sfile);
		int h = bufferedImage.getHeight();
		int w = bufferedImage.getWidth();

		// 灰度化
		int[][] gray = new int[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int argb = bufferedImage.getRGB(x, y);
				// 图像加亮（调整亮度识别率非常高）
				int r = (int) (((argb >> 16) & 0xFF) * 1.1 + 30);
				int g = (int) (((argb >> 8) & 0xFF) * 1.1 + 30);
				int b = (int) (((argb >> 0) & 0xFF) * 1.1 + 30);
				if (r >= 255) {
					r = 255;
				}
				if (g >= 255) {
					g = 255;
				}
				if (b >= 255) {
					b = 255;
				}
				gray[x][y] = (int) Math.pow(
						(Math.pow(r, 2.2) * 0.2973 + Math.pow(g, 2.2) * 0.6274 + Math.pow(b, 2.2) * 0.0753), 1 / 2.2);
			}
		}

		// 二值化
		int threshold = cih.ostu(gray, w, h);
		BufferedImage binaryBufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (gray[x][y] > threshold) {
					gray[x][y] |= 0x00FFFF;
				} else {
					gray[x][y] &= 0xFF0000;
				}
				binaryBufferedImage.setRGB(x, y, gray[x][y]);
			}
		}

		// 矩阵打印
		/*for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (cih.isBlack(binaryBufferedImage.getRGB(x, y))) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}*/

		ImageIO.write(binaryBufferedImage, "jpg", new File(destDir, sfile.getName()));
	}

	public boolean isBlack(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() <= 300) {
			return true;
		}
		return false;
	}

	public boolean isWhite(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() > 300) {
			return true;
		}
		return false;
	}

	public int isBlackOrWhite(int colorInt) {
		if (getColorBright(colorInt) < 30 || getColorBright(colorInt) > 730) {
			return 1;
		}
		return 0;
	}

	public int getColorBright(int colorInt) {
		Color color = new Color(colorInt);
		return color.getRed() + color.getGreen() + color.getBlue();
	}

	public int ostu(int[][] gray, int w, int h) {
		int[] histData = new int[w * h];
		// Calculate histogram
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int red = 0xFF & gray[x][y];
				histData[red]++;
			}
		}

		// Total number of pixels
		int total = w * h;

		float sum = 0;
		for (int t = 0; t < 256; t++)
			sum += t * histData[t];

		float sumB = 0;
		int wB = 0;
		int wF = 0;

		float varMax = 0;
		int threshold = 0;

		for (int t = 0; t < 256; t++) {
			wB += histData[t]; // Weight Background
			if (wB == 0)
				continue;

			wF = total - wB; // Weight Foreground
			if (wF == 0)
				break;

			sumB += (float) (t * histData[t]);

			float mB = sumB / wB; // Mean Background
			float mF = (sum - sumB) / wF; // Mean Foreground

			// Calculate Between Class Variance
			float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

			// Check if new maximum found
			if (varBetween > varMax) {
				varMax = varBetween;
				threshold = t;
			}
		}

		return threshold;
	}
	
	
	/**
	 * 裁剪图片
	 * @param srcFile 源文件
	 * @param outFile 目标文件夹
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @return 
	 */
	public static boolean cutPic(String srcFile, String outFile, int x, int y,  
            int width, int height) {  
        FileInputStream is = null;  
        ImageInputStream iis = null;  
        try {  
            // 如果源图片不存在  
            if (!new File(srcFile).exists()) {  
                return false;  
            }  
  
            // 读取图片文件  
            is = new FileInputStream(srcFile);  
  
            // 获取文件格式  
            String ext = srcFile.substring(srcFile.lastIndexOf(".") + 1);  
  
            // ImageReader声称能够解码指定格式  
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(ext);  
            ImageReader reader = it.next();  
  
            // 获取图片流  
            iis = ImageIO.createImageInputStream(is);  
  
            // 输入源中的图像将只按顺序读取  
            reader.setInput(iis, true);  
  
            // 描述如何对流进行解码  
            ImageReadParam param = reader.getDefaultReadParam();  
  
            // 图片裁剪区域  
            Rectangle rect = new Rectangle(x, y, width, height);  
  
            // 提供一个 BufferedImage，将其用作解码像素数据的目标  
            param.setSourceRegion(rect);  
  
            // 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象  
            BufferedImage bi = reader.read(0, param);  
  
            // 保存新图片  
            File tempOutFile = new File(outFile);  
            if (!tempOutFile.exists()) {  
                tempOutFile.mkdirs();  
            }  
            ImageIO.write(bi, ext, new File(outFile));  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        } finally {  
            try {  
                if (is != null) {  
                    is.close();  
                }  
                if (iis != null) {  
                    iis.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
                return false;  
            }  
        }  
    }  
}
