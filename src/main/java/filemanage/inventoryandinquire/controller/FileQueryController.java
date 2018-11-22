package filemanage.inventoryandinquire.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.vo.ArchiveFileHelpInfor;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.inventoryandinquire.service.CascadingService;
import filemanage.inventoryandinquire.service.FileQueryService;
import filemanage.inventoryandinquire.vo.BoxConditionVo;
import filemanage.inventoryandinquire.vo.FileConditionVo;
import filemanage.inventoryandinquire.vo.HistoryDataConditionVo;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.service.MessageNotificationService;
import filemanage.utils.GetUUIDName;
import filemanage.utils.layui.Layui;
import filemanage.utils.papersave.CustomFileUtil;
import filemanage.utils.papersave.ZipCompressorUtil;

@Controller
@RequestMapping("/fileQuery")
public class FileQueryController {
	private Logger log = LoggerFactory.getLogger(FileQueryController.class);
	 private User user;

	@Autowired
	private FileQueryService fileQueryService;

	@Autowired
	private MessageNotificationService messageNotificationService;

	@Autowired
	private CascadingService cascadingService;

	/**
	 * 跳转以盒查询页面(基础数据渲染)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goToFileQueryBoxList")
	public ModelAndView goToFileQueryBoxList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	    user = HavingUserInfor.havingUser();
		ModelAndView mView = new ModelAndView();
		mView.addObject("boxNum", fileQueryService.countBoxNum());// 统计盒子数量
		mView.addObject("boxFileCasesNumber", fileQueryService.countBoxFileCasesNumber());// 统计件数之和
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mView.addObject("retentionperiodName", fileQueryService.queryRetentionperiodName());
		mView.addObject("user", user);
		mView.addObject("pcList", cascadingService.getPrimaryClassList());
		mView.setViewName("/inventoryAndinquire/fileQuery");
		return mView;
	}

	/**
	 * 查询所有盒子信息(页面初始化数据)
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryBoxList(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page)
			throws Exception {
		return fileQueryService.queryBoxList(limit, page);
	}

	/**
	 * 按照条件查询盒子信息
	 * 
	 * @param boxConditionVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryBoxListByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryBoxListByCondition(BoxConditionVo boxConditionVo,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws Exception {
		return fileQueryService.queryBoxListByCondition(boxConditionVo, limit, page);
	}
	
	/**
	 * 条件查询下统计盒数和件数
	 * @param quanzongNumber
	 * @param quanzongName
	 * @param pcId
	 * @param scId
	 * @param boxanual
	 * @param retentionperiodId
	 * @param boxNumber
	 * @param storageRacknumber
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryConditionNum",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public HavingInforBox queryBoxByCondition(@RequestParam("quanzongNumber") String quanzongNumber,
			@RequestParam("quanzongName") String quanzongName,@RequestParam("pcId") String  pcId,
			@RequestParam("scId") String scId,@RequestParam("boxanual") String boxanual,
			@RequestParam("retentionperiodId") String  retentionperiodId,@RequestParam("boxNumber") String boxNumber,
			@RequestParam("storageRacknumber") String storageRacknumber,@RequestParam("condition") String condition) throws Exception {
		BoxConditionVo boxConditionVo=new BoxConditionVo();
		boxConditionVo.setQuanzongNumber(quanzongNumber);
		boxConditionVo.setQuanzongName(quanzongName);
		boxConditionVo.setPcId(pcId);
		boxConditionVo.setScId(scId);
		boxConditionVo.setBoxanual(boxanual);
		boxConditionVo.setRetentionperiodId(retentionperiodId);
		boxConditionVo.setBoxNumber(boxNumber);
		boxConditionVo.setStorageRacknumber(storageRacknumber);
		boxConditionVo.setCondition(condition);
		return fileQueryService.queryBoxByCondition(boxConditionVo);
	}
	

	/**
	 * 渲染件的基础数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "basicDataRendering", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody JSONObject BasicDataRendering() throws Exception {
		JSONObject resObj = new JSONObject();
		resObj.put("fileNumber", fileQueryService.countFile());// 统计文件件数
		resObj.put("filePages", fileQueryService.countArchivefilePages());// 统计页数之和
		resObj.put("retention", fileQueryService.queryRetentionperiodName());// 保管期限名称集合
		return resObj;
	}

	/**
	 * 查询所有件信息
	 * 
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryFileList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryFileList(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page)
			throws Exception {
		return fileQueryService.queryFileList(limit, page);
	}

	/**
	 * 按条件查询所有件信息
	 * 
	 * @param fileConditionVo
	 * @param limit
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryFileListByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Layui queryFileListByCondition(FileConditionVo fileConditionVo,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws Exception {
		return fileQueryService.queryFileListByCondition(fileConditionVo, limit, page);
	}
	
	/**
	 * 按条件查询统计件数和页数
	 * @param quanzongNumber
	 * @param quanzongName
	 * @param pcId
	 * @param scId
	 * @param archiveFileAnual
	 * @param retentionperiodid
	 * @param archiveFileFileNumber
	 * @param boxNumber
	 * @param archiveFileCreatetime
	 * @param storageRacknumber
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryFileConditionNum",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArchiveFileHelpInfor queryFileByboxCondition(@RequestParam("quanzongNumber") String quanzongNumber,
			@RequestParam("quanzongName") String quanzongName,@RequestParam("pcId") String pcId,
			@RequestParam("scId") String scId,@RequestParam("archiveFileAnual") String archiveFileAnual,
			@RequestParam("retentionperiodid") String retentionperiodid,
			@RequestParam("archiveFileFileNumber") String archiveFileFileNumber,
			@RequestParam("boxnumber") String boxnumber,@RequestParam("archiveFileCreatetime") String archiveFileCreatetime,
			@RequestParam("storageRacknumber") String storageRacknumber,@RequestParam("condition") String condition) throws Exception{
		FileConditionVo fileConditionVo=new FileConditionVo();
		fileConditionVo.setQuanzongNumber(quanzongNumber);
		fileConditionVo.setQuanzongName(quanzongName);
		fileConditionVo.setPcId(pcId);
		fileConditionVo.setScId(scId);
		fileConditionVo.setArchiveFileAnual(archiveFileAnual);
		fileConditionVo.setRetentionperiodid(retentionperiodid);
		fileConditionVo.setArchiveFileFileNumber(archiveFileFileNumber);
		fileConditionVo.setBoxnumber(boxnumber);
		fileConditionVo.setArchiveFileCreatetime(archiveFileCreatetime);
		fileConditionVo.setStorageRacknumber(storageRacknumber);
		fileConditionVo.setCondition(condition);
		return fileQueryService.queryFileByboxCondition(fileConditionVo);
	}

	/**
	 * 跳转档案查询的历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goToHistoryData", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goToHistoryData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mView = new ModelAndView();
		mView.addObject("historyDataNumber", fileQueryService.countHistoryDataNumber());// 统计历史数据数量
		mView.addObject("historyDataPages", fileQueryService.countHistoryDataPages());// 统计历史数据页数之和
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mView.addObject("retentionperiodName", fileQueryService.queryRetentionperiodName());
		mView.setViewName("/inventoryAndinquire/historicalDataQuery");
		return mView;
	}

	/**
	 * 根据盒子主键获取归档目录路径集合
	 * 
	 * @param request
	 * @param response
	 * @param boxIdList
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportDirectory", method = { RequestMethod.POST, RequestMethod.GET })
	public void exportDirectory(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("boxIdList") List<String> boxIdList) throws Exception {
		// 获取文件根目录，不同框架获取的方式不一样，可自由切换
		String basePath = request.getSession().getServletContext().getRealPath("resourceZip");

		// 获取文件名称（包括文件格式）
		String fileName = GetUUIDName.getUUID() + ".zip";
		// 组合成完整的文件路径
		String targetPath = basePath + File.separator + fileName;
		try {
			List<String> list = fileQueryService.findFilePathList(boxIdList);
			log.info("导出目录的路径集合:" + list);
			try {
				ZipCompressorUtil zc = new ZipCompressorUtil(targetPath);
				zc.compress(list);
			} catch (Exception ex2) {
				throw ex2;
			}
			try {
				File temp = new File(targetPath);
				CustomFileUtil.downloadFile(temp, response, true);
			} catch (Exception ex3) {
				throw ex3;
			}
		} catch (Exception ex1) {
			throw ex1;
		}
	}

	/**
	 * 在线打印归档文件目录
	 * 
	 * @param boxId
	 * @return
	 */
	@RequestMapping(value = "/printBoxattachmentFile", method = RequestMethod.POST)
	public @ResponseBody net.sf.json.JSONObject printFile(@RequestParam("boxId") String boxId) throws Exception {
		// 根据盒子主键获取归档文件目录地址
		AmCoBoxattachment amCoBoxattachment = fileQueryService.queryBoxattachmentFilePath(boxId);
		String boxattachmentFilePath = amCoBoxattachment.getBoxattachmentFile().replace("D:/file", "/resource");
		System.err.println(boxattachmentFilePath);
		boxattachmentFilePath="{'data':'"+boxattachmentFilePath+"'}";
		return net.sf.json.JSONObject.fromObject(boxattachmentFilePath);
	}

