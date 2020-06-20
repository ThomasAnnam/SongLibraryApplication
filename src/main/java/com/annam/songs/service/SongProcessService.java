package com.annam.songs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annam.songs.persistence.entity.Song;
import com.annam.songs.persistence.service.SongService;
import com.google.gson.Gson;

@Service
public class SongProcessService {

	@Autowired
	private SongService songService;
	
	@Autowired
	private Gson gson;
	
	public List<Song> getAll(){
		return songService.get();
	}
	
	public String add(String body) {
		Song song = gson.fromJson(body, Song.class);
		songService.add(song);
		return "Successfully Inserted";
	}
	
	public String edit(Long id,String body) {
		Song song = gson.fromJson(body, Song.class);
		songService.edit(id, song);
		return "Successfully Edited";
	}
	
	public String delete(Long id) {
		songService.delete(id);
		return "Successfully Deleted";
	}
}
