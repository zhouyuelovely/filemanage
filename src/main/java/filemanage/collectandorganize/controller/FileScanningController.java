package filemanage.collectandorganize.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.TemporaryFile;
import filemanage.collectandorganize.service.FileScanningService;
import filemanage.login.pojo.User;
import filemanage.login.service.LogService;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.Archive;
import filemanage.utils.ocr.OCRSample;
import filemanage.utils.page.PageBean;
import filemanage.utils.paperbuild.OracleImp;
import filemanage.utils.paperbuild.ZipTool;
import filemanage.utils.premission.PremissionFilter;

/**
 * @author FYX
 *
 */
@Controller
@RequestMapping("/fileScanning")
public class FileScanningController {

	private Logger log = LoggerFactory.getLogger(FileScanningController.class);

	@Autowired
	private FileScanningService fileScanningService;
	@Autowired
	private LogService logService;
	private User user;
	private String quanzongId;

	/**
	 * 跳转档案扫描页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/goFileScanning")
	public ModelAndView goFileScanning(HttpServletRequest request) {
		ModelAndView mView = new ModelAndView();
		user = HavingUserInfor.havingUser();
		log.info("获取的用户信息为：" + user);
		quanzongId = HavingUserInfor.havingArchiveId();
		String view=PremissionFilter.goPage("aa", logService.filePremission(13, 19), user.getRole().getAuthorities());
		System.err.println(view);
		mView.setViewName(view);
		return mView;
	}

	/**
	 * 扫描图片
	 * 
	 * @param request
	 * @param files
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadjpg")
	public @ResponseBody String uploadjpg(HttpServletRequest request, @RequestParam("image") MultipartFile[] files)
			throws Exception {
		return fileScanningService.uploadjpg(files, user, quanzongId);
	}

	/**
	 * 图片分页并展示到页面
	 * 
	 * @param request
	 * @param currentPage
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getImgFileList", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody PageBean<TemporaryFile> getImgFileList(HttpServletRequest request,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage)
			throws Exception {
		PageBean<TemporaryFile> pageBean = null;
		if (user != null) {
			pageBean = fileScanningService.getImgList(user.getUserIdNumber(), currentPage);
		} else {
			log.info("没有拿到用户信息,用户session作用域失效或者用户数据不存在!");
		}
		return pageBean;
	}

	/**
	 * 根据路径删除图片记录
	 * 
	 * @param request
	 * @param response
	 * @param temporaryAccessaryPath
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delImg")
	public @ResponseBody Integer deleteImg(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("temporaryAccessaryPath") String temporaryAccessaryPath,
			@RequestParam("temporaryAccessaryPageNumber") String temporaryAccessaryPageNumber) throws Exception {

		return fileScanningService.deleteImgByPath(temporaryAccessaryPath, temporaryAccessaryPageNumber);
	}

	/**
	 * OCR识别
	 * 
	 * @param request
	 * @param temporaryAccessaryPath
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/imageRecognize", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> imageRecognize(HttpServletRequest request,
			@RequestParam("temporaryAccessaryPath") String temporaryAccessaryPath) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String ftp = temporaryAccessaryPath.substring(temporaryAccessaryPath.indexOf("/resource"),
				temporaryAccessaryPath.lastIndexOf("?"));
		String path = ftp.replace("/resource", "D:/file");
		if (!StringUtils.isEmpty(path)) {
			OCRSample ocrSample = new OCRSample();
			map = ocrSample.sample(request, path);
			log.info("识别图片返回的map集合为:" + map);
		} else {
			throw new Exception("识别首页失败!首页路径为:" + path);
		}
		return map;
	}

	/**
	 * 保存封面信息
	 * 
	 * @param archiveFile
	 * @param temporaryAccessaryPath
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCoverForm", method = RequestMethod.POST)
	public @ResponseBody Integer saveCoverForm(ArchiveFile archiveFile,
			@RequestParam(value = "temporaryAccessaryPath") String temporaryAccessaryPath, HttpServletRequest request)
			throws Exception {
		Integer num = null;
		String tempPath = temporaryAccessaryPath.substring(0, temporaryAccessaryPath.lastIndexOf("?"));
		// 获取session里的信息
		Archive archive = user.getArchive();
		if (archive != null && user != null && !StringUtils.isEmpty(temporaryAccessaryPath)) {
			// 获取图片数量（页数） // user.getUserIdNumber() //320111199812215811
			Integer archiveFilePages = fileScanningService.countImgPath(user.getUserIdNumber());
			// 向对象archiveFile里注入必要的参数 // user.getUserName()//范大哥
			archiveFile.setArchiveFileScanpople(user.getUserName());
			archiveFile.setArchive(archive);
			archiveFile.setArchiveFilePages(Integer.toString(archiveFilePages));
			num = fileScanningService.addCoverInfo(archiveFile, tempPath, user);
		} else {
			log.error("获取user信息失败！");
		}
		return num;
	}

	/**
	 * 离线导入压缩包
	 * 
	 * @param file
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/** 上传目录名 */
	private static final String uploadFolderName = "zipFile";

	@RequestMapping(value = "/offlineImport", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody JSONObject fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curProjectPath = session.getServletContext().getRealPath("zipFile");
		String saveDirectoryPath = curProjectPath;
		log.info("控制层,saveDirectoryPath---离线导入存放目录:" + saveDirectoryPath + "--上传文件名称:" + file.getOriginalFilename());
		JSONObject resObj = new JSONObject();
		// 判断文件是否存在
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
			if (fileName.equals("file")) {
				/*FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(saveDirectoryPath, file.getOriginalFilename()));*/
				String fileNames=file.getOriginalFilename();
				File dir = new File(saveDirectoryPath,fileNames);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				file.transferTo(dir);//保存图片
				String zipFilePath = saveDirectoryPath + "\\" + file.getOriginalFilename();
				log.info("上传压缩文件目录:" + zipFilePath);
				ZipTool.unZipFiles(new File(zipFilePath));
				Boolean boolean2 = OracleImp.OracleImpM();
				if (boolean2) {
					resObj.put("msg", "ok");
					log.info("数据库导入成功!");
				} else {
					resObj.put("msg", "error");
					log.error("数据库导入失败!");
					File file2 = new File(zipFilePath);
					if (file2.exists()) {
						file2.delete();
					}
				}
			} else {
				resObj.put("msg", "error");
			}
		} else {
			resObj.put("msg", "error");
		}
		return resObj;
	}

}