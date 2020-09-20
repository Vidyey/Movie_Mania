package com.Capgemini.Movie_Mania.Project.Dao;
//package com.Movie_Mania.Project.Dao;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.Movie_Mania.Project.entity.Booking;
//import com.Movie_Mania.Project.entity.BookingState;
//import com.Movie_Mania.Project.entity.Seat;
//import com.Movie_Mania.Project.entity.Show;
//import com.Movie_Mania.Project.entity.Ticket;
//import com.Movie_Mania.Project.repo.BookingRepository;
//import com.Movie_Mania.Project.repo.Seatrepo;
//import com.Movie_Mania.Project.repo.TicketRepository;
//@Repository
//public class MovieManiaDaoImpl implements IMovieManiaDao{
//
//	@Autowired
//	BookingRepository bookRepository;
//	@Autowired
//	TicketRepository ticketRepository;
//	@Autowired
//	Seatrepo seatrepository;
//	Booking booking1;
//	Show show;
//	Ticket ticket1=new Ticket();
//	double sum=0;
//	
//	
//	@Override
//	public double calculateTotalCost(Booking booking) {
//		// TODO Auto-generated method stub
//		List<Seat> seat=booking.getSeatList();
//		
//		for(int i=0; i<seat.size();i++) {
//			sum=sum+seat.get(i).getSeatPrice();
//		}
//			booking.setTotalCost(sum);
//			bookRepository.save(booking);
//			return sum;
//	}
//
//	@Override
//	public Booking makePayment(Booking booking) {
////		 Booking b1= new Booking(bookingId,movieId,showId,showRef,)
////		b.getTransactionId();
//		Ticket printTicket = booking1.getTicket();
//		printTicket.setNoOfSeats(booking1.getSeatList().size());
//		printTicket.setScreenName(booking1.getShowRef().getShowName());
//		booking1.setTicket(printTicket);
////		UpdateSeatStatus(b);
//		return booking1;
//	}
//
//	
//	@Override
//	public Booking   cancelticket(Ticket ticket) {
//		Booking cancelBooking=ticket1.getBookingRef();
////		cancelticket=cancelBooking(cancelticket);
//		
//		List<Seat> list = cancelBooking.getSeatList();
//		for (Seat seat : list) {
//			if(seat.getSeatStatus().equals(BookingState.booked))
//					{
//				       seat.setSeatStatus(BookingState.Available);
//					}
//			
//		}
//		Ticket confirmTicket = cancelBooking.getTicket();
//		confirmTicket.setTicketStatus(false);
//		ticketRepository.save(confirmTicket);
//		seatrepository.saveAll(list);
//		bookRepository.save(cancelBooking);		
//		return cancelBooking ;
//		
//	
//	}
//		
//	@Override
//	public Booking choosePaymentmethod(List<Seat> seat, int buttonid) {
//		Booking b = null; 
////		b1.setMovieId(movieId);
//		
//		Seat s1 =seat.get(0);
////		int showid=show.getShowId();
////		b.setShowId(showid);
//		
//		b.setShowId(show.getShowId());
//		
////		seat=show.getSeats();
//		
//		b.setSeatList(seat);
////		
////		int movieid=show.getMovieName().getMovieId();
//		
//		b.setMovieId(show.getMovieName().getMovieId());
//		
////		double totalcost =calculateTotalCost(b);
//		b.setTotalCost(calculateTotalCost(b));
//		b.setBookingDate(java.time.LocalDate.now());
//			
//		b.setTransactionId(buttonid);
//		b.setShowRef(show);
//		b.setTicket(ticket1);
////		List<Seat> seat1=b.getSeatList();
////		seat=b.getTransactionId();
//		bookRepository.save(b);
//		
//		return b;
//	}
//
//}
