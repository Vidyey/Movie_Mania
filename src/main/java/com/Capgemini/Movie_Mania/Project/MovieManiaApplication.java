package com.Capgemini.Movie_Mania.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
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
	private TicketRepository ticketrepo;
	@Autowired
	private BookingRepository brepo;

	

	
	@Autowired
	BookingRepository bookrepo;





	public static void main(String[] args) {
		
		SpringApplication.run(MovieManiaApplication.class, args);
		System.out.println("lets start");
	}

	@Override
	public void run(String... args) throws Exception {
//
//		Theater t2 = new Theater(101,"INOX", "Pune", "Akshay", "9875566776");
//		Theater t1 = new Theater(102,"PVR", "Pune", "Danny", "9075566776");
//		
//		trepo.save(t1);
//		trepo.save(t2);
//		String[] language = {"Hindi","English"};
//
//		Movie m1=new Movie(1,"3 Idiots","Entertainment","Raju Hirani",170,language,LocalDate.of(2010, 01, 12));
//		
//		Movie m2=new Movie(2,"Tanhaji","Period","Om Raut",130,language,LocalDate.of(2020, 01, 12));
//		
//		
//		t1.addMovie(m1);
//		t1.addMovie(m2);
//		t2.addMovie(m1);
//		t2.addMovie(m2);
//		trepo.save(t1);
//		trepo.save(t2);
//		
//		Customer customer = new Customer("mahesh@gmail.com", "mahesh123","pet name", "maddy", "Mahesh", "21-09-1998", "8765677766");
//		
//		String[] seatsname = {"B1","B2","B3"};
//		String[] seatsname1 = {"C7","C8"};
//		customer.addTicket(new Ticket(125,3,seatsname,false,"Audi4"));
//		customer.addTicket(new Ticket(126,2,seatsname1,true,"Audi1"));
//		custRepo.save(customer);

	
//		String[] stringArray = {"t","s"};
//		
//		Movie m1=new Movie(1, "Ragnarok", "", "", 50, stringArray, LocalDate.now());
//		
//		Movie m2=new Movie(2, "Orphan", "", "", 60, stringArray, LocalDate.now());
//			
//		List<Movie> movielist1 =new ArrayList<Movie>();
//		movielist1.add(m1);
		
//		long milli = 123456789999l;
//		java.sql.Time time = new java.sql.Time(milli);
//	
//		Show s3 = new Show(100,time, time, null, "Alpha", m1, 11, 101);     //Theatre 1 Screen 1 show 1
//		Show s2 = new Show(200,time, time, null, "Alpha", m1, 12, 101);
//		List<Show> showlist1=new ArrayList<Show>();
//		showlist1.add(s3);
//		showlist1.add(s2);
		
//		int array[]= {1,2};
//		Seat seat1 = new Seat(1,100.0,null,null,array);
//		List<Seat> seatList = new ArrayList<Seat>();
//				seatList.add(seat1);
//			Ticket tk = new Ticket(1, 2, null , true, "maheshscreen");
//				ticketrepo.save(tk);
//				Ticket tk2 = ticketrepo.getOne(1);
//		Booking bk = new Booking(111, 222, 333, null, null, 555, 180.0, seatList, tk);
//				brepo.save(bk);
//		Theater t1 = new Theater(101, "PVR", "Pune", movielist1, null, "", "");
//		trepo.save(t1);
		
//		---------------------------------------
		

//

//		Theater t2 = new Theater(102, "INOX", "Pune", "Akshay", "9875566776");
//		Theater t1 = new Theater(101, "PVR", "Pune", "Danny", "9075566776");
//		String[] language = {"Hindi","English"};
//

//		Movie m1=new Movie(3,"3 Idiots","Entertainment","Raju Hirani",170,language,LocalDate.of(2010, 01, 12));		
//		Movie m2=new Movie(4,"Tanhaji","Period","Om Raut",130,language,LocalDate.of(2020, 01, 12));

//		Movie m1=new Movie(3,"3 Idiots","Entertainment","Raju Hirani",170,language,LocalDate.of(2010, 01, 12));
//		
//		Movie m2=new Movie(4,"Tanhaji","Period","Om Raut",130,language,LocalDate.of(2020, 01, 12));
//		
//		

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

		
//		
//Show s1 = new Show(null,"12pm","3am", null, "Alpha", null, 501, 101);

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
	
//	Show s1 = new Show(null,"12pm","3am", null, "Alpha", null, 501, 101);
//	
//	//Show s2 = new Show(showId, showStartTime, showEndTime, seats, showName, movieName, screenId, theaterId);
//
//		srepo.save(s1);
//		Show showone = srepo.getOne(1);
//		
//		  List<Seat> seatlist = new ArrayList<Seat>(); 
//		  for (int i = 0; i < 5; i++) 
//		  { 
//			  for(int j = 0; j < 10; j++) 
//			  { 
//				  Seat seat = new Seat(); 
//				  int[] seatLocation ={i,j};
//				  seat.setSeatLocation(seatLocation); 
//				  seat.setShow(showone);
//				  
//				  seat.setSeatPrice(108.0);
//				  seatlist.add(seat);
//				  seatrepo.save(seat);
//				  System.out.println(seat);
//			  } 
//		}
//		 for (Seat seat : seatlist) {
//			System.out.println(seat);
//		}
//		  
//		 s1.setSeats(seatlist);
//		 srepo.save(s1);
//
//		  
		
		// select seat -----------------------------------------------------------------------------
		
		
		
	
	//-------------------------update seat status---------------------------------------------------------------
		
	//	Booking bk = new Booking(111, 222, 333, s1, null, 555, 180.0, seatList, tk);
//		//Booking bk2 = new Booking(bookingId, movieId, showId, showRef, bookingDate, transactionId, totalCost, seatList, ticket)
		


		
		
	}

}
