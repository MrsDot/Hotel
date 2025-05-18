package org.example.hotel2.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.example.hotel2.dto.SignupRequest;
import org.example.hotel2.dto.UserDto;
import org.example.hotel2.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<?> signUpMainUser(@RequestBody SignupRequest signupRequest) {
        try {
            UserDto createdUser = authService.createUser(signupRequest);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (EntityExistsException entityExistsException) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception exception) {
            return new ResponseEntity<>("User not created, try later", HttpStatus.BAD_REQUEST);
        }
    }
}
