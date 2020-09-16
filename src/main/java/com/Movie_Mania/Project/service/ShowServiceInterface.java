package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Seat;

@Service
public interface ShowServiceInterface {
	public boolean updateSeatsStatus();
	public List<Seat> chooseSeats();
	public boolean intiateBooking();

}
