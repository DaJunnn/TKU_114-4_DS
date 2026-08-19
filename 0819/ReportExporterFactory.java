interface ReportExporter {
    void export(String title, int[] values);
}

class CsvExporter implements ReportExporter {
    @Override
    public void export(String title, int[] values) {
        System.out.println("CSV Report: " + title);

        if (values == null) {
            System.out.println("No data");
            return;
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);

            if (i < values.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println();
    }
}

class JsonExporter implements ReportExporter {
    @Override
    public void export(String title, int[] values) {
        System.out.println("JSON Report: " + title);

        if (values == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);

            if (i < values.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}

class TextExporter implements ReportExporter {
    @Override
    public void export(String title, int[] values) {
        System.out.println("Text Report: " + title);

        if (values == null) {
            System.out.println("No data");
            return;
        }

        for (int value : values) {
            System.out.println(value);
        }
    }
}

public class ReportExporterFactory {

    public static ReportExporter createExporter(String format) {
        if (format == null) {
            return new TextExporter();
        }

        switch (format.toLowerCase()) {
            case "csv":
                return new CsvExporter();

            case "json":
                return new JsonExporter();

            case "text":
                return new TextExporter();

            default:
                return new TextExporter();
        }
    }

    public static void exportReport(
            ReportExporter exporter,
            String title,
            int[] values) {

        exporter.export(title, values);
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        ReportExporter exporter1 = createExporter("csv");
        exportReport(exporter1, "Sales Report", values);

        System.out.println();

        ReportExporter exporter2 = createExporter("json");
        exportReport(exporter2, "Score Report", values);

        System.out.println();

        ReportExporter exporter3 = createExporter("pdf");
        exportReport(exporter3, "Unknown Format", values);

        System.out.println();

        ReportExporter exporter4 = createExporter("text");
        exportReport(exporter4, "Null Data Report", null);
    }
}