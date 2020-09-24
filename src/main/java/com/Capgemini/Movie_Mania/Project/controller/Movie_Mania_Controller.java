package com.Capgemini.Movie_Mania.Project.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RestController;

import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.SelectedSeatArray;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.requests.ForgotPasswordRequest;
import com.Capgemini.Movie_Mania.Project.service.MovieService;
import com.Capgemini.Movie_Mania.Project.service.MovieServiceImpl;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movie")
public class Movie_Mania_Controller {
	
	/*
	 * Controller is used to handle requests coming from clients
	 * 
	 * Logger is to store the log messages.In case of failure the logger can help to locate the problems
	 */
//private Logger logger = Logger.getRootLogger();
	
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
//		logger.info("At Controller - Register customer function");
		return mserv.registerCustomer(customer);
	}
	
	
	/*
	 * This mapping will handle the request for registering a Admin.It will return the response message
	 */
	@PostMapping(value ="/regAdmin")
	public String registerAdmin(@RequestBody Admin admin) {
//		logger.info("At Controller - Register admin function");
		return mserv.registerAdmin(admin);
	}
	
	
	/*
	 * This mapping will handle the request for logging in a customer.
	 * It will return the response message true or false
	 */
	@GetMapping(value="/custLogin/{userId}/{password}")
	public boolean custLogin(@PathVariable("userId")String userId, @PathVariable("password")String password) 
	{
//		logger.info("At Controller - Customer login function");
		return mserv.custLogin(userId, password);
	}
	
	
	/*
	 * This mapping will handle the request for logging in a Admin.
	 * It will return the response message true or false
	 */
	@GetMapping(value="/adminLogin/{userId}/{password}")
	public boolean adminLogin(@PathVariable("userId")String userId, @PathVariable("password")String password) 
	{
//		logger.info("At Controller - admin login function");
		return mserv.adminLogin(userId, password);
	}

	/*
	 * This mapping will handle the request for Editing in a customer.
	 * It will return the response message
	 */
	@PutMapping(value ="/editCust")
	public String editCustomer(@RequestBody Customer customer){
//		logger.info("At Controller - Edit Customer function");
		return mserv.editCustomer(customer);
	}
	
	@PutMapping(value ="/editAdmin")
	public String editAdmin(@RequestBody Admin admin){
//		logger.info("At Controller - Edit Admin function");
		return mserv.editAdmin(admin);
	}
	
	/*
	 * This mapping will handle the request for Change password.
	 * It will return the response message 
	 */
	@GetMapping(value = "/changePassword/{userId}/{currentPass}/{newPass}")
	public String changePassword(@PathVariable("userId") String userId,
			@PathVariable("currentPass")String currentPassword,@PathVariable("newPass")String newPassword)

	{
//		logger.info("At Controller - Change password function");
		return mserv.changePassword(userId, currentPassword, newPassword);
	}
	
	@GetMapping(value = "/changePasswordAdmin/{userId}/{currentPass}/{newPass}")
	public String changePasswordAdmin(@PathVariable("userId") String userId,
			@PathVariable("currentPass")String currentPassword,@PathVariable("newPass")String newPassword)

	{
//		logger.info("At Controller - Change password Admin function");
		return mserv.changePasswordAdmin(userId, currentPassword, newPassword);
	}
	
	
	/*
	 * This mapping will handle the request for Forgot Password.
	 * It will return the response message
	 */
	@PostMapping(value = "/forgotPassword")
	public String forgotPassword(@RequestBody ForgotPasswordRequest forgotpPassRequest) {
//		logger.info("At Controller - Forgot password function");
		return mserv.forgotPassword(forgotpPassRequest.getUsername(), forgotpPassRequest.getSecurityQuestion(), forgotpPassRequest.getSecurityAnswer());
	}
	
	@PostMapping(value = "/forgotPasswordAdmin")
	public String forgotPasswordAdmin(@RequestBody ForgotPasswordRequest forgotpPassRequest) {
//		logger.info("At Controller - Forgot password Admin function");
		return mserv.forgotPasswordAdmin(forgotpPassRequest.getUsername(), forgotpPassRequest.getSecurityQuestion(), forgotpPassRequest.getSecurityAnswer());
	}
	
	/*
	 * This mapping will handle the request for getting the All tickets of a customer.
	 * It will return the the List of Tickets
	 */
	@GetMapping("myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") String customerId ){
//		logger.info("At Controller - Show My Tickets function");
	return new ResponseEntity<List<Ticket>>(mserv.showTickets(customerId), HttpStatus.OK);
	
	}

	
	/*
	 * This mapping will handle the request for searching a Movie.
	 * It will return the the List of Movies
	 */

	@GetMapping(path="/searchMovie/{movieName}")
	public List<Movie> searchMovie(@PathVariable("movieName") String movieName)
	{
//		logger.info("At Controller - Search Movie function");
	return mserv.searchMovie(movieName);
	}

	/*
	 * This mapping will handle the request for Searching a Theatre.
	 * It will return the the List of Theatres
	 */
	@GetMapping(path="/searchTheatre/{theatreName}")
	public List<Theater> searchTheatre(@PathVariable("theatreName") String theatreName)
	{
//		logger.info("At Controller - Search Theatre function");
	return mserv.searchTheatre(theatreName);

	}
	
	/*
	 * This mapping will handle the request for getting the Customer by Id.
	 * It will return the the Customer Object
	 */
	@GetMapping(path="/getCust/{userId}")
	public Customer getCustById(@PathVariable("userId") String userId)
	{
//		logger.info("At Controller - Get customer by id function");
	return mserv.getCustById(userId);

	}
	
	/*
	 * This mapping will handle the request for getting the Admin by Id.
	 * It will return the the Admin Object
	 */
	@GetMapping(path="/getAdmin/{userId}")
	public Admin getAdminById(@PathVariable("userId") String userId) 
	{
//		logger.info("At Controller - Get Admin by id function");
		return mserv.getAdminById(userId);

	}
	
