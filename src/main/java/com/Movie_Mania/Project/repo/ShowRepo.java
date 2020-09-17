package com.Movie_Mania.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Show;

@Repository
public interface ShowRepo  extends JpaRepository<Show, Integer>{
	
	public List<Show> findByShowName(String showName);

}
