package com.Movie_Mania.Project.Dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.repo.BookingRepository;
import com.Movie_Mania.Project.repo.CustomerRepository;
import com.Movie_Mania.Project.repo.ShowRepository;
import com.Movie_Mania.Project.repo.TicketRepository;

@Repository
public class BookingDaoImpl implements IBookingDao {

	@Autowired
	CustomerRepository custRepository;
	
	@Autowired
	BookingRepository bookRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	private Customer customer;
	
	@Override
	public List<Ticket> showTickets(int customerId) {
		
		customer = new Customer(customerId, "abcd123", "Dhiraj p", Calendar.getInstance().getTime(), "9876556789");
		
		String[] name = {"B1","B2"};
		Ticket ticket = new Ticket(204, 2,name , true, "Audi3");
		
		customer.addTicket(ticket);
		
		custRepository.save(customer);
		
		return custRepository.getOne(customerId).getMyTickets();
	}

	@Override
	public Boolean cancelSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket bookSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean bloackSeat() {
		// TODO Auto-generated method stub
		return null;
	}

}
