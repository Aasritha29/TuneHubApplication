package com.example.sbweb.services;

import java.util.List;

import com.example.sbweb.entities.Song;

public interface SongsService {

	public String addSong(Song song);
	 public boolean songExists(String songname);
	 public List<Song> fetchAllSongs();
}
