package com.github.airlinereservation.repository.passenger;

public interface PassengerRepository {
    Passenger findPassengerByUserId(Integer userId);
}
