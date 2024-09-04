/*
Yedam Lee
This class represents a Ticket dto, which carries the information of the ticket.
 */
package com.github.airlinereservation.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.airlinereservation.repository.airlineTicket.AirlineTicket;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;


@Getter
@NoArgsConstructor
//uses JsonNaming since the names of the fields here is CamelCase style, while the names in the database is SnakeCase style
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ticket {

    private String depart;
    private String arrival;
    private String departureTime;
    private String returnTime;
    private Integer ticketId;

    //since airlineTicket's departureAt type and departureTime type is different
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");

    //constructor that maps AirlineTicket to Ticket
    public Ticket(AirlineTicket airlineTicket){
        this.depart = airlineTicket.getDepartureLocation();
        this.arrival = airlineTicket.getArrivalLocation();
        this.departureTime = airlineTicket.getDepartureAt().format(dateTimeFormatter);
        this.returnTime = airlineTicket.getReturnAt().format(dateTimeFormatter);
        this.ticketId = airlineTicket.getTicketId();
    }

}
