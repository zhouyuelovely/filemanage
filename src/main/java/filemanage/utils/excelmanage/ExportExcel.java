package filemanage.utils.excelmanage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	private Logger logger=Logger.getLogger(ExportExcel.class);
	/**
	 * 创建Excel表格
	 * @param excelPath 表格的路径及其表格的名称
	 * @param excelName 表头
	 * @param excelOutfit 表格标题
	 * @param listName 表格内容
	 * @throws Exception 
	 */
	public static void createExcel(String excelPath, String excelName, String[] excelOutfit, List<List> listName)
			throws Exception {
		ExportExcel excel=new ExportExcel();
		Workbook workbook = new XSSFWorkbook();// 创建工作

		Sheet sheet = workbook.createSheet("2007sheet");// 创建一个工作簿对象

		// 产生表格标题行
		Row row = sheet.createRow(0);// 创建一个行对象，从0行开始
		Cell cell = row.createCell(0);// 创建单元格，从0列开始
		
		if(excelName.equals("盘点计划")) {
			sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (excelOutfit.length-6) - 1));// 合并单元格四个参数分别为：开始行，结束行，开始列，结束列
		}else {
			sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, excelOutfit.length - 1));// 合并单元格四个参数分别为：开始行，结束行，开始列，结束列
		}
		
		cell.setCellValue(excelName);// 设置标题
		row.setHeightInPoints(50);// 设置行高位30像素
		sheet.setColumnWidth(0, 9*100);
		sheet.setColumnWidth(1, 9*700);
		sheet.setColumnWidth(2, 9*600);
		sheet.setColumnWidth(3, 9*500);
		sheet.setColumnWidth(4, 9*900);
		sheet.setColumnWidth(5, 9*500);
		sheet.setColumnWidth(6, 9*200);
		sheet.setColumnWidth(7, 9*100);
		sheet.setColumnWidth(8, 9*100);
		// 设置标题的样式
		CellStyle titleCellStyle = getTitleStyle(workbook);
		cell.setCellStyle(titleCellStyle);
		if(excelName.equals("盘点计划")) {
			String[] userOutfit = {"制作人","盘点人","计划制作日期","计划实施日期","计划完成日期","盘点盒数","实际实施时间","实际完成日期"};
			// 设置标题的表中字段
			Row thRow = sheet.createRow(2);// 创建一个行对象，从0开始
			thRow.setHeightInPoints(40);

			for (int i = 0; i < userOutfit.length; i++) {
				Cell thCell = thRow.createCell(i, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
				// 设置式样
				CellStyle thCellStyle = getThStyle(workbook);
				thCell.setCellStyle(thCellStyle);
				thCell.setCellValue(userOutfit[i]);// 设置内容
				
			}
			//设置单元格合并
			sheet.addMergedRegion(new CellRangeAddress(4,4,6,7));
			String[] userOutfit1 = { "序号", "盒编号", "档案类型", "起件号", "止件号", "位置","盘点结果"," " };
			// 设置标题的表中字段
			Row thRow1 = sheet.createRow(4);// 创建一个行对象，从0开始
			thRow1.setHeightInPoints(40);

			for (int i = 0; i < userOutfit1.length; i++) {
				Cell thCell = thRow1.createCell(i, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
				// 设置式样
				CellStyle thCellStyle = getThStyle(workbook);
				thCell.setCellStyle(thCellStyle);
				thCell.setCellValue(userOutfit1[i]);// 设置内容
				
			}
		}else {
			// 设置标题的表中字段
			Row thRow = sheet.createRow(2);// 创建一个行对象，从0开始
			thRow.setHeightInPoints(40);

			for (int i = 0; i < excelOutfit.length; i++) {
				Cell thCell = thRow.createCell(i, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
				// 设置式样
				CellStyle thCellStyle = getThStyle(workbook);
				thCell.setCellStyle(thCellStyle);
				thCell.setCellValue(excelOutfit[i]);// 设置内容
				
			}
		}
		
		//设置内容
		if(excelName.equals("盘点计划")) {
			List<String> listName1 = new ArrayList<>();
			List<List> listName2 = new ArrayList<>();

			//excel标题
			for (int i = 1; i < listName.size(); i++) {
				listName2.add(listName.get(i));
				System.out.println("BBBBBBB"+listName.get(i));
			}
			for(int m=0;m<listName2.size();m++) {
				//设置单元格合并
				Row contentRow = sheet.createRow(3+m);
				contentRow.setHeightInPoints(40);
				List listContent=(List) listName2.get(m);
				for(int n=0;n<listContent.size();n++) {
					Cell contentCell = contentRow.createCell(n, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
					// 设置式样
					CellStyle thCellStyle = getContextStyle(workbook);
					contentCell.setCellStyle(thCellStyle);
					contentCell.setCellValue(listContent.get(n).toString());// 设置内容
				}
			}
			//excel内容
			System.out.println("SSSS"+listName.get(0).size());
			for (int i = 0; i < listName.get(0).size(); i++) {
				listName1.add(listName.get(0).get(i).toString());
				System.out.println(listName.get(0).size());
				System.out.println(listName.get(0).get(i));
			}
			System.out.println(listName1.get(0));;
			System.out.println(fixedGrouping(listName1, 6));;
			
			for (int i = 0; i < fixedGrouping(listName1, 6).size()-1; i++) {
				System.out.println("AAAAAAA"+fixedGrouping(listName1, 6).get(i));
				for(int m=0;m<fixedGrouping(listName1, 6).get(i).size();m++) {
					//设置单元格合并
						sheet.addMergedRegion(new CellRangeAddress((5+m),(5+m),6,7));
						Row contentRow = sheet.createRow(5+i);
						contentRow.setHeightInPoints(40);
						List<String> listContent=fixedGrouping(listName1, 6).get(i);
					for(int n=0;n<listContent.size();n++) {
						Cell contentCell = contentRow.createCell(n, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
						// 设置式样
						CellStyle thCellStyle = getContextStyle(workbook);
						contentCell.setCellStyle(thCellStyle);
						contentCell.setCellValue(listContent.get(n).toString());// 设置内容
					}
				}
			}
		}else {
			for(int m=0;m<listName.size();m++) {
				Row contentRow = sheet.createRow(3+m);
				contentRow.setHeightInPoints(40);
				List listContent=(List) listName.get(m);
				for(int n=0;n<listContent.size();n++) {
					Cell contentCell = contentRow.createCell(n, Cell.CELL_TYPE_STRING);// 创建单元格从0开始
					// 设置式样
					CellStyle thCellStyle = getContextStyle(workbook);
					contentCell.setCellStyle(thCellStyle);
					contentCell.setCellValue(listContent.get(n).toString());// 设置内容
				}
			}
		}
		
		
		
		FileOutputStream outputStream = new FileOutputStream(excelPath);
		workbook.write(outputStream);// 将文档对象写入输出流

		outputStream.close();// 关闭文件输出流
		excel.logger.info("创建成功 office excel");
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
	

	// 设置标题式样
	public static CellStyle getTitleStyle(Workbook workbook) {

		Font font = workbook.createFont(); // 设置字体
		font.setFontHeightInPoints((short) 20);// 设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
		font.setFontName("仿宋体"); // 设置字体名字
		font.setColor(HSSFColor.BLACK.index); // 设置字体颜色

		// 设置样式;
		CellStyle style = workbook.createCellStyle();
		/*style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置底边框;
		style.setBottomBorderColor(HSSFColor.YELLOW.index);// 设置底边框颜色;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 设置左边框;
		style.setLeftBorderColor(HSSFColor.YELLOW.index); // 设置左边框颜色;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 设置右边框;
		style.setRightBorderColor(HSSFColor.YELLOW.index);// 设置右边框颜色;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 设置顶边框;
		style.setTopBorderColor(HSSFColor.YELLOW.index);// 设置顶边框颜色;
*/		style.setFont(font);// 在样式用应用设置的字体;
		style.setWrapText(false);// 设置自动换行;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 设置水平对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 设置垂直对齐的样式为居中对齐;
		return style;
	}

	// 设置表头式样
	private static CellStyle getThStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();// 创建样式对象
		// 设置对齐方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 设置边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 顶部边框粗线
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 设置左部边框双线
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 设置右部边框双线
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置底部边框双线
		style.setWrapText(true);// 设置单元格内容是否自动换行
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		// 设置单元格字体
		Font font = workbook.createFont();// 创建字体对象
		font.setFontHeightInPoints((short) 12);// 设置字体大小
		font.setColor(HSSFColor.BLACK.index);// 设置字体颜色
		font.setFontName("仿宋体");// 设置字体字
		style.setFont(font);

		return style;
	}

	// 设置内容式样
	private static CellStyle getContextStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();// 创建样式对象
		// 设置对齐方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 设置边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 顶部边框粗线
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 设置左部边框双线
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 设置右部边框双线
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置底部边框双线
		style.setWrapText(true);// 设置单元格内容是否自动换行
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		// 设置单元格字体
		Font font = workbook.createFont();// 创建字体对象
		font.setFontHeightInPoints((short) 12);// 设置字体大小
		font.setColor(HSSFColor.BLACK.index);// 设置字体颜色
		font.setFontName("仿宋体");// 设置字体字
		style.setFont(font);

		return style;
	}
	/**
	 * 读取excell文件的内容
	 * @param filename 文件的位置和名称
	 * @return
	 * @throws IOException
	 */
	public static List<List<Object>> readExcel(String filename) throws IOException {
		File file = new File(filename);
		Workbook workbook = null;
		if (filename.endsWith(".xlsx")) {// excel 2007
			workbook = new XSSFWorkbook(new FileInputStream(file));// 创建一个excell对象
		} else if (filename.endsWith(".xls")) {// excel 2003
			workbook = new HSSFWorkbook(new FileInputStream(file));// 创建一个excel文档对象
		}

		Sheet sheet = workbook.getSheetAt(0);// 读取第一个sheet页表格的内容
		Object value = null;
		Row row = null;
		Cell cell = null;

		System.out.println("读取office excel 内容如下");

		// 行
		List<List<Object>> listRow = new LinkedList<List<Object>>();

		for (int i = sheet.getFirstRowNum()+3; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}

			// 列
			List<Object> listCell = new LinkedList<>();
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}

				DecimalFormat dFormat = new DecimalFormat("0");// 格式化 number String
				DecimalFormat nFormat = new DecimalFormat("0");// 格式化数字

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 格式化日期字符串  HH:mm:ss
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:// 字符串 -String type
					value = cell.getRichStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:// 数字 -number type
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = dFormat.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = nFormat.format(cell.getNumericCellValue());
					} else {
						if (HSSFDateUtil.isCellDateFormatted(cell)) {  // 判断是否是日期类型
							 Date dateCellValue = cell.getDateCellValue();
							value = simpleDateFormat.format(dateCellValue);
					}
						
					}
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:// boolean -boolean type
					value = cell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:// 空白 -blank type
					value = "";
					break;
				default:// default type
					value = cell.toString();
					// break;
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				listCell.add(value);
			}
			listRow.add(listCell);
		}
		return listRow;
	}
	
	public static void main(String[] args) throws Exception {
		List<List<Object>> list=ExportExcel.readExcel("C:\\Users\\Administrator\\Downloads\\_日志记录表(20180611).xlsx");
		for (List<Object> lis : list) {
			for (Object object : lis) {
				System.out.println(object);
			}
		}
	}

}
