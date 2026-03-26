package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.PeopleModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.PeopleEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPeopleEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IPeopleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PeopleJpaAdapterTest {

    private IPeopleRepository repository;
    private IPeopleEntityMapper mapper;
    private PeopleJpaAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(IPeopleRepository.class);
        mapper = mock(IPeopleEntityMapper.class);
        adapter = new PeopleJpaAdapter(repository, mapper);
    }

    private PeopleModel buildModel() {
        return new PeopleModel("123", "Andres", "test@mail.com");
    }

    private PeopleEntity buildEntity() {
        PeopleEntity entity = new PeopleEntity();
        entity.setDocumentNumber("123");
        entity.setName("Andres");
        entity.setEmail("test@mail.com");
        return entity;
    }

    // -------- savePeople --------

    @Test
    void shouldSavePeopleSuccessfully() {
        PeopleModel model = buildModel();
        PeopleEntity entity = buildEntity();

        when(mapper.toEntity(model)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toModel(entity)).thenReturn(model);

        PeopleModel result = adapter.savePeople(model);

        assertNotNull(result);
        assertEquals(model.getDocumentNumber(), result.getDocumentNumber());
        assertEquals(model.getName(), result.getName());
        assertEquals(model.getEmail(), result.getEmail());

        verify(mapper).toEntity(model);
        verify(repository).save(entity);
        verify(mapper).toModel(entity);
    }

    // -------- findById --------

    @Test
    void shouldReturnPeopleWhenFound() {
        Long id = 1L;
        PeopleEntity entity = buildEntity();
        PeopleModel model = buildModel();

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toModel(entity)).thenReturn(model);

        Optional<PeopleModel> result = adapter.findById(id);

        assertTrue(result.isPresent());
        assertEquals(model.getDocumentNumber(), result.get().getDocumentNumber());

        verify(repository).findById(id);
        verify(mapper).toModel(entity);
    }

    @Test
    void shouldReturnEmptyWhenPeopleNotFound() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        Optional<PeopleModel> result = adapter.findById(id);

        assertTrue(result.isEmpty());

        verify(repository).findById(id);
        verifyNoInteractions(mapper);
    }
}
