package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.PeopleModel;


public interface IPeopleServicePort {
    void savePeople(PeopleModel peopleModel);
    PeopleModel findById(Long userId);

}
