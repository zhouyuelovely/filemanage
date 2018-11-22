package filemanage.digitalarchives.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.digitalarchives.pojo.Advice;
import filemanage.digitalarchives.service.AdviceService;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.JSON;
import filemanage.utils.exchangeCenter.exchangeCenterBRInterface;
import filemanage.utils.exchangeCenter.exchangeCenterData;
import filemanage.utils.layui.Layui;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 交流中心
 * @author 陈一达
 * controller 
 */
@Controller
@RequestMapping("/AdviceMapperController")
public class AdviceMapperController {
	
	//建议咨询Service
	@Autowired
	private AdviceService aService;

	@RequestMapping("/modelAndView")
	@ResponseBody
	public ModelAndView modelAndView(HttpServletRequest request,HttpServletResponse response) {
		
		String userType = "2";
		/*String userType = HavingUserInfor.havingUser().getUserType();*/
		String userId = HavingUserInfor.havingUser().getUserId();
		request.getSession().setAttribute("userType",userType);
		request.getSession().setAttribute("userId", userId);/*userId*/
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/digitalarchives/exchange");
		return mv;
		
	}
	
	/**
	 * 前台页面数据渲染
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/adviceQuery")
	@ResponseBody
	public Layui adviceQuery(HttpServletRequest request,HttpServletResponse response) {
		Advice advices = new Advice();
		String keywords = request.getParameter("keywords");
		//可根据关键词查询数据
		advices.setAdviceType(keywords);
		List<Advice> lists = aService.adviceQuery(advices);
		int count = aService.adviceCount(advices);
		return Layui.data(count, lists);
	}
	
	/**
	 * 咨询人/回复人提交
	 * @return
	 */
	@RequestMapping("/adviceReplyCommit")
	@ResponseBody
	public JSONObject adviceReplyCommit(HttpServletRequest request,HttpServletResponse response,
				@RequestBody exchangeCenterData exchangeCenter) {
		System.out.println(exchangeCenter);
		exchangeCenterBRInterface exchangecenterbrinterface = new exchangeCenterBRInterface();
		JSONObject array = JSONObject.fromObject(exchangecenterbrinterface.adviceReplyInsert(request, exchangeCenter, aService));
		return array;
		
	}
	public static void main(String[] args) throws ParseException {
		JSONObject array = JSONObject.fromObject("{msg:'咨询提交成功，请等待回复！'}");
		System.out.println(array.toString());
		
	}
}