//	----------------Prajakta-------------------------------
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
//			return ser.addShow(show);
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
		
		
		
//		----------------------------------------------------------
		
	
	
	
	
	
	
	


//-----------------------------------------------------------
	@GetMapping(path="/showShows/{screenId}")
	public List<Show> showShows(@PathVariable("screenId") Integer screenId)
	{
	return mserv.showShows(screenId);
	}

	

	

	@PostMapping("cancelticket")
	public ResponseEntity<Booking> cancelticket(@RequestBody Ticket ticket){
	return new ResponseEntity<Booking>(mserv.cancelticket(ticket),HttpStatus.OK);
		
	}
	
	@PostMapping("makePayment")
	public ResponseEntity<Booking> makePayment(@RequestBody Booking booking){
	return new ResponseEntity<Booking>(mserv.makePayment(booking),HttpStatus.OK);
	}	
	
	@PostMapping("calculateTotalCost")
	public ResponseEntity<Double> calculateTotalCost(@RequestBody List<Seat> seat){
    return new ResponseEntity<Double>(mserv.calculateTotalCost(seat), HttpStatus.OK);
	}
	@PutMapping(value="/choosePaymentmethod/{buttonid}")
	public Booking choosePaymentmethod(@RequestBody List<Seat> seat, @PathVariable("buttonid") int buttonid) {
		return mserv.choosePaymentmethod(seat, buttonid);
		
	} 
	

	@PostMapping(path ="/ConfirmedSeat/{showId}")
	public List<Seat> SelectSeat(@PathVariable("showId") Integer showId,@RequestBody SelectedSeatArray seatLocation) {
		// TODO Auto-generated method stub
		return mserv.SelectSeat(showId, seatLocation);
	}

	// tasted on postman 
	@PutMapping(path ="/updateSeatstatus")
	public Booking UpdateSeatStatus(@RequestBody Booking BookingObj) {
		// TODO Auto-generated method stub
		return mserv.UpdateSeatStatus(BookingObj);
	}

	//tested on postman
	@PutMapping(path="/selectSeat")
	public Seat blockUnblock(@RequestBody Seat markseat) {
		// TODO Auto-generated method stub
		return mserv.blockUnblock(markseat);
	}

	//tested on postmanstatus
	@PutMapping(path="/CancelPayment")
	public Booking unblockSeat(@RequestBody Booking Bookingobj) {
		// TODO Auto-generated method stub
		return mserv.unblockSeat(Bookingobj);
	}

	@GetMapping(path="/cancelBooking")
	public Booking cancelBooking(Booking cancelBooking) {
		// TODO Auto-generated method stub
		return mserv.cancelBooking(cancelBooking);
	}
	
	
	
	
}
