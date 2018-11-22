package filemanage.utils.excelmanage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReflectionDemo {
	public static List<List> allInfor(Object model) throws Exception, NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		List list = new ArrayList();

		try {
			Field[] field = model.getClass().getDeclaredFields();// 获取实体类的所有属性返回
			for (int i = 0; i < field.length; i++) {// 遍历属性
				List listContext = new ArrayList();
				String name = field[i].getName();// 获取属性名字
				System.out.println("attribute name:" + name);
				name = name.substring(0, 1).toUpperCase() + name.substring(1);// 将过去的名字首字母大写，还原实体类中的成员变量
				String type = field[i].getGenericType().toString();// 获取属性类型
				if (type.equals("class java.lang.String")) {// 获取string类型的值
					Method method = model.getClass().getMethod("get" + name);
					String value = (String) method.invoke(model);// 调用get方法获取属性值
					if (value != null) {
						System.out.println("attribute value:" + value);
					}
				}
				if (type.equals("class java.lang.Integer")) {
					Method m = model.getClass().getMethod("get" + name);
					Integer value = (Integer) m.invoke(model);
					if (value != null) {
						System.out.println("attribute value:" + value);
					}
				}
				if (type.equals("class java.lang.Short")) {
					Method m = model.getClass().getMethod("get" + name);
					Short value = (Short) m.invoke(model);
					if (value != null) {
						System.out.println("attribute value:" + value);
					}
				}
				if (type.equals("class java.lang.Double")) {
					Method m = model.getClass().getMethod("get" + name);
					Double value = (Double) m.invoke(model);
					if (value != null) {
						System.out.println("attribute value:" + value);
					}
				}
				if (type.equals("class java.lang.Boolean")) {
					Method m = model.getClass().getMethod("get" + name);
					Boolean value = (Boolean) m.invoke(model);
					if (value != null) {
						System.out.println("attribute value:" + value);
					}
				}
				if (type.equals("class java.util.Date")) {
					Method m = model.getClass().getMethod("get" + name);
					Date value = (Date) m.invoke(model);
					if (value != null) {
						System.out.println("attribute value:" + value.toLocaleString());
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
