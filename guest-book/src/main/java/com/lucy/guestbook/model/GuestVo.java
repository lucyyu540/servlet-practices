package com.lucy.guestbook.model;

public class GuestVo {
	private String name;
	private String password;
	private int idguestbook;
	private String text;
	private String date;
	public GuestVo(String name, String password, String text) {
		this.name = name;
		this.password = password;
		this.text = text;
	}
	public GuestVo(int id, String name2, String text2, String date2) {
		this.idguestbook=id;
		this.name = name2;
		this.text = text2;
		this.date = date2;
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
	public int getIdguestbook() {
		return idguestbook;
	}
	public void setIdguestbook(int idguestbook) {
		this.idguestbook = idguestbook;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
