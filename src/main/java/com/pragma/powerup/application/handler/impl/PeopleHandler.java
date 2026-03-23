package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.handler.IPeopleHandler;
import com.pragma.powerup.application.mapper.IPeopleRequestMapper;
import com.pragma.powerup.domain.api.IPeopleServicePort;
import com.pragma.powerup.domain.model.PeopleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class PeopleHandler implements IPeopleHandler {

    private final IPeopleRequestMapper peopleRequestMapper;
    private final IPeopleServicePort peopleServicePort;

    @Override
    public void savePeople(PeopleRequestDto peopleRequestDto) {
        PeopleModel people = peopleRequestMapper.toModel(peopleRequestDto);
        peopleServicePort.savePeople(people);
    }
}
