package com.Movie_Mania.Project.Dao;



import java.util.List;

import org.apache.log4j.Logger;
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

	private Logger logger = Logger.getRootLogger();
	
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
	

	/*
	 * Register a customer 
	 * If customer already exists then it will not be registered again.
	 * If doesn't exist will be registered
	 */

	@Override
	public String registerCustomer(Customer customer) {
		
			if(custRepository.existsById(customer.getUserId())) 
			{
				logger.error("Customer Already Exists.");
				return "Customer Already Exists.Try login or forgot password";
			}
			else {
				custRepository.save(customer);
				logger.info(customer.getCustomerName()+" is registered successfully!..");
				return customer.getCustomerName()+" is registered successfully!..";
			}
		
	}

	/*
	 * Register a Admin 
	 * If admin already exists then it will not be registered again.
	 * If doesn't exist will be registered
	 */
	@Override
	public String registerAdmin(Admin admin) {
		if(adminRepo.existsById(admin.getUserId())) 
		{
			logger.error("Admin Already Exists.");
			return "Admin Already Exists.Try login or forgot password";
		}
		else {
			adminRepo.save(admin);
			logger.info(admin.getAdminName()+" is registered successfully!..");
			return admin.getAdminName()+" is registered successfully!..";
		}
	}

	/*
	 * Customer Login 
	 * If login credentials are correct it will return true.
	 * else return false
	 */
	@Override
	public boolean custLogin(Integer userId, String password) {
		
		if(custRepository.existsById(userId)) {
			customer = custRepository.getOne(userId);
			if(customer.getPassword().equals(password)) {
				logger.info("Login successfull");
				return true;
				
			}
			else 
				{
				logger.error("Incorrect password");
					return false;
				}
		}
		else {
			logger.error("Customer doesnt exist");
			return false;
		}
	}

	/*
	 * Admin Login 
	 * If login credentials are correct it will return true.
	 * else return false
	 */
	@Override
	public boolean adminLogin(Integer userId, String password) {
		
		if(adminRepo.existsById(userId)) {
			Admin admin = adminRepo.getOne(userId);
			if(admin.getPassword().equals(password))
			 {
				logger.info("Login successfull");
				return true;
				
			}
			else{
				logger.error("Incorrect password");
				return false;
			}
		}
		else
		{
			logger.error("Admin doesnt exist");
			return false;
		}
	}
	
	/*
	 * Change Password
	 * The current password should be correct
	 * New password can't be Same as Current
	 */
	@Override
	public String changePassword(Integer userId, String currentPassword, String newPassword) {
		customer = custRepository.getOne(userId);
		if(customer.getPassword().equals(currentPassword)) 
		{
			if(currentPassword.equals(newPassword)) {
				logger.error("New password can't be Same as Current");
				return "New password can't be Same as Current";
			}
			customer.setPassword(newPassword);
			custRepository.save(customer);
			logger.info("Password changed successfully");
			return "Password changed successfully";
		}
		else 
		{
			logger.error("Current Password is incorrect");
			return "Current Password is incorrect";
		}
	}

	/*
	 * Edit Customer
	 * Customer can edit his details
	 */
	@Override
	public String editCustomer(Customer customer) {
		custRepository.save(customer);
		logger.info(customer.getCustomerName()+" is updated successfully!..");
		return customer.getCustomerName()+" is updated successfully!..";
	}

	/*
	 * Forgot Password
	 * Customer can retrieve his password by Giving Security Question and its answer
	 * Both should match the existing user
	 */
	@Override
	public String forgotPassword(Integer userId, String securityQuestion, String answer) {
		if(custRepository.existsById(userId)) {
			customer = custRepository.getOne(userId);
			if(customer.getSecurityQuestion().equals(securityQuestion) && customer.getAnswer().equals(answer)) {
				logger.info("Password retrieved");
				return "Your password is "+customer.getPassword()+". Plz change it for security purpose.";
			}
			logger.error("Invalid Security question/Answer");
			return "Invalid Security question/Answer";
		}
		else {
			logger.error("UserId does not exist");
			return "UserId does not exist";
		}
	}
	
	@Override
	public Customer getCustById(Integer userId) {
		logger.info("Customer retrieved");
		return custRepository.getOne(userId);
	}

	@Override
	public Admin getAdminById(Integer userId) {
		logger.info("Admin retrieved");
		return adminRepo.getOne(userId);
	}
	
	/*
	 * Show Tickets
	 * Customer can see his booking history
	 * All tickets can be seen booked or cancelled also
	 */
	@Override
	public List<Ticket> showTickets(int customerId) {
		if(custRepository.existsById(customerId)) {
			logger.info("Tickets retrieved");
		return custRepository.getOne(customerId).getMyTickets();
		}
		else
			return null;
	}
	
	/* Search Movie
	 * Customer can serach a movie by its name
	 * Can see all theatres in which the movie is running
	 */
	@Override
	public List<Movie> searchMovie(String movieName) {
		logger.info("At DAO - Search movie");
		return movieRepo.findByMovieName(movieName);
	}

	/*
	 * Search Theatre
	 * Customer can search a theatre by its name
	 * Can see all movies in that theatre
	 */
	@Override
	public List<Theater> searchTheatre(String theatreName) {
		logger.info("At DAO - Search Theatre");
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
