package org.example.Exporter;

public class ExportFactory {

    public static IExportOrder getExporter(String format) {
        if (format.equals("JSON")) {
            return new JSONExport();
        } else if (format.equals("PLAINTEXT")) {
            return new PlainTextExport();
        } else {
            return null;
        }
    }
}
