package meng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.recorded.dao.ArchiveFileRecordedTableMapper;
import filemanage.recorded.dao.ArchivingFileRecordedMapper;
import filemanage.recorded.dao.ExpectHistoryMapper;
import filemanage.recorded.dao.HisoryDataMapper;
import filemanage.recorded.dao.RecordedEditMapper;
import filemanage.recorded.service.RecordedService;
import filemanage.recorded.vo.ConditionHelp;
import filemanage.recorded.vo.ExportHistoryHelp;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.historyFile.PressureAndDecompression;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml","classpath:spring-mvc-dao.xml"})
@WebAppConfiguration("src/main/resources")
public class TestRecorded {
	@Autowired
	private HisoryDataMapper hisoryDataMapper;
	@Autowired
	private ArchivingFileRecordedMapper archivingFileRecordedMapper;
	@Autowired
	private ArchiveFileRecordedTableMapper archiveFileRecordedTableMapper;
	@Autowired
	private RecordedEditMapper recordedEditMapper;
	@Autowired
	private RecordedService recordedService;//档案著录service
	@Autowired
	private ExpectHistoryMapper expectHistoryMapper;



	@Test
	public void testCondition() {
		List<ConditionHelp> list=null;
		list=archivingFileRecordedMapper.findBoxpropertyPag();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
		list=archivingFileRecordedMapper.findPcId();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
		list=archivingFileRecordedMapper.findQuanzongName();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
		list=archivingFileRecordedMapper.findQuanzongNumber();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
		list=archivingFileRecordedMapper.findRetentionperiodName();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
		list=archivingFileRecordedMapper.findScId();
		for (ConditionHelp conditionHelp : list) {
			System.out.println(conditionHelp);
		}
	}
	@Test
	public void testBoxInfor() {
		PreparationFormHelp preparationFormHelp=new PreparationFormHelp();
		preparationFormHelp.setAnual("2017");
		preparationFormHelp.setQzId("01FE498598ED4813AD7FFE2CBC31F871");
		preparationFormHelp.setPcId("1");
		preparationFormHelp.setScId("07BE60BD0C35402CB2E24F6B25ECE32C");
		preparationFormHelp.setRtId("3");
		preparationFormHelp.setBoxNumber("1");
		AmCoBox boxInfor=archivingFileRecordedMapper.findAmCoBoxByCondition(preparationFormHelp);
		System.out.println(boxInfor);
	}
	@Test
	public void testHavingFileAtta() {
		List<String> list=archivingFileRecordedMapper.havingFileAtta("3f1994c6-131a-4513-bf56-d9d782a4a53b");
		for (String string : list) {
			System.out.println(string);
		}
	}
	@Test
	public void testUpdataFileInfor() {
		Map<String, String> map=new HashMap<String,String>();
		map.put("fileId", "ffe11b93-87b9-4f08-9ddb-8712c067eaca");
		map.put("content", "archiveFilePages");
		map.put("value", "3");
		Integer index=archivingFileRecordedMapper.updataFileInfor(map);
	}
	@Test
	public void testAddFileAttach() {
		List<FileAttachment> list=new ArrayList<FileAttachment>();
		FileAttachment fileAttachment=null;
		for(int i=0;i<3;i++) {
			fileAttachment=new FileAttachment();
			fileAttachment.setFileAttachmentId(i+"369");
			fileAttachment.setArchiveFileId("1");
			fileAttachment.setFileAttachmentAnual("2");
			fileAttachment.setFileAttachmentMark("0");
			fileAttachment.setFileAttachmentName("6");
			fileAttachment.setFileAttachmentPageNumber("1");
			fileAttachment.setFileAttachmentPath("10");
			fileAttachment.setFileCreatetime(new Date());
			fileAttachment.setFileCreator("admin");
			fileAttachment.setQuanzongId("001");
			list.add(fileAttachment);
		}
		Integer index=archivingFileRecordedMapper.addFileAttachment(list);
		System.out.println(index);
	}
	@Test
	public void testAmCoBox() {
		AmCoBox boc=null;
		boc=new AmCoBox();
		PreparationFormHelp preparationFormHelp=new PreparationFormHelp();
		preparationFormHelp.setPcId("999");
		preparationFormHelp.setQzId("666");
		preparationFormHelp.setAnual("1998");
		preparationFormHelp.setScId("888");
		preparationFormHelp.setRtId("0003");
		preparationFormHelp.setBoxNumber("003");
		boc=archivingFileRecordedMapper.findAmCoBoxByCondition(preparationFormHelp);
		System.err.println(boc);
	}
	@Test
	public void testBoxAtt() {
		AmCoBoxattachment boxAtt=archiveFileRecordedTableMapper.havingBoxAttachByBoxId("acc9074b-65bd-4b06-9b8a-f7178411cc6c");
		System.err.println(boxAtt);
	}
	@Test
	public void testHaving() {
		String zipFileName="D:/file/history/敦煌泰坦测试数据.zip";
		String outputDirectory="D:/file/history";
		List<String> listFile=new PressureAndDecompression().decompressionZipFile(zipFileName, outputDirectory);
		recordedService.havingHistory(listFile, outputDirectory);
	}
	@Test
	public void testUpdateStart() {
		Map<String,Object> map=new HashMap<String,Object>();
		String str="d634df93-54c8-4eb0-81fd-f12e9d363eae,0ade4e0b-af45-42ec-af54-50b5f08d8229";
		map.put("str", str.split(","));
		archiveFileRecordedTableMapper.updateBoxStart(map);
	}
	@Test
	public void testFindFile() {
		String str="c5a73cd7-b6be-49d6-9f68-952f37eb7b7c,ea26e1d8-c32b-43bf-86aa-93ae657bce38";
		String[] ids=str.split(",");
		List<ExportHistoryHelp> list=expectHistoryMapper.queryFile(ids);
		for (ExportHistoryHelp exportHistoryHelp : list) {
			System.err.println(exportHistoryHelp);
		}
	}
	@Test
	public void testExpectHistory()throws Exception {
		String ids="df7eff5c-1d92-4120-8607-02918c092fc4,a8f20ffd-7efc-4988-845a-6ffe432f259a,a8d3f2ec-3602-4a38-a2f9-881fee44f5e3";
		String remark="2";
		String historyPath=recordedService.expectHistory(ids, remark);
	}
}
