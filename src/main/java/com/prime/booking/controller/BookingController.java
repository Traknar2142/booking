package com.prime.booking.controller;

import com.prime.booking.dto.LotDto;
import com.prime.booking.dto.ReservationDto;
import com.prime.booking.filter.LotEntityFilter;
import com.prime.booking.service.LotService;
import com.prime.booking.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final LotService lotService;
    private final ReservationService reservationService;

    @GetMapping("/find-all")
    public Page<LotDto> findAll(LotEntityFilter lotEntityFilter, Pageable pageable) {
        return lotService.findAll(lotEntityFilter, pageable);
    }

    @PostMapping("/make-reservation")
    public ReservationDto makeReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.makeReservationProcess(reservationDto);
    }
}
