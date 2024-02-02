package app;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    // testcase 3
    @Test
    void TestNotAStudentAndIsWeekDayEverySecondTicketIsFree() {
        // Arrange
        Movie movie = new Movie("The Matrix");
        MovieScreening movieScreening = new MovieScreening(LocalDateTime.now().plusDays(4), 10.0, movie);
        MovieTicket ticket = new MovieTicket(3, 18, false, movieScreening);
        MovieTicket ticket2 = new MovieTicket(3, 19, false, movieScreening);
        MovieTicket ticket3 = new MovieTicket(3, 20, false, movieScreening);
        MovieTicket ticket4 = new MovieTicket(3, 21, false, movieScreening);


        Order order = new Order(1, false);
        order.addSeatReservation(ticket);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);


        double expected = 20.0;
        double actual = 0;
        // Act
        actual = order.calculatePrice();
        // Assert
        assertEquals(expected, actual);
    }

    // testcase 4
    @Test
    void IsWeekDayAndNotStudentOneTicket(){
        // Arrange
        Movie movie = new Movie("The Matrix");
        MovieScreening movieScreening = new MovieScreening(LocalDateTime.now().plusDays(4), 10.0, movie);
        MovieTicket ticket = new MovieTicket(3, 18, false, movieScreening);

        Order order = new Order(1, false);
        order.addSeatReservation(ticket);

        double expected = 10.0;
        double actual = 0;
        // Act
        actual = order.calculatePrice();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestNotAStudentAndIsWeekend() {
        // Arrange
        double expected = 72.0;
        double actual = 0;

        // Act
        Movie movie = new Movie("The Matrix");

        LocalDateTime saturday = LocalDateTime.of(2024, 2, 3, 12, 0);
        MovieScreening movieScreening = new MovieScreening(saturday, 10.0, movie);
        MovieTicket ticket = new MovieTicket(3, 18, false, movieScreening);
        MovieTicket ticket2 = new MovieTicket(3, 19, false, movieScreening);
        MovieTicket ticket3 = new MovieTicket(3, 20, false, movieScreening);
        MovieTicket ticket4 = new MovieTicket(3, 21, false, movieScreening);
        MovieTicket ticket5 = new MovieTicket(3, 22, false, movieScreening);
        MovieTicket ticket6 = new MovieTicket(3, 23, false, movieScreening);
        MovieTicket ticket7 = new MovieTicket(3, 24, false, movieScreening);
        MovieTicket ticket8 = new MovieTicket(3, 25, false, movieScreening);

        Order order = new Order(1, false);
        order.addSeatReservation(ticket);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        order.addSeatReservation(ticket5);
        order.addSeatReservation(ticket6);
        order.addSeatReservation(ticket7);
        order.addSeatReservation(ticket8);

        actual = order.calculatePrice();
        // Assert
        assertEquals(expected, actual);
    }





}