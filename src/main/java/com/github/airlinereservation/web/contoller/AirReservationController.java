/*
Yedam Lee
This class connects our program to the web, where we represent the REST API.
Once we get the requests from the users, we communicate with the service layer to do the logic.
 */
package com.github.airlinereservation.web.contoller;

import com.github.airlinereservation.AirlineReservationApplication;
import com.github.airlinereservation.service.AirReservationService;
import com.github.airlinereservation.web.dto.ReservationRequest;
import com.github.airlinereservation.web.dto.ReservationResult;
import com.github.airlinereservation.web.dto.Ticket;
import com.github.airlinereservation.web.dto.TicketResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Using CSS, so we use @RequestMapping to get the path we want to use.
@RestController
@RequestMapping("/v1/api/air-reservation")
public class AirReservationController {

    //connecting with the service layer
    private AirReservationService airReservationService;

    public AirReservationController(AirReservationService airReservationService) {
        this.airReservationService = airReservationService;
    }

    //When the user wants to find some tickets of specific type, we get the information from the database
    @GetMapping("/tickets")
    public TicketResponse findAirlineTickets(@RequestParam("user-Id") Integer userId,
                                             @RequestParam("airline-ticket-type") String ticketType){

        //we ask the service layer to give us the list of tickets with certain ticket type
        List<Ticket> tickets = airReservationService.findUserFavoritePlaceTicket(userId, ticketType);

        return new TicketResponse(tickets);

    }

    //When the user tries to reserve the ticket after getting the ticket's information.
    @PostMapping("/reservations")
    public ReservationResult makeReservation(@RequestBody ReservationRequest reservationRequest){

        //returning the ReservationResult after the user tries to make the reservation.
        return airReservationService.makeReservation(reservationRequest);
    }
}
