package com.Capgemini.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.Movie_Mania.Project.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

}