package com.prime.booking.mapper;

import com.prime.booking.annotations.CustomSpan;
import com.prime.booking.dto.ReservationDto;
import com.prime.booking.model.ReservationEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReservationMapper {

    private final ModelMapper modelMapper;


    @CustomSpan
    public ReservationEntity toEntity(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, ReservationEntity.class);
    }


    @CustomSpan
    public ReservationDto toDto(ReservationEntity reservationEntity) {
        return modelMapper.map(reservationEntity, ReservationDto.class);
    }

}
