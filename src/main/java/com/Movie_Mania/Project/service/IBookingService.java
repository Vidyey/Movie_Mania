package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Ticket;

@Service
public interface IBookingService {

	List<Ticket> showTickets(int customerId);
	Boolean cancelSeat();
	
	Ticket bookSeat();
	
	Boolean bloackSeat();
}
