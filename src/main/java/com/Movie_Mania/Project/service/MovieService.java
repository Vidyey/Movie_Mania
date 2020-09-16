package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;

@Service
public interface MovieService {
	/*
	 * public List<Movie> searchMovie(String movieName); public List<Theater>
	 * searchTheatre(String theatreName) ; public List<Show> searchShow(String
	 * movieName); public List<Show> showShows(Integer screenId);
	 */
	
	public Customer registerCustomer(Customer customer);
	public Admin registerAdmin(Admin admin);

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
	
}

