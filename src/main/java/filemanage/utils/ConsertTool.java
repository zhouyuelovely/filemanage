package filemanage.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsertTool {
	/**
	 * String 转化为Integer
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static Integer StringConvertInteger(String source)throws Exception {
		Integer result=null;
		Pattern pattern= Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence)source);
		Boolean bl=matcher.matches();
		if(bl) {
			if(source!=null) {
				result=Integer.parseInt(source);
			}
			return result;
		}else {
			return result;
		}
	}
	
	public static Long StringConvertLong(String source)throws Exception {
		Long result=null;
		Pattern pattern= Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence)source);
		Boolean bl=matcher.matches();
		if(bl) {
			if(source!=null) {
				result=Long.parseLong(source);
			}
			return result;
		}else {
			return result;
		}
	}
	
	/**
	 * String 转化为Date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date StringConverDate(String dateStr) throws ParseException {
		Date date=null;
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		date=sDateFormat.parse(dateStr);
		return date;
	} 
	/**
	 * String 转化为 Boolean
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static Boolean StringConverBoolean(String source)throws Exception{
		Boolean result=null;
		if(source!=null) {
			result=Boolean.parseBoolean(source);
		}
		return result;
	}
	/**
	 * Date 转化为 String
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String DateConverString(Date date)throws Exception{
		String result=null;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		result=simpleDateFormat.format(date);
		return result;
	}
	/**
	 * 日期转化为对应的年度
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String DateConverStringAnnual(Date date)throws Exception{
		String result=null;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
		result=simpleDateFormat.format(date);
		return result;
	}
	
}
