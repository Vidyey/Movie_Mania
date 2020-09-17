package com.Movie_Mania.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.service.MovieService;
import com.Movie_Mania.Project.service.MovieServiceImpl;




@RestController
public class Movie_Mania_Controller {
	
	
	
	
	@Autowired
	private MovieServiceImpl ser;
	
	@Autowired
	MovieService mserv;
	
	
	
	@GetMapping(value="/hellooo")
	public String poo()
	{
		return "hii";
	}
	
//	Movie
	@PostMapping(value="/addMovie")
	public void addMovie(@RequestBody Movie movie)
	{
		System.out.println(movie.toString());
		ser.addMovie(movie);
	}

	@DeleteMapping(value="/deleteMovie/{movieId}")
	public void deleteMovie(@PathVariable("movieId") int movieId)
	{
		ser.deleteMovie(movieId);
	}
	
	
	@GetMapping(value="/getMovies")
	public List<Movie> GetAllMovies()
	{
	return ser.getAllMovies();
	}
	
	
	
	
//	Theater
	@PostMapping(value="/addTheater")
	public void addTheater(@RequestBody Theater theater)
	{
		System.out.println(theater.toString());
		ser.addTheater(theater);
	}

	@DeleteMapping(value="/deleteTheater/{theater_id}")
	public void deleteTheater(@PathVariable("theater_id") int theater_id)
	{
		
		ser.deleteTheater(theater_id);
	}
	
	@GetMapping(value="/getTheater")
	public List<Theater> GetAllTheater()
	{
	
	
		return ser.getAllTheater();
	}
	
	
	
	//Screen
	@PostMapping(value="/addScreen")
	public void addScreen(@RequestBody Screen screen)
	{
		System.out.println(screen.toString());
		ser.addScreen(screen);
	}

	@DeleteMapping(value="/deleteScreen/{screen_id}")
	public void deleteScreen(@PathVariable("screen_id") int screen_id)
	{
		
		ser.deleteScreen(screen_id);
	}
	
	@GetMapping(value="/getScreen")
	public List<Screen> GetAllScreen()
	{
	
	
		return ser.getAllScreen();
	}
	
	//Show
	
	@PostMapping(value="/addShow")
	public void addShow(@RequestBody Show show)
	{
		System.out.println(show.toString());
		ser.addShow(show);
	}

	@DeleteMapping(value="/deleteShow/{show_id}")
	public void deleteShow(@PathVariable("show_id") int show_id)
	{
		
		ser.deleteShow(show_id);
	}
	
	@GetMapping(value="/getShow")
	public List<Show> GetAllShow()
	{
	
	
		return ser.getAllShow();
	}
	
//	-----------------------
	
	
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
