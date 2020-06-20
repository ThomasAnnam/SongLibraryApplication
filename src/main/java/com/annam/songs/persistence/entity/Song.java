package com.annam.songs.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "song")
public class Song {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="artist")
	private String artistName;
	
	@Column(name="name")
	private String songName;
			
	public void setId(Long id) {
		this.id = id;
	}
		
	public void setSongName(String songName) {
		this.songName = songName;
	}
		
	public Long getId() {
		return id;
	}
		
	public String getSongName() {
		return songName;
	}
	
	@Override
	public String toString() {
		return "[Artist: "+artistName+" SongName: "+songName+"]";
	}
}