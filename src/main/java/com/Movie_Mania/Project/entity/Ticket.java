/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.util.Arrays;

import javax.persistence.*;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	@Column(name = "No_of_seats")
	private Integer	noOfSeats;
	@Column(name = "SeatName")
	private String[] seatName; 
	
	@OneToOne(targetEntity=Booking.class,cascade=CascadeType.ALL) 
	private Booking	bookingRef;
	
	
	@Column(name = "Ticket_Status")
	private Boolean	ticketStatus;
	@Column(name = "ScreenName")
	private String	screenName;
	/**
	 * @param ticketId
	 * @param noOfSeats
	 * @param seatName
	 * @param bookingRef
	 * @param ticketStatus
	 * @param screenName
	 */
	public Ticket(Integer ticketId, Integer noOfSeats, String[] seatName, Booking bookingRef, Boolean ticketStatus,
			String screenName) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.bookingRef = bookingRef;
		this.ticketStatus = ticketStatus;
		this.screenName = screenName;
	}
	/**
	 * 
	 */
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName=" + Arrays.toString(seatName)
				+ ", bookingRef=" + bookingRef + ", ticketStatus=" + ticketStatus + ", screenName=" + screenName + "]";
	}
	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * @return the noOfSeats
	 */
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	/**
	 * @return the seatName
	 */
	public String[] getSeatName() {
		return seatName;
	}
	/**
	 * @param seatName the seatName to set
	 */
	public void setSeatName(String[] seatName) {
		this.seatName = seatName;
	}
	/**
	 * @return the bookingRef
	 */
	public Booking getBookingRef() {
		return bookingRef;
	}
	/**
	 * @param bookingRef the bookingRef to set
	 */
	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}
	/**
	 * @return the ticketStatus
	 */
	public Boolean getTicketStatus() {
		return ticketStatus;
	}
	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	/**
	 * @return the screenName
	 */
	public String getScreenName() {
		return screenName;
	}
	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	

}