	/**
	 * 跳转历史数据页面(历史数据基础数据)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goToHistoryDataList", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goToHistoryDataList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = HavingUserInfor.havingUser();
		ModelAndView mView = new ModelAndView();
		mView.addObject("historyData", fileQueryService.countHistoryData());// 统计历史数据件数之和
		mView.addObject("historyDataPageSum", fileQueryService.countHistoryDataPageSum());// 统计历史数据页数之和
		mView.addObject("messageNum", messageNotificationService.countMessageNotificationStart());
		mView.addObject("retentionperiodName", fileQueryService.queryRetentionperiodName());
		mView.addObject("pcList", cascadingService.getPrimaryClassList());
		mView.setViewName("/inventoryAndinquire/historicalDataQuery");
		mView.addObject("user", user);
		return mView;
	}

	/**
	 * 历史数据查询
	 * 
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryHistoryData", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryHistoryData(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page)
			throws Exception {
		return fileQueryService.queryHistoryData(page, limit);
	}

	/**
	 * 按条件查询历史数据查询
	 * 
	 * @param historyDataConditionVo
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryHistoryDataByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Layui queryHistoryDataByCondition(HistoryDataConditionVo historyDataConditionVo,
			@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws Exception {
		System.out.println("historyDataConditionVo="+historyDataConditionVo);
		return fileQueryService.queryHistoryDataByCondition(historyDataConditionVo, page, limit);
	}

}
