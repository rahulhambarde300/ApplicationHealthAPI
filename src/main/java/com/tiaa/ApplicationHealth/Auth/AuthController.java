package com.tiaa.ApplicationHealth.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	AuthService authService;
	
	AuthController(AuthService authService){
		this.authService = authService;
	}

	@PostMapping("/user")
	public ResponseEntity loginUser(@RequestBody AuthModel au) {
		if(authService.login(au.getUsername(), au.getPassword())) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
