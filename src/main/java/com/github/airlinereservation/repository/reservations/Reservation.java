/*
Yedam Lee
This class represents the Reservation Entity that is connected to the database.
It has the information about the reservation.
 */
package com.github.airlinereservation.repository.reservations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Reservation {
    private Integer reservationId;
    private Integer passengerId;
    private Integer airlineTicketId;
    private String reservationStatus;
    private LocalDateTime reserveAt;

    //when the reservation is made
    public Reservation(Integer passengerId, Integer airlineTicketId) {
        this.passengerId = passengerId;
        this.airlineTicketId = airlineTicketId;
        this.reservationStatus = "pending";
        this.reserveAt = LocalDateTime.now();
    }
}
