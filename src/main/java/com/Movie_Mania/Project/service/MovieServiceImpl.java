package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;


import com.Movie_Mania.Project.Dao.MovieDaoImpl;
import com.Movie_Mania.Project.Dao.IMovieDao;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.repo.AdminRepo;
import com.Movie_Mania.Project.repo.CustomerRepo;

import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.repo.MovieRepo;
import com.Movie_Mania.Project.repo.ScreenRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;


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

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return dao.showShows(screenId);
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
