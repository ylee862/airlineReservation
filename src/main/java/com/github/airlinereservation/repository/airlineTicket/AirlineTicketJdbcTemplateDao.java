/*
Yedam Lee
This class represents the repository layer of AirlineTicket.
It receives some requests from the service layer and communicates with the database to get some information about the airline ticket.
 */
package com.github.airlinereservation.repository.airlineTicket;

import lombok.Builder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirlineTicketJdbcTemplateDao implements AirlineTicketRepository{

    //uses jdbcTemplate to connect to the database
    private JdbcTemplate jdbcTemplate;

    public AirlineTicketJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //creating a RowMapper that maps each field in the database to the entity's field.
    static RowMapper<AirlineTicket> airlineTicketRowMapper = (((rs, rowNum) ->
            new AirlineTicket(
                    rs.getInt("ticket_id"),
                    rs.getString("ticket_type"),
                    rs.getNString("departure_loc"),
                    rs.getNString("arrival_loc"),
                    rs.getDate("departure_at"),
                    rs.getDate("return_at"),
                    rs.getDouble("tax"),
                    rs.getDouble("total_price")
            )));

    //making another RowMapper for the inner joined tables
    static RowMapper<AirlineTicketAndFlightInfo> airlineTicketAndFlightInfoRowMapper = (((rs, rowNum) ->

            //A stands for airline_ticket table
            //F stands for flight table
            new AirlineTicketAndFlightInfo(
                    rs.getInt("A.ticket_id"),
                    rs.getDouble("F.flight_price"),
                    rs.getDouble("F.charge"),
                    rs.getDouble("A.tax"),
                    rs.getDouble("A.total_price")
            )));

    //method that finds the tickets with certain "likePlace" and "ticketType" from the database
    @Override
    public List<AirlineTicket> findAllAirlineTicketsWithPlaceAndTicketType(String likePlace, String ticketType) {

        //since we are searching for more than one object, we just use "query()"
        return jdbcTemplate.query("SELECT * FROM airline_ticket " +
                                    "WHERE arrival_loc = ? AND ticket_type = ? ", airlineTicketRowMapper, likePlace, ticketType);
    }

    //method that finds the list of ticket information based on the airlineTicketId
    @Override
    public List<AirlineTicketAndFlightInfo> findAllAirlineTicketAndPriceInfo(Integer airlineTicketId) {

        //using INNER JOIN to join two tables
        return jdbcTemplate.query("SELECT A.ticket_id, A.tax, A.total_price, F.flight_price, F.charge " +
                                    "   FROM airline_ticket A " +
                                    "       INNER JOIN flight F " +
                                    "       ON A.ticket_id = F.ticket_id " +
                                    "   WHERE A.ticket_id = ? ", airlineTicketAndFlightInfoRowMapper, airlineTicketId);
    }
}
