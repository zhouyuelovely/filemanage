package cyd;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcel {
	
	// 该方法判断excel版本
	@SuppressWarnings("resource")
	public static Workbook openWorkbook(String fileName)
	throws IOException {
	InputStream in = new FileInputStream(fileName); // 创建输入流
	Workbook wb = null;
	if (fileName.toLowerCase().endsWith(".xlsx")) {//toLowerCase 区分大小写
	wb = new XSSFWorkbook(in);// Excel 2007
	} else {
	wb = (Workbook) new HSSFWorkbook(in);// Excel 2003
	}
	return wb;
	}
	// 该方法处理excel的数据
	public static Map<String, Double> readExcel(String fileName, int sheetIndex, List<Map<String, Object>> readValues) throws Exception {
	Map<String, Double> result = new HashMap<String, Double>();
	Workbook wb =  openWorkbook(fileName);// 获取Excel文件对象
	Sheet sheet = wb.getSheetAt(sheetIndex);// 获取文件的指定工作表m 
	FormulaEvaluator evaluator = wb.getCreationHelper()
	.createFormulaEvaluator();//考虑到有些表格位置值为计算的结果，这里为获取计算结果值，避免把公式读出来了
	for (Map<String, Object> info : readValues){//通过readValues遍历key和value
	Row row = sheet.getRow((int)info.get("y"));// 获取行
	Cell cell = row.getCell((int)info.get("x"));// 获取列
	CellValue cellValue = evaluator.evaluate(cell);// 获表格公式计算后的值
	if(cellValue != null){
	switch (cellValue.getCellType()) {// 判断值类型
	case Cell.CELL_TYPE_NUMERIC:
	result.put(info.get("user").toString(), cellValue.getNumberValue());
	System.out.println("键为:  " + info.get("user") + "读取到的值是： " + result.get(info.get("user").toString()));
	break;
	default:
	result.put(info.get("user").toString(), 0.0d);
	break;
	}
	}else{
	System.out.println("单元格的值为空！");
	}
	}
	return result;
	}


	public static void main(String[] args) throws Exception { 
	String fileName = "D://24185af0d2e74da0becba5252cdc99cd.xlsx";//D://文件夹名//文件名.xlsx"
	List<Map<String, Object>> readValues = new ArrayList<Map<String, Object>>();
	Map<String, Object> readValue = new HashMap<String, Object>();
	readValue.put("user","姓名");//user 是取名表头类型(user) 尽量取一个代表性名字，后面为属性比如：姓名，年龄
	readValue.put("x", 1);//横坐标
	readValue.put("y", 1);//纵坐标
	readValues.add(readValue);
	readExcel(fileName, 0 , readValues);//文件名，sheet下标，值

	}
}
