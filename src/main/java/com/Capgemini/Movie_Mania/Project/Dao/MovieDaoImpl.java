package com.Capgemini.Movie_Mania.Project.Dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.BookingState;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.BookingRepository;
import com.Capgemini.Movie_Mania.Project.repo.CustomerRepository;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepository;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.Seatrepo;
import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;
import com.Capgemini.Movie_Mania.Project.repo.TicketRepository;

@Repository
public class MovieDaoImpl implements IMovieDao {

	@Autowired
	CustomerRepository custRepository;
	
	@Autowired
	BookingRepository bookRepository;
	
	@Autowired
	ShowRepo showRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MovieRepository repo;
	
	@Autowired
	ScreenRepo screenRepo;
	
	
	@Autowired
	TheatreRepo trepo;
	
	private Customer customer;
	
	@Override
	public List<Ticket> showTickets(int customerId) {
		
		customer = new Customer(customerId, "abcd123", "Dhiraj p", Calendar.getInstance().getTime(), "9876556789");
		
		String[] name = {"B1","B2"};
		Ticket ticket = new Ticket(204, 2,name , true, "Audi3");
		
		customer.addTicket(ticket);
		
		custRepository.save(customer);
		
		return custRepository.getOne(customerId).getMyTickets();
	}

	@Override
	public Boolean cancelSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket bookSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean bloackSeat() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

	
//	Movie m1=new Movie(101,111,"abc","fh","gvj",12,"hindi","2020-4-14");
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
       repo.save(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
      //repo.deleteById(movieId);
		repo.deleteById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
//		List<Movie> movies=new ArrayList<>();
//		movies=repo.findAll();
		
//		List<Movie> movies=new ArrayList<Movie>();
//		movies=repo.findAll();
//		System.out.println(movies);
       return repo.findAll();
		
	}

	@Override
	public List<Movie> searchMovie(String movieName) {
		return repo.findByMovieName(movieName);
	}

	@Override
	public List<Theater> searchTheatre(String theatreName) {
		return trepo.findByTheaterName(theatreName);
	}

	@Override
	public List<Show> showShows(Integer screenId) {
		Screen screen =screenRepo.getOne(screenId);
		return screen.getShowList();
	}

	public List<Show> searchShow(String showName) {
	return  showRepository.findByShowName(showName);
		
	}

//	mahesh module
	
	
	@Autowired
	Seatrepo seatrepository;
	Booking booking1;
	Show show;
	Ticket ticket1=new Ticket();
	double sum=0;
	
	
	@Override
	public double calculateTotalCost(List<Seat> seat) {
		// TODO Auto-generated method stub
//		List<Seat> seat=booking.getSeatList();
		
		for(int i=0; i<seat.size();i++) {
			sum=sum+seat.get(i).getSeatPrice();
		}
//			booking.setTotalCost(sum);
//			bookRepository.save(booking);
			return sum;
	}

	@Override
	public Booking makePayment(Booking booking) {

		booking.getTransactionId();
		
		
		Ticket printTicket = booking.getTicket();

				printTicket.setNoOfSeats(booking.getSeatList().size());
		printTicket.setScreenName(booking.getShowRef().getShowName());
		
		booking.getTicket().setTicketStatus(true);
		booking.setTicket(printTicket);

//				UpdateSeatStatus(booking);
		
		return booking;
	}

	
	@Override
	public Booking cancelticket(Ticket ticket) {
		
//		cancelticket=cancelBooking(cancelticket);
		Ticket ticket1=ticketRepository.getOne(ticket.getTicketId());
		Booking cancelBooking=ticket1.getBookingRef();
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
		seatrepository.saveAll(list);
		bookRepository.save(cancelBooking);		
		return cancelBooking ;
		
	
	}
		
	@Override
	public Booking choosePaymentmethod(List<Seat> seat, int buttonid) {
		Booking b = null; 
		Seat s1 =seat.get(0);		
		b.setShowId(show.getShowId());		
		b.setSeatList(seat);
		b.setMovieId(show.getMovieName().getMovieId());
		b.setTotalCost(calculateTotalCost( seat));
		b.setBookingDate(java.time.LocalDate.now());
			
		b.setTransactionId(buttonid);
		b.setShowRef(show);
		b.setTicket(ticket1);
		bookRepository.save(b);	
		return b;
	}

}
