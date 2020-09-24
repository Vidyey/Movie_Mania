package com.Capgemini.Movie_Mania.Project.Dao;

import java.util.List;

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

public interface IMovieDao {
	
	//Prajakta
	public void addMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Movie> getAllMovies();
	public void addTheater(Theater theater);
	public void deleteTheater(int theater_id);
	public List<Theater> getAllTheater();
	public void addScreen(Screen screen);
	public void deleteScreen(int screen_id);
	public List<Screen> getAllScreen();
	public void addShow(Show screen, int movieId);
	public void deleteShow(int show_id);
	public List<Show> getAllShow();
	
	
	//Dhiraj Modules
	public String registerCustomer(Customer customer);
	public String registerAdmin(Admin admin);
	public boolean custLogin(String username,String password);
	public boolean adminLogin(String username,String password);
	public String changePassword(String username,String currentPassword,String newPassword);
	public String changePasswordAdmin(String username, String currentPassword, String newPassword);
	public String editCustomer(Customer customer);
	public String editAdmin(Admin admin);
	public String forgotPassword(String username,String securityQuestion,String answer);
	public String forgotPasswordAdmin(String username,String securityQuestion,String answer);
	public List<Ticket> showTickets(String username);
	public List<Movie> searchMovie(String movieName);
	public List<Theater> searchTheatre(String theatreName) ;
	public Customer getCustById(String username);
	public Admin getAdminById(String username);


	

	
	//	mahesh module
		public  double calculateTotalCost(List<Seat> seat);
		public Booking makePayment(int Booking_id);
		public Booking   cancelticket(Ticket ticket);
		public Booking choosePaymentmethod(Integer showId, SelectedSeatArray seatLocation,int buttonid);
		public List<Show> searchShow(String showName);
		public List<Show> showShows(Integer screenId);
	
	// pratiks Module
	
		public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation);   //  function to select seat
		
		public Booking UpdateSeatStatus(Booking BookingObj);
		
		public Booking initiateBooking (Booking BookingObj);
	
		public Seat blockUnblock (Integer markseat);
	
		public Booking unblockSeat (int Bookingobj);
	
		public Booking cancelBooking (int cancelBooking_id);
	

	




}
