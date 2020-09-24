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

		
		
	}

}
