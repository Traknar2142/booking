package com.prime.booking.exceptions;

public class ReservationAlreadyExistsException extends RuntimeException{
    public ReservationAlreadyExistsException(String message) {
        super(message);
    }
}
