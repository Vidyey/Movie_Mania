package com.Capgemini.Movie_Mania.Project.Dao;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.BookingState;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.SelectedSeatArray;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.AdminRepository;
import com.Capgemini.Movie_Mania.Project.repo.BookingRepository;
import com.Capgemini.Movie_Mania.Project.repo.CustomerRepository;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepository;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.SeatRepo;
import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;
import com.Capgemini.Movie_Mania.Project.repo.TicketRepository;






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
	public void deleteShow(int show_id) {
		// TODO Auto-generated method stub
		showRepo.deleteById(show_id);
		
	}

	@Override
	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return showRepo.findAll();
	}


	

	@SuppressWarnings("null")
	@Override
	public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation) { //1,1,1,2,1,2
		// TODO Auto-generated method stub
		System.out.println(seatLocation);
		Show show = showRepo.getOne(showId);
		List<Seat> SeatList = show.getSeats();
		System.out.println("-----------------------------------------------------------------------seats checked in dao-----------------------------------------------------------------------------------");
		for (Seat seat : SeatList) {
			System.out.println(seat);
		}
		List<Seat> ChoosedSeat = new ArrayList<Seat>();
		int size = seatLocation.getSeatLocation().length;
		Integer[] seatLoc = seatLocation.getSeatLocation();
		for (int i =0 ; i<size; i=i+2) {
		int row = seatLoc[i];
		int col = seatLoc[i+1]; //(1,1),(1,2),
		
		int loc = (row*10)+(col);
		Seat blockedseat = SeatList.get(loc);
		
		ChoosedSeat.add(blockedseat);
		}
		
		return ChoosedSeat;
		
	}
	@Override
	public  Booking UpdateSeatStatus(Booking BookingObj) {
		
		List<Seat> list =BookingObj.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("Blocked"))
					{
				       seat.setSeatStatus("booked");
					}
			
		}
		Ticket confirmTicket = BookingObj.getTicket();
		
		
		confirmTicket.setTicketStatus(true);
		ticketRepository.save(confirmTicket);
		
		System.out.print("payment success :- Ticket status :-     ");
		System.out.println( BookingObj.getTicket().getTicketStatus());
		seatrepo.saveAll(list);
		bookRepository.save(BookingObj);		
		return BookingObj ;
		
		
	}

	@Override
	public Seat blockUnblock(Seat markseat) {
		// TODO Auto-generated method stub
		
		if(markseat.getSeatStatus().equals("Available"))
		{
	       markseat.setSeatStatus("Blocked");
		}
		else if(markseat.getSeatStatus().equals("Blocked"))
		{
			markseat.setSeatStatus("Available");
		}
		
		Seat marked= seatrepo.save(markseat);
		return marked;
	}


	@Override
	public Booking cancelBooking(Booking cancelBooking) {
		// TODO Auto-generated method stub
		List<Seat> list = cancelBooking.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("booked"))
					{
				       seat.setSeatStatus("Available");
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
			if(seat.getSeatStatus().equals("Blocked"))
					{
				       seat.setSeatStatus("Available");
					}
			
		}
		
		Ticket confirmTicket = Bookingobj.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(Bookingobj);		
		return Bookingobj ;
	}

	@Override
	public void addShow(Show show , int movieId) {
		// TODO Auto-generated method stub
		Movie movieref = movieRepo.getOne(movieId);
		show.setMovieName(movieref);
		showRepo.save(show);
		
		
		List<Seat> seatlist = new ArrayList<Seat>(); 
		  for (int i = 0; i < 5; i++) 
		  { 
			  for(int j = 0; j < 10; j++) 
			  { 
				  Seat seat = new Seat(); 
				  int[] seatLocation ={i,j};
				  seat.setSeatLocation(seatLocation); 
				  seat.setShow(show);
				  seatrepo.save(seat);
				  System.out.println(seat);
		  
		  seatlist.add(seat);
		  
		  } }
		  
		  show.setSeats(seatlist);
			 showRepo.save(show);
	}
	
	
	

}
