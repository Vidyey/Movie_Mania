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
	
	//-----------------------------Movie-------------------------------------
		@Override
		public String addMovie(Movie movie) {
			return dao.addMovie(movie);
			

		}

		@Override
		public String deleteMovie(int movieId) {
			return dao.deleteMovie(movieId);
		}

		@Override
		public List<Movie> getAllMovies() {
			// TODO Auto-generated method stub
			return dao.getAllMovies();

		}


//		-------------------------------------------------------------------------



	



		//----------------------------Theater---------------------------------
			@Override
			public String addTheater(Theater theater) {
				 return dao.addTheater(theater);
				
			}

			@Override
			public String deleteTheater(int theater_id) {
				// TODO Auto-generated method stub
				return dao.deleteTheater(theater_id);
			
				
			}

			@Override
			public List<Theater> getAllTheater() {
				// TODO Auto-generated method stub
				return dao.getAllTheater();
			}


			
//			---------------------------Screen---------------------------------
			@Override
			public String addScreen(Screen screen) {
				return dao.addScreen(screen);
				
			}

			@Override
			public String deleteScreen(int screen_id) {
				return dao.deleteScreen(screen_id);
				
			}

			@Override
			public List<Screen> getAllScreen() {
				// TODO Auto-generated method stub
				return dao.getAllScreen();
			}
//			@Override
//			public List<Screen> getAllScreenById(int theater_id) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			--------------------------Show---------------------------------
			@Override
			public String addShow(Show show) {
				return dao.addShow(show);
				 
				
			}

			@Override
			public String deleteShow(int show_id) {
				return dao.deleteShow(show_id);
				
			}

			@Override
			public List<Show> getAllShow() {
				// TODO Auto-generated method stub
				return dao.getAllShow();
			}
		//-------------------------------------------------------------
			//not required
		@Override
			public Theater getTheater(int theater_id) {
				// TODO Auto-generated method stub
				return dao.getTheater(theater_id);
			}



			@Override
			public Theater grtTheaterById(int theater_id) {
				// TODO Auto-generated method stub
				return dao.grtTheaterById(theater_id);
			}

			@Override
			public Screen getScreen(int screen_id) {
				// TODO Auto-generated method stub
				return dao.getScreen(screen_id);
			}

			

//	mahesh module
	@Override
	public double calculateTotalCost(List<Seat> seat) {
		return dao.calculateTotalCost(seat);	
	}

	@Override
	public Booking makePayment(Booking booking) {
		// TODO Auto-generated method stub
		return dao.makePayment(booking);
	}

	@Override
	public Booking   cancelticket(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.cancelticket(ticket);
	}

	@Override
	public Booking choosePaymentmethod(List<Seat> seat, int buttonid) {
		// TODO Auto-generated method stub
		return dao.choosePaymentmethod(seat, buttonid);
	
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
		public Seat blockUnblock(Seat markseat) {
			// TODO Auto-generated method stub
			return dao.blockUnblock(markseat);
		}
		
		@Override
		public Booking unblockSeat(Booking Bookingobj) {
			// TODO Auto-generated method stub
			return dao.unblockSeat(Bookingobj);
		}
		
		@Override
		public Booking cancelBooking(Booking cancelBooking) {
			// TODO Auto-generated method stub
			return dao.cancelBooking(cancelBooking);
		}


		@Override
		public List<Show> showShows(Integer screenId) {
			// TODO Auto-generated method stub
			return null;
		}



	
	
}
