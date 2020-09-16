package com.Movie_Mania.Project.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{


	public List<Movie> findByMovieName(String movieName);
}
