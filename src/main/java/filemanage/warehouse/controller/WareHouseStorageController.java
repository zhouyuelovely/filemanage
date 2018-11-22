package filemanage.warehouse.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;
import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.service.WareHouseStorageService;
import filemanage.warehouse.vo.ArchiveInWareHouseAssist;

/**
 * @author mlt 库房管理_档案入库部分
 */
@Controller
@RequestMapping("/wareHouseStorage")
public class WareHouseStorageController {

	private User user;
	private Logger logger = Logger.getLogger(WareHouseStorageController.class);
	@Autowired
	private MessageNotificationService messageNotificationService;

	@Autowired
	private WareHouseStorageService wareHouseStorageService;

	/**
	 * 跳转到库房管理_档案入库页面
	 * @return
	 */
	@RequestMapping(value = "/fileStorageShow", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView wareHouseListShow() {
		ModelAndView mv = new ModelAndView();
		logger.info("库房管理_档案入库");
		user = HavingUserInfor.havingUser();
		mv.addObject("archiveNumberList", wareHouseStorageService.archiveNumberList());// 获取已审核通过的档案盒有关的全宗信息列表
		mv.addObject("archiveNameList", wareHouseStorageService.archiveNameList());// 获取已审核通过的档案盒有关的全宗信息列表
		mv.addObject("pcNameList", wareHouseStorageService.pcNameList());// 获取已审核通过的档案盒有关的一级分类列表
		mv.addObject("scNameList", wareHouseStorageService.scNameList());// 获取已审核通过的档案盒有关的二级分类列表
		mv.addObject("boxAnualList", wareHouseStorageService.boxAnualList());// 获取已审核通过的档案盒年度列表
		mv.addObject("retentionperiodNameList", wareHouseStorageService.retentionperiodNameList());// 获取已审核通过的档案盒有关的保管期限名称列表
		mv.addObject("boxNumberList", wareHouseStorageService.boxNumberList());// 获取已审核通过的档案盒号列表
		mv.addObject("boxsNum", wareHouseStorageService.countBoxInfoListShow());// 档案入库页面档案盒数目
		mv.addObject("archiveFilesNum", wareHouseStorageService.countArchiveFileInBox());
		mv.addObject("user", user);// 获取用户信息
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());// 未读信息数
		mv.addObject("wareHouseName", wareHouseStorageService.listWareHouseNumber());//
		mv.addObject("wareHouseNames", wareHouseStorageService.listWareHouseNumber());//
		mv.setViewName("warehouse/fileStorage");// 库房管理展示页面
		return mv;
	}

	/**
	 * 档案入库页面信息展示
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/boxInfoList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui boxInfoList(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return wareHouseStorageService.boxInfoListShow(limit, page);
	}

	/**
	 * 多条件查询
	 * @param request
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryBoxInfoByConditions", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryBoxInfoByConditions(HttpServletRequest request, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		String quanzongNumber = request.getParameter("quanzongNumber");
		String quanzongName = request.getParameter("quanzongName");
		String pcName = request.getParameter("pcName");
		String scName = request.getParameter("scName");
		String boxAnual = request.getParameter("boxAnual");
		String retentionperiodName = request.getParameter("retentionperiodName");
		String boxNumber = request.getParameter("boxNumber");
		ArchiveInWareHouseAssist archiveInWareHouseAssist = new ArchiveInWareHouseAssist();
		archiveInWareHouseAssist.setQuanzongNumber(quanzongNumber);
		archiveInWareHouseAssist.setQuanzongName(quanzongName);
		archiveInWareHouseAssist.setPcName(pcName);
		archiveInWareHouseAssist.setScName(scName);
		archiveInWareHouseAssist.setBoxAnual(boxAnual);
		archiveInWareHouseAssist.setRetentionperiodName(retentionperiodName);
		archiveInWareHouseAssist.setBoxNumber(boxNumber);
		return wareHouseStorageService.queryBoxInfoByConditions(archiveInWareHouseAssist, limit, page);
	}

	/**
	 * 入库信息
	 * @param archiveInWareHouseAssist
	 * @return
	 */
	@RequestMapping(value = "/updateOneInStorageInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean updateOneInStorageInfo(HttpServletRequest request, ArchiveInWareHouseAssist archiveInWareHouseAssist,
			String str) {
		Boolean lock = null;
		String uuid = UUID.randomUUID().toString();
		archiveInWareHouseAssist.setStorageId(uuid);
		String storageRackNumber = request.getParameter("storageRackNumber");
		archiveInWareHouseAssist.setStorageRackNumber(storageRackNumber);
		String wareHouseBuildId = request.getParameter("wareHouseBuildId");
		archiveInWareHouseAssist.setWareHouseBuildId(wareHouseBuildId);
		int isExitSstorageRacknumber = wareHouseStorageService.isExitSstorageRacknumber(storageRackNumber);
		String ids = wareHouseStorageService.storageIdShow(storageRackNumber);
		if (isExitSstorageRacknumber > 0) {
			String[] s = str.split(",");
			for (String string : s) {
				archiveInWareHouseAssist.setStorageId(uuid);
				wareHouseStorageService.updateInWareHouse(string, ids);
			}
			lock = true;
		} else {
			if (wareHouseStorageService.addInWareHouse(archiveInWareHouseAssist)) {
				String[] s = str.split(",");
				for (String string : s) {
					/*archiveInWareHouseAssist = new ArchiveInWareHouseAssist();*/
					archiveInWareHouseAssist.setStorageId(uuid);
					int isExitBoxInfoUnderWareHouse = wareHouseStorageService.isExitBoxInfoUnderWareHouse(string);
					if (isExitBoxInfoUnderWareHouse > 0) {
						logger.info("该档案盒已入库，请重新选择");
						lock = true;
					} else {
						if (wareHouseStorageService.updateInWareHouse(string, uuid)) {
							lock = true;
						} else {
							lock = false;
							break;
						}
					}
				}
			} else {
				logger.info("新增失败！");
				lock = false;
			}

		}

		return lock;
	}

