package com.pragma.powerup.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleModelTest {

    @Test
    void shouldCreateObjectWithEmptyConstructorAndSetValues() {
        PeopleModel model = new PeopleModel();

        model.setDocumentNumber("123456");
        model.setName("Andres");
        model.setEmail("andres@email.com");

        assertEquals("123456", model.getDocumentNumber());
        assertEquals("Andres", model.getName());
        assertEquals("andres@email.com", model.getEmail());
    }

    @Test
    void shouldCreateObjectWithAllArgsConstructor() {
        PeopleModel model = new PeopleModel(
                "123456",
                "Andres",
                "andres@email.com"
        );

        assertEquals("123456", model.getDocumentNumber());
        assertEquals("Andres", model.getName());
        assertEquals("andres@email.com", model.getEmail());
    }

    @Test
    void shouldAllowNullValues() {
        PeopleModel model = new PeopleModel(null, null, null);

        assertNull(model.getDocumentNumber());
        assertNull(model.getName());
        assertNull(model.getEmail());
    }
}
