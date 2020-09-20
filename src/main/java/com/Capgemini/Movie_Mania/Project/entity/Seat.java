/**
 * 
 */
package com.Capgemini.Movie_Mania.Project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "seat_details")
public class Seat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="seat_id",length = 6)
	private Integer seatId; 
	@Column(name="seat_Status")
	private  String seatStatus;
	@Column(name="seat_Price")
	private  Double seatPrice;
	
//	@ManyToOne
//	@JoinColumn(name="booking_id")
//	private Booking booking;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="show_id")
	private Show show;
	
	private int seatLocation[];

//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	
	
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}


	

	/**
	 * @param seatId
	 * @param seatStatus
	 * @param seatPrice
	 * @param booking
	 * @param show
	 * @param seatLocation
	 */
	public Seat(Integer seatId,  Double seatPrice, Booking booking, Show show,
			int[] seatLocation) {
		super();
		this.seatId = seatId;
		this.seatStatus = "Available";
		this.seatPrice = seatPrice;
		
		//this.show = show;
		this.seatLocation = seatLocation;
	}

	/**
	 * 
	 */
	public Seat() {
		super();
		
		this.seatStatus = "Available";
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", seatPrice=" + seatPrice + "]";
	}


	public int[] getSeatLocation() {
		return seatLocation;
	}


	/**
	 * @param seatLocation the seatLocation to set
	 */
	public void setSeatLocation(int[] seatLocation) {
		this.seatLocation = seatLocation;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the seatStatus
	 */
	public String getSeatStatus() {
		return seatStatus;
	}

	/**
	 * @param seatStatus the seatStatus to set
	 */
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	

	
	


}
