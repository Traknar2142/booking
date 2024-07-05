package com.prime.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LotDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address")
    private String address;

    @JsonProperty("sq")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer sq;

    @JsonProperty("floor")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer floor;

    @JsonProperty("countOfRooms")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer countOfRooms;
}
