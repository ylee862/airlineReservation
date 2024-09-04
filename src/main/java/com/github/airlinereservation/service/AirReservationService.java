/*
Yedam Lee
This class represents the service layer, which connects the web layer and the repository layer.
Once the web layer calls the methods in the service layer, the logic is performed here,
but if we need to get more information from the database, we send requests to the repository layer.
 */
package com.github.airlinereservation.service;

import com.github.airlinereservation.repository.airlineTicket.AirlineTicket;
import com.github.airlinereservation.repository.airlineTicket.AirlineTicketRepository;
import com.github.airlinereservation.repository.passenger.Passenger;
import com.github.airlinereservation.repository.passenger.PassengerRepository;
import com.github.airlinereservation.repository.reservations.Reservation;
import com.github.airlinereservation.repository.reservations.ReservationRepository;
import com.github.airlinereservation.repository.users.UserRepository;
import com.github.airlinereservation.repository.users.UsersEntity;
import com.github.airlinereservation.repository.airlineTicket.AirlineTicketAndFlightInfo;
import com.github.airlinereservation.web.dto.ReservationRequest;
import com.github.airlinereservation.web.dto.ReservationResult;
import com.github.airlinereservation.web.dto.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//it uses @Service annotation to make this class into a bean
@Service
public class AirReservationService {

    //connecting the service layer to the repository layer
    private UserRepository userRepository;
    private AirlineTicketRepository airlineTicketRepository;
    private PassengerRepository passengerRepository;
    private ReservationRepository reservationRepository;

    public AirReservationService(UserRepository userRepository, AirlineTicketRepository airlineTicketRepository, PassengerRepository passengerRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.airlineTicketRepository = airlineTicketRepository;
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
    }

    //method that finds the tickets (where the user wants to visit and with the ticketType)
    public List<Ticket> findUserFavoritePlaceTicket(Integer userId, String ticketType) {

        //1. bring the user using userId
        UsersEntity usersEntity = userRepository.findUserById(userId);

        //2. then find out the place the user wants to visit
        String likePlace = usersEntity.getLikeTravelPlace();

        //3. using the place user wants to go to + the ticketType, we use AirlineTicket table to get the AirlineTicket
        List<AirlineTicket> airlineTickets = airlineTicketRepository.findAllAirlineTicketsWithPlaceAndTicketType(likePlace, ticketType);

        //4. combining the top 2 then making the Ticket dto
        List<Ticket> tickets = airlineTickets.stream().map(Ticket::new).collect(Collectors.toList());

        return tickets;

    }

    //method that returns the result of the user trying to make a reservation for the ticket
    @Transactional
    public ReservationResult makeReservation(ReservationRequest reservationRequest) {
        //1. reservation repository, Join table (flight/airline_ticket), passenger repository

        //0. getting the userId and airlineTicketId
        Integer userId = reservationRequest.getUserId();
        Integer airlineTicketId = reservationRequest.getAirlineTicketId();

        //1. getting the passenger Id
        Passenger passenger = passengerRepository.findPassengerByUserId(userId);
        Integer passengerId = passenger.getPassengerId();

        //2. getting the information of the ticket, like the price
        List<AirlineTicketAndFlightInfo> airlineTicketAndFlightInfo =
                airlineTicketRepository.findAllAirlineTicketAndPriceInfo(airlineTicketId);

        //3. making the reservation
        Reservation reservation = new Reservation(passengerId, airlineTicketId);
        Boolean isSuccess = reservationRepository.saveReservation(reservation);

        //4. make ReservationResult dto
        List<Integer> prices = airlineTicketAndFlightInfo.stream().map(AirlineTicketAndFlightInfo::getPrice).collect(Collectors.toList());
        List<Integer> charges = airlineTicketAndFlightInfo.stream().map(AirlineTicketAndFlightInfo::getCharge).collect(Collectors.toList());
        Integer tax = airlineTicketAndFlightInfo.stream().map(AirlineTicketAndFlightInfo::getTax).findFirst().get();
        Integer totalPrice = airlineTicketAndFlightInfo.stream().map(AirlineTicketAndFlightInfo::getTotalPrice).findFirst().get();

        return new ReservationResult(prices, charges, tax, totalPrice, isSuccess);
    }
}
