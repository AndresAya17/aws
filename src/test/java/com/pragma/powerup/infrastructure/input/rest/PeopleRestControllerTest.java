package com.pragma.powerup.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.application.dto.request.PeopleRequestDto;
import com.pragma.powerup.application.dto.response.PeopleResponseDto;
import com.pragma.powerup.application.handler.IPeopleHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeopleRestController.class)
class PeopleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPeopleHandler peopleHandler;

    @Autowired
    private ObjectMapper objectMapper;

    // -------- POST --------

    @Test
    void shouldSavePeopleSuccessfully() throws Exception {
        PeopleRequestDto request = new PeopleRequestDto();
        request.setDocumentNumber("123456");
        request.setName("Andres");
        request.setEmail("test@mail.com");

        mockMvc.perform(post("/api/v1/people/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        verify(peopleHandler).savePeople(any(PeopleRequestDto.class));
    }

    // -------- GET --------

    @Test
    void shouldReturnPeopleById() throws Exception {
        Long id = 1L;

        PeopleResponseDto response = new PeopleResponseDto();
        response.setDocumentNumber("123456");
        response.setName("Andres");
        response.setEmail("test@mail.com");

        when(peopleHandler.findById(id)).thenReturn(response);

        mockMvc.perform(get("/api/v1/people/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.documentNumber").value("123456"))
                .andExpect(jsonPath("$.name").value("Andres"))
                .andExpect(jsonPath("$.email").value("test@mail.com"));

        verify(peopleHandler).findById(id);
    }
}
