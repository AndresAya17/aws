package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IPeopleServicePort;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.PeopleModel;
import com.pragma.powerup.domain.spi.IPeoplePersistencePort;
import com.pragma.powerup.domain.validator.PeopleValidator;


public class PeopleUseCase implements IPeopleServicePort {

    private final IPeoplePersistencePort peoplePersistencePort;

    public PeopleUseCase(IPeoplePersistencePort peoplePersistencePort) {
        this.peoplePersistencePort = peoplePersistencePort;
    }

    @Override
    public void savePeople(PeopleModel people) {
        PeopleValidator.validate(people);
        peoplePersistencePort.savePeople(people);
    }

    @Override
    public PeopleModel findById(Long userId) {
        return peoplePersistencePort.findById(userId).orElseThrow( ()-> new DomainException("USER NOT FOUND"));
    }
}
