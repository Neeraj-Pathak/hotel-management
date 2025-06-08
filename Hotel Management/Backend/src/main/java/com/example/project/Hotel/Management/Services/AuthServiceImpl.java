package com.example.project.Hotel.Management.Services;

import com.example.project.Hotel.Management.Dto.SignupRequest;
import com.example.project.Hotel.Management.Dto.UserDto;
import com.example.project.Hotel.Management.Entity.User;
import com.example.project.Hotel.Management.Enums.UserRole;
import com.example.project.Hotel.Management.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdmin(){
        Optional<User> admin = userRepository.findByUserRole(UserRole.ADMIN);
        if(admin.isEmpty()){
            User user = new User();
            user.setEmail("test@admin.com");
            user.setName("Admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("Admin created");
        }else{
            System.out.println("Admin already exists");
        }
    }

    //
    public UserDto createUser(SignupRequest signupRequest) {
        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new EntityExistsException("User already exists" + signupRequest.getEmail());
        }
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser.getUserdto();
    }
}
