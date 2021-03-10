package com.lucy.model;

public class EmailListVo {
	private int idemaillist;
	private String firstname;
	private String lastname;
	private String email;
	
	/*CONSTRUCTOR*/
	public EmailListVo(int idemaillist, String firstname, String lastname, String email) {
		this(firstname, lastname, email);
		this.idemaillist=idemaillist;
	}
	public EmailListVo(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	/*GETTER SETTER*/
	public int getIdemaillist() {
		return idemaillist;
	}
	public void setIdemaillist(int idemaillist) {
		this.idemaillist = idemaillist;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailVo [idemaillist=" + idemaillist + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + "]";
	}

}
