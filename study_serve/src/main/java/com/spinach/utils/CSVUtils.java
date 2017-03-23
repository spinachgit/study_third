package com.spinach.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.appcore.util.JSONUtil;

/**
 * CSV操作(导出和导入)
 * 
 * @author wanghuihui
 * @time: 2017年3月23日上午9:36:47
 */
public class CSVUtils {
	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CSVUtils.class);

	/**
	 * 导出
	 * 
	 * @param file
	 *            csv文件(路径+文件名)，csv文件不存在会自动创建
	 * @param dataList
	 *            数据
	 * @return
	 */
	public static boolean exportCsv(File file, List<String> dataList) {
		if (dataList == null || dataList.isEmpty()) {
			logger.info("数据为空，不能导出！");
			return false;
		}
		boolean isSucess = false;
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out, "GBK");
			bw = new BufferedWriter(osw);

			for (String data : dataList) {
				bw.append(data).append("\r");
			}
			isSucess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isSucess;
	}

	/**
	 * 导入 InputStream
	 * 
	 * @param file
	 *            文件(路径+文件)
	 * @return
	 */
	public static List<String[]> importCsv(InputStream is) {
		List<String[]> dataList = new ArrayList<String[]>();
		BufferedReader br = null;
		try {
			DataInputStream dataIS = new DataInputStream(is);
			br = new BufferedReader(new InputStreamReader(dataIS, "GBK"));
			String line = "";
			while ((line = br.readLine()) != null) {
				dataList.add((line + ",000").split(","));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}

	/**
	 * 导入
	 * 
	 * @param file
	 *            csv文件(路径+文件)
	 * @return
	 * @throws FileNotFoundException
	 */
	public static List<String[]> importCsv(File file) throws FileNotFoundException {
		BufferedReader br = null;
		if (!file.exists()) {
			logger.info("文件不存在，或者路径不正确！");
			return null;
		}
		List<String[]> dataList = importCsv(new FileInputStream(file));
		return dataList;
	}

	/**
	 * 根据列名数组解析CSV数据 获取List
	 * 
	 * @author:wanghuihui
	 * @date:2017年3月22日下午2:21:17
	 * @param headerNames
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String[]> readCSVByHeaderNames(String[] headerNames, List<String[]> dataList) throws Exception {
		//String headerName;
		// 先判断列明是否全部存在 ，存在再解析，不存在返回异常信息
		String[] columnHeaderList = dataList.get(0);
		//Integer[] flag = checkColumnHeaderExist(columnHeaderList, headerNames);
		//int rowEmptyCount;
		List<Integer> objects = new ArrayList<Integer>();
		for (int i = 0; i < columnHeaderList.length; i++) {
			for (int j = 0; j < headerNames.length; j++) {
				if (headerNames[j].equals(columnHeaderList[i])) {
					objects.add(i);
				}
			}
		}
		ArrayList<String[]> list = new ArrayList<String[]>(dataList.size()-1);
		for(int i=1;i<dataList.size();i++){
			String[] data = dataList.get(i);
			String[] arr = new String[objects.size()];
			for(int j=0;j<objects.size();j++){
				arr[j] = data[objects.get(j)];
			}
			list.add(arr);
		}
		return list;
	}



	/**
	 * CSV导出 test
	 * 
	 * @throws Exception
	 */
	public void exportCsvTest() {
		List<String> dataList = new ArrayList<String>();
		dataList.add("1,张三,男");
		dataList.add("2,李四,男");
		dataList.add("3,小红,女");
		boolean isSuccess = CSVUtils.exportCsv(new File("E:/ljq.csv"), dataList);
		System.out.println(isSuccess);
	}

	/**
	 * CSV导入
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @throws Exception
	 */
	public void importCsvTest() throws FileNotFoundException {
		List<String[]> dataList = CSVUtils.importCsv(new File("F:\\doc\\excel\\衣岚香衣泽香 聚美对账单 2017.2.1-2.16\\POP对账单POP1703010965_发货订单明细导出列表_20170301132101.csv"));
		if (dataList != null && !dataList.isEmpty()) {
			for (String[] data : dataList) {
				System.out.println(JSON.toJSONString(data));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		CSVUtils csv = new CSVUtils();
		// csv.importCsvTest();
		// csv.exportCsvTest();

		String str = ",,,,1234,1234,城,一直在,需要";
		String str2 = "合计,,,,72185.70,72121.02,230.00,11.18,0.00,0.00,0.00,10.00,-186.50,,,,,,,00";
		String[] arr = str2.split(",");
		List<String[]> dataList = CSVUtils.importCsv(new File("F:\\doc\\excel\\衣岚香衣泽香 聚美对账单 2017.2.1-2.16\\POP对账单POP1703010965_返点订单明细导出列表_20170301132105.csv"));
		String[] headerNames = { "流转状态", "订单号/包裹号", "SKU", "商品名称", "品牌名称", "商品数量", "商品实付金额（CNY）", "发货时间" };
		ArrayList<String[]> result = csv.readCSVByHeaderNames(headerNames, dataList);
		
		System.out.println(arr);
	}

}
