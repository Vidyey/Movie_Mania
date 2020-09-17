package com.Movie_Mania.Project.Dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.BookingState;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Seat;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
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
	
	@Autowired
	SeatRepo seatrepo;
	
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
