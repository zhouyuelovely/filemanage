package filemanage.warningandediting.controller;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.danganmanage.controller.DanganmanageController;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.MessageNotification;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.layui.Layui;
import filemanage.warningandediting.pojo.BorrowingFile;
import filemanage.warningandediting.service.BorrowingFileService;

@Controller
@RequestMapping("borrowingFile")
public class BorrowingFileController {
	private User user;
	private Logger logger = Logger.getLogger(DanganmanageController.class);

	@Autowired
	private BorrowingFileService bs;
	@Autowired
	private MessageNotificationService ms;
	@Autowired
	private MessageNotificationService messageNotificationService;

	// 去重
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList(); // 创建新集合
		Iterator it = list.iterator(); // 根据传入的集合(旧集合)获取迭代器
		while (it.hasNext()) { // 遍历老集合
			Object obj = it.next(); // 记录每一个元素
			if (!newList.contains(obj)) { // 如果新集合中不包含旧集合中的元素
				newList.add(obj); // 将元素添加
			}
		}
		return newList;
	}

	@RequestMapping("/goGuiHuan")
	public ModelAndView goGuiHuan() throws Exception {
		logger.info("跳转到未归还档案页面");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView mv = new ModelAndView();
		user = HavingUserInfor.havingUser();
		List<BorrowingFile> list = bs.queryAllBorrowingFile();
		ArrayList bf = new ArrayList<>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// 当天的时间
				Date date1 = new Date();
				// 归还日期
				Date date2 = sdf.parse(list.get(i).getEndDate());
				if (date2 != null) {
					// 计算剩余天数
					long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
					if (days3 <= 30) {
						if (days3 <= 0) {
							// 获得预警天数
							String warningDays = 0 + "天";
							// 30天内开始预警
							bf.add(warningDays);
						} else {
							// 获得预警天数
							String warningDays = days3 + "天";
							// 30天内开始预警
							bf.add(warningDays);
						}
					}
				}
			}
			ArrayList newList = getSingle(bf);
			mv.addObject("warningDayList", newList);
		}
		mv.addObject("user", user);
		mv.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mv.addObject("total", bs.countBorrowingFile());
		mv.setViewName("/warningandediting/Unreturned_file");
		return mv;
	}

	/**
	 * 查询所有未归还档案
	 * 
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectAllBorrowingFile", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryAllBorrowingFile(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Integer before = limit * (page - 1);
		Integer after = page * limit;
		List<BorrowingFile> list = bs.queryBorrowingFile(before, after);
		List<BorrowingFile> bf = new ArrayList<BorrowingFile>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// 当天的时间
				Date date1 = new Date();
				// 归还日期
				Date date2 = sdf.parse(list.get(i).getEndDate());
				if (date2 != null) {
					// 计算剩余天数
					long days3 = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000) + 1;
					if (days3 <= 30) {
						if (days3 <= 0) {
							// 获得预警天数
							String warningDays = 0 + "天";
							// 30天内开始预警
							bf.add(new BorrowingFile(list.get(i).getArchivefileId(), list.get(i).getQzName(),
									list.get(i).getFileNumber(), list.get(i).getBoxNumber(),
									list.get(i).getRackNumber(), list.get(i).getStartDate(), list.get(i).getEndDate(),
									warningDays));
						} else {
							// 获得预警天数
							String warningDays = days3 + "天";
							// 30天内开始预警
							bf.add(new BorrowingFile(list.get(i).getArchivefileId(), list.get(i).getQzName(),
									list.get(i).getFileNumber(), list.get(i).getBoxNumber(),
									list.get(i).getRackNumber(), list.get(i).getStartDate(), list.get(i).getEndDate(),
									warningDays));
						}
					}
				}
			}
		}
		Integer count = bs.countBorrowingFile();
		return Layui.data(count, bf);
	}

	/**
	 * 根据预警天数查询信息
	 * 
	 * @param page
	 * @param limit
	 * @param surplusDays
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectByEndDate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryByEndDate(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit, String surplusDays) throws Exception {
		Integer before = limit * (page - 1);
		Integer after = page * limit;
		System.out.println(surplusDays);
		List<BorrowingFile> bf = new ArrayList<BorrowingFile>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<BorrowingFile> list = bs.queryBorrowingFile(before, after);
		System.out.println(list);
		if (surplusDays != null && surplusDays != "") {
			// 当天的时间
			Date date = new Date();
			// 根据预警天数计算到期日期
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			String regEx = "[^0-9]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(surplusDays);
			String time = m.replaceAll("").trim();
			if (Integer.parseInt(time) > 0) {
				c.add(Calendar.DATE, Integer.parseInt(time));
				String endDate = sdf.format(c.getTime());
				List<BorrowingFile> list2 = bs.queryByEndDate(before, after, endDate);
				for (int i = 0; i < list2.size(); i++) {
					bf.add(new BorrowingFile(list2.get(i).getArchivefileId(), list2.get(i).getQzName(),
							list2.get(i).getFileNumber(), list2.get(i).getBoxNumber(), list2.get(i).getRackNumber(),
							list2.get(i).getStartDate(), list2.get(i).getEndDate(), endDate));
				}
				Integer count = bs.countByEndDate(endDate);
				System.out.println(bf);
				System.out.println(count);
				return Layui.data(count, bf);
			} else if (Integer.parseInt(time) == 0) {
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						// 归还日期
						Date date2 = sdf.parse(list.get(i).getEndDate());
						if (date2 != null) {
							// 计算剩余天数
							long days3 = (date2.getTime() - date.getTime()) / (24 * 3600 * 1000) + 1;
							if (days3 <= 0) {
								// 获得预警天数
								String warningDays = 0 + "天";
								// 30天内开始预警
								bf.add(new BorrowingFile(list.get(i).getArchivefileId(), list.get(i).getQzName(),
										list.get(i).getFileNumber(), list.get(i).getBoxNumber(),
										list.get(i).getRackNumber(), list.get(i).getStartDate(),
										list.get(i).getEndDate(), warningDays));
							}
						}
					}
				}
				Integer count = bs.countByZeroDate();
				return Layui.data(count, bf);
			}
		}
		return null;
	}

	/**
	 * 催还
	 * 
	 * @param messageType
	 * @param messageContent
	 * @param messageCreator
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertMessage", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void addMessage(String messageType, String messageContent, String messageCreator) throws Exception {
		Integer add = ms.addMessageNotification(new MessageNotification("催还消息", "文件借阅即将到期，请归还", messageCreator));
		if (add > 0) {
			System.out.println("催还成功");
		}
	}
}
