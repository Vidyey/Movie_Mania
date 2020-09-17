package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Movie_Mania.Project.Dao.MovieDaoImpl;
import com.Movie_Mania.Project.Dao.IMovieDao;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;

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


	ShowRepo srepo;
	
	@Autowired
	ScreenRepo screpo;
	
	@Autowired
	private IMovieDao bookDao;
	
	@Override
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
		return null;
	}

	public List<Theater> searchTheatre(String theatreName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Show> searchShow(String movieName) {
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
