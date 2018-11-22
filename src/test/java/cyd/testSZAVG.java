package cyd;

import java.util.ArrayList;
import java.util.List;

public class testSZAVG {
	
	public static void main(String[] args) {
		List<String> liststr = new ArrayList<>();
		liststr.add("A");
		liststr.add("B");
		liststr.add("C");
		liststr.add("D");
		liststr.add("E");
		liststr.add("F");
		liststr.add("A2");
		liststr.add("B2");
		liststr.add("C2");
		liststr.add("D2");
		liststr.add("E2");
		liststr.add("F2");
		System.out.println(liststr);
		for (int i = 0; i < fixedGrouping(liststr, 6).size(); i++) {
			System.out.println(fixedGrouping(liststr, 6).get(i));
		}
	}
	/**
	 * 将一组数据固定分组，每组n个元素
	 * @param source 要分组的数据源
	 * @param n      每组n个元素
	 * @param <T>
	 * @return
	 */
	public static <T> List<List<T>> fixedGrouping(List<T> source, int n) {

	    if (null == source || source.size() == 0 || n <= 0)
	        return null;
	    List<List<T>> result = new ArrayList<List<T>>();

	    int sourceSize = source.size();
	    int size = (source.size() / n) + 1;
	    for (int i = 0; i < size; i++) {
	        List<T> subset = new ArrayList<T>();
	        for (int j = i * n; j < (i + 1) * n; j++) {
	            if (j < sourceSize) {
	                subset.add(source.get(j));
	            }
	        }
	        result.add(subset);
	    }
	    return result;
	}
}
