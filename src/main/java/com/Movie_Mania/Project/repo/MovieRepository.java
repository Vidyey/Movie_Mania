package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Movie;


public interface MovieRepository  extends JpaRepository<Movie, Integer> {

}
