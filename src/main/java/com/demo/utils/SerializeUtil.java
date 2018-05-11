package com.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.mail.model.User;
@SuppressWarnings("all")
public class SerializeUtil {
	/**
	 * 序列化
	 * 
	 * @param list
	 * @return
	 */
	public static byte[] serialize(Object obj) {
		// 申明存放数组
		byte[] arr = null;
		// 对象流，用于序列化对象
		ObjectOutputStream os = null;
		// 临时输入流
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(obj);
			arr = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	/**
	 * 反序列化
	 * 
	 * @param in
	 * @return
	 */
	public static Object unserialize(byte[] in) {

		 ObjectInputStream oii=null;
	        ByteArrayInputStream bis=null;
	        bis=new ByteArrayInputStream(in);
	        try {
	            oii=new ObjectInputStream(bis);
	            Object obj=oii.readObject();
	            return obj;
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        }
	    
	        
	        return null;
	}
}
