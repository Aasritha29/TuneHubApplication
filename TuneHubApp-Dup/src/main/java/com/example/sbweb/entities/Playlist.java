package com.example.sbweb.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String songname;
	@ManyToMany
	List<Song> song;
	public Playlist() {
		super();
	}
	public Playlist(int id, String songname, List<Song> song) {
		super();
		this.id = id;
		this.songname = songname;
		this.song = song;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public List<Song> getSong() {
		return song;
	}
	public void setSong(List<Song> song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", songname=" + songname + ", song=" + song + "]";
	}


}
