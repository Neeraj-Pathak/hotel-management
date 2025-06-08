package com.example.project.Hotel.Management.Services.Admin;

import com.example.project.Hotel.Management.Dto.ReservationResponseDto;

public interface ReservationService {
    ReservationResponseDto getAllReservations(int pageNumber);
    boolean changeReservationStatus(Long id,String status);
}
