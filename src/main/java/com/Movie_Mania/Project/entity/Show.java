/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Show_Details")
public class Show implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="show_id")
	private Integer showId;
	@Column(name="show_StartTime")
	private Time showStartTime;
	@Column(name="show_EndTime")
	private Time showEndTime;
	
	@OneToMany(mappedBy = "show",targetEntity = Seat.class,cascade=CascadeType.ALL)										//mappimg remaining
	private List<Seat> seats;
	
	@OneToOne(cascade = CascadeType.ALL)
	Booking booking;
	
	private String showName;
	@JoinColumn(name="movie_name")
	@OneToOne(targetEntity=Movie.class,cascade=CascadeType.ALL) 
	private Movie movieName;
	@Column(name="screen_id")
	private Integer screenId;
	@Column(name="theater_id")
	private Integer theaterId;
	
	@ManyToOne
	Screen screen;
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
	public Show(Integer showId, Time showStartTime, Time showEndTime, List<Seat> seats, String showName, Movie movieName,
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
	public List<Seat> getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(List<Seat> seats) {
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
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + seats + ", booking=" + booking + ", showName=" + showName + ", movieName=" + movieName
				+ ", screenId=" + screenId + ", theaterId=" + theaterId + ", screen=" + screen + "]";
	}
	
	
	
	

}
