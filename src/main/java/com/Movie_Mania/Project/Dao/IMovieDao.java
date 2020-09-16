package com.Movie_Mania.Project.Dao;

import java.util.List;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;

public interface IMovieDao {
	public void addMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Movie> getAllMovies();

	List<Ticket> showTickets(int customerId);
	
	Boolean cancelSeat();
	
	Ticket bookSeat();
	
	Boolean bloackSeat();
	
	public List<Movie> searchMovie(String movieName);
	
	public List<Theater> searchTheatre(String theatreName);
	
	public List<Show> showShows(Integer screenId);

}
