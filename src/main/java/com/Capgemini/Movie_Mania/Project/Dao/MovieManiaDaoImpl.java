package com.Movie_Mania.Project.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Booking;
import com.Movie_Mania.Project.entity.Seat;
import com.Movie_Mania.Project.repo.BookingRepository;
@Repository
public class MovieManiaDaoImpl implements IMovieManiaDao{

	@Autowired
	BookingRepository br;
	
	Booking b;
	double sum=0;
	@Override
	public double calculateTotalCost(Booking b) {
		// TODO Auto-generated method stub
		List<Seat> seat=b.getSeatList();
		
		for(int i=0; i<seat.size();i++) {
			sum=sum+seat.get(i).getSeatPrice();
		}
			b.setTotalCost(sum);
			br.save(b);
			return sum;
	}

	@Override
	public boolean makePayment(Booking b) {
		
		
		return false;
	}

	@Override
	public boolean cancelSeats(List<Seat> seatList) {
		// TODO Auto-generated method stub
		return false;
	}

}
