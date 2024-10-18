package com.example.sbweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController {
	
	    //to create link between register page and controller because in order to communicate with 2 html files we need help of controller
		 @GetMapping("/map-register")
		  public String registerMapping()
		  {
			  return "register";
		  }
		 
		 @GetMapping("/map-login")
		 public String loginMapping() {
			 return "login";
		 }
		 
		 
		 @GetMapping("/map-songs")
		 public String songsMapping() {
			 return "addsongs";
		 }

		/* @GetMapping("/map-viewsongs")
		 public String viewSongsMapping() {
			 return "viewsongs";
		 }*/
		  
	}



