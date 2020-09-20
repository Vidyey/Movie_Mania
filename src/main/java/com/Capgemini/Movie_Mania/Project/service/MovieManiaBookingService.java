package com.Capgemini.Movie_Mania.Project.service;
//package com.Movie_Mania.Project.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Movie_Mania.Project.Dao.IMovieManiaDao;
//import com.Movie_Mania.Project.entity.Booking;
//import com.Movie_Mania.Project.entity.Seat;
//import com.Movie_Mania.Project.entity.Ticket;
//
//@Service
//public class MovieManiaBookingService implements IMovieManiaBookingService{
//	 
//	@Autowired
//	IMovieManiaDao moviemananiadao;
//	
//	@Override
//	public double calculateTotalCost(Booking booking) {
//		return moviemananiadao.calculateTotalCost(booking);
//		
//	}
//
//	@Override
//	public Booking makePayment(Booking booking) {
//		// TODO Auto-generated method stub
//		return moviemananiadao.makePayment(booking);
//	}
//
//	@Override
//	public Booking   cancelticket(Ticket ticket) {
//		// TODO Auto-generated method stub
//		return moviemananiadao.cancelticket(ticket);
//	}
//
//	@Override
//	public Booking choosePaymentmethod(List<Seat> seat, int buttonid) {
//		// TODO Auto-generated method stub
//		return moviemananiadao.choosePaymentmethod(seat, buttonid);
//	
//
//}
//}