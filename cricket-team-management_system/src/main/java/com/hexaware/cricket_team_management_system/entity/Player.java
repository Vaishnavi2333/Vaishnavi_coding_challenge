package com.hexaware.cricket_team_management_system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Player {
	
	@Id
	private int playerId;
	private String playerName;
	private int jerseyNumber;
	private String role;
	private int totalMatches;
	private String teamName;
	private String stateName;
	private String description;
	
	

}