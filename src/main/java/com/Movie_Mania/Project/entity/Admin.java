/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "admin_details")
public class Admin extends User{
	
	@Column(name = "date_Of_Birth")
	private  LocalDate dateOfBirth;
	@Column(name = "admin_contact")
	private String adminContact;
	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 */
	public Admin(Integer userId, String userName, String password) {
		super(userId, userName, password);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param dateOfBirth
	 * @param adminContact
	 */
	public Admin(Integer userId, String userName, String password, LocalDate dateOfBirth, String adminContact) {
		super(userId, userName, password);
		this.dateOfBirth = dateOfBirth;
		this.adminContact = adminContact;
	}
	@Override
	public String toString() {
		return "Admin [dateOfBirth=" + dateOfBirth + ", adminContact=" + adminContact + "]";
	}
	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the adminContact
	 */
	public String getAdminContact() {
		return adminContact;
	}
	/**
	 * @param adminContact the adminContact to set
	 */
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	
	
	
	
	
	

}
