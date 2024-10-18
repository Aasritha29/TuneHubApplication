package com.example.sbweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbweb.entities.Users;
import com.example.sbweb.services.UserService;

@Controller
public class UsersController {

		  @Autowired
		  UserService usi;
		 
	      @PostMapping("/register")
	      public String addUser(@ModelAttribute Users user)
			{ 
	    	  
	    	  boolean userstat=usi.emailExists(user.getEmail());
	    	//if emailexists in database then redirecting to registersuccess page
	    	  if(userstat==false)
	    	  {
	    	  usi.addUser(user);
	    	  return "registersuccess";
	    	  }
	    	  else
	    	  {
	    		  return "registerfail";
	    	  }
	    		
	    	  
	      }
	      
	      //login module
	      @PostMapping("/login")
	      public String validateUsers(@RequestParam String email,@RequestParam String password) {
	    	  //invoking validateuser in service
	    	  if(usi.validateUsers(email,password)==true)
	    	  {
	    		  //checking whether user is admin or customer
	    		  if(usi.getRole(email).equals("admin"))
	    		  {
	    		  return "adminhome";
	    		  }
	    		  else
	    		  {
	    			  return "customerhome";
	    		  }
	    	  }
	    	  else {
	    		  return "loginfail";
	    	  }
	      }

}
