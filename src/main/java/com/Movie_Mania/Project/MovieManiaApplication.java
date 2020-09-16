package com.Movie_Mania.Project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.repo.MovieRepo;
import com.Movie_Mania.Project.repo.ScreenRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;

@EnableJpaRepositories(basePackages = "com.Movie_Mania.Project.repo")
@SpringBootApplication

public class MovieManiaApplication implements CommandLineRunner {

	@Autowired
	private ScreenRepo screpo;

	@Autowired
	private MovieRepo mrepo;

	@Autowired
	private TheatreRepo trepo;

	@Autowired
	private ShowRepo srepo;

	public static void main(String[] args) {
		
		SpringApplication.run(MovieManiaApplication.class, args);
		System.out.println("lets start");
		System.out.println("yash");
		System.out.println("Pratik");
		
	}

	@Override
	public void run(String... args) throws Exception {

		
		
//		String[] stringArray = {"t","s"};
//		
//		Movie m1=new Movie(1, "Ragnarok", "", "", 50, stringArray, LocalDate.now());
//		
//		
//		Movie m2=new Movie(2, "Orphan", "", "", 60, stringArray, LocalDate.now());
//		
//		
//		
//		List<Movie> movielist1 =new ArrayList<Movie>();
//		movielist1.add(m1);
//	
//		
//		
//		
//		
//		
//		
//		
//		Theater t1 = new Theater(101, "PVR", "Pune", movielist1, null, "", "");
//		
//		
//		trepo.save(t1);
//		
//		
//		
//	
//		long milli = 123456789999l;
//		java.sql.Time time = new java.sql.Time(milli);
//		
//		Show s1 = new Show(null,time, time, null, "Alpha", m1, 501, 101);     //Theatre 1 Screen 1 show 1
//		Show s2 = new Show(null,time, time, null, "Alpha", m1, 501, 101);
//		
//		 
//		 		
//		List<Show> showlist1=new ArrayList<Show>();
//		showlist1.add(s1);
//	
//		
//		
//	
//		Screen sc1=new Screen(501, 101, "A", showlist1, LocalDate.now(),10 , 20);
//		
//		
//		
//		
//		
//		List<Screen> screenlist1 = new ArrayList<Screen>();
//		screenlist1.add(sc1);
//		

		
	}

}
