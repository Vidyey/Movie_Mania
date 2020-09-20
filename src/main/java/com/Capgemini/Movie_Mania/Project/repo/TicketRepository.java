package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie_Mania.Project.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
