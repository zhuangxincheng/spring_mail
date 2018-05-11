package com.demo.javabean;

import io.swagger.annotations.ApiModelProperty;

public class testDo {
	@ApiModelProperty("性别")
	private String sex;
	@ApiModelProperty("手机号")
	private String phonenum;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	
}
