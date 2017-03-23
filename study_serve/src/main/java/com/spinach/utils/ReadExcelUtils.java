package com.spinach.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

public class ReadExcelUtils {
	private String filePath;
	private Workbook workBook;
	private Sheet sheet;
	private List<String> columnHeaderList;
	private List<List<String>> listData;
	private List<Map<String, String>> mapData;
	private InputStream inputStream;
	private boolean flag;

	/**
	 * 构造函数初始化
	 * 
	 * @param filePath
	 */
	public ReadExcelUtils(String filePath) {
		this.filePath = filePath;
		this.inputStream = null;
		this.flag = false;
		this.load();
		this.getSheetData();
	}

	/**
	 * 流化构造器
	 * 
	 * @param stream
	 */
	public ReadExcelUtils(InputStream stream) {
		this.filePath = "";
		this.inputStream = stream;
		this.load();
		this.getSheetData();
	}

	/**
	 * 根据需求默认读取SHEET为第一个的单元格数据
	 */
	private void load() {
		FileInputStream inStream = null;
		try {
			// 若是流为空，路径不为空
			if (inputStream == null && StringUtils.isNotEmpty(filePath)) {
				inStream = new FileInputStream(new File(filePath));
			} else if (inputStream != null && StringUtils.isEmpty(filePath)) {
				inStream = (FileInputStream) inputStream;
			}
			workBook = WorkbookFactory.create(inStream);
			sheet = workBook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * 单元格数值格式化处理，基本规则是吧所以数据转成字符串类型
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:19:29
	 * @param cell
	 * @return
	 */
	private static String getCellValue(Cell cell) {
		String cellValue = "";

		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) { // 如果是时间类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					cellValue = format.format(cell.getDateCellValue());
				} else { // 纯数字
					cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				cellValue = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				cellValue = "";
				break;
			default:
				cellValue = cell.toString().trim();
				break;
			}
		}
		return cellValue.trim();
	}

