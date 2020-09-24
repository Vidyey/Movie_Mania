package com.Capgemini.Movie_Mania.Project.Dao;



import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Loader;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Capgemini.Movie_Mania.Project.entity.Admin;
import com.Capgemini.Movie_Mania.Project.entity.Booking;
import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.entity.Movie;
import com.Capgemini.Movie_Mania.Project.entity.Screen;
import com.Capgemini.Movie_Mania.Project.entity.Seat;
import com.Capgemini.Movie_Mania.Project.entity.SelectedSeatArray;
import com.Capgemini.Movie_Mania.Project.entity.Show;
import com.Capgemini.Movie_Mania.Project.entity.Theater;
import com.Capgemini.Movie_Mania.Project.entity.Ticket;
import com.Capgemini.Movie_Mania.Project.repo.AdminRepository;
import com.Capgemini.Movie_Mania.Project.repo.BookingRepository;
import com.Capgemini.Movie_Mania.Project.repo.CustomerRepository;
import com.Capgemini.Movie_Mania.Project.repo.MovieRepository;
import com.Capgemini.Movie_Mania.Project.repo.ScreenRepo;
import com.Capgemini.Movie_Mania.Project.repo.SeatRepo;

import com.Capgemini.Movie_Mania.Project.repo.ShowRepo;
import com.Capgemini.Movie_Mania.Project.repo.TheatreRepo;
import com.Capgemini.Movie_Mania.Project.repo.TicketRepository;

@Repository
public class MovieDaoImpl implements IMovieDao {



	

//	private Logger logger = Logger.getRootLogger();

	

	@Autowired
	CustomerRepository custRepository;
	

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	BookingRepository bookRepository;
	
	@Autowired
	ShowRepo showRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired

	 MovieRepository repo;
	
	@Autowired
	TheatreRepo theatreRepo; 

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	ScreenRepo screenRepo;
	

	@Autowired
	ShowRepo showRepo;
	
	@Autowired
	SeatRepo seatrepo;
	
	
//	private Theater theaterobj ;

	@Autowired 
	TheatreRepo trepo;
	
	private Customer customer;
	
	
	
	//Dhiraj Modules
	

	/*
	 * Register a customer 
	 * If customer already exists then it will not be registered again.
	 * If doesn't exist will be registered
	 */

	@Override
	public String registerCustomer(Customer customer) {
		
			if(custRepository.existsById(customer.getUsername())) 
			{
//				Loader.error("Customer Already Exists.");
				return "Customer Already Exists.Try login or forgot password";
			}
			else {
				custRepository.save(customer);
//				logger.info(customer.getCustomerName()+" is registered successfully!..");
				return customer.getCustomerName()+" is registered successfully!..";
			}
		
	}

	/*
	 * Register a Admin 
	 * If admin already exists then it will not be registered again.
	 * If doesn't exist will be registered
	 */
	@Override
	public String registerAdmin(Admin admin) {
		if(adminRepo.existsById(admin.getUsername())) 
		{
//			logger.error("Admin Already Exists.");
			return "Admin Already Exists.Try login or forgot password";
		}
		else {
			adminRepo.save(admin);
//			logger.info(admin.getAdminName()+" is registered successfully!..");
			return admin.getAdminName()+" is registered successfully!..";
		}
	}

	/*
	 * Customer Login 
	 * If login credentials are correct it will return true.
	 * else return false
	 */
	@Override
	public boolean custLogin(String username, String password) {
		
		if(custRepository.existsById(username)) {
			customer = custRepository.getOne(username);
			if(customer.getPassword().equals(password)) {
//				logger.info("Login successfull");
				return true;
				
			}
			else 
				{
//				logger.error("Incorrect password");
					return false;
				}
		}
		else {
//			logger.error("Customer doesnt exist");
			return false;
		}
	}

	/*
	 * Admin Login 
	 * If login credentials are correct it will return true.
	 * else return false
	 */
	@Override
	public boolean adminLogin(String username, String password) {
		
		if(adminRepo.existsById(username)) {
			Admin admin = adminRepo.getOne(username);
			if(admin.getPassword().equals(password))
			 {
//				logger.info("Login successfull");
				return true;
				
			}
			else{
//				logger.error("Incorrect password");
				return false;
			}
		}
		else
		{
//			logger.error("Admin doesnt exist");
			return false;
		}
	}
	
