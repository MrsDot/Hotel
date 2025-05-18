package org.example.hotel2.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String name;
    private Integer maxSpace;
    private Double price;
    private boolean isAvailable;

}
