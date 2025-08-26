package com.hexaware.cricket_team_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket_team_management_system.dto.PlayerDto;
import com.hexaware.cricket_team_management_system.entity.Player;
import com.hexaware.cricket_team_management_system.exception.PlayerNotFoundException;
import com.hexaware.cricket_team_management_system.exception.PlayerAlreadyExistsException;
import com.hexaware.cricket_team_management_system.repo.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService{
	
	@Autowired
	PlayerRepository repo;

	@Override
	public Player addPlayer(PlayerDto dto) throws PlayerAlreadyExistsException{
		
		if(repo.existsById(dto.getPlayerId())) {
			throw new PlayerAlreadyExistsException("Player with given id already exists");
		}
		Player play = new Player();
	
		
		play.setPlayerId(dto.getPlayerId());
		play.setPlayerName(dto.getPlayerName());
		play.setJerseyNumber(dto.getJerseyNumber());
		play.setRole(dto.getRole());
		play.setTotalMatches(dto.getTotalMatches());
		play.setTeamName(dto.getTeamName());
		play.setStateName(dto.getStateName());
		play.setDescription(dto.getDescription());
		
		return repo.save(play);
	}

	@Override
	public Player updatePlayer(int playerId,PlayerDto dto) throws PlayerNotFoundException {
		Player play = repo.findById(playerId).orElseThrow(()-> new PlayerNotFoundException("Player with given id not found"));
		
		play.setPlayerName(dto.getPlayerName());
		play.setJerseyNumber(dto.getJerseyNumber());
		play.setRole(dto.getRole());
		play.setTotalMatches(dto.getTotalMatches());
		play.setTeamName(dto.getTeamName());
		play.setStateName(dto.getStateName());
		play.setDescription(dto.getDescription());
		
		return repo.save(play);
	}

	@Override
	public Player getPlayerById(int playerId) throws PlayerNotFoundException {
		
		return repo.findById(playerId).orElseThrow(()-> new PlayerNotFoundException("Player with given id not found"));
	}

	@Override
	public String deletePlayerById(int playerId) {
		
		
				repo.deleteById(playerId);
				return "Deleted Successfully";
	}

	@Override
	public List<Player> getAllPlayers() {
		
		return repo.findAll();
	}

	@Override
	public List<Player> getByRole(String role) {
		
		return repo.getByRole(role);
	}

	
				

	

}