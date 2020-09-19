package com.Movie_Mania.Project.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Movie_Mania.Project.entity.Admin;
import com.Movie_Mania.Project.entity.Customer;


import com.Movie_Mania.Project.Dao.IMovieDao;

import com.Movie_Mania.Project.entity.Movie;
import com.Movie_Mania.Project.entity.Show;
import com.Movie_Mania.Project.entity.Theater;
import com.Movie_Mania.Project.entity.Ticket;



@Service

	
public class MovieServiceImpl implements MovieService
{
	
	
	
	@Autowired
	private IMovieDao dao;
	

	/*
	 * For registering a customer there are some validations rules are designed. 
	 * To validate the input this function will check by using patterns or lengths
	 */
	@Override
	public String registerCustomer(Customer customer) {
		if(customer.getUserId().toString().length()<6) {
			return "User Id should be minimum of 6 digits";
		}
		else if(customer.getCustomerName().isEmpty() || customer.getCustomerName().trim().length()==0) {
			return "Name should not be null";
		}
		else if(!Pattern.matches("[a-z A-Z]{1,30}", customer.getCustomerName())) {
			return "Name should not contains digits";
		}
		else if(!Pattern.matches("[6-9][0-9]{9}", customer.getCustomerContact())) {
			return "Enter valid mobile number (should start with 6-9)";
		}
		else if(customer.getPassword().length()<6) {
			return "Password should be minimum of length 6";
		}
		else if(customer.getSecurityQuestion().isEmpty() || customer.getSecurityQuestion().trim().length()==0) {
			return "Security question should not be null";
		}
		else if(customer.getAnswer().isEmpty() || customer.getAnswer().trim().length()==0) {
			return "Answer should not be null";
		}
		else if(customer.getDateOfBirth().isEmpty() || customer.getDateOfBirth().trim().length()==0) {
			return "DOB should not be null";
		}
		return dao.registerCustomer(customer);
	}

	
	/*
	 * For registering a admin there are some validations rules are designed. 
	 * To validate the input this function will check by using patterns or lengths
	 */
	@Override
	public String registerAdmin(Admin admin) {
		if(!Pattern.matches("[1][0-8]{3}",admin.getUserId().toString())) {
			return "Admin Id should be 4 digits and should start with 1";
		}
		else if(admin.getAdminName().isEmpty() || admin.getAdminName().trim().length()==0) {
			return "Name should not be null";
		}
		else if(!Pattern.matches("[a-z A-Z]{1,30}", admin.getAdminName())) {
			return "Name should not contains digits";
		}
		else if(!Pattern.matches("[6-9][0-9]{9}", admin.getAdminContact())) {
			return "Enter valid mobile number";
		}
		else if(admin.getPassword().length()<6) {
			return "Password should be minimum of length 6";
		}
		else if(admin.getSecurityQuestion().isEmpty() || admin.getSecurityQuestion().trim().length()==0) {
			return "Security question should not be null";
		}
		else if(admin.getAnswer().isEmpty() || admin.getAnswer().trim().length()==0) {
			return "Answer should not be null";
		}
		return dao.registerAdmin(admin);
	}

	@Override
	public boolean custLogin(Integer userId, String password) {
		return dao.custLogin(userId, password);
	}
	
	@Override
	public boolean adminLogin(Integer userId, String password) {
		return dao.adminLogin(userId, password);
	}

	@Override
	public String changePassword(Integer userId, String currentPassword, String newPassword) {
		return dao.changePassword(userId, currentPassword, newPassword);
	}

	@Override
	public String editCustomer(Customer customer) {
		if(customer.getUserId().toString().length()<6) {
			return "User Id should be minimum of 6 digits";
		}
		else if(customer.getCustomerName().isEmpty() || customer.getCustomerName().trim().length()==0) {
			return "Name should not be null";
		}
		else if(!Pattern.matches("[a-z A-Z]{1,30}", customer.getCustomerName())) {
			return "Name should not contains digits";
		}
		else if(!Pattern.matches("[6-9][0-9]{9}", customer.getCustomerContact())) {
			return "Enter valid mobile number";
		}
		else if(customer.getPassword().length()<6) {
			return "Password should be minimum of length 6";
		}
		else if(customer.getSecurityQuestion().isEmpty() || customer.getSecurityQuestion().trim().length()==0) {
			return "Security question should not be null";
		}
		else if(customer.getAnswer().isEmpty() || customer.getAnswer().trim().length()==0) {
			return "Answer should not be null";
		}
		else if(customer.getDateOfBirth().isEmpty() || customer.getDateOfBirth().trim().length()==0) {
			return "DOB should not be null";
		}
		return dao.editCustomer(customer);
	}

	@Override
	public String forgotPassword(Integer userId, String securityQuestion, String answer) {
		return dao.forgotPassword(userId, securityQuestion, answer);
	}

	public List<Ticket> showTickets(int customerId) {
		return dao.showTickets(customerId);
	}
	
	@Override
	public Customer getCustById(Integer userId) {
		return dao.getCustById(userId);
	}

	@Override
	public Admin getAdminById(Integer userId) {
		return dao.getAdminById(userId);
	}

	public List<Movie> searchMovie(String movieName) {
		return dao.searchMovie(movieName);
	}

	public List<Theater> searchTheatre(String theatreName) {
		
		return dao.searchTheatre(theatreName);
	}
	
	
	

	
	
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		dao.addMovie(movie);

	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
        dao.deleteMovie(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return dao.getAllMovies();

	}


	

	public List<Show> showShows(Integer screenId) {
		// TODO Auto-generated method stub
		return null;
	}

	


	
	


}
