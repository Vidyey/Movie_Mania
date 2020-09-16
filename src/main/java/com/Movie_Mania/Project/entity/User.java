/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.io.Serializable;

import javax.persistence.* ;

@MappedSuperclass
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="PASSWORD")
	private String password;

	public User(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + "]";
	}
	
	
	
	
		
	
	
}
