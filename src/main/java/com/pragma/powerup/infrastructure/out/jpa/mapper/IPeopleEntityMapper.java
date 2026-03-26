package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.PeopleModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.PeopleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPeopleEntityMapper {

    PeopleEntity toEntity(PeopleModel peopleModel);
    PeopleModel toModel(PeopleEntity peopleEntity);

}
