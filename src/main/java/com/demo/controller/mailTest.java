package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class mailTest {
	public static void main(String[] args) {
		List<String> aa = new ArrayList<String>();
		aa.add(null);
		aa.add("zxc");
		System.out.println(aa.contains(null));
		
		
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
