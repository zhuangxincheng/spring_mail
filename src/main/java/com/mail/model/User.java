package com.mail.model;

import com.demo.config.NotEmpty;

import java.io.Serializable;


public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @NotEmpty(groups = AAA.class,message = "username不能为空")
    private String username;
    @NotEmpty(groups = AAA.class,message = "password不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public interface AAA{}
}