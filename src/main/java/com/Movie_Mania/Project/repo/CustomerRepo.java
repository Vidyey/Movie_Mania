package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Customer findByUsernameAndPassword(String username, String password);

}
