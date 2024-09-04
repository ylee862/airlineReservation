package com.github.airlinereservation.repository.users;

public interface UserRepository {
    UsersEntity findUserById(Integer userId);
}
