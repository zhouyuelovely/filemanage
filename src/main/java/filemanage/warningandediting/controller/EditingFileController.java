package filemanage.warningandediting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.danganmanage.controller.DanganmanageController;
import filemanage.danganmanage.service.DanganManageService;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.MessageNotification;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;
import filemanage.warningandediting.pojo.EditingFile;
import filemanage.warningandediting.service.EditingFileService;

@Controller
@RequestMapping("editingFile")
public class EditingFileController {
	private User user;
	private Logger logger = Logger.getLogger(DanganmanageController.class);

	@Autowired
	private EditingFileService es;
	@Autowired
	private MessageNotificationService messageNotificationService;
	
	 @Autowired
	 private DanganManageService danganManageService;

	@RequestMapping("/goBianYan")
	public ModelAndView goBianYan() throws Exception {
		logger.info("跳转到编研页面");
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("editingTypeNameList", es.queryEditingFileType());
		mv.addObject("editingDateList", es.queryEditingFileDate());
		mv.setViewName("/warningandediting/Studying_archives");
		return mv;
	}

	@RequestMapping(value="/goChaKan", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView goChaKan(@RequestParam("editingId") String editingId) {
		logger.info("跳转到查看页面");
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.setViewName("/warningandediting/BianYan_results");
		return mv;
	}

	@RequestMapping(value="/goBianJi",method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView goBianJi() throws Exception {
		logger.info("跳转到加工编辑页面");
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<AmCoArchivefile> listFile=danganManageService.selectAllFile();
		for (AmCoArchivefile amCoArchivefile : listFile) {
			System.out.println(amCoArchivefile.getArchivefileid());
		}
		mv.addObject("listFile", listFile);
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("editingTypeNameList", es.queryEditingFileType());
		mv.addObject("editingFileList", es.queryAllEditingFile());
		mv.setViewName("/warningandediting/processing_editor");
		return mv;
	}

	/**
	 * 查询所有编研文件
	 * 
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectAllEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryEditingFile(int page, int limit) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<EditingFile> list = es.queryEditingFile(before, after);
		Integer count = es.countEditingFile();
		return Layui.data(count, list);
	}

	/**
	 * 查看边沿内容
	 * 
	 * @param editingId
	 * @param editingController
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEditingFileBody", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public EditingFile queryEditingFileBody(@RequestParam("editingId")String editingId)
			throws Exception {
		EditingFile ef = es.queryEditingFileBody(editingId);
		System.out.println("ef+++" + ef);
		return ef;
	}

	/**
	 * 统计编研文件数量
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/countEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void countEditingFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int count = es.countEditingFile();
		System.out.println("count+++" + count);
	}

	/**
	 * 搜索框模糊查询
	 * 
	 * @param page
	 * @param limit
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectFuzzyEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui fuzzyEditingFile(int page, int limit, String searchBody) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<EditingFile> list = es.fuzzyEditingFile(before, after, searchBody);
		Integer count = es.countFuzzyEditingFile(searchBody);
		return Layui.data(count, list);
	}

	/**
	 * 下拉查看文件
	 * 
	 * @param page
	 * @param limit
	 * @param editingTypeName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEditingFileByType", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryEditingFileByType(int page, int limit, String editingTypeName) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		List<EditingFile> list = es.queryEditingFileByType(before, after, editingTypeName);
		Integer count = es.countQueryEditingFileByType(editingTypeName);
		return Layui.data(count, list);
	}

	/**
	 * 根据编研时间查看文件
	 * 
	 * @param page
	 * @param limit
	 * @param editingDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEditingFileByDate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryEditingFileByDate(int page, int limit, String editingDate) throws Exception {
		int before = limit * (page - 1);
		int after = page * limit;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<EditingFile> list = es.queryEditingFileByDate(before, after, sdf.parse(editingDate));
		Integer count = es.countQueryEditingFileByDate(sdf.parse(editingDate));
		System.out.println("时间：" + sdf.parse(editingDate));
		return Layui.data(count, list);
	}

	/**
	 * 删除编研文件
	 * 
	 * @param editingId
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer deleteEditingFile(@RequestParam("editingId") String editingId) throws Exception {
		 Integer result=null;
		  Integer count = es.deleteEditingFile(editingId);
		  if(count>0) {
			  result=1;
		  }else {
			  result=2;
		  }
		return result;
	}

	/**
	 * 加工编辑界面搜索框模糊查询
	 * 
	 * @param searchBody
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectFuzzyEditingFileTitle", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<AmCoArchivefile> fuzzyEditingFileTitle(String searchBody) throws Exception {
		List<AmCoArchivefile> list = danganManageService.fuzzyEditingFileTitle(searchBody);
		return list;
	}

	/**
	 * 添加编研文件
	 * 
	 * @param editingType
	 * @param editingTitle
	 * @param editingAuthor
	 * @param editingController
	 * @throws Exception 
	 */
	@RequestMapping(value = "/insertEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer addEditingFile(@RequestParam("editingTypeName")String editingTypeName, 
			@RequestParam("editingDate")String editingDate, @RequestParam("editingTitle")String editingTitle, 
			@RequestParam("editingAuthor")String editingAuthor,
			@RequestParam("editingController")String editingController) throws Exception {
		user = HavingUserInfor.havingUser();
		Integer result=null;
		EditingFile a = es.queryByTypeName(editingTypeName);
		Integer editingType = a.getEditingType();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EditingFile editingFile=new EditingFile();
		editingFile.setEditingAuthor(editingAuthor);
		editingFile.setEditingController(editingController);
		editingFile.setEditingDate(sdf.parse(editingDate));
		editingFile.setEditingTitle(editingTitle);
		editingFile.setEditingType(editingType);
		editingFile.setEditingTypeName(editingTypeName);
		if(es.addEditingFile(editingFile)>0) {
			result=1;
		}else {
			result=2;
		}
		return result;
	}
	
	/**
	 * 修改编研文件
	 * 
	 * @param editingId
	 * @param editingTypeName
	 * @param editingDate
	 * @param editingTitle
	 * @param editingAuthor
	 * @param editingController
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeEditingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer updateEditingFile(@RequestParam("editingTypeName")String editingTypeName,
			 @RequestParam("editingTitle")String editingTitle,@RequestParam("editingController")String editingController,
			 @RequestParam("editingId") String editingId) {
		user = HavingUserInfor.havingUser();
		Integer result=null;
		EditingFile a = es.queryByTypeName(editingTypeName);
		Integer editingType = a.getEditingType();
		EditingFile editingFile=new EditingFile();
		editingFile.setEditingController(editingController);
		editingFile.setEditingTitle(editingTitle);
		editingFile.setEditingType(editingType);
		editingFile.setEditingTypeName(editingTypeName);
		editingFile.setEditingId(editingId);
		if(es.updateEditingFile(editingFile)>0) {
			result=1;
		}else {
			result=2;
		}
		return result;
	}
}
