package com.Capgemini.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capgemini.Movie_Mania.Project.Dao.IMovieDao;
import com.Capgemini.Movie_Mania.Project.Dao.MovieDaoImpl;
import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.AdminRepo;
import com.Capgemini.Movie_Mania.Project.repo.CustomerRepo;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepo;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;


@Service
	
	
public class MovieServiceImpl implements MovieService
{
	@Autowired

	private MovieDaoImpl dao;
	@Autowired
	CustomerRepo custRepo;


	ShowRepo srepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	private IMovieDao bookDao;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		Customer cust = custRepo.save(customer);
		return cust;
	}
	
	@Override
	public Admin registerAdmin(Admin admin) {
		Admin ad = adminRepo.save(admin);
		return ad;
	}

	
	public List<Ticket> showTickets(int customerId) {
		return bookDao.showTickets(customerId);
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


	public List<Movie> searchMovie(String movieName) {
		// TODO Auto-generated method stub
		return dao.searchMovie(movieName);
	}

	public List<Theater> searchTheatre(String theatreName) {
		
		return dao.searchTheatre(theatreName);
	}
	
public List<Show> searchShow(String showName) {
		
		return dao.searchShow(showName);
	}

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return dao.showShows(screenId);
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

	
	
	
	
	
	
	
//	@Override
//	public List<Movie> searchMovie(String movieName) {
//
//		return mrepo.findByMovieName(movieName);
//	}
//
//	@Override
//	public List<Theater> searchTheatre(String theatreName) {
//		// TODO Auto-generated method stub
//		return trepo.findByTheaterName(theatreName);
//	}
//	
//	@Override
//	public List<Show> searchShow(String showName) {
//		return srepo.findByShowName(showName);
//	}
//
//	@Override
//	public List<Show> showShows(Integer screenId) {
//		Screen screen=screpo.getOne(screenId) ;
//		return screen.getShowList();
//	}


}
