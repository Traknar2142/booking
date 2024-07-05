package com.prime.booking.mapper;

import com.prime.booking.dto.LotDto;
import com.prime.booking.model.LotEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LotMapper {
    private final ModelMapper modelMapper;

    public LotDto toDto(LotEntity lotEntity) {
        return modelMapper.map(lotEntity, LotDto.class);
    }
}
