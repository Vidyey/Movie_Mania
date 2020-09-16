package com.Movie_Mania.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.repo.MovieRepo;
import com.Movie_Mania.Project.repo.ScreenRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepo mrepo;
	
	@Autowired
	TheatreRepo trepo;
	
	@Autowired
	ShowRepo srepo;
	
	@Autowired
	ScreenRepo screpo;
	
	@Override
	public List<Movie> searchMovie(String movieName) {

		return mrepo.findByMovieName(movieName);
	}

	@Override
	public List<Theater> searchTheatre(String theatreName) {
		// TODO Auto-generated method stub
		return trepo.findByTheaterName(theatreName);
	}
	
	@Override
	public List<Show> searchShow(String showName) {
		return srepo.findByShowName(showName);
	}

	@Override
	public List<Show> showShows(Integer screenId) {
		Screen screen=screpo.getOne(screenId) ;
		return screen.getShowList();
	}

}
