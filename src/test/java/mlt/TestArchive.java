package mlt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import filemanage.collectandorganize.dao.FileAuditMapper;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.Organization;
import filemanage.systemmanage.service.ArchiveService;
import filemanage.systemmanage.service.OrganizationService;
import filemanage.warehouse.dao.WareHouseStorageMapper;
import filemanage.warehouse.pojo.WareHouseBuild;
import filemanage.warehouse.service.WareHouseStorageService;
import filemanage.warehouse.vo.ArchiveInWareHouseAssist;

public class TestArchive {
	@Autowired
	private FileAuditMapper fileAuditMapper;
	@Autowired
	private WareHouseStorageMapper wareHouseStorageMapper;
	
	@Autowired
	private WareHouseStorageService wareHouseStorageService;

	// 添加全宗
	@Test
	public void testAddOneArchive() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		ArchiveService archiveService = (ArchiveService) ac.getBean("archiveService", ArchiveService.class);
		Archive archive = new Archive();
		archive.setQuanzongNumber("043");
		archive.setQuanzongName("张掖市地税局");
		archive.setQuanzongPhone("13913");
		//archive.setQuanzongCreatetime(new Date());
		Boolean result = archiveService.addOneArchive(archive);
		assertTrue(result);
	}

	// 列表展示全宗信息
	@Test
	public void testSelectAllArchive() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		ArchiveService archiveService = (ArchiveService) ac.getBean("archiveService");
		List<Archive> listAllArchive = archiveService.selectAllArchive();
		assertNotNull(listAllArchive);
		for (Archive archive : listAllArchive) {
			System.out.println(archive);
		}
	}
	
	//
	@Test
	public void testFindWareHousenumber() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		WareHouseStorageMapper wareHouseStorageMapper = (WareHouseStorageMapper) ac.getBean("wareHouseStorageMapper");
		List<WareHouseBuild> listWareHouseShelfNumber = wareHouseStorageMapper.listWareHouseShelfNumber("2");
		for (WareHouseBuild wareHouseBuild : listWareHouseShelfNumber) {
			System.out.println("+++++++++++++++++++++++++"+wareHouseBuild);
		}
	}
	
	@Test
	public void testAllShow() throws Exception {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("begin", 1);
		map.put("end", 6);
		List<ArchiveInWareHouseAssist> boxInfoListShow = wareHouseStorageMapper.boxInfoListShow(map);
		for (ArchiveInWareHouseAssist archiveInWareHouseAssist : boxInfoListShow) {
			System.out.println(archiveInWareHouseAssist);
		}
		assertNotNull(boxInfoListShow);
	}

	// 列表展示机构信息
	@Test
	public void testSelectAllOrganization() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		OrganizationService organizationService = (OrganizationService) ac.getBean("organizationService");
		List<Organization> listAllOrganization = organizationService.selectAllOrganization();
		assertNotNull(listAllOrganization);
		for (Organization organization : listAllOrganization) {
			System.out.println(organization);
		}
	}
	
	@Test
	public void testUpdateReturnFor(){
		AmCoBox rif = new AmCoBox();
		rif.setQuanzongId(rif.getQuanzongId());
		rif.setBoxanual("2017");
		rif.setBoxstatus("1");
		rif.setBoxAuditstart("0");
		Integer ff = fileAuditMapper.updateBad("2017", rif.getQuanzongId());
		System.out.println(ff);
	}

}
