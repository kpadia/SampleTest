package com.tcs.ilp.bean;

public class UserBean {
	private String username;
    private String password;
    private String name;
    public String usertype;
    private String emailId;
    private String contact;
    
    private int userid;
   
   
    public boolean valid;
    
    
    public int getUserId() {
    	return userid;
    }
    public void setUserId(int userid) {
    	this.userid = userid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserType() {
		return usertype;
	}
	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
