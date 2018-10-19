package com.kafang.atgo.restful.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

//import com.kafang.atgo.service.api.RptActualService;

@Slf4j
public class CSVUtil {

	/*
	 * public static void main(String[] args) { RptActualService rptService =
	 * ServiceFactory.getService(RptActualService.class); int customerId=12; int
	 * strategyId=2002; SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd HH:mm:ss Date asOfDate; try {
	 * asOfDate = sdf.parse("2018-09-10"); List<RptActual>
	 * list=rptService.selectByCustomer(customerId, strategyId, asOfDate);
	 * List<Map<String, String>> exportData = new ArrayList<Map<String, String>>();
	 * for(RptActual ra:list) { log.info(""+ra); Map<String, String> row1 = new
	 * LinkedHashMap<String, String>(); row1.put("1",ra.getAsOfDate().toString());
	 * row1.put("2",ra.getCustomerName()); row1.put("3",ra.getClientName());
	 * exportData.add(row1); } LinkedHashMap<String, String> map = new
	 * LinkedHashMap<String, String>(); //设置列名 map.put("1", "AsOfDate");
	 * map.put("2", "CustomerName"); map.put("3", "ClientName"); File directory =
	 * new File("");//设定为当前文件夹 log.info(directory.getCanonicalPath());//获取标准的路径
	 * log.info(directory.getAbsolutePath());//获取绝对路径 //String path =
	 * "E:\\reateCSVFile"; String path = "./csvFile"; //文件名=生产的文件名称+时间戳 String
	 * fileName = "文件导出"; File file = CSVUtil.createCSVFile(exportData, map, path,
	 * fileName); String fileName2 = file.getName(); log.info("文件名称：" + fileName2);
	 * 
	 * 
	 * } catch (Exception e) { log.error("", e); }
	 * 
	 * }
	 */

	/**
	 * 创建文件
	 * 
	 * @param exportData
	 * @param map
	 * @param outPutPath
	 * @param fileName
	 * @return
	 */
	public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath, String fileName) {
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File(outPutPath);
			if (!file.exists()) {
				file.mkdir();
			}
			// 定义文件名格式并创建
			csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
			log.info("csvFile：" + csvFile);
			// UTF-8使正确读取分隔符","
			// 如果生产文件乱码，windows下用gbk，linux用UTF-8
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"),
					1024);
			log.info("csvFileOutputStream：" + csvFileOutputStream);
			// 写入文件头部
			for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
				csvFileOutputStream
						.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "");
				if (propertyIterator.hasNext()) {
					csvFileOutputStream.write(",");
				}
			}
			csvFileOutputStream.newLine();
			// 写入文件内容
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
				Object row = (Object) iterator.next();
				for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
					java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
					csvFileOutputStream.write((String) BeanUtils.getProperty(row, (String) propertyEntry.getKey()));
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
				}
				if (iterator.hasNext()) {
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();
		} catch (Exception e) {
			log.error("createCSVFile outPutPath：{},fileName：{},error：{}", outPutPath, fileName, e);
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				log.error("", e);
			}
		}
		return csvFile;
	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param csvFilePath 文件路径
	 * @param fileName    文件名称
	 * @throws IOException
	 */
	public static void exportFile(HttpServletResponse response, String csvFilePath, String fileName)
			throws IOException {
		response.setContentType("application/csv;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		InputStream in = null;
		try {
			in = new FileInputStream(csvFilePath);
			int len = 0;
			byte[] buffer = new byte[1024];
			response.setCharacterEncoding("UTF-8");
			OutputStream out = response.getOutputStream();
			while ((len = in.read(buffer)) > 0) {
				out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
				out.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			log.error("exportFile csvFilePath：{},fileName：{},error：{} ", csvFilePath, fileName, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param filePath 文件目录路径
	 * @param fileName 文件名称
	 */
	public static void deleteFile(String filePath, String fileName) {
		File file = new File(filePath);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					if (files[i].getName().equals(fileName)) {
						files[i].delete();
						return;
					}
				}
			}
		}
	}

}
