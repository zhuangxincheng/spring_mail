package com.demo;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.demo.javabean.TestBean;

/** 
 * 查看项目所有URL对应的Controller和方法 
 */  
 @SuppressWarnings("all")
public class RequestMappingHandlerTest {
	@Test
	public void test() {
		TestBean TestBean = new TestBean();
		
		TestBean.setSex("女");
		System.out.println(TestBean.getSex());
	}
}
