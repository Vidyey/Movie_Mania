package com.Movie_Mania.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.service.MovieService;
import com.Movie_Mania.Project.service.MovieServiceImpl;




@RestController
@RequestMapping("/movie")
public class Movie_Mania_Controller {
	
	
	
	
	@Autowired
	private MovieServiceImpl ser;
	
	@Autowired
	MovieService mserv;
	
	@GetMapping("/hello")
	public ResponseEntity<Object> checkWorking(){
	return new ResponseEntity<Object>("Hello Customer..", HttpStatus.OK);
	}
	
	
	@PostMapping(value ="/regCust")
	public String registerCustomer(@RequestBody Customer customer) {
		return mserv.registerCustomer(customer);
	}
	
	@PostMapping(value ="/regAdmin")
	public String registerAdmin(@RequestBody Admin admin) {
		return mserv.registerAdmin(admin);
	}
	
	@GetMapping(value="/custLogin/{userId}/{password}")
	public boolean custLogin(@PathVariable("userId")Integer userId, @PathVariable("password")String password) 
	{
		return mserv.custLogin(userId, password);
	}
	
	@GetMapping(value="/adminLogin/{userId}/{password}")
	public boolean adminLogin(@PathVariable("userId")Integer userId, @PathVariable("password")String password) 
	{
		return mserv.adminLogin(userId, password);
	}
	
	@PutMapping(value ="/editCust")
	public String editCustomer(@RequestBody Customer customer) {
		return mserv.editCustomer(customer);
	}
	
	@GetMapping(value = "/changePassword/{userId}/{currentPass}/{newPass}")
	public String changePassword(@PathVariable("userId") Integer userId,
			@PathVariable("currentPass")String currentPassword,@PathVariable("newPass")String newPassword)
	{
		return mserv.changePassword(userId, currentPassword, newPassword);
	}
	
	@GetMapping(value = "/forgotPassword/{userId}/{securityQue}/{answer}")
	public String forgotPassword(@PathVariable("userId") Integer userId,
			@PathVariable("securityQue")String securityQuestion,@PathVariable("answer")String answer) {
		return mserv.forgotPassword(userId, securityQuestion, answer);
	}
	
	@GetMapping("myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") int customerId ){
	return new ResponseEntity<List<Ticket>>(mserv.showTickets(customerId), HttpStatus.OK);
	}

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value="/hellooo")
	public String poo()
	{
		return "hii";
	}
	@PostMapping(value="/addMovie")
	public void addMovie(@RequestBody Movie movie)
	{

	ser.addMovie(movie);
	}



	@GetMapping(value="/getMovies")
	public List<Movie> GetAllTopics()
	{
	return ser.getAllMovies();
	}
	
	



	@GetMapping(path="/showShows/{screenId}")
	public List<Show> showShows(@PathVariable("screenId") Integer screenId)
	{
	return mserv.showShows(screenId);
	}

	

	

	
	
	
	
	
}
