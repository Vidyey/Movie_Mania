package com.Movie_Mania.Project.Dao;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.BookingState;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;

import com.Movie_Mania.Project.entity.Seat;

import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.repo.AdminRepository;
import com.Movie_Mania.Project.repo.BookingRepository;
import com.Movie_Mania.Project.repo.CustomerRepository;
import com.Movie_Mania.Project.repo.MovieRepository;
import com.Movie_Mania.Project.repo.ScreenRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;
import com.Movie_Mania.Project.repo.TicketRepository;

@Repository
public class MovieDaoImpl implements IMovieDao {

	@Autowired
	CustomerRepository custRepository;
	

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	BookingRepository bookRepository;
	
	@Autowired
	ShowRepo showRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired

	 MovieRepository repo;
	
	@Autowired
	TheatreRepo theatreRepo; 

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	ScreenRepo screenRepo;
	

	@Autowired
	ShowRepo showRepo;
	
	
//	private Theater theaterobj ;

	@Autowired 
	TheatreRepo trepo;
	
	private Customer customer;
	
	//Dhiraj Modules
	

	
	@Override
	public String registerCustomer(Customer customer) {
		
			if(custRepository.existsById(customer.getUserId())) 
			{
				return "Customer Already Exists.Try login or forgot password";
			}
			else {
				custRepository.save(customer);
				return customer.getCustomerName()+" is registered successfully!..";
			}
		
	}

	@Override
	public String registerAdmin(Admin admin) {
		if(adminRepo.existsById(admin.getUserId())) 
		{
			return "Admin Already Exists.Try login or forgot password";
		}
		else {
			adminRepo.save(admin);
			return admin.getAdminName()+" is registered successfully!..";
		}
	}

	@Override
	public boolean custLogin(Integer userId, String password) {
		
		if(custRepository.existsById(userId)) {
			customer = custRepository.getOne(userId);
			if(customer.getPassword().equals(password))
				return true;
			else return false;
		}
		else
		return false;
	}

	@Override
	public boolean adminLogin(Integer userId, String password) {
		
		if(adminRepo.existsById(userId)) {
			Admin admin = adminRepo.getOne(userId);
			if(admin.getPassword().equals(password))
				return true;
			else return false;
		}
		else
		return false;
	}
	@Override
	public String changePassword(Integer userId, String currentPassword, String newPassword) {
		customer = custRepository.getOne(userId);
		if(customer.getPassword().equals(currentPassword)) 
		{
			if(currentPassword.equals(newPassword)) {
				return "New password can't be Same as Current";
			}
			customer.setPassword(newPassword);
			custRepository.save(customer);
			return "Password changed successfully";
		}
		else 
		{
			return "Current Password is incorrect";
		}
	}

	@Override
	public String editCustomer(Customer customer) {
		custRepository.save(customer);
		return customer.getCustomerName()+" is updated successfully!..";
	}

	@Override
	public String forgotPassword(Integer userId, String securityQuestion, String answer) {
		if(custRepository.existsById(userId)) {
			customer = custRepository.getOne(userId);
			if(customer.getSecurityQuestion().equals(securityQuestion) && customer.getAnswer().equals(answer)) {
				return "Your password is "+customer.getPassword()+". Plz change it for security purpose.";
			}
			return "Invalid Security question/Answer";
		}
		else
			return "UserId does not exist";
	}
	
	
	@Override
	public List<Ticket> showTickets(int customerId) {
		if(custRepository.existsById(customerId))
		return custRepository.getOne(customerId).getMyTickets();
		else
			return null;
	}
	
	@Override
	public List<Movie> searchMovie(String movieName) {
		return movieRepo.findByMovieName(movieName);
	}

	@Override
	public List<Theater> searchTheatre(String theatreName) {
		return trepo.findByTheaterName(theatreName);
	}
	
	
	///End of Dhiraj Modules
	


	
	@Override
	public List<Show> showShows(Integer screenId) {
		Screen screen =screenRepo.getOne(screenId);
		return screen.getShowList();
	}

	
	
	
	
//	-----------------------------------------------------------------------------------

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub

     
		repo.deleteById(movieId);

      //repo.deleteById(movieId);
		

	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub


//       return repo.findAll();

       return movieRepo.findAll();

		
	}

	@Override
	public void addTheater(Theater theater) {
		// TODO Auto-generated method stub
		theatreRepo.save(theater);
	}

	@Override
	public void deleteTheater(int theater_id) {
		// TODO Auto-generated method stub
		theatreRepo.deleteById(theater_id);
		
	}

	@Override
	public List<Theater> getAllTheater() {
		// TODO Auto-generated method stub

		return theatreRepo.findAll();
	}

	@Override
	public void addScreen(Screen screen) {
		// TODO Auto-generated method stub
		screenRepo.save(screen);
		
	}

	@Override
	public void deleteScreen(int screen_id) {
		// TODO Auto-generated method stub
		screenRepo.deleteById(screen_id);
		
	}

	@Override
	public List<Screen> getAllScreen() {
		// TODO Auto-generated method stub
		return screenRepo.findAll();
	}

	@Override
	public void addShow(Show show) {
		// TODO Auto-generated method stub
		showRepo.save(show);
	}

	@Override
	public void deleteShow(int show_id) {
		// TODO Auto-generated method stub
		showRepo.deleteById(show_id);
		
	}

	@Override
	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return showRepo.findAll();
	}


	

	@Override
	public List<Seat> SelectSeat(Show show, int[] seatLocation) {
		// TODO Auto-generated method stub
		List<Seat> SeatList = show.getSeats();
		List<Seat> ChoosedSeat = null;
		int size = seatLocation.length;
		for (int i =0 ; i<size; i=i+2) {
		int row = seatLocation[i];
		int col = seatLocation[i+1];
		
		int loc = (row*10)+(col+1);
		;
		ChoosedSeat.add(SeatList.get(loc));
		}
		
		return ChoosedSeat;
		
	}
	@Override
	public Boolean UpdateSeatStatus(Booking BookingObj) {
		
		List<Seat>List =BookingObj.getSeatList();
		for (Seat seat : List) {
			if(seat.getSeatStatus().equals(BookingState.Blocked))
					{
				       seat.setSeatStatus(BookingState.booked);
					}
			else {
				return false;
			}
		}
		return true;
		
		
		
	}

	@Override
	public Booking initiateBooking(Booking BookingObj) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	


}
