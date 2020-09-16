package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByUsernameAndPassword(String username, String password);
}
