package com.pragma.powerup.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {
        String message = "Domain error occurred";

        DomainException exception = new DomainException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void shouldBeInstanceOfRuntimeException() {
        DomainException exception = new DomainException("error");

        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    void shouldThrowDomainException() {
        String message = "Something went wrong";

        DomainException exception = assertThrows(
                DomainException.class,
                () -> {
                    throw new DomainException(message);
                }
        );

        assertEquals(message, exception.getMessage());
    }
}
