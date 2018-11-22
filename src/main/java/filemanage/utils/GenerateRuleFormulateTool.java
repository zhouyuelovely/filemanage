package filemanage.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.itextpdf.text.DocumentException;
import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.FilePackingBoxService;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.collectandorganize.vo.BoxSideBoxRidge;
import filemanage.collectandorganize.vo.CartoningFunctionDataVoForm;
import filemanage.collectandorganize.vo.ExcelFrom;
import filemanage.collectandorganize.vo.GenerateRuleFormulateVo;
import filemanage.collectandorganize.vo.Shuiyin;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.AmCoBoxProperty;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.SecondryClassFication;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.FileCustomizationFileBoxService;
import filemanage.systemmanage.service.FileCustomizationTermOfCustodyService;
import filemanage.systemmanage.service.UserService;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;
import filemanage.utils.paperbuild.CreatePdfUtil;
import filemanage.utils.shuiYinTool.SealTools;

/**
 * 生成规则制定
 * @author 陈一达
 *
 */
public class GenerateRuleFormulateTool {
	
	/**
	 * 档号生成规则制定 
	 * @param listGRF
	 * @return
	 */
	public List<String> referenceGenerate(ArrayList<ArrayList<GenerateRuleFormulateVo>> listGRF) {
		//档号集合
		List<String> archivefilefilenumbers = new ArrayList<>();
		DecimalFormat nf = new DecimalFormat("0000");
		for (int i = 0; i < listGRF.size(); i++) {
			for (int j = 0; j < listGRF.get(i).size(); j++) {
				listGRF.get(i).get(j).setIndex(nf.format(j+1));
				//生成档号
				String archivefilefilenumber = listGRF.get(i).get(j).getQuanzongnumber()+"-"+
											   listGRF.get(i).get(j).getPccode()+"·"+
											   listGRF.get(i).get(j).getArchivefileanual()+"-"+
											   listGRF.get(i).get(j).getRetentionperiodcode()+"-"+
											   listGRF.get(i).get(j).getSccode()+"-"+
											   listGRF.get(i).get(j).getIndex(); 
				archivefilefilenumbers.add(archivefilefilenumber);
			}
		}
		return archivefilefilenumbers;
	}
	
