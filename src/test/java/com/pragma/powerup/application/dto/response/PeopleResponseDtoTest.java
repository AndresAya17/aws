package com.pragma.powerup.application.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleResponseDtoTest {

    @Test
    void shouldSetAndGetValuesCorrectly() {
        PeopleResponseDto dto = new PeopleResponseDto();

        dto.setDocumentNumber("123456789");
        dto.setName("Andres");
        dto.setEmail("andres@email.com");

        assertEquals("123456789", dto.getDocumentNumber());
        assertEquals("Andres", dto.getName());
        assertEquals("andres@email.com", dto.getEmail());
    }

    @Test
    void shouldAllowNullValues() {
        PeopleResponseDto dto = new PeopleResponseDto();

        dto.setDocumentNumber(null);
        dto.setName(null);
        dto.setEmail(null);

        assertNull(dto.getDocumentNumber());
        assertNull(dto.getName());
        assertNull(dto.getEmail());
    }
}
