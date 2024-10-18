package com.example.sbweb.services;

import com.example.sbweb.entities.Users;

public interface UserService {

	public String addUser(Users user);
	 public boolean emailExists(String email);
	    public boolean validateUsers(String email,String password);
	    public String getRole(String email);

}
