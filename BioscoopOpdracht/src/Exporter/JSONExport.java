package Exporter;
import Enums.TicketExportFormat;
import app.Order;

public class JSONExport implements IExportOrder{

    @Override
    public void exportOrder(Order order, TicketExportFormat format) {
        System.out.println("JSON");
    }
}
