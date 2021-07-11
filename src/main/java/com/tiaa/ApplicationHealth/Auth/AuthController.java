package com.tiaa.ApplicationHealth.Auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	AuthService authService;
	
	AuthController(AuthService authService){
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity loginUser(@RequestBody AuthModel au) throws IOException {

		if(authService.login(au)){
			return new ResponseEntity(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
