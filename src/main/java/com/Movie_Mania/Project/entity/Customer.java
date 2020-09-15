/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "customer_details")
public class Customer extends User {

	@Column(name = "date_Of_Birth")
	private LocalDate dateOfBirth;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(targetEntity = Ticket.class )
	private List<Ticket> myTickets;
	@Column(name = "Customer_contact")
	private String customerContact;
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param dateOfBirth
	 * @param myTickets
	 * @param customerContact
	 */
	public Customer(Integer userId, String userName, String password, LocalDate dateOfBirth, List<Ticket> myTickets,
			String customerContact) {
		super(userId, userName, password);
		this.dateOfBirth = dateOfBirth;
		this.myTickets = myTickets;
		this.customerContact = customerContact;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 */
	public Customer(Integer userId, String userName, String password) {
		super(userId, userName, password);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [dateOfBirth=" + dateOfBirth + ", myTickets=" + myTickets + ", customerContact="
				+ customerContact + "]";
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
	 * @return the myTickets
	 */
	public List<Ticket> getMyTickets() {
		return myTickets;
	}
	/**
	 * @param myTickets the myTickets to set
	 */
	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}
	/**
	 * @return the customerContact
	 */
	public String getCustomerContact() {
		return customerContact;
	}
	/**
	 * @param customerContact the customerContact to set
	 */
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	
	
	
}
