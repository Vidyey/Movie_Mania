package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.Dao.IMovieDaoImpl;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
@Service
public class MovieServiceImpl implements IMovieService
{
	@Autowired
	private IMovieDaoImpl dao;

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

}