	/*
	 * Change Password
	 * The current password should be correct
	 * New password can't be Same as Current
	 */
	@Override
	public String changePassword(String username, String currentPassword, String newPassword) {
		customer = custRepository.getOne(username);
		if(customer.getPassword().equals(currentPassword)) 
		{
			if(currentPassword.equals(newPassword)) {
//				logger.error("New password can't be Same as Current");
				return "New password can't be Same as Current";
			}
			customer.setPassword(newPassword);
			custRepository.save(customer);
//			logger.info("Password changed successfully");
			return "Password changed successfully";
		}
		else 
		{
//			logger.error("Current Password is incorrect");
			return "Current Password is incorrect";
		}
	}
	
	@Override
	public String changePasswordAdmin(String username, String currentPassword, String newPassword) {
		Admin admin = adminRepo.getOne(username);
		if(admin.getPassword().equals(currentPassword)) 
		{
			if(currentPassword.equals(newPassword)) {
//				logger.error("New password can't be Same as Current");
				return "New password can't be Same as Current";
			}
			admin.setPassword(newPassword);
			adminRepo.save(admin);
//			logger.info("Password changed successfully");
			return "Password changed successfully";
		}
		else 
		{
//			logger.error("Current Password is incorrect");
			return "Current Password is incorrect";
		}
	}

	/*
	 * Edit Customer
	 * Customer can edit his details
	 */
	@Override
	public String editCustomer(Customer customer)
	{
		try {
		custRepository.save(customer);
//		logger.info(customer.getCustomerName()+" is updated successfully!..");
		return customer.getCustomerName()+" is updated successfully!..";
		}
		catch(Exception exception) {
			throw exception;
		}
	}
	@Override
	public String editAdmin(Admin admin)
	{
		try {
			adminRepo.save(admin);
//			logger.info(admin.getAdminName()+" is updated successfully!..");
			return admin.getAdminName()+" is updated successfully!..";
			}
			catch(Exception exception) {
				throw exception;
			}
	}

	/*
	 * Forgot Password
	 * Customer can retrieve his password by Giving Security Question and its answer
	 * Both should match the existing user
	 */
	@Override
	public String forgotPassword(String username, String securityQuestion, String answer)
	{
		if(custRepository.existsById(username)) {
			customer = custRepository.getOne(username);
			if(customer.getSecurityQuestion().equals(securityQuestion) && customer.getAnswer().equals(answer)) {
//				logger.info("Password retrieved");
				return "Your password is "+customer.getPassword()+". Plz change it for security purpose.";
			}
//			logger.error("Invalid Security question/Answer");
			return "Invalid Security question/Answer";
		}
		else {
//			logger.error("UserId does not exist");
			return "UserId does not exist";
		}
	}
	
	@Override
	public String forgotPasswordAdmin(String username, String securityQuestion, String answer) 
	{
		if(adminRepo.existsById(username)) {
			Admin admin = adminRepo.getOne(username);
			if(admin.getSecurityQuestion().equals(securityQuestion) && admin.getAnswer().equals(answer)) {
//				logger.info("Password retrieved");
				return "Your password is "+admin.getPassword()+". Plz change it for security purpose.";
			}
//			logger.error("Invalid Security question/Answer");
			return "Invalid Security question/Answer";
		}
		else {
//			logger.error("UserId does not exist");
			return "UserId does not exist";
		}
	}
	
	@Override
	public Customer getCustById(String username)
	{
		try {
//		logger.info("Customer retrieved");
		return custRepository.getOne(username);
		}
		catch(Exception exception) {
			throw exception;
		}
	}

	@Override
	public Admin getAdminById(String username)
	{
		try {
//		logger.info("Admin retrieved");
		return adminRepo.getOne(username);
		}
	catch(Exception exception) {
		throw exception;
	}
	}
	
