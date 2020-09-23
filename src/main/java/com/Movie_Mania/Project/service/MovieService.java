package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;

@Service
public interface MovieService {
	
	
	
	public String registerCustomer(Customer customer);
	public String registerAdmin(Admin admin);
	public boolean custLogin(String userId,String password);
	public boolean adminLogin(String userId,String password);
	public String changePassword(String userId,String currentPassword,String newPassword);
	public String changePasswordAdmin(String userId, String currentPassword, String newPassword);
	public String editCustomer(Customer customer);
	public String editAdmin(Admin admin);
	public String forgotPassword(String userId,String securityQuestion,String answer);
	public String forgotPasswordAdmin(String userId,String securityQuestion,String answer);
	public List<Ticket> showTickets(String customerId);
	public List<Movie> searchMovie(String movieName);
	public List<Theater> searchTheatre(String theatreName) ;
	public Customer getCustById(String userId);
	public Admin getAdminById(String userId);
	
	
	
	public List<Show> showShows(Integer screenId);
	

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

