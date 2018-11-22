package filemanage.collectandorganize.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.ArchiveFileStoreService;
import filemanage.collectandorganize.vo.SaveArchiveFileHelp;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.utils.ocr.OCRSample;
import filemanage.utils.page.PageBean;
import filemanage.utils.sortTool.SortTool;

/**
 * @author meng
 *文件修改控制层
 */
@RequestMapping("/archiveFileStoreModify")
@Controller
public class ArchiveFileStoreModifyController {
	private Logger log=Logger.getLogger(ArchiveFileStoreModifyController.class);
	@Autowired
	private ArchiveFileStoreService archiveFileStoreService;
	private User user;
	/**
	 * 页面跳转文件编辑页面
	 * @param archiveFileId 文件主键
	 * @param currentPage 当前页面 默认第一页
	 * @return 文件集合信息
	 */
	@RequestMapping(value="/goArchiveFileStoreEdit",method=RequestMethod.GET)
	public ModelAndView goArchiveFileStoreEdit(@RequestParam("archiveFileId")String archiveFileId,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage) {
		ModelAndView modelAndView=new ModelAndView();
		user=HavingUserInfor.havingUser();
		log.info("监听到文件编辑中用户的信息为:"+user);
		modelAndView.addObject("archiveFile", archiveFileStoreService.queryArchiveFileByArchiveFileId(archiveFileId));
		modelAndView.addObject("pagemsg", archiveFileStoreService.queryFileAttachmentByArchiveFileIdPages(archiveFileId, currentPage));
		modelAndView.setViewName("archiveFileStore/edit");
		return modelAndView;
	}
	/**
	 * 获取文件附件信息
	 * @param archiveFileId 文件主键
	 * @param currentPage 当前 也鼠标
	 * @return 文件集合信息
	 */
	@RequestMapping(value="/havingFileAttachment")
	public @ResponseBody PageBean<FileAttachment> havingFileAttachment(@RequestParam("archiveFileId")String archiveFileId,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage){
		log.info("监听到传入的参数：archiveFileId="+archiveFileId+"currentPage="+currentPage);
		PageBean<FileAttachment> pagemsg=archiveFileStoreService.queryFileAttachmentByArchiveFileIdPages(archiveFileId, currentPage);
		log.info("监听到返回的参数是："+pagemsg);
		return pagemsg;
	}
	/**
	 * 不选择插入位置添加图片
	 * @param files 文件集合
	 * @param archiveFileId 文件的id
	 * @return 是否添加成功
	 * @throws Exception 文件流抛出异常
	 */
	@RequestMapping(value="/lastIndex")
	public @ResponseBody Boolean joinLastIndex(@RequestParam("image") MultipartFile[] files,@RequestParam("archiveFileId")String archiveFileId)throws Exception {
		
		log.info("开始上传图片"+archiveFileId+"文件的长度为:"+files.length);
		Boolean lock=false;
		ArchiveFile archiveFile=archiveFileStoreService.queryArchiveFileByArchiveFileId(archiveFileId);//获取文件信息
		log.info("监听到文件的信息为:"+archiveFile);
		String path=archiveFileStoreService.queryFileAttachmentPathByArchiveFileId(archiveFileId);//获取文件保存路径
		log.info("监听到文件的保存位置为:"+path);
		Integer countPagesInt=archiveFileStoreService.countFileAttachmentByArchiveFileIdPages(archiveFileId);//获取数据库中附件数量
		log.info("监听到原始文件的数量为:"+countPagesInt+"条件");
		if("请文件的正确确认路径".equals(path)) {
			log.info("保存文件路径出现问题：目标文件夹不止一个");
			lock= false;
		}else {
			log.info("目标文件保存路径为："+path);
			if(files!=null) {//文件不为空
				if(files.length==0) {
					log.info("扫描仪文件未上传");
				}else {
					log.info("文件数量为:"+files.length);
					FileAttachment fileAttachment=null;
					for(int i=0;i<files.length;i++) {
						MultipartFile file = files[i];
						String fileName=file.getOriginalFilename();//获取文件名称
						//保存文件到服务器
						File dir=new File(path,fileName);
						if (!dir.exists()) {
							dir.mkdirs();
						}
						file.transferTo(dir);//保存图片
						log.info("第"+(i+1)+"个文件文件名为："+fileName+"已成功保存在服务器路径："+path+"文件夹下");
						//保存文件到数据库
						String countPages=archiveFile.getArchiveFilePages();//获取文件的总数量
						
						fileAttachment=new FileAttachment();//获取文件附件对象
						fileAttachment.setFileAttachmentId(UUID.randomUUID().toString());//设置附件主键
						String archiveId=archiveFile.getArchive().getQuanzongId();
						fileAttachment.setQuanzongId(archiveId);//设置附件所属全宗
						String anual=archiveFile.getArchiveFileAnual();//获取文件年度
						fileAttachment.setFileAttachmentAnual(anual);//设置附近年度
						fileAttachment.setFileAttachmentPath(path+"/"+fileName);//设置保存附件路径
						fileAttachment.setFileAttachmentName(fileName);//设置附件名称
						Integer pageNum=countPagesInt+i+1;//获取附件的页码
						fileAttachment.setFileAttachmentPageNumber(pageNum.toString());//设置附件页码
						fileAttachment.setFileAttachmentMark("0");//设置分封面
						fileAttachment.setArchiveFileId(archiveFileId);//设置文件主键
						fileAttachment.setFileCreator(user.getUserName());//添加用户名
						Boolean res=archiveFileStoreService.addFileAttachment(fileAttachment);//添加附件
						log.info("添加文件附件信息已成功");
						if(!res) {
							lock=false;
							break;
						}else {
							lock=true;
						}
						log.info("第"+(i+1)+"个文件文件名为："+fileName+"已成功保存在数据库");
					}
				}
			}else {
				log.info("上传文件为空，请检查扫描仪");
				lock=false;
			}
		}
		
		return lock;
	}
	@RequestMapping(value="/havingIndex")
	public @ResponseBody Boolean havingIndex(@RequestParam("image") MultipartFile[] files,
			@RequestParam("archiveFileId")String archiveFileId,
			@RequestParam("index")String index)throws Exception {
		Boolean lock=false;
		log.info("插扫开始上传图片"+archiveFileId+":");
		ArchiveFile archiveFile=archiveFileStoreService.queryArchiveFileByArchiveFileId(archiveFileId);//获取文件信息
		log.info("监听到文件的信息为:"+archiveFile);
		String path=archiveFileStoreService.queryFileAttachmentPathByArchiveFileId(archiveFileId);//获取文件保存路径
		log.info("监听到文件的保存位置为:"+path);
		String coverName=new String();
		Integer countPagesInt=archiveFileStoreService.countFileAttachmentByArchiveFileIdPages(archiveFileId);//获取数据库中附件数量
		log.info("监听到原始文件的数量为:"+countPagesInt+"条件");
		List<FileAttachment> list=archiveFileStoreService.queryFileAttachmentAddressByArchiveFileId(archiveFileId);//获取文件附件的集合
		List<String> newPathList=new ArrayList<String>();//新上传文件文件名集合
		List<String> oldPathList=new ArrayList<String>();//新上传文件文件名集合
		if("请文件的正确确认路径".equals(path)) {
			log.info("保存文件路径出现问题：目标文件夹不止一个");
			lock= false;
		}else {
			log.info("目标文件保存路径为："+path);
			if(files!=null) {
				log.info("文件数量为:"+files.length);
				//将文件保存在服务器路径下
				for(int i=0;i<files.length;i++) {
					MultipartFile file = files[i];
					String fileName=file.getOriginalFilename();//获取文件名称
					//保存文件到服务器
					File dir=new File(path,fileName);
					if (!dir.exists()) {
						dir.mkdirs();
					}
					file.transferTo(dir);//保存图片
					newPathList.add(path+"/"+fileName);//文件名集合
					log.info("第"+(i+1)+"个文件文件名为："+fileName+"已成功保存在服务器路径："+path+"文件夹下");
				}
				
				//获取就文件的名集合
				for(FileAttachment fileAttachment:list) {
					oldPathList.add(fileAttachment.getFileAttachmentPath().replace("/resource", "D:/file"));
					if("1".equals(fileAttachment.getFileAttachmentMark())) {
						coverName=fileAttachment.getFileAttachmentPath().replace("/resource", "D:/file");
					}
				}
				log.info("插扫监听到新文件有:"+newPathList.size());
				log.info("插扫监听到旧文件的数量为:"+list.size());
				Integer in=Integer.parseInt(index);
				List<String> newNameList=SortTool.sortMethod(newPathList, oldPathList, in);//获取插入文件后的新的文件的名称
				log.info("插扫监听到文件新附件的数量为:"+newNameList.size());
				archiveFileStoreService.deleteFileAttachment(archiveFileId);//删除文件附件信息
				FileAttachment fileAttachment=null;
				for(int m=0;m<newNameList.size();m++) {
					fileAttachment=new FileAttachment();//获取文件附件对象
					fileAttachment.setFileAttachmentId(UUID.randomUUID().toString());//设置附件主键
					String archiveId=archiveFile.getArchive().getQuanzongId();
					fileAttachment.setQuanzongId(archiveId);//设置附件所属全宗
					String anual=archiveFile.getArchiveFileAnual();//获取文件年度
					fileAttachment.setFileAttachmentAnual(anual);//设置附近年度
					fileAttachment.setFileAttachmentPath(newNameList.get(m));//设置保存附件路径
					fileAttachment.setArchiveFileId(archiveFileId);//设置文件主键
					fileAttachment.setFileAttachmentName(newNameList.get(m).substring(newNameList.get(m).lastIndexOf("/"), newNameList.get(m).length()));//设置文件名称
					Integer me=(m+1);
					fileAttachment.setFileAttachmentPageNumber(me.toString());//设置文件的封面
					if(newNameList.get(m)==coverName) {
						fileAttachment.setFileAttachmentMark("1");
					}else {
						fileAttachment.setFileAttachmentMark("0");
					}
					fileAttachment.setFileCreator(user.getUserName());//添加用户名
					Boolean res=archiveFileStoreService.addFileAttachment(fileAttachment);//添加附件
					if(res) {
						lock=true;
						log.info("第"+(m+1)+"-"+newNameList.size()+"文件"+newNameList.get(m)+"已成功添加数据库");
					}else {
						lock=false;
						break;
					}
				}
				
			}else {
				log.info("上传文件为空，请检查扫描仪");
			}
		}
		return lock;
	}
	/**
	 * 删除图片
	 * @param fileAttachmentPageNumber
	 * @param archiveFileId
	 * @return
	 */
	@RequestMapping(value="/deleteImage",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Boolean deleteImage(@RequestParam("fileAttachmentPageNumber")String fileAttachmentPageNumber,
			@RequestParam("archiveFileId")String archiveFileId) {
		log.info("监听到传入的参数为:当前页面="+fileAttachmentPageNumber+"文件主键="+archiveFileId);
		return archiveFileStoreService.deleteFileAttachment(archiveFileId, fileAttachmentPageNumber);
	}
	/**
	 * 更新文件信息
	 * @param archiveFile
	 * @return
	 */
	@RequestMapping(value="/updateArchiveFile",method=RequestMethod.POST)
	public @ResponseBody Boolean updateArchiveFile(SaveArchiveFileHelp saveArchiveFileHelp) {
		log.info("更新文件的信息"+saveArchiveFileHelp);
		return archiveFileStoreService.updateArchiveFileByArchiveFileId(saveArchiveFileHelp);
	}
	/**
	 * ocr识别
	 * @param imgPath
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/imageRecognize",method=RequestMethod.POST)
	public@ResponseBody Map<String, Object> havingInfor(@RequestParam("imgPath")String imgPath,HttpServletRequest request) throws Exception {
		log.info("监听到传回来文件的信息为"+imgPath);
		imgPath = imgPath.replace("/resource", "D:/file");
		OCRSample ocrSample = new OCRSample();
		return ocrSample.sample(request, imgPath);
	}
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public @ResponseBody Boolean checkFile(@RequestParam("archiveFileId")String archiveFileId,
			@RequestParam("archiveFileReferenceNumber")String archiveFileReferenceNumber,
			@RequestParam("archiveFileTitle")String archiveFileTitle) {
		return archiveFileStoreService.checkFile(archiveFileId, archiveFileReferenceNumber, archiveFileTitle);
	}
	
	
}
