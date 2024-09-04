/*
Yedam Lee
This class represents the Passenger entity which is connected to the database's table.
It has the details about the passenger (when the user buys the ticket).
 */
package com.github.airlinereservation.repository.passenger;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Passenger {
    private Integer passengerId;
    private Integer userId;
    private String passportNum;

}
