package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;

@Service
public interface MovieService {
	/*
	 * public List<Movie> searchMovie(String movieName); public List<Theater>
	 * searchTheatre(String theatreName) ; public List<Show> searchShow(String
	 * movieName); public List<Show> showShows(Integer screenId);
	 */
	
	public Customer registerCustomer(Customer customer);
	public Admin registerAdmin(Admin admin);
	public boolean login(String username, String password); 

}
