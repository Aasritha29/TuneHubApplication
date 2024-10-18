package com.example.sbweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbweb.entities.Song;
import com.example.sbweb.repositories.SongsRepository;

@Service
  public class SongsServiceImplementation implements SongsService {

		@Autowired
		SongsRepository songrepo;
		@Override
		public String addSong(Song song) {
		    songrepo.save(song);
			return "Song added";
		}
		@Override
		public boolean songExists(String songname) {
			Song songs=songrepo.findBySongname(songname);
		    if(songs==null)
			  return false;
		    else
		    	return true;
		}
		@Override
		public List<Song> fetchAllSongs() {
			List<Song> songslist=songrepo.findAll();
			
			return songslist;
		}
}
