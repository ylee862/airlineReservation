/*
Yedam Lee
This class is connected to the database, performing the methods needed to gain information from the database.
It collects the information of the Reservation.
 */
package com.github.airlinereservation.repository.reservations;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

@Repository
public class ReservationJdbcTemplateDao implements ReservationRepository{

    //connecting to the database
    private JdbcTemplate jdbcTemplate;

    public ReservationJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //method that returns a boolean whether it has succeeded or not
    //if we have successfully updated the reservation onto the database, rowNums is going to be > 0.
    @Override
    public Boolean saveReservation(Reservation reservation) {
        Integer rowNums = jdbcTemplate.update("INSERT INTO reservation(passenger_id, airline_ticket_id, reservation_status, reserve_at) VALUE(?, ?, ?, ? ) ",
                                                reservation.getPassengerId(), reservation.getAirlineTicketId(),
                                                reservation.getReservationStatus(),
                                                new Date(Timestamp.valueOf(reservation.getReserveAt()).getTime()));
        return rowNums > 0;
    }
}
