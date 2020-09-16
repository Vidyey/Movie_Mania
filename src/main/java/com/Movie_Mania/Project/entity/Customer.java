/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer_details")
public class Customer extends User {

	
	private static final long serialVersionUID = 1L;

	@Column(name = "Customer_name")
	private String customerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_Of_Birth")
	private Date dateOfBirth;
	
	
	@Column(name = "Customer_contact")
	private String customerContact;
	
	@JsonBackReference
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL )
	private List<Ticket> myTickets;
	
	
	
	public Customer(Integer userId, String password, String customerName, Date dateOfBirth, String customerContact) {
		super(userId, password);
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
		myTickets = new ArrayList<Ticket>();
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
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
