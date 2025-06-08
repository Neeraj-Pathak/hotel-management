package com.example.project.Hotel.Management.Controller.Customer;

import com.example.project.Hotel.Management.Dto.RoomResponseDto;
import com.example.project.Hotel.Management.Services.Admin.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerRoomsController {

    private final RoomService roomService;

    @GetMapping("/rooms/{pageNumber}")
    public ResponseEntity<?> getRooms(@PathVariable int pageNumber) {
        RoomResponseDto response = roomService.getAllRooms(pageNumber);
        return ResponseEntity.ok(response);
    }
}
