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

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Movie_Mania.Project.repo")

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
		
	}

	@Override
	public void run(String... args) throws Exception {

	/*	
		
		String[] stringArray = {"t","s"};
		
		Movie m1=new Movie(1, 1, "Ragnarok", "", "", 50, stringArray, LocalDate.now());
		
		
		Movie m2=new Movie(2, 2, "Orphan", "", "", 60, stringArray, LocalDate.now());
		mrepo.save(m1);
		mrepo.save(m2);
		
		
		List<Movie> movielist1 =new ArrayList<Movie>();
		movielist1.add(m1);
		
		List<Movie> movielist2 =new ArrayList<Movie>();
		movielist2.add(m2);
		
		
		
	
		long milli = 123456789999l;
		java.sql.Time time = new java.sql.Time(milli);
		
		Show s1 = new Show(201,time, time, null, "Alpha", m1, 501, 101);     //Theatre 1 Screen 1 show 1
		Show s2 = new Show(202,time, time, null, "Beta", m2, 502, 101);      //Theatre 1 Screen 2 show 1
		Show s3 = new Show(203,time, time, null, "Gamma", m1, 503, 102);     //Theatre 2 Screen 1 show 1
		Show s4 = new Show(204,time, time, null, "Theta", m2, 504, 102);     //Theatre 2 Screen 2 show 1
			
		
		 srepo.save(s1);  srepo.save(s2);  srepo.save(s3);  srepo.save(s4);
		 		
		List<Show> showlist1=new ArrayList<Show>();
		showlist1.add(s1);
	
		List<Show> showlist2=new ArrayList<Show>();
		showlist2.add(s2);
		
		List<Show> showlist3=new ArrayList<Show>();
		showlist3.add(s3);
	
		List<Show> showlist4=new ArrayList<Show>();
		showlist4.add(s4);
				
		
	
		Screen sc1=new Screen(501, 101, "A", null, LocalDate.now(),10 , 20);
		
		Screen sc2=new Screen(502,101,"B", null,LocalDate.now(),20,30);
		
		Screen sc3=new Screen(503, 102, "C", null, LocalDate.now(),10 , 20);
		
		Screen sc4=new Screen(504,102,"D", null,LocalDate.now(),20,30);
		
		screpo.save(sc1);
		screpo.save(sc2);
		screpo.save(sc3);
		screpo.save(sc4);
		
		List<Screen> screenlist1 = new ArrayList<Screen>();
		screenlist1.add(sc1);
		screenlist1.add(sc2);
		
		List<Screen> screenlist2 = new ArrayList<Screen>();
		screenlist2.add(sc3);
		screenlist2.add(sc4);
		
		
		
		
	
		
		
		Theater t1 = new Theater(101, "PVR", "Pune", null, null, "", "");
		
		Theater t2 = new Theater(102, "INOX", "Pune", null, null, "", "");
		
		trepo.save(t1);
		trepo.save(t2);
		
		*/
	}

}
