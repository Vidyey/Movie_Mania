/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Booking_Details")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer	bookingId;
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="show_id")
	private Integer	showId;
	
	private Show showRef;
	@Column(name="booking_date")
	private LocalDate bookingDate;
	@Column(name="transaction_id")
	private Integer transactionId;
	@Column(name="Total_Cost")
	private Double totalCost;
	
	private Seat[] seatList;
	@OneToOne(targetEntity=Ticket.class) 
	private Ticket ticket;
	/**
	 * @param bookingId
	 * @param movieId
	 * @param showId
	 * @param showRef
	 * @param bookingDate
	 * @param transactionId
	 * @param totalCost
	 * @param seatList
	 * @param ticket
	 */
	public Booking(Integer bookingId, Integer movieId, Integer showId, Show showRef, LocalDate bookingDate,
			Integer transactionId, Double totalCost, Seat[] seatList, Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.showRef = showRef;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.seatList = seatList;
		this.ticket = ticket;
	}
	/**
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", showRef="
				+ showRef + ", bookingDate=" + bookingDate + ", transactionId=" + transactionId + ", totalCost="
				+ totalCost + ", seatList=" + Arrays.toString(seatList) + ", ticket=" + ticket + "]";
	}
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the movieId
	 */
	public Integer getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the showId
	 */
	public Integer getShowId() {
		return showId;
	}
	/**
	 * @param showId the showId to set
	 */
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	/**
	 * @return the showRef
	 */
	public Show getShowRef() {
		return showRef;
	}
	/**
	 * @param showRef the showRef to set
	 */
	public void setShowRef(Show showRef) {
		this.showRef = showRef;
	}
	/**
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the totalCost
	 */
	public Double getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * @return the seatList
	 */
	public Seat[] getSeatList() {
		return seatList;
	}
	/**
	 * @param seatList the seatList to set
	 */
	public void setSeatList(Seat[] seatList) {
		this.seatList = seatList;
	}
	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
