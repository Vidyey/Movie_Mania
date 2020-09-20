package com.Capgemini.Movie_Mania.Project;

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

import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.BookingRepository;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepo;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.Seatrepo;
import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;
import com.Capgemini.Movie_Mania.Project.repo.TicketRepository;

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
	
	@Autowired
	Seatrepo seatrepo;
	
	@Autowired
	private TicketRepository ticketrepo;
	@Autowired
	private BookingRepository brepo;

	public static void main(String[] args) {
		
		SpringApplication.run(MovieManiaApplication.class, args);
		System.out.println("lets start");
		System.out.println("yash");
		System.out.println("Pratik");
		
	}

	@Override
	public void run(String... args) throws Exception {

		String[] stringArray = {"t","s"};
		
		Movie m1=new Movie(1, "Ragnarok", "", "", 50, stringArray, LocalDate.now());
		
		Movie m2=new Movie(2, "Orphan", "", "", 60, stringArray, LocalDate.now());
			
		List<Movie> movielist1 =new ArrayList<Movie>();
		movielist1.add(m1);
		
//		long milli = 123456789999l;
//		java.sql.Time time = new java.sql.Time(milli);
//	
//		Show s3 = new Show(100,time, time, null, "Alpha", m1, 11, 101);     //Theatre 1 Screen 1 show 1
//		Show s2 = new Show(200,time, time, null, "Alpha", m1, 12, 101);
//		List<Show> showlist1=new ArrayList<Show>();
//		showlist1.add(s3);
//		showlist1.add(s2);
		
		int array[]= {1,2};
		Seat seat1 = new Seat(1,100.0,null,null,array);
		List<Seat> seatList = new ArrayList<Seat>();
				seatList.add(seat1);
			Ticket tk = new Ticket(1, 2, null , true, "maheshscreen");
				ticketrepo.save(tk);
				Ticket tk2 = ticketrepo.getOne(1);
		Booking bk = new Booking(111, 222, 333, null, null, 555, 180.0, seatList, tk);
				brepo.save(bk);
		Theater t1 = new Theater(101, "PVR", "Pune", movielist1, null, "", "");
		trepo.save(t1);
		
//		---------------------------------------
		
//		Theater t2 = new Theater(102, "INOX", "Pune", "Akshay", "9875566776");
//		Theater t1 = new Theater(101, "PVR", "Pune", "Danny", "9075566776");
//		String[] language = {"Hindi","English"};
//
//		Movie m1=new Movie(3,"3 Idiots","Entertainment","Raju Hirani",170,language,LocalDate.of(2010, 01, 12));		
//		Movie m2=new Movie(4,"Tanhaji","Period","Om Raut",130,language,LocalDate.of(2020, 01, 12));
//		t1.addMovie(m1);
//		t1.addMovie(m2);
//		trepo.save(t1);
//		trepo.save(t2);
//		Customer customer = new Customer(1011, "pratik123","pet name", "tom", "Pratik", "21-09-1998", "8765677766");
//		String[] seatsname = {"A1","A2"};
//		customer.addTicket(new Ticket(121,3,seatsname,true,"Audi3"));
//		custRepo.save(customer);	
//		List<Movie> movielist1 =new ArrayList<Movie>();
//		movielist1.add(m1);
//		movielist1.add(m2);
//		Theater t1 = new Theater(101, "PVR", "Pune", movielist1, null, "", "");
//		trepo.save(t1);
//		Screen screen=screpo.getOne(11);
//		screen.addShow(s3);
//		screen.addShow(s2);
//		screpo.getOne(11).addShow(s3);
//	screpo.save(screen);
//	Screen s1=new Screen(11,101,"Audi1",showlist1,null);
//		List<Screen> screenlist1 = new ArrayList<Screen>();
//		screenlist1.add(sc1);

		
		
Show s1 = new Show(null,"12pm","3am", null, "Alpha", null, 501, 101);
		
		
		srepo.save(s1);
		
		  List<Seat> seatlist = new ArrayList<Seat>(); 
		  for (int i = 0; i < 5; i++) 
		  { 
			  for(int j = 0; j < 10; j++) 
			  { 
				  Seat seat = new Seat(); 
				  int[] seatLocation ={i,j};
				  seat.setSeatLocation(seatLocation); 
				  seat.setShow(s1);
				  seatrepo.save(seat);
				  System.out.println(seat);
		  
		  seatlist.add(seat);
		  
		  } }
		 for (Seat seat : seatlist) {
			System.out.println(seat);
		}
		  
		 s1.setSeats(seatlist);
		 srepo.save(s1);
		
			
	}

}
