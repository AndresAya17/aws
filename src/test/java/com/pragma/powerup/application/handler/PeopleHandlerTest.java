package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.dto.response.PeopleResponseDto;
import com.pragma.powerup.application.handler.impl.PeopleHandler;
import com.pragma.powerup.application.mapper.IPeopleRequestMapper;
import com.pragma.powerup.application.mapper.IPeopleResponseMapper;
import com.pragma.powerup.domain.api.IPeopleServicePort;
import com.pragma.powerup.domain.model.PeopleModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PeopleHandlerTest {

    @Mock
    private IPeopleRequestMapper requestMapper;

    @Mock
    private IPeopleResponseMapper responseMapper;

    @Mock
    private IPeopleServicePort servicePort;

    @InjectMocks
    private PeopleHandler handler;

    private PeopleRequestDto requestDto;
    private PeopleModel model;
    private PeopleResponseDto responseDto;

    @BeforeEach
    void setUp() {
        requestDto = new PeopleRequestDto();
        requestDto.setDocumentNumber("123");
        requestDto.setName("Andres");
        requestDto.setEmail("test@mail.com");

        model = new PeopleModel();
        model.setDocumentNumber("123");
        model.setName("Andres");
        model.setEmail("test@mail.com");

        responseDto = new PeopleResponseDto();
        responseDto.setDocumentNumber("123");
        responseDto.setName("Andres");
        responseDto.setEmail("test@mail.com");
    }

    @Test
    void shouldSavePeopleSuccessfully() {
        // Arrange
        when(requestMapper.toModel(requestDto)).thenReturn(model);

        // Act
        handler.savePeople(requestDto);

        // Assert
        verify(requestMapper).toModel(requestDto);
        verify(servicePort).savePeople(model);
    }

    @Test
    void shouldFindByIdSuccessfully() {
        Long userId = 1L;

        // Arrange
        when(servicePort.findById(userId)).thenReturn(model);
        when(responseMapper.toResponse(model)).thenReturn(responseDto);

        // Act
        PeopleResponseDto result = handler.findById(userId);

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getDocumentNumber());
        assertEquals("Andres", result.getName());
        assertEquals("test@mail.com", result.getEmail());

        verify(servicePort).findById(userId);
        verify(responseMapper).toResponse(model);
    }
}
