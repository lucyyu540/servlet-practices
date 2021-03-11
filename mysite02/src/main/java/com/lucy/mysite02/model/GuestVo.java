package com.lucy.mysite02.model;

public class GuestVo {
	private String name;
	private String password;
	private int no;
	private String contents;
	private String reg_date;
	public GuestVo(String name, String password, String text) {
		this.name = name;
		this.password = password;
		this.contents = text;
	}
	public GuestVo(int id, String name2, String text2, String date2) {
		this.no=id;
		this.name = name2;
		this.contents = text2;
		this.reg_date = date2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


}
