package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.domain.model.PeopleModel;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class IPeopleRequestMapperTest {

    private final IPeopleRequestMapper mapper =
            Mappers.getMapper(IPeopleRequestMapper.class);

    @Test
    void shouldMapPeopleRequestDtoToPeopleModel() {
        // Arrange
        PeopleRequestDto dto = new PeopleRequestDto();
        dto.setDocumentNumber("123456");
        dto.setName("Andres");
        dto.setEmail("andres@email.com");

        // Act
        PeopleModel model = mapper.toModel(dto);

        // Assert
        assertNotNull(model);
        assertEquals(dto.getDocumentNumber(), model.getDocumentNumber());
        assertEquals(dto.getName(), model.getName());
        assertEquals(dto.getEmail(), model.getEmail());
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // Act
        PeopleModel model = mapper.toModel(null);

        // Assert
        assertNull(model);
    }
}
