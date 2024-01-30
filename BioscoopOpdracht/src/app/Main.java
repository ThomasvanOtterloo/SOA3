package app;

import Enums.TicketExportFormat;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Movie movie = new Movie("The Matrix");
        MovieScreening movieScreening = new MovieScreening(LocalDateTime.now(), 10.0, movie);
        MovieTicket ticket = new MovieTicket(3, 18, true, movieScreening);
        MovieTicket ticket2 = new MovieTicket(3, 19, true, movieScreening);


        Order order = new Order(1, false);
        order.addSeatReservation(ticket);
        order.addSeatReservation(ticket2);


        System.out.println(order.calculatePrice());

        order.export(TicketExportFormat.PLAINTEXT);

    }
}