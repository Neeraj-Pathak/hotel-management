package com.example.project.Hotel.Management.Services.Customer;

import com.example.project.Hotel.Management.Dto.ReservationDto;
import com.example.project.Hotel.Management.Dto.ReservationResponseDto;
import com.example.project.Hotel.Management.Entity.Reservation;
import com.example.project.Hotel.Management.Entity.Room;
import com.example.project.Hotel.Management.Entity.User;
import com.example.project.Hotel.Management.Enums.ReservationStatus;
import com.example.project.Hotel.Management.Repository.ReservationRepository;
import com.example.project.Hotel.Management.Repository.RoomRepository;
import com.example.project.Hotel.Management.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    public static final int SEARCH_RESULT_PER_PAGE  =4;

    public boolean postReservation(ReservationDto reservationDto) {
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());
        Optional<Room> optionalRoom = roomRepository.findById(reservationDto.getRoomId());

        if(optionalRoom.isPresent() && optionalUser.isPresent()) {
            Reservation reservation = new Reservation();
            reservation.setUser(optionalUser.get());
            reservation.setRoom(optionalRoom.get());
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);

            Long days = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            reservation.setPrice(optionalRoom.get().getPrice() * days);

            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, SEARCH_RESULT_PER_PAGE);

        Page<Reservation> reservationPage = reservationRepository.findAllByUserId(pageable, userId);

        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();

        reservationResponseDto.setReservationDtoList(reservationPage
                .stream()
                .map(Reservation::getReservationDto)
                .collect(Collectors.toList()));

        reservationResponseDto.setPageNumber(reservationPage.getPageable().getPageNumber());
        reservationResponseDto.setTotalPages(reservationPage.getTotalPages());
        return reservationResponseDto;
    }
}
