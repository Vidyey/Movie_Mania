package com.Capgemini.Movie_Mania.Project.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capgemini.Movie_Mania.Project.Dao.IMovieDao;
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

	
public class MovieServiceImpl implements MovieService
{
	
	
	
	@Autowired
	private IMovieDao dao;
	

	/*
	 * For registering a customer there are some validations rules are designed. 
	 * To validate the input this function will check by using patterns or lengths
	 */
	@Override
	public String registerCustomer(Customer customer) {

		return dao.registerCustomer(customer);
	}

	
	/*
	 * For registering a admin there are some validations rules are designed. 
	 * To validate the input this function will check by using patterns or lengths
	 */
	@Override
	public String registerAdmin(Admin admin) {

		return dao.registerAdmin(admin);
	}

	@Override
	public boolean custLogin(String userId, String password) {
		return dao.custLogin(userId, password);
	}
	
	@Override
	public boolean adminLogin(String userId, String password) {
		return dao.adminLogin(userId, password);
	}

	@Override
	public String changePassword(String userId, String currentPassword, String newPassword) {
		return dao.changePassword(userId, currentPassword, newPassword);
	}
	
	@Override
	public String changePasswordAdmin(String userId, String currentPassword, String newPassword) {
		return dao.changePasswordAdmin(userId, currentPassword, newPassword);
	}

	@Override
	public String editCustomer(Customer customer) {

		return dao.editCustomer(customer);
	}

	@Override
	public String editAdmin(Admin admin) {

		return dao.editAdmin(admin);
	}

	@Override
	public String forgotPassword(String userId, String securityQuestion, String answer) {
		return dao.forgotPassword(userId, securityQuestion, answer);
	}
	
	@Override
	public String forgotPasswordAdmin(String userId, String securityQuestion, String answer) {
		return dao.forgotPasswordAdmin(userId, securityQuestion, answer);
	}

	public List<Ticket> showTickets(String customerId) {
		return dao.showTickets(customerId);
	}
	
	@Override
	public Customer getCustById(String userId)  {
		return dao.getCustById(userId);
	}

	@Override
	public Admin getAdminById(String userId)  {
		return dao.getAdminById(userId);
	}

	public List<Movie> searchMovie(String movieName) {
		return dao.searchMovie(movieName);
	}

	public List<Theater> searchTheatre(String theatreName) {
		
		return dao.searchTheatre(theatreName);
	}
	
	
	

	//Prajakta
	
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		dao.addMovie(movie);

	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
        dao.deleteMovie(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return dao.getAllMovies();

	}


	



	@Override
	public void addTheater(Theater theater) {
		// TODO Auto-generated method stub
		dao.addTheater(theater);
	}

	@Override
	public void deleteTheater(int theater_id) {
		// TODO Auto-generated method stub
		dao.deleteTheater(theater_id);
		
	}

	@Override
	public List<Theater> getAllTheater() {
		// TODO Auto-generated method stub
		return dao.getAllTheater();
	}

	@Override
	public void addScreen(Screen screen) {
		// TODO Auto-generated method stub
		dao.addScreen(screen);
		
	}

	@Override
	public void deleteScreen(int screen_id) {
		// TODO Auto-generated method stub
			dao.deleteScreen(screen_id);
		
	}

	@Override
	public List<Screen> getAllScreen() {
		// TODO Auto-generated method stub
		return dao.getAllScreen();
	}

	@Override
	public void addShow(Show screen, int movieId) {
		dao.addShow(screen, movieId);
	}

	@Override
	public void deleteShow(int show_id) {
		// TODO Auto-generated method stub
		dao.deleteShow(show_id);
		
	}

	@Override
	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return dao.getAllShow();
	}



	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return null;
	}
	

//	mahesh module
	@Override
	public double calculateTotalCost(List<Seat> seat) {
		return dao.calculateTotalCost(seat);	
	}

	@Override
	public Booking makePayment(int Booking_id) {
		// TODO Auto-generated method stub
		return dao.makePayment(Booking_id);
	}

	@Override
	public Booking   cancelticket(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.cancelticket(ticket);
	}

	@Override
	public Booking choosePaymentmethod(Integer showId, SelectedSeatArray seatLocation, int buttonid) {
		// TODO Auto-generated method stub
		return dao.choosePaymentmethod(showId, seatLocation, buttonid);
	
}
	
	
	//Pratik

		@Override
		public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation) {
			// TODO Auto-generated method stub
			return dao.SelectSeat(showId, seatLocation);
		}
		
		@Override
		public Booking UpdateSeatStatus(Booking BookingObj) {
			// TODO Auto-generated method stub
			return dao.UpdateSeatStatus(BookingObj);
		}
		
	
	
		@Override
		public Seat blockUnblock(Integer markseat) {
			// TODO Auto-generated method stub
			return dao.blockUnblock(markseat);
		}
		
		@Override
		public Booking unblockSeat(int Bookingobj) {
			// TODO Auto-generated method stub
			return dao.unblockSeat(Bookingobj);
		}
		
		@Override
		public Booking cancelBooking(int cancelBooking_id) {
			// TODO Auto-generated method stub
			return dao.cancelBooking( cancelBooking_id);
		}

		
		//--------------------------------------------------------------------------------

		@Override
		public List<Show> searchShow(String showName) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Booking initiateBooking(Booking BookingObj) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
		
		
		
}
