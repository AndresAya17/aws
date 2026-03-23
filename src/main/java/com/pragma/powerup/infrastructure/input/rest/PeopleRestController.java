package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.handler.IPeopleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
@RequiredArgsConstructor
public class PeopleRestController {

    private final IPeopleHandler peopleHandler;

    @PostMapping("/")
    public ResponseEntity<Void> savePeople(@RequestBody PeopleRequestDto peopleRequestDto) {
        peopleHandler.savePeople(peopleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
