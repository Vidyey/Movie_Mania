package com.Movie_Mania.Project.Dao;

import java.util.List;
import java.util.Optional;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;



	
	

import com.Movie_Mania.Project.entity.Seat;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;

public interface IMovieDao {
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
//	public Optional<Screen> getAllScreensByTherateid(int theater_id);
	
	
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
	
	public List<Seat> SelectSeat(Show show, int[] seatLocation);   //  function to select seat
	
	public Boolean UpdateSeatStatus(Booking BookingObj);
	
	public Booking initiateBooking (Booking BookingObj);

}
