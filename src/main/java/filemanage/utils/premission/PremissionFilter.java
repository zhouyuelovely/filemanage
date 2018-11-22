package filemanage.utils.premission;

import java.util.List;


import filemanage.systemmanage.pojo.Authority;
import oracle.net.aso.s;

public class PremissionFilter {
	
	/**
	 * 子系统进去页面
	 * @param srcList 系统拥有权限
	 * @param userList 用户拥有权限
	 * @return
	 */
	public static Boolean pagePremission(List<Authority> srcList,List<Authority> authList) {
		String str="noHaving";
		if(srcList.size()>0&&authList.size()>0) {
			for (Authority auth : authList) {//是否拥有景区页面的权限
				for(Authority src:srcList) {
					if(auth.getPermissionId().equals(src.getPermissionId())) {
						str="having";
						break;
					}
				}
				if("having".equals(str)) {
					break;
				}
			}
		}
		if("having".equals(str)) {//存在权限返回true
			return true;
		}else {//不存在返回false
			return false;
		}
	}
	/**
	 * 拥有权限
	 * @param code 权限代码
	 * @param userList 用户权限集合
	 * @return
	 */
	public static Boolean buttenPremission(String code,List<Authority> authList) {
		String str="noHaving";
		if(code!=null&&code!=""&&authList.size()>0) {
			for (Authority authority : authList) {
				if(code.equals(authority.getPermissionBelong())) {
					str="having";
					break;
				}
			}
		}
		if("having".equals(str)) {//存在权限返回true
			return true;
		}else {//不存在返回false
			return false;
		}
	}
	/**
	 * 页面跳转
	 * @param code 权限代码
	 * @param srcList 
	 * @param userList
	 * @return
	 */
	public static String goPage(String code,List<Authority> srcList,List<Authority> authList) {
		String str=null;
		if(srcList.size()>0&&authList.size()>0&&code!=null&&code.length()>0) {
			for (Authority auth : authList) {//是否拥有景区页面的权限
				for(Authority src:srcList) {
					if(auth.getPermissionId().equals(src.getPermissionId())) {
						System.err.println(auth+":"+src);
						if(code.equals(auth.getPermissionBelong())) {
							str=auth.getPermissionDescription();
							break;
						}else {
							str="forward:"+auth.getPermissionUrl();
							break;
						}
					}
				}
				if(str!=null) {
					break;
				}
			}
		}
		if(str!=null) {//存在权限返回true
			return str;
		}else {//不存在返回false
			return "error/noPermissions";
		}
	}
	/**
	 * 权限选中
	 * @param id 权限主键
	 * @param authList 权限集合
	 * @return
	 */
	public static Boolean checked(String id,List<Authority> authList) {
		String str="noChecked";
		if(authList.size()>0&&authList!=null&&id!=null&&id.length()>0) {
			for (Authority authority : authList) {
				if(id.equals(authority.getPermissionId())) {
					str="checked";
					break;
				}
			}
		}
		if("checked".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
}
