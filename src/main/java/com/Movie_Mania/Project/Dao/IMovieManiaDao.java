package com.Movie_Mania.Project.Dao;

import java.util.List;

import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Seat;

public interface IMovieManiaDao {

	public  double calculateTotalCost(Booking b);
	public boolean makePayment(Booking b);
	public boolean cancelSeats(List<Seat> seatList);
}
