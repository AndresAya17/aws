package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;

public interface IPeopleHandler {
    void savePeople(PeopleRequestDto peopleRequestDto);
}