	/*
	 * Show Tickets
	 * Customer can see his booking history
	 * All tickets can be seen booked or cancelled also
	 */
	@Override
	public List<Ticket> showTickets(String username)
	{
		if(custRepository.existsById(username)) {
//			logger.info("Tickets retrieved");
		return custRepository.getOne(username).getMyTickets();
		}
		else
			return null;
	}
	
	/* Search Movie
	 * Customer can serach a movie by its name
	 * Can see all theatres in which the movie is running
	 */
	@Override

	public List<Movie> searchMovie(String movieName) {
//		logger.info("At DAO - Search movie");

		return movieRepo.findByMovieName(movieName);
	}

	/*
	 * Search Theatre
	 * Customer can search a theatre by its name
	 * Can see all movies in that theatre
	 */
	@Override

	public List<Theater> searchTheatre(String theatreName) {
//		logger.info("At DAO - Search Theatre");

		return trepo.findByTheaterName(theatreName);
		
	}
	
	
	///End of Dhiraj Modules
	


	
	
	
	@Override
	public List<Show> showShows(Integer screenId) 
	{
		Screen screen =screenRepo.getOne(screenId);
		return screen.getShowList();
	}

	
	
	
	
//	-----------------------------------------------------------------------------------

//	---------------------------Movie--------------------------------------------------------

	@Override

	public String addMovie(Movie movie) {

		// TODO Auto-generated method stub
		movieRepo.save(movie);
return "Movie added successfully..";
	}

	@Override
	public String deleteMovie(int movieId) {
		// TODO Auto-generated method stub

     
		repo.deleteById(movieId);
		return "Movie deleted successfully..";

      
		

	}

	@Override
	public List<Movie> getAllMovies()
	{
		// TODO Auto-generated method stub




       return movieRepo.findAll();

		
	}
//	-----------------------------------------------------
	//-------------------------Theater----------------------------
		@Override
		public String addTheater(Theater theater) {
			// TODO Auto-generated method stub
			theatreRepo.save(theater);
	 return "Theater added successfully..";
		}


		@Override
		public String deleteTheater(int theater_id) {
			// TODO Auto-generated method stub
			theatreRepo.deleteById(theater_id);
			return "Theater deleted successfully";
			
		}


		@Override
		public List<Theater> getAllTheater() {
			// TODO Auto-generated method stub

			return theatreRepo.findAll();
		}
	//--------------------------------------------------------------------
		@Override
		public Theater getTheater(int theater_id) {
			// TODO Auto-generated method stub
			return theatreRepo.getOne(theater_id);
		}
		
		
//		------------------------Screen---------------------------------
		@Override
		public String addScreen(Screen screen) {
			// TODO Auto-generated method stub
			screenRepo.save(screen);
			return "Screen added successfully";
			
		}


		@Override
		public String deleteScreen(int screen_id) {
			// TODO Auto-generated method stub
			screenRepo.deleteById(screen_id);
			return "Screen deleted successfully";
			
		}


		@Override
		public List<Screen> getAllScreen() {
			// TODO Auto-generated method stub
			return screenRepo.findAll();
		}


		
//		-----------------------------------------------------------------
//		@Override
//		public Optional<Screen> getAllScreensByTherateid(int theater_id) {
//			// TODO Auto-generated method stub
//			return null;
//		}

	//--------------------------Show--------------------------------------
		@Override
		public String addShow(Show show) {
			// TODO Auto-generated method stub
	 Show s1=showRepo.save(show);
	 
	 
	 List<Seat> seatlist = new ArrayList<Seat>(); 
	  for (int i = 0; i < 5; i++) 
	  { 
		  for(int j = 0; j < 10; j++) 
		  { 
			  Seat seat = new Seat(); 
			  int[] seatLocation ={i,j};
			  seat.setSeatLocation(seatLocation); 
			  seat.setShow(show);
			  seatrepo.save(seat);
			  System.out.println(seat);
			  seatlist.add(seat);
	  
	  } }
	 
	  s1.setSeats(seatlist);
	  return "Show added successfully";

		
		}


