package com.prime.booking.service;

import com.prime.booking.annotations.CustomSpan;
import com.prime.booking.dto.ReservationDto;
import com.prime.booking.exceptions.ReservationAlreadyExistsException;
import com.prime.booking.mapper.ReservationMapper;
import com.prime.booking.model.LotEntity;
import com.prime.booking.model.ReservationEntity;
import com.prime.booking.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private LotService lotService;
    private ReservationMapper reservationMapper;

    @Transactional
    @CustomSpan
    public ReservationDto makeReservationProcess(ReservationDto reservationDto) {
        LotEntity lot = lotService.findById(reservationDto.getLotId());
        checkReservation(reservationDto);
        ReservationEntity reservation = reservationMapper.toEntity(reservationDto);
        reservation.setLotEntity(lot);
        ReservationEntity save = reservationRepository.save(reservation);
        return reservationMapper.toDto(save);

    }

    private void checkReservation(ReservationDto reservationDto) {
        ReservationEntity byLotIdAndDateTime = reservationRepository
                .findByLotIdAndDateTime(reservationDto.getLotId(),
                        reservationDto.getReservationDateTime());
        if (byLotIdAndDateTime != null) {
            throw new ReservationAlreadyExistsException(String.format("Для лота с id %d существует бронь с id %d",
                    reservationDto.getLotId(),
                    byLotIdAndDateTime.getId()));
        }
    }

}
