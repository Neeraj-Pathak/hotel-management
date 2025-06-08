package com.example.project.Hotel.Management.Services;

import com.example.project.Hotel.Management.Dto.SignupRequest;
import com.example.project.Hotel.Management.Dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);
}
