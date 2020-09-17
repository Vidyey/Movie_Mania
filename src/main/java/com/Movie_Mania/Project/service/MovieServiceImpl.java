package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Customer;


import com.Movie_Mania.Project.Dao.IMovieDao;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
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
	public void addTheater(Theater theater) {
		// TODO Auto-generated method stub
		dao.addTheater(theater);
	}

	@Override
	public void deleteTheater(int theater_id) {
		// TODO Auto-generated method stub
		dao.deleteTheater(theater_id);
		
	}

	@Override
	public List<Theater> getAllTheater() {
		// TODO Auto-generated method stub
		return dao.getAllTheater();
	}

	@Override
	public void addScreen(Screen screen) {
		// TODO Auto-generated method stub
		dao.addScreen(screen);
		
	}

	@Override
	public void deleteScreen(int screen_id) {
		// TODO Auto-generated method stub
dao.deleteScreen(screen_id);
		
	}

	@Override
	public List<Screen> getAllScreen() {
		// TODO Auto-generated method stub
		return dao.getAllScreen();
	}

	@Override
	public void addShow(Show show) {
		// TODO Auto-generated method stub
		dao.addShow(show);
		
	}

	@Override
	public void deleteShow(int show_id) {
		// TODO Auto-generated method stub
		dao.deleteShow(show_id);
		
	}

	@Override
	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return dao.getAllShow();
	}

}
