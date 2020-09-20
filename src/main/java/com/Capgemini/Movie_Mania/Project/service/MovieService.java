package com.Capgemini.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.SelectedSeatArray;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;

@Service
public interface MovieService {
	
	
	public String registerCustomer(Customer customer);
	public String registerAdmin(Admin admin);
	public boolean custLogin(Integer userId,String password);
	public boolean adminLogin(Integer userId,String password);
	public String changePassword(Integer userId,String currentPassword,String newPassword);
	public String editCustomer(Customer customer);
	public String forgotPassword(Integer userId,String securityQuestion,String answer);
	public List<Ticket> showTickets(int customerId);
	public List<Movie> searchMovie(String movieName);
	public List<Theater> searchTheatre(String theatreName) ;
	
	
	
	
	public List<Show> showShows(Integer screenId);
	

	public void addMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Movie> getAllMovies();
	

	// pratiks Module
	
	public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation);   //  function to select seat
		
		public Booking UpdateSeatStatus(Booking BookingObj);
		
		
		
		public Seat blockUnblock (Seat markseat);
		
		public Booking unblockSeat (Booking Bookingobj);
		
		public Booking cancelBooking (Booking  cancelBooking);

	
	public void addTheater(Theater theater);
	public void deleteTheater(int theater_id);
	public List<Theater> getAllTheater();
	
	
	public void addScreen(Screen screen);
	public void deleteScreen(int screen_id);
	public List<Screen> getAllScreen();
	
	public void addShow(Show screen, int movieId);
	public void deleteShow(int show_id);
	public List<Show> getAllShow();
	

	
}

