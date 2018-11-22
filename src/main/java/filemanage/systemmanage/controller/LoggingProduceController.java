package filemanage.systemmanage.controller;


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
import org.springframework.web.bind.annotation.ResponseBody;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.LoggingProduceService;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.systemmanage.vo.LogginProduceCondition;
import filemanage.utils.layui.Layui;
import filemanage.utils.oracletool.OracleBackUp;
import filemanage.utils.oracletool.OracleRestore;


@Controller
@RequestMapping("/loggingProduce")
public class LoggingProduceController {
	private Logger logger =Logger.getLogger(LoggingProduceController.class);
	@Autowired
	private LoggingProduceService loggingProduceService;
	@Autowired
	private MessageNotificationService messageNotificationService;
	private User user;
	
	@RequestMapping(value="/goSafetyManagement")
	public String goSafetyManagement(HttpServletRequest request) {
		user=HavingUserInfor.havingUser();
		request.setAttribute("messageNum", messageNotificationService.countMessageNotificationStart());
		return "/archiveManage/safety_management";
	}

	/**
	 * 条件查询
	 * @param logginProduceCondition 查询条件
	 * @param limit 每页数量
	 * @param page 当前页
	 * @return
	 */


	
	@RequestMapping(value="/havingLoggingProduce",method=RequestMethod.POST)//获取页面数据
	public @ResponseBody Layui havingLoggingProduce(@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return loggingProduceService.findLoggingProduce(limit, page);
	}


	@RequestMapping(value="/findLoggingProduceByCondition",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui findLoggingProduceByCondition(LogginProduceCondition logginProduceCondition, 
			@RequestParam("limit")Integer limit,
			@RequestParam("page")Integer page) {
		return loggingProduceService.findLoggingProduceByCondition(logginProduceCondition, limit, page);
	}
	/**
	 * oracle 备份
	 * @param request
	 */
	@RequestMapping(value="oracleBackUp")
	public @ResponseBody Boolean oracleBackUp(HttpServletRequest request)throws Exception {
		String path=request.getSession().getServletContext().getRealPath("oracleFile");
		return OracleBackUp.OracleExpM(path);
	}
	/**
	 * oracle恢复
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oracleRestore")
	public @ResponseBody Boolean oracleRestore(HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("oracleFile");
		return OracleRestore.retuoreData(path);
	}
	@RequestMapping(value="/exceptContent")
	public void exceptContent(@RequestParam("str")String str,HttpServletRequest request,HttpServletResponse response)throws Exception {
		String path=request.getSession().getServletContext().getRealPath("excelFile");
		String filePath=loggingProduceService.expectLoggingProduce(str,path);
		logger.info("文件的信息为:"+filePath);
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
        }
	}
	

}
