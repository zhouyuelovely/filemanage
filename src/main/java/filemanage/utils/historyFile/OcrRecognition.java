package filemanage.utils.historyFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class OcrRecognition {
	private final String[] sts=new String[] {"serialNumal","fileNumber","textNumber",
			"respomsiblePerson","title","date","confidentialityLevel","pagesNumber","note"};//表格表头
	// 设置APPID/AK/SK
	private final String APP_ID = "10889402";
	private final String API_KEY = "4yWCN61oLn0ai4wPkQvviL7p";
	private final String SECRET_KEY = "mQmrsBYYQq9mDPkvnYqoo713RTx1OEYY";
	private final AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
	private Logger logger=Logger.getLogger(OcrRecognition.class);
	
	/**
	 * 识别表格每行数据
	 * @param list 每行数据的绝对路径
	 * @return
	 */
	private Map<String, String> havingRowContent(List<String> list){
		Map<String, String> map=new HashMap<String,String>();//保存信息
		HashMap<String, String> options = new HashMap<String, String>();//ocr识别设置
		options.put("language_type", "CHN_ENG");
        for(int i=0;i<list.size();i++) {
        	JSONObject res = client.basicGeneral(list.get(i), options);//识别信息
        	JSONArray listInfo = res.getJSONArray("words_result");//获取识别后的json数组
        	StringBuffer resStr = new StringBuffer();
        	for (int j = 0; j < listInfo.length(); j++) {
        		resStr.append(listInfo.getJSONObject(j).get("words"));//获取数组中的每个元素
    		}
        	map.put(sts[i], resStr.toString());//键值对添加到map中
        }
        	
        return map;
	}
	/**
	 * 获取表格中所有内容
	 * @param listes 表格内容
	 * @return
	 */
	public List<Map> havingTableContent(List<List> listes){
		List<Map> listResult=new ArrayList<Map>();//实例集合存放表格内容
		Map<String, String> map=null;//接收行内元素
		for(List list:listes) {
			map=havingRowContent(list);
			if(map.get("fileNumber")!=""&&//档号不为空
					map.get("respomsiblePerson")!=""&&//责任者不为空
					map.get("title")!="") {//题名不为空
				listResult.add(map);
			}
			logger.info("[序号："+map.get("serialNumal")+";档号："+map.get("fileNumber")+";文号:"+map.get("textNumber")+
					";责任者："+map.get("respomsiblePerson")+";题名："+map.get("title")+";日期："+map.get("date")+
					";密级："+map.get("confidentialityLevel")+";页数："+map.get("pagesNumber")+";备注："+map.get("note")+"]");
		}
		return listResult;
	}
	/**
	 * 获取单个图片的内容
	 * @param filename 文件的绝对路径
	 * @return
	 */
	public String havingBKInfor(String filename) {
		HashMap<String, String> options = new HashMap<String, String>();//ocr识别设置
		options.put("language_type", "CHN_ENG");
		JSONObject res = client.basicGeneral(filename, options);//识别信息
    	JSONArray listInfo = res.getJSONArray("words_result");//获取识别后的json数组
    	StringBuffer resStr = new StringBuffer();
    	for (int j = 0; j < listInfo.length(); j++) {
    		resStr.append(listInfo.getJSONObject(j).get("words"));//获取数组中的每个元素
		}
    	return resStr.toString();
	}
}
