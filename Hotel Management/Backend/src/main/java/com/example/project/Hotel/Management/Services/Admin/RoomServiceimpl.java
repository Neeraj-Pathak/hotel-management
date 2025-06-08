package com.example.project.Hotel.Management.Services.Admin;

import com.example.project.Hotel.Management.Dto.RoomDto;
import com.example.project.Hotel.Management.Dto.RoomResponseDto;
import com.example.project.Hotel.Management.Entity.Room;
import com.example.project.Hotel.Management.Repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceimpl implements RoomService {

    private final RoomRepository roomRepository;

    public boolean postRoom(RoomDto roomDto) {
        try {
            Room room = new Room();
            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setType(roomDto.getType());
            room.setAvailable(true);

            roomRepository.save(room);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public RoomResponseDto getAllRooms(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Room> roomPage = roomRepository.findAll(pageable);

        RoomResponseDto roomResponseDto = new RoomResponseDto();
        roomResponseDto.setPageNumber(roomPage.getNumber()); // Alternatively: pageNumber
        roomResponseDto.setTotalPages(roomPage.getTotalPages());
        roomResponseDto.setRoomDtoList(
                roomPage.getContent()
                        .stream()
                        .map(Room::getRoomDto)
                        .collect(Collectors.toList())
        );

        return roomResponseDto;
    }

    public RoomDto getRoomById(Long Id) {
        Optional<Room> optionleRoom = roomRepository.findById(Id);
        if(optionleRoom.isPresent()) {
            return optionleRoom.get().getRoomDto();
        }else{
            throw new EntityNotFoundException("Room not found");
        }
    }

    public boolean updateRoom(Long id, RoomDto roomDto) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setName(roomDto.getName());
            existingRoom.setPrice(roomDto.getPrice());
            existingRoom.setType(roomDto.getType());
            roomRepository.save(existingRoom);
            return true;
        }
        return false;
    }

    public void deleteRoom(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(optionalRoom.isPresent()) {
            roomRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Room not found");
        }
    }
}