	/**
	 * 盒子编号生成规则	全宗号-年度-保管期限代码-盒号
	 * @param listGRF
	 * @return
	 */
	public String boxNumberGenerate(GenerateRuleFormulateVo generateruleformulatevo){
		//盒编号集合
		String boxsericalnumber = generateruleformulatevo.getQuanzongnumber()+"-"+
								  generateruleformulatevo.getArchivefileanual()+"-"+
								  generateruleformulatevo.getRetentionperiodcode()+"-"+
								  generateruleformulatevo.getBoxnumber();
		return boxsericalnumber;
	}
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)
	 * @param map
	 * @return
	 */
	public Layui filePackingBoxALLQuery(Map<String, Object> map,FilePackingBoxService fpbs,String archivefilefilenumber,String secondaryclassificationid,HttpServletRequest request) {
		//生成规则辅助类
		GenerateRuleFormulateVo grf = new GenerateRuleFormulateVo();
		//辅助类集合中的集合
		ArrayList<ArrayList<GenerateRuleFormulateVo>> listLists = new ArrayList<ArrayList<GenerateRuleFormulateVo>>();
		//辅助类集合
		List<GenerateRuleFormulateVo> list = new ArrayList<>();
		//文档类
		AmCoArchivefile Archivefile = new AmCoArchivefile();
		
		List<AmCoArchivefile> filePackingBoxALLQueryList = fpbs.filePackingBoxALLQuery(map);
		int filePackingBoxALLQueryCount = fpbs.filePackingBoxALLQueryCount(map);
		if(archivefilefilenumber == null || archivefilefilenumber == "") {
			for (int i = 0; i < filePackingBoxALLQueryList.size(); i++) {
				grf.setQuanzongnumber(fpbs.queryQuanzongNumber(filePackingBoxALLQueryList.get(i).getQuanzongid()));
				grf.setPccode(fpbs.queryPCCode(filePackingBoxALLQueryList.get(i).getPrimaryclassificationid()));
				grf.setArchivefileanual(filePackingBoxALLQueryList.get(i).getArchivefileanual());
				grf.setRetentionperiodcode(fpbs.queryRetentionperiodCode(filePackingBoxALLQueryList.get(i).getRetentionperiodid()));
				grf.setSccode(fpbs.querySCCode(secondaryclassificationid));
				list.add(grf);
			}
		}
		//第一次拿到的无档号的数据
		listLists.add((ArrayList<GenerateRuleFormulateVo>) list);
		//现获取档号的生成集合
		List<?> referenceList = referenceGenerate(listLists);
		List<AmCoArchivefile> newFilePackingBoxALLQueryList = new ArrayList<>();
		for (int i = 0; i < filePackingBoxALLQueryList.size(); i++) {
			if(filePackingBoxALLQueryList.get(i).getArchivefilefilenumber() == null || filePackingBoxALLQueryList.get(i).getArchivefilefilenumber() == "") {
				for (int j = i; j < referenceList.size(); j++) {
					Archivefile.setArchivefileid(filePackingBoxALLQueryList.get(j).getArchivefileid());
					Archivefile.setArchivefilefilenumber(referenceGenerate(listLists).get(j));
					fpbs.updateFileNumber(Archivefile);
					newFilePackingBoxALLQueryList = fpbs.filePackingBoxALLQuery(map);
				}
			}else {
				newFilePackingBoxALLQueryList = fpbs.filePackingBoxALLQuery(map);
			}
		}
		return Layui.data(filePackingBoxALLQueryCount, newFilePackingBoxALLQueryList);
	}
	
	/**
	 * 根据盒主键查询盒的信息
	 * @param boxpropertyid
	 * @param request
	 * @return
	 */
	public List<AmCoBoxProperty> boxPrimaryKeyQuery(String boxpropertyid,FileCustomizationFileBoxService fcfbs,HttpServletRequest request){
		AmCoBoxProperty amcoboxpropert = new AmCoBoxProperty();
		amcoboxpropert.setBoxpropertyid(boxpropertyid);
		List<AmCoBoxProperty> boxpropertyidList = fcfbs.queryBoxProperties(amcoboxpropert);
		return boxpropertyidList;
	}
	
	/**
	 * 给文件添加盒子主键操作
	 * @param listDatas
	 * @param fpbs
	 * @param request
	 * @return
	 */
	public String updateFilePackingBox( List<ExcelFrom> listDatas,FilePackingBoxService fpbs,HttpServletRequest request) {
		//生成UUID
		UUID uuid=UUID.randomUUID();
		String uuidStr = uuid.toString().replace("-", ""); 
		String boxid = uuidStr;
		String isNull = "false";
		AmCoArchivefile acaFile =  new AmCoArchivefile();
		for (int i = 0; i < listDatas.size(); i++) {
			acaFile.setBoxid(boxid);
			acaFile.setArchivefileremark(listDatas.get(i).getArchivefileremark());
			acaFile.setArchivefileid(listDatas.get(i).getArchivefileid());
			acaFile.setArchivefilefilenumber(listDatas.get(i).getArchivefilefilenumber());
			if(fpbs.updateFilePackingBox(acaFile) > 0) {
				isNull = uuidStr;
			}
		}
		return isNull;
	}
	
	/**
	 * 装盒功能
	 * @param cartoningFunctionData		//装盒参数
	 * @param excelfroms				//文件生成是页面的传参
	 * @param fcfbs						//档案自定义		>>	档案盒  service层
	 * @param fpbs						//档案整理	 >>	       文件装盒页面  service层
	 * @param fctoc						//档案自定义	   	>>		保管期限  service层
	 * @param request					//请求
	 * @param as						//档案	service层
	 * @return
	 */
	public Boolean cartoningFunction(
				CartoningFunctionDataVoForm cartoningFunctionData,
				FileCustomizationFileBoxService fcfbs,
				FilePackingBoxService fpbs,
				FileCustomizationTermOfCustodyService fctoc,
				HttpServletRequest request,
				ArchiveService as) {
		GenerateRuleFormulateVo grfVO = new GenerateRuleFormulateVo();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 	//创建日期
			Date boxcreatetime = new Date(); 
	        String dateNowStr = sdf.format(boxcreatetime);  
	        Boolean isInsert = true;
	        //盒号
			String boxnumber = null;
			//盒编号
			String boxsericalnumber = null;
			Archive archive =as.queryArchiveById(cartoningFunctionData.getQuanzongId()); 
			AmMaSmRetentionperiod amsr = new AmMaSmRetentionperiod();
			AmCoBox acb = new AmCoBox();
			AmCoBoxProperty acpty = new AmCoBoxProperty();
			acpty.setBoxpropertyid(cartoningFunctionData.getBoxProperties());
			List<AmCoBoxProperty> acblist =  fcfbs.queryBoxProperties(acpty);
			//盒子厚度
			String boxpropertythickness = acblist.get(0).getBoxpropertythickness();
			//盒子页数
			String boxpropertypag = acblist.get(0).getBoxpropertypag();
			//赋予档案盒全宗号（查询）
			//获取全宗iD填装到档案盒中
			Archive ar = new Archive();
			ar.setQuanzongId(cartoningFunctionData.getQuanzongId());
			acb.setArchive(ar);
			acb.setBoxanual(cartoningFunctionData.getArchivefileanual());
			List<AmCoBox> isAmCoBox = fpbs.queryMaxBoxNumber(acb);
			if(isAmCoBox.get(0) == null) {
				amsr.setRetentionperiodid(cartoningFunctionData.getRetentionperiodid());
				List<AmMaSmRetentionperiod> asrs = fctoc.queryTermOfCustody(amsr);
				for (int i = 0; i < asrs.size(); i++) {
					grfVO.setRetentionperiodcode( asrs.get(i).getRetentionperiodcode());
				}
				grfVO.setQuanzongnumber(archive.getQuanzongNumber());
				grfVO.setArchivefileanual(cartoningFunctionData.getArchivefileanual());
				grfVO.setBoxnumber("1");
				boxnumber = grfVO.getBoxnumber();
				boxsericalnumber = boxNumberGenerate(grfVO);
				//进行新增填装数据
				AmCoBox amcobox = new AmCoBox();
				Archive arch = new Archive();
				SecondryClassFication scCftion = new SecondryClassFication();
				AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
				scCftion.setScId(cartoningFunctionData.getSecondaryclassificationid());
				arch.setQuanzongId(cartoningFunctionData.getQuanzongId());
				amcobox.setBoxid(cartoningFunctionData.getBoxid());
				amcobox.setBoxsituation(cartoningFunctionData.getBoxsituation());
				amcobox.setBoxsericalnumber(boxsericalnumber);
				amcobox.setBoxthickness(boxpropertythickness);
				amcobox.setBoxpage(boxpropertypag);
				amcobox.setBoxcasesnumber(cartoningFunctionData.getBoxcasesnumber());
				amcobox.setArchive(arch);
				amcobox.setBoxanual(cartoningFunctionData.getArchivefileanual());
				amcobox.setRetentionperiodid(cartoningFunctionData.getRetentionperiodid());
				amcobox.setBoxstartnumber(cartoningFunctionData.getBoxstartnumber());
				amcobox.setBoxendnumber(cartoningFunctionData.getBoxendnumber());
				amcobox.setBoxnumber(boxnumber);
				amcobox.setSecondryClassFication(scCftion);
				amcobox.setArchivefileid(amcoarchivefile);
				if(fpbs.insertAmCoBox(amcobox) >0) {
					//文件目录生成
					isInsert = fileDirectoryGeneration(request, cartoningFunctionData, fpbs);
					if(isInsert == true) {
						return isInsert;
					}else {
						return isInsert;
					}
					
				}else {
					isInsert = false;
					return isInsert;
				}
			}else {
				
				amsr.setRetentionperiodid(cartoningFunctionData.getRetentionperiodid());
				List<AmMaSmRetentionperiod> asrs = fctoc.queryTermOfCustody(amsr);
				for (int i = 0; i < asrs.size(); i++) {
					grfVO.setRetentionperiodcode( asrs.get(i).getRetentionperiodcode());
				}
				grfVO.setQuanzongnumber(archive.getQuanzongNumber());
				grfVO.setArchivefileanual(cartoningFunctionData.getArchivefileanual());
				for (int i = 0; i < fpbs.queryMaxBoxNumber(acb).size(); i++) {
					String boxnumbers = fpbs.queryMaxBoxNumber(acb).get(i).getBoxnumber().toString();
					Integer boxnumbe = Integer.parseInt(boxnumbers)+1;
					grfVO.setBoxnumber(boxnumbe.toString());
				}
				boxnumber = grfVO.getBoxnumber();
				boxsericalnumber = boxNumberGenerate(grfVO);
				//进行新增填装数据
				
				AmCoBox amcobox = new AmCoBox();
				Archive arch = new Archive();
				SecondryClassFication scCftion = new SecondryClassFication();
				AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
				/*amcoarchivefile.setArchivefileid(cartoningFunctionData.getArchivefileid());*/
				scCftion.setScId(cartoningFunctionData.getSecondaryclassificationid());
				arch.setQuanzongId(cartoningFunctionData.getQuanzongId());
				amcobox.setBoxid(cartoningFunctionData.getBoxid());
				amcobox.setBoxsituation(cartoningFunctionData.getBoxsituation());
				amcobox.setBoxsericalnumber(boxsericalnumber);
				amcobox.setBoxthickness(boxpropertythickness);
				amcobox.setBoxpage(boxpropertypag);
				amcobox.setBoxcasesnumber(cartoningFunctionData.getBoxcasesnumber());
				amcobox.setArchive(arch);
				amcobox.setBoxanual(cartoningFunctionData.getArchivefileanual());
				amcobox.setRetentionperiodid(cartoningFunctionData.getRetentionperiodid());
				amcobox.setBoxstartnumber(cartoningFunctionData.getBoxstartnumber());
				amcobox.setBoxendnumber(cartoningFunctionData.getBoxendnumber());
				amcobox.setBoxnumber(boxnumber);
				amcobox.setSecondryClassFication(scCftion);
				amcobox.setArchivefileid(amcoarchivefile);
				if(fpbs.insertAmCoBox(amcobox) > 0) {
					//文件目录生成
					isInsert = fileDirectoryGeneration(request, cartoningFunctionData, fpbs);
					if(isInsert == true) {
						return isInsert;
					}else {
						return isInsert;
					}
				}else {
					isInsert = false;
					return isInsert;
				}
			}
	}
	/**
	 * 文件目录生成
	 * @param request
	 * @param response
	 * @return
	 */
	public Boolean fileDirectoryGeneration(HttpServletRequest request,
				CartoningFunctionDataVoForm cartoningFunctionData,
				FilePackingBoxService fpbs) {
		SealTools sealtools = new SealTools();
		//盒面盒脊对象
		BoxSideBoxRidge boxsideboxridge = new BoxSideBoxRidge();
		Boolean isfileDirectoryGeneration = false;
		AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
		AmCoBox amcobox = new AmCoBox();
		//盒子主键
		amcobox.setBoxid(cartoningFunctionData.getBoxid());
		boxsideboxridge.setQuanzongNumber(fpbs.queryQuanzongNumber(cartoningFunctionData.getQuanzongId()));
		boxsideboxridge.setQuanzongName(cartoningFunctionData.getQuanzongName());
		boxsideboxridge.setBoxanual(cartoningFunctionData.getArchivefileanual());
		boxsideboxridge.setAmmasmretentionperiod(cartoningFunctionData.getRetentionperiodidName());
		boxsideboxridge.setSecondryClassFication(cartoningFunctionData.getSecondaryclassificationidName());
		boxsideboxridge.setBoxstartnumber(cartoningFunctionData.getBoxstartnumber());
		boxsideboxridge.setBoxendnumber(cartoningFunctionData.getBoxendnumber());
		boxsideboxridge.setBoxsituation(cartoningFunctionData.getBoxsituation());
		boxsideboxridge.setCollator(cartoningFunctionData.getExcelList().get(0).getCollator());
		//整理时间
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		boxsideboxridge.setFinishingTime(df.format(day).replaceAll("-","     "));
		List<AmCoBox> list = fpbs.boxNumberQueryList(amcobox);
		Map<String, Object> map = null;
		for (int i = 0; i < list.size(); i++) {
			boxsideboxridge.setBoxnumber(list.get(i).getBoxnumber());
			map = sealtools.boxInfor(boxsideboxridge, request);
		}
		
		
		//生成归档章
		generateAnArchiveChapter(request, cartoningFunctionData,fpbs);
		
		
		
		
		
		//遍历map中的键 
		List<String> mapList =new ArrayList<String>();
		for(String o:map.keySet()) {
			//生成PDF文件
			mapList.add((String) map.get(o));
		}
		fileGeneratedPDF(request, cartoningFunctionData, fpbs);
		
		AmCoBoxattachment amcoboxattachment = new AmCoBoxattachment();
		Archive archive = new Archive();
		archive.setQuanzongId(cartoningFunctionData.getQuanzongId());
		//生成UUID
		UUID uuid=UUID.randomUUID();
		String uuidStr = uuid.toString().replace("-", "");
		
		for (int j = 0; j < list.size(); j++) {
			amcoboxattachment.setBoxattachmentBox(mapList.get(0));
			amcoboxattachment.setBoxattachmentForm(mapList.get(1));
			amcoboxattachment.setBoxId(list.get(j).getBoxid());
			amcoboxattachment.setBoxYear(cartoningFunctionData.getArchivefileanual());
			amcoboxattachment.setArchive(archive);
			
				//生成Exce
				/*String filename = cartoningFunctionData.getQuanzongName()
							+"-"+cartoningFunctionData.getArchivefileanual()
							+"-"+cartoningFunctionData.getRetentionperiodidName()
							+"-"+cartoningFunctionData.getSecondaryclassificationidName()
							+".xlsx";*/
				String filename = "归档文件目录.xlsx";
				AmCoArchivefile amcBoxId = new AmCoArchivefile();
				amcBoxId.setBoxid(cartoningFunctionData.getBoxid());
				//EXCEL路径
				List<AmCoBox> boxNumbeList = fpbs.boxNumberQueryList(amcobox);
				String quanzongNum = fpbs.queryQuanzongNumber(cartoningFunctionData.getQuanzongId());
				String pdfPath = "D:/file"+"/"+quanzongNum+"/"+cartoningFunctionData.getArchivefileanual()+"/"+boxNumbeList.get(0).getBoxnumber()+"/"+filename;
				amcoboxattachment.setBoxattachmentFile(pdfPath);
				if(fpbs.insertAmCoBoxattachment(amcoboxattachment)>0) {
					isfileDirectoryGeneration = true;
				List<AmCoArchivefile> ArchivefileList = fpbs.ExcelQuery(amcBoxId);
				List<List> excelList = new ArrayList<>();
				for (int i = 0; i < ArchivefileList.size(); i++) {
					List fileList = new ArrayList<>();
						fileList.add(i+1);
					if(ArchivefileList.get(i).getArchivefilefilenumber() == null || ArchivefileList.get(i).getArchivefilefilenumber() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefilefilenumber());
					}
					
					if(ArchivefileList.get(i).getArchivefilereferencenumber() == null || ArchivefileList.get(i).getArchivefilereferencenumber() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefilereferencenumber());
					}
					
					if(ArchivefileList.get(i).getArchivefileresponsible() == null || ArchivefileList.get(i).getArchivefileresponsible() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefileresponsible());	
					}
					
					if(ArchivefileList.get(i).getArchivefiletitle() == null || ArchivefileList.get(i).getArchivefiletitle() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefiletitle());	
					}
					
					if(ArchivefileList.get(i).getArchivefilecreatetime() == null || ArchivefileList.get(i).getArchivefilecreatetime() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefilecreatetime().replaceAll("-", ""));
					}
					
					if(ArchivefileList.get(i).getAfsecurityclassrification() == null || ArchivefileList.get(i).getAfsecurityclassrification() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getAfsecurityclassrification());
					}
					
					if(ArchivefileList.get(i).getArchivefilepages() == null || ArchivefileList.get(i).getArchivefilepages() == "") {
						fileList.add("");
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefilepages());
					}
					if(ArchivefileList.get(i).getArchivefileremark() == null || ArchivefileList.get(i).getArchivefileremark() == "") {
						fileList.add("");	
					}else {
						fileList.add(ArchivefileList.get(i).getArchivefileremark());	
					}
					
					excelList.add(fileList);
					
				}
				try {
					produceOrganization(request, excelList, pdfPath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isfileDirectoryGeneration = true;
				/*if(isfileDirectoryGeneration == true) {
					
				}*/
			}else {
				isfileDirectoryGeneration = false;
			}
		}
		
		return isfileDirectoryGeneration;
		
	}
	

	/**
	 * 生成文件归档章
	 * @param request
	 * @param response
	 * @param excelfroms
	 * @return
	 */
	public void generateAnArchiveChapter(HttpServletRequest request,
			CartoningFunctionDataVoForm cartoningFunctionData,FilePackingBoxService fpbs) {
		SealTools sealtools = new SealTools();
		Shuiyin shuiyin = new Shuiyin();
		//全宗号
		String quanzongNum = fpbs.queryQuanzongNumber(cartoningFunctionData.getQuanzongId());
		//文件附件对象
		List<FileAttachment> fileattachmentList = new ArrayList<>(); 
		for (int i = 0; i < cartoningFunctionData.getExcelList().size(); i++) {
			FileAttachment fileattachment = new FileAttachment();
			fileattachment.setArchiveFileId(cartoningFunctionData.getExcelList().get(i).getArchivefileid());
			fileattachment.setQuanzongId(cartoningFunctionData.getQuanzongId());
			fileattachment.setFileAttachmentAnual(cartoningFunctionData.getArchivefileanual());
			fileattachment.setFileAttachmentMark("1");
			fileattachmentList.add(fileattachment);
		}
		List<FileAttachment> fileList = new ArrayList<>();
 		//数据库的文件图片存储位置
		for (int i = 0; i < fileattachmentList.size(); i++) {
			fileList = fpbs.fileAttachmentPathQuery(fileattachmentList.get(i));
			
			for (int j = 0; j < fileList.size(); j++) {
				Logger log = Logger.getLogger(GenerateRuleFormulateTool.class);
				log.info("归档章:"+fileList.get(j));
				
				//归档所需参数
				shuiyin.setQuanzongId(quanzongNum);
				shuiyin.setAnual(cartoningFunctionData.getArchivefileanual());
				shuiyin.setScName(cartoningFunctionData.getSecondaryclassificationidName());
				shuiyin.setRetentionperiodName(cartoningFunctionData.getRetentionperiodidName());
				//整理人
				shuiyin.setCollator(cartoningFunctionData.getExcelList().get(0).getCollator());
				//整理时间
				Date day=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				shuiyin.setFinishingTime(df.format(day).replace("-", ""));
				AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
				amcoarchivefile.setArchivefileid(fileList.get(j).getArchiveFileId());
				List<AmCoArchivefile> listJianHao = fpbs.getFileNumber(amcoarchivefile);
				//页数
				shuiyin.setPageNum(listJianHao.get(0).getArchivefilepages());
				//件号
				String[] jinhaos = listJianHao.get(0).getArchivefilefilenumber().split("-");
				int jhNum = jinhaos.length;
				String jianhao = "";
				for (int k = 0; k < jhNum; k++) {
					jianhao = jinhaos[jhNum-1];
				}
				shuiyin.setPiceNum(jianhao);
				sealtools.archiveInfor(shuiyin,fileList.get(j).getFileAttachmentPath() , request);
			}
		}
		
		
	}
	/**
	 * 文件PDF生成
	 * @param request
	 * @param cartoningFunctionData
	 * @param excelfroms
	 * @param fpbs
	 * @param pdfPath
	 * @return
	 */
	@RequestMapping("/fileGeneratedPDF")
	@ResponseBody
	public List<String> fileGeneratedPDF(HttpServletRequest request,
						CartoningFunctionDataVoForm cartoningFunctionData,			
						FilePackingBoxService fpbs) {
				AmCoArchivefile amcoarchivefile = new AmCoArchivefile();
				//获取全宗号
				AmCoBox acb = new AmCoBox();
				Archive ar = new Archive();
				ar.setQuanzongId(cartoningFunctionData.getQuanzongId());
				acb.setArchive(ar);
				String quanzongNum = fpbs.queryQuanzongNumber(cartoningFunctionData.getQuanzongId());
				//文件ID
				String archivefileid = request.getParameter("archivefileid");
				amcoarchivefile.setArchivefileid(archivefileid);
				//提名的集合
				List<String> tnameList = new ArrayList<>();
				//获取文件提名
				for (int i = 0; i < cartoningFunctionData.getExcelList().size(); i++) {
					String filetitle = (cartoningFunctionData.getExcelList().get(i).getArchivefiletitle());
					tnameList.add(filetitle);
				}
				//盒号
				AmCoBox amcobox = new AmCoBox();
				amcobox.setBoxid(cartoningFunctionData.getBoxid());
				//盒号的集合
				List<AmCoBox> list = fpbs.boxNumberQueryList(amcobox);
				//接收消息的集合
				List<String> msgList = new ArrayList<>();
				AmCoArchivefile file = new AmCoArchivefile();
				//调用文件生成路径
				CreatePdfUtil createpdfutil = new CreatePdfUtil();
				for (int i = 0; i < cartoningFunctionData.getExcelList().size(); i++) {
					//文件附件对象
					FileAttachment fileattachment = new FileAttachment();
					fileattachment.setArchiveFileId(cartoningFunctionData.getExcelList().get(i).getArchivefileid());
					fileattachment.setQuanzongId(cartoningFunctionData.getQuanzongId());
					fileattachment.setFileAttachmentAnual(cartoningFunctionData.getArchivefileanual());
					//123
					
					//图片的存储位置转为String集合
					List<String> fileatList= new ArrayList<>();
					//数据库的文件图片存储位置
					List<FileAttachment> fileList = fpbs.fileAttachmentPathQuery(fileattachment);
					if(fileList!=null && !fileList.isEmpty()) {
						for (int i2 = 0; i2 < fileList.size(); i2++) {
							fileatList.add(fileList.get(i2).getFileAttachmentPath().toString());
							//输出路径
							for (int j = 0; j < list.size(); j++) {
								for (int j2 = 0; j2 < tnameList.size(); j2++) {
									String pdfPath = "D:/file"+"/"+quanzongNum+"/"+cartoningFunctionData.getArchivefileanual()+"/"+list.get(j).getBoxnumber()+"/"+tnameList.get(i)+".pdf";
									msgList.add(pdfPath);
									try {
										msgList = (List<String>) CreatePdfUtil.createPDF(pdfPath, fileatList);
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
							}
							
						}
						
					}else {
						msgList.add("该目录不存在");
					}
				}
				return msgList;
				
		}

	// excel模板
	public void produceOrganization(HttpServletRequest request,List<List> list ,String pdfPath) throws Exception {
			/*String path = request.getSession().getServletContext().getRealPath("excelFile") + "/" + filename;*/
			String path = pdfPath;
			String fileName = "归档文件目录";
			String[] archiveOutFilt = { "序号","档号", "文号", "责任者", "题名", "日期", "密级", "页数", "备注" };
			ExportExcel.createExcel(path, fileName, archiveOutFilt, list);
		}
/*	public static void main(String[] args) throws Exception {
		HttpServletRequest request = null;
		GenerateRuleFormulateTool a = new GenerateRuleFormulateTool();
		String filename = "Book1.xls";
		a.produceOrganization(filename);
	}
	*/
	
}
