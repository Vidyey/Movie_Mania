/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Screen_Details")
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="screen_id")
	private Integer screenId;
	@Column(name="theatre_id")
	private Integer theatreId;
	@Column(name="screen_Name")
	String screenName;
	
	
	
	@OneToMany(targetEntity = Show.class)
	private List<Show> showList;
	@Column(name="movieEndDate")
	private LocalDate movieEndDate;
	@Column(name="rows")
	private Integer rows;												// does any need to use this in table ??
	@Column(name="columns")
	private Integer columns;
	/**
	 * 
	 */
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param screenId
	 * @param theatreId
	 * @param screenName
	 * @param showList
	 * @param movieEndDate
	 * @param rows
	 * @param columns
	 */
	public Screen(Integer screenId, Integer theatreId, String screenName, List<Show> showList, LocalDate movieEndDate,
			Integer rows, Integer columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;
		this.showList = showList;
		this.movieEndDate = movieEndDate;
		this.rows = rows;
		this.columns = columns;
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
	 * @return the theatreId
	 */
	public Integer getTheatreId() {
		return theatreId;
	}
	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
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
	/**
	 * @return the showList
	 */
	public List<Show> getShowList() {
		return showList;
	}
	/**
	 * @param showList the showList to set
	 */
	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}
	/**
	 * @return the movieEndDate
	 */
	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}
	/**
	 * @param movieEndDate the movieEndDate to set
	 */
	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}
	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	/**
	 * @return the columns
	 */
	public Integer getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns="
				+ columns + "]";
	}

	

}
