package pers.qiuyuzu.servlet;


public class User {
	private String username;
	private String password;
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCopy() {
		//return "write by &#x6D77;&#x632F;&#x949F;-13008082 ";
		return "Copyright © 2018 上海理工大学 版权所有 All Rights Reserved   ";
	}
}
