package com.Movie_Mania.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.service.MovieService;
import com.Movie_Mania.Project.service.MovieServiceImpl;




@RestController
public class Movie_Mania_Controller {
	
	@Autowired
	MovieService mserv;
	
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
	
	@GetMapping("/hello")
	public ResponseEntity<Object> checkWorking(){
		return new ResponseEntity<Object>("Hello Customer..", HttpStatus.OK);
	}
	
	@GetMapping("myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<List<Ticket>>(mserv.showTickets(customerId), HttpStatus.OK);
	}
	
	@GetMapping("bookSeat")
	public ResponseEntity<Ticket> bookSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Ticket>(mserv.bookSeat(), HttpStatus.OK);
	}
	
	@GetMapping("cancelSeat")
	public ResponseEntity<Boolean> cancelSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Boolean>(mserv.cancelSeat(), HttpStatus.OK);
	}
	
	@GetMapping("blockSeat")
	public ResponseEntity<Boolean> blockSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Boolean>(mserv.bloackSeat(), HttpStatus.OK);
	}
	
}
