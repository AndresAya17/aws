package com.pragma.powerup.application.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PeopleRequestDtoTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private PeopleRequestDto buildValidDto() {
        PeopleRequestDto dto = new PeopleRequestDto();
        dto.setDocumentNumber("123456789");
        dto.setName("Andres");
        dto.setEmail("andres@email.com");
        return dto;
    }

    @Test
    void shouldPassValidationWhenDtoIsValid() {
        PeopleRequestDto dto = buildValidDto();

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailWhenDocumentNumberIsBlank() {
        PeopleRequestDto dto = buildValidDto();
        dto.setDocumentNumber("");

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }

    @Test
    void shouldFailWhenDocumentNumberHasLetters() {
        PeopleRequestDto dto = buildValidDto();
        dto.setDocumentNumber("ABC123");

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertTrue(violations.stream()
                .anyMatch(v -> v.getMessage().contains("only numbers")));
    }

    @Test
    void shouldFailWhenDocumentNumberSizeIsInvalid() {
        PeopleRequestDto dto = buildValidDto();
        dto.setDocumentNumber("123"); // menor a 5

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }

    @Test
    void shouldFailWhenNameIsBlank() {
        PeopleRequestDto dto = buildValidDto();
        dto.setName("");

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        PeopleRequestDto dto = buildValidDto();
        dto.setEmail("invalid-email");

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }

    @Test
    void shouldFailWhenEmailIsBlank() {
        PeopleRequestDto dto = buildValidDto();
        dto.setEmail("");

        Set<ConstraintViolation<PeopleRequestDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }
}
