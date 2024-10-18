package com.example.sbweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbweb.entities.Song;
import com.example.sbweb.services.SongsService;

@Controller
public class SongsController {


		@Autowired
		SongsService songserv;
		
		@PostMapping("/add-songs")
		public String addSong(@ModelAttribute Song song) {
		 //songserv.addSong(song);
		if(songserv.songExists(song.getSongname())==false)
		{
			songserv.addSong(song);
		 return "songsuccess";
		}
		else
			return "songfail";
		}
		
		@GetMapping("/map-viewsongs")
		public String viewSongs( Model model)
		{
			List<Song> songslist=songserv.fetchAllSongs();
			model.addAttribute("songslist",songslist);
			
			return "displaysongs";
		}
		
		@GetMapping("/cutomersongs")
		public String viewCustomerSongs(Model model)
		{
			boolean primeStatus=true;
			if(primeStatus==true)
			{
				List<Song> songslist=songserv.fetchAllSongs();
				model.addAttribute("songslist",songslist);
				return "displaysongs";
			}
			else
			{
				return "makepayment";
			}
		}
	}
