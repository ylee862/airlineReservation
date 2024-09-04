/*
Yedam Lee
This class represents the AirlineTicketAndFlightInfo entity which connects to the database's table which has
the information for the ticket.
We get the information by Joining the tables in the database.
We are joining the airline_ticket table and flight table to get the informations we want.
 */
package com.github.airlinereservation.repository.airlineTicket;

public class AirlineTicketAndFlightInfo {
    private Integer ticketId;
    private Integer price;
    private Integer charge;
    private Integer tax;
    private Integer totalPrice;

    public AirlineTicketAndFlightInfo(Integer ticketId, Double price, Double charge, Double tax, Double totalPrice) {
        this.ticketId = ticketId;
        this.price = price.intValue();
        this.charge = charge.intValue();
        this.tax = tax.intValue();
        this.totalPrice = totalPrice.intValue();
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
