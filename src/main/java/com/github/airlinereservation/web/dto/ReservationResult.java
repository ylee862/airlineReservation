/*
Yedam Lee
This class represents the ReservationResult dto which carries the information of the result of the reservation.
 */
package com.github.airlinereservation.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReservationResult {
    private List<Integer> prices;
    private List<Integer> charges;
    private Integer tax;
    private Integer totalPrice;
    private Boolean success;
}
