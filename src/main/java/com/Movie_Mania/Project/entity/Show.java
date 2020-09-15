/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.sql.Time;
import java.util.Arrays;

/**
 * @author PDGadge
 *
 */
public class Show {
	private Integer showId;
	private Time showStartTime;
	private Time showEndTime;
	private Seat[] seats;
	private String showName;
	private Movie movieName;
	private Integer screenId;
	private Integer theaterId;
	/**
	 * @param showId
	 * @param showStartTime
	 * @param showEndTime
	 * @param seats
	 * @param showName
	 * @param movieName
	 * @param screenId
	 * @param theaterId
	 */
	public Show(Integer showId, Time showStartTime, Time showEndTime, Seat[] seats, String showName, Movie movieName,
			Integer screenId, Integer theaterId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.seats = seats;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}
	/**
	 * 
	 */
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + Arrays.toString(seats) + ", showName=" + showName + ", movieName=" + movieName
				+ ", screenId=" + screenId + ", theaterId=" + theaterId + "]";
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
	 * @return the showStartTime
	 */
	public Time getShowStartTime() {
		return showStartTime;
	}
	/**
	 * @param showStartTime the showStartTime to set
	 */
	public void setShowStartTime(Time showStartTime) {
		this.showStartTime = showStartTime;
	}
	/**
	 * @return the showEndTime
	 */
	public Time getShowEndTime() {
		return showEndTime;
	}
	/**
	 * @param showEndTime the showEndTime to set
	 */
	public void setShowEndTime(Time showEndTime) {
		this.showEndTime = showEndTime;
	}
	/**
	 * @return the seats
	 */
	public Seat[] getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	/**
	 * @return the showName
	 */
	public String getShowName() {
		return showName;
	}
	/**
	 * @param showName the showName to set
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}
	/**
	 * @return the movieName
	 */
	public Movie getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(Movie movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the screenId
	 */
	public Integer getScreenId() {
		return screenId;
	}
	/**
	 * @param screenId the screenId to set
	 */
	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}
	/**
	 * @return the theaterId
	 */
	public Integer getTheaterId() {
		return theaterId;
	}
	/**
	 * @param theaterId the theaterId to set
	 */
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	
	

}
