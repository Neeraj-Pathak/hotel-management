package com.example.project.Hotel.Management.Services.Customer;

import com.example.project.Hotel.Management.Dto.ReservationDto;
import com.example.project.Hotel.Management.Dto.ReservationResponseDto;

public interface BookingService {
    boolean postReservation(ReservationDto reservationDto);
    ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber);
}
