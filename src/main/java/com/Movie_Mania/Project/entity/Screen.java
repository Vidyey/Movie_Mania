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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="screen_id",length = 4)
	private Integer screenId;
	@Column(name="screen_Name")
	String screenName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="theater_id")
	Theater theatre;
	
	@OneToMany(mappedBy = "screen",targetEntity = Show.class,cascade = CascadeType.ALL)
	private List<Show> showList;
	@Column(name="movieEndDate")
	private String movieEndDate;
	@Column(name="row_count")
	private Integer rows;												// does any need to use this in table ??
	@Column(name="column_count")
	private Integer columns;
	
	
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
	public Screen(Integer screenId, Integer theaterId, String screenName, List<Show> showList, String movieEndDate) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.showList = showList;
		this.movieEndDate = movieEndDate;
		this.rows = 5;
		this.columns = 10;
		
		
		
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
	public String getMovieEndDate() {
		return movieEndDate;
	}
	/**
	 * @param movieEndDate the movieEndDate to set
	 */
	public void setMovieEndDate(String movieEndDate) {
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
		return "Screen [screenId=" + screenId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns="
				+ columns + "]";
	}
	public Theater getTheatre() {
		return theatre;
	}
	public void setTheatre(Theater theatre) {
		this.theatre = theatre;
	}
	
	
	public void addShow(Show show) {

		show.setScreen(this);
		this.getShowList().add(show);
	}
	

	

}
