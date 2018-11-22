package filemanage.recorded.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.BoxSideBoxRidge;
import filemanage.recorded.dao.ArchiveFileRecordedTableMapper;
import filemanage.recorded.dao.ArchivingFileRecordedMapper;
import filemanage.recorded.dao.ExpectHistoryMapper;
import filemanage.recorded.dao.HisoryDataMapper;
import filemanage.recorded.dao.RecordedEditMapper;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.recorded.pojo.HistoryData;
import filemanage.recorded.vo.ArchiveFileAddHelp;
import filemanage.recorded.vo.BoxAddHelp;
import filemanage.recorded.vo.BoxAttachmentHelp;
import filemanage.recorded.vo.ConditionHelp;
import filemanage.recorded.vo.ExportHistoryHelp;
import filemanage.recorded.vo.GdFileArray;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.recorded.vo.RecodedTableSelect;
import filemanage.recorded.vo.RecordedTableCountHelp;
import filemanage.recorded.vo.SaveBoxInfor;
import filemanage.recorded.vo.SelectQueryHelp;
import filemanage.recorded.vo.TableContentInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.copefile.CopeFileTool;
import filemanage.utils.historyFile.ClippiungImage;
import filemanage.utils.historyFile.FileNumberCheck;
import filemanage.utils.historyFile.OcrRecognition;
import filemanage.utils.historyFile.PinTinTools;
import filemanage.utils.historyFile.PressureAndDecompression;
import filemanage.utils.historyFile.ZipHistoryTools;
import filemanage.utils.layui.Layui;
import filemanage.utils.shuiYinTool.SealTools;

/**
 * @author meng
 *档案著录
 */
@Service
public class RecordedServiceSimpl implements RecordedService{
	private Logger logger=Logger.getLogger(RecordedServiceSimpl.class);
	private Integer temp=0;
	
	@Autowired
	private HisoryDataMapper hisoryDataMapper;
	@Autowired
	private ArchivingFileRecordedMapper archivingFileRecordedMapper;
	@Autowired
	private ArchiveFileRecordedTableMapper archiveFileRecordedTableMapper;
	@Autowired
	private RecordedEditMapper recordedEditMapper;
	@Autowired
	private ExpectHistoryMapper expectHistoryMapper;
	
