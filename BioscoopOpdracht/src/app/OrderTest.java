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





}