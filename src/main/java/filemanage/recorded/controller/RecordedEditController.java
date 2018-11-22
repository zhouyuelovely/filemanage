package filemanage.recorded.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import filemanage.recorded.service.RecordedService;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.recorded.vo.SaveBoxInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/recodedEdit")
public class RecordedEditController {
	private Logger loggin=Logger.getLogger(RecordedEditController.class);
	@Autowired
	private RecordedService recordedService;//档案著录service
	/**
	 * 跳转补充盒内文件
	 * @param boxId
	 * @return
	 */
	@RequestMapping(value="/goSupplement",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goSupplement(@RequestParam("boxId")String boxId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("qzNumber", recordedService.findQuanzongNumber());//获取全宗号
		modelAndView.addObject("qzName", recordedService.findQuanzongName());//获取全宗名
		modelAndView.addObject("pc",recordedService.findPcId());//获取一级分类
		modelAndView.addObject("sc", recordedService.findScId());//获取二级分类
		modelAndView.addObject("rpn",recordedService.findRetentionperiodName());//获取保管期限
		modelAndView.addObject("bp", recordedService.findBoxpropertyPag());//获取盒子属性
		AmCoBox box= recordedService.findAmCoBoxByBoxId(boxId);
		modelAndView.addObject("box", box);//获取盒子信息
		modelAndView.addObject("bf", recordedService.havingBoxForm(boxId));//获取备考表地址
		modelAndView.setViewName("recorded/supplement");
		return modelAndView;
	}
	/**
	 * 上传备考表
	 * @param file 文件
	 * @param boxId 盒子主键
	 * @return
	 */
	@RequestMapping(value="/havingPerpartionForm",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject havingPerpartionForm(MultipartFile file,@RequestParam("boxId")String boxId) {
		String json=null;
		String result=recordedService.updateAmCoBoxattachment(file, boxId);
		json="{'result':'"+result+"'}";
		return JSONObject.fromObject(json);
	}
	/**
	 * 更新盒子信息
	 * @param preparationFormHelp 盒子信息
	 * @param request 
	 * @return
	 */
	@RequestMapping(value="/saveBoxInfor",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject SaveBoxInfor(PreparationFormHelp preparationFormHelp,HttpServletRequest request) {
		String srcImage=request.getSession().getServletContext().getRealPath("shuiYin")+"/box.jpg";
		String json=null;
		json="{'result':'"+recordedService.saveBox(preparationFormHelp, srcImage)+"'}";
		return JSONObject.fromObject(json);
	}
	
}
