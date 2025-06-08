package com.example.project.Hotel.Management.Dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String name;
    private String userRole;
}
