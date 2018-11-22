package FYX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.collectandorganize.dao.BoxSubmitReviewMapper;
import filemanage.collectandorganize.dao.FileScanningMapper;
import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.pojo.TemporaryFile;
import filemanage.collectandorganize.service.FileScanningService;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.Archive;
import filemanage.utils.page.PageBean;

public class TestCollectAndOrganize {

	@Test
	public void testAddImageInfo() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		TemporaryFile temporaryFile = new TemporaryFile();
		// temporaryFile.setTemporaryAccessaryId(1);
		temporaryFile.setTemporaryAccessaryName("timg(5)");
		temporaryFile.setTemporaryAccessaryPageNumber("page5");
		temporaryFile.setTemporaryAccessaryPath("D:\\picture\\timg(5)");
		// temporaryFile.setTemporaryAccessarySign("");
		temporaryFile.setTemporaryAccessaryUserIdNumber("320111199812215811");
		temporaryFile.setQuanzongId(UUID.randomUUID().toString());

	}

	@Test
	public void testGetImgList() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningService fileScanningService = (FileScanningService) context.getBean("fileScanningService",
				FileScanningService.class);
		PageBean<TemporaryFile> pageBean = fileScanningService.getImgList("320111199812215811", 1);
		List<TemporaryFile> list = pageBean.getLists();
		System.out.println(list);
		for (TemporaryFile temporaryFile : list) {
			System.out.println(temporaryFile.getTemporaryAccessaryPath());
		}
		for (TemporaryFile temporaryFile : list) {
			System.out.println(temporaryFile.getTemporaryAccessaryPageNumber());
		}
	}

	@Test
	public void testCountImgPath() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		Integer num = fileScanningMapper.countImgPath("320111199812215811");
		System.out.println(num);
	}

	@Test
	public void testListImgPath() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		HashMap<String, Object> map = new HashMap<String, Object>();
		String userIdNumber = "320111199812215811";
		map.put("temporaryAccessaryUserIdNumber", userIdNumber);
		map.put("start", 0);
		map.put("size", 3);
		List<TemporaryFile> listImgPath = fileScanningMapper.listImgPath(map);
		System.out.println(listImgPath);
	}

	@Test
	public void testTagPageByImgPath() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		Integer num = fileScanningMapper.tagPageByImgPath("D:/file/timg(2).jpg");
		System.out.println(num);
	}

	@Test
	public void testQueryTemporaryFileInfoByUserIdNumber() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		List<TemporaryFile> list = fileScanningMapper.queryTemporaryFileInfoByUserIdNumber("320111199812215811");
		System.out.println(list);
	}

	@Test
	public void testFindBoxPathList() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		BoxSubmitReviewMapper boxSubmitReviewMapper = (BoxSubmitReviewMapper) context.getBean("boxSubmitReviewMapper");
		AmCoBoxattachment amCoBoxattachment = new AmCoBoxattachment();
		User user = HavingUserInfor.havingUser();
		Archive archive = new Archive();
		archive.setQuanzongId(user.getArchive().getQuanzongId());
		amCoBoxattachment.setArchive(archive);;
		amCoBoxattachment.setBoxYear("2018");
		List<AmCoBoxattachment> list = boxSubmitReviewMapper.findBoxPathList(amCoBoxattachment);
		List<String> listBox = new ArrayList<>();
		for (AmCoBoxattachment amCoBoxattachment2 : list) {
			listBox.add(amCoBoxattachment2.getBoxattachmentBox().substring(0,
					amCoBoxattachment2.getBoxattachmentBox().lastIndexOf("/")));
		}
		System.out.println(listBox);
	}
	
	@Test
	public void testAddFileAttachmentInfo() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		FileScanningMapper fileScanningMapper = (FileScanningMapper) context.getBean("fileScanningMapper");
		String ftp = "D:/file/022/2018-05-28/张掖市甘州区成立张掖市御景东方建设工程项目1号综合楼“92”高处坠落事故调查组的批复"; 
		ArchiveFile archiveFile2 = fileScanningMapper.queryArchiveFileIdByArchiveFileTitle("张掖市甘州区成立张掖市御景东方建设工程项目1号综合楼“92”高处坠落事故调查组的批复");
		System.out.println("*********"+archiveFile2);
		List<TemporaryFile> temporaryFileList = fileScanningMapper.queryTemporaryFileInfoByUserIdNumber("350287199812130648");
		List<FileAttachment> list = new ArrayList<FileAttachment>();
		FileAttachment fileAttachment =null;
		/*for (int i = 0; i < temporaryFileList.size(); i++) {
			fileAttachment=new FileAttachment();
			String fileAttachmentPath=ftp+"/"+temporaryFileList.get(i).getTemporaryAccessaryName();
			fileAttachment.setArchiveFileId(archiveFile2.getArchiveFileId());// 文件主键
			fileAttachment.setFileAttachmentAnual(archiveFile2.getArchiveFileAnual());// 文件年度
			fileAttachment.setFileAttachmentMark(temporaryFileList.get(i).getTemporaryAccessarySign());// 标记1：封面
			fileAttachment.setFileAttachmentName(temporaryFileList.get(i).getTemporaryAccessaryName());// 附件名称
			fileAttachment.setFileAttachmentPageNumber(temporaryFileList.get(i).getTemporaryAccessaryPageNumber());// 页码
			fileAttachment.setFileAttachmentPath(fileAttachmentPath);// 附件地址
			fileAttachment.setQuanzongId(temporaryFileList.get(i).getQuanzongId());// 全宗主键
			fileAttachment.setFileCreator("admin");// 创建人 user.getUserName();//张菜菜
			// 往文件附件表插入信息
			list.add(fileAttachment);
		}*/
		for (TemporaryFile temporaryFile : temporaryFileList) {
			fileAttachment=new FileAttachment();
			String fileAttachmentPath=ftp+"/"+temporaryFile.getTemporaryAccessaryName();
			fileAttachment.setArchiveFileId(archiveFile2.getArchiveFileId());// 文件主键
			fileAttachment.setFileAttachmentAnual(archiveFile2.getArchiveFileAnual());// 文件年度
			fileAttachment.setFileAttachmentMark(temporaryFile.getTemporaryAccessarySign());// 标记1：封面
			fileAttachment.setFileAttachmentName(temporaryFile.getTemporaryAccessaryName());// 附件名称
			fileAttachment.setFileAttachmentPageNumber(temporaryFile.getTemporaryAccessaryPageNumber());// 页码
			fileAttachment.setFileAttachmentPath(fileAttachmentPath);// 附件地址
			fileAttachment.setQuanzongId(temporaryFile.getQuanzongId());// 全宗主键
			fileAttachment.setFileCreator("admin");// 创建人 user.getUserName();//张菜菜
			// 往文件附件表插入信息
			list.add(fileAttachment);
		}
		/*for (FileAttachment fileAttachment1 : list) {
			System.out.println(fileAttachment1);
		}*/
		Integer num = fileScanningMapper.addFileAttachmentInfo(list);
		System.out.println(num);
	}

}
