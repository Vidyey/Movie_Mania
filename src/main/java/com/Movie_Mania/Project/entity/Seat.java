/**
 * 
 */
package com.Movie_Mania.Project.entity;

/**
 * @author Administrator
 *
 */
public class Seat {
	private Integer seatId; 
	private  Enum<BookingState> seatStatus;
	
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
