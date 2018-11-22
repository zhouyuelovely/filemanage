package filemanage.recorded.controller;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.recorded.service.RecordedService;
import filemanage.recorded.vo.BoxAddHelp;
import filemanage.recorded.vo.GdFileArray;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.recorded.vo.TableContentInfor;
import filemanage.utils.layui.Layui;
import net.sf.json.JSONObject;

/**
 * @author meng
 *档案著录
 */
@Controller
@RequestMapping("/recordedContent")
public class RecordedContentController {
	private Logger logger=Logger.getLogger(RecordedContentController.class);//日志记录
	@Autowired
	private RecordedService recordedService;//档案著录service
	
	/**
	 * 跳转到档案著录页面
	 * @return
	 */
	@RequestMapping(value="/goCatalog",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goCatalog() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("qzNumber", recordedService.findQuanzongNumber());//获取全宗号
		modelAndView.addObject("qzName", recordedService.findQuanzongName());//获取全宗名
		modelAndView.addObject("pc",recordedService.findPcId());//获取一级分类
		modelAndView.addObject("sc", recordedService.findScId());//获取二级分类
		modelAndView.addObject("rpn",recordedService.findRetentionperiodName());//获取保管期限
		modelAndView.addObject("bp", recordedService.findBoxpropertyPag());//获取盒子属性
		modelAndView.setViewName("/recorded/catalog");
		return modelAndView;
	}
	/**
	 * 历史数据的导入
	 * @param zipFile 历史数据压缩文件
	 * @param chunk 当前片数
	 * @param chunks 总片数
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value="/uploadHistory",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Boolean uploadHistory(@RequestParam("file")MultipartFile zipFile,
			Integer chunk,
			Integer chunks,
			HttpServletRequest request) {
		String path="D:/file/history";
		System.out.println(zipFile+":"+chunk+":"+chunks+":"+path);
		return recordedService.addHistoryTaitan(zipFile, chunk, chunks, path);
	}
	/**
	 * 上传归档文件目录
	 * @param file 文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/uploadFileTable",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject uploadArchivingFileTable(MultipartFile file,HttpServletRequest request) {
		String pathname=null;
		String path="D:/file/archivingFileList";
		if(file!=null) {//文件存在
			String name=file.getOriginalFilename();//获取文件名称
			File dir=new File(path,name);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			try {
				file.transferTo(dir);
				pathname=path+"/"+name;
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		pathname=pathname.replace("D:/file", "/resource");
		String json="{'name':'"+pathname+"'}";
		return JSONObject.fromObject(json);
	}
	/**
	 * 获取表格中的盒子信息
	 * @param file 归档文件目录地址
	 * @return
	 */
	@RequestMapping(value="/tableContentInfor",method=RequestMethod.POST)
	public @ResponseBody TableContentInfor havingTableContentInfor(String file) {
		return recordedService.havingTableContentInfor(file);
	}
	/**
	 * 上传备考表
	 * @param file 上传的文件
	 * @param preparationFormHelp 内容
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/havingPerpartionForm",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject havingPerpartionForm(MultipartFile file) {
		String json=null;
		String result=recordedService.saveBoxInfor(file);
		if(result!="") {
			json="{'result':'"+result+"'}";
		}else {
			json="{'result':''}";
		}
		return JSONObject.fromObject(json);
	}
	/**
	 * 获取盒子中文件信息
	 * @param boxId 盒子主键
	 * @return
	 */
	@RequestMapping(value="/havingFile",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingFile(@RequestParam("boxId")String boxId,
			@RequestParam("limit")Integer limit,
			@RequestParam("page")Integer page) {
		return recordedService.havingFileByBoxId(boxId, limit, page);
	}
	/**
	 * 多文件上传
	 * @param files 文件集合
	 * @return
	 */
	@RequestMapping(value="/moreUpload",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject moreUpload(@RequestParam("file")MultipartFile file,@RequestParam("boxId")String boxId) {
		String json="{'result':'"+recordedService.saveFileInfor(file, boxId)+"'}";
		return JSONObject.fromObject(json);
	}
	/**
	 * 单文件上传
	 * @param file 文件
	 * @param boxId 盒子主键
	 * @return
	 */
	@RequestMapping(value="/oneUpload",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject oneUpload(@RequestParam("file")MultipartFile file,@RequestParam("boxId")String boxId) {
		String json="{'result':'"+recordedService.saveFileInfor(file, boxId)+"'}";
		return JSONObject.fromObject(json);
	}
	
	/**
	 * 更新表格中的文件信息
	 * @param fileId 文件主键
	 * @param content 字段
	 * @param value 内容
	 * @return
	 */
	@RequestMapping(value="/updateFileInfor",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Boolean updateFileInfor(
			@RequestParam("fileId")String fileId,
			@RequestParam("content")String content,
			@RequestParam("value")String value) {
		return recordedService.updateFileInfor(fileId, content, value);
	}
	/**
	 * 查看文件附件
	 * @param archiveFileId
	 * @return
	 */
	@RequestMapping(value="/havingFileAtta",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<String> havingFileAtta(String archiveFileId){
		return recordedService.havingFileAtta(archiveFileId);
	}
	/**
	 * 文件状态选择
	 * @param boxId 盒子主键
	 * @param start 状态
	 * @param limit 大小
	 * @param page 页数
	 * @return
	 */
	@RequestMapping(value="/havingFileStart",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Layui havingFileStart(@RequestParam("boxId")String boxId,
			@RequestParam("start")String start,
			@RequestParam("limit")Integer limit,
			@RequestParam("page")Integer page) {
		return recordedService.findArchiveFileByBoxIdAndStart(boxId, start, limit, page);
	}
	/**
	 * 保存文件
	 * @param boxId 盒子主键
	 * @return
	 */
	@RequestMapping(value="/updataBoxStart",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody JSONObject updataBoxStart(PreparationFormHelp preparationFormHelp,HttpServletRequest request) {
		String srcImage=request.getSession().getServletContext().getRealPath("shuiYin")+"/box.jpg";
		System.err.println("preparationFormHelp:"+preparationFormHelp);
		String result= recordedService.updataBoxStart(preparationFormHelp,srcImage);
		String json="{'result':'"+result+"'}";
		return JSONObject.fromObject(json);
	};
	
	/**
	 * 新增需求手动著录（创建盒子文件信息）
	 */
	@RequestMapping(value="/manualDescription",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSONObject manualDescription(HttpServletRequest request,HttpServletResponse response) {
		return JSONObject.fromObject(recordedService.saveBoxs(request));
	};
	
	
}
