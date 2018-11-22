package filemanage.utils.ocr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.aip.ocr.AipOcr;

public class OCRSample {

	private Logger log = LoggerFactory.getLogger(OCRSample.class);

	// 设置APPID/AK/SK
	public static final String APP_ID = "10889402";
	public static final String API_KEY = "4yWCN61oLn0ai4wPkQvviL7p";
	public static final String SECRET_KEY = "mQmrsBYYQq9mDPkvnYqoo713RTx1OEYY";

	public Map sample(HttpServletRequest request, String temporaryAccessaryPath)
			throws IOException {
		log.info("---temporaryAccessaryPath---首页路径为:"+temporaryAccessaryPath);
		int width = 0;
		int height = 0;
		// 前端返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		// ocr客户端
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

		String coverName = temporaryAccessaryPath.substring(temporaryAccessaryPath.lastIndexOf("/"),
				temporaryAccessaryPath.length());
		log.info("----图片实际路径："+coverName);
		// 获取封面图片
		File sfile = new File(temporaryAccessaryPath);
		String resultPath = request.getSession().getServletContext().getRealPath("temporaryImage");
		log.info("图片虚拟存储路径："+resultPath);
		// 封面信息去噪
		ClearImageHelper.cleanImage(sfile, resultPath);

		// 去噪后的封面图片
		String image = resultPath + "/" + coverName;
		log.info("去燥后的封面图片绝对路径:"+image);
		// 获取文件的信息
		File file = new File(image);
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			ImageReader reader = readers.next();
			reader.setInput(iis, true);
			width = reader.getWidth(0);// 获取文件的宽度
			height = reader.getHeight(0);// 获取文件的高度
			log.info("The width of this picture:" + width);
			log.info("The height of this picture:" + height);
			iis.flush();
			iis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 定位数据
		int reponsibleBegin = (height / 10);
		int reponsibleEnd = (19 * height) / 70;
		int documentBegin = (11 * height) / 35;
		int documentEnd = (1 * height) / 7;
		int documentWidth = (7 * width) / 10;
		int titleBegin = (3 * height) / 7;
		int titleEnd = (1 * height) / 7;

		// 截取图片获取责任人内容

		// 新责任人图片路径
		String imageReponsible = resultPath + "/" + coverName.replace(".", "A.");
		// 图片截取
		ClearImageHelper.cutPic(image, imageReponsible, 0, reponsibleBegin, width, reponsibleEnd);
		// 识别结果
		JSONObject resReponsible = client.basicGeneral(imageReponsible, options);
		// 获取识别后的数据
		JSONArray listReponsible = resReponsible.getJSONArray("words_result");
		// 组装字符串
		StringBuffer stringReponsible = new StringBuffer();
		for (int i = 0; i < listReponsible.length(); i++) {
			stringReponsible.append(listReponsible.getJSONObject(i).get("words"));
		}
		log.info("archiveFileResponsible" + stringReponsible.toString());
		// 数据添加到
		map.put("archiveFileResponsible", stringReponsible.toString());

		// 文号内容

		// 新文号图片路径
		String imageDocument = resultPath + "/" + coverName.replace(".", "B.");
		// 截取图片获取文号相关信息
		ClearImageHelper.cutPic(image, imageDocument, 0, documentBegin, documentWidth, documentEnd);
		// 识别结果
		JSONObject resDocument = client.basicGeneral(imageDocument, options);
		// 获取识别后的数据
		JSONArray listDocument = resDocument.getJSONArray("words_result");
		// 组装字符串
		StringBuffer stringDocument = new StringBuffer();
		for (int i = 0; i < listDocument.length(); i++) {
			stringDocument.append(listDocument.getJSONObject(i).get("words"));
		}
		log.info("archiveFileReferenceNumber" + stringDocument.toString());
		// 数据添加到
		map.put("archiveFileReferenceNumber", stringDocument.toString());

		// 题名内容

		// 新题名图片路径
		String imageTitle = resultPath + "/" + coverName.replace(".", "C.");
		// 截取图片个、获取题名相关信息
		ClearImageHelper.cutPic(image, imageTitle, 0, titleBegin, width, titleEnd);
		// 识别图片
		JSONObject resTitle = client.basicGeneral(imageTitle, options);
		// 识别结果
		JSONArray listTitle = resTitle.getJSONArray("words_result");
		// 组装字符串
		StringBuffer stringTitle = new StringBuffer();
		for (int i = 0; i < listTitle.length(); i++) {
			stringTitle.append(listTitle.getJSONObject(i).get("words"));
		}
		log.info("archiveFileTitle" + stringTitle.toString());
		// 数据添加到
		map.put("archiveFileTitle", stringTitle.toString());
		
		OCRSample o = new OCRSample();
		o.delete(image);
		o.delete(imageReponsible);
		o.delete(imageDocument);
		o.delete(imageTitle);
		return map;
	}

	private void delete(String pathname) {
		File file = new File(pathname);
		file.delete();
	}

	public Map size(String filePath) {
		long startTime = System.currentTimeMillis();
		Map<String, Object> imageInfoMap = new HashMap<>();
		InputStream is = null;
		try {
			File file = new File(filePath);
			is = new FileInputStream(file);
			BufferedImage image = ImageIO.read(is);
			System.out.println(file.length() + ":" + image.getWidth() + ":" + image.getHeight());
			imageInfoMap.put("IMAGE_SIZE", file.length());
			imageInfoMap.put("IMAGE_WIDTH", image.getWidth());
			imageInfoMap.put("IMAGE_HEIGHT", image.getHeight());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close(); // 关闭流
				} catch (IOException e) {
					log.error("getImageInfo I/O exception " + e.getMessage(), e);
				}
			}
		}
		long endTime = System.currentTimeMillis();
		log.info("take time: " + (endTime - startTime));
		return imageInfoMap;
	}

	public void getImageInfoByImageReader(String filePath) {
		long beginTime = new Date().getTime();
		File file = new File(filePath);
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			ImageReader reader = readers.next();
			reader.setInput(iis, true);
			System.out.println("width:" + reader.getWidth(0));
			System.out.println("height:" + reader.getHeight(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = new Date().getTime();
		log.info("使用[ImageReader]获取图片尺寸耗时：[" + (endTime - beginTime) + "]ms");
	}


}
