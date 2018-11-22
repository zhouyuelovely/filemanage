package filemanage.recorded.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import filemanage.recorded.service.RecordedService;
import filemanage.utils.historyFile.ZipHistoryTools;

@Controller
@RequestMapping("/expectHistory")
public class ExpectHistoryController {
	private Logger logger=Logger.getLogger(ExpectHistoryController.class);//日志记录
	@Autowired
	private RecordedService recordedService;//档案著录service
	
	/**
	 * 导出泰坦格式
	 * @param ids 文件主键的集合
	 * @param remark 标记，用于区分历史数据和新建档案 “1”：新建档案；“2”：历史数据
	 * @param response
	 */
	@RequestMapping(value="/expectHistory",method= {RequestMethod.GET,RequestMethod.POST})
	public void expectHistory(@RequestParam("ids")String ids,
			@RequestParam("remark")String remark,
			HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		String filePath=recordedService.expectHistory(ids, remark);
		String deletePath=filePath.substring(0, filePath.lastIndexOf("/"));
		String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
		InputStream inputStream=new FileInputStream(filePath);
		File file=new File(filePath);
		
		
		String userAgent = request.getHeader("USER-AGENT"); //获取浏览器信息
		System.err.println(userAgent);
		String finalFileName = null; 
		if (StringUtils.contains(userAgent, "Edge")) {
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		}else if(StringUtils.contains(userAgent, "")) {
			 finalFileName = URLEncoder.encode(fileName, "UTF8");
		}else if(StringUtils.contains(userAgent, "Chrome")) {//google/firefox
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		}else {
			finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
		}
		
		
		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=\"" + finalFileName);
		response.addHeader("Content-Length", "" + file.length());

		byte[] b = new byte[100];
        int len;
        try {
            while ((len = inputStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	ZipHistoryTools.deleteFile(deletePath);
		}
	}
	
}
