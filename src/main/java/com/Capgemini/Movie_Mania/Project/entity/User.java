/**
 * 
 */
package com.Capgemini.Movie_Mania.Project.entity;

import java.io.Serializable;

import javax.persistence.* ;

@MappedSuperclass
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 30,name="USER_ID")
	private String username;
	
	@Column(length = 20,name="PASSWORD",nullable = false)
	private String password;
	
	@Column(length = 40, nullable = false)
	private String securityQuestion;
	@Column(length = 20, nullable = false)
	private String answer;

	

	public User(String username, String password, String securityQuestion, String answer) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public User() {
		super();
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

	
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", securityQuestion=" + securityQuestion
				+ ", answer=" + answer + "]";
	}

	
	
}
