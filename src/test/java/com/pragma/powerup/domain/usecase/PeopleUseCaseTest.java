package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.PeopleModel;
import com.pragma.powerup.domain.spi.IPeoplePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PeopleUseCaseTest {

    private IPeoplePersistencePort persistencePort;
    private PeopleUseCase useCase;

    @BeforeEach
    void setUp() {
        persistencePort = mock(IPeoplePersistencePort.class);
        useCase = new PeopleUseCase(persistencePort);
    }

    private PeopleModel buildValidModel() {
        return new PeopleModel("123456", "Andres", "test@mail.com");
    }

    // -------- savePeople --------

    @Test
    void shouldSavePeopleSuccessfully() {
        PeopleModel model = buildValidModel();

        useCase.savePeople(model);

        verify(persistencePort).savePeople(model);
    }

    @Test
    void shouldThrowExceptionWhenValidationFails() {
        PeopleModel model = buildValidModel();
        model.setEmail("invalid-email"); // rompe validación

        assertThrows(IllegalArgumentException.class,
                () -> useCase.savePeople(model));

        verify(persistencePort, never()).savePeople(any());
    }

    // -------- findById --------

    @Test
    void shouldReturnPeopleWhenUserExists() {
        Long userId = 1L;
        PeopleModel model = buildValidModel();

        when(persistencePort.findById(userId)).thenReturn(Optional.of(model));

        PeopleModel result = useCase.findById(userId);

        assertNotNull(result);
        assertEquals(model, result);

        verify(persistencePort).findById(userId);
    }

    @Test
    void shouldThrowDomainExceptionWhenUserNotFound() {
        Long userId = 1L;

        when(persistencePort.findById(userId)).thenReturn(Optional.empty());

        DomainException exception = assertThrows(
                DomainException.class,
                () -> useCase.findById(userId)
        );

        assertEquals("USER NOT FOUND", exception.getMessage());

        verify(persistencePort).findById(userId);
    }
}
