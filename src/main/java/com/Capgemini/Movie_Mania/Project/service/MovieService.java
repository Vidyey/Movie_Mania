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
	
	
	//Dhiraj
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
	
	
	
	
	
// Prajakta
	public String addMovie(Movie movie);
	public String deleteMovie(int movieId);
	public List<Movie> getAllMovies();

	
	public String addTheater(Theater theater);
	public String deleteTheater(int theater_id);
	public List<Theater> getAllTheater();
	public Theater getTheater(int theater_id);
	public Theater grtTheaterById(int theater_id);
	
	public String addScreen(Screen screen);
	public String deleteScreen(int screen_id);
	public List<Screen> getAllScreen();
	public Screen getScreen(int screen_id);
	
	public String addShow(Show screen);
	public String deleteShow(int show_id);
	public List<Show> getAllShow();
//	mahesh module
	public  double calculateTotalCost(List<Seat> seat);
	public Booking makePayment(Booking b);
	public Booking   cancelticket(Ticket t);
	public Booking choosePaymentmethod(List<Seat> seat,int buttonid);
	
	public List<Show> showShows(Integer screenId);
	
	
//	pratik
	public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation);   //  function to select seat
	
	public Booking UpdateSeatStatus(Booking BookingObj);
	
	
	
	
	
	
	
	public Seat blockUnblock (Seat markseat);
	
	public Booking unblockSeat (Booking Bookingobj);
	
	public Booking cancelBooking (Booking  cancelBooking);
	
	
}

