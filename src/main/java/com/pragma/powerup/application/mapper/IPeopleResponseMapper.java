package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.PeopleResponseDto;
import com.pragma.powerup.domain.model.PeopleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPeopleResponseMapper {
    PeopleResponseDto toResponse(PeopleModel peopleModel);
}