	/**
	 * 编辑入库信息
	 * 
	 * @param request
	 * @param archiveInWareHouseAssist
	 * @param boxId
	 * @return
	 */
	@RequestMapping(value = "/editOneInStorageInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean editOneInStorageInfo(HttpServletRequest request, ArchiveInWareHouseAssist archiveInWareHouseAssist,
			String boxId) {
		Boolean lock = null;
		String uuid = UUID.randomUUID().toString();
		archiveInWareHouseAssist.setStorageId(uuid);
		String storageRackNumber = request.getParameter("storageRackNumber");
		archiveInWareHouseAssist.setStorageRackNumber(storageRackNumber);
		String wareHouseBuildId = request.getParameter("wareHouseBuildId");
		archiveInWareHouseAssist.setWareHouseBuildId(wareHouseBuildId);
		String ids = wareHouseStorageService.storageIdShow(storageRackNumber);
		System.out.println(ids);
		int isExitSstorageRacknumber = wareHouseStorageService.isExitSstorageRacknumber(storageRackNumber);
		if (isExitSstorageRacknumber > 0) {
			wareHouseStorageService.editInWareHouse(boxId, ids);
			lock = true;
		} else if (isExitSstorageRacknumber == 0) {
			archiveInWareHouseAssist.setStorageId(uuid);
			archiveInWareHouseAssist.setBoxId(boxId);
			wareHouseStorageService.addInWareHouse(archiveInWareHouseAssist);
			wareHouseStorageService.editInWareHouse(boxId, uuid);
			lock = true;

		}

		return lock;
	}

	/**
	 * 根据主键查询入库信息
	 * 
	 * @param boxId
	 * @return
	 */
	@RequestMapping(value = "/queryOneInStorageInfoById", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ArchiveInWareHouseAssist queryOneInStorageInfoById(@RequestParam("boxId") String boxId) {
		ArchiveInWareHouseAssist archiveInWareHouseAssist = wareHouseStorageService.queryOneInStorageInfoById(boxId);
		return archiveInWareHouseAssist;
	}

	/**
	 * 入库操作
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/updateInWareHouse", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean updateInWareHouse(@RequestParam("str") String str, @RequestParam("uuid") String uuid) {
		return wareHouseStorageService.updateInWareHouse(str, uuid);
	}

	/**
	 * 入库弹框_获取库房编号
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseNumber", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<WareHouseBuild> listWareHouseNumber() {
		return wareHouseStorageService.listWareHouseNumber();
	}

	/**
	 * 入库弹框_根据库房编号获取密集架号
	 * 
	 * @param wareHouseBuildNumber
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseShelfNumber", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<WareHouseBuild> listWareHouseShelfNumber(String wareHouseBuildId) {
		return wareHouseStorageService.listWareHouseShelfNumber(wareHouseBuildId);
	}

	/**
	 * 入库弹框_库房编号和密集架编号获取组编号
	 * 
	 * @param wareHouseBuildNumber
	 * @param wareHouseBuildShelfNumber
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseGroupNumber", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	List<WareHouseBuild> listWareHouseGroupNumber(@RequestParam("wareHouseBuildId") String wareHouseBuildId) {
		return wareHouseStorageService.listWareHouseGroupNumber(wareHouseBuildId);
	}

	/**
	 * 入库弹框_根据库房编号、密集架号和租号获取格子号
	 * 
	 * @param wareHouseBuildNumber
	 * @param wareHouseBuildShelfNumber
	 * @param wareHouseBuildGroupNumber
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseLatticeNumber", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	List<WareHouseBuild> listWareHouseLatticeNumber(@RequestParam("wareHouseBuildId") String wareHouseBuildId) {
		return wareHouseStorageService.listWareHouseLatticeNumber(wareHouseBuildId);
	}

	// ============================档案入库编辑===========================
	/**
	 * 档案入库编辑_获取密集架编号列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseShelfNumbers", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<WareHouseBuild> listWareHouseShelfNumbers() {
		return wareHouseStorageService.listWareHouseShelfNumbers();
	}

	/**
	 * 档案入库编辑_获取组编号列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseGroupNumbers", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	List<WareHouseBuild> listWareHouseGroupNumbers() {
		return wareHouseStorageService.listWareHouseGroupNumbers();
	}

	/**
	 * 档案入库编辑_获取格子编号列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listWareHouseLatticeNumbers", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	List<WareHouseBuild> listWareHouseLatticeNumbers() {
		return wareHouseStorageService.listWareHouseLatticeNumbers();
	}

}
