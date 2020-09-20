package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking ,Integer>{

	

}
