package com.Movie_Mania.Project.service;

import java.util.List;

import com.Movie_Mania.Project.entity.Movie;

public interface IMovieService {
	public void addMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Movie> getAllMovies();
}
