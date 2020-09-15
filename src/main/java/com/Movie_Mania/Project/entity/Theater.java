/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.util.Arrays;

/**
 * @author PDGadge
 *
 */
public class Theater {

	private Integer theaterId;
	private String theaterName;
	private String theaterCity;
	private Movie[] movies;
	
	
	private Screen[] listOfScreens;
	private String managerName;
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
	public Theater(Integer theaterId, String theaterName, String theaterCity, Movie[] movies, Screen[] listOfScreens,
			String managerName, String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.movies = movies;
		this.listOfScreens = listOfScreens;
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
	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", movies=" + Arrays.toString(movies) + ", listOfScreens=" + Arrays.toString(listOfScreens)
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
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
	public Movie[] getMovies() {
		return movies;
	}
	/**
	 * @param movies the movies to set
	 */
	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}
	/**
	 * @return the listOfScreens
	 */
	public Screen[] getListOfScreens() {
		return listOfScreens;
	}
	/**
	 * @param listOfScreens the listOfScreens to set
	 */
	public void setListOfScreens(Screen[] listOfScreens) {
		this.listOfScreens = listOfScreens;
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
	
	

}
