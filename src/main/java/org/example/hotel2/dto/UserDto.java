package org.example.hotel2.dto;

import lombok.Data;
import org.example.hotel2.enums.MainUserRole;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;

    private MainUserRole userRole;
}
