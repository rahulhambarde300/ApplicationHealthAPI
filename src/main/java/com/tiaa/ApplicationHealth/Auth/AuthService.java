package com.tiaa.ApplicationHealth.Auth;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private AuthRepo authRepo;
	
	@Autowired
	public AuthService(AuthRepo authRepo) {
		this.authRepo = authRepo;
	}

	public boolean login(String username,String password) {
		try {
			AuthModel audata = this.authRepo.getById(username);
			if(password.equals(audata.getPassword())) {
				return true;
			}
			return false;
		}catch(EntityNotFoundException enfe) {
			return false;
		}
	}

}
