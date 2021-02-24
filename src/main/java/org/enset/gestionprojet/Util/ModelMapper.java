package org.enset.gestionprojet.Util;

import org.springframework.context.annotation.Bean;

public class ModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
