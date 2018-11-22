package filemanage.digitalarchives.controller;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.digitalarchives.service.ElectronicReadingRoomService;
import filemanage.digitalarchives.vo.ElecReadingRoomVo;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * @author MLT 电子阅览室
 *
 */
@Controller
@RequestMapping("/readingRoom")
public class ElectronicReadingRoomController {

	@Autowired
	private ElectronicReadingRoomService electronicReadingRoomService;

	/**
	 * 跳转到电子阅览室页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/publicArchiveShow", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView selectAllPublicArchive(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("archiveNameList", electronicReadingRoomService.listAllArchiveInfo());// 全宗名称下拉框列表显示
		mv.addObject("fileAnualList", electronicReadingRoomService.listArchiveFileAnual());// 获取密级为公开的文件的年度
		mv.addObject("retentionperiodNameList", electronicReadingRoomService.listRetentionperiodName());// 获取密级为公开的文件的保管期限
		mv.addObject("pcNameList", electronicReadingRoomService.listPCName());// 获取密级为公开的文件的一级分类
		mv.addObject("scNameList", electronicReadingRoomService.listSCName());// 获取密级为公开的文件的二级分类
	    mv.addObject("pagemsg", electronicReadingRoomService.selectAllPublicArchiveDh(currentPage));
		mv.setViewName("digitalarchives/electronicReadingRoom");// 跳转到电子阅览室页面
		return mv;
	}

	/**
	 * 页面数据渲染
	 * @return
	 */
	@RequestMapping(value = "/archiveFileList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui archiveFileList(@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		return electronicReadingRoomService.selectAllPublicArchive(limit, page);
	}

	/**
	 * 多条件关键词查询
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryAllPublicArchive", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryPublicArchiveFileByConditions(HttpServletRequest request,@RequestParam("limit")Integer limit,@RequestParam("page")Integer page) {
		String quanzongName = request.getParameter("quanzongName");
		String archiveFileAnual = request.getParameter("archiveFileAnual");
		String retentionperiodname = request.getParameter("retentionperiodname");
		String pcName = request.getParameter("pcName");
		String scName = request.getParameter("scName");
		String conditions = request.getParameter("condition");
		System.out.println(conditions);
		ElecReadingRoomVo elecReadingRoomVo = new ElecReadingRoomVo();
		elecReadingRoomVo.setQuanzongName(quanzongName);
		elecReadingRoomVo.setArchiveFileAnual(archiveFileAnual);
		elecReadingRoomVo.setRetentionperiodname(retentionperiodname);
		elecReadingRoomVo.setPcName(pcName);
		elecReadingRoomVo.setScName(scName);
		elecReadingRoomVo.setConditions(conditions);
		return electronicReadingRoomService.queryAllPublicAchiveFileByConditions(elecReadingRoomVo, limit, page);

	}
	
	/**
	 * 密级状态为公开的文件附件首页图片展示
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/imgListShow",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public PageBean<ElecReadingRoomVo> imgListShow(@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage) throws Exception{
		PageBean<ElecReadingRoomVo> pageBean = electronicReadingRoomService.selectAllPublicArchiveDh(currentPage);
		List<ElecReadingRoomVo> fileList = pageBean.getLists();
		for(int i = 0;i<fileList.size();i++){
			System.out.println(fileList.get(i).getArchiveFileId());
		}
		return pageBean;
		}
	
	/**
	 * 统计展示的缩略图的图片数
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/countImgNum",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int countImgNum() throws Exception{
		return electronicReadingRoomService.countAllPublicArchiveDh();
	}

	/**
	 * 查看每份文件的附件(图片展示)
	 * @param request
	 * @param amCoArchivefile
	 * @return
	 */
	@RequestMapping(value="/searchAllPublicArchiveFile",method=RequestMethod.POST)
	@ResponseBody
	public List<FileAttachment> fileAttachmentListShow(String archiveFileId) {
		return electronicReadingRoomService.selectFileAttachmentByArchiveFileId(archiveFileId);
	}

}
