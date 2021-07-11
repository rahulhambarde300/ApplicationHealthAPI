package com.tiaa.ApplicationHealth.Auth;

import javax.persistence.EntityNotFoundException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class AuthService {
	private AuthRepo authRepo;
	
	@Autowired
	public AuthService(AuthRepo authRepo) {
		this.authRepo = authRepo;
	}

	public boolean login(AuthModel au) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		TypeReference<AuthModel> typeReference = new TypeReference<AuthModel>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/UserDetails.json");
		try {
			//AuthModel audata = objectMapper.readValue(new File("resources/json/UserDetails.json"), AuthModel.class);
			AuthModel audata = objectMapper.readValue(inputStream, typeReference);
			if(au.getPassword().equals(audata.getPassword()) && au.getUsername().equals(audata.getUsername())) {
				return true;
			}
			return false;
		}catch(EntityNotFoundException enfe) {
			return false;
		}
	}

}
