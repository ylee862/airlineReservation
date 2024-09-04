/*
Yedam Lee
This program allows the users to search for the airplane tickets and buy it.
It the user buys it, it returns the information about the airplane ticket.
It is designed in 3-tier design pattern.
 */
package com.github.airlinereservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationApplication.class, args);
    }

}
