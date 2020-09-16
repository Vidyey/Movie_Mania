/**
 * 
 */
package com.Movie_Mania.Project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "seat_details")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="seat_id")
	private Integer seatId; 
	@Column(name="seat_Status")
	private  Enum<BookingState> seatStatus;
	@Column(name="seat_Price")
	private  Double seatPrice;

	public Enum<BookingState> getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(Enum<BookingState> seatStatus) {
		this.seatStatus = seatStatus;
	}

	/**
	 * @param seatId
	 * @param seatStatus
	 * @param seatPrice
	 */
	public Seat(Integer seatId, Enum<BookingState> seatStatus, Double seatPrice) {
		super();
		this.seatId = seatId;
		this.seatStatus = seatStatus;
		this.seatPrice = seatPrice;
	}

	/**
	 * 
	 */
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", seatPrice=" + seatPrice + "]";
	}

	/**
	 * @return the seatId
	 */
	public Integer getSeatId() {
		return seatId;
	}

	/**
	 * @param seatId the seatId to set
	 */
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	/**
	 * @return the seatPrice
	 */
	public Double getSeatPrice() {
		return seatPrice;
	}

	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Double seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	


}
