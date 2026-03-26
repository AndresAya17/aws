package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.dto.response.PeopleResponseDto;
import com.pragma.powerup.application.handler.IPeopleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/{id}")
    public ResponseEntity<PeopleResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(peopleHandler.findById(id));
    }

}
