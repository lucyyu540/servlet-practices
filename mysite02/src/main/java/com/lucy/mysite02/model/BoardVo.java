package com.lucy.mysite02.model;

public class BoardVo {
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", g_no=" + g_no + ", o_no=" + o_no + ", depth=" + depth + ", authorNo=" + authorNo
				+ ", author=" + author + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date
				+ ", count=" + count + "]";
	}
	private int no;//board no
	private int g_no;
	private int o_no;
	private int depth;
	
	private int authorNo;//user no
	private String author;//name
	
	
	private String title;
	private String content;
	private String reg_date;
	private int count; 
	public BoardVo() {}
	/*CONSTRUCTORS*/
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
	/*GETTER SETTER*/
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
