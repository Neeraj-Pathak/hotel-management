package com.example.project.Hotel.Management.Services.Admin;

import com.example.project.Hotel.Management.Dto.RoomDto;
import com.example.project.Hotel.Management.Dto.RoomResponseDto;

public interface RoomService {
    boolean postRoom(RoomDto roomDto);
    RoomResponseDto getAllRooms(int pageNumber);
    RoomDto getRoomById(Long Id);
    boolean updateRoom(Long id, RoomDto roomDto);
    void deleteRoom(Long id);
}
