package com.demo;

import com.alibaba.fastjson.JSON;
import com.demo.javabean.Hero;
import com.demo.utils.ExcelUtil;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

@SuppressWarnings("all")
public class ImportExcel {
	@Test
	public void importData() {
		File file = new File("C:\\Users\\zhuangxincheng\\Desktop\\测试.xlsx");
		Workbook wb = null;
		List<Hero> HeroList = new ArrayList();
		try {
			if (ExcelUtil.isExcel2007(file.getPath())) {
				wb = new XSSFWorkbook(new FileInputStream(file));
			} else {
				wb = new HSSFWorkbook(new FileInputStream(file));
			}
		} catch (IOException e) {
			e.printStackTrace();

			//return null;
		}

		Sheet sheet = wb.getSheetAt(0);// 获取第一张表
		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
			Row row = sheet.getRow(i);// 获取索引为i的行，以0开始
			String name = row.getCell(0).getStringCellValue();// 获取第i行的索引为0的单元格数据
			String age =  row.getCell(1).getStringCellValue();
			
			Hero hero = new Hero();
			hero.setName(name);
			hero.setAge(age);
			HeroList.add(hero);
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print((Map)JSON.toJSON(HeroList.get(0)));
		Map map = new HashedMap<>();
		map.put("aaa", "111");
		System.out.print(map);
	}
	@Test
	public void mapToXml() throws Exception {
		Map<String, String>  map = new HashMap<>();
		map.put("asd","34344");
		map.put("qqqq","sdrer");
		this.mapToXml(map);
	}

	public String mapToXml(Map<String, String> data) throws Exception {
		String a =  UUID.randomUUID().toString().replace("-","");

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document document = documentBuilder.newDocument();
		org.w3c.dom.Element root = document.createElement("xml");
		document.appendChild(root);
		for (String key: data.keySet()) {
			String value = data.get(key);
			if (value == null) {
				value = "";
			}
			value = value.trim();
			org.w3c.dom.Element filed = document.createElement(key);
			filed.appendChild(document.createTextNode("<![CDATA["+value+"]]>"));
			root.appendChild(filed);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
		try {
			writer.close();
		}
		catch (Exception ex) {
		}
		output = output.replace("&lt;", '<' + "");
		output = output.replace("&gt;", '>' + "");
		output =  output.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>","");
		return output;
	}

}
