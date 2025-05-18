package org.example.hotel2.service;

import org.example.hotel2.dto.SignupRequest;
import org.example.hotel2.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
