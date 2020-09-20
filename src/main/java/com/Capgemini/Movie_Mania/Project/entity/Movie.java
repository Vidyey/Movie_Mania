
/**
 * 
 */
package com.Capgemini.Movie_Mania.Project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author PDGadge
 *
 */
@Entity
@Table(name = "Movie_Details")
public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="movie_id",length = 4)
	private Integer movieId;
	
	@Column(name="Movie_name")
	private String movieName;
	
	private String	movieGenre; 
	@Column(name="movie_Director")
	private String movieDirector;
	@Column(name="movie_Length")
	private Integer movieLength;
	@Column(name="movie_langauges")
	private String[] languages;
	@Column(name="movie_releaseDate")
	private LocalDate movieReleaseDate;
	
	@OneToOne(mappedBy = "movieName",cascade = CascadeType.ALL)
	Show show;
//	@JsonIgnore
	@ManyToMany(mappedBy = "movies")
	List<Theater> theatrelist;
	
	public Movie(Integer movieId, String movieName, String movieGenre, String movieDirector,
			Integer movieLength, String[] languages, LocalDate movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages = languages;
		this.movieReleaseDate = movieReleaseDate;
		theatrelist=new ArrayList<>();
	}
	/**
	 * 
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMovieGenre() {
		return movieGenre;
	}
	/**
	 * @param movieGenre the movieGenre to set
	 */
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	/**
	 * @return the movieDirector
	 */
	public String getMovieDirector() {
		return movieDirector;
	}
	/**
	 * @param movieDirector the movieDirector to set
	 */
	public void setMovieDirector(String movieDirector) {
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
	
	
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public List<Theater> getTheatrelist() {
		return theatrelist;
	}
	public void setTheatrelist(List<Theater> theatrelist) {
		this.theatrelist = theatrelist;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieDirector=" + movieDirector + ", movieLength=" + movieLength + ", languages="
				+ Arrays.toString(languages) + ", movieReleaseDate=" + movieReleaseDate + ", show=" + show
				+ ", theatrelist=" + theatrelist + "]";
	}
	

	
	
	

}