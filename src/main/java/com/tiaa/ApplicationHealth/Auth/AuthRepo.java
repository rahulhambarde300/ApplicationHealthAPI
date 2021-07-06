package com.tiaa.ApplicationHealth.Auth;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepo extends JpaRepository<AuthModel, String> {
}
