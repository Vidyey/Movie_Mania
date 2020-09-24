package com.movie_mania.project.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.service.MovieService;
@RunWith(SpringRunner.class)
@SpringBootTest
class AdminTesting {
	@Autowired
	private MovieService movieService;
	
	

//	@Test
//	@Rollback(true)
//	public void addMovieTest()
//	{
////		String message=movieService.addMovie(new Movie(111,"Sultan","Action","xyz",5,["Hindi"],"2014-03-13"));
//		String expectedMessage="Movie added Sucessfully";
////		assertEquals(message, expectedMessage);
//	}
	
	@Test
	@Rollback(true)
 public void Test1()
 {
		Movie movie=new Movie();
		int movieId=111;
		        
         movie.setMovieId(movieId);
	    assertEquals(movie.getMovieId(), movieId);
	
	 
 }
	
	@Test
	@Rollback(true)
	public void Test2()
	{
		Movie movie=new Movie();
		String movieDirector="RajKumar Hirani";
		movie.setMovieDirector(movieDirector);
		assertEquals(movie.getMovieDirector(),movieDirector );
	}
	
	@Test
	@Rollback(true)
	public void Test3()
	{
		Theater theater=new Theater();
		String City="Pune";
		//movie.setMovieDirector(movieDirector);
		theater.setTheaterCity(City);
		assertEquals(theater.getTheaterCity(), City);
	}
	
	
	@Test
	@Rollback(true)
	public void Test4()
	{
		Theater theater=new Theater();
		String theaterName="PVR";
		//movie.setMovieDirector(movieDirector);
		theater.setTheaterName(theaterName);
		assertEquals(theater.getTheaterName(), theaterName);
	}
	
}
