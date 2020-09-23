package com.Movie_Mania.Project.testing;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.Capgemini.Movie_Mania.Project.entity.Customer;
import com.Capgemini.Movie_Mania.Project.service.MovieService;

@Transactional
@SpringBootTest
class MovieManiaTesting {

	@Autowired
	MovieService movieService;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("Fetching resources for testing ...");
	}

	@BeforeEach
	void setup() {
		
		movieService.registerCustomer(new Customer("mahesh@gmail.com", "mahesh123","pet name", "maddy", "Mahesh", "21-09-1998", "8765677766"));
		System.out.println();
		System.out.println("Test Case Started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");
	}

	@Test
	@DisplayName("Customer Registration Successful")
	@Rollback(true)
	public void registrationFirstTest() throws Exception {
		String message = movieService.registerCustomer(new Customer("pratik@gmail.com", "pratik123","pet name", "tom", "Pratik", "21-09-1998", "8765677766"));
		String expectedMessage = "Pratik is registered successfully!..";
		assertEquals(message, expectedMessage);
	}
	
	@Test
	@DisplayName("Customer Registration Fails - Customer Already Registered")
	@Rollback(true)
	public void registrationSecondTest() throws Exception {
		String message = movieService.registerCustomer(new Customer("mahesh@gmail.com", "pratik123","pet name", "tom", "Pratik", "21-09-1998", "8765677766"));
				
		String expectedMessage = "Customer Already Exists.Try login or forgot password";
		assertEquals(message, expectedMessage);
	}
	
	@Test
	@DisplayName("Customer Login Successful")
	@Rollback(true)
	public void loginFirstTest() throws Exception {

		boolean result = movieService.custLogin("mahesh@gmail.com", "mahesh123");
		assertEquals(true, result);
	}
	
	@Test
	@DisplayName("Customer Login Fails - Invalid Credentials")
	@Rollback(true)
	public void loginSecondTest() throws Exception {
		boolean result = movieService.custLogin("mahesh@gmail.com", "pratik1232");
		assertEquals(false, result);
	}
	
	@Test
	@DisplayName("Change Password Successfull")
	@Rollback(true)
	public void changePasswordFirstTest() throws Exception {
		String message = movieService.changePassword("mahesh@gmail.com", "mahesh123", "mahesh12345");
		String expectedMessage = "Password changed successfully";
		assertEquals(message, expectedMessage);
		
	}
	
	@Test
	@DisplayName("Change Password Unsuccessfull - Current Password is Wrong")
	@Rollback(true)
	public void changePasswordSecondTest() throws Exception {
		String message = movieService.changePassword("mahesh@gmail.com", "mahesh1233", "mahesh123");
		String expectedMessage = "Current Password is incorrect";
		assertEquals(message, expectedMessage);
	}
	

	@Test
	@DisplayName("Forgot Password Successfull")
	@Rollback(true)
	public void forgotPasswordFirstTest() throws Exception {
		String message = movieService.forgotPassword("mahesh@gmail.com", "pet name", "maddy");
		String expectedMessage = "Your password is mahesh123. Plz change it for security purpose.";
		assertEquals(message, expectedMessage);
		
	}
	
	@Test
	@DisplayName("Forgot Password Unsuccessfull - Incorrect security question/answer")
	@Rollback(true)
	public void forgotPasswordSecondTest() throws Exception {
		String message = movieService.forgotPassword("mahesh@gmail.com", "first car", "maddy");
		String expectedMessage = "Invalid Security question/Answer";
		assertEquals(message, expectedMessage);
	}
}
