package com.prime.booking.repository;

import com.prime.booking.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    @Query("SELECT r FROM ReservationEntity r WHERE r.lotEntity.id = :lotId and r.reservationDateTime = :localDateTime")
    ReservationEntity findByLotIdAndDateTime(Long lotId, LocalDateTime localDateTime);
}
