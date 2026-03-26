package com.pragma.powerup.domain.validator;

import com.pragma.powerup.domain.model.PeopleModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleValidatorTest {

    private PeopleModel buildValidModel() {
        return new PeopleModel("123456", "Andres", "andres@email.com");
    }

    @Test
    void shouldPassValidationWhenModelIsValid() {
        PeopleModel model = buildValidModel();

        assertDoesNotThrow(() -> PeopleValidator.validate(model));
    }

    // -------- DOCUMENT NUMBER --------

    @Test
    void shouldFailWhenDocumentNumberIsNull() {
        PeopleModel model = buildValidModel();
        model.setDocumentNumber(null);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The document number is required", ex.getMessage());
    }

    @Test
    void shouldFailWhenDocumentNumberIsNotNumeric() {
        PeopleModel model = buildValidModel();
        model.setDocumentNumber("ABC123");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The document number must contain only numbers", ex.getMessage());
    }

    @Test
    void shouldFailWhenDocumentNumberLengthIsInvalid() {
        PeopleModel model = buildValidModel();
        model.setDocumentNumber("123"); // menor a 5

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The document number must be between 5 and 15 characters", ex.getMessage());
    }

    // -------- NAME --------

    @Test
    void shouldFailWhenNameIsNull() {
        PeopleModel model = buildValidModel();
        model.setName(null);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The name is required", ex.getMessage());
    }

    @Test
    void shouldFailWhenNameLengthIsInvalid() {
        PeopleModel model = buildValidModel();
        model.setName("A"); // menor a 2

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The name must be between 2 and 50 characters", ex.getMessage());
    }

    // -------- EMAIL --------

    @Test
    void shouldFailWhenEmailIsNull() {
        PeopleModel model = buildValidModel();
        model.setEmail(null);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The email is required", ex.getMessage());
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        PeopleModel model = buildValidModel();
        model.setEmail("invalid-email");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PeopleValidator.validate(model)
        );

        assertEquals("The email format is invalid", ex.getMessage());
    }
}
