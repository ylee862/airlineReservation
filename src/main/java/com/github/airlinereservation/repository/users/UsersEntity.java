/*
Yedam Lee
This class represents an entity that maps to the database's "users" table.
Must have the constructor, getters and setters, hashcode() and equals()
 */
package com.github.airlinereservation.repository.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class UsersEntity {
    private Integer userId;
    private String userName;
    private String likeTravelPlace;
    private String phoneNum;


}
