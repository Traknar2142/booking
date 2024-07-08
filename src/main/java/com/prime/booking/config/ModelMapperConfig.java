package com.prime.booking.config;

import com.prime.booking.dto.ReservationDto;
import com.prime.booking.model.ReservationEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        TypeMap<ReservationEntity, ReservationDto> typeMap = mapper
                .createTypeMap(ReservationEntity.class,
                        ReservationDto.class);
        typeMap.addMapping(s -> s.getLotEntity().getId(), ReservationDto::setLotId);
        return mapper;
    }
}
