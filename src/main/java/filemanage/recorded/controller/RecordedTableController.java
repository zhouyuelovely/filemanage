package filemanage.recorded.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.recorded.service.RecordedService;
import filemanage.recorded.vo.RecordedTableCountHelp;
import filemanage.recorded.vo.SelectQueryHelp;
import filemanage.utils.layui.Layui;

/**
 * @author meng
 *著录列表
 */
@Controller
@RequestMapping("/recordedTable")
public class RecordedTableController {
	private Logger logger=Logger.getLogger(RecordedTableController.class);
	@Autowired
	private RecordedService recordedService;//档案著录service
	private String quanzongId=null;//获取全宗主键
	/**
	 * 跳转到著录列表
	 * @return
	 */
	@RequestMapping(value="/goRecordedTable",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goRecordedTable() {
		ModelAndView modelAndView=new ModelAndView();
		quanzongId=HavingUserInfor.havingArchiveId();//获取全宗主键
		modelAndView.addObject("sp", recordedService.findSeelectPc(quanzongId));//全宗下盒子的一级分类
		List<String> list=recordedService.findSelectAnual(quanzongId);
		modelAndView.addObject("sa", list);//全宗下盒子的年度
		modelAndView.addObject("num", recordedService.havingFileAmCoBoxByQuanzongId(quanzongId, null, null));
		modelAndView.setViewName("/recorded/description");//转到页面
		return modelAndView;
	}
	/**
	 * 初始化 著录列表
	 * @param limit 每页大小
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping(value="/havingAmCoBoxByQuanzongId",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingAmCoBoxByQuanzongId(@RequestParam("limit")Integer limit, 
			@RequestParam("page")Integer page) {
		return recordedService.havingAmCoBoxByQuanzongId(quanzongId, limit, page);
	}
	/**
	 * 初始化数量
	 * @return
	 */
	@RequestMapping(value="/havingFileAmCoBoxByQuanzongId",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody RecordedTableCountHelp havingFileAmCoBoxByQuanzongId() {
		return recordedService.havingFileAmCoBoxByQuanzongId(quanzongId, null, null);
	}
	/**
	 * select 著录列表
	 * @param selectQueryHelp select 信息
	 * @param limit 数量 
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping(value="/havingAmCoBoxBySelect",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingAmCoBoxBySelect(SelectQueryHelp selectQueryHelp,
			@RequestParam("limit")Integer limit, 
			@RequestParam("page")Integer page) {
		return recordedService.havingAmCoBoxBySelect(quanzongId, selectQueryHelp, limit, page);
	}
	/**
	 * select 数量
	 * @param selectQueryHelp select信息
	 * @param limit 数量
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping(value="/havingFileAmCoBoxBySelect",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody RecordedTableCountHelp havingFileAmCoBoxBySelect(SelectQueryHelp selectQueryHelp) {
		return recordedService.havingFileAmCoBoxBySelect(quanzongId, selectQueryHelp);
	}
	/**
	 * 条件 著录列表
	 * @param condition 条件
	 * @param limit 数量
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping(value="/havingAmCoBoxByCondition",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingAmCoBoxByCondition(@RequestParam("condition")String condition,
			@RequestParam("limit")Integer limit, 
			@RequestParam("page")Integer page) {
		return recordedService.havingAmCoBoxByCondition(quanzongId, condition, limit, page);
	}
	/**
	 * 条件 数量
	 * @param condition 条 件
	 * @param limit 数量
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping(value="/havingFileAmCoBoxByCondition",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody RecordedTableCountHelp havingFileAmCoBoxByCondition(@RequestParam("condition")String condition) {
		return recordedService.havingFileAmCoBoxByCondition(quanzongId, condition);
	}
	/**
	 * 删除盒子信息
	 * @param boxId 盒子主键
	 * @return
	 */
	@RequestMapping(value="/deleteBox",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Boolean deleteBox(String boxId) {
		return recordedService.deleteBox(boxId);
	}
	/**
	 * 提交进馆
	 * @param str 盒子主键集合
	 * @return
	 */
	@RequestMapping(value="/updateBoxStart",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Boolean updateBoxStart(@RequestParam("str")String str) {
		return recordedService.updateBoxStart(str);
	};
}
