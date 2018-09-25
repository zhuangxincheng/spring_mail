package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.javabean.TestBean;
import com.demo.utils.sendMailUtil;
import com.mail.mapping.UserMapper;
import com.mail.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/springboot/")
@Api(value = "SendMailController", description = "邮件发送模块")
public class SendMailController {
	private static Logger logger = LoggerFactory.getLogger(SendMailController.class);
	@Autowired
	sendMailUtil sendMailUtil;
	@Autowired
	Task Task;
	@Autowired
	UserMapper mapper;
	@Autowired
	ApplicationContext applicationContext;

	@ApiOperation(value = "邮件发送", notes = "通过javamailSender")
	@RequestMapping(value = "sendMail", method = RequestMethod.GET)
	public void sendMail(TestBean test) throws InterruptedException, ExecutionException {
		String[] email = new String[] { "xincheng.zhuang@wowjoy.cn", "ceshi1@wowjo.cn", "ceshi2@wowjoy.cn",
				"ceshi3@wowjoy.cn" };
		String title = "測試";
		String text = "測試";
		String html = "<html><head>" + "</body></html>";
		long start = System.currentTimeMillis();
		int code = 0;

		List<Future<String>> list = new ArrayList<Future<String>>();
		Future<String> tatsk = null;
		for (int i = 0; i < email.length; i++) {

			tatsk = sendMailUtil.sendHtml("xincheng.zhuang@wowjoy.cn", "18249512862Zxc", title, html, email[i]);

			list.add(tatsk);

			while (true) {
				if (tatsk.get().equals("200")) {
					break;
				}
			}

		}

		// while (true) {
		// String aaa = list.get(list.size() - 1).get();
		// if (list.get(list.size() - 1).get().equals("200")) {
		// Thread.sleep(500);
		// break;
		// }
		//
		// }
		// for(Future<String> feture : list) {
		// if(feture.isDone()) {
		// flag = true;
		// }else {
		// flag = false;
		// }
		// }
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

	@ApiOperation(value = "用户信息获取", notes = "用户信息获取")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "String")
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public List<User> getUserOnfo(String userId) {
		List<User> users = mapper.selectByExample(null);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		// 查看配置数据源信息
		System.out.println(dataSource);
		System.out.println(dataSource.getClass().getName());
		return users;
	}

	@RequestMapping(value = "testTask", method = RequestMethod.GET)
	public void testTask() {
		Task.doTaskOne();
		Task.doTaskTwo();
	}
	
	@RequestMapping(value = "testTask", method = RequestMethod.PUT)
	public void testTaskEdit() {
		Task.doTaskOne();
		Task.doTaskTwo();
	}

}
