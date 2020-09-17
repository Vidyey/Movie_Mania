package com.Movie_Mania.Project.Dao;

import java.util.ArrayList;
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
	TheatreRepo theatreRepo; 
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	ShowRepo showRepo;
	
	private Customer customer;
	
//	private Theater theaterobj ;
	
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
	
	

	

	
	
	
	
//	-----------------------------------------------------------------------------------

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
       repo.save(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
     
		repo.deleteById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub

       return repo.findAll();
		
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


}
