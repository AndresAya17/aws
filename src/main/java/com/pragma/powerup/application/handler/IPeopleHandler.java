package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.dto.response.PeopleResponseDto;

import java.util.Optional;

public interface IPeopleHandler {
    void savePeople(PeopleRequestDto peopleRequestDto);
    PeopleResponseDto findById(Long userId);
}
