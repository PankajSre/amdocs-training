package com.amdocs.training.model;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Long phoneNumber;

	public User() {
	}

	public User(String username, String password, Long phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
