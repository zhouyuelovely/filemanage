package filemanage.systemmanage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmCoBoxProperty;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.service.FileCustomizationTermOfCustodyService;
import filemanage.utils.layui.Layui;

@Controller
@RequestMapping("FileCustomizationTermOfCustodyController")
public class FileCustomizationTermOfCustodyController {

	@Autowired
	private FileCustomizationTermOfCustodyService fctcs;
	
	/**
	 * 保管期限页面展示
	 * @return
	 */
	@RequestMapping(value = "/modelAndView",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView	modelAndView() {
		ModelAndView mv = new ModelAndView();
		/*mv.addObject(fs.queryBoxProperties());*/
		mv.setViewName("/");
		return mv;
	}
	
	/**
	 * 档案自定义		>>		保管期限（页面展示）
	 * @return
	 */
	@RequestMapping(value = "/queryTermOfCustody",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryTermOfCustody(int page,int limit) {
		List<AmMaSmRetentionperiod> asrs = new ArrayList<>();
		int before = limit * (page-1);  
        int after = page * limit; 
		String retentionperiodname = String.valueOf((before+after));
		String retentionperiodcreator = String.valueOf(before);
		AmMaSmRetentionperiod reten = new AmMaSmRetentionperiod();
		reten.setRetentionperiodname(retentionperiodname);
		reten.setRetentionperiodcreator(retentionperiodcreator);
		asrs = fctcs.queryTermOfCustody(reten);
		Integer countAsr = fctcs.countQueryTermOfCustody();
		return Layui.data(countAsr, asrs);
	}
	
	/**
	 * 档案自定义		>>		添加保管期限  
	 * @return
	 */
	@RequestMapping(value = "/saveTermOfCustody",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int saveTermOfCustody(HttpServletRequest request,HttpServletResponse response,AmMaSmRetentionperiod reten) {
		String retentionperiodcode = request.getParameter("retentionperiodcode");
		String retentionperiodname = request.getParameter("retentionperiodname");
		reten.setRetentionperiodcode(retentionperiodcode);
		reten.setRetentionperiodname(retentionperiodname);
		reten.setRetentionperiodcreator(HavingUserInfor.havingUser().getUserName());
		return fctcs.saveTermOfCustody(reten);
	}
	
	
	/**
	 * 档案自定义		>>		删除保管期限  
	 * @return
	 */
	@RequestMapping(value = "/deleteTermOfCustody",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int deleteTermOfCustody(HttpServletRequest request,HttpServletResponse response,AmMaSmRetentionperiod reten) {
		Integer msg = null;
		String retentionperiodid = request.getParameter("retentionperiodid");
		reten.setRetentionperiodid(retentionperiodid);
		if(fctcs.countTermOfCustody(reten)>0) {
			msg = 2;
		}else if(fctcs.countTermOfCustody(reten)==0) {
			if(fctcs.termOfCustodyType(reten)== 1) {
				msg = fctcs.deleteTermOfCustody(reten);
			}else {
				msg = 3;
			}
		}
		return msg;
	}
}
