package com.Movie_Mania.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Theater;

@Repository
public interface TheatreRepo extends JpaRepository<Theater, Integer>{

	
	public List<Theater> findByTheaterName(String theatreName);
}
