package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.PeopleModel;
import com.pragma.powerup.domain.spi.IPeoplePersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.PeopleEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPeopleEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IPeopleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PeopleJpaAdapter implements IPeoplePersistencePort {

    private final IPeopleRepository peopleRepository;
    private final IPeopleEntityMapper peopleEntityMapper;

    @Override
    public PeopleModel savePeople(PeopleModel peopleModel) {
        PeopleEntity peopleEntity = peopleRepository.save(peopleEntityMapper.toEntity(peopleModel));
        return peopleEntityMapper.toModel(peopleEntity);
    }
}
