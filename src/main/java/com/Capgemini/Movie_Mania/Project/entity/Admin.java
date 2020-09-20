package com.Movie_Mania.Project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "admin_details")
public class Admin extends User{
	
	
	private static final long serialVersionUID = 1L;
	@Column(name = "admin_name")
	private  String adminName;
	

	@Column(name = "admin_contact")
	private String adminContact;
	
	public Admin() {
		super();
	}
	
	public Admin(Integer userId, String password, String adminName, String adminContact) {
		super(userId, password);
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
