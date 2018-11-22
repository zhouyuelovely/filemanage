package filemanage.utils.historyFile;



import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import oracle.net.aso.f;


/**
 * @author meng
 *档号信息校验
 */
public class FileNumberCheck {
	private final String[] strs=new String[] {"quanZongNumber","firstClass","anual",
			"custodyTime","secondClass","beginPart","endPart","number"};
	private Logger logger=Logger.getLogger(FileNumberCheck.class);
	private List<String> checkContent(List<String> list) {
		List<String> listNew=new ArrayList<String>();
		List<String> listm=new ArrayList<String>();
		Integer index=1;
		Integer charLength=0;
		List<char[]> listes=new ArrayList<char[]>();
		List<char[]> listy=new ArrayList<char[]>();
		if(list.size()>0) {
			//获取每行每个元素
			logger.info("获取每行元素");
			for(String string:list) {
				System.err.println(string);
				if(!string.startsWith("-",string.length()-5)) {
					String oldStr=string.substring(string.length()-4);
					String newStr="-"+oldStr;
					string=string.replace(oldStr, newStr);
				}
				char[] c=string.toCharArray();
				listes.add(c);
				listm.add(string);
			}
			list.clear();
			list.addAll(listm);
			//获取每行元素的长度
			logger.info("获取每行元素的长度");
			for(int i=0;i<1;i++) {
				for(int j=1;j<list.size();j++) {
					if(list.get(i).length()==list.get(j).length()) {//档号长度一致
						index++;
					}
				}
				if(index==list.size()) {//档号的规则一致
					charLength=list.get(i).length();//获取档号的长度
				}
			}
			logger.info("翻转元素，获取每列的值");
			//数据翻转，获取每一列中的数据
			for(int i=0;i<charLength-4;i++) {
				char[] chary=new char[list.size()];
				for(int j=0;j<listes.size();j++) {
					chary[j]=listes.get(j)[i];
				}
				listy.add(chary); 
			}
			logger.info("统计每列的值，改变少数的值");
			for(int i=0;i<listy.size();i++) {
				Map<Character, Integer> map=new HashMap<Character, Integer>();
				char[] charCount=listy.get(i);
				for (char c : charCount) {
					if(!map.containsKey(c)) {//不存在键值
						map.put(c, 1);
					}else {
						map.put(c, map.get(c)+1);//存在键值添加数量
					}
				}
				if(map.size()>1) {
					List<Map.Entry<Character, Integer>> listMap=new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());//map转化为list
					Collections.sort(listMap, new Comparator<Map.Entry<Character, Integer>>() {//按照map的values排序
						public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
							return o1.getValue().compareTo(o2.getValue());
						}
					});
					char men=listMap.get(listMap.size()-1).getKey();//获取最大value对应的键
					for(int m=0;m<charCount.length;m++) {//键键值给所有的char数组
						charCount[m]=men;
					}
				}
			}
			for(int i=0;i<listy.get(0).length;i++) {
				StringBuffer sb=new StringBuffer();
				for(int j=0;j<listy.size();j++) {
					sb.append(listy.get(j)[i]);
				}
				sb.append(list.get(i).substring(list.get(i).lastIndexOf("-")+1));
				System.err.println(sb.toString());
				listNew.add(sb.toString());
			}
		}
		return listNew;
	}
	public Map<String, Object> havingContent(List<String> list) {
		Map<String, Object> map=new HashMap<String,Object>();
		List<String> listNew=checkTool(list);
		List<String> lis=new ArrayList<String>();
		//获取行内部分信息
		String content=listNew.get(0).substring(0, listNew.get(0).lastIndexOf("-"));//分割字符串
		String[] str=content.split("·");//添加
		for (String string : str) {
			String[] stri=string.split("-");
			lis.addAll(Arrays.asList(stri));
		}
		//获取起件号和止件号
		String[] in=new String[listNew.size()];
		for(int i=0;i<listNew.size();i++) {
			in[i]=(listNew.get(i).substring(listNew.get(i).lastIndexOf("-")+1));
		}
		Arrays.sort(in);//排序
		for(int i=0;i<lis.size();i++) {//组装数据
			map.put(strs[i], lis.get(i));
		}
		map.put(strs[strs.length-3], in[0]);
		map.put(strs[strs.length-2], in[in.length-1]);
		String beginNum=list.get(0).substring(list.get(0).length()-4);
		String endNum=list.get(list.size()-1).substring(list.get(list.size()-1).length()-4);
		map.put(strs[strs.length-1], Integer.parseInt(endNum)-Integer.parseInt(beginNum)+1);
		return map;
 	}
	public static void main(String[] args) {
		FileNumberCheck fileNumberCheck=new FileNumberCheck();
		List<String> list=new ArrayList<String>();
		list.add("001-WS·2017-D10-BGS0001");
		list.add("001-WS·2017-D10-BGS0002");
		list.add("001-WS·2017-D10-BGS0003");
		list.add("001-WS·2017-D10-BGS0004");
		list.add("001-WS·2017-D10-BGS0005");
		list.add("001-WS2017-D10-BGS0006");
		list.add("001-WS·2017-D10-BGS0007");
		list.add("001-WS·2017-D10-BGS0008");
		list.add("001-WS·2017D10-BGS0009");
		list.add("001-WS·2017-D10-BGS0010");
		list.add("001-WS·2017-D10-BGS0011");
		Map<String, Object> map=fileNumberCheck.havingContent(list);
		for(Map.Entry<String, Object> entry:map.entrySet()) {
			System.out.println("key:"+entry.getKey()+";value:"+entry.getValue());
		}
		//fileNumberCheck.checkTool(list);
	}
	
	public static List<String> checkTool(List<String> list) {
		List<String> newList=new ArrayList<String>();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for (String string : list) {//获取最多字符串
			string=string.substring(0,string.length()-4);
			if(!"-".equals(string.substring(string.length()-1))) {
				string=string+"-";
			}
			if(!map.containsKey(string)) {
				map.put(string, 1);
			}else {
				map.put(string, map.get(string)+1);
			}
		}
		String result=null;
		if(map.size()>0) {
			List<Map.Entry<String, Integer>> mapList=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
			Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {//按照map的values排序
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
			});
			result=mapList.get(mapList.size()-1).getKey();
		}
		for(String string:list) {
			string=string.replace(string.subSequence(0, string.length()-4), result);
			newList.add(string);
		}
		return newList;
	}
}
