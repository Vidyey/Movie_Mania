/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Screen_Details")
public class Screen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="screen_id")
	private Integer screenId;
	@Column(name="theater_id")
	private Integer theaterId;
	@Column(name="screen_Name")
	String screenName;
	
	@ManyToOne
	Theater theatre;
	
	@OneToMany(mappedBy = "screen",targetEntity = Show.class,cascade = CascadeType.ALL)
	private List<Show> showList;
	@Column(name="movieEndDate")
	private LocalDate movieEndDate;
	@Column(name="row_count")
	private Integer rows;												// does any need to use this in table ??
	@Column(name="column_count")
	private Integer columns;
	
	private int SeatMatrix[][];
	/**
	 * 
	 */
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
		this.rows = 5;
		this.columns = 10;
		
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
	public Screen(Integer screenId, Integer theaterId, String screenName, List<Show> showList, LocalDate movieEndDate) {
		super();
		this.screenId = screenId;
		this.theaterId = theaterId;
		this.screenName = screenName;
		this.showList = showList;
		this.movieEndDate = movieEndDate;
		this.rows = 5;
		this.columns = 10;
		
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.rows; j++) {
				this.SeatMatrix[i][j] = 0;
			}
		}
		
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
		return theaterId;
	}
	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(Integer theaterId) {
		this.theaterId = theaterId;
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
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns="
				+ columns + "]";
	}
	public Theater getTheatre() {
		return theatre;
	}
	public void setTheatre(Theater theatre) {
		this.theatre = theatre;
	}
	
	

	

}
