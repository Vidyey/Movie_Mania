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
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.BookingRepository;
import com.Capgemini.Movie_Mania.Project.repo.CustomerRepository;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepository;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.SeatRepo;
import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;
import com.Capgemini.Movie_Mania.Project.repo.TicketRepository;

@EnableJpaRepositories(basePackages = "com.Capgemini.Movie_Mania.Project.repo")
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
	
	@Autowired
	SeatRepo seatrepo;
	
	@Autowired
	TicketRepository ticketrepo;
	
	@Autowired
	BookingRepository bookrepo;

	public static void main(String[] args) {
		
		SpringApplication.run(MovieManiaApplication.class, args);
		System.out.println("lets start");
	}

	@Override
	public void run(String... args) throws Exception {
//
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
		
		
//		fix data :----------------------------------------------------------
		
		
//	-------------------cancel payment	
//		List<Seat> seatList = new ArrayList<Seat>();
//				seatList.add(seatrepo.getOne(3).);
//				seatList.add(seatrepo.getOne(4));
//				
////				Ticket tk = new Ticket(1, 2, null , false, "maheshscreen");
////				
////				ticketrepo.save(tk);
//				
//				
//				Ticket tk = ticketrepo.getOne(1);
//		
//		bookrepo.save(bk);
//		
		
		
	// update seat status ------------------------
		
//		Seat s1 = seatrepo.getOne(3);
//		s1.setSeatStatus("Blocked");
//		seatrepo.save(s1);
//		Seat s2 = seatrepo.getOne(4);
//		s2.setSeatStatus("Blocked");
//		seatrepo.save(s2);
//		List<Seat> seatList = new ArrayList<Seat>();
//		seatList.add(s1);
//		seatList.add(s2);
//		
//		Booking bk3 = bookrepo.getOne(5);
//		bk3.setSeatList(seatList);
//		bookrepo.save(bk3);

//					//	{
//						    "bookingId": 5,
//						    "movieId": 222,
//						    "showId": 333,
//						    "showRef": null,
//						    "bookingDate": null,
//						    "transactionId": 555,
//						    "totalCost": 180.0,
//						    "seatList": [
//						        {
//						            "seatId": 3,
//						            "seatStatus": "Blocked",
//						            "seatPrice": 90,
//						            "booking": null,
//						            "show": null,
//						            "seatLocation": [
//						                1,
//						                2
//						            ]
//						        },
//						        {
//						            "seatId": 4,
//						            "seatStatus": "Blocked",
//						            "seatPrice": 90,
//						            "booking": null,
//						            "show": null,
//						            "seatLocation": [
//						                3,
//						                2
//						            ]
//						        }
//						    ],
//						    "ticket": {
//						        "ticketId": 1,
//						        "noOfSeats": 2,
//						        "seatName": null,
//						        "ticketStatus": false,
//						        "screenName": "maheshscreen"
//						    }
//						}
//		
//		
		
		
		// select seat 
		
		
		
		
		
		
		
		
		
		
		
		// ----------------- Showw creation + choosedSeats function 
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
		  
		
		// select seat -----------------------------------------------------------------------------
		
		
		
	
	//-------------------------update seat status---------------------------------------------------------------
		
	//	Booking bk = new Booking(111, 222, 333, s1, null, 555, 180.0, seatList, tk);
//		//Booking bk2 = new Booking(bookingId, movieId, showId, showRef, bookingDate, transactionId, totalCost, seatList, ticket)
		


		
		
		
		
	}

}