		@Override
		public String deleteShow(int show_id) {
			// TODO Auto-generated method stub
			showRepo.deleteById(show_id);
			return "Show deleted successfully";
		}


		@Override
		public List<Show> getAllShow() {
			// TODO Auto-generated method stub
			return showRepo.findAll();
		}


	//---------------------------------------------------------------------
		@Override
		public Theater grtTheaterById(int theater_id) {
			// TODO Auto-generated method stub
			return theatreRepo.getOne(theater_id);
		}

		@Override
		public Screen getScreen(int screen_id) {
			// TODO Auto-generated method stub
			return screenRepo.getOne(screen_id);
		}
	
	
	



	

//	-----------------------------------------------------------------------------------
	@SuppressWarnings("null")
	@Override
	public List<Seat> SelectSeat(Integer showId, SelectedSeatArray seatLocation) 
	{ //1,1,1,2,1,2
		// TODO Auto-generated method stub
		System.out.println(seatLocation);
		Show show = showRepo.getOne(showId);
		List<Seat> SeatList = show.getSeats();
		System.out.println("-----------------------------------------------------------------------seats checked in dao-----------------------------------------------------------------------------------");
		for (Seat seat : SeatList) {
			System.out.println(seat);
		}
		List<Seat> ChoosedSeat = new ArrayList<Seat>();
		int size = seatLocation.getSeatLocation().length;
		int[] seatLoc = seatLocation.getSeatLocation();
		for (int i =0 ; i<size; i=i+2) {
		int row = seatLoc[i];
		int col = seatLoc[i+1]; //(1,1),(1,2),
		
		int loc = (row*10)+(col);
		Seat blockedseat = SeatList.get(loc);
		
		ChoosedSeat.add(blockedseat);
		}
		
		return ChoosedSeat;
		
	}
	@Override
	public  Booking UpdateSeatStatus(Booking BookingObj) 
	{
		
		List<Seat> list =BookingObj.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("Blocked"))
					{
				       seat.setSeatStatus("booked");
					}
			
		}
		Ticket confirmTicket = BookingObj.getTicket();
		
		
		confirmTicket.setTicketStatus(true);
		ticketRepository.save(confirmTicket);
		
		System.out.print("payment success :- Ticket status :-     ");
		System.out.println( BookingObj.getTicket().getTicketStatus());
		seatrepo.saveAll(list);
		
		BookingObj.setTicket(confirmTicket);
		BookingObj.setSeatList(list);
		bookRepository.save(BookingObj);		
		return BookingObj ;
		
		
	}

	@Override
	public Seat blockUnblock(Integer seat_id ) 
	{
		// TODO Auto-generated method stub
		
		Seat markseat = seatrepo.getOne(seat_id);
		System.out.println(markseat);
		
		if(markseat.getSeatStatus().equals("Available"))
		{
	       markseat.setSeatStatus("Blocked");
		}
		else if(markseat.getSeatStatus().equals("Blocked"))
		{
			markseat.setSeatStatus("Available");
		}
		
		
		
		Seat marked= seatrepo.save(markseat);
		return marked;
	}



	@Override
	public Booking cancelBooking(int cancelBooking_id)
	{
		// TODO Auto-generated method stub
		Booking cancelBooking = bookRepository.getOne(cancelBooking_id);
		List<Seat> list = cancelBooking.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("booked"))
					{
				       seat.setSeatStatus("Available");
					}
			
		}
		Ticket confirmTicket = cancelBooking.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(cancelBooking);		
		return cancelBooking ;
		
	}

	@Override
	public Booking unblockSeat(int Bookingobj_id)
	{
		// TODO Auto-generated method stub
		Booking Bookingobj = bookRepository.getOne(Bookingobj_id);
		List<Seat> list = Bookingobj.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("Blocked"))
					{
				       seat.setSeatStatus("Available");
					}
			
		}
		
		Ticket confirmTicket = Bookingobj.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		bookRepository.save(Bookingobj);		
		return Bookingobj ;
	}


