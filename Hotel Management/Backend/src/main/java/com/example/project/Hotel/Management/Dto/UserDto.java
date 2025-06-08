package com.example.project.Hotel.Management.Dto;

import com.example.project.Hotel.Management.Enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
