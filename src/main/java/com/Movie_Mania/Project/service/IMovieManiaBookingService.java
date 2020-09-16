package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Seat;

@Service
public interface IMovieManiaBookingService {
	
	public  double calculateTotalCost(Booking b);
	public boolean makePayment(Booking b);
	public boolean cancelSeats(List<Seat> seatList);
}
