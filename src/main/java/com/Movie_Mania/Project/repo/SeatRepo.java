package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Movie_Mania.Project.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

}
