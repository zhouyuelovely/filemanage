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

import filemanage.systemmanage.pojo.AmCoBoxProperty;
import filemanage.systemmanage.service.FileCustomizationFileBoxService;
import filemanage.utils.layui.Layui;


/**
 * 档案自定义		>>		档案盒
 * @author 陈一达
 *
 */
@Controller
@RequestMapping("/filecustomizationfileboxcontroller")
public class FileCustomizationFileBoxController {
	
	@Autowired
	private FileCustomizationFileBoxService fs;				//档案盒service接口
	
	/**
	 * 档案盒页面展示
	 * @return
	 */
	@RequestMapping(value = "/modelAndView",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView	modelAndView() {
		ModelAndView mv = new ModelAndView();
		/*mv.addObject(fs.queryBoxProperties());*/
		mv.setViewName("/classfication/classficationManage");
		return mv;
	}
	
	/**
	 * 档案自定义		>>		档案盒（页面展示）
	 * @return
	 */
	@RequestMapping(value = "/queryBoxProperties",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Layui queryBoxProperties(int page,int limit) {
		List<AmCoBoxProperty> queryList = new ArrayList<>();
		 int before = limit * (page-1);  
         int after = page * limit; 
		AmCoBoxProperty amcoboxpropert = new AmCoBoxProperty();
		String boxpropertythickness = String.valueOf((before+after));
		String boxpropertypag = String.valueOf(before);
		amcoboxpropert.setBoxpropertythickness(boxpropertythickness);
		amcoboxpropert.setBoxpropertypag(boxpropertypag);
		queryList = fs.queryBoxProperties(amcoboxpropert);
		Integer queryCount = fs.queryCountBoxProperties();
		System.out.println(queryCount);
		return Layui.data(queryCount, queryList);
	}
	
	
	/**
	 * 档案自定义		>>		档案盒（编辑功能）
	 * @return
	 */
	@RequestMapping(value = "/updateBoxProperties",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int updateBoxProperties(HttpServletRequest request,HttpServletResponse response,AmCoBoxProperty amcoboxproperty) {
		String boxpropertyid = request.getParameter("boxpropertyid");
		String boxpropertythickness = request.getParameter("boxpropertythickness");
		String boxpropertypag = request.getParameter("boxpropertypag");
		amcoboxproperty.setBoxpropertyid(boxpropertyid);
		amcoboxproperty.setBoxpropertypag(boxpropertypag);
		amcoboxproperty.setBoxpropertythickness(boxpropertythickness);
		return fs.updateBoxProperties(amcoboxproperty);
	}
	
	/**
	 * 档案自定义		>>		档案盒（删除）
	 * @return
	 */
	@RequestMapping(value = "/deleteBoxProperties",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int deleteBoxProperties(HttpServletRequest request,HttpServletResponse response,AmCoBoxProperty amcoboxproperty) {
		Integer msg = null;
		String boxpropertythickness = request.getParameter("boxpropertythickness");
		String boxpropertypag = request.getParameter("boxpropertypag");
		amcoboxproperty.setBoxpropertypag(boxpropertypag);
		amcoboxproperty.setBoxpropertythickness(boxpropertythickness);
		if(fs.countBoxPropertiesFileExist(amcoboxproperty)>0) {
			msg = 2;
		}else if(fs.countBoxPropertiesFileExist(amcoboxproperty)==0) {
			String boxpropertyid = request.getParameter("boxpropertyid");
			amcoboxproperty.setBoxpropertyid(boxpropertyid);
			msg = fs.deleteBoxProperties(amcoboxproperty);
		}
		return msg;
	}
	
	/**
	 * 档案自定义		>>		档案盒（添加）
	 * @return
	 */
	@RequestMapping(value = "/saveBoxProperties",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int saveBoxProperties(HttpServletRequest request,HttpServletResponse response,AmCoBoxProperty amcoboxproperty) {
		String boxpropertythickness = request.getParameter("boxpropertythickness");
		String boxpropertypag = request.getParameter("boxpropertypag");
		amcoboxproperty.setBoxpropertypag(boxpropertypag);
		amcoboxproperty.setBoxpropertythickness(boxpropertythickness);
		return fs.saveBoxProperties(amcoboxproperty);
	}
}
