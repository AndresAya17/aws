package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.PeopleModel;

public interface IPeoplePersistencePort {
    PeopleModel savePeople(PeopleModel peopleModel);
}
