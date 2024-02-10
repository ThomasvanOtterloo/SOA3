package org.example.app;

import org.example.Enums.DayOfWeek;

import java.time.LocalDateTime;
import java.util.Locale;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;
    private Movie movie;

    public MovieScreening(LocalDateTime dateAndTime, double pricePerSeat, Movie movie) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
        this.movie = movie;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public DayOfWeek getDateAndTime() {
        java.time.DayOfWeek NameOfDay = dateAndTime.getDayOfWeek();
        return DayOfWeek.valueOf(NameOfDay.toString().toUpperCase(Locale.ROOT));
    }

    @Override
    public String toString() {
        return "app.MovieScreening{" +
                "dateAndTime=" + dateAndTime +
                ", pricePerSeat=" + pricePerSeat +
                ", movie=" + movie +
                '}';
    }


}
