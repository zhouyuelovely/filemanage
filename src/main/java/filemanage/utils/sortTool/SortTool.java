package filemanage.utils.sortTool;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;



/**
 * @author meng
 * 文件排序
 */
public class SortTool {
	private Logger logger=Logger.getLogger(SortTool.class);
	
	
	public static List<String> sortMethod(List<String> newList,List<String> oldList,Integer index) {
		SortTool sortTool=new SortTool();
		List<String> list=new ArrayList<String>();
		Map<Integer, String> map=new HashMap<Integer,String>();
		for(int i=1;i<=oldList.size();i++) {
			map.put(i, oldList.get(i-1));
		}
		Map<Integer, String> mapa=new HashMap<Integer,String>();
		for(Integer o:map.keySet()) {
			if(o>=index) {
				mapa.put((o+newList.size()), map.get(o));
			}else {
				mapa.put(o, map.get(o));
			}
		}
		for(int i=index;i<newList.size()+index;i++) {
			mapa.put(i,newList.get(i-index));
		}
		
		for(Integer o:mapa.keySet()) {
			list.add(mapa.get(o));
			sortTool.logger.info("监听到新的集合路径为:"+mapa.get(o));
		}
		return list;
	}
	public static void main(String[] args) {
		
		List<String> listNew=new ArrayList<String>();
		listNew.add("1");
		listNew.add("2");
		listNew.add("3");
		listNew.add("4");
		listNew.add("5");
		listNew.add("6");
		listNew.add("7");
		List<String> list=new ArrayList<String>();
		list.add("666");
		list.add("777");
		list.add("888");
		Integer index=3;
		
		List<String> list2=sortMethod(list,listNew,index);
		for (String string : list2) {
			System.out.println(string);
		}
	}
}
