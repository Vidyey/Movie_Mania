/**
 * 
 */
package com.Movie_Mania.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Movie_Mania.Project.entity.Show;

/**
 * @author Administrator
 *
 */

public interface ShowRepository extends JpaRepository<Show, Integer> {
	
	

}
