package com.Movie_Mania.Project.Dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
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


}
