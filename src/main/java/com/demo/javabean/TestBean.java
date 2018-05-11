package com.demo.javabean;

import io.swagger.annotations.ApiModelProperty;

public class TestBean extends testDo{
	@ApiModelProperty("姓名")
	private String name;
	@ApiModelProperty("用户id")
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
