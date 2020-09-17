package com.Movie_Mania.Project.Dao;

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
import com.Movie_Mania.Project.repo.SeatRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;
import com.Movie_Mania.Project.repo.TicketRepository;

@Repository
public class MovieDaoImpl implements IMovieDao {

	private static final Booking Bookingobj = null;

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

	MovieRepository movieRepo;
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired 
	TheatreRepo trepo;
	
	@Autowired
	SeatRepo seatrepo;
	
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

	
//	Movie m1=new Movie(101,111,"abc","fh","gvj",12,"hindi","2020-4-14");
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
      //repo.deleteById(movieId);
		movieRepo.deleteById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
//		List<Movie> movies=new ArrayList<>();
//		movies=repo.findAll();
		
//		List<Movie> movies=new ArrayList<Movie>();
//		movies=repo.findAll();
//		System.out.println(movies);
       return movieRepo.findAll();
		
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
	public  Booking UpdateSeatStatus(Booking BookingObj) {
		
		List<Seat> list =BookingObj.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals(BookingState.Blocked))
					{
				       seat.setSeatStatus(BookingState.booked);
					}
			
		}
		Ticket confirmTicket = BookingObj.getTicket();
		confirmTicket.setTicketStatus(true);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(BookingObj);		
		return BookingObj ;
		
		
	}

	@Override
	public Seat blockUnblock(Seat markseat) {
		// TODO Auto-generated method stub
		
		if(markseat.getSeatStatus().equals(BookingState.Available))
		{
	       markseat.setSeatStatus(BookingState.Blocked);
		}
		else if(markseat.getSeatStatus().equals(BookingState.Blocked))
		{
			markseat.setSeatStatus(BookingState.Available);
		}
		
		seatrepo.save(markseat);
		return markseat;
	}


	@Override
	public Booking cancelBooking(Booking cancelBooking) {
		// TODO Auto-generated method stub
		List<Seat> list = cancelBooking.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals(BookingState.booked))
					{
				       seat.setSeatStatus(BookingState.Available);
					}
			
		}
		Ticket confirmTicket = cancelBooking.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(cancelBooking);		
		return cancelBooking ;
		
	}

	@Override
	public Booking unblockSeat(Booking Bookingobj) {
		// TODO Auto-generated method stub
		List<Seat> list = Bookingobj.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals(BookingState.Blocked))
					{
				       seat.setSeatStatus(BookingState.Available);
					}
			
		}
		
		Ticket confirmTicket = Bookingobj.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(Bookingobj);		
		return Bookingobj ;
	}

	


}
