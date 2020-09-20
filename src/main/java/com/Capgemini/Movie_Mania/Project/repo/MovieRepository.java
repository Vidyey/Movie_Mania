package com.Movie_Mania.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Movie;


public interface MovieRepository  extends JpaRepository<Movie, Integer> {
	
	public List<Movie> findByMovieName(String movieName);

}
