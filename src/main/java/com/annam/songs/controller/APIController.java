package com.annam.songs.controller;

import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.annam.songs.service.SongProcessService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class APIController {

	@Autowired
	private SongProcessService songProcessService;
	
	@Autowired
	private Gson gson;
	
	@GetMapping(path="song")
	public String all() {
		return gson.toJson(songProcessService.getAll());
	}
	
	@PostMapping(path="song")
	public ResponseEntity<String>  addSong(@RequestBody Map<String,Object> body) {
		String json = gson.toJson(body);
		try {
			String result = songProcessService.add(json);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch(HibernateException e) {
			return new ResponseEntity<>("Song cannot be added", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("song/{id}")
	public ResponseEntity<String> editSong(@PathVariable Long id,@RequestBody Map<String,Object> body) {
		String json = gson.toJson(body);
		try {
			String result = songProcessService.edit(id, json);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch(HibernateException e) {
			return new ResponseEntity<>("Song cannot be edited", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("song/{id}")
	public ResponseEntity<String> deleteSong(@PathVariable Long id) {
		try {
			String result = songProcessService.delete(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch(HibernateException e) {
			return new ResponseEntity<>("Song cannot be deleted", HttpStatus.BAD_REQUEST);
		}
	}
}
