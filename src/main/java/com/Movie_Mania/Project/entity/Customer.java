/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer_details")
public class Customer extends User {

	
	private static final long serialVersionUID = 1L;

	@Column(name = "Customer_name",length = 30 , nullable = false)
	private String customerName;
	
	
	@Column(name = "date_Of_Birth",length = 15,nullable = false)
	private String dateOfBirth;
	
	
	@Column(name = "Customer_contact",length = 15,nullable = false)
	private String customerContact;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL )
	private List<Ticket> myTickets;
	
	
	
	
	public Customer(Integer userId, String password, String securityQuestion, String answer, String customerName,
			String dateOfBirth, String customerContact) {
		super(userId, password, securityQuestion, answer);
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
		this.myTickets = new ArrayList<>();
	}
	public Customer() {
		super();
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public List<Ticket> getMyTickets() {
		return myTickets;
	}
	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", dateOfBirth=" + dateOfBirth + ", customerContact="
				+ customerContact + ", myTickets=" + myTickets + "]";
	}
	
	
	public void addTicket(Ticket ticket)
	{
		ticket.setCustomer(this);
		this.getMyTickets().add(ticket);
	}
	
	
	
}
