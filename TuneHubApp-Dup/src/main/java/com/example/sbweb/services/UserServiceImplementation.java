package com.example.sbweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbweb.entities.Users;
import com.example.sbweb.repositories.UsersRepository;

@Service

	public class UserServiceImplementation implements UserService {
	    @Autowired
		UsersRepository userrepo;
	    
		@Override
		public String addUser(Users user) {
			userrepo.save(user);
			return "user is created and saved";
		}

		@Override
		public boolean emailExists(String email) {
			if(userrepo.findByEmail(email)==null) {
			return false;
		    }
			else
			{
				return true;
			}

		
	}

		@Override
		public boolean validateUsers(String email, String password) {
			 /*Users user=userrepo.findByEmail(email);
			String db_pwd=user.getPassword();
			if(db_pwd.equals(password))
			{
				return true;
			}*/
			if(userrepo.findByEmail(email).getPassword().equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		@Override
		public String getRole(String email) {
		    /* Users user=userrepo.findByEmail(email);
		     String role=user.getRole();
			return role;*/
			
			return userrepo.findByEmail(email).getRole();
			
		}
}
