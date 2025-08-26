package com.hexaware.cricket_team_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket_team_management_system.dto.PlayerDto;
import com.hexaware.cricket_team_management_system.entity.Player;
import com.hexaware.cricket_team_management_system.exception.PlayerAlreadyExistsException;
import com.hexaware.cricket_team_management_system.exception.PlayerNotFoundException;
import com.hexaware.cricket_team_management_system.service.IPlayerService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/player")
public class PlayerController  {
	
	@Autowired
	IPlayerService service;
	
	@PostMapping("/add")
	public Player addPlayer(@Valid @RequestBody PlayerDto dto) throws PlayerAlreadyExistsException {
		
		return service.addPlayer(dto);
		
	}
	
	@PutMapping("/update/{playerId}")
	public Player updatePlayer(@Valid  @PathVariable int playerId,@RequestBody PlayerDto dto) throws PlayerNotFoundException {
		return service.updatePlayer(playerId, dto);
	}
	
	@GetMapping("/getbyid/{playerId}")
	public Player getById(@PathVariable int playerId) throws PlayerNotFoundException {
		return service.getPlayerById(playerId);
		
	}
	
	@DeleteMapping("/delete/{playerId}")
	public String deletePlayerById(@PathVariable int playerId) {
		return service.deletePlayerById(playerId);
	}
	
	@GetMapping("/getall")
	public List<Player> getAllPlayers(){
		return service.getAllPlayers();
	}
	
	@GetMapping("/getbyrole")
	public List<Player> getByRole(@RequestParam String role){
		return service.getByRole(role);
	}
	
	
	

}