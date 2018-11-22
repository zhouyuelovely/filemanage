package filemanage.collectandorganize.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.ArchiveFileStoreService;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.QueryArchiveFileCondition;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.layui.Layui;

/**
 * @author meng
 *
 */
@Controller
@RequestMapping("/archiveFileStore")
public class ArchiveFileStoreController {
	private Logger log=Logger.getLogger(ArchiveFileStoreController.class);
	@Autowired
	private ArchiveFileStoreService archiveFileStoreService;
	private User user;
	/**
	 * 转跳档案储存页面
	 * @return
	 */
	@RequestMapping(value="goStore",method=RequestMethod.GET)
	public ModelAndView goStore(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();//创建返回页面类型
		String archiveId=HavingUserInfor.havingArchiveId();
		user=HavingUserInfor.havingUser();
		log.info("监听到文件编辑中用户的信息为:"+user);
		modelAndView.addObject("count", archiveFileStoreService.countFileNumberAllArchiveFile(archiveId));//获取此全宗下所有的文件数量
		modelAndView.addObject("anualList", archiveFileStoreService.listAnual(archiveId));//获取此全宗下文件的所有年度
		modelAndView.addObject("pages", archiveFileStoreService.countAllPageNumber(archiveId));//获取此全宗下所有文件的页数
		modelAndView.setViewName("/archiveFileStore/store");
		return modelAndView;
	}
	/**
	 * 获取采集的数据
	 * @return
	 */
	@RequestMapping(value="/havingArchiveFile",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody 
	public Layui havingContent(HttpServletRequest request,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		ModelAndView modelAndView=new ModelAndView();//创建返回页面类型
		String archiveId=HavingUserInfor.havingArchiveId();
		return archiveFileStoreService.findAllArchiveFile(archiveId, limit, page);
	}
	/**
	 * 获取全宗文件的数量信息
	 * @return
	 */
	@RequestMapping(value="/noAnual",method=RequestMethod.GET)
	public @ResponseBody ArchiveFileHelpInfor noAnual() {
		String archiveId=HavingUserInfor.havingArchiveId();
		return archiveFileStoreService.archiveFileHelpInfor(archiveId);
	}
	/**
	 * 全宗年度存在获取数据
	 */
	@RequestMapping(value="/havingArchiveFileByAnual",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingArchiveFileByAnual(String anual,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		String archiveId=HavingUserInfor.havingArchiveId();//获取全宗主键
		return archiveFileStoreService.findArchiveFile(archiveId, anual, limit, page);//获取所有全宗年度信息
	}
	/**
	 * 获取全宗年度文件的数量
	 * @param anual
	 * @return
	 */
	@RequestMapping(value="/anual",method=RequestMethod.GET)
	public @ResponseBody ArchiveFileHelpInfor AnnualCalendar(String anual) {
		String archiveId=HavingUserInfor.havingArchiveId();
		return archiveFileStoreService.archiveFileHelpInforAnual(archiveId, anual);
	}
	/**
	 * 条件查询文件
	 * @param anual
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/queryCondition",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui queryCondition(@RequestParam("anual")String anual,@RequestParam("condition")String condition,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		QueryArchiveFileCondition queryArchiveFileCondition =new QueryArchiveFileCondition();
		String archiveId=HavingUserInfor.havingArchiveId();
		queryArchiveFileCondition.setAnual(anual);
		queryArchiveFileCondition.setArchiveId(archiveId);
		queryArchiveFileCondition.setCondition(condition);
		return archiveFileStoreService.queryArchiveFileByCondition(queryArchiveFileCondition, limit, page);
	}
	/**
	 * 条件查询文件的数量信息
	 * @param anual
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/queryConditionNum",method=RequestMethod.GET)
	public @ResponseBody ArchiveFileHelpInfor queryConditionNum(@RequestParam("anual")String anual,@RequestParam("condition")String condition) {
		QueryArchiveFileCondition queryArchiveFileCondition =new QueryArchiveFileCondition();
		String archiveId=HavingUserInfor.havingArchiveId();
		queryArchiveFileCondition.setAnual(anual);
		queryArchiveFileCondition.setArchiveId(archiveId);
		queryArchiveFileCondition.setCondition(condition);
		return archiveFileStoreService.archiveFileHelpInforCondition(queryArchiveFileCondition);
	}
	/**
	 * 查看文件附件
	 * @return
	 */
	@RequestMapping(value="/havingFileAttachmentList",method=RequestMethod.POST)
	public @ResponseBody List<FileAttachment> havingFileAttachmentList(String archiveFileId){
		System.out.println("文件ID："+archiveFileId);
		return archiveFileStoreService.queryFileAttachmentAddressByArchiveFileId(archiveFileId);
	}
	/**
	 * 删除文件（假删除）
	 * @param fileId 文件的主键集合
	 * @return
	 */
	@RequestMapping(value="/deleteFile",method=RequestMethod.POST)
	public @ResponseBody Boolean deleteFile(String fileId) {
		user=HavingUserInfor.havingUser();
		log.info("监听到文件编辑中用户的信息为:"+user);
		Boolean result=false;
		String[] strings=fileId.split(",");
		for (String string : strings) {
			Boolean isDelete=archiveFileStoreService.deleteArchiveFileByArchiveFileId(string);
			if(isDelete) {
				result=isDelete;
			}else {
				result=isDelete;
				break;
			}
		}
		return result;
	}
	/**
	 * 更新文件信息
	 * @param fileId
	 * @return
	 */
	@RequestMapping(value="/updateStart",method=RequestMethod.POST)
	public @ResponseBody Boolean updateStart(String anual) {
		String archiveId=HavingUserInfor.havingArchiveId();
		return archiveFileStoreService.updateArchiveFileStartByArchiveFileId(archiveId,anual);
	}
	/**
	 * 根据文件主键更新文件状态
	 * @param str 文件主键的集合
	 * @return
	 */
	@RequestMapping(value="/updateArchiveFileStartById",method=RequestMethod.POST)
	public @ResponseBody Boolean updateArchiveFileStartById(String str) {
		return archiveFileStoreService.updateArchiveFileStartById(str);
	}
	
}
