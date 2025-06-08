package com.example.project.Hotel.Management.Dto;

import com.example.project.Hotel.Management.Enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private Long userId;
    private UserRole userRole;
}
