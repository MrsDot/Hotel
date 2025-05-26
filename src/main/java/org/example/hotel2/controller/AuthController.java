package org.example.hotel2.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.example.hotel2.dto.AuthenticationRequest;
import org.example.hotel2.dto.AuthenticationResponse;
import org.example.hotel2.dto.SignupRequest;
import org.example.hotel2.dto.UserDto;
import org.example.hotel2.entity.MainUser;
import org.example.hotel2.repository.MainUserRepository;
import org.example.hotel2.service.AuthService;
import org.example.hotel2.service.UserService;
import org.example.hotel2.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    private final MainUserRepository mainUserRepository;
    private final JwtUtil jwtUtil;
    private final UserService userService;


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

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken (@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<MainUser> optionalMainUser = mainUserRepository.findMainUserByEmail(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalMainUser.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setMainUserRole(optionalMainUser.get().getMainUserRole());
            authenticationResponse.setUserId(optionalMainUser.get().getId());
        }
        return authenticationResponse;
    }
}
