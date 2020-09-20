package com.Capgemini.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.Movie_Mania.Project.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{


}
