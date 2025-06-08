package com.example.project.Hotel.Management.Controller.Customer;

import com.example.project.Hotel.Management.Dto.ReservationDto;
import com.example.project.Hotel.Management.Services.Customer.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")  // add base path consistent with security rules
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> postBooking(@RequestBody ReservationDto reservationDto) {
        boolean success = bookingService.postReservation(reservationDto);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Room not found");
        }
    }

    @GetMapping("/bookings/{userId}/{pageNumber}")
    public ResponseEntity<?> getAllBookingsByUserId(@PathVariable Long userId, @PathVariable int pageNumber) {
        try{
            return ResponseEntity.ok(bookingService.getAllReservationByUserId(userId, pageNumber));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
