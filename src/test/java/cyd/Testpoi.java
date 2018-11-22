package cyd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import filemanage.inventoryandinquire.pojo.InventoryPlan;

public class Testpoi {

    public static void main(String[] args) {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        /*String filePath = "D:\\test1.xlsx";*/
        
        String filePath = "D:\\24185af0d2e74da0becba5252cdc99cd.xlsx";
        String columns[] = {"制作人","盘点人","计划制作日期","计划实施日期","计划完成日期","盘点盒数","实际实施时间","实际完成日期"};
        
        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String, String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(2);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,String> map = new LinkedHashMap<String,String>();
            	/*List<String> strlist = new ArrayList<>();*/
                row = sheet.getRow(i+2);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                        /*System.out.println(row.getCell(j));*/
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        }
        String[] exval = null;
        String val = null;
        //遍历解析出来的list
        for (Map<String,String> map : list) {
            for (Entry<String,String> entry : map.entrySet()) {
            	
                val += entry.getValue()+",";
                /*System.out.println(val);*/
            }
            
        }
        InventoryPlan iplan = new InventoryPlan();
        exval = val.split(",");
        
        for (int i = 0; i < exval.length; i++) {
        	System.out.println(exval[i]);
        	iplan.setSjsstime(exval[6]);
        	iplan.setSjwctime(exval[7]); //22 30 38
        	iplan.setPdjg(exval[30]);
		}
        System.out.println(iplan.getPdjg());
    }
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:{
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            }
            case Cell.CELL_TYPE_FORMULA:{
                //判断cell是否为日期格式
                if(DateUtil.isCellDateFormatted(cell)){
                    //转换为日期格式YYYY-mm-dd
                    cellValue = cell.getDateCellValue();
                }else{
                    //数字
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:{
                cellValue = cell.getRichStringCellValue().getString();
                break;
            }
            default:
                cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

}
