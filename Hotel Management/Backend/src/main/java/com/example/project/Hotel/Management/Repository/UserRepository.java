package com.example.project.Hotel.Management.Repository;

import com.example.project.Hotel.Management.Entity.User;
import com.example.project.Hotel.Management.Enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserRole(UserRole userRole);
}
