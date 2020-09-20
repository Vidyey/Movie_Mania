
package com.Capgemini.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Booking_Details")
public class Booking implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="booking_id")
	private Integer	bookingId;
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="show_id")
	private Integer	showId;
	
	@OneToOne(mappedBy = "booking",targetEntity=Show.class,cascade=CascadeType.ALL)
	private Show showRef;
	@Column(name="booking_date")
	private LocalDate bookingDate;
	@Column(name="transaction_id")
	private Integer transactionId;
	@Column(name="Total_Cost")
	private Double totalCost;
	
	@OneToMany(mappedBy = "booking",targetEntity = Seat.class,cascade=CascadeType.ALL)
	private List<Seat> seatList;
	
	@OneToOne(targetEntity=Ticket.class) 
	private Ticket ticket;

	
	
	public Booking(Integer bookingId, Integer movieId, Integer showId, Show showRef, LocalDate bookingDate,
			Integer transactionId, Double totalCost, List<Seat> seatList, Ticket ticket) {
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

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Seat> getSeatList() {
		return seatList;
	}
	/**
	 * @param seatList the seatList to set
	 */
	public void setSeatList(List<Seat> seatList) {
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
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", showRef="
				+ showRef + ", bookingDate=" + bookingDate + ", transactionId=" + transactionId + ", totalCost="
				+ totalCost + ", seatList=" + seatList + ", ticket=" + ticket + "]";
	}
	
	

}
