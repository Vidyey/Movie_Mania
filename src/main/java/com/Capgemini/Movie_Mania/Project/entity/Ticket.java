/**
 * 
 */
package com.Capgemini.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id",length = 8)
	private Integer ticketId;
	@Column(name = "No_of_seats")
	private Integer	noOfSeats;
	@Column(name = "SeatName")
	private String[] seatName; 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer;
	
	@OneToOne(mappedBy = "ticket",targetEntity=Booking.class,cascade=CascadeType.ALL) 
	private Booking	bookingRef;
	
	
	@Column(name = "Ticket_Status")
	private Boolean	ticketStatus;
	@Column(name = "ScreenName")
	private String	screenName;
	
	public Ticket(Integer ticketId, Integer noOfSeats, String[] seatName, Boolean ticketStatus,
			String screenName) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.ticketStatus = ticketStatus;
		this.screenName = screenName;
	}
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String[] getSeatName() {
		return seatName;
	}

	public void setSeatName(String[] seatName) {
		this.seatName = seatName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Booking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}

	public Boolean getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName=" + Arrays.toString(seatName)
				+ ", customer=" + customer + ", bookingRef=" + bookingRef + ", ticketStatus=" + ticketStatus
				+ ", screenName=" + screenName + "]";
	}
	
	
	
	

}
