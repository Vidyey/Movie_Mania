package com.Movie_Mania.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.service.MovieServiceImpl;




@RestController
public class Movie_Mania_Controller {
	
	@Autowired
	MovieServiceImpl mserv;
	
	@GetMapping(path="/searchMovie/{movieName}")
	public List<Movie> searchMovie(@PathVariable("movieName") String movieName)
	{
		return mserv.searchMovie(movieName);
	}
	
	@GetMapping(path="/searchTheatre/{theatreName}")
	public List<Theater> searchTheatre(@PathVariable("theatreName") String theatreName)
	{
		return mserv.searchTheatre(theatreName);
		
	}
	
	@GetMapping(path="/searchShow/{showName}")
	public List<Theater> searchShow(@PathVariable("showName") String showName)
	{
		return mserv.searchTheatre(showName);
		
	}
	
	
	@GetMapping(path="/showShows/{screenId}")
	public List<Show> showShows(@PathVariable("screenId") Integer screenId)
	{
		return mserv.showShows(screenId);
	}
	
}