	/**
	 * 获取数据
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:19:56
	 */
	@SuppressWarnings("static-access")
	private void getSheetData() {
		listData = new ArrayList<List<String>>();
		// 将每行的的数据以Map的Key键值处理，键值为列名，数值为单元格数值
		mapData = new ArrayList<Map<String, String>>();
		// 将第一行的列名形成数组
		columnHeaderList = new ArrayList<String>();
		int numOfRows = sheet.getLastRowNum() + 1;
		List<CellRangeAddress> listCombineCell = getCombineCell(sheet);
		String cellvalue = null;
		for (int i = 0; i < numOfRows; i++) {
			Row row = sheet.getRow(i);
			Map<String, String> map = new HashMap<String, String>();
			List<String> list = new ArrayList<String>();
			if (row != null) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);

					if (i == 0) {
						columnHeaderList.add(getCellValue(cell));
					} else {
						cellvalue = this.getCombineCell(listCombineCell, cell, sheet);

						// System.out.println(columnHeaderList.size());
						// System.out.println(j);
						if (columnHeaderList.size() > j) {
							map.put(columnHeaderList.get(j), cellvalue);
						}

					}
					list.add(this.getCellValue(cell));
				}
			}
			if (i > 0) {
				mapData.add(map);
			}
			listData.add(list);
		}
		try {
			if(null != inputStream){
				this.inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		flag = true;
	}

	/**
	 * 拓展接口方法，根据行和列或者单元格数值
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:20:19
	 * @param row
	 * @param col
	 * @return
	 */
	public String getCellData(int row, int col) {
		if (row <= 0 || col <= 0) {
			return null;
		}
		if (!flag) {
			this.getSheetData();
		}

		if (listData.size() >= row && listData.get(row - 1).size() >= col) {
			return listData.get(row - 1).get(col - 1);
		} else {
			return null;
		}
	}

	/**
	 * 拓展接口方法，根据行和列明获取单元格
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:20:35
	 * @param row
	 * @param headerName
	 * @return
	 * @throws Exception
	 */
	public String getCellData(int row, String headerName) throws Exception {
		if (row <= 0) {
			return null;
		}
		if (!flag) {
			this.getSheetData();
		}

		if (mapData.size() >= row && mapData.get(row - 1).containsKey(headerName)) {
			return mapData.get(row - 1).get(headerName);
		} else {
			return null;
		}
	}

	/**
	 * 确认所需要的抬头名EXCEL是否存在，存在则继续解析，不存在抛出异常
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:20:44
	 * @param columnHeaderList
	 * @param checkHeaderNames
	 * @return
	 * @throws Exception
	 */
	public boolean checkColumnHeaderExist(List<String> columnHeaderList, String[] checkHeaderNames) throws Exception {
		String headername = null;
		String checkHeaderName = null;
		Boolean isExsit = null;
		for (int i = 0; i < checkHeaderNames.length; i++) {
			checkHeaderName = checkHeaderNames[i];
			isExsit = false;
			for (int j = 0; j < columnHeaderList.size(); j++) {
				headername = columnHeaderList.get(j);
				if (headername.equals(checkHeaderName)) {
					isExsit = true;
					break;
				}
			}
			if (!isExsit) {
				throw new RuntimeException("列明为空");
			}
		}
		return true;
	}

	/**
	 * 获取做过合并单元格的List数组
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:20:52
	 * @param sheet
	 * @return
	 */
	private static List<CellRangeAddress> getCombineCell(Sheet sheet) {
		List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
		// 获得一个 sheet 中合并单元格的数量
		int sheetmergerCount = sheet.getNumMergedRegions();
		// 遍历合并单元格
		for (int i = 0; i < sheetmergerCount; i++) {
			// 获得合并单元格加入list中
			CellRangeAddress ca = sheet.getMergedRegion(i);
			list.add(ca);
		}
		return list;
	}

	/**
	 * 根据合并单元格的数组和单元格的CELL 对象，或缺该CELL对应的合并单元格的值
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:21:04
	 * @param listCombineCell
	 * @param cell
	 * @param sheet
	 * @return
	 */
	private static String getCombineCell(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet) {
		int firstC = 0;
		int lastC = 0;
		int firstR = 0;
		int lastR = 0;
		String cellValue = "";
		for (CellRangeAddress ca : listCombineCell) {
			// 获得合并单元格的起始行, 结束行, 起始列, 结束列
			firstC = ca.getFirstColumn();
			lastC = ca.getLastColumn();
			firstR = ca.getFirstRow();
			lastR = ca.getLastRow();
			if (null != cell && cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
				if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
					Row fRow = sheet.getRow(firstR);
					Cell fCell = fRow.getCell(firstC);
					cellValue = getCellValue(fCell);
					return cellValue;
				}
			}
		}
		cellValue = getCellValue(cell);
		return cellValue;
	}

	/**
	 * 根据列名数组解析EXCEL数据 获取List
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:21:17
	 * @param headerNames
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Object[]> readExcelByHeaderNames(String[] headerNames) throws Exception {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		String headerName;
		// 如果没有初次解析过表头和所有数据则运行getSheetData方法解析一次表头
		if (!flag) {
			this.getSheetData();
		}
		// 列名重组
		headerNames = sortNewHeaderNames(headerNames);
		// 先判断列明是否全部存在 ，存在再解析，不存在返回异常信息
		checkColumnHeaderExist(columnHeaderList, headerNames);
		int rowEmptyCount;
		for (int i = 0; i < mapData.size(); i++) {
			rowEmptyCount = 0;
			Object[] objects = new Object[headerNames.length];
			for (int j = 0; j < headerNames.length; j++) {
				headerName = headerNames[j];
				objects[j] = mapData.get(i).get(headerName);

				if (objects[j] == null || "".equals(objects[j])) {
					rowEmptyCount++;
				}
			}
			// 当为空数量小于列明数量证明该数据是有效数据 ，进入list数组
			if (rowEmptyCount < headerNames.length) {
				list.add(objects);
			} else {
				// 当为最后一行 时正常导入，当不为最后一行时抛出异常
				if (i < mapData.size() - 1) {
					throw new RuntimeException("数据格式不正确:第" + (i + 2) + "行");
				} else {
					System.out.println("1111");
					return list;
				}
			}
		}
		return list;
	}

	/**
	 * 列明数组重组
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:21:27
	 * @param headerNames
	 * @return
	 * @throws RuntimeException
	 */
	private String[] sortNewHeaderNames(String[] headerNames) throws RuntimeException {
		// 非附加集合
		List<String> nomalHeaderNamesList = new ArrayList<String>();
		// 附加集合
		List<String> allLikeHeaderNameList = new ArrayList<String>();
		// 所有集合，最后先非附加集合和附加集合按顺序进入所有集合
		List<String> allHeaderNameList = new ArrayList<String>();
		// 列名
		String headerName = null;
		// 列名替换临时变量
		String headerNametemp = null;
		// Excel列名
		String excelheaderName = null;
		int headerNameLikeCount = 0;
		// 根据列名数组查询Excel匹配的列明
		for (int i = 0; i < headerNames.length; i++) {
			headerName = headerNames[i].trim();
			if (headerName.length() > 0) {
				// 区分是否为附加的列名
				if (!String.valueOf(headerName.charAt(headerName.length() - 1)).equals("+")) {
					nomalHeaderNamesList.add(headerName);

				} else {
					headerNametemp = headerName.substring(0, headerName.length() - 1);
					headerNameLikeCount = 0;
					for (int j = 0; j < columnHeaderList.size(); j++) {
						excelheaderName = columnHeaderList.get(j);
						if (excelheaderName.indexOf(headerNametemp) == 0) {
							allLikeHeaderNameList.add(excelheaderName);
							headerNameLikeCount++;
						}
					}
					// 如果查询不到列名数组给出的列名报出异常
					if (headerNameLikeCount == 0) {
						throw new RuntimeException("列明为空:" + headerName);
					}
					headerNameLikeCount = 0;
				}
			}
			headerName = null;
		}
		// 列名数组重组，获取新的列名数组
		allHeaderNameList.addAll(nomalHeaderNamesList);
		allHeaderNameList.addAll(allLikeHeaderNameList);
		String[] newHeaderNames = new String[allHeaderNameList.size()];
		for (int i = 0; i < allHeaderNameList.size(); i++) {
			newHeaderNames[i] = allHeaderNameList.get(i);
		}
		return newHeaderNames;
	}

	/**
	 * Excel解析exsample
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:21:42
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ReadExcelUtils eh = new ReadExcelUtils("F:\\11.xlsx");
		String[] HeaderNanames = { "流转状态", "订单号/包裹号","SKU","商品名称","品牌名称","商品数量","商品实付金额（CNY）"};
		
		List<Object[]> list = eh.readExcelByHeaderNames(HeaderNanames);
		Object[] objects = null;
		/*for (int i = 0; i < list.size(); i++) {
			objects = (Object[]) list.get(i);
			for (int j = 0; j < objects.length; j++) {
				System.out.println("序列" + i + ":" + objects[j]);
			}
		}*/
	}

}