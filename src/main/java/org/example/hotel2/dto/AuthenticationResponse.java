package org.example.hotel2.dto;

import lombok.Data;
import org.example.hotel2.enums.MainUserRole;

@Data
public class AuthenticationResponse {
    private String jwt;
    private Long userId;
    private MainUserRole mainUserRole;
}
