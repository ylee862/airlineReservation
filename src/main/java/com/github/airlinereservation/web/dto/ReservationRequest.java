/*
Yedam Lee
This class represents the ReservationRequest dto that carries the information of the request for reserving the ticket.
We receive this as a parameter in the service layer and upload it to the database.
 */
package com.github.airlinereservation.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReservationRequest {
    private Integer userId;
    private Integer airlineTicketId;
}
