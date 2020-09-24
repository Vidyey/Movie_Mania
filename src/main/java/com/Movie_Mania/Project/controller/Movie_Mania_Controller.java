package com.Movie_Mania.Project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Booking;
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
	

//	Movie-------------------------------------------------------
//	@PostMapping(value="/addMovie/{theater_id}")
//	public void addMovie(@PathVariable("theater_id")Integer theater_id,@RequestBody Movie movie)
//	{
//		movie.setTheatre(ser.getTheater(theater_id));
//		ser.addMovie(movie);
//	}

	
//	---------------------Movie------------------------
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addMovie")
	public String addMovie(@RequestBody Movie movie)
	{
       return ser.addMovie(movie);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteMovie/{movieId}")
	public String deleteMovie(@PathVariable("movieId") int movieId)
	{
		return ser.deleteMovie(movieId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getMovies")
	public List<Movie> GetAllMovies()
	{
	return ser.getAllMovies();
	}
//	--------------------------------------------------------------------
	
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
	

	
	
	
//---------------------Theater---------------------------------------------
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addTheater")
	public String addTheater(@RequestBody Theater theater)
	{
		System.out.println(theater.toString());
		return ser.addTheater(theater);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteTheater/{theater_id}")
	public String deleteTheater(@PathVariable("theater_id") int theater_id)
	{
		
		return ser.deleteTheater(theater_id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getTheater")
	public List<Theater> GetAllTheater()
	{
	
	
		return ser.getAllTheater();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getTheaterById/{theater_id}")
	public Theater GetTheaterById(@PathVariable("theater_id") int theater_id)
	{
		return ser.grtTheaterById(theater_id);
	}
//-----------------------Screen---------------------------------------
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addScreen/{theatreId}")
	public String addScreen(@RequestBody Screen screen,@PathVariable("theatreId") int theatreId)
	{
		screen.setTheatre(ser.getTheater(theatreId));
		return ser.addScreen(screen);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteScreen/{screen_id}")
	public String deleteScreen(@PathVariable("screen_id") int screen_id)
	{
		
		return ser.deleteScreen(screen_id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getScreen")
	public List<Screen> GetAllScreen()
	{
		return ser.getAllScreen();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getScreenById/{screen_id}")
	public Screen GetScreenById(@PathVariable("screen_id") int screen_id)
	{
		return ser.getScreen(screen_id);
	}
//----------------------------Show---------------------------

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addShow/{screen_id}")
	public String addShow(@RequestBody Show show,@PathVariable("screen_id") int screen_id)
	{
		show.setScreen(ser.getScreen(screen_id));
		return ser.addShow(show);
//		return ser.addShow(show);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addShow")
	public void addShow(@RequestBody Show show)
	{
		System.out.println(show.toString());
		ser.addShow(show);
	}

	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteShow/{show_id}")
	public String deleteShow(@PathVariable("show_id") int show_id)
	{
		
		return ser.deleteShow(show_id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getShow")
	public List<Show> GetAllShow()
	{
	
	
		return ser.getAllShow();
	}
	
	
	
//	----------------------------------------------------------
	
	

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
	




	
	
	



	@GetMapping(path="/showShows/{screenId}")
	public List<Show> showShows(@PathVariable("screenId") Integer screenId)
	{
	return mserv.showShows(screenId);
	}

	

	

	
	
	
	
	
}
