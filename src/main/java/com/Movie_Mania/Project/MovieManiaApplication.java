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

import com.Movie_Mania.Project.entity.Customer;
import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Screen;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;
import com.Movie_Mania.Project.repo.CustomerRepository;
import com.Movie_Mania.Project.repo.MovieRepository;
import com.Movie_Mania.Project.repo.ScreenRepo;
import com.Movie_Mania.Project.repo.ShowRepo;
import com.Movie_Mania.Project.repo.TheatreRepo;

@EnableJpaRepositories(basePackages = "com.Movie_Mania.Project.repo")
@SpringBootApplication

public class MovieManiaApplication implements CommandLineRunner {

	@Autowired
	private ScreenRepo screpo;

	@Autowired
	private MovieRepository mrepo;

	@Autowired
	CustomerRepository custRepo;
	
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

//		Theater t2 = new Theater(102, "INOX", "Pune", "Akshay", "9875566776");
//		Theater t1 = new Theater(101, "PVR", "Pune", "Danny", "9075566776");
//		String[] language = {"Hindi","English"};
//
//		Movie m1=new Movie(3,"3 Idiots","Entertainment","Raju Hirani",170,language,LocalDate.of(2010, 01, 12));
//		
//		Movie m2=new Movie(4,"Tanhaji","Period","Om Raut",130,language,LocalDate.of(2020, 01, 12));
//		
//		
//		t1.addMovie(m1);
//		t1.addMovie(m2);
//		trepo.save(t1);
//		trepo.save(t2);
//		
//		Customer customer = new Customer(1011, "pratik123","pet name", "tom", "Pratik", "21-09-1998", "8765677766");
//		
//		String[] seatsname = {"A1","A2"};
//		customer.addTicket(new Ticket(121,3,seatsname,true,"Audi3"));
//		
//		custRepo.save(customer);
//		
//		
//		
//		
//		
//		
//		
//		
//		List<Movie> movielist1 =new ArrayList<Movie>();
//		movielist1.add(m1);
//		movielist1.add(m2);
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
