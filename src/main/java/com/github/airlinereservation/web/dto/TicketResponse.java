/*
Yedam Lee
This class represents a TicketResponse dto which carries the information of the ticket we want to give to the user.
 */
package com.github.airlinereservation.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TicketResponse {

    //getting the full-detailed information about the ticket in Tickets dto
    private List<Ticket> tickets;
}
