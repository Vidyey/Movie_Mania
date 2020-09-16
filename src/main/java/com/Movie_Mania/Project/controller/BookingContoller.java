package com.Movie_Mania.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.service.IBookingService;

@RestController
@CrossOrigin("*")
public class BookingContoller {

	@Autowired
	private IBookingService bookService;
	
	@GetMapping("/hello")
	public ResponseEntity<Object> checkWorking(){
		return new ResponseEntity<Object>("Hello Customer..", HttpStatus.OK);
	}
	
	@GetMapping("myTickets/{customerId}")
	public ResponseEntity<List<Ticket>> showMyTickets(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<List<Ticket>>(bookService.showTickets(customerId), HttpStatus.OK);
	}
	
	@GetMapping("bookSeat")
	public ResponseEntity<Ticket> bookSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Ticket>(bookService.bookSeat(), HttpStatus.OK);
	}
	
	@GetMapping("cancelSeat")
	public ResponseEntity<Boolean> cancelSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Boolean>(bookService.cancelSeat(), HttpStatus.OK);
	}
	
	@GetMapping("blockSeat")
	public ResponseEntity<Boolean> blockSeat(@PathVariable("customerId") int customerId ){
		return new ResponseEntity<Boolean>(bookService.bloackSeat(), HttpStatus.OK);
	}
}
