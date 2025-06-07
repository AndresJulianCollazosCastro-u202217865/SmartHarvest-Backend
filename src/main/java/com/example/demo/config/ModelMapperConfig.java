package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Usa estrategia estricta: los campos deben coincidir exactamente
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                // Ignora ambigüedades en el mapeo
                .setAmbiguityIgnored(true);

        return modelMapper;
    }
}