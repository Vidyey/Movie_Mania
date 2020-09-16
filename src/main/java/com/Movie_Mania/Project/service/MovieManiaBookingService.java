package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Movie_Mania.Project.Dao.IMovieManiaDao;
import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Seat;


public class MovieManiaBookingService implements IMovieManiaBookingService{
	 
	@Autowired
	IMovieManiaDao mmd;
	
	@Override
	public double calculateTotalCost(Booking b) {
		return mmd.calculateTotalCost(b);
		
	}

	@Override
	public boolean makePayment(Booking b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelSeats(List<Seat> seatList) {
		// TODO Auto-generated method stub
		return false;
	}

}
