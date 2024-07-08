package com.prime.booking.mapper;

import com.prime.booking.dto.ReservationDto;
import com.prime.booking.model.ReservationEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationMapper {
    private final ModelMapper modelMapper;

    public ReservationEntity toEntity(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, ReservationEntity.class);
    }

    public ReservationDto toDto(ReservationEntity reservationEntity) {
        return modelMapper.map(reservationEntity, ReservationDto.class);
    }
}
