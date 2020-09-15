package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Movie_Mania.Project.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
