package FYX;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import filemanage.systemmanage.dao.RoleManagementMapper;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.service.RoleManagementService;

public class TestRoleManagement {
	/**
	 * 查询全宗信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testlistArchive() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		RoleManagementMapper roleManagementMapper = (RoleManagementMapper) context.getBean("roleManagementMapper");
		List<Archive> list = roleManagementMapper.listArchive();
		for (Archive archive : list) {
			System.out.println(archive);
		}
	}

	/**
	 * 根据角色Id删除权限Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteAuthorityByROleId() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		/*
		 * RoleManagementService
		 * roleManagementService=(RoleManagementService)context.getBean(
		 * "roleManagementService",RoleManagementService.class); Boolean result=
		 * roleManagementService.deleteAuthorityByRoleId("2");
		 * System.out.println(result);
		 */
		RoleManagementMapper roleManagementMapper = (RoleManagementMapper) context.getBean("roleManagementMapper");
		Integer num = roleManagementMapper.deleteAuthorityByRoleId("2");
		System.out.println(num);
	}

	/**
	 * 模拟权限赋予
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGrantAuthority() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-dao.xml");
		RoleManagementService roleManagementService = (RoleManagementService) context.getBean("roleManagementService",
				RoleManagementService.class);
		String roleId="5";
		String permissionId= "11,12,13,14,15,16,18,19,17";
		String []rightId =permissionId.split(",");
		Boolean result=roleManagementService.grantAuthority(roleId, rightId);
		System.out.println(result);
	}
}
