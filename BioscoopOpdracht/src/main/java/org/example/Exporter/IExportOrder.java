package org.example.Exporter;


import org.example.Enums.TicketExportFormat;
import org.example.app.Order;

public interface IExportOrder {
    void exportOrder(Order order, TicketExportFormat format);


}
