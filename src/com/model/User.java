package com.model;

public class User {
	private Integer id;
	private String name;
	private String accessName;
	private String password;
	private Integer numberPost;
	private String email;

	public User(String name, String accessName, String password, Integer id, String email) {
		this.name = name;
		this.accessName = accessName;
		this.password = TransformaStringMD5.md5(password);
		this.id = id;
		this.numberPost = 0;
		this.email = email;
	}

	public User(String accessName, String password) {
		this.accessName = accessName;
		this.password = TransformaStringMD5.md5(password);
	}

	public User(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = TransformaStringMD5.md5(password);
	}

	public Integer getNumberPost() {
		return numberPost;
	}

	public void setNumberPost(Integer numberPost) {
		this.numberPost = numberPost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
