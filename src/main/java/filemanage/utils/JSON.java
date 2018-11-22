package filemanage.utils;

import java.util.List;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import net.sf.json.JSONObject;

public class JSON {
	
	public static String queryAllClass(List<PrimaryClassFication> list){
			StringBuffer sb=new StringBuffer();
		if(list.size() == 0) {
			sb.append("{\"");
			sb.append("selected");
			sb.append("\":");
			sb.append("\"");
			sb.append("该全总没有添加机构");
			sb.append("\",");
			JSONObject obj1 = new JSONObject();
			obj1.put("onetype", 0);
			String s=obj1.toString();
			s=s.substring(1);
			s=s.substring(0, s.length()-1);
			sb.append(s);
			sb.append("}");
		}else {
			sb.append("{\"");
			sb.append("selected");
			sb.append("\":");
			sb.append("\"");
			sb.append(list.get(0).getPcName());
			sb.append("\",");
			JSONObject obj = new JSONObject();
			obj.put("onetype", list);
			String s=obj.toString();
			s=s.substring(1);
			s=s.substring(0, s.length()-1);
			sb.append(s);
			sb.append("}");
		}
		return sb.toString();
		
	}
	

}
