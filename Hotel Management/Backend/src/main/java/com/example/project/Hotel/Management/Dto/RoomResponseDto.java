package com.example.project.Hotel.Management.Dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomResponseDto {

    private List<RoomDto> roomDtoList;
    private Integer totalPages;
    private Integer pageNumber;
}
