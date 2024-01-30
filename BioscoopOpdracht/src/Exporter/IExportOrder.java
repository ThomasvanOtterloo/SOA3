package Exporter;


import Enums.TicketExportFormat;
import app.Order;

public interface IExportOrder {
    void exportOrder(Order order, TicketExportFormat format);


}
