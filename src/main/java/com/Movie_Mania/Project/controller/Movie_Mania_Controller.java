package com.Movie_Mania.Project.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.service.MovieService;
import com.Movie_Mania.Project.service.MovieServiceImpl;




@RestController
@RequestMapping("/movie")
public class Movie_Mania_Controller {
	
	/*
	 * Controller is used to handle requests coming from clients
	 * 
	 * Logger is to store the log messages.In case of failure the logger can help to locate the problems
	 */
	private Logger logger = Logger.getRootLogger();
	
	@Autowired
	private MovieServiceImpl ser;
	
	@Autowired
	MovieService mserv;
	
	@GetMapping("/hello")
	public ResponseEntity<Object> checkWorking(){
	return new ResponseEntity<Object>("Hello Customer..", HttpStatus.OK);
	}
	
	
	/*
	 * This mapping will handle the request for registering a customer.It will return the response message
	 */
	@PostMapping(value ="/regCust")	
	public String registerCustomer(@RequestBody Customer customer) {
		logger.info("At Controller - Register customer function");
		return mserv.registerCustomer(customer);
	}
	
	
	/*
	 * This mapping will handle the request for registering a Admin.It will return the response message
	 */
	@PostMapping(value ="/regAdmin")
	public String registerAdmin(@RequestBody Admin admin) {
		logger.info("At Controller - Register admin function");
		return mserv.registerAdmin(admin);
	}
	
	
	/*
	 * This mapping will handle the request for logging in a customer.
	 * It will return the response message true or false
	 */
	@GetMapping(value="/custLogin/{userId}/{password}")
	public boolean custLogin(@PathVariable("userId")Integer userId, @PathVariable("password")String password) 
	{
		logger.info("At Controller - Customer login function");
		return mserv.custLogin(userId, password);
	}
	
	
	/*
	 * This mapping will handle the request for logging in a Admin.
	 * It will return the response message true or false
	 */
	@GetMapping(value="/adminLogin/{userId}/{password}")
	public boolean adminLogin(@PathVariable("userId")Integer userId, @PathVariable("password")String password) 
	{
		logger.info("At Controller - admin login function");
		return mserv.adminLogin(userId, password);
	}

	/*
	 * This mapping will handle the request for Editing in a customer.
	 * It will return the response message
	 */
	@PutMapping(value ="/editCust")
	public String editCustomer(@RequestBody Customer customer) {
		logger.info("At Controller - Edit Customer function");
		return mserv.editCustomer(customer);
	}
	
	/*
	 * This mapping will handle the request for Change password.
	 * It will return the response message 
	 */
	@GetMapping(value = "/changePassword/{userId}/{currentPass}/{newPass}")
	public String changePassword(@PathVariable("userId") Integer userId,
			@PathVariable("currentPass")String currentPassword,@PathVariable("newPass")String newPassword)

	{
		logger.info("At Controller - Change password function");
		return mserv.changePassword(userId, currentPassword, newPassword);
	}
	
	
	/*
	 * This mapping will handle the request for Forgot Password.
	 * It will return the response message
	 */
	@GetMapping(value = "/forgotPassword/{userId}/{securityQue}/{answer}")
	public String forgotPassword(@PathVariable("userId") Integer userId,
			@PathVariable("securityQue")String securityQuestion,@PathVariable("answer")String answer) {
		logger.info("At Controller - Forgot password function");
		return mserv.forgotPassword(userId, securityQuestion, answer);
	}
	
	/*
	 * This mapping will handle the request for getting the All tickets of a customer.
	 * It will return the the List of Tickets
	 */
	@GetMapping("myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") int customerId ){
		logger.info("At Controller - Show My Tickets function");
	return new ResponseEntity<List<Ticket>>(mserv.showTickets(customerId), HttpStatus.OK);
	
	}

	
	/*
	 * This mapping will handle the request for searching a Movie.
	 * It will return the the List of Movies
	 */

	@GetMapping(path="/searchMovie/{movieName}")
	public List<Movie> searchMovie(@PathVariable("movieName") String movieName)
	{
		logger.info("At Controller - Search Movie function");
	return mserv.searchMovie(movieName);
	}

	/*
	 * This mapping will handle the request for Searching a Theatre.
	 * It will return the the List of Theatres
	 */
	@GetMapping(path="/searchTheatre/{theatreName}")
	public List<Theater> searchTheatre(@PathVariable("theatreName") String theatreName)
	{
		logger.info("At Controller - Search Theatre function");
	return mserv.searchTheatre(theatreName);

	}
	
	/*
	 * This mapping will handle the request for getting the Customer by Id.
	 * It will return the the Customer Object
	 */
	@GetMapping(path="/getCust/{userId}")
	public Customer getCustById(@PathVariable("userId") Integer userId)
	{
		logger.info("At Controller - Get customer by id function");
	return mserv.getCustById(userId);

	}
	
	/*
	 * This mapping will handle the request for getting the Admin by Id.
	 * It will return the the Admin Object
	 */
	@GetMapping(path="/getAdmin/{userId}")
	public Admin getAdminById(@PathVariable("userId") Integer userId)
	{
		logger.info("At Controller - Get Admin by id function");
	return mserv.getAdminById(userId);

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
	
//	-----------------------
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value="/hellooo")
	public String poo()
	{
		return "hii";
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
