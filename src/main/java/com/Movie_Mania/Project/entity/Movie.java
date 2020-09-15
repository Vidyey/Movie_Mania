/**
 * 
 */
package com.Movie_Mania.Project.entity;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author PDGadge
 *
 */
public class Movie {

	private Integer movieId;
	private Integer	bookingId;
	private String movieName;
	private Show[]	movieGenre; 
	private LocalDate movieDirector;
	private Integer movieLength;
	private String[] languages; 
	private LocalDate movieReleaseDate;
	/**
	 * @param movieId
	 * @param bookingId
	 * @param movieName
	 * @param movieGenre
	 * @param movieDirector
	 * @param movieLength
	 * @param languages
	 * @param movieReleaseDate
	 */
	public Movie(Integer movieId, Integer bookingId, String movieName, Show[] movieGenre, LocalDate movieDirector,
			Integer movieLength, String[] languages, LocalDate movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages = languages;
		this.movieReleaseDate = movieReleaseDate;
	}
	/**
	 * 
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", bookingId=" + bookingId + ", movieName=" + movieName + ", movieGenre="
				+ Arrays.toString(movieGenre) + ", movieDirector=" + movieDirector + ", movieLength=" + movieLength
				+ ", languages=" + Arrays.toString(languages) + ", movieReleaseDate=" + movieReleaseDate + "]";
	}
	/**
	 * @return the movieId
	 */
	public Integer getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the movieGenre
	 */
	public Show[] getMovieGenre() {
		return movieGenre;
	}
	/**
	 * @param movieGenre the movieGenre to set
	 */
	public void setMovieGenre(Show[] movieGenre) {
		this.movieGenre = movieGenre;
	}
	/**
	 * @return the movieDirector
	 */
	public LocalDate getMovieDirector() {
		return movieDirector;
	}
	/**
	 * @param movieDirector the movieDirector to set
	 */
	public void setMovieDirector(LocalDate movieDirector) {
		this.movieDirector = movieDirector;
	}
	/**
	 * @return the movieLength
	 */
	public Integer getMovieLength() {
		return movieLength;
	}
	/**
	 * @param movieLength the movieLength to set
	 */
	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}
	/**
	 * @return the languages
	 */
	public String[] getLanguages() {
		return languages;
	}
	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	/**
	 * @return the movieReleaseDate
	 */
	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}
	/**
	 * @param movieReleaseDate the movieReleaseDate to set
	 */
	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	
	


}
