package com.Movie_Mania.Project.Dao;

import java.util.List;

import com.Movie_Mania.Project.entity.Ticket;

public interface IBookingDao {

	List<Ticket> showTickets(int customerId);
	
	Boolean cancelSeat();
	
	Ticket bookSeat();
	
	Boolean bloackSeat();
}
