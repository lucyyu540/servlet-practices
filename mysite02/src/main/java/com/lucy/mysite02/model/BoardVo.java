package com.lucy.mysite02.model;

public class BoardVo {
	private int no;
	private int authorNo;
	private String author;
	private String title;
	private String content;
	private String reg_date;
	public BoardVo() {}
	public BoardVo(int authorNo, String title, String content) {
		this.setAuthorNo(authorNo);
		this.title = title;
		this.content = content;
	}
	public BoardVo(int no, int authorNo, String author, String title, String content, String reg_date) {
		this.authorNo = authorNo;
		this.author = author;
		this.title = title;
		this.content = content;
		this.no = no;
		this.reg_date = reg_date;
		
	}

	public BoardVo(int no, String author, String title, String content, String date) {
		this.no = no;
		this.author = author;
		this.title = title;
		this.content = content;
		this.reg_date = date;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

}