//	@Override
//	public void addShow(Show show , int movieId) {
//		// TODO Auto-generated method stub
//		Movie movieref = movieRepo.getOne(movieId);
//		show.setMovieName(movieref);
//		showRepo.save(show);
//		
//		
//		List<Seat> seatlist = new ArrayList<Seat>(); 
//		  for (int i = 0; i < 5; i++) 
//		  { 
//			  for(int j = 0; j < 10; j++) 
//			  { 
//				  Seat seat = new Seat(); 
//				  int[] seatLocation ={i,j};
//				  seat.setSeatLocation(seatLocation); 
//				  seat.setShow(show);
//				  seatrepo.save(seat);
//				  System.out.println(seat);
//		  
//		  seatlist.add(seat);
//		  
//		  } }
//		  
//		  show.setSeats(seatlist);
//			 showRepo.save(show);
//	}


	@Override
	public Booking initiateBooking(Booking BookingObj)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	mahesh module
	
	
//	@Autowired
//	Seatrepo seatrepository;

	
	
	@Override
	public double calculateTotalCost(List<Seat> seat)
	{
		
		double sum=0;
		for(int i=0; i<seat.size();i++) {
			sum=sum+seat.get(i).getSeatPrice();
		}

			return sum;
	}

	@Override
	public Booking makePayment(int Booking_id) 
	{
		System.out.println(Booking_id);
		Booking booking= bookRepository.getOne(Booking_id);
		 
		 System.out.println(" here choose payment method :-----------c");
		 System.out.println(booking);
		booking.getTransactionId();
		Ticket printTicket = booking.getTicket();
		printTicket.setNoOfSeats(booking.getSeatList().size());
		printTicket.setScreenName(booking.getShowRef().getShowName());
		printTicket.setBookingRef(booking);
		
		Ticket paid = ticketRepository.save(printTicket);
		booking.setTicket(paid);
		booking= UpdateSeatStatus(booking);
	return booking;
	}

	
	@Override
	public Booking   cancelticket(Ticket ticket)
	{
		
		Booking cancelBooking=ticket.getBookingRef();
		List<Seat> list = cancelBooking.getSeatList();
		for (Seat seat : list) {
			if(seat.getSeatStatus().equals("booked"))
					{
				       seat.setSeatStatus("Available");
					}
			
		}
		Ticket confirmTicket = cancelBooking.getTicket();
		confirmTicket.setTicketStatus(false);
		ticketRepository.save(confirmTicket);
		seatrepo.saveAll(list);
		
		bookRepository.save(cancelBooking);		
		return cancelBooking ;
		
	
	}
	
	@Override
	public Booking choosePaymentmethod(Integer showId, SelectedSeatArray seatLocation, int buttonid) 
	{
		
		List<Seat> seat = SelectSeat(showId, seatLocation);
		Booking b = new Booking(); 
		Ticket tk =new Ticket(); /// 2,4,2,5,2,6
		b.setTicket(tk);
		Seat s1 =seat.get(0);
		
		System.out.println(seat);
		System.out.println(s1);
		
		b.setShowId(s1.getShow().getShowId());		
		b.setSeatList(seat);
//		b.setMovieId(s1.getShow().getMovieName().getMovieId());
		b.setTotalCost(calculateTotalCost(seat));
		b.setBookingDate(java.time.LocalDate.now());
		
		
		//to generate unique transaction id
		
				int[] locArray = seatLocation.getSeatLocation(); 
				
				StringBuilder s = new StringBuilder(); 
				s.append(buttonid);
		
			    for (int i : locArray)
			    {
			         s.append(i); //add all the ints to a string
			    }
		
			     int id = Integer.parseInt(s.toString());

		
		b.setTransactionId(id);
		
		System.out.println(" here choose payment method :-----------a");
		System.out.println(b);
		b.setShowRef(s1.getShow());
	    ticketRepository.save(tk);
	    
	    System.out.println(" here choose payment method :-----------b");
	    System.out.println(b);
		bookRepository.save(b);	
		return b;
	}

	@Override
	public List<Show> searchShow(String showName)
	{
//		logger.info("At DAO - Search movie");
		return showRepository.findByShowName(showName);
	}

	


}
	

	



