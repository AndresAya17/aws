package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IPeopleServicePort;
import com.pragma.powerup.domain.spi.IPeoplePersistencePort;
import com.pragma.powerup.domain.usecase.PeopleUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.PeopleJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPeopleEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IPeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPeopleRepository peopleRepository;
    private final IPeopleEntityMapper peopleEntityMapper;

    @Bean
    public IPeoplePersistencePort peoplePersistencePort(){
        return new PeopleJpaAdapter(peopleRepository,peopleEntityMapper);
    }

    @Bean
    public IPeopleServicePort peopleServicePort(){
        return new PeopleUseCase(peoplePersistencePort());
    }
}