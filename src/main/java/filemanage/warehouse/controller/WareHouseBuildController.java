package filemanage.warehouse.controller;

import java.util.List;

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
import filemanage.warehouse.service.WareHouseBuildService;
import filemanage.warehouse.vo.WareHousePageInfo;
/**
 * @author mlt 库房管理_库房建设
 */
@Controller
@RequestMapping("/wareHouseBuild")
public class WareHouseBuildController {

	private User user;

	private Logger logger = Logger.getLogger(WareHouseBuildController.class);

	@Autowired
	private MessageNotificationService messageNotificationService;

	@Autowired
	private WareHouseBuildService wareHouseBuildService;

	/**
	 * 跳转到库房管理_库房建设页面
	 * @return
	 */
	@RequestMapping(value = "/wareHouseListShow", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView wareHouseListShow() {
		ModelAndView mv = new ModelAndView();
		logger.info("库房管理_库房建设");
		user = HavingUserInfor.havingUser();
		mv.addObject("user", user);// 获取用户信息
		mv.addObject("shelvesNum", wareHouseBuildService.listWareHouseBuildShelvesNum());//密集架数量列表
		mv.addObject("pageInfo", wareHouseBuildService.havingPageInfoAboutWareHouse());//库房数
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());// 未读信息数
		mv.setViewName("warehouse/wareHouse");// 库房管理展示页面
		return mv;
	}

	/**
	 * 初始化数据
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/wareHouseList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui wareHouseList(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) {
		System.out.println(wareHouseBuildService.wareHouseInfoListShow(limit, page));
		return wareHouseBuildService.wareHouseInfoListShow(limit, page);
	}

	/**
	 * 编辑库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	@RequestMapping(value = "/updateOneWareHouseInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer updateOneWareHouseInfo(WareHouseBuild wareHouseBuild) {
		Integer result = null;
		if(wareHouseBuildService.updateOneWareHouseInfo(wareHouseBuild)>0) {
			result = 3;
		}else {
			result=4;
		}
		
		return result;
	}

	/**
	 * 根据库房主键查询库房信息
	 * 
	 * @param wareHouseBuildId
	 * @return
	 */
	@RequestMapping(value = "/queryWareHouseInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public WareHouseBuild queryWareHouseInfo(String wareHouseBuildId) {
		WareHouseBuild wareHouseBuild = wareHouseBuildService.queryWareHouseInfo(wareHouseBuildId);
		return wareHouseBuild;
	}

	/**
	 * 删除库房信息
	 * @param wareHouseBuildId
	 * @return
	 */
	@RequestMapping(value = "/deleteOneWareHouseInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Boolean deleteOneWareHouseInfo(@RequestParam("wareHouseBuildId") String wareHouseBuildId) {
		Boolean result = null;
		int countWareHouseUnderHaveInfo = wareHouseBuildService.countWareHouseUnderHaveInfo(wareHouseBuildId);
		if (countWareHouseUnderHaveInfo == 0) {
			result = wareHouseBuildService.deleteOneWareHouseInfo(wareHouseBuildId);
		} else {
			return false;
		}
		return result;
	}

	/**
	 * 根据密集架数量获取对应的组数(查询)
	 * @param wareHouseBuildShelvesNum
	 * @return
	 */
	@RequestMapping(value = "/listGroupsNum", method = RequestMethod.GET)
	@ResponseBody
	public List<WareHouseBuild> listGroupsNum(String wareHouseBuildShelvesNum) {
		return wareHouseBuildService.listWareHouseBuildGroupsNum(wareHouseBuildShelvesNum);
	}
	
	/**
	 * 根据密集架和组数筛选库房信息
	 * @param wareHouseBuildShelvesNum
	 * @param wareHouseBuildGroupsNum
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/moreConditionFiltrate",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui moreConditionFiltrate(@RequestParam("wareHouseBuildShelvesNum") String wareHouseBuildShelvesNum,
			@RequestParam("wareHouseBuildGroupsNum") String wareHouseBuildGroupsNum, @RequestParam("limit") Integer limit,
			@RequestParam("page") Integer page) {
		return wareHouseBuildService.selectWareHouseInfoByShelvesNumAndGroupsNum(wareHouseBuildShelvesNum,wareHouseBuildGroupsNum, limit, page);
	}

	/**
	 * 根据密集架数量和组数获取库房数
	 * @param wareHouseBuildShelvesNum
	 * @param wareHouseBuildGroupsNum
	 * @return
	 */
	@RequestMapping(value="/reloadPageInfo",method = RequestMethod.GET)
	@ResponseBody
	public WareHousePageInfo reloadPageInfo(@RequestParam("wareHouseBuildShelvesNum") String wareHouseBuildShelvesNum,
			@RequestParam("wareHouseBuildGroupsNum") String wareHouseBuildGroupsNum){
		return wareHouseBuildService.havingPageInfoByShelvesNumAndGroupsNum(wareHouseBuildShelvesNum, wareHouseBuildGroupsNum);
		}
	
	/**
	 * 关键词查询库房信息
	 * @param condition
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/selectWareHouseInfoByConditions",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui selectWareHouseInfoByConditions(@RequestParam("condition") String condition,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) {
		return wareHouseBuildService.selectWareHouseInfoByConditions(condition, limit, page);
	}

	/**
	 * 统计关键词查询后的库房数
	 * @param condition
	 * @return
	 */
	@RequestMapping("/reloadPageInfos")
	@ResponseBody
	public WareHousePageInfo reloadPageInfos(@RequestParam("condition") String condition) {
		return wareHouseBuildService.havingPageInfoByConditions(condition);
	}

	// +++++++++++++++++++++++++++++++++++++++++以下是新建库房++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 跳转到库房管理_新建库房页面
	 * @return
	 */
	@RequestMapping(value = "/newWareHouse", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView newWareHouse() {
		ModelAndView mv = new ModelAndView();
		logger.info("库房管理_库房建设");
		user = HavingUserInfor.havingUser();
		mv.addObject("user", user);// 获取用户信息
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());// 未读信息数
		mv.setViewName("warehouse/newWareHouse");// 库房管理展示页面
		return mv;

	}
	
	/**
	 * 添加库房信息
	 * @param wareHouseBuild
	 * @return
	 */
	@RequestMapping(value = "/addWareHouseInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Integer addWareHouseInfo(WareHouseBuild wareHouseBuild) {
		Integer result = null;
		int isExitWareHouseBuildNumber = wareHouseBuildService.isExitWareHouseBuildNumber(wareHouseBuild);
		int isExitWareHouseBuildName = wareHouseBuildService.isExitWareHouseBuildName(wareHouseBuild);
		if (isExitWareHouseBuildNumber > 0) {
			System.out.println("库房号已存在");
			result = 1;
		} else if (isExitWareHouseBuildName > 0) {
			System.out.println("库房名称已存在");
			result = 2;
		} else if (wareHouseBuild.getWareHouseBuildId() != null && wareHouseBuild.getWareHouseBuildId() != "") {
			wareHouseBuildService.updateOneWareHouseInfo(wareHouseBuild);
			result = 3;
		} else {
			wareHouseBuildService.addWareHouseInfo(wareHouseBuild);
			result = 4;
		}
		return result;
	}

}
