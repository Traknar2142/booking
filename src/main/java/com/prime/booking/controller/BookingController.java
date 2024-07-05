package com.prime.booking.controller;

import com.prime.booking.dto.LotDto;
import com.prime.booking.filter.LotEntityFilter;
import com.prime.booking.service.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final LotService lotService;

    @GetMapping("/find-all")
    public Page<LotDto> findAll(LotEntityFilter lotEntityFilter, Pageable pageable) {
        return lotService.findAll(lotEntityFilter, pageable);
    }
}
