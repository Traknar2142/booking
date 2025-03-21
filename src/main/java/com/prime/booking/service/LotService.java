package com.prime.booking.service;


import com.prime.booking.annotations.CustomSpan;
import com.prime.booking.dto.LotDto;
import com.prime.booking.filter.LotEntityFilter;
import com.prime.booking.mapper.LotMapper;
import com.prime.booking.model.LotEntity;
import com.prime.booking.repository.LotRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LotService {
    private LotRepository lotRepository;
    private LotMapper mapper;

    @Transactional
    @CustomSpan
    public Page<LotDto> findAll(LotEntityFilter lotEntityFilter, Pageable pageable) {
        return lotRepository.findAll(lotEntityFilter, pageable)
                .map(lot -> mapper.toDto(lot));
    }

    @Transactional
    @CustomSpan
    public LotEntity findById(Long id) {
        return lotRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Лот с id = %d не найден", id)));
    }
}
