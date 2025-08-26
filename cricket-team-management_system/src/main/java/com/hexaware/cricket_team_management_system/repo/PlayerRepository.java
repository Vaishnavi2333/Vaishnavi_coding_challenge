package com.hexaware.cricket_team_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.cricket_team_management_system.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
	
	@Query("select p from Player p where p.role = :role ")
	List<Player> getByRole(@Param("role") String role);

	
	
	

}