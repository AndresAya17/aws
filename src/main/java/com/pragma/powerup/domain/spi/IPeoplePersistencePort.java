package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.PeopleModel;

import java.util.Optional;

public interface IPeoplePersistencePort {
    PeopleModel savePeople(PeopleModel peopleModel);
    Optional<PeopleModel> findById(Long userId);
}
