package org.example.hotel2.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.example.hotel2.dto.SignupRequest;
import org.example.hotel2.dto.UserDto;
import org.example.hotel2.entity.MainUser;
import org.example.hotel2.enums.MainUserRole;
import org.example.hotel2.repository.MainUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MainUserRepository mainUserRepository;

    @PostConstruct
    public void createAnAdminAccount() {
        Optional<MainUser> adminAccount = mainUserRepository.findByMainUserRole(MainUserRole.ADMIN);
        if (adminAccount.isEmpty()) {
            MainUser mainUser = new MainUser();
            mainUser.setEmail("admin@test.com");
            mainUser.setUserName("admin");
            mainUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            mainUser.setMainUserRole(MainUserRole.ADMIN);
            mainUserRepository.save(mainUser);
            System.out.println("Admin account created:" + " " + mainUser.getEmail() +
                    " " + mainUser.getPassword());
        }
        else {
            System.out.println("Admin account already exists");
        }
    }

    public UserDto createUser(SignupRequest signupRequest) {
        if (mainUserRepository.findMainUserByEmail(signupRequest.getEmail()).isPresent()) {
            throw new EntityExistsException("User already present with email: " + signupRequest.getEmail());
        }

        MainUser mainUser = new MainUser();
        mainUser.setEmail(signupRequest.getEmail());
        mainUser.setMainUserRole(MainUserRole.CUSTOMER);
        mainUser.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        MainUser savedMainUser = mainUserRepository.save(mainUser);
        return savedMainUser.getMainUserDto();

    }

}
