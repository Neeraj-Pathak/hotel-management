package com.example.project.Hotel.Management.Dto;

import com.example.project.Hotel.Management.Enums.ReservationStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {
    private long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long price;
    private ReservationStatus reservationStatus;
    private Long roomId;
    private String roomType;
    private String roomName;
    private Long userId;
    private String userName;
}
