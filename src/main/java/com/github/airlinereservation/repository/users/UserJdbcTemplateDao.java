/*
Yedam Lee
This class represents repository layer, which receives the requests
from the service layer and gets the information from the database.
It consists of the methods from the UserRepository and RowMapper.
 */
package com.github.airlinereservation.repository.users;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcTemplateDao implements UserRepository{

    //uses jdbcTemplate to connect to the database
    private JdbcTemplate jdbcTemplate;

    public UserJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //rowMapper maps the fields in the table of the database to the UserEntity's fields.
    static RowMapper<UsersEntity> usersEntityRowMapper = (((rs, rowNum) ->
            new UsersEntity(
                    rs.getInt("user_id"),
                    rs.getNString("user_name"),
                    rs.getNString("like_travel_place"),
                    rs.getNString("phone_num")
            )));

    //method that finds the user with "userId"
    @Override
    public UsersEntity findUserById(Integer userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id = ? ", usersEntityRowMapper, userId);
    }
}
