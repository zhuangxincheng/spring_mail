package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.demo.controller.RequestMappingHandlerTest;
import com.demo.utils.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("all")
public class RedisTest {
	private static Logger logger = LoggerFactory.getLogger(RequestMappingHandlerTest.class);
	@Autowired
	RedisUtil RedisUtil;
	@Test
	public void contextLoads() throws InterruptedException {
		try {
			JSONArray a = RedisUtil.getJson("1233",JSONArray.class);
			List<String> users = new ArrayList<String>();
			users.add("张三");
			users.add("李四");
			logger.info("---"+JSON.toJSONString(users));
			RedisUtil.set("1233", users, 120L);
			
			logger.info("---"+a);
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
}
