package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.Dao.IBookingDao;
import com.Movie_Mania.Project.entity.Ticket;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao bookDao;
	
	@Override
	public List<Ticket> showTickets(int customerId) {
		return bookDao.showTickets(customerId);
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
