/*
Yedam Lee
This class is connected to the database.
It is consisted of the methods needed to connect and get the information about the passenger from the database.
 */
package com.github.airlinereservation.repository.passenger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerJdbcTemplateDao implements PassengerRepository{

    //connecting to the database
    private JdbcTemplate jdbcTemplate;

    public PassengerJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static RowMapper<Passenger> passengerRowMapper = (((rs, rowNum) ->
            new Passenger(
                    rs.getInt("passenger_id"),
                    rs.getInt("user_id"),
                    rs.getNString("passport_num")
            )));

    //method that returns the object found in the database which passenger has the userId as the id.
    @Override
    public Passenger findPassengerByUserId(Integer userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM passenger WHERE user_id = ? ", passengerRowMapper, userId);
    }
}
