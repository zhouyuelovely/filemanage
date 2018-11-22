package filemanage.collectandorganize.controller;

import java.io.File;
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

import com.alibaba.druid.util.StringUtils;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.BoxSubmitReviewService;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxHavingRetentionperiodHelp;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;
import filemanage.utils.papersave.CustomFileUtil;
import filemanage.utils.papersave.ZipCompressorUtil;

import filemanage.utils.page.PageBean;

/**
 * @author meng
 *
 */
@Controller
@RequestMapping("/boxSubmitReview")
public class BoxSubmitReviewController {
	private Logger log = Logger.getLogger(BoxSubmitReviewController.class);

	@Autowired
	private BoxSubmitReviewService boxSubmitReviewService;
	private User user;

	/**
	 * 页面基础数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goBoxReview", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goBoxReview() {
		ModelAndView modelAndView = new ModelAndView();
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		user = HavingUserInfor.havingUser();
		log.info("档案送审中获取用户信息为:" + user);
		modelAndView.addObject("anual", boxSubmitReviewService.countArchiveFileSubmitReviewAnual(archiveId));// 获取年度集合
		modelAndView.addObject("num", boxSubmitReviewService.countAllAmcBoxNum(archiveId));// 获取全宗下盒子数量
		modelAndView.addObject("fileNum", boxSubmitReviewService.countAmcBoxArchiveFile(archiveId));// 获取全宗下盒子文件总数
		modelAndView.addObject("user", user);// 获取用户信息
		modelAndView.setViewName("/archiveFileStore/boxReview");
		return modelAndView;
	}

	/**
	 * 页面初始化表格数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/havingBoxContent", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui havingBoxContent(@RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.findAllAmcBox(archiveId, limit, page);
	}

	/**
	 * 全宗年度查询盒子
	 * 
	 * @param aunal
	 * @return
	 */
	@RequestMapping(value = "/reloadHavingBox", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui reloadHavingBox(String anual, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.queryAllAllAmcBoxByAnual(archiveId, anual, limit, page);
	}

	/**
	 * 查询盒子和文件数量
	 * 
	 * @param anual
	 *            年度
	 * @return
	 */
	@RequestMapping(value = "/reloadInfor", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody HavingInforBox reloadInfor(String anual) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.reloadAmcBoxByAnual(archiveId, anual);
	}

	/**
	 * 查询盒子和文件数量
	 * 
	 * @return
	 */
	@RequestMapping(value = "/havingInfor", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody HavingInforBox havingInforBox() {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.havingAllAllAmcBoxByAnual(archiveId);
	}

	/*
	 * 条件查询盒子信息
	 */
	@RequestMapping(value = "/conditionBoxContent", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui conditionBoxContent(@RequestParam("condition") String condition,
			@RequestParam("anual") String anual, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		BoxByCondition boxByCondition = new BoxByCondition();
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		boxByCondition.setArchiveId(archiveId);
		boxByCondition.setAnual(anual);
		boxByCondition.setCodition(condition);
		return boxSubmitReviewService.queryAllAllAmcBoxByCondition(boxByCondition, limit, page);
	}

	/**
	 * 条件查询后页面的数量
	 * 
	 * @param condition
	 *            条件
	 * @param anual
	 *            年度
	 * @return
	 */
	@RequestMapping(value = "/contionHavingInforBox", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody HavingInforBox contionHavingInforBox(@RequestParam("condition") String condition,
			@RequestParam("anual") String anual) {
		BoxByCondition boxByCondition = new BoxByCondition();
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		boxByCondition.setArchiveId(archiveId);
		boxByCondition.setAnual(anual);
		boxByCondition.setCodition(condition);
		return boxSubmitReviewService.reloadAmcBoxByCondition(boxByCondition);
	}

	/**
	 * 提交审核
	 * 
	 * @param custody
	 *            保管期限主键
	 * @param anual
	 *            年度
	 * @return
	 */
	@RequestMapping(value = "/submitAccept", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Boolean submitAccept(@RequestParam("custody") String custody,
			@RequestParam("anual") String anual, HttpServletRequest request) {
		User us = (User) request.getSession().getAttribute("user");
		log.info("监听到session中用户的信息为" + us);
		if (us != null) {
			user = us;
		}
		String[] str = custody.split(",");// 获取盒子保管期限的主键
		log.info("提交的内容是:" + str.length + "条");
		return boxSubmitReviewService.updateSubmitRrview(str, anual, user);
	}

	/**
	 * 驳回重整
	 * 
	 * @param anual
	 *            年度
	 * @return 驳回是否成功
	 */
	@RequestMapping(value = "/reorganize", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Boolean reorganize(@RequestParam("anual") String anual,
			@RequestParam("custody") String custody) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.reorganize(archiveId, anual, custody);
	}

	/**
	 * 根据年度和全宗号导出档案(压缩包)
	 * 
	 * @param boxYear
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportDocument", method = { RequestMethod.POST, RequestMethod.GET })
	public void exportDocument(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("boxYear") String boxYear, @RequestParam("retentionperiodid") String retentionperiodid)
			throws Exception {
		User user = HavingUserInfor.havingUser();
		if (!StringUtils.isEmpty(boxYear) && !StringUtils.isEmpty(retentionperiodid)) {
			// 获取文件根目录，不同框架获取的方式不一样，可自由切换
			String basePath = request.getSession().getServletContext().getRealPath("resourceZip");
			// 获取文件名称（包括文件格式）
			String fileName = user.getArchive().getQuanzongNumber() + "-" + boxYear + ".zip";
			// 组合成完整的文件路径
			String targetPath = basePath + File.separator + fileName;
			try {
				List<String> boxPathList = boxSubmitReviewService.findBoxPathList(boxYear, retentionperiodid);
				try {
					ZipCompressorUtil zc = new ZipCompressorUtil(targetPath);
					zc.compress(boxPathList);
					log.info("成功压缩该全宗该年度盒文件！");
				} catch (Exception ex2) {
					ex2.printStackTrace();
				}
				try {
					File temp = new File(targetPath);
					CustomFileUtil.downloadFile(temp, response, true);
					log.info("下载该全宗该年度盒附件压缩包成功!");
				} catch (Exception ex3) {
					ex3.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			log.error("请检查前端传参----" + "年度:" + boxYear + "---保管期限:" + retentionperiodid);
		}
	}

	/**
	 * 根据盒号查询盒子附件信息
	 * 
	 * @param boxId
	 *            盒子主键
	 * @return 盒子附件信息
	 */
	@RequestMapping(value = "/havingAmCoBoxattachment", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody AmCoBoxattachment havingAmCoBoxattachment(String boxId) {
		log.info("监听到传过来的盒子主键信息用于查看盒子封面" + boxId.length());
		return boxSubmitReviewService.queryAmCoBoxattachment(boxId);
	}

	/**
	 * 查询文件的附件的首页
	 * 
	 * @param boxId
	 *            盒子主键
	 * @param currentPage
	 *            当前页数
	 * @return
	 */
	@RequestMapping(value = "/havingFileAttachment", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody PageBean<FileAttachment> havingFileAttachment(@RequestParam("boxId") String boxId,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage) {
		log.info("监听到传过来的参数为盒子主键和当前页码:");
		return boxSubmitReviewService.queryFileAttachmentByBoxId(boxId, currentPage);
	}

	/**
	 * 根据盒子主键查询文件的信息（文件目录展示）
	 * 
	 * @param boxId
	 *            盒子主键
	 * @return 文件合集
	 */
	@RequestMapping(value = "/havingArchiveFileByBoxId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui havingArchiveFileByBoxId(String boxId, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		log.info("监听到传过来的参数是:" + boxId);
		return boxSubmitReviewService.queryArchiveFileByBoxId(boxId, limit, page);
	}

	/**
	 * 根据文件主键获取文件附件的信息
	 * 
	 * @param archivefileid
	 *            文件主键
	 * @return
	 */
	@RequestMapping(value = "/havingFileAttachmentByArchiveFileId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<FileAttachment> havingFileAttachmentByArchiveFileId(String archivefileid) {
		log.info("监听到传过来的参数是:" + archivefileid);
		return boxSubmitReviewService.queryFileAttachmentByArchiveFileId(archivefileid);
	}

	/**
	 * 根据盒子主键查询盒子信息
	 * 
	 * @param boxId
	 *            盒子主键
	 * @return
	 */
	@RequestMapping(value = "/havingAmCoBoxByBoxId", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody AmCoBox havingAmCoBoxByBoxId(String boxId) {
		log.info("获取带盒子主键用于查询盒子信息");
		return boxSubmitReviewService.queryAmCoBoxByBoxId(boxId);
	}

	/**
	 * 驳回情况表
	 * 
	 * @param anual
	 *            年度
	 * @param limit
	 *            每页数量
	 * @param page
	 *            当前页数
	 * @return
	 */
	@RequestMapping(value = "/returnInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui returnInfo(String anual, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		log.info("监听到传过来的年度参数是:" + anual + "全宗主键" + archiveId);
		return boxSubmitReviewService.returnInfor(archiveId, anual, limit, page);
	}

	/**
	 * 获取驳回情况
	 * 
	 * @param anual
	 * @return
	 */
	@RequestMapping(value = "/havingRetentionperiodHelp", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<BoxHavingRetentionperiodHelp> havingRetentionperiodHelp(String anual) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.havingRetentionperiod(archiveId, anual);
	}

	/**
	 * 保管期限年度查询
	 * 
	 * @param anual
	 *            年度
	 * @param retentionperoids
	 *            保管期限主键
	 * @param limit
	 *            每页条数
	 * @param page
	 *            当前页数
	 * @return
	 */
	@RequestMapping(value = "/queryAllAllAmcBoxByAnualAndRetentionperoid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody Layui queryAllAllAmcBoxByAnualAndRetentionperoid(@RequestParam("anual") String anual,
			@RequestParam("retentionperoids") String retentionperoids, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.queryAllAllAmcBoxByAnualAndRetentionperoid(archiveId, anual, limit, page,
				retentionperoids);
	}

	/**
	 * 保管期限 年度
	 * 
	 * @param anual
	 *            年度
	 * @param retentionperoids
	 *            保管期限主键集合
	 * @return
	 */
	@RequestMapping(value = "/reloadAmcBoxByAnualAndRetentionperoid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody HavingInforBox reloadAmcBoxByAnualAndRetentionperoid(@RequestParam("anual") String anual,
			@RequestParam("retentionperoids") String retentionperoids) {
		String archiveId = HavingUserInfor.havingArchiveId();// 获取全宗主键
		return boxSubmitReviewService.reloadAmcBoxByAnualAndRetentionperoid(archiveId, anual, retentionperoids);
	}

}
