package com.annam.songs.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annam.songs.persistence.entity.Song;
import com.annam.songs.persistence.repository.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;
	
	public List<Song> get(){
		return songRepository.findAll();
	}
	
	public void add(Song song) {
		songRepository.save(song);
	}
	
	public void edit(Long id,Song song) {
		
		Optional<Song> doesSongExist = songRepository.findById(id);
		
		if(doesSongExist.isPresent()) {
			song.setId(doesSongExist.get().getId());
		}
		
		songRepository.save(song);
	}
	
	public void delete(Long id) {
		songRepository.deleteById(id);
	}
}
