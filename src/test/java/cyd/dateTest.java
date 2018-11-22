package cyd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class dateTest {
	/*public static void main(String[] args) {
		Date date = new Date();	
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		                 date.setTime(19970707);
		 System.out.println(sdf.format(date));
		 String dates = "2018-08-08";
		 System.out.println(dates.length());
		 if(dates.length() == 8) {
			 
		 }
	}*/
	
	    /*public static void main(String[] args) {
	    	String value = "19980810";
	    	String str1 = value;
	        if(str1.length() != 8) {
	        	System.out.println("时间格式为8位");
	        }else {
	        	StringBuilder sb = new StringBuilder(str1);//构造一个StringBuilder对象
		        sb.insert(4, "-");//在指定的位置，插入指定的字符串
		        sb.insert(7, "-");//在指定的位置，插入指定的字符串
		        str1 = sb.toString();
	        }
	        System.out.println(str1);
	    }*/
	
	public static void main(String[] args) {
		List<List> list = new ArrayList<>();
		List<String> strlist1 = new ArrayList<>();
		List<String> strlist2 = new ArrayList<>();
		
		strlist1.add("A");
		strlist1.add("B");
		strlist1.add("C");
		strlist1.add("D");
		strlist1.add("E");
		strlist1.add("F");
		for (int i = 0; i < strlist1.size(); i++) {
			List<String> strlist3 = new ArrayList<>();
			strlist3.add(strlist1.get(i));
			if(strlist3.size() == 3) {
				strlist3 = new ArrayList<>();
				strlist3.add(strlist1.get(i));
				System.out.println(strlist3.get(i));
			}
		}
		
		strlist2.add("a1");
		strlist2.add("b1");
		strlist2.add("c1");
		list.add(strlist1);
		list.add(strlist2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
