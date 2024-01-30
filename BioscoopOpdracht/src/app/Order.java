package app;

import Enums.DayOfWeek;
import Enums.TicketExportFormat;
import Exporter.ExportFactory;
import Exporter.IExportOrder;

import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<MovieTicket> ticketAmount;
    private int totalFreeTickets;


    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        ticketAmount = new ArrayList<>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        ticketAmount.add(ticket);

    }

    public double calculatePrice() {
        calculateBasePrice();
        if (isStudentOrder) {
            applyDiscount();
        } else {
            applyDiscount();
        }
        return calctotalprice();
    }

    private void calculateBasePrice() {
        for (int i = 1; i <= ticketAmount.size(); i++) {
            ticketAmount.get(i-1).setPrice( isStudentOrder, ticketAmount.get(i-1).isPremiumTicket());
        }
    }

    private double calctotalprice() {
        double totalPrice = 0.0;
        for (MovieTicket ticket : ticketAmount) {
            totalPrice += ticket.getPrice();
        }
        if (!isStudentOrder && ticketAmount.size() >= 6) {
            totalPrice = totalPrice * 0.9;
        }
        return totalPrice;
    }

    private void applyDiscount() {
            if (isStudentOrder || (!isStudentOrder && isWeekDay())) {
                for (int i = 1; i <= ticketAmount.size(); i++) {
                    if (i % 2 == 0) {
                        ticketAmount.get(i-1).setPriceForFree();
                        i++;
                    }
                }
            } else if (!isStudentOrder && !isWeekDay()) {
                if (ticketAmount.size() >= 6) {
                    for (int i = 0; i < ticketAmount.size() -1; i++) {
                        ticketAmount.get(i).setPrice( isStudentOrder, ticketAmount.get(i).isPremiumTicket());
                    }
                }
            }
        }

            private boolean isWeekDay() {
                for (MovieTicket ticket : ticketAmount) {
                    if (ticket.getDayOfMovie().equals(DayOfWeek.MONDAY) ||
                            ticket.getDayOfMovie().equals(DayOfWeek.TUESDAY) ||
                            ticket.getDayOfMovie().equals(DayOfWeek.WEDNESDAY) ||
                            ticket.getDayOfMovie().equals(DayOfWeek.THURSDAY) ) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }

    public void export(TicketExportFormat exportFormat) {
        IExportOrder exporter = ExportFactory.getExporter(String.valueOf(exportFormat));
        exporter.exportOrder(this, exportFormat);
    }
}
