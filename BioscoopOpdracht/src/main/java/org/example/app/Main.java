package org.example.app;

import org.example.Enums.TicketExportFormat;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Movie movie = new Movie("The Matrix");
        MovieScreening movieScreening = new MovieScreening(LocalDateTime.now().plusDays(1), 10.0, movie);
        MovieTicket ticket = new MovieTicket(3, 18, true, movieScreening);
        MovieTicket ticket2 = new MovieTicket(3, 19, true, movieScreening);
        MovieTicket ticket3 = new MovieTicket(3, 20, true, movieScreening);
        MovieTicket ticket4 = new MovieTicket(3, 21, true, movieScreening);
        MovieTicket ticket5 = new MovieTicket(3, 22, true, movieScreening);
        MovieTicket ticket6 = new MovieTicket(3, 23, true, movieScreening);


        Order order = new Order(1, true);
        order.addSeatReservation(ticket);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        order.addSeatReservation(ticket5);
        order.addSeatReservation(ticket6);

        System.out.println(order.calculatePrice());

        order.export(TicketExportFormat.PLAINTEXT);
    }
}