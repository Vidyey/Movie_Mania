package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;

@Service
public interface MovieService {
	public List<Movie> searchMovie(String movieName);
	public List<Theater> searchTheatre(String theatreName) ;
	public List<Show> searchShow(String movieName);
	public List<Show> showShows(Integer screenId);
	
	List<Ticket> showTickets(int customerId);
	Boolean cancelSeat();
	
	Ticket bookSeat();
	
	Boolean bloackSeat();
	public void addMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Movie> getAllMovies();
	
	
	public void addTheater(Theater theater);
	public void deleteTheater(int theater_id);
	public List<Theater> getAllTheater();
	
	
	public void addScreen(Screen screen);
	public void deleteScreen(int screen_id);
	public List<Screen> getAllScreen();
	
	public void addShow(Show screen);
	public void deleteShow(int show_id);
	public List<Show> getAllShow();
	
}

