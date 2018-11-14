package com.demo.controller;

import com.demo.javabean.TestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 查看项目所有URL对应的Controller和方法
 */
@Controller
@SuppressWarnings("all")
public class RequestMappingHandlerTest {
	private static Logger logger = LoggerFactory.getLogger(RequestMappingHandlerTest.class);
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "/admin/util/url2controller", method = RequestMethod.GET)
	@ResponseBody
	public void list(HttpServletResponse response, TestBean test) {
		logger.info("=====");
		StringBuilder sb = new StringBuilder();
		sb.append("URL").append("--").append("Class").append("--").append("Function").append('\n');
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
			RequestMappingInfo info = m.getKey();
			HandlerMethod method = m.getValue();
			sb.append(info.getPatternsCondition()).append("--");
			sb.append(info.getMethodsCondition()).append("--");
			sb.append(method.getMethod().getDeclaringClass()).append("--");
			MethodParameter[] paramers = method.getMethodParameters();
			if (paramers != null && paramers.length > 0) {
				for (int i = 0; i < paramers.length; i++) {
					Class<?> parameterType = paramers[i].getParameterType();
					PropertyDescriptor[] des = BeanUtils.getPropertyDescriptors(parameterType);
					for (int j = 0; j < des.length; j++) {
						if (!"class".equals(des[j].getName())) {
							sb.append(des[j].getName()).append("--");
						}

					}

				}

			}
			sb.append(method.getMethod().getName()).append('\n');
		}

		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}
}
