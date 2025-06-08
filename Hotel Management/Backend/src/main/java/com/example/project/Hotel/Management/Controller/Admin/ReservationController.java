package com.example.project.Hotel.Management.Controller.Admin;

import com.example.project.Hotel.Management.Services.Admin.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations/{pageNumber}")
    public ResponseEntity<?> getAllReservations(@PathVariable int pageNumber) {
        try{
            return ResponseEntity.ok(reservationService.getAllReservations(pageNumber));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/reservation/{id}/{status}")
    public ResponseEntity<?> changeReservationStatus(@PathVariable Long id, @PathVariable String status) {
        boolean success = reservationService.changeReservationStatus(id, status);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
