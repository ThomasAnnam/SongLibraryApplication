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
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String songName;
		
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSongName() {
		return songName;
	}
	
	@Override
	public String toString() {
		return "[FirstName: "+firstName+" LastName: "+lastName+" SongName: "+songName+"]";
	}
}