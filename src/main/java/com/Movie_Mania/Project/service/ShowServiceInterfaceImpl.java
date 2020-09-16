package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Seat;
import com.Movie_Mania.Project.repo.AdminRepository;
import com.Movie_Mania.Project.repo.CustomerRepository;
import com.Movie_Mania.Project.repo.ShowRepository;
@Service
public class ShowServiceInterfaceImpl implements ShowServiceInterface {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ShowRepository showRepository;

	public boolean updateSeatsStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<Seat> chooseSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean intiateBooking() {
		// TODO Auto-generated method stub
		return false;
	}

}
