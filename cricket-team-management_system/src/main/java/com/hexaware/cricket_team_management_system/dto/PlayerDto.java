package com.hexaware.cricket_team_management_system.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PlayerDto {
	
	

	private int playerId;

	 
	
	@NotNull(message = "Player  name should not be null")
	@NotEmpty(message = "Player name should not be empty")
	private String playerName;
	
	
	@NotNull(message="Jersey number cannot be null")
	@Min(value = 1, message = "Jersey number must be at least 1")
	private int jerseyNumber;
	
	@NotNull
	@Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder")
	private String role;
	
	@Positive(message="Number of matches should be positive")
	private int totalMatches;
	
	@NotNull(message = "Team name should not be null")
	@NotEmpty(message = "Team name should not be empty")
	@Size(min=5,max=20)
	private String teamName;
	
	@NotNull(message = "State name should not be null")
	private String stateName;
	
	@NotEmpty(message = "Description should not be empty")
	private String description;

}