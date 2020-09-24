package com.Movie_Mania.Project.service;

import java.util.List;
import java.util.Optional;

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
	
	
	

	
//-----------------------------Movie-------------------------------------
	@Override
	public String addMovie(Movie movie) {
		return dao.addMovie(movie);
		

	}

	@Override
	public String deleteMovie(int movieId) {
		return dao.deleteMovie(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return dao.getAllMovies();

	}


//	-------------------------------------------------------------------------

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

//----------------------------Theater---------------------------------
	@Override
	public String addTheater(Theater theater) {
		 return dao.addTheater(theater);
		
	}

	@Override
	public String deleteTheater(int theater_id) {
		// TODO Auto-generated method stub
		return dao.deleteTheater(theater_id);
	
		
	}

	@Override
	public List<Theater> getAllTheater() {
		// TODO Auto-generated method stub
		return dao.getAllTheater();
	}


	
//	---------------------------Screen---------------------------------
	@Override
	public String addScreen(Screen screen) {
		return dao.addScreen(screen);
		
	}

	@Override
	public String deleteScreen(int screen_id) {
		return dao.deleteScreen(screen_id);
		
	}

	@Override
	public List<Screen> getAllScreen() {
		// TODO Auto-generated method stub
		return dao.getAllScreen();
	}
	@Override
	public List<Screen> getAllScreenById(int theater_id) {
		// TODO Auto-generated method stub
		return null;
	}
//	--------------------------Show---------------------------------
	@Override
	public String addShow(Show show) {
		return dao.addShow(show);
		 
		
	}

	@Override
	public String deleteShow(int show_id) {
		return dao.deleteShow(show_id);
		
	}

	@Override
	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return dao.getAllShow();
	}
//-------------------------------------------------------------
	//not required
@Override
	public Theater getTheater(int theater_id) {
		// TODO Auto-generated method stub
		return dao.getTheater(theater_id);
	}



	@Override
	public Theater grtTheaterById(int theater_id) {
		// TODO Auto-generated method stub
		return dao.grtTheaterById(theater_id);
	}

	@Override
	public Screen getScreen(int screen_id) {
		// TODO Auto-generated method stub
		return dao.getScreen(screen_id);
	}

	

//	@Override
//	public Optional<Screen> getAllScreensByTherateid(int theater_id) {
//		// TODO Auto-generated method stub
//		return dao.getAllScreensByTherateid(theater_id);
//	}

}
