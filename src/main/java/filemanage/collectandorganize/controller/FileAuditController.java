package filemanage.collectandorganize.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.service.BoxSubmitReviewService;
import filemanage.collectandorganize.service.FileAuditService;

import filemanage.collectandorganize.vo.BoxAuditHelp;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxPageInfo;
import filemanage.collectandorganize.vo.BoxVo;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;

import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;

/**
 * @author MLT 档案审核模块* fileAudit
 */
@Controller
@RequestMapping("/fileAudit")
public class FileAuditController {
	@Autowired
	private BoxSubmitReviewService boxSubmitReviewService;
	@Autowired
	private FileAuditService fileAuditService;

	private User user;

	private Logger logger = Logger.getLogger(FileAuditController.class);
	private String quanzongId;

	/**
	 * 进入审核页面
	 * @return
	 */
	@RequestMapping(value = "/fileAuditShow", method = RequestMethod.GET)
	public ModelAndView goFileAuditFileAudit() {
		ModelAndView mv = new ModelAndView();
		quanzongId=HavingUserInfor.havingArchiveId();
		user=HavingUserInfor.havingUser();
		logger.info("审核页面获取到的用户信息"+user);
		mv.addObject("user", user);// 获取用户信息
		mv.addObject("pageInfo", fileAuditService.havingPageInfo());
		mv.addObject("archiveInfo", fileAuditService.listArchiveInfo());
		mv.setViewName("archivescollect/fileAudit");
		return mv;
	}

	/**
	 * 初始化数据
	 * 
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/fileAuditList", method = RequestMethod.GET)
	public @ResponseBody Layui fileAuditList(Integer limit, Integer page) {
		System.out.println(fileAuditService.findAmcBox(limit, page));
		return fileAuditService.findAmcBox(limit, page);
	}

	/**
	 * 根据全宗主键查询年度
	 * 
	 * @param arcId
	 * @return
	 */
	@RequestMapping(value = "/havingAnual", method = RequestMethod.GET)
	public @ResponseBody List<BoxAuditHelp> havingAnual(String arcId) {
		return fileAuditService.listAnualByArchiveId(arcId);
	}

	/**
	 * 根据全宗主键和和年度查询盒子
	 * 
	 * @param anual
	 *            年度
	 * @param arcId
	 *            全宗主键
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/reloadHavingBox", method = RequestMethod.GET)
	public @ResponseBody Layui reloadHavingBox(@RequestParam("anual") String anual, @RequestParam("arcId") String arcId,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return fileAuditService.findAmcBoxAnualAndArchiveId(anual, arcId, limit, page);
	}

	/**
	 * 根据全宗主键和年度获取数量
	 * 
	 * @param anual
	 *            年度
	 * @param arcId
	 *            全宗主键
	 * @return
	 */
	@RequestMapping(value = "/reloadPageInfo", method = RequestMethod.GET)
	public @ResponseBody BoxPageInfo reloadPageInfo(@RequestParam("anual") String anual,
			@RequestParam("arcId") String arcId) {
		return fileAuditService.havingPageInfoAnualAndArchiveId(anual, arcId);
	}

	/**
	 * 条件查询盒子的信息
	 * 
	 * @param anual
	 *            年度
	 * @param arcId
	 *            全宗主键
	 * @param condition
	 *            条件
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/reloadCondition", method = RequestMethod.GET)
	public @ResponseBody Layui reloadCondition(@RequestParam("anual") String anual, @RequestParam("arcId") String arcId,
			@RequestParam("condition") String condition, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		BoxByCondition boxByCondition = new BoxByCondition();
		boxByCondition.setAnual(anual);
		boxByCondition.setArchiveId(arcId);
		boxByCondition.setCodition(condition);
		return fileAuditService.findAmcBoxCondition(boxByCondition, limit, page);
	}

	/**
	 * 条件查询盒子的信息
	 * 
	 * @param anual
	 *            年度
	 * @param arcId
	 *            全宗主键
	 * @param condition
	 *            条件
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/reloadCPageInfo", method = RequestMethod.GET)
	public @ResponseBody BoxPageInfo reloadCPageInfo(@RequestParam("anual") String anual,
			@RequestParam("arcId") String arcId, @RequestParam("condition") String condition) {
		BoxByCondition boxByCondition = new BoxByCondition();
		boxByCondition.setAnual(anual);
		boxByCondition.setArchiveId(arcId);
		boxByCondition.setCodition(condition);
		return fileAuditService.havingPageInfofindAmcBoxCondition(boxByCondition);

	}

	/**
	 * 审核通过
	 * 
	 * @param anual
	 *            年度
	 * @param arcId
	 *            全宗主键
	 * @return
	 */
	@RequestMapping(value = "/good", method = RequestMethod.POST)
	public @ResponseBody Boolean good(@RequestParam("anual") String anual, @RequestParam("arcId") String arcId) {
		return fileAuditService.updateGood(anual, arcId);
	}

	/**
	 * 添加驳回
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/addReturn", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Boolean addReturn(String str) {
		Boolean lock = false;
		String[] s = str.split(",");
		String name = user.getUserName();
		for (String string : s) {
			ReturnInfoBox run = new ReturnInfoBox();
			BoxVo boxVo = new BoxVo();
			run.setBoxId(string);
			run.setReturnInfoId(UUID.randomUUID().toString());
			run.setReturnInfoPreson(name);
			run.setReturnInfoTime(new Date());
			Integer in=fileAuditService.queryReturnFor(string);
			if(in>0) {
				logger.info("抽查的盒编号已经存在");
				lock = true;
			}else {
				Boolean bo = fileAuditService.addReturnFor(run);
				if (bo) {
					lock = true;
				} else {
					lock = false;
					break;
				}
			}
		}
		return lock;
	}

	/**
	 * 更具全宗和年度获取驳回情况信息
	 * 
	 * @param anual
	 *            年度
	 * @param archiveId
	 *            全宗主键
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/havingReturnInfo", method = RequestMethod.GET)
	public @ResponseBody Layui havingReturnInfo(@RequestParam("anual") String anual,
			@RequestParam("archiveId") String archiveId, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		 Layui lay =  boxSubmitReviewService.returnInfor(archiveId, anual, limit, page);
		return lay;
	}

	/**
	 * 添加驳回情况
	 * 
	 * @param returnInfoId
	 *            驳回情况主键
	 * @param returnInfoReason
	 *            驳回情况
	 * @return
	 */
	@RequestMapping(value = "/addReturnInfoReason", method = RequestMethod.POST)
	public @ResponseBody Boolean addReturnInfoReason(@RequestParam("returnInfoId") String returnInfoId,
			@RequestParam("returnInfoReason") String returnInfoReason) {
		return fileAuditService.updateReturnFor(returnInfoReason, returnInfoId);
	}

	/**
	 * 更新驳回情况
	 * 
	 * @param anual
	 *            年度
	 * @param archiveId
	 *            全宗主键
	 * @return
	 */
	@RequestMapping(value = "/updateBad", method = RequestMethod.POST)
	public @ResponseBody Boolean updateBad(@RequestParam("anual") String anual, @RequestParam("arcId") String arcId) {
		return fileAuditService.updateBad(anual, arcId);
	}
	// --------------------------------------------------------------------------------
}
