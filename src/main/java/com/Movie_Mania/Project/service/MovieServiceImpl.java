package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Customer;


import com.Movie_Mania.Project.Dao.IMovieDao;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Seat;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;



@Service

	
public class MovieServiceImpl implements MovieService
{
	
	
	
	@Autowired
	private IMovieDao dao;
	

	
	@Override
	public String registerCustomer(Customer customer) {
		return dao.registerCustomer(customer);
	}

	@Override
	public String registerAdmin(Admin admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public boolean custLogin(Integer userId, String password) {
		return dao.custLogin(userId, password);
	}
	
	@Override
	public boolean adminLogin(Integer userId, String password) {
		return dao.adminLogin(userId, password);
	}

	@Override
	public String changePassword(Integer userId, String currentPassword, String newPassword) {
		return dao.changePassword(userId, currentPassword, newPassword);
	}

	@Override
	public String editCustomer(Customer customer) {
		return dao.editCustomer(customer);
	}

	@Override
	public String forgotPassword(Integer userId, String securityQuestion, String answer) {
		return dao.forgotPassword(userId, securityQuestion, answer);
	}

	public List<Ticket> showTickets(int customerId) {
		return dao.showTickets(customerId);
	}

	public List<Movie> searchMovie(String movieName) {
		return dao.searchMovie(movieName);
	}

	public List<Theater> searchTheatre(String theatreName) {
		
		return dao.searchTheatre(theatreName);
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


	

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> SelectSeat(Show show, int[] seatLocation) {
		// TODO Auto-generated method stub
		return null;
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


	
	


}