package com.example.project.Hotel.Management.Dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
