package com.Capgemini.Movie_Mania.Project.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.SelectedSeatArray;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.service.MovieService;
import com.Capgemini.Movie_Mania.Project.service.MovieServiceImpl;

@RestController
@RequestMapping("/movie")

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
	public List<Show> searchShow(@PathVariable("showName") String showName)
	{
	return mserv.searchShow(showName);

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

	@GetMapping("/myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") int customerId ){
	return new ResponseEntity<List<Ticket>>(mserv.showTickets(customerId), HttpStatus.OK);
	}

	@GetMapping("/bookSeat")
	public ResponseEntity<Ticket> bookSeat(@PathVariable("customerId") int customerId ){
	return new ResponseEntity<Ticket>(mserv.bookSeat(), HttpStatus.OK);
	}

	@GetMapping("/cancelSeat")
	public ResponseEntity<Boolean> cancelSeat(@PathVariable("customerId") int customerId ){
	return new ResponseEntity<Boolean>(mserv.cancelSeat(), HttpStatus.OK);
	}

	@GetMapping("/blockSeat")
	public ResponseEntity<Boolean> blockSeat(@PathVariable("customerId") int customerId ){
	return new ResponseEntity<Boolean>(mserv.bloackSeat(), HttpStatus.OK);
	}
	 
	@PostMapping(value ="/regCust")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return mserv.registerCustomer(customer);
	}
	
	@PostMapping(value ="/regAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return mserv.registerAdmin(admin);
	}
	
	@PostMapping("/cancelticket")
	public ResponseEntity<Booking> cancelticket(@RequestBody Ticket ticket){
	return new ResponseEntity<Booking>(mserv.cancelticket(ticket),HttpStatus.OK);
		
	}
	
	@GetMapping("/makePayment/{BookingId}")
	public ResponseEntity<Booking> makePayment(@PathVariable("BookingId") int BookingId){
		
		System.out.print("controller:- ");
		System.out.println(BookingId);
	return new ResponseEntity<Booking>(mserv.makePayment(BookingId),HttpStatus.OK);
	}	
	
	@PutMapping("/calculateTotalCost")
	public ResponseEntity<Double> calculateTotalCost(@RequestBody List<Seat> seat){
    return new ResponseEntity<Double>(mserv.calculateTotalCost(seat), HttpStatus.OK);
	}
	@PutMapping(value="/choosePaymentmethod/{showId}/{buttonid}")
	public Booking choosePaymentmethod(@PathVariable("showId") Integer showId,@RequestBody SelectedSeatArray seatLocation, @PathVariable("buttonid") int buttonid) {
		return mserv.choosePaymentmethod(showId, seatLocation, buttonid);
		
	} 
	
	
	//Pratik module 

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
	@GetMapping(path="/selectSeat/{seat_id}")
	public Seat blockUnblock(@PathVariable("seat_id") Integer seat_id) {
		// TODO Auto-generated method stub
		return mserv.blockUnblock(seat_id);
	}

	//tested on postman status
	@PutMapping(path="/CancelPayment/{BookingId}")
	public Booking unblockSeat(@PathVariable("BookingId") int BookingId) {
		// TODO Auto-generated method stub
		return mserv.unblockSeat(BookingId);
	}

	@GetMapping(path="/cancelBooking/{BookingId}")
	public Booking cancelBooking(@PathVariable("BookingId") int BookingId) {
		// TODO Auto-generated method stub
		return mserv.cancelBooking(BookingId);
	}
	
	
}
