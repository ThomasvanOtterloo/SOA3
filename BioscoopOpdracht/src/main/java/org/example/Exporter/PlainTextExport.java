package org.example.Exporter;
import org.example.Enums.DayOfWeek;
import org.example.Enums.TicketExportFormat;
import org.example.app.Order;

public class PlainTextExport implements IExportOrder{

    @Override
    public void exportOrder(Order order, TicketExportFormat format) {
        System.out.println("PlainText");
    }
}
