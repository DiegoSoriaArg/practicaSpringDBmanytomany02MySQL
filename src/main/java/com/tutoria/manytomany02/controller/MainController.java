package com.tutoria.manytomany02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutoria.manytomany02.dto.SubDTO;
import com.tutoria.manytomany02.service.MainService;

@RestController
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody SubDTO dto) {
		if(!mainService.existUserAndCanal(dto.getIdUser(), dto.getIdCanal()))
			return new ResponseEntity<>("Ya existe este usuario o el canal", HttpStatus.NOT_FOUND);
		if(mainService.existSub(dto.getIdUser(), dto.getIdCanal()))
			return new ResponseEntity<>("Ya estas subscrito amig@", HttpStatus.BAD_REQUEST);
		mainService.createSub(dto.getIdUser(), dto.getIdCanal());
		return new ResponseEntity<>("te has subscrito", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> deleteuser(@PathVariable("id") int id) {
		mainService.deleteUser(id);
		return new ResponseEntity<>("Te has borrado", HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecanal/{id}")
	public ResponseEntity<?> deletecanal(@PathVariable("id") int id) {
		mainService.deleteCanal(id);
		return new ResponseEntity<>("Has borrado el canal", HttpStatus.OK);
	}

}
