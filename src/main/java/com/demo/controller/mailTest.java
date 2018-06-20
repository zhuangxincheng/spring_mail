package com.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressWarnings("all")
public class mailTest {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long ago = 0L;
		try {
			 ago = format.parse("2018-03-21").getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long a = date.getTime();
		System.out.println(a>ago);
		
//		List<String> aa = new ArrayList<String>();
//		aa.add("123");
//		aa.add("zxc");
//		aa.add("456");
//		aa.add("789");
//		System.out.println(aa.subList(2, 4));
		//C:\Program Files\Java\jdk1.8.0_45\bin
		
		
//		User user = new User();
//		user.setUsername("张三");
//		user.setPassword("1234");
		
//		System.out.println(JSONObject.toJSONString(user));
//		byte[] bytes = SerializeUtil.serialize(user);
//		User user_new = (User) SerializeUtil.unserialize(bytes);
//		System.out.println(JSONObject.toJSONString(user_new));
		
//		List<User> users = (List<User>) user;
		
		// 继承Thread类实现多线程
//        new Thread() {
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + "--" + i);
//                }
//            }
//        }.start();
//        // 实现Runnable接口实现多线程
//        new Thread(new Runnable() {
//
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + "--" + i);
//                }
//            }
//        }) {
//        }.start();
		
	}
}
