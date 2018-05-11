package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.demo.javabean.Hero;
import com.demo.utils.ExcelUtil;
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

}
