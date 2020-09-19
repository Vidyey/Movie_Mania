package com.Movie_Mania.Project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "admin_details")
public class Admin extends User{
	
	
	private static final long serialVersionUID = 1L;
	@Column(name = "admin_name",length = 30,nullable = false)
	private  String adminName;
	

	@Column(name = "admin_contact",length = 15,nullable = false)
	private String adminContact;
	
	public Admin() {
		super();
	}
	
	

	public Admin(Integer userId, String password, String securityQuestion, String answer, String adminName,
			String adminContact) {
		super(userId, password, securityQuestion, answer);
		this.adminName = adminName;
		this.adminContact = adminContact;
	}



	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
	
	
	
	
	

}
