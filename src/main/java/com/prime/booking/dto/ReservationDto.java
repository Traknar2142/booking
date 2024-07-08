package com.prime.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDto {

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("reservationDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime reservationDateTime;

    @JsonProperty("lotId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long lotId;

    @JsonProperty("phoneNumber")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long phoneNumber;
}
