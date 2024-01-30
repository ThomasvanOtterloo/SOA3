package Exporter;
import Enums.TicketExportFormat;
import app.Order;

public class PlainTextExport implements IExportOrder{

    @Override
    public void exportOrder(Order order, TicketExportFormat format) {
        System.out.println("PlainText");
    }
}
