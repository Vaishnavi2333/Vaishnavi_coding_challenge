package com.hexaware.cricket_team_management_system.service;

import java.util.List;

import com.hexaware.cricket_team_management_system.dto.PlayerDto;
import com.hexaware.cricket_team_management_system.entity.Player;
import com.hexaware.cricket_team_management_system.exception.PlayerAlreadyExistsException;
import com.hexaware.cricket_team_management_system.exception.PlayerNotFoundException;

public interface IPlayerService {
	
	public Player addPlayer(PlayerDto dto) throws PlayerAlreadyExistsException;
	
	public Player updatePlayer(int playerId,PlayerDto dto) throws PlayerNotFoundException;
	
	public Player getPlayerById(int playerId) throws PlayerNotFoundException;
	
	public String deletePlayerById(int playerId);
	
	public List<Player> getAllPlayers();
	
	public List<Player> getByRole(String role);

}