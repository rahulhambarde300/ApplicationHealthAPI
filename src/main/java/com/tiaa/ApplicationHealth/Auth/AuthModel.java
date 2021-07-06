package com.tiaa.ApplicationHealth.Auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auth")
public class AuthModel {
	@Id
	@Column(name="`username`")
	private String username;
	
	@Column(name="`password`")
	private String password;

	public AuthModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AuthModel() {
		
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "AuthModel [username=" + username + ", password=" + password + "]";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
