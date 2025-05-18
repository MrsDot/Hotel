package org.example.hotel2.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel2.dto.RoomDto;
import org.example.hotel2.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor


public class RoomController {
    private final RoomService roomService;

    public ResponseEntity<?> postRoom(@RequestBody RoomDto roomDto) {
        boolean success = roomService.postRoom(roomDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