	@Override
	public Boolean addHistoryTaitan(MultipartFile zipFile, Integer chunk, Integer chunks, String path) {
		Boolean lock=true;
		long beginTime=System.currentTimeMillis();
		long endUploadTime = 0;//上传结束时间
		long decompressionZipFileTime=0;//解压文件结束时间
		List<HistoryData> listHistoryData=new ArrayList<HistoryData>();//历史数据
		List<HistoryAnnex> listHistoryAnnex=new ArrayList<HistoryAnnex>();//历史数据附件
		List<String> listFile=null;//历史数据压缩包中文件
		PressureAndDecompression pAndDecompression=new PressureAndDecompression();//历史数据工具
		String fileName=null;//文件名称
		logger.info("开始上传泰坦格式文件");
		logger.info("分片信息:"+chunk+":"+chunks);
		if(chunk==null&&chunks==null) {//未开启分片保存压缩文件
			fileName=zipFile.getOriginalFilename();
			long fileSize=zipFile.getSize();
			logger.info("文件的大小是："+fileSize);
			try {
				File dir=new File(path,fileName);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				zipFile.transferTo(dir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				logger.info("开始解压泰坦文件");
				listFile=pAndDecompression.decompressionZipFile(path+"/"+zipFile.getOriginalFilename(), path);
				Map<String, Object> map=havingHistory(listFile, path);
				listHistoryData=(List<HistoryData>)map.get("historyData");
		        listHistoryAnnex=(List<HistoryAnnex>)map.get("historyAnnex");
			}
		}else {//开启分片合并分片后的文件
			fileName=zipFile.getOriginalFilename();
			fileName=fileName.replace(".", (chunk+1)+".");
			long fileSize=zipFile.getSize();
			logger.info("文件的大小是："+fileSize);
			try {
				File dir=new File(path,fileName);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				zipFile.transferTo(dir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(temp==(chunks-1)) {//最后一片文件
				FileOutputStream fileOutputStream=null;  
		        BufferedOutputStream bufferedOutputStream=null;  
		        BufferedInputStream inputStream=null;
		        String name=zipFile.getOriginalFilename();
		        try {
		        	File tempFiles=new File(path);
		        	File[] files=tempFiles.listFiles();
					File file=new File(path,name);
					fileOutputStream=new FileOutputStream(file);//创建文件输出流 
					bufferedOutputStream=new BufferedOutputStream(fileOutputStream);//创建文件缓存流  
					byte[] buffer = new byte[1024];//一次读取1024个字节 
					if(files.length>0) {//文件夹下存在文件
						Arrays.sort(files,new Comparator<File>() {//重新排序规则
							@Override
							public int compare(File o1, File o2) {
								String o1Name=o1.getName();//获取文件1 的名称
								String o2Name=o2.getName();//获取文件2 的名称
								Integer o1Length=o1Name.length()-file.getName().length();//获取分片文件的长度和文件的长度的差值
								Integer o2Length=o2Name.length()-file.getName().length();//获取分片文件的长度和文件的长度的差值
								String o1String=o1Name.substring(o1Name.lastIndexOf(".")-o1Length, o1Name.lastIndexOf("."));
								String o2String=o2Name.substring(o2Name.lastIndexOf(".")-o2Length, o2Name.lastIndexOf("."));
								logger.info("文件1的名称["+o1Name+"];和文件的差值["+o1Length+"];序号["+o1String+"]");
								logger.info("文件2的名称["+o2Name+"];和文件的差值["+o2Length+"];序号["+o2String+"]");
								if(o1String.length()==0) {
									o1String="0";
								}else if(o2String.length()==0) {
									o2String="0";
								}
								Integer o1Integer=Integer.parseInt(o1String);
								Integer o2Integer=Integer.parseInt(o2String);
								if(o1Integer>o2Integer) {
									return 1;
								}else if(o1Integer==o2Integer) {
									return 0;
								}else {
									return -1;
								}
							}
						});
						for(int i=0;i<files.length;i++) {//组合分片文件
							File fil=files[i];
							inputStream = new BufferedInputStream(new FileInputStream(fil));
							int readcount;  
					        while ((readcount = inputStream.read(buffer)) > 0) {  
					           bufferedOutputStream.write(buffer, 0, readcount);  
					           bufferedOutputStream.flush();  
					        }  
					        inputStream.close();  
						}
						bufferedOutputStream.close();
						for(int i=0;i<files.length;i++) {//删除分片文件
							files[i].delete();
						}
						temp=0;
						endUploadTime=System.currentTimeMillis();
						logger.info("泰坦格式文件上结束");
						logger.info("泰坦文件上传总用时:"+(endUploadTime-beginTime)+"ms");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(inputStream!=null){  
		                try {  
		                    inputStream.close();  
		                } catch (IOException e) {  
		                    e.printStackTrace();  
		                }  
		            }  
		            if(fileOutputStream!=null){  
		                try {  
		                    fileOutputStream.close();  
		                } catch (IOException e) {  
		                    e.printStackTrace();  
		                }  
		            }  
		            if(bufferedOutputStream!=null){  
		                try {  
		                    bufferedOutputStream.close();  
		                } catch (IOException e) {  
		                    e.printStackTrace();  
		                }  
		            }
		            listFile=pAndDecompression.decompressionZipFile(path+"/"+zipFile.getOriginalFilename(), path);
					Map<String, Object> map=havingHistory(listFile, path);
					listHistoryData=(List<HistoryData>)map.get("historyData");
			        listHistoryAnnex=(List<HistoryAnnex>)map.get("historyAnnex");
				}
			}
		}
		System.out.println(zipFile+":"+chunk+":"+chunks+":"+path);
		if(listHistoryData.size()>0&&listHistoryAnnex.size()>0) {
			logger.info("开始批量导入数据库");
			Integer hisData=hisoryDataMapper.addHistoryData(listHistoryData);
			if(listHistoryData.size()==hisData) {
				logger.info("历史数据批量导入数据库成功");
				lock=true;
			}else {
				logger.info("历史数据批量导入数据库失败");
				lock= false;
			}
			Integer hisAnnex=hisoryDataMapper.addHistoryAnnex(listHistoryAnnex);
			if(listHistoryAnnex.size()==hisAnnex) {
				logger.info("历史数据附件批量导入数据库成功");
				lock=true;
			}else {
				logger.info("历史数据附件批量导入数据库失败");
				lock=false;
			}
			for (String string : listFile) {
				pAndDecompression.deleteFile(path+"/"+string);
			}
			pAndDecompression.deleteFile(path+"/"+zipFile.getOriginalFilename());
		}
		temp++;
		return null;
	}


//==============================================================================================新建档案===============================================	
	/**
	 * 识别归档文件目录
	 */
	@Override
	public TableContentInfor havingTableContentInfor(String file) {
		TableContentInfor table=new TableContentInfor();
		ClippiungImage clip=new ClippiungImage();//实例图片操作类
		OcrRecognition ocrRec=new OcrRecognition();//实例化识别类
		FileNumberCheck fileNumberCheck=new FileNumberCheck();//实例化
		BoxAddHelp amCoBox=new BoxAddHelp();//实例化盒子信息
		ArchiveFileAddHelp archiveFile=null;//文件
		List<ArchiveFileAddHelp> listArchiveFile=new ArrayList<ArchiveFileAddHelp>();//保存文件集合
		List<String> listFileNumber=new ArrayList<String>();//接收所有文件的档号
		List<List> listes=null;//接收归档文件目录绝对路径
		List<Map> listResult=null;//接收表格内容
		Map<String, Object> mapFileNumber=null;//接收档号校验后的结果
		String boxstartnumber=null;//起件号
		String boxendnumber=null; // 止件号
		String pathname=null;
		long begin=System.currentTimeMillis();
		String filename=file.replace("/resource", "D:/file");
		try {
			pathname=clip.copyFile(filename);
			listes=clip.havingImageCoorDinate(pathname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("开始ocr识别表格内容");
		long beginRecTime=System.currentTimeMillis();//识别开始时间
		listResult=ocrRec.havingTableContent(listes);
		long endRecTime=System.currentTimeMillis();//识别结束时间
		logger.info("ocr识别表格识别用时:"+(endRecTime-beginRecTime)+"ms");
		for(int i=0;i<listResult.size();i++) {
			listFileNumber.add(listResult.get(i).get("fileNumber").toString());//获取表格中文件的所有的档案
		}
		logger.info("档号信息校验开始");
		long fileNumCheckTimeBegin=System.currentTimeMillis();
		mapFileNumber=fileNumberCheck.havingContent(listFileNumber);
		long fileNumCheckTimeEnd=System.currentTimeMillis();
		logger.info("档号信息校验用时:"+(fileNumCheckTimeEnd-fileNumCheckTimeBegin)+"ms");
		logger.info("信息添加到数据库");
		//公用信息
		String quanZongId=archivingFileRecordedMapper.queryQuanZongId(mapFileNumber.get("quanZongNumber").toString());//获取全宗主键
		String retentionperiodid=archivingFileRecordedMapper.queryRetentionPeriodId(mapFileNumber.get("custodyTime").toString());//获取保管期限主键
		String pcId=archivingFileRecordedMapper.queryPcId(mapFileNumber.get("firstClass").toString());//获取一级分类主键
		String scId=archivingFileRecordedMapper.queryScId(mapFileNumber.get("secondClass").toString());//获取二级分类主键
		String anual=mapFileNumber.get("anual").toString();//年度
		String boxid=UUID.randomUUID().toString();//盒子的主键
		//盒子信息
		boxstartnumber=mapFileNumber.get("beginPart").toString();//起件号
		boxendnumber=mapFileNumber.get("endPart").toString();//止件号
		String boxcasesnumber=mapFileNumber.get("number").toString();//件数
		String boxstatus="5";//盒状态(0：待审核，1：审核中，2：验收合格；3：驳回 ；4未进馆；5：未保存（档案著录新进啊档案默认0)
		String boxAuditstart="2";//文件审核状态(0：未审核，1：已审核：2：已驳回；默认0)
		String boxBoxingStart="1";//装盒状态（档案著录中已装盒，未装盒）
		amCoBox.setAnual(anual);
		amCoBox.setBoxAuditstart(boxAuditstart);
		amCoBox.setBoxBoxingStart(boxBoxingStart);
		amCoBox.setBoxcasesnumber(boxcasesnumber);
		amCoBox.setBoxendnumber(boxendnumber);
		amCoBox.setBoxid(boxid);
		amCoBox.setBoxstartnumber(boxstartnumber);
		amCoBox.setBoxstatus(boxstatus);
		amCoBox.setPcId(pcId);
		amCoBox.setQuanZongId(quanZongId);
		amCoBox.setRetentionperiodid(retentionperiodid);
		amCoBox.setScId(scId);
		//文件信息
		String archiveFileIsUpload="1";//文件是否上传
		for(Map map:listResult) {
			archiveFile=new ArchiveFileAddHelp();
			String archiveFileId=UUID.randomUUID().toString();// 文件主键
			String archiveFileResponsible=map.get("respomsiblePerson").toString();//责任者
			String archiveFileCreatetime=map.get("date").toString();//成文日期
			String archiveFileTitle=map.get("title").toString();// 题名
			String archiveFilePages=map.get("pagesNumber").toString();// 页数
			String afSecurityClassrification=map.get("confidentialityLevel").toString();//密级
			String archiveFileFileNumber=map.get("fileNumber").toString();// 档号
			String archiveFileReferenceNumbe=map.get("textNumber").toString();// 文号
			String archiveFileRemark=map.get("note").toString();// 备注
			archiveFile.setAfSecurityClassrification(afSecurityClassrification);
			archiveFile.setAnual(anual);
			archiveFile.setArchiveFileCreatetime(archiveFileCreatetime);
			archiveFile.setArchiveFileFileNumber(archiveFileFileNumber);
			archiveFile.setArchiveFileId(archiveFileId);
			archiveFile.setArchiveFileIsUpload(archiveFileIsUpload);
			archiveFile.setArchiveFilePages(archiveFilePages);
			archiveFile.setArchiveFileReferenceNumbe(archiveFileReferenceNumbe);
			archiveFile.setArchiveFileRemark(archiveFileRemark);
			archiveFile.setArchiveFileResponsible(archiveFileResponsible);
			archiveFile.setArchiveFileTitle(archiveFileTitle);
			archiveFile.setBoxid(boxid);
			archiveFile.setPcId(pcId);
			archiveFile.setQuanZongId(quanZongId);
			archiveFile.setRetentionperiodid(retentionperiodid);
			archiveFile.setScId(scId);
			listArchiveFile.add(archiveFile);
		}
		archivingFileRecordedMapper.addBoxInfor(amCoBox);//添加盒信息数据库
		archivingFileRecordedMapper.addArchiveFile(listArchiveFile);//添加文件信息到数据库
		long addDataend=System.currentTimeMillis();
		logger.info("添加数据库用时:"+(addDataend-fileNumCheckTimeEnd)+"ms");
		//组装返回数据
		table.setAnual(anual);
		table.setBoxendnumber(boxendnumber);
		table.setBoxId(boxid);
		table.setBoxstartnumber(boxstartnumber);
		table.setPcId(pcId);
		table.setQuanzongId(quanZongId);
		table.setRetentionperiodid(retentionperiodid);
		table.setScId(scId);
		//删除多余的文件
		for(List lists:listes) {
			for(Object string:lists) {
				clip.deleteFile(string.toString());
			}
		}
		clip.deleteFile(pathname);
		long end =System.currentTimeMillis();
		logger.info("识别归档文件总用时："+(end-begin)+"ms");
		return table;
	}

	/**
	 * 全宗号
	 */
	@Override
	public List<ConditionHelp> findQuanzongNumber() {
		return archivingFileRecordedMapper.findQuanzongNumber();
	}

	/**
	 * 全宗名
	 */
	@Override
	public List<ConditionHelp> findQuanzongName() {
		return archivingFileRecordedMapper.findQuanzongName();
	}

	/**
	 *一级分类
	 */
	@Override
	public List<ConditionHelp> findPcId() {
		return archivingFileRecordedMapper.findPcId();
	}

	/**
	 * 二级分类
	 */
	@Override
	public List<ConditionHelp> findScId() {
		return archivingFileRecordedMapper.findScId();
	}

	/**
	 * 保管期限
	 */
	@Override
	public List<ConditionHelp> findRetentionperiodName() {
		return archivingFileRecordedMapper.findRetentionperiodName();
	}

	/**
	 * 盒子属性
	 */
	@Override
	public List<ConditionHelp> findBoxpropertyPag() {
		return archivingFileRecordedMapper.findBoxpropertyPag();
	}

	/**
	 * 保存盒子信息
	 */
	@Override
	public String saveBoxInfor(MultipartFile file) {
		if(file!=null) {
			String path="D:/file/prepartionForm";
			String fileName=file.getOriginalFilename();
			File dir=new File(path,fileName);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			try {
				file.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path+"/"+fileName;
		}else {
			return "";
		}
	}

	/**
	 * 获取盒子内的文件
	 */
	@Override
	public Layui havingFileByBoxId(String boxId,Integer limit,Integer page) {
		Map<String,Object> map=new HashMap<String,Object>();
		Integer begin=(page-1)*limit+1;
		Integer end=page*limit;
		map.put("boxId", boxId);
		map.put("begin", begin);
		map.put("end", end);
		List<ArchiveFile> data=archivingFileRecordedMapper.findArchiveFileByBoxId(map);
		Integer count=archivingFileRecordedMapper.countArchiveFileByBoxId(boxId);
		return new Layui().data(count, data);
	}

	/**
	 * 保存文件信息
	 */
	@Override
	public String saveFileInfor(MultipartFile file, String boxId) {
		if(file!=null) {
			Boolean lock=false;
			ArchiveFile arFile=null;
			String filename=file.getOriginalFilename();//获取文件的名字
			String x=filename;
			x=filename.substring(0, x.lastIndexOf("."));
			List<ArchiveFile> list=archivingFileRecordedMapper.findAllArchiveFileByBoxId(boxId);
			for (ArchiveFile archiveFile : list) {//判断文件是否存在
				if(x.equals(archiveFile.getArchiveFileTitle())) {
					lock=true;
					arFile=archiveFile;
				}
			}
			if(lock) {//存在
				String path="D:/file"+"/"+
							archivingFileRecordedMapper.findQzongNumber(arFile.getArchiveFileId())+"/"+
							arFile.getArchiveFileCreatetime();//服务器路径+全宗号+文件成文日期
				File dir=new File(path,filename);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				try {
					file.transferTo(dir);//保存文件
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				PressureAndDecompression pressureAndDecompression=new PressureAndDecompression();
				String pathName=path+"/"+filename;
				List<String> listPath=pressureAndDecompression.decompressionZipFile(pathName, path);//获取所有文件的信息
				pathName=pathName.substring(0,pathName.lastIndexOf("."));//获取文件附件的的保存路径
				FileAttachment fileAttachment=null;
				List<FileAttachment> listfileAttachment=new ArrayList<FileAttachment>();
				Integer in=null;
				//组装文件附件信息
				for (int i=0;i<listPath.size();i++) {
					fileAttachment=new FileAttachment();
					fileAttachment.setArchiveFileId(arFile.getArchiveFileId());//文件主键
					fileAttachment.setFileAttachmentAnual(arFile.getArchiveFileAnual());//年度
					fileAttachment.setFileAttachmentId(UUID.randomUUID().toString());//文件附件主键
					if(i==0) {//标记首页
						fileAttachment.setFileAttachmentMark("1");
					}else {
						fileAttachment.setFileAttachmentMark("0");
					}
					System.out.println(listPath.get(i));
					fileAttachment.setFileAttachmentName(listPath.get(i).substring(listPath.get(i).lastIndexOf("/")));//文件名
					
					in=(i+1);
					fileAttachment.setFileAttachmentPageNumber(in.toString());//页码
					fileAttachment.setFileAttachmentPath(path+"/"+listPath.get(i));//路径
					fileAttachment.setQuanzongId(archivingFileRecordedMapper.findQuanzongId(arFile.getArchiveFileId()));
					listfileAttachment.add(fileAttachment);
				}
				Integer ind=archivingFileRecordedMapper.addFileAttachment(listfileAttachment);
				archivingFileRecordedMapper.updateFileStart(arFile.getArchiveFileId());
				//更新装盒状态
				Integer uploadNum=archivingFileRecordedMapper.havingFileNum(boxId);//获取上传文件数量
				String boxNum=archivingFileRecordedMapper.havingBoxFileNum(boxId);//获取盒子中件数
				System.err.println(uploadNum+":"+boxNum);
				Boolean up=null;
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa:"+boxNum);
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa:"+uploadNum);
				if(boxNum.equals(uploadNum.toString())) {
					up=archivingFileRecordedMapper.updateBoxingStart(boxId);//
					if(up) {
						logger.info("成功");
					}else {
						return "数据库盒子状态更新失败";
					}
				}
				pressureAndDecompression.deleteFile(path+"/"+filename);
				if(ind==listPath.size()) {
					return "添加成功";
				}else {
					return "文件添加数据库失败";
				}
				
			}else {
				return "文件不存在";
			}
		}else {
			return "选择上传文件";
		}
	}

	/**
	 * 更新文件信息
	 */
	@Override
	public Boolean updateFileInfor(String fileId, String content, String value) {
		Map<String, String> map=new HashMap<String,String>();
		System.out.println("AAAAAAAAAA"+content);
		String str1 = value;
		if(content.equals("archiveFileCreatetime")) {
	        if(str1.length() != 8) {
	        	System.out.println("时间格式为8位");
	        }else {
	        	StringBuilder sb = new StringBuilder(str1);//构造一个StringBuilder对象
		        sb.insert(4, "-");//在指定的位置，插入指定的字符串
		        sb.insert(7, "-");//在指定的位置，插入指定的字符串
		        str1 = sb.toString();
		        map.put("fileId", fileId);
				map.put("content", content);
				map.put("value", str1);
	        }
		}else {
			map.put("fileId", fileId);
			map.put("content", content);
			map.put("value", value);
		}
		Integer index=archivingFileRecordedMapper.updataFileInfor(map);
		if(index>0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 获取文件附件信息
	 */
	@Override
	public List<String> havingFileAtta(String archiveFileId) {
		List<String> list=archivingFileRecordedMapper.havingFileAtta(archiveFileId);
		List<String> newList=new ArrayList<String>();
		for (String string : list) {
			newList.add(string.replace("D:/file","/resource"));
		}
		return newList;
	}

	/**
	 * 查询文件
	 */
	@Override
	public Layui findArchiveFileByBoxIdAndStart(String boxId, String start, Integer limit, Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin=(page-1)*limit+1;
		Integer end=page*limit;
		map.put("boxId", boxId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("start", start);
		List<ArchiveFile> data=archivingFileRecordedMapper.findArchiveFileByBoxIdAndStart(map);
		Integer count=archivingFileRecordedMapper.countArchiveFileByBoxIdAndStart(boxId, start);
		return new Layui().data(count, data);
	}

	/**
	 * 更新文件状态
	 */
	@Override
	public String updataBoxStart(PreparationFormHelp preparationFormHelp,String srcImage) {
		logger.info("保存盒子信息");
		CopeFileTool copFile=new CopeFileTool();//复制工具
		BoxSideBoxRidge boxSideBoxRidge=null;//盒面盒脊信息
		SealTools sealTools=new SealTools();//水印
		ClippiungImage clippiungImage=new ClippiungImage();//处理图片
		OcrRecognition ocrRecognition=new OcrRecognition();//ocr识别
		SaveBoxInfor saveBoxInfor=new SaveBoxInfor();//保存盒子信息
		BoxAttachmentHelp boxAttachmentHelp=new BoxAttachmentHelp();//盒子附件信息
		String bkPath=null;//备考表地址
		Boolean bkBoolean=null;//复制备考表结果
		Boolean fileBooean=null;//备考表存在判断
		long beginTime=System.currentTimeMillis();//获取方法执行开始时间
		AmCoBox boxInfor=archivingFileRecordedMapper.findAmCoBoxByCondition(preparationFormHelp);
		if(boxInfor!=null) {//盒子信息已存在
			return "盒号已存在";
		}else {
			logger.info("保存盒子附件的信息");
			fileBooean=preparationFormHelp.getBkImage()!=""&&preparationFormHelp.getBkImage()!=null;
			String path="D:/file/"+preparationFormHelp.getQzNumbar()+"/"+
					preparationFormHelp.getAnual()+"/"+preparationFormHelp.getBoxNumber();//盒子附件保存地址（file+全宗号+年度+盒号）
			File filePath=new File(path);
			if(!filePath.exists()) {
				filePath.mkdirs();//创建盒子信息保存地址
			}
			//归档文件目录
			String fileGdPath=preparationFormHelp.getImageAddress().replace("/resource", "D:/file");
			String gdPath=path+fileGdPath.substring(fileGdPath.lastIndexOf("/"));
			Boolean gdBoolean=copFile.copeOneFile(fileGdPath, gdPath);//文件复制成功；
			if(gdBoolean) {
				logger.info("归档文件目录复制成功");
			}else {
				return "归档文件附录复制失败";
			}
			//备考表信息
			String rbkImage=null;
			if(fileBooean) {
				rbkImage=preparationFormHelp.getBkImage();//原来备考表的绝对路径
				bkPath=path+rbkImage.substring(rbkImage.lastIndexOf("/"));
				bkBoolean=copFile.copeOneFile(rbkImage, bkPath);
				if(fileBooean) {
					logger.info("备考表已上传复制成功");
				}else {
					return "备考表复制失败";
				}
			}
			//盒面盒脊
			boxSideBoxRidge=new BoxSideBoxRidge();
			boxSideBoxRidge.setAmmasmretentionperiod(preparationFormHelp.getBgName());//保管期限名字
			boxSideBoxRidge.setBoxanual(preparationFormHelp.getAnual());//年度
			boxSideBoxRidge.setBoxendnumber(preparationFormHelp.getBen());//止件号
			boxSideBoxRidge.setBoxnumber(preparationFormHelp.getBoxNumber());//盒号
			boxSideBoxRidge.setBoxstartnumber(preparationFormHelp.getBsn());//起件号
			boxSideBoxRidge.setQuanzongName(preparationFormHelp.getQzName());//全宗名
			boxSideBoxRidge.setQuanzongNumber(preparationFormHelp.getQzNumbar());//全宗号
			boxSideBoxRidge.setSecondryClassFication(preparationFormHelp.getScName());//二级分类名
			String hzInfor=sealTools.boxContent(boxSideBoxRidge, srcImage);
			//组装盒子附件信息
			boxAttachmentHelp.setBoxattachmentBox(hzInfor);
			if(gdBoolean) {
				boxAttachmentHelp.setBoxattachmentFile(gdPath);
			}
			if(fileBooean) {
				boxAttachmentHelp.setBoxattachmentForm(bkPath);
			}
			boxAttachmentHelp.setBoxattachmentId(UUID.randomUUID().toString());
			boxAttachmentHelp.setBoxId(preparationFormHelp.getBoxId());
			boxAttachmentHelp.setBoxYear(preparationFormHelp.getAnual());
			boxAttachmentHelp.setQuanzongId(preparationFormHelp.getQzId());
			boxAttachmentHelp.setRetentionperiodid(preparationFormHelp.getRtId());
			//更新盒子的信息
			String bkImg = null;//复制备考表信息
			String bkInfor=null;
			if(fileBooean) {
				try {
					bkImg=clippiungImage.copyFile(bkPath);
					bkImg=clippiungImage.cutImage(bkImg, bkImg, 250, 810, 2050, 2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				bkInfor=ocrRecognition.havingBKInfor(bkImg);//获取备考表的内容
				clippiungImage.deleteFile(bkImg);
			}
			//组装盒子内容
			saveBoxInfor.setBoxanual(preparationFormHelp.getAnual());//年度
			saveBoxInfor.setBoxendnumber(preparationFormHelp.getBen());//止件号
			saveBoxInfor.setBoxId(preparationFormHelp.getBoxId());//盒子主键
			saveBoxInfor.setBoxnumber(preparationFormHelp.getBoxNumber());//盒号
			saveBoxInfor.setBoxpage(preparationFormHelp.getBoxPages());//可装页数
			String sericalnumber=preparationFormHelp.getQzNumbar()+"-"+preparationFormHelp.getAnual()+"-"+
								archivingFileRecordedMapper.findRetentionCode(preparationFormHelp.getRtId())+"-"+
								preparationFormHelp.getBoxNumber();
			saveBoxInfor.setBoxsericalnumber(sericalnumber);//盒子编号
			if(fileBooean) {
				saveBoxInfor.setBoxsituation(bkInfor);//盒内情况说明
			}
			saveBoxInfor.setBoxstartnumber(preparationFormHelp.getBsn());//起件号
			saveBoxInfor.setBoxthickness(preparationFormHelp.getBpId());//盒子厚度
			saveBoxInfor.setPcId(preparationFormHelp.getPcId());//一级分类主键
			saveBoxInfor.setQuanzongId(preparationFormHelp.getQzId());//全宗主键
			saveBoxInfor.setRetentionperiodid(preparationFormHelp.getRtId());//保管期限主键
			saveBoxInfor.setScId(preparationFormHelp.getScId());//二级分类主键
			//操作数据库
			Integer add=archivingFileRecordedMapper.addBoxAttechment(boxAttachmentHelp);
			Integer upda=archivingFileRecordedMapper.updataBoxInfor(saveBoxInfor);
			//删除多余的图片
			clippiungImage.deleteFile(fileGdPath);//删除归档文件目录
			if(fileBooean) {
				clippiungImage.deleteFile(rbkImage);
			}
			if(add>0&&upda>0) {//添加盒子信息和盒子附件信息
				logger.info("更新盒子信息和盒子附件信息成功");
				return "";
			}else {
				return "更新盒子信息和盒子附件信息失败";
			}
		}
	}
//===================================================================著录列表=================================================
	/**
	 * 根据全宗id查询一级分类
	 */
	@Override
	public List<RecodedTableSelect> findSeelectPc(String quanzongId) {
		return archiveFileRecordedTableMapper.findSelectPc(quanzongId);
	}

	/**
	 * 获取年度
	 */
	@Override
	public List<String> findSelectAnual(String quanzongId) {
		List<String> list=archiveFileRecordedTableMapper.findSelectAnual(quanzongId);
		return list;
	}

	/**
	 * 著录列表
	 */
	@Override
	public Layui havingAmCoBoxByQuanzongId(String quanzongId, Integer limit, Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin=(page-1)*limit+1;
		Integer end=page*limit;
		map.put("quanzongId", quanzongId);
		map.put("begin", begin);
		map.put("end", end);
		List<AmCoBox> data=archiveFileRecordedTableMapper.findAmCoBoxByQuanzongId(map);
		Integer count=archiveFileRecordedTableMapper.countAmCoBoxByQuanzongId(quanzongId);
		return new Layui().data(count, data);
	}

	/**
	 * select 著录列表
	 */
	@Override
	public Layui havingAmCoBoxBySelect(String quanzongId, SelectQueryHelp selectQueryHelp, Integer limit,
			Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin=(page-1)*limit+1;
		Integer end=page*limit;
		map.put("quanzongId", quanzongId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("pcId", selectQueryHelp.getPcId());//一级分类主键
		map.put("anual", selectQueryHelp.getAnual());//年度
		map.put("start", selectQueryHelp.getStart());//状态
		List<AmCoBox> data=archiveFileRecordedTableMapper.findAmCoBoxBySelect(map);
		Integer count=archiveFileRecordedTableMapper.countAmCoBoxBySelect(map);
		return new Layui().data(count, data);
	}

	//条件 著录列表
	@Override
	public Layui havingAmCoBoxByCondition(String quanzongId, String condition, Integer limit, Integer page) {
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin=(page-1)*limit+1;
		Integer end=page*limit;
		map.put("quanzongId", quanzongId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("condition", condition);
		List<AmCoBox> data=archiveFileRecordedTableMapper.findAmCoBoxByCondition(map);
		Integer count=archiveFileRecordedTableMapper.countAmCoBoxByCondition(map);
		return new Layui().data(count, data);
	}

	/**
	 * 删除 盒子文件
	 */
	@Override
	public Boolean deleteBox(String boxId) {
		CopeFileTool cTool=new CopeFileTool();
		//删除服务器文件附件
		List<String> listFileAttachPath=archiveFileRecordedTableMapper.havingFileAttachByBoxId(boxId);//获取盒子下文件附件的地址
		if(listFileAttachPath.size()>0) {
			String fileAttachPath=listFileAttachPath.get(0).substring(0, listFileAttachPath.get(0).lastIndexOf("/"));//获取文件附件的
			Boolean delA=cTool.deleteFile(fileAttachPath);//删除
			if(delA) {
				logger.info("附件删除成功");
			}else {
				logger.info("附件删除失败");
				return false;
			}
			String fileAttachParent=fileAttachPath.substring(0,fileAttachPath.lastIndexOf("/"));//获取附件的父级文件夹
			File[] files=new File(fileAttachParent).listFiles();
			if(files.length>0) {
				logger.info("文件夹下存在其他文件");
			}else {
				Boolean delPa=cTool.deleteFile(fileAttachParent);//删除
				if(delPa) {
					logger.info("附件父级文件夹删除成功");
				}else {
					logger.info("附件父级文件夹删除失败");
					return false;
				}
			}
			//删除文件和文件附件
			Boolean delFa=archiveFileRecordedTableMapper.deleteFileAttachByBoxId(boxId);
			if(delFa) {
				logger.info("数据库文件附件删除成功");
			}else {
				logger.info("数据库文件附件删除失败");
				return false;
			}
		}
		Boolean delF=archiveFileRecordedTableMapper.deleteFileByBoxId(boxId);
		if(delF) {
			logger.info("数据库文件删除成功");
		}else {
			logger.info("数据库文件删除失败");
			return false;
		}
		//删除盒子附件
		AmCoBoxattachment amca=archiveFileRecordedTableMapper.havingBoxAttachByBoxId(boxId);//获取盒子附件的信息
		logger.error("盒子的附件："+amca);
		String boxAttachParent=amca.getBoxattachmentFile().substring(0, amca.getBoxattachmentFile().lastIndexOf("/"));//获取盒子附件的父文件夹
		Boolean delBoxA=cTool.deleteFile(boxAttachParent);
		if(delBoxA) {
			logger.info("删除盒子附件成功");
		}else {
			logger.info("删除盒子信息失败");
		}
		Boolean delBa=archiveFileRecordedTableMapper.deleteBoxAttachByBoxId(boxId);
		if(delBa) {
			logger.info("数据库盒子附件信息删除成功");
		}else {
			logger.info("数据库盒子附件信息删除失败");
			return false;
		}
		Boolean delB=archiveFileRecordedTableMapper.deleteBoxByBoxId(boxId);
		if(delB) {
			logger.info("盒子信息删除成功");
			return true;
		}else {
			logger.info("盒子信息删除失败");
			return true;
		}
	}

	/**
	 * 统计盒子和文件的数量
	 */
	@Override
	public RecordedTableCountHelp havingFileAmCoBoxByQuanzongId(String quanzongId, Integer limit, Integer page) {
		return new RecordedTableCountHelp(archiveFileRecordedTableMapper.countAmCoBoxByQuanzongId(quanzongId),
				archiveFileRecordedTableMapper.countFileAmCoBoxByQuanzongId(quanzongId));
	}

	/**
	 *select  统计盒子和文件的数量
	 */
	@Override
	public RecordedTableCountHelp havingFileAmCoBoxBySelect(String quanzongId, SelectQueryHelp selectQueryHelp) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("quanzongId", quanzongId);
		map.put("pcId", selectQueryHelp.getPcId());//一级分类主键
		map.put("anual", selectQueryHelp.getAnual());//年度
		map.put("start", selectQueryHelp.getStart());//状态
		return new RecordedTableCountHelp(archiveFileRecordedTableMapper.countAmCoBoxBySelect(map),
				archiveFileRecordedTableMapper.countFileAmCoBoxBySelect(map));
	}

	/**
	 *condition  统计盒子和文件的数量
	 */
	@Override
	public RecordedTableCountHelp havingFileAmCoBoxByCondition(String quanzongId, String condition) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("quanzongId", quanzongId);
		map.put("condition", condition);
		return new RecordedTableCountHelp(archiveFileRecordedTableMapper.countAmCoBoxByCondition(map),
				archiveFileRecordedTableMapper.countFileAmCoBoxByCondition(map));
	}

	/**
	 * 提交进馆
	 */
	@Override
	public Boolean updateBoxStart(String str) {
		str=str.substring(0, str.length()-1);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("str", str.split(","));
		return archiveFileRecordedTableMapper.updateBoxStart(map);
	}

	/**
	 * 查询盒子信息
	 */
	@Override
	public AmCoBox findAmCoBoxByBoxId(String boxId) {
		return recordedEditMapper.findAmCoBoxByBoxId(boxId);
	}

	/**
	 * 添加备考表
	 */
	@Override
	public String updateAmCoBoxattachment(MultipartFile file, String boxId) {
		AmCoBox box=recordedEditMapper.findAmCoBoxByBoxId(boxId);
		if(file!=null) {
			String path="D:/file/"+box.getArchive().getQuanzongNumber()+"/"+
					box.getBoxanual()+"/"+box.getBoxnumber();//全宗号/年度/盒号
			String fileName=file.getOriginalFilename();//获取文件名
			File dir=new File(path,fileName);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			try {
				file.transferTo(dir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String formAddress=path+"/"+fileName;
			Boolean result=recordedEditMapper.updateAmCoBoxattachment(formAddress, boxId);
			if(result) {
				return formAddress;
			}else {
				return "";
			}
		}else {
			return "";
		}
	}

	/**
	 * 备考表地址
	 */
	@Override
	public String havingBoxForm(String boxId) {
		return recordedEditMapper.havingBoxForm(boxId);
	}


	@Override
	public String saveBox(PreparationFormHelp preparationFormHelp, String srcImage) {
		SealTools sealTools=new SealTools();//水印
		AmCoBoxattachment amca=archiveFileRecordedTableMapper.havingBoxAttachByBoxId(preparationFormHelp.getBoxId());//获取盒子附件的信息
		AmCoBox boxInfor=null;
		boxInfor=findAmCoBoxByBoxId(preparationFormHelp.getBoxId());//获取盒子信息
		String path="D:/file/"+preparationFormHelp.getQzNumbar()+"/"+
				preparationFormHelp.getAnual()+"/"+preparationFormHelp.getBoxNumber();//盒子附件保存地址（file+全宗号+年度+盒号）
		File filePath=new File(path);
		if(!filePath.exists()) {//文件夹不存在
			filePath.mkdirs();//创建文件夹
		}
		String ataFile=amca.getBoxattachmentFile();//获取归档文件目录绝对路径
		String ataFileName=ataFile.substring(ataFile.lastIndexOf("/"));//获取归档文件目录的名字
		String ataForm=amca.getBoxattachmentForm();//获取备考表绝对路径
		if(ataForm==null||ataForm=="") {
			ataForm=preparationFormHelp.getBkImage();
		}
		String ataFormName=ataForm.substring(ataForm.lastIndexOf("/"));//获取备考表的名字
		CopeFileTool copFile=new CopeFileTool();//复制工具
		Boolean gdBoolean=copFile.copeOneFile(ataFile, path+"/"+ataFileName);//归档文件复制
		Boolean pkBoolean=copFile.copeOneFile(ataForm, path+"/"+ataFormName);//备考表复制
		if(!gdBoolean&&!pkBoolean) {
			return "备考表或归档文件目录未成功复制";
		}
		System.err.println(ataForm+":"+ataFormName);
		//生成盒面盒脊
		BoxSideBoxRidge boxSideBoxRidge=new BoxSideBoxRidge();
		boxSideBoxRidge.setAmmasmretentionperiod(preparationFormHelp.getBgName());//保管期限名字
		boxSideBoxRidge.setBoxanual(preparationFormHelp.getAnual());//年度
		boxSideBoxRidge.setBoxendnumber(preparationFormHelp.getBen());//止件号
		boxSideBoxRidge.setBoxnumber(preparationFormHelp.getBoxNumber());//盒号
		boxSideBoxRidge.setBoxstartnumber(preparationFormHelp.getBsn());//起件号
		boxSideBoxRidge.setQuanzongName(preparationFormHelp.getQzName());//全宗名
		boxSideBoxRidge.setQuanzongNumber(preparationFormHelp.getQzNumbar());//全宗号
		boxSideBoxRidge.setSecondryClassFication(preparationFormHelp.getScName());//二级分类名
		String hzInfor=sealTools.boxContent(boxSideBoxRidge, srcImage);
		
		
		//保存盒子附件信息
		BoxAttachmentHelp boxAttachmentHelp=new BoxAttachmentHelp();//盒子附件信息
		boxAttachmentHelp.setBoxattachmentFile(path+ataFileName);//归档文件目录
		boxAttachmentHelp.setBoxattachmentBox(hzInfor);//盒面盒脊
		boxAttachmentHelp.setBoxattachmentForm(path+ataFormName);//备考表
		boxAttachmentHelp.setBoxYear(preparationFormHelp.getAnual());//年度
		boxAttachmentHelp.setBoxattachmentId(amca.getBoxattachmentId());//盒子附件的主键
		boxAttachmentHelp.setBoxId(amca.getBoxId());//盒号
		boxAttachmentHelp.setQuanzongId(preparationFormHelp.getQzId());//全宗主键
		boxAttachmentHelp.setRetentionperiodid(preparationFormHelp.getRtId());//保管期限
		
		//获取备考表中的数据
		ClippiungImage clippiungImage=new ClippiungImage();//处理图片
		OcrRecognition ocrRecognition=new OcrRecognition();//ocr识别
		String bkImg = null;//复制备考表信息
		String bkInfor=null;
		try {
			bkImg=clippiungImage.copyFile(path+ataFormName);
			bkImg=clippiungImage.cutImage(bkImg, bkImg, 250, 810, 2045, 2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bkInfor=ocrRecognition.havingBKInfor(bkImg);//获取备考表的内容
		
		//保存盒子信息
		SaveBoxInfor saveBoxInfor=new SaveBoxInfor();//保存盒子信息
		saveBoxInfor.setBoxanual(preparationFormHelp.getAnual());//年度
		saveBoxInfor.setBoxendnumber(preparationFormHelp.getBen());//止件号
		saveBoxInfor.setBoxId(preparationFormHelp.getBoxId());//盒子主键
		saveBoxInfor.setBoxnumber(preparationFormHelp.getBoxNumber());//盒号
		saveBoxInfor.setBoxpage(preparationFormHelp.getBoxPages());//可装页数
		String sericalnumber=preparationFormHelp.getQzNumbar()+"-"+preparationFormHelp.getAnual()+"-"+
							archivingFileRecordedMapper.findRetentionCode(preparationFormHelp.getRtId())+"-"+
							preparationFormHelp.getBoxNumber();
		saveBoxInfor.setBoxsericalnumber(sericalnumber);//盒子编号
		saveBoxInfor.setBoxsituation(bkInfor);//盒内情况说明
		saveBoxInfor.setBoxstartnumber(preparationFormHelp.getBsn());//起件号
		saveBoxInfor.setBoxthickness(preparationFormHelp.getBpId());//盒子厚度
		saveBoxInfor.setPcId(preparationFormHelp.getPcId());//一级分类主键
		saveBoxInfor.setQuanzongId(preparationFormHelp.getQzId());//全宗主键
		saveBoxInfor.setRetentionperiodid(preparationFormHelp.getRtId());//保管期限主键
		saveBoxInfor.setScId(preparationFormHelp.getScId());//二级分类主键
		
		
		
		
		
		if(preparationFormHelp.getAnual().equals(boxInfor.getBoxanual())//年度
				&&preparationFormHelp.getBen().equals(boxInfor.getBoxendnumber())//止件号
				&&preparationFormHelp.getBoxNumber().equals(boxInfor.getBoxnumber())//盒号一致
				&&preparationFormHelp.getBoxPages().equals(boxInfor.getBoxpage())//可装页数
				&&preparationFormHelp.getBsn().equals(boxInfor.getBoxstartnumber())//起件号
				&&preparationFormHelp.getPcId().equals(boxInfor.getPrimaryClassFication().getPcId())//一级分类主键
				&&preparationFormHelp.getQzId().equals(boxInfor.getArchive().getQuanzongId())//全宗号相同
				&&preparationFormHelp.getRtId().equals(boxInfor.getRetentionperiod().getRetentionperiodid())//保管期限
				&&preparationFormHelp.getScId().equals(boxInfor.getSecondryClassFication().getScId())//二级分类主键
				) 
		{//盒子信息没改变
			logger.info("盒子信息没改变");
		}else {//盒子信息改变
			AmCoBox emptBox=archivingFileRecordedMapper.findAmCoBoxByCondition(preparationFormHelp);//新的信息
			if(emptBox!=null) {//盒子的相关信息存在
				return "盒子已存在";
			}else {
				
				CopeFileTool cTool=new CopeFileTool();
				String deletePath=ataFile.substring(0, ataFile.lastIndexOf("/"));
				Boolean delBoxA=cTool.deleteFile(deletePath);//删除盒号下所有文件
				
			}
		}
		//操作数据库
		Boolean updateBoxAtta=recordedEditMapper.updateAllAmCoBoxattachment(boxAttachmentHelp);
		Boolean upda=archivingFileRecordedMapper.updataBoxInfor(saveBoxInfor)>0;
		clippiungImage.deleteFile(bkImg);
		if(updateBoxAtta&&upda) {
			logger.info("数据库更新成功");
			return "";
		}else {
			return "数据库更新失败";
		}
	}
	
	/**
	 * 获取历史数据内容
	 * @param listFile
	 * @param path
	 */
	public Map<String, Object> havingHistory(List<String> listFile,String path) {
		Map<String, Object> map=new HashMap<String, Object>();
		PressureAndDecompression pAndDecompression=new PressureAndDecompression();//历史数据工具
		List<HistoryData> listHistoryData=new ArrayList<HistoryData>();//历史数据
		List<HistoryAnnex> listHistoryAnnex=new ArrayList<HistoryAnnex>();//历史数据附件
		List<List> listIni=null;//读取ini文件
		List<List> listTxt=null;//读取txt文件
		List<String> listPath=null;//历史数据文件附件
		HistoryData historyData=null;//历史数据
		HistoryAnnex historyAnnex=null;//历史数据附件
		String pathname=null;//文件附件地址
		String pathFile=null;//文件附件保存地址
		Integer size=null;//text文件每行数字的数量
		for (String string : listFile) {//获取ini文件内容
         	if("ini".equals(string.substring(string.lastIndexOf("."))));{
         		listIni=pAndDecompression.readFile(path+"/"+string);
         		break;
         	}
		}
		for (String string : listFile) {//获取txt文件内容
			if("txt".equals(string.substring(string.lastIndexOf(".")+1).toLowerCase())) {//后缀转化为小写
				listTxt=pAndDecompression.readFile(path+"/"+string);
				break;
			}
		}
		for(int i=0;i<listTxt.size();i++) {
			historyData=new HistoryData();//实例化历史数据
        	pathname=pAndDecompression.havingFile(listFile, listTxt.get(i).get(listTxt.get(i).size()-1).toString());
        	pathname=path+"/"+pathname;
        	//组装历史数据
        	size = listTxt.get(i).size();
    		String historydataId=UUID.randomUUID().toString();//文件的主键
    		if(pathname!=null) {//压缩文件存在
    			pathFile=pathname.substring(0, pathname.lastIndexOf("."));//获取文件附件的保存地址
				listPath=pAndDecompression.decompressionZipFile(pathname, pathFile);//获取文件附件绝对路径
				
				//通用历史数据
				historyData.setHistorydataId(historydataId);//历史数据主键
				historyData.setHistorydataTitle(listTxt.get(i).get(1).toString());//题名
				if("75".equals(listTxt.get(i).get(0))) {//75个音乐符：存在文号
					historyData.setHistorydataReferencenumber(listTxt.get(i).get(2).toString());//文号
					historyData.setHistorydataAFResponsible(listTxt.get(i).get(3).toString());//责任者
					historyData.setHistorydataFiledate(listTxt.get(i).get(4).toString());//成文日期
					historyData.setHistorydataSecurityLevel(listTxt.get(i).get(5).toString());//密级
					historyData.setHistorydataPages(listTxt.get(i).get(6).toString());//页数
					String historydataType=listTxt.get(i).get(7).toString();//一级分类名称
					historyData.setHistorydataType(historydataType);//一级分类名称
					String quanzongNumber=listTxt.get(i).get(8).toString();
					historyData.setQuanzongNumber(quanzongNumber);//全宗号
					historyData.setQuanzongName(hisoryDataMapper.queryQuanzongName(quanzongNumber));//全宗名
					historyData.setRetentionperiodName(listTxt.get(i).get(9).toString());//保管期限名称
					historyData.setHistorydataArchivalYear(listTxt.get(i).get(10).toString());//过当文件年度
					historyData.setOrganizationName(listTxt.get(i).get(11).toString());//机构问题分类名称
					historyData.setHistorydataPartNumber(listTxt.get(i).get(12).toString());//件号
					historyData.setRetentionperiodCode(listTxt.get(i).get(13).toString());//保管期限代码
					historyData.setOrganizationCode(listTxt.get(i).get(14).toString());//机构问题代码
					historydataType=historydataType.substring(0, historydataType.length()-2);
					String historydataTypecode=PinTinTools.getPinYinHeadChar(historydataType);
					historydataTypecode=historydataTypecode.toUpperCase(); 
					String historydataNumber=listTxt.get(i).get(8).toString()+"-"+historydataTypecode+"·"+listTxt.get(i).get(10).toString()+
							"-"+listTxt.get(i).get(13).toString()+"-"+listTxt.get(i).get(14).toString()+"-"+listTxt.get(i).get(12).toString();
					historyData.setHistorydataNumber(historydataNumber);//档号
					if("17".equals(size.toString())) {//每行数据数量为17:存在文本项
						historyData.setHistorydataTextitem(listTxt.get(i).get(15).toString());//文本项
	        		}
				}else if("74".equals(listTxt.get(i).get(0))) {//74个音乐符：不存在文号
					historyData.setHistorydataAFResponsible(listTxt.get(i).get(2).toString());//责任者
					historyData.setHistorydataFiledate(listTxt.get(i).get(3).toString());//成文日期
					historyData.setHistorydataSecurityLevel(listTxt.get(i).get(4).toString());//密级
					historyData.setHistorydataPages(listTxt.get(i).get(5).toString());//页数
					String historydataType=listTxt.get(i).get(6).toString();//一级分类名称
					historyData.setHistorydataType(historydataType);//一级分类名称
					String quanzongNumber=listTxt.get(i).get(7).toString();
					historyData.setQuanzongNumber(quanzongNumber);//全宗号
					historyData.setQuanzongName(hisoryDataMapper.queryQuanzongName(quanzongNumber));//全宗名
					historyData.setRetentionperiodName(listTxt.get(i).get(8).toString());//保管期限名称
					historyData.setHistorydataArchivalYear(listTxt.get(i).get(9).toString());//过当文件年度
					historyData.setOrganizationName(listTxt.get(i).get(10).toString());//机构问题分类名称
					historyData.setHistorydataPartNumber(listTxt.get(i).get(11).toString());//件号
					historyData.setRetentionperiodCode(listTxt.get(i).get(12).toString());//保管期限代码
					historyData.setOrganizationCode(listTxt.get(i).get(13).toString());//机构问题代码
					historydataType=historydataType.substring(0, historydataType.length()-2);
					String historydataTypecode=PinTinTools.getPinYinHeadChar(historydataType);
					historydataTypecode=historydataTypecode.toUpperCase(); 
					String historydataNumber=listTxt.get(i).get(7).toString()+"-"+historydataTypecode+"·"+listTxt.get(i).get(9).toString()+
							"-"+listTxt.get(i).get(12).toString()+"-"+listTxt.get(i).get(13).toString()+"-"+listTxt.get(i).get(11).toString();
					historyData.setHistorydataNumber(historydataNumber);//档号
					if("16".equals(size.toString())) {//每行数据数量为17:存在文本项
						historyData.setHistorydataTextitem(listTxt.get(i).get(14).toString());//文本项
	        		}
				}
				listHistoryData.add(historyData);//历史数据添加到集合中
				for(int m=0;m<listPath.size();m++) {
					historyAnnex=new HistoryAnnex();
					String historyannexPath=pathFile+"/"+listPath.get(m);//历史数据附件的绝对路径
					String historyannexName=listPath.get(m);//历史数据名字
					String historyannexId=UUID.randomUUID().toString();
					historyAnnex.setHistoryannexId(historyannexId);
					historyAnnex.setHistoryannexName(historyannexName);
					historyAnnex.setHistoryannexPath(historyannexPath);
					historyAnnex.setHistorydataId(historydataId);
					listHistoryAnnex.add(historyAnnex);
				}
    		}
    		
		}
		for(HistoryData data:listHistoryData) {
			System.err.println(data);
		}
		map.put("historyData", listHistoryData);
		map.put("historyAnnex", listHistoryAnnex);
		return map;
	}


	@Override
	public String expectHistory(String ids, String remark)throws Exception {
		List<ExportHistoryHelp> listFile=null;
		ExportHistoryHelp exportHistoryHelp=null;
		List<String> historyList=null;//接收文件附件
		String deletePath="D:/file/expectTT";
		String historyPath="D:/file/expectTT/敦煌泰坦.zip";
		String[] contentTxt=null;//接收txt文件内容
		String[] contentIni=null;//接收ini文件内容
		String[] id=ids.split(",");
		String modelOne="D:/file/model/modeOne.txt";//存在文号和文本项
		String modelTwo="D:/file/model/modeTwo.txt";//存在文号不存在文本项
		String modelThree="D:/file/model/modeThree.txt";//不存在存在文号和文本项
		String modelFour="D:/file/model/modeFour.txt";//不存在存在文号和不存在文本项
		if("1".equals(remark)) {//是新建文件
			listFile=expectHistoryMapper.queryFile(id);
			historyList=new ArrayList<String>();
			contentTxt=new String[listFile.size()];
			contentIni=new String[8];
			List<String> listContent=null;//接收文件内容
			List<String> listSymbl=null;//接收特殊符号
			List<String> pathList=null;//接收文件附件
			String srcPath="D:/file/expectTT/敦煌泰坦/归档文件管理/1/Media";
			String srepath=null;
			String pathnameTxt="D:/file/expectTT/敦煌泰坦/归档文件管理/1/GD.Txt";
			String pathnameIni="D:/file/expectTT/敦煌泰坦/handover.ini";
			Integer index=ZipHistoryTools.havingIndex(listFile.size());//获取随机起始位置
			//组装txt文件内容
			for (int i=0;i<listFile.size();i++) {
				exportHistoryHelp=listFile.get(i);
				String pageNumber=exportHistoryHelp.getExpectPartNumber();//获取档号
				System.out.println("#####"+pageNumber);
				pageNumber.substring(pageNumber.lastIndexOf("-"), pageNumber.length());//获取件号
				exportHistoryHelp.setExpectPartNumber(pageNumber);//组装件号
				if(exportHistoryHelp.getExpectNumbering()!=null) {//存在文号不存在文本项
					pathList=expectHistoryMapper.findFile(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelTwo);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectNumbering());//文号
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}else {//不存在文号不存在文本项
					pathList=expectHistoryMapper.findFile(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelFour);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}
				index=index+i+1;
			}
			//组装ini文件内容
			
			contentIni[0]="[归档文件管理]";
			contentIni[1]="MainTable=GDMT";
			contentIni[2]="User=sysdba";
			contentIni[3]="Time="+ZipHistoryTools.havingTime();
			contentIni[4]="Des=";
			contentIni[5]="rowCount="+listFile.size();
			contentIni[6]="Type=darms";
			contentIni[7]="SubTable=";
			ZipHistoryTools.writerTxt(contentTxt, pathnameTxt);
			ZipHistoryTools.writerIni(contentIni, pathnameIni);
			historyList.add("D:/file/expectTT/敦煌泰坦/归档文件管理");
			historyList.add("D:/file/expectTT/敦煌泰坦/handover.ini");
			ZipHistoryTools.zip(historyList, historyPath);
			
			return historyPath;
		}else{//是历史数据
			listFile=expectHistoryMapper.queryHistory(id);
			System.err.println(listFile.size());
			historyList=new ArrayList<String>();
			contentTxt=new String[listFile.size()];
			contentIni=new String[8];
			List<String> listContent=null;//接收文件内容
			List<String> listSymbl=null;//接收特殊符号
			List<String> pathList=null;//接收文件附件
			String srcPath="D:/file/expectTT/敦煌泰坦/归档文件管理/1/Media";
			String srepath=null;
			String pathnameTxt="D:/file/expectTT/敦煌泰坦/归档文件管理/1/GD.Txt";
			String pathnameIni="D:/file/expectTT/敦煌泰坦/handover.ini";
			Integer index=ZipHistoryTools.havingIndex(listFile.size());//获取随机起始位置
			//组装txt文件内容
			for (int i=0;i<listFile.size();i++) {
				exportHistoryHelp=listFile.get(i);
				if(exportHistoryHelp.getExpectNumbering()!=null&&exportHistoryHelp.getExpectTextItem()!=null) {//存在文号存在文本项
					pathList=expectHistoryMapper.findHistory(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelOne);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectNumbering());//文号
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(exportHistoryHelp.getExpectTextItem());//文本项
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}else if(exportHistoryHelp.getExpectNumbering()==null&&exportHistoryHelp.getExpectTextItem()!=null){//不存在文号存在文本项
					pathList=expectHistoryMapper.findHistory(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelThree);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(exportHistoryHelp.getExpectTextItem());//文本项
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}else if(exportHistoryHelp.getExpectNumbering()!=null&&exportHistoryHelp.getExpectTextItem()==null){//存在文号不存在文本项
					pathList=expectHistoryMapper.findHistory(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelTwo);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectNumbering());//文号
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}else if(exportHistoryHelp.getExpectNumbering()==null&&exportHistoryHelp.getExpectTextItem()==null){//不存在文号不存在文本项
					pathList=expectHistoryMapper.findHistory(exportHistoryHelp.getFileId());//根据文件的id获取文件附件集合
					srepath=srcPath+"/"+index+"_1.zip";//底层压缩包名称
					ZipHistoryTools.zip(pathList, srepath);//压缩底层压缩包
					listSymbl=ZipHistoryTools.readModelFile(modelFour);//获取模式内容
					//组装每行文件的内容
					listContent=new ArrayList<String>();
					listContent.add(exportHistoryHelp.getExpectTitle());//题名
					listContent.add(exportHistoryHelp.getExpectRPerson());//责任者
					listContent.add(exportHistoryHelp.getExpectWrittenDate());//成文日期
					listContent.add(exportHistoryHelp.getExpectSecretLevel());//密级
					listContent.add(exportHistoryHelp.getExpectPages());//页数
					listContent.add(exportHistoryHelp.getExpectTypeName());//档案类型
					listContent.add(exportHistoryHelp.getExpectArchiveNumber());//全宗号
					listContent.add(exportHistoryHelp.getExpectSTimeName());//保管期限名称
					listContent.add(exportHistoryHelp.getExpectAnual());//归档年度
					listContent.add(exportHistoryHelp.getExpectSCName());//二级分类名称
					listContent.add(exportHistoryHelp.getExpectPartNumber());//件号
					listContent.add(exportHistoryHelp.getExpectSTimeCode());//保管期限代码
					listContent.add(exportHistoryHelp.getExpectSCCode());//二级分类代码
					listContent.add(index.toString());//底层包编号
					contentTxt[i]=ZipHistoryTools.lineComposition(listContent, listSymbl);
				}
				index=index+i+1;
			}
			//组装ini文件内容
			
			contentIni[0]="[归档文件管理]";
			contentIni[1]="MainTable=GDMT";
			contentIni[2]="User=sysdba";
			contentIni[3]="Time="+ZipHistoryTools.havingTime();
			contentIni[4]="Des=";
			contentIni[5]="rowCount="+listFile.size();
			contentIni[6]="Type=darms";
			contentIni[7]="SubTable=";
			ZipHistoryTools.writerTxt(contentTxt, pathnameTxt);
			ZipHistoryTools.writerIni(contentIni, pathnameIni);
			historyList.add("D:/file/expectTT/敦煌泰坦/归档文件管理");
			historyList.add("D:/file/expectTT/敦煌泰坦/handover.ini");
			ZipHistoryTools.zip(historyList, historyPath);
			
		
			return historyPath;
		}
	}

	/**
	 * 手动著录盒子信息
	 */
	@Override
	public String saveBoxs(HttpServletRequest request) {
		String anual = request.getParameter("anual");
		String boxAuditstart = request.getParameter("boxAuditstart");
		String boxBoxingStart = request.getParameter("boxBoxingStart");
		String boxendnumber = request.getParameter("boxendnumber");
		String boxid = request.getParameter("boxid");
		String boxstartnumber = request.getParameter("boxstartnumber");
		String boxstatus = request.getParameter("boxstatus");
		String pcId = request.getParameter("pcId");
		String quanZongId = request.getParameter("quanZongId");
		String retentionperiodid = request.getParameter("retentionperiodid");
		String scId = request.getParameter("scId");
		String boxcasesnumber = request.getParameter("boxCasesnumber");
		BoxAddHelp boxAddHelp = new BoxAddHelp();
		boxAddHelp.setAnual(anual);
		boxAddHelp.setBoxAuditstart(boxAuditstart);
		boxAddHelp.setBoxBoxingStart(boxBoxingStart);
		boxAddHelp.setBoxendnumber(boxendnumber);
		boxAddHelp.setBoxid(boxid);
		boxAddHelp.setBoxstartnumber(boxstartnumber);
		boxAddHelp.setBoxstatus(boxstatus);
		boxAddHelp.setPcId(pcId);
		boxAddHelp.setQuanZongId(quanZongId);
		boxAddHelp.setRetentionperiodid(retentionperiodid);
		boxAddHelp.setScId(scId);
		boxAddHelp.setBoxcasesnumber(boxcasesnumber);
		// TODO Auto-generated method stub
		String msg = "";
		if(archivingFileRecordedMapper.selectCount(boxAddHelp)>0) {
			msg = "{msg:'盒子已创建，请注入文件！'}";
		}else {
			if(archivingFileRecordedMapper.addBoxInfor(boxAddHelp)>0) {
				//起件号
				Integer boxStartNumber = Integer.parseInt(boxAddHelp.getBoxstartnumber().replaceAll("^(0+)", ""));
				//止件号
				Integer boxEndNumber = Integer.parseInt(boxAddHelp.getBoxendnumber().replaceAll("^(0+)", ""));
				Integer boxNum = boxEndNumber-boxStartNumber;
				List<ArchiveFileAddHelp> listArchiveFiles = new ArrayList<>();
				for (int i = 0; i <= boxNum; i++) {
					//生成文件UUID
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					ArchiveFileAddHelp files = new ArchiveFileAddHelp();
					files.setArchiveFileId(uuid);
					files.setQuanZongId(quanZongId);
					files.setPcId(pcId);
					files.setScId(scId);
					files.setRetentionperiodid(retentionperiodid);
					files.setAnual(anual);
					files.setBoxid(boxid);
					files.setArchiveFileIsUpload("1");
					listArchiveFiles.add(files);
				}
				if(archivingFileRecordedMapper.addArchiveFile(listArchiveFiles) > 0) {
					msg = "{msg:'盒子与文件创建成功！'}";
				}else {
					msg = "{msg:'文件创建失败！'}";
				}
				
			}else {
				msg = "{msg:'盒子创建失败！'}";
			}
		}
		return msg;
	}
}
