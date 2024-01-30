package app;

import Enums.DayOfWeek;

public class MovieTicket {
    private int rowNr;
    private int searNr;
    private boolean isPremium;

    private MovieScreening movieScreening;
    private double ticketPrice;

    public MovieTicket(int rowNr, int searNr, boolean isPremium, MovieScreening movieScreening) {
        this.rowNr = rowNr;
        this.searNr = searNr;
        this.isPremium = isPremium;
        this.movieScreening = movieScreening;
    }
    public boolean isPremiumTicket() {
        return isPremium;
    }

    public double getPrice() {
        return ticketPrice;
    }


    public void setPrice( boolean isStudent, boolean isPremium) {
        setBasePrice();
        if (isPremium && isStudent) {
            this.ticketPrice = ticketPrice + 2.0;
        } else if(isPremium && !isStudent) {
            this.ticketPrice = ticketPrice + 3.0;
        }
    }

    private void setBasePrice() {
        ticketPrice = movieScreening.getPricePerSeat();
    }

    public void setPriceForFree() {
        this.ticketPrice = 0.0;
    }

    public DayOfWeek getDayOfMovie() {
        return movieScreening.getDateAndTime();
    }

    public String toString() {
        return "Ticket: row " + rowNr + ", seat " + searNr + ", premium: " + isPremium;
    }

}
