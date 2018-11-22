package meng;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.collectandorganize.dao.ArchiveFileStoreMapper;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.ArchiveFileStoreService;
import filemanage.collectandorganize.vo.QueryArchiveFileCondition;
import filemanage.collectandorganize.vo.QueryArchiveFileStoreHelp;
import filemanage.utils.layui.Layui;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml","classpath:spring-mvc-dao.xml"})
@WebAppConfiguration("src/main/resources")
public class TestArchiveFileStore {
	@Autowired
	private ArchiveFileStoreMapper archiveFileStoreMapper;
	@Autowired
	private ArchiveFileStoreService archiveFileService;
	
	
	@Test//全宗文件集合
	public void testFindAllArchiveFile() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("archiveId", "01FE498598ED4813AD7FFE2CBC31F871");
		map.put("begin", 1);
		map.put("end", 10);
		List<ArchiveFile> listArchiveFile=archiveFileStoreMapper.findAllArchiveFile(map);
		for (ArchiveFile archiveFile : listArchiveFile) {
			System.out.println(archiveFile);
		}
		assertNotNull(listArchiveFile);
	}

	@Test//全宗下文件的所有年度
	public void testListAnual() {
		List<QueryArchiveFileStoreHelp> listAnua=archiveFileService.listAnual("01FE498598ED4813AD7FFE2CBC31F871");
		for (QueryArchiveFileStoreHelp queryArchiveFileStoreHelp : listAnua) {
			System.out.println(queryArchiveFileStoreHelp);
		}
		assertNotNull(listAnua);
	}
	@Test//全宗年度文件集合
	public void testFindArchiveFile() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("archiveId", "01FE498598ED4813AD7FFE2CBC31F871");
		map.put("begin", 1);
		map.put("end", 10);
		map.put("annual", "2016");
		List<ArchiveFile> listArchiveFile=archiveFileStoreMapper.findArchiveFile(map);
		for (ArchiveFile archiveFile : listArchiveFile) {
			System.out.println(archiveFile);
		}
		assertNotNull(listArchiveFile);
	}

	@Test//条件查询
	public void testQueryArchiveFileByCondition() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("archiveId", "01FE498598ED4813AD7FFE2CBC31F871");
		map.put("begin", 1);
		map.put("end", 10);
		map.put("annual", "2016");
		map.put("condition", "admin");
		List<ArchiveFile> list=archiveFileStoreMapper.queryArchiveFileByCondition(map);
		for (ArchiveFile archiveFile : list) {
			System.out.println(archiveFile);
		}
		assertNotNull(list);
	}

	@Test//删除功能
	public void textUpdate() {
		Integer result=archiveFileStoreMapper.deleteArchiveFileByArchiveFileId("1");
		assertTrue(result>0);
	}
	@Test//更新文件状态
	public void testUpdateStart() {
		//assertTrue(archiveFileService.updateArchiveFileStartByArchiveFileId("1"));
	}
	@Test//根据文件主键查询文件附件
	public void testQueryFileAttachmentByArchiveFileId() {
		List<FileAttachment> list=archiveFileStoreMapper.queryFileAttachmentByArchiveFileId("11");
		for (FileAttachment fileAttachment : list) {
			System.out.println(fileAttachment);
		}
		System.out.println(list);
	}
	@Test
	public void testQueryArchiveFileByArchiveFileId() {
		ArchiveFile archiveFile=archiveFileStoreMapper.queryArchiveFileByArchiveFileId("10");
		System.out.println(archiveFile);
		assertNotNull(archiveFile);
	}
	@Test
	public void testQueryArchiveFileByArchiveFileIdPages() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("begin", 1);
		map.put("end", 10);
		map.put("archiveFileId", "10");
		List<FileAttachment> list=archiveFileStoreMapper.queryFileAttachmentByArchiveFileIdPages(map);
		for (FileAttachment fileAttachment : list) {
			System.out.println(fileAttachment);
		}
		assertNotNull(list);
	}
	@Test
	public void testAddFileAttachment() {
		FileAttachment fileAttachment=new FileAttachment();
		fileAttachment.setFileAttachmentId(UUID.randomUUID().toString());
		fileAttachment.setArchiveFileId("B7FBECDD119D4EF28837BD9503B2CF95");
		fileAttachment.setQuanzongId("1");
		fileAttachment.setFileAttachmentAnual("2015");
		fileAttachment.setFileAttachmentMark("0");
		fileAttachment.setFileAttachmentName("wuwuwuwu");
		fileAttachment.setFileAttachmentPageNumber("0");
		fileAttachment.setFileAttachmentPath("d");
		Integer result=archiveFileStoreMapper.addFileAttachment(fileAttachment);
		assertNotNull(result);
		System.out.println(result);
	}
	@Test
	public void testQueryFileAttachmentByBoxId() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("begin", 1);
		map.put("end", 1);
		map.put("boxId", "2");
		List<FileAttachment> list=archiveFileStoreMapper.queryFileAttachmentByBoxId(map);
		for (FileAttachment fileAttachment : list) {
			System.out.println(fileAttachment);
		}
	}
}
