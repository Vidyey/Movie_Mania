/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Theater_Details")
public class Theater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="theater_id")
	private Integer theaterId;
	@Column(name="theater_Name")
	private String theaterName;
	@Column(name="theater_city")
	private String theaterCity;
	
	// mapping remaining
	
	@OneToMany(mappedBy = "theatre",targetEntity = Movie.class, cascade = CascadeType.ALL)
	private List<Movie> movies;
	  // adding extra col 
	
	@JsonIgnore
	@OneToMany(mappedBy = "theatre",targetEntity = Screen.class, cascade = CascadeType.ALL)
	private List<Screen> screens;
	
	@Column(name="Manager_Name")
	private String managerName;
	@Column(name="Manager_Contact")
	private String managerContact;
	/**
	 * @param theaterId
	 * @param theaterName
	 * @param theaterCity
	 * @param movies
	 * @param listOfScreens
	 * @param managerName
	 * @param managerContact
	 */
	public Theater(Integer theaterId, String theaterName, String theaterCity,
			String managerName, String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.movies = new ArrayList<>();
		this.screens = new ArrayList<Screen>();
		this.managerName = managerName;
		this.managerContact = managerContact;
	}
	/**
	 * 
	 */
	public Theater() {
		super();
		// TODO Auto-generated constructor stub
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
	/**
	 * @return the theaterName
	 */
	public String getTheaterName() {
		return theaterName;
	}
	/**
	 * @param theaterName the theaterName to set
	 */
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	/**
	 * @return the theaterCity
	 */
	public String getTheaterCity() {
		return theaterCity;
	}
	/**
	 * @param theaterCity the theaterCity to set
	 */
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	/**
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		return movies;
	}
	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	/**
	 * @return the listOfScreens
	 */
	public List<Screen> getListOfScreens() {
		return screens;
	}
	/**
	 * @param listOfScreens the listOfScreens to set
	 */
	public void setListOfScreens(List<Screen> listOfScreens) {
		this.screens = listOfScreens;
	}
	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * @return the managerContact
	 */
	public String getManagerContact() {
		return managerContact;
	}
	/**
	 * @param managerContact the managerContact to set
	 */
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", movies=" + movies + ", listOfScreens=" + screens + ", managerName=" + managerName
				+ ", managerContact=" + managerContact + "]";
	}
	
	
	public void addMovie(Movie movie) {
		movie.setTheatre(this);
		this.getMovies().add(movie);
	}
	
	
	public void addScreen(Screen screen) {
		screen.setTheatre(this);
		this.getListOfScreens().add(screen);
	}
	

}
