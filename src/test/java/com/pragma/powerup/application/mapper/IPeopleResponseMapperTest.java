package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.PeopleResponseDto;
import com.pragma.powerup.domain.model.PeopleModel;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class IPeopleResponseMapperTest {

    private final IPeopleResponseMapper mapper =
            Mappers.getMapper(IPeopleResponseMapper.class);

    @Test
    void shouldMapPeopleModelToResponseDto() {
        // Arrange
        PeopleModel model = new PeopleModel();
        model.setDocumentNumber("123456");
        model.setName("Andres");
        model.setEmail("andres@email.com");

        // Act
        PeopleResponseDto response = mapper.toResponse(model);

        // Assert
        assertNotNull(response);
        assertEquals(model.getDocumentNumber(), response.getDocumentNumber());
        assertEquals(model.getName(), response.getName());
        assertEquals(model.getEmail(), response.getEmail());
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // Act
        PeopleResponseDto response = mapper.toResponse(null);

        // Assert
        assertNull(response);
    }
}
